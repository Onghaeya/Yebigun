package com.yebigun.main;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 각종 도구모음 클래스
 * @author 박
 *
 */
public class Util {

	/**
	 * 오라클 서버에 접속하는 메소드
	 * @return 연결 컬렉션을 반환
	 */
	public static Connection open(){
		
		Connection conn = null;
		String url = "jdbc:oracle:thin:@211.63.89.46:1521:xe";
		String id = "dbrlxo";
		String pw = "java1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
			return conn;
		} catch (Exception e) {
			System.out.println("### Util.open ###");
			e.printStackTrace();
		}
		return null;
	}//open
}
