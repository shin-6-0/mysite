package com.poscodx.mysite.web.mvc.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poscodx.mysite.dao.UserDao;
import com.poscodx.mysite.vo.UserVo;
import com.poscodx.web.utils.WebUtil;

public class UpdateAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UpdateAction 들어옴");

		// 접근 제어 (인증이 필요한 접근에 대한 체크)
		HttpSession session = request.getSession();
		if (session == null) {
			WebUtil.redirect(request.getContextPath(), request, response);
			return;
		}
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (authUser == null) {
			WebUtil.redirect(request.getContextPath(), request, response);
			return;
		}

		Long userNo = authUser.getNo();
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");

		new UserDao().updateUserNamePassword(name, password, gender, userNo);
		if (session != null) {
			session.removeAttribute("authUser");
		}
		authUser.setNo(userNo);
		authUser.setName(name);
		session.setAttribute("authUser", authUser);

		WebUtil.forward("user/updatesuccess", request, response);

	}
}
