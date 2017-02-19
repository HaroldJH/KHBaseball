package com.bs.model;

public class MemberDTO {
	
	private int memberId; //회원id
	private int teamId; //팀 id (구단 관계자만)
	private String memberName; //회원 명
	private String passCode; //비밀번호
	private String dateOfBirth; //생년원일
	private String memberEmail; //이메일
	private String memberPhone; //연락처
	private String memberKind; //맴버 종류
	
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPassCode() {
		return passCode;
	}
	public void setPassCode(String passCode) {
		this.passCode = passCode;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberKind() {
		return memberKind;
	}
	public void setMemberKind(String memberKind) {
		this.memberKind = memberKind;
	}
	
	
}
