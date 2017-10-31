package com.yebigun.DTO;

public class MemberDTO {
	
	private String seq; // 번호
	private String name; // 이름
	private String num; // 군번
	private String soldier; // 군
	private String pseq; // 주특기
	private String tseq; // 부대
	private String endday; // 전역일
	
	public String getEndday() {
		return endday;
	}
	public void setEndday(String endday) {
		this.endday = endday;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getSoldier() {
		return soldier;
	}
	public void setSoldier(String soldier) {
		this.soldier = soldier;
	}
	public String getPseq() {
		return pseq;
	}
	public void setPseq(String pseq) {
		this.pseq = pseq;
	}
	public String getTseq() {
		return tseq;
	}
	public void setTseq(String tseq) {
		this.tseq = tseq;
	}
	
}
