package com.bs.record;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Battingaverage extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		
		ArrayList<BattingaverageDTO> battingaverage = new ArrayList<>();
		
		
		BattingaverageDAO dao = new BattingaverageDAO();
		
		battingaverage=dao.battingAverage();
		
		
		
		
		 
		req.setAttribute("battingaverage", battingaverage);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/record/Battingaverage.jsp");
		dispatcher.forward(req, resp);
		
	}

}
