package com.poscodx.mysite.web.mvc.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poscodx.mysite.dao.UserDao;
import com.poscodx.mysite.vo.UserVo;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

public class UpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// Access Control(접근제어)
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			System.out.println("User가 없습니다!");
			response.sendRedirect(request.getContextPath()+"/user?a=loginform");
			return;
		}
		///////////////////////////////////////////////////////
		
		System.out.println("User가 확인되었습니다!");
		Long memNo = authUser.getNo();
		UserVo getMem = new UserDao().findByNo(memNo);
		System.out.println(getMem.getEmail()+", "+getMem.getGender()+", "+getMem.getPassword());
		request.setAttribute("getMem", getMem);
		
		WebUtil.forward("user/updateform", request, response);
		
	}

}