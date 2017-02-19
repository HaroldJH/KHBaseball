package com.bs.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveList extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		RemoveListDAO dao = new RemoveListDAO();
		ArrayList<RemoveListDTO>plist = null;
		plist = dao.plist();	
		req.setAttribute("plist", plist);
		
		
		ArrayList<RemoveListDTO>hlist = null;
		hlist = dao.hlist();	
		req.setAttribute("hlist", hlist);
		
		
		req.setAttribute("sel", req.getParameter("sel"));
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Admin/RemoveList.jsp");
		dispatcher.forward(req, resp);
	}
}
