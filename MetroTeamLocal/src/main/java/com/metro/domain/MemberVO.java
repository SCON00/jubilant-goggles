package com.metro.domain;

public class MemberVO {

	private String memberId;
	private String memberMail;
	private String memberPhone;
	private String memberPass;
	private String memberName;
	private String memberIntro;
	private String memberDate;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberID) {
		this.memberId = memberID;
	}
	public String getMemberMail() {
		return memberMail;
	}
	public void setMemberMail(String memberMail) {
		this.memberMail = memberMail;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberPass() {
		return memberPass;
	}
	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberIntro() {
		return memberIntro;
	}
	public void setMemberIntro(String memberIntro) {
		this.memberIntro = memberIntro;
	}
	public String getMemberDate() {
		return memberDate;
	}
	public void setMemberDate(String memberDate) {
		this.memberDate = memberDate;
	}
	@Override
	public String toString() {
		return "MemberVO [" + (memberId != null ? "memberId=" + memberId + ", " : "")
				+ (memberMail != null ? "memberMail=" + memberMail + ", " : "")
				+ (memberPhone != null ? "memberPhone=" + memberPhone + ", " : "")
				+ (memberPass != null ? "memberPass=" + memberPass + ", " : "")
				+ (memberName != null ? "memberName=" + memberName + ", " : "")
				+ (memberIntro != null ? "memberIntro=" + memberIntro + ", " : "")
				+ (memberDate != null ? "memberDate=" + memberDate : "") + "]";
	}
	
	
}
