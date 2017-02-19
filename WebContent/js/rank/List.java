package com.bs.rank;

import java.io.IOException;


import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class List extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			
		ArrayList<RankDTO> rankList = new ArrayList<>();
		
		
		RankDAO dao = new RankDAO();
		rankList = dao.rankList();
		
		req.setAttribute("rankList", rankList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Rank/List.jsp");

		dispatcher.forward(req, resp);
		
		
		
			
			

	
}
}
