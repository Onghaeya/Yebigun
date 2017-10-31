package com.yebigun.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yebigun.DTO.CompanyDTO;
import com.yebigun.DTO.FoodDTO;
import com.yebigun.main.Util;

/**
 * 
 * @author 박
 *
 */
public class FoodDAO {
	
	private Connection conn;
	
	public FoodDAO() {
		try {
			conn = Util.open(); 
		} catch (Exception e) {
			System.out.println("### FoodDAO.FoodDAO ###");
			e.printStackTrace();
		}
	}//Constructor
	
	public List<FoodDTO> FoodList() {
		try {
			String sql = "select a.SEQ as seq, a.NAME as name, a.DESERT as desert, a.EXDATE as exdate, a.ORIGIN as origin, b.name as cseq "
					+ "from food a inner join COMPANY b on a.CSEQ = b.SEQ";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			List<FoodDTO> list = new ArrayList<FoodDTO>();
			while (rs.next()) {
				FoodDTO dto = new FoodDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setDessert(rs.getString("desert"));
				dto.setExdate(rs.getString("exdate"));
				dto.setOrigin(rs.getString("origin"));
				dto.setCseq(rs.getString("cseq"));
				list.add(dto);
			}
			rs.close();
			stat.close();
			return list;
		} catch (Exception e) {
			System.out.println("### FoodDAO.FoodList ###");
			e.printStackTrace();
		}
		return null;
	}//List
	
	public List<CompanyDTO> CompanyList() {
		try {
			String sql = "select * from company";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			List<CompanyDTO> list = new ArrayList<CompanyDTO>();
			while (rs.next()) {
				CompanyDTO dto = new CompanyDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setCeo(rs.getString("ceo"));
				dto.setLocation(rs.getString("location"));
				dto.setNum(rs.getString("num"));
			}
			rs.close();
			stat.close();
			return list;
		} catch (Exception e) {
			System.out.println("### FoodDAO.CompanyList ###");
			e.printStackTrace();
		}
		return null;
	}
}
