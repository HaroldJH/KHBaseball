/**
 * 
 */
package com.bs.cast;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author YJH
 *
 */
public class PlaySchedule extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PlayscheduleDAO dao = new PlayscheduleDAO();
		ArrayList<PlayscheduleDTO> list = dao.getSchedule();
		
		req.setAttribute("schedule", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/cast/playSchedule.jsp");
		dispatcher.forward(req, resp);
	}
}
