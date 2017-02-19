package com.bs.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.model.CompareDAO;
import com.bs.model.CompareDTO;
import com.bs.model.CompareDTO2;
import com.bs.model.PlayerDAO;
import com.bs.model.TeamCompareDTO;

public class TeamCompare extends HttpServlet{ //선수 비교 서블릿
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ArrayList<TeamCompareDTO> list = new ArrayList<>();
		ArrayList<TeamCompareDTO> list2 = new ArrayList<>();
		CompareDTO2 dto = new CompareDTO2();
		CompareDTO2 dto2 = new CompareDTO2();
		CompareDTO2 dto3 = new CompareDTO2();
		CompareDTO2 dto4 = new CompareDTO2();
		ArrayList<CompareDTO> lotteLineUp = new ArrayList<>();
		
		
		
		CompareDAO dao = new CompareDAO();
		
		list = dao.teamCompare();
		list2 = dao.teamCompare2();
		dto = dao.pitcher();
		dto2 = dao.pitcher2();
		dto3 = dao.pitcher3();
		dto4 = dao.pitcher4();
		lotteLineUp = dao.lotteLineUp();
		
		req.setAttribute("team1", list.get(0));
		req.setAttribute("team2", list.get(1));
		req.setAttribute("team3", list2.get(0));
		req.setAttribute("team4", list2.get(1));
		req.setAttribute("pitcher", dto);
		req.setAttribute("pitcher2", dto2);
		req.setAttribute("pitcher3", dto3);
		req.setAttribute("pitcher4", dto4);
		req.setAttribute("lotteLineUp", lotteLineUp);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Admin/TeamCompare.jsp");

		dispatcher.forward(req, resp);
	}
}
