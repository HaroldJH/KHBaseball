package com.bs.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bs.db.DBUtil;

public class ScoutListDAO {
	//데이터베이스 작업 전담 클래스
		
		private Statement stat = null;

		//초기화 작업 - 생성
		public ScoutListDAO() {
			try {
				stat = DBUtil.connect().createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
		//방어율 영입 추천 리스트 정보 가져오기
		public ArrayList<ScoutListDTO> plist(String col, String team, String prSalary){
			ArrayList<ScoutListDTO> plist = new ArrayList<ScoutListDTO>();
			
			if(team.equals("lg")){
				team = "LG";
			}
			String prSalaryWhere = "";
			
			if (prSalary != null) {
				if (prSalary.equals("1hm")) {
					prSalaryWhere = " and salary < 10000 ";
				} else if(prSalary.equals("13hm")) {
					prSalaryWhere = " and salary >= 10000 and salary <= 30000 ";
				} else if(prSalary.equals("3hm")) {
					prSalaryWhere = " and salary > 30000 ";
				} 
				
				
			}
			
			try{
				String sql = "";
				
				if (!team.equals("무소속")) {
					//System.out.println("!empty");
					sql = String.format("select p.salary, p.playerId, p.playerName, sum(pr.pWin) as pWin, sum(pr.pLose) as pLose, sum(pr.pSave) as pSave, sum(pr.pHold) as pHold, sum(pr.pInning) as pInning, sum(pr.pAnts) as pAnta, sum(pr.pHomerun) as pHomerun, sum(pr.pBallnet) as pBallnet, sum(pr.pSamjin) as pSamjin, sum(pr.pJacheck) as pJacheck, to_char(avg(pr.pBangEo),'90.00') as pBangEo, to_char(avg(pr.WHIP),'90.00') as WHIP from player p inner join   pitcherRecord pr on p.playerId = pr.playerId inner join team t on p.teamId = t.teamId where (select avg(pbangeo) from Pitcherrecord where playerId = p.playerId) <= (select pbangeo from (select a.*, rownum as rnum from (select to_char(avg(pr.pbangeo),'90.00') as pbangeo, t.teamname from pitcherRecord pr inner join  player p on p.playerId = pr.playerId inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by avg(pr.pbangeo) asc)a) where rnum >= 3 and teamname = '롯데') and teamname = '%s' %s group by p.playername, p.playerId, p.salary order by %s asc, salary asc", team, prSalaryWhere, col);
				} else {
					//System.out.println("empty");
					sql = String.format("select p.salary, p.playerId, p.playerName, sum(pr.pWin) as pWin, sum(pr.pLose) as pLose, sum(pr.pSave) as pSave, sum(pr.pHold) as pHold, sum(pr.pInning) as pInning, sum(pr.pAnts) as pAnta, sum(pr.pHomerun) as pHomerun, sum(pr.pBallnet) as pBallnet, sum(pr.pSamjin) as pSamjin, sum(pr.pJacheck) as pJacheck, to_char(avg(pr.pBangEo),'90.00') as pBangEo, to_char(avg(pr.WHIP),'90.00') as WHIP from player p inner join   pitcherRecord pr on p.playerId = pr.playerId inner join team t on p.teamId = t.teamId where (select avg(pbangeo) from Pitcherrecord where playerId = p.playerId) <= (select pbangeo from (select a.*, rownum as rnum from (select to_char(avg(pr.pbangeo),'90.00') as pbangeo, t.teamname from pitcherRecord pr inner join  player p on p.playerId = pr.playerId inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by avg(pr.pbangeo) asc)a) where rnum >= 3 and teamname = '롯데') and t.teamid is null %s group by p.playername, p.playerId, p.salary order by %s asc, salary asc", prSalaryWhere, col);
				}
				
				System.out.println(sql);
				
				ResultSet rs = stat.executeQuery(sql);


				while(rs.next()){
					ScoutListDTO dto = new ScoutListDTO();
					dto.setPlayerId(rs.getString("playerId"));
					dto.setPlayerName(rs.getString("playerName"));
					dto.setpWin(rs.getInt("pWin"));
					dto.setpLose(rs.getInt("pLose"));
					dto.setpSave(rs.getInt("pSave"));
					dto.setpHold(rs.getInt("pHold"));
					dto.setpInning(rs.getDouble("pInning"));
					dto.setpAnta(rs.getInt("pAnta"));
					dto.setpHomerun(rs.getInt("pHomerun"));
					dto.setpBallnet(rs.getInt("pBallnet"));
					dto.setpSamjin(rs.getInt("pSamjin"));
					dto.setpBangEo(rs.getDouble("pBangEo"));
					dto.setWhip(rs.getDouble("whip"));
					
					plist.add(dto);
				}
			} catch (Exception e) {
				System.out.println("p : " + e.toString());
			}
			
			return plist;
		}//plist()<=투수리스트
		
		
		//타율 영입 추천 리스트 정보 가져오기
		public ArrayList<ScoutListDTO> hlist(String col, String team, String prSalary){
			ArrayList<ScoutListDTO> hlist = new ArrayList<ScoutListDTO>();
			
			String prSalaryWhere = "";
			if(team.equals("lg")){
				team = "LG";
			}
			
			
			if (prSalary != null) {
				if (prSalary.equals("1hm")) {
					prSalaryWhere = " and salary < 10000 ";
				} else if(prSalary.equals("13hm")) {
					prSalaryWhere = " and salary >= 10000 and salary <= 30000 ";
				} else if(prSalary.equals("3hm")) {
					prSalaryWhere = " and salary > 30000 ";
				} 
			}
			
			
			try{
				
				String sql = "";
				

				if(!team.equals("무소속")){	
					if (col.equals("battingAverage")) {
						sql = String.format("select p.salary, p.playerId as playerId, p.playerName as playerName, sum(br.atBat) as atBat, sum(br.hits) as hits, sum(br.homeRun) as homeRun, sum(br.still) as still, sum(br.samjin) as samjin, sum(br.fourball) as fourball, to_char(avg(br.battingAverage), '0.000') as battingAverage, to_char(avg(br.onBase), '0.000') as onBase, to_char(avg(br.slugging), '0.000') as slugging, to_char(avg(br.ops), '0.000') as ops, sum(br.error) as error from Batterrecord br inner join  player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId where (select avg(BattingAverage) from Batterrecord where playerId = p.playerId) >= (select BattingAverage from (select a.*, rownum as rnum from (select to_char(avg(br.BattingAverage),'0.000') as BattingAverage, t.teamname from Batterrecord br inner join  player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by avg(br.BattingAverage) desc)a) where rnum >= 3 and teamname = '롯데') and teamname = '%s' %s group by p.playername, p.playerId, p.salary order by %s desc, salary asc",team, prSalaryWhere, col);
					} else if (col.equals("onBase")) {
						sql = String.format("select p.salary, p.playerId as playerId, p.playerName as playerName, sum(br.atBat) as atBat, sum(br.hits) as hits, sum(br.homeRun) as homeRun, sum(br.still) as still, sum(br.samjin) as samjin, sum(br.fourball) as fourball, to_char(avg(br.battingAverage), '0.000') as battingAverage, to_char(avg(br.onBase), '0.000') as onBase, to_char(avg(br.slugging), '0.000') as slugging, to_char(avg(br.ops), '0.000') as ops, sum(br.error) as error from Batterrecord br inner join  player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId where (select avg(OnBase) from Batterrecord where playerId = p.playerId) >= (select OnBase from (select a.*, rownum as rnum from (select to_char(avg(br.OnBase),'0.000') as OnBase, t.teamname from Batterrecord br inner join  player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by avg(br.OnBase) desc)a) where rnum >= 3 and teamname = '롯데') and teamname = '%s' %s group by p.playername, p.playerId, p.salary order by %s desc,  salary asc",team, prSalaryWhere, col);
					} else if(col.equals("slugging")){
						sql = String.format("select p.salary, p.playerId as playerId, p.playerName as playerName, sum(br.atBat) as atBat, sum(br.hits) as hits, sum(br.homeRun) as homeRun, sum(br.still) as still, sum(br.samjin) as samjin, sum(br.fourball) as fourball, to_char(avg(br.battingAverage), '0.000') as battingAverage, to_char(avg(br.onBase), '0.000') as onBase, to_char(avg(br.slugging), '0.000') as slugging, to_char(avg(br.ops), '0.000') as ops, sum(br.error) as error from Batterrecord br inner join  player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId where (select avg(Slugging) from Batterrecord where playerId = p.playerId) >= (select Slugging from (select a.*, rownum as rnum from (select to_char(avg(br.Slugging),'0.000') as Slugging, t.teamname from Batterrecord br inner join  player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by avg(br.Slugging) desc)a) where rnum >= 3 and teamname = '롯데') and teamname = '%s' %s group by p.playername, p.playerId, p.salary order by %s desc, salary asc", team, prSalaryWhere, col);
					} else if(col.equals("still")){
						sql = String.format("select p.salary, p.playerId as playerId, p.playerName as playerName, sum(br.atBat) as atBat, sum(br.hits) as hits, sum(br.homeRun) as homeRun, sum(br.still) as still, sum(br.samjin) as samjin, sum(br.fourball) as fourball, to_char(avg(br.battingAverage), '0.000') as battingAverage, to_char(avg(br.onBase), '0.000') as onBase, to_char(avg(br.slugging), '0.000') as slugging, to_char(avg(br.ops), '0.000') as ops, sum(br.error) as error from Batterrecord br inner join  player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId where (select sum(Still) from Batterrecord where playerId = p.playerId) >= (select Still from (select a.*, rownum as rnum from (select sum(br.Still) as Still, t.teamname from Batterrecord br inner join  player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by sum(br.Still) desc)a) where rnum >= 3 and teamname = '롯데') and teamname = '%s' %s group by p.playername, p.playerId, p.salary order by %s desc, salary asc", team, prSalaryWhere, col);
					} else if(col.equals("error")){
						sql = String.format("select p.salary, p.playerId as playerId, p.playerName as playerName, sum(br.atBat) as atBat, sum(br.hits) as hits, sum(br.homeRun) as homeRun, sum(br.still) as still, sum(br.samjin) as samjin, sum(br.fourball) as fourball, to_char(avg(br.battingAverage), '0.000') as battingAverage, to_char(avg(br.onBase), '0.000') as onBase, to_char(avg(br.slugging), '0.000') as slugging, to_char(avg(br.ops), '0.000') as ops, sum(br.error) as error from Batterrecord br inner join  player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId where (select sum(Error) from Batterrecord where playerId = p.playerId) <= (select Error from (select a.*, rownum as rnum from (select sum(br.Error) as Error, t.teamname from Batterrecord br inner join  player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by sum(br.Error) asc)a) where rnum >= 3 and teamname = '롯데') and teamname = '%s' %s group by p.playername, p.playerId, p.salary order by Error asc, salary asc", team, prSalaryWhere, col);
					}
				} else {
					
					
					if (col.equals("battingAverage")) {
						sql = "select p.playerName, sum(br.atBat) as atBat, sum(br.hits) as hits, sum(br.homeRun) as homeRun, sum(br.still) as still, sum(br.samjin) as samjin, sum(br.fourball) as fourball, to_char(avg(br.battingAverage), '0.000') as battingAverage, to_char(avg(br.onBase), '0.000') as onBase, to_char(avg(br.slugging), '0.000') as slugging, to_char(avg(br.ops), '0.000') as ops, sum(br.error) as error from Batterrecord br inner join  player p on p.playerId = br.playerId where p.teamId is null group by p.playerName order by onBase desc";
					} else if (col.equals("onBase")) {
						sql = "select p.playerName, sum(br.atBat) as atBat, sum(br.hits) as hits, sum(br.homeRun) as homeRun, sum(br.still) as still, sum(br.samjin) as samjin, sum(br.fourball) as fourball, to_char(avg(br.battingAverage), '0.000') as battingAverage, to_char(avg(br.onBase), '0.000') as onBase, to_char(avg(br.slugging), '0.000') as slugging, to_char(avg(br.ops), '0.000') as ops, sum(br.error) as error from Batterrecord br inner join  player p on p.playerId = br.playerId where p.teamId is null group by p.playerName order by onBase desc";
					} else if(col.equals("slugging")){
						sql = "select p.playerName, sum(br.atBat) as atBat, sum(br.hits) as hits, sum(br.homeRun) as homeRun, sum(br.still) as still, sum(br.samjin) as samjin, sum(br.fourball) as fourball, to_char(avg(br.battingAverage), '0.000') as battingAverage, to_char(avg(br.onBase), '0.000') as onBase, to_char(avg(br.slugging), '0.000') as slugging, to_char(avg(br.ops), '0.000') as ops, sum(br.error) as error from Batterrecord br inner join  player p on p.playerId = br.playerId where p.teamId is null group by p.playerName order by onBase desc";
					} else if(col.equals("still")){
						sql = "select p.playerName, sum(br.atBat) as atBat, sum(br.hits) as hits, sum(br.homeRun) as homeRun, sum(br.still) as still, sum(br.samjin) as samjin, sum(br.fourball) as fourball, to_char(avg(br.battingAverage), '0.000') as battingAverage, to_char(avg(br.onBase), '0.000') as onBase, to_char(avg(br.slugging), '0.000') as slugging, to_char(avg(br.ops), '0.000') as ops, sum(br.error) as error from Batterrecord br inner join  player p on p.playerId = br.playerId where p.teamId is null group by p.playerName order by onBase desc";
					} else if(col.equals("error")){
						sql = "select p.playerName, sum(br.atBat) as atBat, sum(br.hits) as hits, sum(br.homeRun) as homeRun, sum(br.still) as still, sum(br.samjin) as samjin, sum(br.fourball) as fourball, to_char(avg(br.battingAverage), '0.000') as battingAverage, to_char(avg(br.onBase), '0.000') as onBase, to_char(avg(br.slugging), '0.000') as slugging, to_char(avg(br.ops), '0.000') as ops, sum(br.error) as error from Batterrecord br inner join  player p on p.playerId = br.playerId where p.teamId is null group by p.playerName order by onBase desc";
					}
					System.out.println("sqltest1 = " + sql);
				}
				
				System.out.println("sqltest2 = " + sql);
				
				ResultSet rs = stat.executeQuery(sql);
				
				
				while(rs.next()){
					ScoutListDTO dto = new ScoutListDTO();
					dto.setPlayerId(rs.getString("playerId"));
					dto.setPlayerName(rs.getString("playerName"));
					dto.setAtBat(rs.getInt("atBat"));
					dto.setHits(rs.getInt("hits"));
					dto.setHomeRun(rs.getInt("homeRun"));
					dto.setStill(rs.getInt("still"));
					dto.setSamJin(rs.getInt("samJin"));
					dto.setFourBall(rs.getInt("fourBall"));
					dto.setBattingAverage(rs.getDouble("battingAverage"));
					dto.setOnBase(rs.getDouble("onBase"));
					dto.setSlugging(rs.getDouble("slugging"));
					dto.setOps(rs.getDouble("ops"));
					dto.setError(rs.getInt("error"));					
									
					
					hlist.add(dto);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			 
			return hlist;
		}//hlist()<=타자리스트

		//단점 :방어율
		public int getpBangEo(String teamId) {
			
			int pBangEo = 0;
			
			try {
			
				String sql = String.format("select count(pbangeo) as cnt from (select a.*, rownum as rnum from (select to_char(avg(pr.pbangeo),'90.00') as pbangeo, t.teamname from pitcherRecord pr inner join  player p on p.playerId = pr.playerId inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by pbangeo asc)a) where rnum >= 3 and teamname='%s'", teamId);
			
				ResultSet rs = stat.executeQuery(sql);
				
				if(rs.next()){
					pBangEo = rs.getInt("cnt");
				}
				
			} catch (Exception e) {
				
				System.out.println(e.toString());
				
			}
			
			return pBangEo;
		}
		
		//단점 : 타율
		public int getBattingAverage(String teamId) {

			int BattingAverage = 0;
			if(teamId.equals("sk")){
				teamId = "SK";
			}
			try {
				String sql = String.format("select count(battingAverage) as cnt from (select a.*, rownum as rnum from (select to_char(avg(br.BattingAverage),'0.000') as BattingAverage, t.teamname from Batterrecord br inner join  player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by BattingAverage desc)a) where rnum >= 3 and teamname='%s'", teamId);
				
				ResultSet rs = stat.executeQuery(sql);
				
				if(rs.next()){
					BattingAverage = rs.getInt("cnt");					
				}
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			return BattingAverage;
		}

		//단점 : 출루율
		public int getOnBase(String teamId) {
			
			int OnBase = 0;
			
			try {
				
				String sql = String.format("select count(OnBase) as cnt from (select a.*, rownum as rnum from (select to_char(avg(br.OnBase),'0.000') as OnBase, t.teamname from Batterrecord br inner join  player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by OnBase desc)a) where rnum >= 3 and teamname='%s'", teamId);
				
				ResultSet rs = stat.executeQuery(sql);
				
				if(rs.next()){
					OnBase = rs.getInt("cnt");
				}
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			return OnBase;
		}

		//단점:장타율
		public int getSlugging(String teamId) {

			int Slugging = 0;
			
			try {
				String sql = String.format("select count(Slugging) as cnt from (select a.*, rownum as rnum from (select to_char(avg(br.Slugging),'0.000') as Slugging, t.teamname from Batterrecord br inner join  player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by Slugging desc)a) where rnum >= 3 and teamname='%s'", teamId);
				
				ResultSet rs = stat.executeQuery(sql);
				
				if(rs.next()){
					Slugging = rs.getInt("cnt");
				}
								
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			return Slugging;
		}

		//단점:도루
		public int getStill(String teamId) {

			int Still = 0;
			
			try {
				
				String sql = String.format("select count(Still) as cnt from (select a.*, rownum as rnum from (select sum(br.Still) as Still, t.teamname from Batterrecord br inner join  player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by Still desc)a) where rnum >= 3 and teamname='%s'", teamId);
				
				ResultSet rs = stat.executeQuery(sql);
				
				if(rs.next()){
					Still = rs.getInt("cnt");
				}
						
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			return Still;
		}

		//단점:실책
		public int getError(String teamId) {

			int Error = 0;
			
			try {
				
				String sql = String.format("select count(Error) as cnt from (select a.*, rownum as rnum from (select sum(br.Error) as Error, t.teamname from Batterrecord br inner join  player p on p.playerId = br.playerId inner join team t on p.teamId = t.teamId group by t.teamId, t.teamname order by Error asc)a) where rnum >= 3 and teamname='%s'", teamId);
				
				ResultSet rs = stat.executeQuery(sql);
				
				if(rs.next()){
					Error=rs.getInt("cnt");
				}
				
			} catch (Exception e) {
				System.out.println(e.toString());	
			}	
			
			return Error;
		}

		public void move(String hch, String hteam) {
			try {
				
				String sql = String.format("update player set teamid = %s where playerid = %s", hteam, hch);
				stat.executeUpdate(sql);
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		
		
		
}










