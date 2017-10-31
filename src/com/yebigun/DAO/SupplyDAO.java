package com.yebigun.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yebigun.DTO.AAmmunitionDTO;
import com.yebigun.DTO.AgrenadeDTO;
import com.yebigun.DTO.AmmunitionDTO;
import com.yebigun.DTO.AsupplyDTO;
import com.yebigun.DTO.GrenadeDTO;
import com.yebigun.DTO.SupplyDTO;
import com.yebigun.main.UI;
import com.yebigun.main.Util;

public class SupplyDAO {
	
	private Connection conn;

	public SupplyDAO() {
		try {
			conn = Util.open();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.SupplyDAO ###");
			e.printStackTrace();
		}
	}
	
	public List<AsupplyDTO> asupplyList(String troopSeq) {
		try {
			List<AsupplyDTO> list = new ArrayList<AsupplyDTO>();
			String sql = "select a.seq as seq, a.pseq as pseq, b.name as sseq, a.num from ASUPPLY a inner join SUPPLY b on a.SSEQ = b.SEQ where a.pseq ="+troopSeq;
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				AsupplyDTO dto = new AsupplyDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setPseq(rs.getString("pseq"));
				dto.setSseq(rs.getString("sseq"));
				dto.setNum(rs.getString("num"));
				list.add(dto);
			}
			rs.close();
			stat.close();
			return list;
		} catch (Exception e) {
			System.out.println("### SupplyDAO.asupplyList ###");
			e.printStackTrace();
		}
		return null;
	}
	
	public List<SupplyDTO> supplyList() {
		try {
			List<SupplyDTO> list = new ArrayList<SupplyDTO>();
			String sql = "select * from SUPPLY";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				SupplyDTO dto = new SupplyDTO();
				dto.setCount(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				list.add(dto);
			}
			rs.close();
			stat.close();
			return list;
		} catch (Exception e) {
			System.out.println("### SupplyDAO.supplyLIst ###");
			e.printStackTrace();
		}
		return null;
	}

	public void supplyInsert(String name) {
		try {
			String sql = "insert into SUPPLY values (SUPPLYSEQ.nextval, '"+name+"')";
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.supplyInsert ###");
			e.printStackTrace();
		}
	}

	public void supplyModify(String seq, String newName) {
		try {
			String sql = "update SUPPLY set name = '"+newName+"' where seq = "+seq;
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.supplyModify ###");
			e.printStackTrace();
		}
	}

	public void supplyDelete(String seq) {
		try {
			String sql = "select * from SUPPLY where seq = "+seq;
			Statement stat = conn.createStatement();
//			ResultSet rs = stat.executeQuery(sql);
//			if (rs.next()) {
//				System.out.println("현 부대 혹은 다른부대에 존재하는 물품은 삭제할 수 없습니다");
//				UI.pause();
//			} else {
				sql = "delete from SUPPLY where seq = "+seq;
				stat = conn.createStatement();
				stat.executeUpdate(sql);
				UI.successPause();
//			}
//			rs.close();
			stat.close();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.supplyDelete ###");
			e.printStackTrace();
		}
	}

	public void asupplyInsert(String troopSeq, String supplySeq, String num) {
		try {
			String sql = "insert into ASUPPLY values (ASUPPLYSEQ.nextval,"+troopSeq+","+supplySeq+","+num+")";
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.asupplyInsert ###");
			e.printStackTrace();
		}
	}

	public void asupplyModify(String troopSeq, String asupplySeq, String num) {
		try {
			String sql = "update ASUPPLY set num ="+num+" where pseq ="+troopSeq+" and seq ="+asupplySeq;
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.asupplyModify ###");
			e.printStackTrace();
		}
	}

	public void asupplyDelete(String seq) {
		try {
			String sql = "delete from ASUPPLY where seq = "+seq;
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.asupplyDelete ###");
			e.printStackTrace();
		} 
	}

	public List<GrenadeDTO> grenadeList() {
		try {
			List<GrenadeDTO> list = new ArrayList<GrenadeDTO>();
			String sql = "select * from GRENADE";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				GrenadeDTO dto = new GrenadeDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				list.add(dto);
			}
			rs.close();
			stat.close();
			return list;
		} catch (Exception e) {
			System.out.println("### SupplyDAO.grenadeLIst ###");
			e.printStackTrace();
		}
		return null;
	}
	
	public List<AgrenadeDTO> agrenadeList(String troopSeq) {
		try {
			List<AgrenadeDTO> list = new ArrayList<AgrenadeDTO>();
			String sql = "select a.seq as seq, a.pseq as pseq, b.name as gseq, a.num as num from AGRENADE a inner join GRENADE b on a.GSEQ = b.SEQ where a.PSEQ = "+troopSeq;
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				AgrenadeDTO dto = new AgrenadeDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setPseq(rs.getString("pseq"));
				dto.setGseq(rs.getString("gseq"));
				dto.setNum(rs.getString("num"));
				list.add(dto);
			}
			rs.close();
			stat.close();
			return list;
		} catch (Exception e) {
			System.out.println("### SupplyDAO.agrenadeList ###");
			e.printStackTrace();
		}
		return null;
	}

	public void grenadeInsert(String name, String type) {
		try {
			String sql = "insert into GRENADE values (GRENADESEQ.nextval,'"+name+"','"+type+"')";
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.grenadeInsert ###");
			e.printStackTrace();
		}
	}

	public void grenadeModify(String seq, String newName, String newType) {
		try {
			String sql = "update GRENADE set name = '"+newName+"' , typ = '"+newType+"' where seq = "+seq;
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.grenadeModify ###");
			e.printStackTrace();
		}
	}

	public void grenadeDelete(String seq) {
		try {
			String sql = "select * from AGRENADE where gseq = "+seq;
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			if (rs.next()) {
				System.out.println("현 부대 혹은 다른부대에 존재하는 물품은 삭제할 수 없습니다");
				UI.pause();
			} else {
				sql = "delete from GRENADE where seq = "+seq;
				stat = conn.createStatement();
				stat.executeUpdate(sql);
				UI.successPause();
			}
			rs.close();
			stat.close();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.grenadeDelete ###");
			e.printStackTrace();
		}
	}

	public void agrenadeInsert(String troopSeq, String seq, String num) {
		try {
			String sql = "insert into AGRENADE values (AGRENADESEQ.nextval,"+troopSeq+","+seq+","+num+")";
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.agrenadeInsert ###");
			e.printStackTrace();
		}
	}

	public void agrenadeModify(String troopSeq, String seq, String newNum) {
		try {
			String sql = "update AGRENADE set num ="+newNum+" where pseq ="+troopSeq+" and seq ="+seq;
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.agrenadeModify ###");
			e.printStackTrace();
		}
	}

	public void agrenadeDelete(String seq) {
		try {
			String sql = "delete from AGRENADE where seq ="+seq;
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.agrenadeDelete ###");
			e.printStackTrace();
		}
	}

	public List<AmmunitionDTO> ammuList() {
		try {
			List<AmmunitionDTO> list = new ArrayList<AmmunitionDTO>();
			String sql = "select * from AMMUNITION";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				AmmunitionDTO dto = new AmmunitionDTO();
				dto.setSEQ(rs.getString("seq"));
				dto.setNAME(rs.getString("name"));
				list.add(dto);
			}
			rs.close();
			stat.close();
			return list;
		} catch (Exception e) {
			System.out.println("### SupplyDAO.ammuList ###");
			e.printStackTrace();
		}
		return null;
	}

	public List<AAmmunitionDTO> aammuList(String troopSeq) {
		try {
			List<AAmmunitionDTO> list = new ArrayList<AAmmunitionDTO>();
			String sql = "select a.seq as seq, b.name as aseq, a.pseq as pseq, a.num as num from AAMMUNITION a inner join AMMUNITION b on a.ASEQ = b.SEQ where a.pseq = "+troopSeq;
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				AAmmunitionDTO dto = new AAmmunitionDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setAseq(rs.getString("aseq"));
				dto.setPseq(rs.getString("pseq"));
				dto.setNum(rs.getString("num"));
				list.add(dto);
			}
			rs.close();
			stat.close();
			return list;
		} catch (Exception e) {
			System.out.println("### SupplyDAO.aammuList ###");
			e.printStackTrace();
		}
		return null;
	}

	public void ammuInsert(String name, String type) {
		try {
			String sql = "insert into AMMUNITION values (AMMUNITIONSEQ.nextval,'"+name+"','"+type+"')";
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.ammuInsert ###");
			e.printStackTrace();
		}
	}

	public void ammuModify(String seq, String newName, String newType) {
		try {
			String sql = "update AMMUNITION set name = '"+newName+"' ,typ = '"+newType+"' where seq = "+seq;
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.ammuModify ###");
			e.printStackTrace();
		}
	}

	public void ammuDelete(String seq) {
		try {
			String sql = "select * from AAMMUNITION where aseq = "+seq;
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			if (rs.next()) {
				System.out.println("현 부대 혹은 다른부대에 존재하는 물품은 삭제할 수 없습니다");
				UI.pause();
			} else {
				sql = "delete from AMMUNITION where seq = "+seq;
//				TODO 확인하기
				stat = conn.createStatement();
				stat.executeUpdate(sql);
				UI.successPause();
			}
			rs.close();
			stat.close();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.ammuDelete ###");
			e.printStackTrace();
		}
	}

	public void aammuInsert(String troopSeq, String seq, String num) {
		try {
			String sql = "insert into AAMMUNITION values (AAMMUNITIONSEQ.nextval,"+seq+","+troopSeq+","+num+")";
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.aammuInsert ###");
			e.printStackTrace();
		}
	}

	public void aammuModify(String troopSeq, String seq, String newNum) {
		try {
			String sql = "update AAMMUNITION set num ="+newNum+" where pseq ="+troopSeq+" and seq ="+seq;
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.aammuModify ###");
			e.printStackTrace();
		}
	}

	public void aammuDelete(String seq) {
		try {
			String sql = "delete from AAMMUNITION where seq ="+seq;
			Statement stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			UI.successPause();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.aammuDelete ###");
			e.printStackTrace();
		}
	}
}
