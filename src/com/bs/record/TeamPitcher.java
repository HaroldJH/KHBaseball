package com.bs.record;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TeamPitcher extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			req.setCharacterEncoding("UTF-8");
			
			
			ArrayList<TeamPitcherDTO> teampbangeo = new ArrayList<TeamPitcherDTO>();
			ArrayList<TeamPitcherDTO> teampsave = new ArrayList<TeamPitcherDTO>();
			ArrayList<TeamPitcherDTO> teampsamjin = new ArrayList<TeamPitcherDTO>();
		
		
			TeamPitcherDAO bdao = new TeamPitcherDAO();
			teampbangeo = bdao.TeamPBangEo();
			teampsave = bdao.TeamPsave();
			teampsamjin = bdao.TeamPsamjin();
			
			
			req.setAttribute("teampbangeo", teampbangeo);
			req.setAttribute("teampsave", teampsave);
			req.setAttribute("teampsamjin", teampsamjin);
			
			
			
		
			RequestDispatcher dispatcher =
					req.getRequestDispatcher("/record/TeamPitcher.jsp");

			dispatcher.forward(req, resp);

		
		}
}
