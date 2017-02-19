package com.bs.record;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PitcherRecord extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		ArrayList<PicherDTO> pBangEo = new ArrayList<>();
		ArrayList<PicherDTO> pBangEos = new ArrayList<>();
		ArrayList<PicherDTO> pwin = new ArrayList<>();
		ArrayList<PicherDTO> pwins = new ArrayList<>();
		ArrayList<PicherDTO> psave = new ArrayList<>();
		ArrayList<PicherDTO> psaves = new ArrayList<>();
		ArrayList<PicherDTO> phold = new ArrayList<>();
		ArrayList<PicherDTO> pholds = new ArrayList<>();
		ArrayList<PicherDTO> psamjin = new ArrayList<>();
		ArrayList<PicherDTO> psamjins = new ArrayList<>();

		
		
		
		
		
		
		
		PicherDAO bdao = new PicherDAO();
		pBangEo = bdao.PBangEo();
		pBangEos = bdao.PBangEos();
		pwin = bdao.Pwin();
		pwins = bdao.Pwins();
		psaves = bdao.Psaves();
		psave = bdao.Psave();
		phold = bdao.Phold();
		pholds = bdao.Pholds();
		psamjin = bdao.Psamjin();
		psamjins = bdao.Psamjins();
		
		
		
		req.setAttribute("pBangEo", pBangEo);
		req.setAttribute("pBangEos", pBangEos);
		req.setAttribute("pwin", pwin);
		req.setAttribute("pwins", pwins);
		req.setAttribute("psaves", psaves);
		req.setAttribute("psave", psave);
		req.setAttribute("phold", phold);
		req.setAttribute("pholds", pholds);
		req.setAttribute("psamjin", psamjin);
		req.setAttribute("psamjins", psamjins);
		
		
		
		
		
		
		
		
		
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/record/PitcherRecord.jsp");

		dispatcher.forward(req, resp);
	
	}
}
