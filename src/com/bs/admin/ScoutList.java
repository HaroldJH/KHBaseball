package com.bs.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ScoutList extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		String team = req.getParameter("team");//tab ? 
		int hteam = 2;//1~4 //HomeTeam   session.getAttribute("teamid");
		req.setAttribute("hteam", hteam);
		

		String prSalary = req.getParameter("prSalary");
		System.out.println(prSalary);
		req.setAttribute("prSalary", prSalary);
		
		
		if (team == null)
			team = "1";
		

		req.setAttribute("team", team);
		
		if (team.equals("1")) team = "lg";
		else if (team.equals("2")) team = "롯데";
		else if (team.equals("3")) team = "두산";
		else if (team.equals("4")) team = "sk";
		else if (team.equals("5")) team = "무소속";
		
		
		String teamdemerit = req.getParameter("teamdemerit");
		ArrayList<ScoutListDTO>plist = null;

		ScoutListDAO dao = new ScoutListDAO();
		
		if (teamdemerit != null) {
		
			System.out.println("teamdemerit = " + teamdemerit);
			String col = "";
			
			if (teamdemerit.equals("방어율")) {
				col = "pbangeo";
			}
			
			plist = dao.plist(col, team, prSalary);
			req.setAttribute("plist", plist);
		} else {
			plist = new ArrayList<ScoutListDTO>();
		}
		
		int pBangEo = dao.getpBangEo("롯데");		
		int BattingAverage = dao.getBattingAverage("롯데");		
		int OnBase = dao.getOnBase("롯데");		
		int Slugging = dao.getSlugging("롯데");		
		int Still = dao.getStill("롯데");		
		int Error = dao.getError("롯데");		
		
		ArrayList<String> selList = new ArrayList<String>();
		if (pBangEo == 1) { selList.add("방어율"); }
		if (BattingAverage == 1) { selList.add("타율"); }
		if (OnBase == 1) { selList.add("출루율"); }
		if (Slugging == 1) { selList.add("장타율"); }
		if (Still == 1) { selList.add("도루"); }
		if (Error == 1) { selList.add("실책"); }
		
		
		req.setAttribute("selList", selList);
		req.setAttribute("sel", req.getParameter("sel"));		
		req.setAttribute("teamdemerit", teamdemerit);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Admin/ScoutList.jsp");
		dispatcher.forward(req, resp);
	}
}







