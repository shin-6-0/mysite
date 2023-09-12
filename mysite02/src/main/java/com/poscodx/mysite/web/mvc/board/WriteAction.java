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

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			HttpSession session = request.getSession();
			UserVo authUser = (UserVo) session.getAttribute("authUser"); //session에서 아이디 정보 가져오기
			if(authUser == null) {
				response.sendRedirect(request.getContextPath()+"/board");
				return;
			}
			Integer maxGroupNo = new BoardDao().findMaxGroupNo(); // 그룹넘버 가져와야함
			BoardVo boardVo = new BoardVo();
			boardVo.setTitle(request.getParameter("title"));
			boardVo.setContents(request.getParameter("contents"));
			boardVo.setHit(0);
			boardVo.setDepth(1); // 간격
			boardVo.setGNo(maxGroupNo + 1); // 그룹넘버에 1플러스 해서 새로운 그룹 만들기
			boardVo.setONo(1); // 그룹내 글 순서
			boardVo.setUserNo(authUser.getNo()); // session에 있는 authUser를 가져와서쓰자.

			new BoardDao().insert(boardVo); // 게시글 등록

			System.out.println(authUser.getName());
			System.out.println(authUser.getNo());
		WebUtil.redirect(request.getContextPath() + "/board?a=board", request, response); // board ㄱㄱ
	}
}


