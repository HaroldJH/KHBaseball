package com.bs.cast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bs.db.DBUtil;

public class PlayscheduleDAO {
	
	private String sql = "";
	private PreparedStatement stat = null;
	private Connection con = null;
	
	public ArrayList<PlayscheduleDTO> getSchedule() {
		ArrayList<PlayscheduleDTO> list = new ArrayList<PlayscheduleDTO>();
		sql = "SELECT p.historyId, TO_CHAR(p.playDate, 'yyyy-mm-dd') AS playDate, p.status, p.startTime, t.teamName AS away,t1.teamName AS home FROM playSchedule p INNER JOIN team t ON p.homeTeamId = t.teamId INNER JOIN team t1 ON p.awayTeamId = t1.teamId ORDER BY p.historyId ASC";
		
		try {
			con = DBUtil.connect();
			stat = con.prepareStatement(sql);
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				PlayscheduleDTO dto = new PlayscheduleDTO();
				dto.setHistoryId(rs.getInt("historyId"));
				dto.setPlayDate(rs.getString("playDate"));
				dto.setStatus(rs.getString("status"));
				dto.setStartTime(rs.getString("startTime"));
				dto.setAwayTeamId(rs.getString("away"));
				dto.setHomeTeamId(rs.getString("home"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}
}
