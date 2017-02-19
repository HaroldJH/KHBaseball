package com.bs.record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bs.db.DBUtil;

public class HomerunsDAO {
	private Statement stat = null;	
	private Connection con = null;

	public HomerunsDAO() {
		try {
			stat = DBUtil.connect().createStatement();

		} catch(Exception e){
			System.out.println("error : " + e.toString());
		}
	}
	//홈런20등까지
	public ArrayList<HomerunsDTO> homeruns() {
		ArrayList<HomerunsDTO> list = new ArrayList<>();
		
		try {
			String sql = String.format("select * from(select a.*, rownum as rnum from (select sum(br.homerun) as homerun, p.playername, t.teamname from Batterrecord br inner join player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, p.playername, t.teamname order by homerun desc) a) where rnum <= 20");
			System.out.println(sql);//디버깅
			
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
				HomerunsDTO bdto =new HomerunsDTO();
				bdto.setHomeruns(rs.getString("homerun"));
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
