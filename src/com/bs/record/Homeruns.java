package com.bs.record;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Homeruns extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		ArrayList<HomerunsDTO> homeruns = new ArrayList<HomerunsDTO>();
		
		
		HomerunsDAO dao = new HomerunsDAO();
		homeruns = dao.homeruns();
		
		
		req.setAttribute("homeruns", homeruns);  
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/record/homeruns.jsp");
		dispatcher.forward(req, resp);
		
	}

}
