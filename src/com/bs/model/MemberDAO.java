package com.bs.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bs.db.DBUtil;

public class MemberDAO { //회원 관련 DAO
	
	private Connection con = null;
	private Statement stat = null;
	
	public MemberDAO() {
		
		
		try{
			//DB연결		
			stat = DBUtil.connect().createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String login(String id, String pw) {
		String result = null;
		
		try {
			
			String sql = String.format("select teamId"
					+ " from member where"
					+ " memberName='%s' and passcode='%s'", id, pw);
			
			ResultSet rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				
				result = rs.getString("teamId");
			}else {
				System.out.println("오류");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}