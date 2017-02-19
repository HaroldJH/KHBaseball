package com.bs.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteOk extends HttpServlet{

		//1.한글처리
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String memberid=req.getParameter("memberid");
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		
		
		BoardDTO dto = new BoardDTO();
		dto.setMemberId(memberid);
		dto.setTitle(title);
		dto.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		
		dao.add(dto);	
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Board/WriteOk.jsp");
		dispatcher.forward(req, resp);
		
			
				
		
	}
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

