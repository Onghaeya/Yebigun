package com.yebigun.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yebigun.main.Util;
import com.yebigun.DTO.AllmobilscheduleDTO;
import com.yebigun.DTO.DongDTO;
import com.yebigun.DTO.MemberDTO;
import com.yebigun.DTO.YebDTO;
import com.yebigun.DTO.mytroopsDTO;

import oracle.jdbc.OracleTypes;

public class YebigunDAO {

	public List<AllmobilscheduleDTO> schduleList(MemberDTO loginDTO) {

		try {

			Connection conn = Util.open();
			String sql = "{call schduleList(?,?)}";
			CallableStatement stat = conn.prepareCall(sql);

			stat.setString(1, loginDTO.getNum());
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			stat.executeQuery();

			ResultSet rs = (ResultSet) stat.getObject(2);
			List<AllmobilscheduleDTO> list = new ArrayList<AllmobilscheduleDTO>();

			while (rs.next()) {

				AllmobilscheduleDTO adto = new AllmobilscheduleDTO();
				adto.setStartday(rs.getString("st"));
				adto.setEndday(rs.getString("en"));
				adto.setName(rs.getString("name"));
				list.add(adto);

			}

			rs.close();
			stat.close();
			conn.close();
			return list;

		} catch (Exception e) {
			System.out.println("#### YebigunDAO.schduleList ####");
			e.printStackTrace();
		}

		return null;

	}

	public List<YebDTO> moveCall(MemberDTO loginDTO) {

		try {

			Connection conn = Util.open();
			String sql = "{call MOVECALL(?,?)}";
			CallableStatement stat = conn.prepareCall(sql);

			stat.setString(1, loginDTO.getNum());
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			stat.executeQuery();

			ResultSet rs = (ResultSet) stat.getObject(2);
			List<YebDTO> list = new ArrayList<YebDTO>();

			while (rs.next()) {

				YebDTO tdto = new YebDTO();
				tdto.setCity(rs.getString("city"));
				list.add(tdto);

			}

			rs.close();
			stat.close();
			conn.close();
			return list;

		} catch (Exception e) {
			System.out.println("#### YebigunDAO.moveCheck ####");
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 전입신고 지역 이동
	 * 
	 * @param loginDTO
	 *            // 로그인 한 사람의 데이터
	 * @param location
	 *            // 희망 하는 지역
	 */
	public void loChange(MemberDTO loginDTO, String location) {

		try {
			Connection conn = Util.open();
			String sql = "update lrt set state = '전입중' where seq = ?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, loginDTO.getSeq());
			System.out.println(loginDTO.getSeq());
			stat.executeUpdate();
		

			sql = "select seq from loc where city = ?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, location);
			ResultSet rs = stat.executeQuery();

			if (rs.next()) {
				String seq = rs.getString("seq");
				String sqll = "insert into lmmessage values(lmmessageseq.nextval,'전입신고',default,?,?,1)";
				stat = conn.prepareStatement(sqll);
				stat.setString(1, loginDTO.getSeq());
				stat.setString(2, seq);
				stat.executeUpdate();
			}

			stat.close();
			rs.close();
			conn.close();
			System.out.println("신청 성공");

		} catch (Exception e) {
			System.out.println("#### YebigunDAO.loChange ####");
			e.printStackTrace();
		}

	}

	public List<mytroopsDTO> myPlace(MemberDTO loginDTO) {

		try {

			Connection conn = Util.open();
			String sql = "SELECT * FROM MYTROOPS WHERE NUM = ?";
			PreparedStatement stat = conn.prepareStatement(sql);

			stat.setString(1, loginDTO.getNum());
			ResultSet rs = stat.executeQuery();
			List<mytroopsDTO> list = new ArrayList<mytroopsDTO>();

			while (rs.next()) {

				mytroopsDTO mdto = new mytroopsDTO();
				mdto.setCommander(rs.getString("commander"));
				mdto.setMark(rs.getString("mark"));
				mdto.setName(rs.getString("name"));
				mdto.setTel(rs.getString("tel"));
				mdto.setPlace(rs.getString("place"));
				mdto.setMname(rs.getString("mname"));
				mdto.setNum(rs.getString("NUM"));
				list.add(mdto);

			}

			return list;

		} catch (Exception e) {
			System.out.println("#### YebigunDAO.myPlace ####");
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 동원인지 동미참인지 구분하여 다른 프로시저를 실행하여준다.
	 * @param loginDTO
	 * @return
	 */
	public DongDTO check(MemberDTO loginDTO) {

		try {

			Connection conn = Util.open();

			// 동원, 동미참 구분
			// 동원 인애들은 동미참에 데이터 값이 존재 하지 않는다.

			String sql = "SELECT * FROM PIL WHERE NUM = ?"; // 동원인 애들은 데이터가 존재
															// 하지 않는다.
			PreparedStatement stat = conn.prepareStatement(sql);
			String num = loginDTO.getNum();
			stat.setString(1, num);
			ResultSet rs = stat.executeQuery();

			if (rs.next()) { // 데이터가 존재 하면 '동미참' 인 인원

				DongDTO ddto = new DongDTO();
				ddto.setOstate(rs.getString("ostate"));
				ddto.setSstate(rs.getString("sstate"));
				return ddto;

			} else { // '동원' 인 인원

				sql = "SELECT * FROM PILD WHERE NUM = ?";
				stat = conn.prepareStatement(sql);
				stat.setString(1, num);
				rs = stat.executeQuery();

				if (rs.next()) {

					DongDTO ddto = new DongDTO();
					ddto.setSstate(rs.getString("sstate"));
					return ddto;

				}

			}

		} catch (Exception e) {
			System.out.println("#### YebigunDAO.check ####");
			e.printStackTrace();
		}

		return null;
	}

}
