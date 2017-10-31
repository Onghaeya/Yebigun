package com.yebigun.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.yebigun.main.Util;

public class SupplyDAO_bak {

	private Connection conn;
	
	public SupplyDAO_bak() {
		try {
			conn = Util.open(); 
		} catch (Exception e) {
			System.out.println("### SupplyDAO.SupplyDAO ###");
			e.printStackTrace();
		}
	}//Constructor


	public List<AsupplyDTO> SupplyList(String seq) {
		
		try {
			String sql = "";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				
			}
			rs.close();
			stat.close();
		} catch (Exception e) {
			System.out.println("### SupplyDAO.SupplyList ###");
			e.printStackTrace();
		}
		try {
		
		System.out.println("1.물품추가");
		System.out.println("2.물품삭제");
		System.out.println("3.물품변경");
		              
		int a = sc.nextInt();
		sc.nextLine();
		if(a==1)  addSupply();
		else if (a==2) deleteSupply();
		else if (a==3) updateSupply();
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}
	}
}
