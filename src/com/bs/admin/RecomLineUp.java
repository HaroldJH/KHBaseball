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
import com.bs.model.PlayerDTO;

public class RecomLineUp extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String first = req.getParameter("first");
		String second = req.getParameter("second");
		
		PlayerDAO dao = new PlayerDAO();
		ArrayList<CompareDTO> rdto = new ArrayList<>();
		
		rdto = dao.compareList(first, second);
		
		req.setAttribute("recomdto", rdto);
		
		req.setAttribute("first", first);
		req.setAttribute("second", second);
		
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/Admin/RecomLineUp.jsp");

		dispatcher.forward(req, resp);
	}
}
