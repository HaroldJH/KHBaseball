package com.bs.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveListDel extends HttpServlet{
	//방출선수 삭제
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//데이터 가져오기
		String playerId = req.getParameter("playerId");
		String sel= req.getParameter("sel");
				
		
		//방출하기
		RemoveListDAO dao = new RemoveListDAO();
		int result = dao.remove(playerId);	
		
		System.out.println(result);
		
		req.setAttribute("result", result);
		req.setAttribute("sel", sel);
		
		//뷰페이지호출(RemoveListDel.jsp)
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Admin/RemoveListDel.jsp");
		dispatcher.forward(req, resp);
	}
	
	
}
