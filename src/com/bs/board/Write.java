package com.bs.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Write extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Board/Write.jsp");
		dispatcher.forward(req, resp);
		
		
		
	}
			
}
