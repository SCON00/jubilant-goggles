package com.metro.domain;

public class CsVO {
	
	// ##### notice_start #####
	private String nid;
	private String ntitle;
	private String ncontent;
	private String ndate;
	private String lno;
	private int cnt;
	
	// ===== setter =====
	public void setNid(String nid) {
		this.nid = nid;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public void setNdate(String ndate) {
		this.ndate = ndate;
	}
	public void setLno(String lno) {
		this.lno = lno;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	// ===== getter =====
	public String getNid() {
		return nid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public String getNdate() {
		return ndate;
	}
	public String getLno() {
		return lno;
	}
	public int getCnt() {
		return cnt;
	}
	// ##### notice_end #####
	
	
	// ##### QA_start #####
	private String qid;
	private String qcontent;
	private String qfile;
	private String qemail;
	private String category;
	private String state;
	private String mid;
	private String qdate;

	// ----- setter -----
	public void setQid(String qid) {
		this.qid = qid;
	}
	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}
	public void setQfile(String qfile) {
		this.qfile = qfile;
	}
	public void setQemail(String qemail) {
		this.qemail = qemail;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public void setQdate(String qdate) {
		this.qdate = qdate;
	}
	
	// ----- getter -----
	public String getQid() {
		return qid;
	}
	public String getQcontent() {
		return qcontent;
	}
	public String getQfile() {
		return qfile;
	}
	public String getQemail() {
		return qemail;
	}
	public String getCategory() {
		return category;
	}
	public String getState() {
		return state;
	}
	public String getMid() {
		return mid;
	}
	public String getQdate() {
		return qdate;
	}
	// ##### QA_end #####
}
