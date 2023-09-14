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

public class ReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(">>>>>>>>>>>>>>ReplyAction 시작");
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo) session.getAttribute("authUser");

		int gNo = Integer.parseInt(request.getParameter("gNo"));
		int oNo = Integer.parseInt(request.getParameter("oNo"));
		int depth = Integer.parseInt(request.getParameter("depth"));

//		Long parentNo = Long.parseLong(request.getParameter("no"));
		System.out.println("orderNo: " + oNo+", gNo: "+gNo+", dept: "+depth);
		// Boolean result= new BoardRepository().replyUpdate(gNo, (orderNo+1));

		String title = request.getParameter("title");
		String content = request.getParameter("contents");

		BoardVo vo = new BoardVo();
		int countSameDepth=BoardDao.findHasSameDepth(gNo,depth);
		int countPlus1Depth=BoardDao.findHasPlus1Depth(gNo,depth);
		System.out.println("같은 깊이의 depth의 갯수 : "+countSameDepth);
		if(countSameDepth!=0||(countPlus1Depth!=0&&countSameDepth==0)) {
			new BoardDao().setOrder(gNo,oNo,depth);
			vo.setoNo(oNo+1);
		}else {
			vo.setoNo(oNo + 1);
		}
		System.out.println("orderNo: " + oNo);
		vo.setTitle(title);
		vo.setContents(content);
		vo.setHit(0);
		vo.setgNo(gNo);
		vo.setDepth(depth + 1);
		vo.setUserNo(authUser.getNo());

		System.out.println("vo값 이후 값 출력 : " + vo);
		new BoardDao().insert(vo);

		WebUtil.redirect(request.getContextPath() + "/board?a=board", request, response);
	}

}
