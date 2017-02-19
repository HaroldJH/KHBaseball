package com.bs.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.board.BoardDAO;
import com.bs.board.BoardDTO;

public class EditOk extends HttpServlet{

 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	  req.setCharacterEncoding("UTF-8");
		
	  	String noticeId=req.getParameter("noticeId");
		String memberId=req.getParameter("memberId");
		/*String subject=req.getParameter("subject");*/
		String title=req.getParameter("title");
		String content=req.getParameter("content");

		
		
		
		
		//2.
		BoardDTO dto = new BoardDTO();
		dto.setNoticeId(noticeId);
		dto.setMemberId(memberId);

		dto.setTitle(title);
		dto.setContent(content);
		
	
		BoardDAO dao = new BoardDAO();
		

	/*	req.setAttribute("result", result); 
		req.setAttribute("noticeId", noticeId); */	
		
 RequestDispatcher dispatcher = req.getRequestDispatcher("/Board/EditOk.jsp");
 dispatcher.forward(req, resp);
}
	
}
