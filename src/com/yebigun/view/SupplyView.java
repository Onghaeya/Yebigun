package com.yebigun.view;

import java.util.ArrayList;
import java.util.List;

import com.yebigun.DTO.AAmmunitionDTO;
import com.yebigun.DTO.AgrenadeDTO;
import com.yebigun.DTO.AmmunitionDTO;
import com.yebigun.DTO.AsupplyDTO;
import com.yebigun.DTO.GrenadeDTO;
import com.yebigun.DTO.SupplyDTO;
import com.yebigun.main.UI;

public class SupplyView {

	/**
	 * 보급품 종류 목록을 출력하는 메소드
	 * @param list 전체 보급품 정보
	 * @return 보급품의 고유번호를 담은 컬렉션
	 */
	public void supplyList(List<SupplyDTO> list) {
		UI.line();
		System.out.println("번호    물품이름");
		UI.line();
		for (SupplyDTO dto : list) {
			System.out.printf("%3s.  %12s\n", dto.getCount(), dto.getName());
		}
		UI.line();
	}
	
	public ArrayList<String> asupplyList(List<AsupplyDTO> list) {
		ArrayList<String> selection = new ArrayList<String>();
		UI.line();
		System.out.println("번호    종류    수량");
		UI.line();
		for (AsupplyDTO dto : list) {
			selection.add(dto.getSeq());
			System.out.printf("%3s.  %12s  %4s\n", dto.getSeq(), dto.getSseq(), dto.getNum());
		}
		UI.line();
		return selection;
	}
	
	public void grenadeList(List<GrenadeDTO> list) {
		UI.line();
		System.out.println("번호    종류");
		UI.line();
		for (GrenadeDTO dto : list) {
			System.out.printf("%3s.  %12s\n", dto.getSeq(), dto.getName());
		}
		UI.line();
	}
	
	public ArrayList<String> agrenadeList(List<AgrenadeDTO> list) {
		ArrayList<String> seq = new ArrayList<String>();
		UI.line();
		System.out.println("번호    종류    수량");
		UI.line();
		for (AgrenadeDTO dto : list) {
			seq.add(dto.getSeq());
			System.out.printf("%3s.  %12s  %4s\n", dto.getSeq(), dto.getGseq(), dto.getNum());
		}
		UI.line();
		return seq;
	}

	public void ammuList(List<AmmunitionDTO> list) {
		UI.line();
		System.out.println("번호    종류");
		UI.line();
		for (AmmunitionDTO dto : list) {
			System.out.printf("%3s.  %12s\n", dto.getSEQ(), dto.getNAME());
		}
		UI.line();
	}
	
	public ArrayList<String> aammuList(List<AAmmunitionDTO> list) {
		ArrayList<String> seq = new ArrayList<String>();
		UI.line();
		System.out.println("번호    종류    수량");
		UI.line();
		for (AAmmunitionDTO dto : list) {
			seq.add(dto.getSeq());
			System.out.printf("%3s.  %12s  %4s\n", dto.getSeq(), dto.getAseq(), dto.getNum());
		}
		UI.line();
		return seq;
	}
}
