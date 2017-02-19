package com.bs.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class View extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		
		String noticeId=req.getParameter("noticeId");
		
		/*String col = req.getParameter("col");
		String word = req.getParameter("word");
		
		if (col != null && word !=null){
			req.setAttribute("col", col);
			req.setAttribute("word", word);
		}*/
		
		BoardDAO dao = new BoardDAO();
		 
		
		HttpSession session = req.getSession();
	       String cread = ""; 
	    		   
	    /*   if (session.getAttribute("cread") != null)
	      cread = session.getAttribute("cread").toString();
	       
	       if(cread.equals("n")|| cread=="") {
	       dao.addCount(seq);
	       session.setAttribute("cread", "y");
	       }*/
	       
	       BoardDTO dto= dao.view(noticeId);
	       
	       String content = dto.getContent();
	       
	     /*  content = content.replace("\r\n","<br />");
			dto.setContent(content);
	       
			 dto.setSubject(dto.getSubject().replace("<", "&lt").replace(">","&gt;"));
		     dto.setMemberId(dto.getMemberId().replace("<", "&lt").replace(">","&gt;"));
		       */
		
		req.setAttribute("dto", dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Board/View.jsp");
		dispatcher.forward(req, resp);
		
		
		
		
		
		
		
		
		
	}
	
}
