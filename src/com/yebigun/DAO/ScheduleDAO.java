package com.yebigun.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yebigun.DTO.AllmobilscheduleDTO;
import com.yebigun.DTO.MobilScheduleDTO;
import com.yebigun.main.UI;
import com.yebigun.main.Util;

/**
 * 
 * @author 박
 *
 */
public class ScheduleDAO {
	
	private Connection conn;
	
	public ScheduleDAO() {
		try {
			conn = Util.open(); 
		} catch (Exception e) {
			System.out.println("### AdminDAO.AdminDAO ###");
			e.printStackTrace();
		}
	}//Constructor
	
	public List<AllmobilscheduleDTO> ScheduleListAll() {
		try {
			String sql = "select * from ALLMOBILSCHEDULE";	//전체목록
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			List<AllmobilscheduleDTO> list = new ArrayList<AllmobilscheduleDTO>();
			while (rs.next()) {
				AllmobilscheduleDTO dto = new AllmobilscheduleDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setStartday(rs.getString("startday"));
				dto.setEndday(rs.getString("endday"));
				dto.setName(rs.getString("name"));
				list.add(dto);
			}
			rs.close();
			stat.close();
			return list;
		} catch (Exception e) {
			System.out.println("### AdminDAO.ScheduleListAll ###");
			e.printStackTrace();
		}
		return null;
	}//ListAll
	
	public List<MobilScheduleDTO> ScheduleDetail(String troopSeq, String scheduleSeq) {
		try {
			String sql = "select * from MOBILSCHEDULE where TSEQ = "+scheduleSeq+" and PSEQ = "+troopSeq;
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			List<MobilScheduleDTO> list = new ArrayList<MobilScheduleDTO>();
			while (rs.next()) {
				MobilScheduleDTO dto = new MobilScheduleDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setStartdate(rs.getString("startday"));
				dto.setPay(rs.getString("pay"));
				dto.setTseq(rs.getString("tseq"));
				dto.setFseq(rs.getString("fseq"));
				dto.setPseq(rs.getString("pseq"));
				list.add(dto);
			}
			rs.close();
			stat.close();
			return list;
		} catch (Exception e) {
			System.out.println("### AdminDAO.ScheduleDetail ###");
			e.printStackTrace();
		}
		return null;
	}//Detail
	
	public void ScheduleModifyTseq(String seq, String newSeq) {
		try {
			String sql = "update MOBILSCHEDULE set TSEQ = "+newSeq+" where seq = "+seq;
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### AdminDAO.ScheduleModifyDay ###");
			e.printStackTrace();
		}
	}//ModifyTseq
	
	public void ScheduleModifyDay(String seq, String input) {
		try {
			String sql = "update MOBILSCHEDULE set STARTDAY = '"+input+"' where seq = "+seq;
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### AdminDAO.ScheduleModifyDay ###");
			e.printStackTrace();
		}
	}//ModifyDay
	
	public void ScheduleModifyPay(String seq, String input) {
		try {
			String sql = "update MOBILSCHEDULE set PAY = "+input+" where seq = "+seq;
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### AdminDAO.ScheduleModifyPay ###");
			e.printStackTrace();
		}
	}//ModifyPay
	
	public void ScheduleModifyFood(String seq, String input) {
		try {
			String sql = "update MOBILSCHEDULE set FSEQ = "+input+" where seq = "+seq;
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### AdminDAO.ScheduleModifyPay ###");
			e.printStackTrace();
		}
	}//ModifyFood
	
	public void ScheduleDel(String seq) {
		try {
			String sql = "select * from ALLSCHEDULE where seq = "+seq;	//child key 존재여부 조회
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			if (rs.next()) {
				System.out.println("현 부대 혹은 다른부대에 존재하는 물품은 삭제할 수 없습니다");
				UI.pause();
			} else {
				sql = "begin procDelSchedule("+seq+") end";
				stat = conn.createStatement();
				stat.executeUpdate(sql);
				UI.successPause();
			}
			rs.close();
			stat.close();
		} catch (Exception e) {
			System.out.println("### AdminDAO.enclosing_method ###");
			e.printStackTrace();
		}
	}//Del
	
	public void ScheduleAdd(String startday, String pay, String seq, String food, String troopseq) {
		try {
			String sql = "begin PROCADDSCHEDULE ('"+startday+"',"+pay+","+seq+","+food+","+troopseq+"); end;";
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### ScheduleDAO.ScheduleAdd ###");
			e.printStackTrace();
		}
	}//Add
	
	public void ScheduleAddAll(String startday, String endday, String recog) {
		try {
			String sql = "begin procAllMobilSchedule ('"+startday+"', '"+endday+"', '"+recog+"'); end;";
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### ScheduleDAO.ScheduleAddAll ###");
			e.printStackTrace();
		}
	}//AddAll


}
