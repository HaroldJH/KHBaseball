package com.bs.record;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Rbi extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		 req.setCharacterEncoding("utf-8");
		 ArrayList<RbiDTO> rbi = new ArrayList<>();
		 
		 RbiDAO dao = new RbiDAO();
		 rbi = dao.rbis();		 
		 
		 req.setAttribute("rbi", rbi);
		 
		 
		 
		 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/record/Rbi.jsp");
		dispatcher.forward(req, resp);
		
	}

}
