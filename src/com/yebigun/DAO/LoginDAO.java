package com.yebigun.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yebigun.main.Util;
import com.yebigun.DTO.MemberDTO;

import oracle.jdbc.OracleTypes;

public class LoginDAO {
	Connection conn = null;
	CallableStatement stat = null;

	public LoginDAO() {
		// 어떤 업무를 위임받더라도 처음에 공통으로 해야하는 일 구현
		try {
			conn = Util.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MemberDTO logIn(String id, String pwd, int check) {
		String sql = null;
		MemberDTO loginDTO = new MemberDTO();
		try {
			if (check == 1)
				sql = "{ call searchOneManager(?,?) }";
			else if (check == 2)
				sql = "{ call searchOneLRT(?,?) }";

			stat = conn.prepareCall(sql);

			stat.setString(1, id);
			stat.registerOutParameter(2, OracleTypes.CURSOR);

			stat.executeQuery();
			ResultSet rs = null;
			rs = (ResultSet) stat.getObject(2);

			if (rs.next()) {
				if (rs.getString("name").equals(pwd)) {
					loginDTO.setSeq(rs.getString("seq"));
					loginDTO.setName(rs.getString("name"));
					loginDTO.setNum(rs.getString("num"));
					loginDTO.setSoldier(rs.getString("soldier"));
					loginDTO.setPseq(rs.getString("pseq"));
					loginDTO.setTseq(rs.getString("tseq"));
					loginDTO.setEndday(rs.getString("endday"));
				} else {
					System.out.println("아이디, 비밀번호 틀림.");
					loginDTO = null;
				}
			} else {
				loginDTO = null;
				System.out.println("아이디 없음");
			}
		} catch (Exception e) {
			System.out.println("###### Start.login #######");
			e.printStackTrace();
		}

		return loginDTO;
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("##### LoginDAO.close #####");
			e.printStackTrace();
		}
	}
}