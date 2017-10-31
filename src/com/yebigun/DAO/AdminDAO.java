package com.yebigun.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yebigun.main.Util;
import com.yebigun.DTO.LrtDTO;
import com.yebigun.DTO.MemberDTO;

import oracle.jdbc.internal.OracleTypes;

public class AdminDAO {
	
	
	public List<LrtDTO> moneyCheck(MemberDTO loginDTO) {

		// 상태 확인후 둘다 예정,수료,미수료,수료중 경우 독촉장 발송
		// 상태 확인후 미수료 경우 독촉장 발송
		
		
		try {

			Connection conn = Util.open();
			String sql = "{call MONEYCHECK(?,?)}";
			CallableStatement stat = conn.prepareCall(sql);
			
			stat.setString(1, loginDTO.getName());
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet) stat.getObject(2);			
			List<LrtDTO> list = new ArrayList<LrtDTO>();
			
			while(rs.next()) {
				
				LrtDTO ldto = new LrtDTO();
				ldto.setName(rs.getString("name"));
				list.add(ldto);
				
			}
			rs.close();
			stat.close();
			conn.close();
			return list;

		} catch (Exception e) {
			System.out.println("#### AdminDAO.money ####");
			e.printStackTrace();
		}
		return null;
		
	}

	public List<LrtDTO> callSchedule(MemberDTO loginDTO) {

		// 예정 된 훈련이 있으면 그사람한테 보낸다...?
		// 자신의 부대에 소속된 예비군중 아직 상태가 예정인 사람을 찾아서 예비군 일정을 알려준다..?
		
		
		try {

			Connection conn = Util.open();
			String sql = "{call CALLSCHEDULE(?,?)}";
			CallableStatement stat = conn.prepareCall(sql);
			
			stat.setString(1, loginDTO.getName());
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			ResultSet rs = (ResultSet) stat.getObject(2);
			List<LrtDTO> list = new ArrayList<LrtDTO>();
			
			while (rs.next()){
				
				LrtDTO ldto = new LrtDTO();
				ldto.setName(rs.getString("name"));
				list.add(ldto);
				
			}
			rs.close();
			stat.close();
			conn.close();
			return list;
		} catch (Exception e) {
			System.out.println("#### AdminDAO.callSchedule ####");
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<LrtDTO> scheduleCheck(MemberDTO loginDTO) {

		System.out.println("훈련 일정 연기 신청 확인");
		
		try {
			
			Connection conn = Util.open();
			String sql = "{call scheduleCheck(?,?)}";
			CallableStatement stat = conn.prepareCall(sql);
			stat.setString(1, loginDTO.getSeq());
			stat.registerOutParameter(2, OracleTypes.CURSOR);

			stat.executeQuery();
			
			ResultSet rs = (ResultSet) stat.getObject(2);
			List<LrtDTO> list = new ArrayList<LrtDTO>();
			
			while(rs.next()) {
				
				String num = rs.getString("lseq");

				String sql1 = "{call moveCheck1(?,?)}";
				CallableStatement stat1 = conn.prepareCall(sql1);

				stat1.setString(1, num);
				stat1.registerOutParameter(2, OracleTypes.CURSOR);

				stat1.executeQuery();

				ResultSet rs1 = (ResultSet) stat1.getObject(2);

				while (rs1.next()) {
					
					LrtDTO ldto = new LrtDTO();
					ldto.setName(rs1.getString("name"));
					list.add(ldto);
					
				}
				rs1.close();
				stat1.close();
				
			}
			
			rs.close();
			stat.close();
			conn.close();
			return list;
		} catch (Exception e) {
			System.out.println("#### AdminDAO.scheduleCheck ####");
			e.printStackTrace();
		}
		return null;
		
	}

	public List<LrtDTO> moveCheck(MemberDTO loginDTO) {


		try {

			Connection conn = Util.open();
			String sql = "{call moveCheck(?,?)}";
			CallableStatement stat = conn.prepareCall(sql);
			stat.setString(1, loginDTO.getSeq());
			stat.registerOutParameter(2, OracleTypes.CURSOR);

			stat.executeQuery();

			ResultSet rs = (ResultSet) stat.getObject(2);
			List<LrtDTO> list = new ArrayList<LrtDTO>();
			
			while (rs.next()) {

				String num = rs.getString("lseq");
				String sql1 = "{call moveCheck1(?,?)}";
				CallableStatement stat1 = conn.prepareCall(sql1);

				stat1.setString(1, num);
				stat1.registerOutParameter(2, OracleTypes.CURSOR);

				stat1.executeQuery();

				ResultSet rs1 = (ResultSet) stat1.getObject(2);

				while (rs1.next()) {
					
					LrtDTO ldto = new LrtDTO();
					ldto.setName(rs1.getString("name"));
					ldto.setSeq(rs1.getString("seq"));
					list.add(ldto);
					
				}
				rs1.close();
				stat1.close();
				
			}
			rs.close();
			stat.close();
			conn.close();
			return list;
		} catch (Exception e) {
			System.out.println("#### AdminDAO.moveCheck ####");
			e.printStackTrace();
		}
		
		return null;
		
	}
	/**
	 * 전입 신청이 있을때 진행하는것
	 * @param list 
	 * @param loginDTO
	 */
	public void con(List<LrtDTO> list, MemberDTO loginDTO) {

		try {

			Connection conn = Util.open();
			String sql = "update lrt set tseq = ?,state = '완료' where seq = ?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, loginDTO.getTseq());
			stat.setString(2, list.get(0).getSeq());
			stat.executeUpdate();
			
			sql = "delete from lmmessage where meseq = 1 and mseq = ?";
			PreparedStatement stat1 = conn.prepareStatement(sql);
			stat1.setString(1, loginDTO.getSeq());
			stat1.executeQuery();
			

		} catch (Exception e) {
			System.out.println("#### AdminDAO.con ####");
			e.printStackTrace();
		}
		
	}

}
