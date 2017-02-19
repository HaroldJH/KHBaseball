package com.bs.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Del extends HttpServlet {

	//호출하면 -> 암호 입력 페이지를 반환 역할
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//Del.do?seq=10
		
		//1. 데이터 가져오기
		//2. 아무작업 없음
		//3. 뷰 페이지 호출하기(Del.jsp)
		
		
		//1.
		String noticeId = req.getParameter("noticeId");
		
		//3.
		
		req.setAttribute("noticeId", noticeId);//삭제할 게시물 번호
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Board/Del.jsp");
		dispatcher.forward(req, resp);
		
		
		
	}
	
	
}
