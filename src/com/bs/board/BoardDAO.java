package com.bs.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bs.board.BoardDTO;
import com.bs.db.DBUtil;
public class BoardDAO {

	private Statement stat = null;	
	private Connection con = null;

	public BoardDAO() {
		try {
			stat = DBUtil.connect().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}  
	public void add(BoardDTO dto) {
		try {
			String sql = String.format("insert into Notice (seq,memberid,subject,content,writeDate,read) values (noticeSeq.nextval, 1,'%s','%s',default,default)",dto.getTitle(),dto.getContent());
			System.out.println(sql);

			stat.executeUpdate(sql);

		}catch(Exception e){
			System.out.println(e.toString());
		}


	}
	public ArrayList<BoardDTO> list(){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			String sql= String.format("select m.teamId, m.memberName, n.seq, n.memberId, n.subject, n.content, n.writeDate, n.read from notice n inner join member m on n.memberId = m.memberId order by seq desc");
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {	//teamId, memberName, 
				BoardDTO dto = new BoardDTO();
				dto.setNoticeId(rs.getString("seq"));
				dto.setMemberId(rs.getString("memberId"));
				dto.setTitle(rs.getString("subject"));
				dto.setWriteDate(rs.getDate("writeDate"));
				dto.setRead(rs.getString("read"));
				dto.setMemberName(rs.getString("memberName"));
				dto.setTeamId(rs.getString("teamId"));
				list.add(dto);

			}

			System.out.println(list.size());
		} catch (Exception e) {
			System.out.println("리스트에러"+e.toString());
		}


		return list;

	}

	public void addCount(String noticeId) {
		try {
			String sql = "update notice set read= read + 1 where noticeId = " +	noticeId;



			stat.executeUpdate(sql);

		} catch (Exception e) {

			System.out.println("dd"+e.toString());
		}

	}

	public BoardDTO view(String noticeId) {
		BoardDTO dto=new BoardDTO();

		try{

			String sql= String.format("select m.teamId, m.memberName,"
					+ " n.seq, n.memberId, n.subject, n.content,"
					+ " n.writeDate, n.read from notice n "
					+ "inner join member m on n.memberId = m.memberId"
					+ " where seq=%s", noticeId);
			System.out.println(sql);
			
			ResultSet rs = stat.executeQuery(sql);

			if(rs.next()) {
				dto.setTeamId(rs.getString("teamId"));
				dto.setMemberName(rs.getString("memberName"));
			    dto.setNoticeId(rs.getString("seq"));
				dto.setMemberId(rs.getString("memberId"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setWriteDate(rs.getDate("writeDate"));
				dto.setRead(rs.getString("read"));
			}


		} catch(Exception e) {
			System.out.println("view 에러"+e.toString());
		}


		return dto;

	}
	
	public void edit(BoardDTO dto) {
		try{
			String sql = String.format("update notice set memberId = '%s',title = '%s',content = '%s' where noticeId = %s ",
			dto.getMemberId(),
			dto.getTitle(),
			dto.getContent(),
			dto.getNoticeId());
			stat.executeUpdate(sql);
			
		}catch(Exception e){
			System.out.println("수정에러"+e.toString());
		}
		
		
	}
}

























