package com.poscodx.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poscodx.mysite.dao.BoardDao;
import com.poscodx.mysite.vo.BoardVo;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

public class ViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Long no = Long.parseLong(request.getParameter("no"));

		BoardVo boardvo = new BoardDao().findByNo(no); // title , 내용 받아옴

		new BoardDao().updateHit(no);


		request.setAttribute("title", boardvo.getTitle()); 		// System.out.println("no:" + no);
		request.setAttribute("contents", boardvo.getContents());
		request.setAttribute("no", no);
		request.setAttribute("userNo", boardvo.getUserNo());

		WebUtil.forward("board/view", request, response);
	}

}
