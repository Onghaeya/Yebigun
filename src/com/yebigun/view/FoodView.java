package com.yebigun.view;

import java.util.List;

import com.yebigun.main.UI;
import com.yebigun.DTO.FoodDTO;

/**
 * 배식 관련정보를 출력하는 클래스
 * @author 박
 *
 */
public class FoodView {
	
	/**
	 * 배식정보를 출력하는 메소드
	 * @param list 전체배식정보
	 */
	public void FoodList(List<FoodDTO> list) {
		UI.line();
		System.out.println("번호      식사                 후식            유통기한    원산지       회사");
		UI.line();
		for (FoodDTO dto : list) {
			String name = UI.length(dto.getName(), 10);
			String dessert = UI.length(dto.getDessert(), 10);
			String origin = UI.length(dto.getOrigin(), 5);
			String cseq = UI.length(dto.getCseq(), 8);
			
			System.out.printf("%3s %s %s %s %s %s\n", 
					dto.getSeq(), name, dessert, dto.getExdate().substring(0,10), origin, cseq);
		}
		UI.line();
	}
}
