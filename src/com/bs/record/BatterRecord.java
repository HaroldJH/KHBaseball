package com.bs.record;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bs.model.CompareDTO;
import com.bs.model.PlayerDAO;
import com.bs.model.TeamDTO;

public class BatterRecord extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		ArrayList<PlayerRankDTO> slugging = new ArrayList<>();
		ArrayList<PlayerRankDTO> sluggings = new ArrayList<>();
		ArrayList<PlayerRankDTO> battingaverages = new ArrayList<PlayerRankDTO>();
		ArrayList<PlayerRankDTO> onbases = new ArrayList<PlayerRankDTO>();		
		ArrayList<PlayerRankDTO> homeruns = new ArrayList<PlayerRankDTO>();
		ArrayList<PlayerRankDTO> scores = new ArrayList<PlayerRankDTO>();
		ArrayList<PlayerRankDTO> stills = new ArrayList<PlayerRankDTO>();
		ArrayList<PlayerRankDTO> rbis = new ArrayList<PlayerRankDTO>();
		ArrayList<PlayerRankDTO> hitss = new ArrayList<PlayerRankDTO>();
		
		
		ArrayList<PlayerRankDTO> homerun = new ArrayList<PlayerRankDTO>();
		ArrayList<PlayerRankDTO> battingaverage = new ArrayList<PlayerRankDTO>();
		ArrayList<PlayerRankDTO> onbase = new ArrayList<PlayerRankDTO>();
		ArrayList<PlayerRankDTO> still = new ArrayList<>();
		ArrayList<PlayerRankDTO> score = new ArrayList<PlayerRankDTO>();
		ArrayList<PlayerRankDTO> rbi = new ArrayList<PlayerRankDTO>();
		ArrayList<PlayerRankDTO> hits = new ArrayList<PlayerRankDTO>();
		
		
		
		
		
		
		
		
		BatterDAO bdao = new BatterDAO();
		slugging = bdao.Slugging();
		sluggings = bdao.Sluggings();
		homerun = bdao.HomeRun();
		homeruns = bdao.HomeRuns();
		battingaverage = bdao.battingAverage();
		battingaverages = bdao.battingAverages();
		still = bdao.still();
		still = bdao.stills();
		score = bdao.Score();
		scores = bdao.Scores();
		rbi = bdao.Rbi();
		rbis=bdao.Rbis();
		hits=bdao.Hits();
		hitss=bdao.Hitss();
		onbase=bdao.Onbase();
		onbases=bdao.Onbases();
		
		
		
		
		 
		req.setAttribute("s", still);
		req.setAttribute("ss", stills);
		req.setAttribute("homerun", homerun);
		req.setAttribute("homeruns", homeruns);
		req.setAttribute("battingaverage",battingaverage);//타율
		                      
		req.setAttribute("battingAverages",battingaverages);
		req.setAttribute("slugging", slugging);
		req.setAttribute("sluggings", sluggings);
		req.setAttribute("onbase", onbase);
		req.setAttribute("onbases", onbases);
		req.setAttribute("score", score);
		req.setAttribute("scores", scores);
		req.setAttribute("rbi", rbi);
		req.setAttribute("rbis", rbis);
		req.setAttribute("hits", hits);
		req.setAttribute("hitss", hitss);
		
		
		
		
		
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/record/BatterRecord.jsp");

		dispatcher.forward(req, resp);
	}
	
}
