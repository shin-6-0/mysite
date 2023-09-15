package com.poscodx.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.mysite.vo.BoardVo;
import com.poscodx.mysite.vo.UserVo;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

public class ReplyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("ReplyFormAction start");
		Long no = Long.valueOf(request.getParameter("no"));
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo) session.getAttribute("authUser"); //session에서 로그인자 정보 가져오기
		if(authUser == null) {
			response.sendRedirect(request.getContextPath()+"/board");
			return;
		}
		BoardVo vo = new BoardDao().findByNo(no);
		
		request.setAttribute("vo", vo);
		
		WebUtil.forward("board/reply", request, response);
	}

}
