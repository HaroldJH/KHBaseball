package com.bs.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.model.CompareDTO;
import com.bs.model.CompareDTO2;
import com.bs.model.PlayerDAO;

public class Compare extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String teamId = req.getParameter("teamId");
		
		ArrayList<CompareDTO> compareList = new ArrayList<>();
		ArrayList<CompareDTO2> compareList2 = new ArrayList<>();
		
		PlayerDAO dao = new PlayerDAO();
		compareList = dao.compareList3(teamId);// 타자비교 목록 리스트
		compareList2 = dao.compareList2(teamId); //투수비교 목록 리스트
		
		req.setAttribute("compareList", compareList);
		req.setAttribute("compareList2", compareList2);
		
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/Admin/Compare.jsp");

		dispatcher.forward(req, resp);
	}
}










