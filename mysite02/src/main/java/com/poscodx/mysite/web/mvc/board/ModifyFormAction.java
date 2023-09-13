package com.poscodx.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

public class ModifyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Long no = Long.parseLong(request.getParameter("no"));
			HttpSession session = request.getSession();
			System.out.println("no ? "+session.getAttribute("authUser"));
			if(no != session.getAttribute("authUser") ) {
			response.setContentType("text/html;charset=UTF-8");
			response.sendRedirect(request.getContextPath()+"/board"); //수정할 권한이 없을 경우 리스트로 이동
			return;
	}

	request.setAttribute("no", no);
	WebUtil.forward("board?a=modify", request, response);

	}

}
