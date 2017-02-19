package com.bs.record;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TeamBatter extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
		
	ArrayList<TeamBatterDTO> teambattingaverage = new ArrayList<TeamBatterDTO>();
	ArrayList<TeamBatterDTO> teamhits = new ArrayList<TeamBatterDTO>();	
	ArrayList<TeamBatterDTO> teamhomerun = new ArrayList<TeamBatterDTO>();	
	ArrayList<TeamBatterDTO> teamrbi = new ArrayList<TeamBatterDTO>();	
	ArrayList<TeamBatterDTO> teamscore = new ArrayList<TeamBatterDTO>();	
	ArrayList<TeamBatterDTO> teamstill = new ArrayList<TeamBatterDTO>();	
	ArrayList<TeamBatterDTO> teamonbase = new ArrayList<TeamBatterDTO>();	
	ArrayList<TeamBatterDTO> teamslugging = new ArrayList<TeamBatterDTO>();	
		
		
		
		
		
		TeamBatterDAO bdao = new TeamBatterDAO();
		teamslugging = bdao.TeamSlugging();
		teamhomerun = bdao.TeamHomeRun();
		teambattingaverage = bdao.TeamBattingAverage();
		teamstill = bdao.TeamStill();
		teamscore = bdao.TeamScore();
		teamrbi = bdao.TeamRbi();
		teamhits =bdao.TeamHits();
		teamonbase =bdao.TeamOnbase();
		
		
		
		
		
		 
		
		req.setAttribute("teamstill", teamstill);
		req.setAttribute("teamhomerun", teamhomerun);
		req.setAttribute("teambattingaverage",teambattingaverage);//타율		                      
		req.setAttribute("teamslugging", teamslugging);
		req.setAttribute("teamonbase", teamonbase);
		req.setAttribute("teamscore", teamscore);
		req.setAttribute("teamrbi", teamrbi);
		req.setAttribute("teamhits", teamhits);

		
		
		
		
		
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/record/TeamBatter.jsp");

		dispatcher.forward(req, resp);

			
	
	}
}
