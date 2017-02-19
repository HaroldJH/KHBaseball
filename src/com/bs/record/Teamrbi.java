package com.bs.record;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Teamrbi extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			req.setCharacterEncoding("utf-8");
			
			
			ArrayList<TeamrbiDTO> teamrbi = new ArrayList<TeamrbiDTO>();

		
		
			TeamrbiDAO bdao = new TeamrbiDAO();

			teamrbi = bdao.teamRbi();
			
			
			req.setAttribute("teamrbi", teamrbi);
			
			
			
			
			
			
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/record/Teamrbi.jsp");
			dispatcher.forward(req, resp);
		}
}
