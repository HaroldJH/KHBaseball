package com.bs.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Scout extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

				
		String hteam = "2";// 1~4 //HomeTeam session.getAttribute("teamid");

		String teamdemerit = req.getParameter("teamdemerit2");
		String team = req.getParameter("team2");
		String prSalary = req.getParameter("prSalary2");

		String ch = req.getParameter("ch");  

		System.out.println(ch);
//		System.out.println("teamdemerit : :" + teamdemerit);
//		System.out.println(team);
//		System.out.println(prSalary);

		ScoutListDAO dao = new ScoutListDAO();
		dao.move(ch, hteam);

		req.setAttribute("team", team);
		req.setAttribute("teamdemerit", teamdemerit);
		req.setAttribute("prSalary", prSalary);
		
		System.out.println("투수영입");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Admin/Scout.jsp");
		dispatcher.forward(req, resp);

	}
}
