/**
 * 
 */
package com.bs.cast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.model.BatterRecordDAO;
import com.bs.model.EventDTO;
import com.bs.model.KindEventDTO;
import com.bs.model.PlayerEventDTO;

/**
 * @author YJH
 *
 */
public class CastAjax extends HttpServlet {
	
	private static int playerSeq = 0;
	private static boolean flag = true;
	private static int out = -1;
	private static int strike = 0;
	private static int ball = 0;
	private static int point = 0;
	private static int inning = 1;
	private static String attackTeamFlag = "A";
	private static int first_base = 0;
	private static int second_base = 0;
	private static int third_base = 0;
	private BatterRecordDTO[] alist = null;
	private BatterRecordDTO[] hlist = null;

	private ArrayList<EventDTO> elist = null;
	private String[] player = null;
	private int[] playerId = null;
	private int hid = 0;
	public static int seq = 0;
	
	public CastAjax() {
		alist = new BatterRecordDTO[9];
		hlist = new BatterRecordDTO[9];
		elist = new ArrayList<EventDTO>();
		player = new String[9];
		playerId = new int[9];
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		CastDAO dao = new CastDAO();

		String str = "";
		//while (flag) {
		
		if (req.getCookies() != null) {
			if (req.getCookies().length != 0) {
				for (int i = 0; i < req.getCookies().length; i++) {
					if (!req.getCookies()[i].getName().equals("attackTeam")
							&& !req.getCookies()[i].getName().equals("inning")
							&& !req.getCookies()[i].getName().equals(
									"playerSeq")
							&& !req.getCookies()[i].getName().equals("strike")
							&& !req.getCookies()[i].getName().equals("ball")
							&& !req.getCookies()[i].getName().equals("out")) {
						// attackTeamFlag = "A";
						// System.out.println("ㅠㅠ : " +
						// req.getCookies()[i].getValue());
					} else {
						if (req.getCookies()[i].getName().equals("inning")) {
							inning = Integer.parseInt(req.getCookies()[i]
									.getValue());
						} else if (req.getCookies()[i].getName().equals(
								"attackTeam")) {
							attackTeamFlag = req.getCookies()[i].getValue();
							if (attackTeamFlag.equals("H")
									&& req.getCookies()[i].getName().equals(
											"hplayerSeq")) {
								playerSeq = Integer
										.parseInt(req.getCookies()[i]
												.getValue());
							} else if (attackTeamFlag.equals("A")
									&& req.getCookies()[i].getName().equals(
											"aplayerSeq")) {
								playerSeq = Integer
										.parseInt(req.getCookies()[i]
												.getValue());
							}
						} else if (req.getCookies()[i].getName().equals(
								"strike")) {
							strike = Integer.parseInt(req.getCookies()[i]
									.getValue());
						} else if (req.getCookies()[i].getName().equals("ball")) {
							ball = Integer.parseInt(req.getCookies()[i]
									.getValue());
						} else if (req.getCookies()[i].getName().equals("out")) {
							out = Integer.parseInt(req.getCookies()[i]
									.getValue());
						} 
					}
				}
			}
		} else {
			// attackTeamFlag = "A";
		}
		
		if (attackTeamFlag.equals("A")) {
			if (req.getAttribute("APoint") != null) {
				point = (Integer)req.getAttribute("APoint");
			}
		} else if (attackTeamFlag.equals("H")) {
			if (req.getAttribute("HPoint") != null) {
				point = (Integer)req.getAttribute("HPoint");
			}
		}
		
		if (out == -1) {
			String temp = "";
			char tempc = '\0';
			if (attackTeamFlag.equals("A")) {
				temp = "원정";
				tempc = '초';
			} else if (attackTeamFlag.equals("H")) {
				temp = "홈";
				tempc = '말';
			}
			System.out.printf("%d회%c %s팀 공격", inning, tempc, temp);
		}

		
		hid = Integer.parseInt(req.getParameter("hid"));
		ArrayList<ALineDTO> list = dao.attackLineUp(attackTeamFlag, hid);

		float[] batting = new float[9];

		for (int i = 0; i < 9; i++) {
			player[i] = list.get(i).getPlayerName();
			playerId[i] = list.get(i).getPlayerId();
			batting[i] = dao.batting(list.get(i).getPlayerId());
		}
		
		if (attackTeamFlag.equals("A")) {
			for (int i = 0; i < batting.length; i++) {
				alist[i] = dao.getBatterRec();
			}
		} else if (attackTeamFlag.equals("H")) {
			for (int i = 0; i < batting.length; i++) {
				hlist[i] = dao.getBatterRec();
			}
		}

		int temp = (int) (batting[playerSeq] * 10);

		// A/B or C/D??
		int[] select = new int[10];

		for (int j = 0; j < 5; j++) {
			select[j] = 1;
		}

		for (int j = 5; j < 10; j++) {
			select[j] = 1;
		}

		Random rand = new Random();
		int index = rand.nextInt(9);
		String event = "";
		
		if (select[index] == 1) {
			event = bat(temp);
		} else if (select[index] == 2) {
			event = noBat();
		}
		
		if (attackTeamFlag.equals("A")) {
			alist[playerSeq].setBat(alist[playerSeq].getBat() +1);
		} else if (attackTeamFlag.equals("H")) {
			hlist[playerSeq].setBat(hlist[playerSeq].getBat() +1);
		}
		
		System.out.printf("%s : %s(타율 : %f)", player[playerSeq], event,
				batting[playerSeq]);
		if (attackTeamFlag.equals("A")) {
			req.setAttribute("APoint", point);
		} else if (attackTeamFlag.equals("H")) {
			req.setAttribute("HPoint", point);
		}
		System.out.println("그러지마ㅠㅠ : " + out);
		if (out >= 2) {
			out = -1;
			strike = ball = 0;
			System.out.println("3아웃 공수교대");
			EventDTO dto = new EventDTO();
			
			if (attackTeamFlag.equals("A")) {
				attackTeamFlag = "H";
				str = "Away";
				dto.setPlayerEvent("3아웃 원정팀공격종료");
				event += "3아웃 원정팀공격종료";
			} else if (attackTeamFlag.equals("H")) {
				attackTeamFlag = "A";
				str = "Home";
				inning++;
				dto.setPlayerEvent("3아웃 홈팀공격종료");
				event += "3아웃 홈팀공격종료";
			}
			seq = dao.seq();
			dao.addEvent(elist, hid, playerSeq);
			if (inning > 9 && attackTeamFlag.equals("H")) {
				flag = false;
				dao.closeDB();
				event += "\n 3아웃 경기종료";
				dao.end(hid);
				req.setAttribute("isEnd", "end");
				
				BatterRecordDAO bdao = new BatterRecordDAO();
				bdao.add((BatterRecordDTO)req.getAttribute("alist"));
				bdao.add((BatterRecordDTO)req.getAttribute("hlist"));
				
				for (int i = 0; i < alist.length; i++) {
					int bat = 0; // 타석
					int atBat = 0; //타수
					int battingAverage = 0; //타율
					int fourBall = 0; //볼넷
					int onBase = 0; //출루율
					int slugging = 0; //장타율
					int ops = 0; //OPS
					int hits = 0; //안타
					int twoHit = 0; // 2루타
					int threeHit = 0; // 3루타
					int homeRun = 0; // 홈런
					
					// 값들 가져오기
					fourBall = alist[playerSeq].getFourBall();
					hits = alist[playerSeq].getHits();
					twoHit = alist[playerSeq].getTwoHit();
					threeHit = alist[playerSeq].getThreeHit();
					homeRun = alist[playerSeq].getHomeRun();
					bat = alist[playerSeq].getBat();
					
					// 계산
					atBat = bat - fourBall;
					battingAverage = hits / atBat;
					onBase = (hits + fourBall) / bat;
					slugging = (hits + twoHit*2 + threeHit*3 + homeRun * 4) / atBat;
					ops = onBase + slugging;
					
					// 넣기
					alist[playerSeq].setAtBat(atBat);
					alist[playerSeq].setBattingAverage(battingAverage);
					alist[playerSeq].setOnBase(onBase);
					alist[playerSeq].setSlugging(slugging);
					alist[playerSeq].setOPS(ops);
				}
				
				for (int i = 0; i < hlist.length; i++) {
					int bat = 0; // 타석
					int atBat = 0; //타수
					int battingAverage = 0; //타율
					int fourBall = 0; //볼넷
					int onBase = 0; //출루율
					int slugging = 0; //장타율
					int ops = 0; //OPS
					int hits = 0; //안타
					int twoHit = 0; // 2루타
					int threeHit = 0; // 3루타
					int homeRun = 0; // 홈런
					
					// 값들 가져오기
					fourBall = hlist[playerSeq].getFourBall();
					hits = hlist[playerSeq].getHits();
					twoHit = hlist[playerSeq].getTwoHit();
					threeHit = hlist[playerSeq].getThreeHit();
					homeRun = hlist[playerSeq].getHomeRun();
					bat = hlist[playerSeq].getBat();
					
					// 계산
					atBat = bat - fourBall;
					battingAverage = hits / atBat;
					onBase = (hits + fourBall) / bat;
					slugging = (hits + twoHit*2 + threeHit*3 + homeRun * 4) / atBat;
					ops = onBase + slugging;
					
					// 넣기
					hlist[playerSeq].setAtBat(atBat);
					hlist[playerSeq].setBattingAverage(battingAverage);
					hlist[playerSeq].setOnBase(onBase);
					hlist[playerSeq].setSlugging(slugging);
					hlist[playerSeq].setOPS(ops);
				}
			}
		//}
	 }

		Cookie cookie = new Cookie("attackTeam", attackTeamFlag);
		resp.addCookie(cookie);

		if (attackTeamFlag.equals("H")) {
			cookie = new Cookie("aplayerSeq", "" + playerSeq);
			resp.addCookie(cookie);
		} else if (attackTeamFlag.equals("A")) {
			cookie = new Cookie("hplayerSeq", "" + playerSeq);
			resp.addCookie(cookie);
		}

		cookie = new Cookie("Inning", "" + inning);
		resp.addCookie(cookie);

		cookie = new Cookie("out", "" + out);
		resp.addCookie(cookie);

		cookie = new Cookie("strike", "" + strike);
		resp.addCookie(cookie);

		cookie = new Cookie("ball", "" + ball);
		resp.addCookie(cookie);

		req.setAttribute("alist", alist);
		req.setAttribute("hlist", hlist);
		
		req.setAttribute("player", player[playerSeq]);
		req.setAttribute("event", event);
		
		if (seq != 0) {
			req.setAttribute("seq", seq);
//			ArrayList<EventDTO> elist = dao.getEventList(seq);	
			
//			req.setAttribute("elist", elist);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/cast/castAjax.jsp");
			dispatcher.forward(req, resp);
		} else {
//			resp.sendRedirect("/KHBaseball/cast/cast.do");
		}
	}
	
	private String noBat() {
		CastDAO dao = new CastDAO();
		ArrayList<KindEventDTO> list = dao.getD();

		Random rand = new Random(Calendar.getInstance().getTime().getTime());
		int index = rand.nextInt(list.size());

		int eventId = list.get(index).getPlayerEventId();
		switch (eventId) {

		// th트라이크
		case 26:
			if (++strike >= 3) {
				if (attackTeamFlag.equals("A")) {
					alist[playerSeq].setSamjin(alist[playerSeq].getSamjin() + 1);
				} else if (attackTeamFlag.equals("H")) {
					hlist[playerSeq].setSamjin(hlist[playerSeq].getSamjin() + 1);
				}
				out++;
				if (++playerSeq >= 8) {
					playerSeq = 0;
				}
				strike = 0;
			}
			{
			EventDTO dto = new EventDTO();
			dto.setInning(inning);
			dto.setPlayerEventId(26);
			dto.setPlayerId(playerId[playerSeq]);
			elist.add(dto);
			seq = dao.seq();
			}
			break;
		// 볼
		case 27:
			if (++ball == 4) {
				// 주자이동
				if (attackTeamFlag.equals("A")) {
					alist[playerSeq].setFourBall(alist[playerSeq].getFourBall() + 1);
				} else if (attackTeamFlag.equals("H")) {
					hlist[playerSeq].setFourBall(hlist[playerSeq].getFourBall() + 1);
				}
				strike = ball = 0;
				if (++playerSeq >= 8) {
					playerSeq = 0;
				}
			}
			{
				EventDTO dto = new EventDTO();
				dto.setInning(inning);
				dto.setPlayerEventId(27);
				dto.setPlayerId(playerId[playerSeq]);
				elist.add(dto);
				seq = dao.seq();
			}
			break;

		// 헛th윙
		case 28:
			if (strike <= 2) {
				strike++;
			} else if (strike >= 3) {
				out++;
				if (++playerSeq >= 8) {
					playerSeq = 0;
				}
				ball = strike = 0;
				if (attackTeamFlag.equals("A")) {
					alist[playerSeq].setSamjin(alist[playerSeq].getSamjin() + 1);
				} else if (attackTeamFlag.equals("H")) {
					hlist[playerSeq].setSamjin(hlist[playerSeq].getSamjin() + 1);
				}
			}
			{
				EventDTO dto = new EventDTO();
				dto.setInning(inning);
				dto.setPlayerEventId(28);
				dto.setPlayerId(playerId[playerSeq]);
				elist.add(dto);
				seq = dao.seq();
			}
			break;
		}
		return list.get(index).getPlayerEvent();
	}

	private String bat(int temp) {
		char[] temps = new char[1000];
		// A or B

		for (int i = 0; i < temp * 100; i++) {
			temps[i] = 'B';
		}
		System.out.println("tempv : " + temp);
		for (int i = temp * 100; i < 1000; i++) {
			temps[i] = 'A';
		}
		CastDAO dao = new CastDAO();
		// HashMap<Integer, String> map = dao.attackLineUp(attackTeamFlag, 1);
		ArrayList<ALineDTO> list = dao.attackLineUp(attackTeamFlag, hid);
		Random rand = new Random(Calendar.getInstance().getTime().getTime());

		int index = rand.nextInt(temps.length);
		// map = null;
		// map = dao.hits("" + temps[index]);

		ArrayList<PlayerEventDTO> liste = dao.hits("" + temps[index]);
		index = rand.nextInt(liste.size());

		int[] tempst = new int[liste.size()];

		// Collection key = map.keySet();
		// Iterator iter = key.iterator();

		for (int i = 0; i < liste.size(); i++) {
			// tempst[i] = Integer.parseInt(iter.next().toString());
			tempst[i] = liste.get(i).getPlayerEventId();
		}

		if (tempst[index] < 16) {
			switch (tempst[index] / 15) {

			// 0~15 : 1out++
			case 0:
				out++;
				strike = ball = 0;
				if (++playerSeq >= 8) {
					playerSeq = 0;
				}
				{
					EventDTO dto = new EventDTO();
					dto.setInning(inning);
					dto.setPlayerEventId(tempst[index]);
					dto.setPlayerId(playerId[playerSeq]);
					elist.add(dto);
					seq = dao.seq();
				}
				dao.addEvent(elist, hid, playerSeq);
				break;

			case 1:
				if (tempst[index] == 15) {
					out++;
					strike = ball = 0;
					playerSeq++;
				}
				{
					EventDTO dto = new EventDTO();
					dto.setInning(inning);
					dto.setPlayerEventId(tempst[index]);
					dto.setPlayerId(playerId[playerSeq]);
					elist.add(dto);
					seq = dao.seq();
				}
				dao.addEvent(elist, hid, playerSeq);
				break;
			}
			// 16 : 2out++ 병살
		} 
			//else if (tempst[index] == 16) {
//			out += 2;
//			playerSeq++;
//			strike = ball = 0;
//			if (attackTeamFlag.equals("A")) {
//				alist[playerSeq].setDoublePlay(alist[playerSeq].getDoublePlay() + 1);
//			} else if (attackTeamFlag.equals("H")) {
//				hlist[playerSeq].setDoublePlay(hlist[playerSeq].getDoublePlay() + 1);
//			}
//			// if (juja >= 2) {
//			// juja -= 2;
//			// }
//			// 1루
//			// 2루
//			// 3루
//			// 12루
//			// 23루
//			// 13루
//			// 만루
//			// 18 : 헛th윙
//			{
//				EventDTO dto = new EventDTO();
//				dto.setInning(inning);
//				dto.setPlayerEventId(tempst[index]);
//				dto.setPlayerId(playerId[playerSeq]);
//				elist.add(dto);
//				seq = dao.seq();
//			}
//			dao.addEvent(elist, hid, playerSeq);
//		} 
			else if (tempst[index] == 17) {
			if (++strike == 3) {
				out++;
				if (++playerSeq >= 8) {
					playerSeq = 0;
				}
				strike = ball = 0;
			}
			{
				EventDTO dto = new EventDTO();
				dto.setInning(inning);
				dto.setPlayerEventId(tempst[index]);
				dto.setPlayerId(playerId[playerSeq]);
				elist.add(dto);
				seq = dao.seq();
			}
			dao.addEvent(elist, hid, playerSeq);
			
			// 안타
		} else if (tempst[index] == 18) {

			// 안타카운트(타자성적) +1
			if (attackTeamFlag.equals("A")) {
				alist[playerSeq].setHits(alist[playerSeq].getHits() + 1);
			} else if (attackTeamFlag.equals("H")) {
				hlist[playerSeq].setHits(hlist[playerSeq].getHits() + 1);
			}

			// 만루일 때
			if (first_base == 1 && second_base == 1 && third_base == 1) {
				point++;
			}
			// 1루만
			if (first_base == 1 && second_base == 0 && third_base == 0) {
				second_base = 1;
			}
			// 2루만
			if (first_base == 0 && second_base == 1 && third_base == 0) {
				first_base = third_base = 1;
				second_base = 0;
			}
			// 3루만
			if (first_base == 0 && second_base == 0 && third_base == 1) {
				first_base = 1;
				third_base = 0;
				point++;
			}
			// 1, 2루
			if (first_base == 1 && second_base == 1 && third_base == 0) {
				first_base = 0;
				third_base = 1;
			}
			// 2, 3루
			if (first_base == 0 && second_base == 1 && third_base == 1) {
				first_base = 1;
				third_base = 1;
				point++;
			}
			// 1, 3루
			if (first_base == 1 && second_base == 0 && third_base == 1) {
				first_base = 0;
				second_base = 1;
				point++;
			}
			{
				EventDTO dto = new EventDTO();
				dto.setInning(inning);
				dto.setPlayerEventId(tempst[index]);
				dto.setPlayerId(playerId[playerSeq]);
				elist.add(dto);
				seq = dao.seq();
			}
			dao.addEvent(elist, hid, playerSeq);
		} else if (tempst[index] == 24 || tempst[index] == 17) {
			if (++strike >= 3) {
				out++;
				playerSeq++;
				strike = ball = 0;
			}
			// 2루타
		} else if (tempst[index] == 19) {

			// 2루타카운트(타자성적) +1
			if (attackTeamFlag.equals("A")) {
				alist[playerSeq].setTwoHit(alist[playerSeq].getTwoHit() + 1);
			} else if (attackTeamFlag.equals("H")) {
				hlist[playerSeq].setTwoHit(hlist[playerSeq].getTwoHit() + 1);
			}

			// 만루일 때
			if (first_base == 1 && second_base == 1 && third_base == 1) {
				point += 2;
			}
			// 1루만
			if (first_base == 1 && second_base == 0 && third_base == 0) {
				third_base = first_base = 1;
			}
			// 2루만
			if (first_base == 0 && second_base == 1 && third_base == 0) {
				second_base = third_base = 1;
			}
			// 3루만
			if (first_base == 0 && second_base == 0 && third_base == 1) {
				point++;
			}
			// 1, 2루
			if (first_base == 1 && second_base == 1 && third_base == 0) {
				first_base = 0;
				third_base = 1;
				point++;
			}
			// 2, 3루
			if (first_base == 0 && second_base == 1 && third_base == 1) {
				first_base = 0;
				third_base = 0;
				point += 2;
			}
			// 1, 3루
			if (first_base == 1 && second_base == 0 && third_base == 1) {
				first_base = 0;
				second_base = 0;
				point++;
			}
			{
				EventDTO dto = new EventDTO();
				dto.setInning(inning);
				dto.setPlayerEventId(tempst[index]);
				dto.setPlayerId(playerId[playerSeq]);
				elist.add(dto);
				seq = dao.seq();
			}
			dao.addEvent(elist, hid, playerSeq);
			// 3루타
		} else if (tempst[index] == 20) {

			// 3루타카운트(타자성적) +1
			if (attackTeamFlag.equals("A")) {
				alist[playerSeq]
						.setThreeHit(alist[playerSeq].getThreeHit() + 1);
			} else if (attackTeamFlag.equals("H")) {
				hlist[playerSeq]
						.setThreeHit(hlist[playerSeq].getThreeHit() + 1);
			}
			// 만루일 때
			if (first_base == 1 && second_base == 1 && third_base == 1) {
				point += 3;
			}
			// 1루만
			if (first_base == 1 && second_base == 0 && third_base == 0) {
				third_base = 1;
				first_base = 0;
				point++;
			}
			// 2루만
			if (first_base == 0 && second_base == 1 && third_base == 0) {
				second_base = 0;
				third_base = 1;
				point++;
			}
			// 3루만
			if (first_base == 0 && second_base == 0 && third_base == 1) {
				point++;
			}
			// 1, 2루
			if (first_base == 1 && second_base == 1 && third_base == 0) {
				first_base = 0;
				third_base = 1;
				second_base = 0;
				point += 2;
			}
			// 2, 3루
			if (first_base == 0 && second_base == 1 && third_base == 1) {
				first_base = 0;
				second_base = 0;
				third_base = 1;
				point += 2;
			}
			// 1, 3루
			if (first_base == 1 && second_base == 0 && third_base == 1) {
				first_base = 0;
				second_base = 0;
				third_base = 1;
				point += 2;
			}
			{
				EventDTO dto = new EventDTO();
				dto.setInning(inning);
				dto.setPlayerEventId(tempst[index]);
				dto.setPlayerId(playerId[playerSeq]);
				elist.add(dto);
				seq = dao.seq();
			}
			dao.addEvent(elist, hid, playerSeq);
		} else if (tempst[index] == 21) {
			// 홈런
			if (attackTeamFlag.equals("A")) {
				alist[playerSeq].setHomeRun(alist[playerSeq].getHomeRun() + 1);
			} else if (attackTeamFlag.equals("H")) {
				hlist[playerSeq].setHomeRun(hlist[playerSeq].getHomeRun() + 1);
			}

			// 만루일 때
			if (first_base == 1 && second_base == 1 && third_base == 1) {
				point += 4;
				first_base = second_base = third_base = 0;
			}
			// 1루만
			if (first_base == 1 && second_base == 0 && third_base == 0) {
				first_base = second_base = third_base = 0;
				point += 2;
			}
			// 2루만
			if (first_base == 0 && second_base == 1 && third_base == 0) {
				first_base = second_base = third_base = 0;
				point += 2;
			}
			// 3루만
			if (first_base == 0 && second_base == 0 && third_base == 1) {
				point += 2;
				first_base = second_base = third_base = 0;
			}
			// 1, 2루
			if (first_base == 1 && second_base == 1 && third_base == 0) {
				first_base = second_base = third_base = 0;
				point += 3;
			}
			// 2, 3루
			if (first_base == 0 && second_base == 1 && third_base == 1) {
				first_base = second_base = third_base = 0;
				point += 3;
			}
			// 1, 3루
			if (first_base == 1 && second_base == 0 && third_base == 1) {
				first_base = second_base = third_base = 0;
				point += 3;
			}
		} else if (tempst[index] == 22) {
			// 1루만
			if (first_base == 1 && second_base == 0 && third_base == 0) {
				first_base = second_base = 1;
				third_base = 0;
				point += 2;
			}
			// 1, 2루
			if (first_base == 1 && second_base == 1 && third_base == 0) {
				first_base = second_base = third_base = 1;
				point += 3;
			}
			// 1, 3루
			if (first_base == 1 && second_base == 0 && third_base == 1) {
				first_base = second_base = third_base = 1;
				point += 3;
			}
			{
				EventDTO dto = new EventDTO();
				dto.setInning(inning);
				dto.setPlayerEventId(tempst[index]);
				dto.setPlayerId(playerId[playerSeq]);
				elist.add(dto);
				seq = dao.seq();
			}
			dao.addEvent(elist, hid, playerSeq);
		}
		// System.out.printf("size : %d, length : %d index: %d tempst : %d",
		// liste.size(), tempst.length, index, tempst[index]);
		// return liste.get(tempst[index]).getPlayerEvent();
		return liste.get(index).getPlayerEvent();
	}
}
