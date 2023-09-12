package com.poscodx.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

public class PagingAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("PagingAction start");
		int currentPage = Integer.parseInt(request.getParameter("page"));

		System.out.println(currentPage);

		WebUtil.redirect(request.getContextPath() + "/board?a=board", request, response);
	}

}
