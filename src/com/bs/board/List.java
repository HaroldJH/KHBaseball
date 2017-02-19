package com.bs.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class List extends HttpServlet   {
  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> list = dao.list();
		req.setAttribute("list", list);
		
		System.out.print(list.size());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Board/List.jsp");
		dispatcher.forward(req, resp);
	}
	
}