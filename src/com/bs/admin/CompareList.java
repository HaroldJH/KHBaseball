package com.bs.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.model.CompareDTO;
import com.bs.model.PlayerDAO;

public class CompareList extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ArrayList<CompareDTO> compareList = new ArrayList<>();
		
		
		PlayerDAO dao = new PlayerDAO();
		compareList = dao.compareList();
		
		req.setAttribute("compareList", compareList);
		
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/Admin/Compare.jsp");

		dispatcher.forward(req, resp);
	}
}


































