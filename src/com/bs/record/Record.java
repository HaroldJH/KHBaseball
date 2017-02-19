package com.bs.record;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Record extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		
		ArrayList<RecordDTO> homeruns = new ArrayList<RecordDTO>();
		ArrayList<RecordDTO> sluggings = new ArrayList<>();
		ArrayList<RecordDTO> battingaverages = new ArrayList<RecordDTO>();
		ArrayList<RecordDTO> onbases = new ArrayList<RecordDTO>();		
		ArrayList<RecordDTO> scores = new ArrayList<RecordDTO>();
		ArrayList<RecordDTO> stills = new ArrayList<RecordDTO>();
		ArrayList<RecordDTO> rbis = new ArrayList<RecordDTO>();
		ArrayList<RecordDTO> hitss = new ArrayList<RecordDTO>();
		
		
		RecordDAO bdao = new RecordDAO();
		sluggings = bdao.Sluggings();
		battingaverages = bdao.battingAverages();
		stills = bdao.stills();
		scores = bdao.Scores();
		rbis=bdao.Rbis();
		hitss=bdao.Hitss();
		onbases=bdao.Onbases();
		
		
		homeruns = bdao.HomeRuns();
		
		req.setAttribute("homeruns", homeruns);           
		
		req.setAttribute("stills", stills);
		req.setAttribute("battingAverages",battingaverages);
		req.setAttribute("sluggings", sluggings);
		req.setAttribute("onbases", onbases);
		req.setAttribute("scores", scores);
		req.setAttribute("rbis", rbis);
		req.setAttribute("hitss", hitss);
		
		
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/record/record.jsp");

		dispatcher.forward(req, resp);
	}

}
