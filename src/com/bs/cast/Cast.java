package com.bs.cast;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cast extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// req.setAttribute("play", "player : " + player + "(" + event + ")");
		req.setAttribute("hid", req.getParameter("hid"));
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cast/cast.jsp");
		dispatcher.forward(req, resp);
	}
}
