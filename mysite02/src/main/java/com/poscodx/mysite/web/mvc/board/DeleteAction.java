package com.poscodx.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("DeleteAction start");
		Long no = Long.parseLong(request.getParameter("no"));
		new BoardDao().Delete(no);
		WebUtil.redirect(request.getContextPath() + "/board?a=board", request, response);
	}

}
