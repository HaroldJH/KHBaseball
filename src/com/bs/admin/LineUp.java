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

public class LineUp extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		ArrayList<CompareDTO> lgLineUp = new ArrayList<>();
		ArrayList<CompareDTO> doosanLineUp = new ArrayList<>();
		ArrayList<CompareDTO> skLineUp = new ArrayList<>();
		
		CompareDAO dao = new CompareDAO();
		
		lgLineUp = dao.lgLineUp();
		doosanLineUp = dao.doosanLineUp();
		skLineUp = dao.skLineUp();
		
		
		req.setAttribute("lgLineUp", lgLineUp);
		req.setAttribute("doosanLineUp", doosanLineUp);
		req.setAttribute("skLineUp", skLineUp);
		
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/Admin/LineUp.jsp");

		dispatcher.forward(req, resp);
	}
}
