package com.bs.rank;

import java.io.IOException;


import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class YearData extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		
		String idx = req.getParameter("idx");
			
		ArrayList<RankDTO> yearList = new ArrayList<>();
		ArrayList<RankDTO> yearList2 = new ArrayList<>();
		
		
		RankDAO dao = new RankDAO();
		yearList = dao.yearList(idx);
		
		req.setAttribute("yearList", yearList);
		
		
		yearList2 = dao.list(idx);
		req.setAttribute("yearList2", yearList2);
		
		
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/Rank/YearData.jsp");

		dispatcher.forward(req, resp);
		
		
		
		
		
		
		
		
			
			

	
}
}
