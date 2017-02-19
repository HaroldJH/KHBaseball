package com.bs.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bs.model.MemberDAO;

public class Login extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		
		String id = req.getParameter("mId");
		String pw = req.getParameter("mPw");
		
		System.out.println(id);
		System.out.println(pw);
		
		MemberDAO dao = new MemberDAO();
		
		String result = dao.login(id, pw);
		
		req.setAttribute("result", result); 
		
		if(result != null){
			session.setAttribute("mId", id);
			session.setAttribute("teamId", result);
			System.out.println(result);
		}
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/Admin/LoginOk.jsp");

		dispatcher.forward(req, resp);
	}
}










