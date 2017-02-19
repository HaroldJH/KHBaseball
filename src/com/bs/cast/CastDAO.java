package com.bs.cast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.bs.db.DBUtil;
import com.bs.model.EventDTO;
import com.bs.model.KindEventDTO;
import com.bs.model.PlayerDTO;
import com.bs.model.PlayerEventDTO;

public class CastDAO {

	private String sql = "";
	private Connection con = null;
	private PreparedStatement stat = null;
	private int[] playerSeq = null;
	
	public CastDAO() {
		con = DBUtil.connect();
		playerSeq = new int[9];
		for (int i = 0; i < playerSeq.length; i++) {
			playerSeq[i] = 0;
		}
	}

	public int seq() {
		sql = "SELECT MAX(eventId) AS maxSeq FROM playEvent WHERE ROWNUM < 2 ORDER BY eventid desc";
		int seq = 0;
		try {
			stat = con.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			
			if (rs.next()) {
				seq = rs.getInt("maxSeq");
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		return seq;
	}
	
	public BatterRecordDTO getBatterRec(){
		BatterRecordDTO list = new BatterRecordDTO();
		
		return list;
	}
	
	public float batting(int playerId) {

		sql = "SELECT AVG(battingaverage) AS Batting FROM batterRecord  WHERE playerId = ?";

		float batting = 0f;

		try {
			// System.out.println("A");
			stat = con.prepareStatement(sql);
			stat.setInt(1, playerId);
			ResultSet rs = stat.executeQuery();
			// System.out.println("B");

			if (rs.next()) {
				batting = rs.getFloat("Batting");
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			// try {
			// con.close();
			// } catch (SQLException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		}

		return batting;
	}

	public ArrayList<PlayerEventDTO> hits(String a) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();

		ArrayList<PlayerEventDTO> list = new ArrayList<PlayerEventDTO>();

		sql = "SELECT * FROM kindPlayEvent WHERE kind = ?";
		System.out.println("testa : " + a);
		try {
			// System.out.println("C");
			stat = con.prepareStatement(sql);
			stat.setString(1, a);
			ResultSet rs = stat.executeQuery();
			// System.out.println("D");

			while (rs.next()) {
				// map.put(rs.getInt("playEventId"), rs.getString("playEvent"));
				PlayerEventDTO dto = new PlayerEventDTO();
				dto.setPlayerEvent(rs.getString("playerEvent"));
				dto.setPlayerEventId(rs.getInt("playerEventId"));
				list.add(dto);
			}

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			// try {
			// con.close();
			// } catch (SQLException e) {
			// System.out.println(e);
			// }
		}
		return list;
	}

	public ArrayList<ALineDTO> attackLineUp(String attackTeamFlag, int historyId) {
		int awayId = 0;
		int homeId = 0;
		int teamId = 0;

		sql = "SELECT hometeamId, awayteamId FROM playschedule WHERE historyId = ?";

		// System.out.println("E");
		try {
			stat = con.prepareStatement(sql);
			stat.setInt(1, historyId);
			ResultSet rs = stat.executeQuery();
			// System.out.println("F");
			if (rs.next()) {

				awayId = rs.getInt("awayteamId");
				homeId = rs.getInt("hometeamId");
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// try {
			// con.close();
			// } catch (SQLException e) {
			// System.out.println(e);
			// }
		}

		String homeTeam = "";
		String awayTeam = "";

		int hid = 0;
		String tempstr = "";
		System.out.println("Attack : " + attackTeamFlag);
		if (attackTeamFlag.equals("A")) {
			tempstr = "s.AwayTeamId";
		} else if (attackTeamFlag.equals("H")) {
			tempstr = "s.HomeTeamId";
		}

		sql = String
				.format("SELECT * FROM attackLineUP a INNER JOIN playschedule s ON a.historyId=s.historyId INNER JOIN player p ON a.playerId = p.playerId INNER JOIN team t ON %s = t.teamId WHERE s.historyId = ? AND p.teamId = ?",
						tempstr);
		System.out.println("ㅠㅠ : " + attackTeamFlag);
		if (attackTeamFlag.equals("A")) {
			teamId = awayId;
		} else if (attackTeamFlag.equals("H")) {
			teamId = homeId;
		}
		System.out.println("-- : " + teamId);
		try {
			// System.out.println("G");
			stat = con.prepareStatement(sql);
			stat.setInt(1, historyId);

			if (attackTeamFlag.equals("A")) {
				// stat.setString(1, "s.AwayTeamId");
				stat.setInt(2, awayId);
				teamId = awayId;
			} else if (attackTeamFlag.equals("H")) {
				// stat.setString(1, "s.HomeTeamId");
				stat.setInt(2, homeId);
				teamId = homeId;
			}

			ResultSet rs = stat.executeQuery();
			// System.out.println("H");

			while (rs.next()) {
				hid = rs.getInt("historyId");
			}
			System.out.println("TEST : " + hid);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// try {
			// con.close();
			// } catch (SQLException e) {
			// System.out.println(e);
			// }
		}

		sql = "SELECT p.playerId, p.playerName FROM attackLineUp a INNER JOIN player p ON p.PLAYERID = a.PLAYERID INNER JOIN team ON team.TEAMID = p.TEAMID WHERE a.historyId = ? AND p.playerkindname = '타자' AND p.teamid = ? ORDER BY a.updateTime ASC";

		String updteTime = "";
		System.out.printf("t : %d, h : %d\n", teamId, historyId);
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		ArrayList<ALineDTO> list = new ArrayList<ALineDTO>();

		try {
			// System.out.println("I");
			stat = con.prepareStatement(sql);
			stat.setInt(1, historyId);
			stat.setInt(2, teamId);
			ResultSet rs = stat.executeQuery();
			// System.out.println("J");
			while (rs.next()) {

				// map.put(rs.getInt("playerId"), rs.getString("playerName"));
				ALineDTO dto = new ALineDTO();
				dto.setPlayerId(rs.getInt("playerId"));
				dto.setPlayerName(rs.getString("playerName"));
				list.add(dto);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// try {
			// con.close();
			// } catch (SQLException e) {
			// System.out.println(e);
			// }
		}

		String pitcherName = "";
		int pitcherId = 0;

		sql = "SELECT p.playername, p.playerId FROM attackLineUp a INNER JOIN player p ON p.PLAYERID = a.PLAYERID INNER JOIN team ON team.TEAMID = p.TEAMID WHERE a.historyId = ? AND p.playerkindname = '투수' AND p.teamid = ? ";
		try {
			// System.out.println("K");
			stat = con.prepareStatement(sql);
			stat.setInt(1, historyId);
			stat.setInt(2, teamId);
			ResultSet rs = stat.executeQuery();
			// System.out.println("L");
			while (rs.next()) {

				// map.put(rs.getInt("pitcherId"), rs.getString("pitcherName"));
				ALineDTO dto = new ALineDTO();
				dto.setPlayerId(rs.getInt("playerId"));
				dto.setPlayerName(rs.getString("playerName"));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// try {
			// con.close();
			// } catch (SQLException e) {
			// System.out.println(e);
			// }
		}

		return list;
	}

	public ArrayList<KindEventDTO> getD() {
		ArrayList<KindEventDTO> list = new ArrayList<KindEventDTO>();
		sql = "SELECT * FROM kindPlayEvent WHERE kind = 'D'";
		// System.out.println("M");

		try {
			stat = con.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			// System.out.println("N");
			while (rs.next()) {

				KindEventDTO dto = new KindEventDTO();
				dto.setPlayerEvent(rs.getString("playerEvent"));
				dto.setPlayerEventId(rs.getInt("playerEventId"));
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	public void closeDB() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addEvent(ArrayList<EventDTO> elist, int hid, int playerSeq) {
		sql = "INSERT INTO playEvent (EventId, playerEventId, playerId, inning, historyId) VALUES (playerEventSeq.NEXTVAL, ?, ?, ?, ?)";

		try {
			stat = con.prepareStatement(sql);
			for (int i = 0; i < elist.size(); i++) {
				stat.setInt(1, elist.get(i).getPlayerEventId());
				stat.setInt(2, elist.get(i).getPlayerId());
				stat.setInt(3, elist.get(i).getInning());
				stat.setInt(4, hid);
				this.playerSeq[i] = playerSeq;
				stat.executeUpdate();
			}
			con.commit();
		} catch (Exception e) {
			System.out.println(e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println(e1);
			}
		}
	}

	public ArrayList<EventDTO> getEventList(int seq) {
		ArrayList<EventDTO> elist = new ArrayList<EventDTO>();

		sql = "SELECT e.PLAYEREVENTID, e.EVENTID, p.PLAYERID, p.PLAYERNAME, e.INNING, k.PLAYEREVENT FROM playEvent e INNER JOIN player p ON e.playerId = p.playerId INNER JOIN kindplayEvent k ON e.playerEventId = k.playerEventId WHERE eventId > ?";

		try {
			stat = con.prepareStatement(sql);
			stat.setInt(1, seq);
			ResultSet rs = stat.executeQuery();
			int i = 0;
			while (rs.next()) {
				EventDTO dto = new EventDTO();
				dto.setPlayerEventId(rs.getInt("playerEventId"));
				dto.setEventId(rs.getInt("eventId"));
				dto.setPlayerId(rs.getInt("playerId"));
				dto.setInning(rs.getInt("inning"));
				dto.setPlayerName(rs.getString("playerName"));
				dto.setPlayerEvent(rs.getString("playerEvent"));
				dto.setPlayerSeq(this.playerSeq[i]);
				elist.add(dto);
				if (++i >= 9) {
					i = 0;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

		return elist;
	}

	public void end(int hid) {
		sql = "UPDATE playSchedule SET status = 3";
		try {
			stat = con.prepareStatement(sql);
			stat.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
}
