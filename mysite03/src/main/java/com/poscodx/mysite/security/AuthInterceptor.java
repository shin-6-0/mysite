package com.poscodx.mysite.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.poscodx.mysite.vo.UserVo;

public class AuthInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//1. handler 종류 확인
		if(!(handler instanceof HandlerMethod)) {
			// DefaultServletHanlder가 처리하는 경우(정적 자원, /assets/**)
			return true;
		}
		
		//2. casting
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		
		//3-1. Handler Method의 @Auth 가져오기
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		//3-2. Handler Method의 @Auth 가 없는 경우, TYPE(Class)의 @Auth가져오기
		if(auth==null) {
			auth= handlerMethod.getMethod().getDeclaringClass().getAnnotation(Auth.class);
		}
		
		//4. @Auth 가 없는 경우
		if(auth == null) {
			return true;
		}
		System.out.println("AuthInterceptor >> auth : "+auth);

		//5. @Auth 가 붙어 있는 경우, 인증(Authenfication) 여부 확인
		HttpSession session = request.getSession();
		if(session==null) { //세션 자체가 존재하지 않을 경우 로그인으로 이동시킴.
			response.sendRedirect(request.getContextPath()+"/user/login");
		}
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) { //로그인 상대가 없을 경우 로그인으로 이동시킴
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}

		//6. 권한(Authorization) 체크를 위해 @Auth의 Role로 가져오기("USER","ADMIN")
		String role = auth.Role();
		String authUserRole = authUser.getRole();
		System.out.println(">> role : "+role +", authUserRole : "+authUserRole);
		//role과 authUserRole 비교
		if(!role.equals(authUserRole)) {
			response.sendRedirect(request.getContextPath());
			return false;
		}
		
		//7. 인증 확인!!!
		return true;
	}

}