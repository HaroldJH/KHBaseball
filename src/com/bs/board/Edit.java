
package com.bs.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.board.BoardDAO;
import com.bs.board.BoardDTO;

public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String noticeId = req.getParameter("noticeId");
		
		//2. 3.
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.view(noticeId);
		
		//4.
		
		//5.
		req.setAttribute("dto",dto);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Board/Edit.jsp");
		dispatcher.forward(req, resp);
		
	}

}
