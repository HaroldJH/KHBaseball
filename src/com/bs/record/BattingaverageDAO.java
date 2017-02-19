package com.bs.record;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bs.db.DBUtil;

public class BattingaverageDAO {
	
	private Statement stat = null;
	
	public BattingaverageDAO() {
		



		try {
			stat = DBUtil.connect().createStatement();

		} catch(Exception e){
			System.out.println("error : " + e.toString());
		}
	}
	
	
	public ArrayList<BattingaverageDTO> battingAverage() {
		ArrayList<BattingaverageDTO> list = new ArrayList<>();
		
		try {
			String sql = String.format("select * from (select a.*, rownum as rnum from (select to_char(avg(br.BattingAverage),'0.000') as BattingAverage, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by BattingAverage desc) a) where rnum <= 20");
			System.out.println(sql);//디버깅
			
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				BattingaverageDTO bdto =new BattingaverageDTO();
				bdto.setBattingaverage(rs.getString("battingAverage"));
				bdto.setPlayerName(rs.getString("playerName"));
				bdto.setTeamName(rs.getString("teamName"));
				bdto.setRnum(rs.getString("rnum"));
				
				list.add(bdto);
			}
		}catch(Exception e){
			System.out.println(e.toString());
		}

			return list;
	}
}
