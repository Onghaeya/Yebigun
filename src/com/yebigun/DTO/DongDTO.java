package com.yebigun.DTO;

public class DongDTO {
	
	private String ostate ; // 동미참인 경우 필증 발급을 위해 데이터 확인을 위한 변수
	private String sstate ; // 동원 인 경우 필증 발급을 위해 데이터 확인을 위한 변수
	
	public String getOstate() {
		return ostate;
	}
	public void setOstate(String ostate) {
		this.ostate = ostate;
	}
	public String getSstate() {
		return sstate;
	}
	public void setSstate(String sstate) {
		this.sstate = sstate;
	}

}
