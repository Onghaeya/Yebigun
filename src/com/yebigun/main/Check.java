package com.yebigun.main;

/**
 * 유효성 검사 도구모음 클래스
 * @author 박
 *
 */
public class Check {
	
	/**
	 * 날짜 확인 메소드
	 * @param yymmdd 확인받을 문자열 입력
	 * @return 확인 결과를 true/false로 반환
	 */
	public static boolean YYMMDD(String yymmdd){
		if (yymmdd.length()<7 && Integer.parseInt(yymmdd.substring(0, 2))<20 && Integer.parseInt(yymmdd.substring(0, 2))>16 &&
				Integer.parseInt(yymmdd.substring(2, 4))<13 && Integer.parseInt(yymmdd.substring(2, 4))>0 &&
				Integer.parseInt(yymmdd.substring(4, 6))<32 && Integer.parseInt(yymmdd.substring(4, 6))>0) {
			return true;
		} else {
			return false;
		}
	}
}
