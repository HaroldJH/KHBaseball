package com.bs.record;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hitss extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		
		ArrayList<HitssDTO> hitss = new ArrayList<>();
		
		HitssDAO dao = new HitssDAO();
		
		hitss = dao.hitss();
		
		
		
		
		 
		req.setAttribute("hitss", hitss);
		
		
		
			
		RequestDispatcher dispatcher = req.getRequestDispatcher("/record/Hitss.jsp");
		dispatcher.forward(req, resp);
	
	}
}
