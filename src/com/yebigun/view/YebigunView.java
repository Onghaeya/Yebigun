package com.yebigun.view;

import java.util.List;

import com.yebigun.DTO.AllmobilscheduleDTO;
import com.yebigun.DTO.DongDTO;
import com.yebigun.DTO.YebDTO;
import com.yebigun.DTO.mytroopsDTO;

public class YebigunView {
	
	/**
	 * 예정된 훈련 확인 
	 * @param list
	 */
	public void viewSchduleList(List<AllmobilscheduleDTO> list) {

		for (AllmobilscheduleDTO adto : list) {
			
			System.out.printf("%s\t시작일 : %s\t종료일 : %s\n",adto.getName(),adto.getStartday(),adto.getEndday());
			
		}
	
	}
	/**
	 * 전입 신고
	 * 본인이 속한 도시를 제외한 모든 도시 출력
	 * @param list 도시 DTO
	 */
	public void viewMoveCall(List<YebDTO> list) {
		int count = 1;
		for (YebDTO ydto : list) {
			
			System.out.printf("%d. %s\t",count,ydto.getCity());
			count++;
		}
		System.out.println();
		
	}
	/**
	 * 나의 소속 부대 확인
	 * @param list 부대 DTO
	 */
	public void viewMyPlace(List<mytroopsDTO> list) {

		for(mytroopsDTO mdto : list) {
			
			System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\n",mdto.getName(),mdto.getMark(),mdto.getTel(),mdto.getCommander(),mdto.getPlace(),mdto.getMname(),mdto.getNum());
			
		}
			
		
	}
	/**
	 * 필증 발급
	 * @param name 이름
	 * @param ddto 데이터
	 */
	public void viewCheck(String name, DongDTO ddto) {

		System.out.printf("%s님은 기본훈련 %s입니다.\n", name, ddto.getSstate());
		if (ddto.getOstate() != null) {
			System.out.printf("%s님은 작계훈련 %s입니다.\n", name, ddto.getOstate());
			if (ddto.getOstate().equals("수료"))
				System.out.printf("%s님의 작계훈련 필증이 발급됩니다.\n", name);
		}
		if (ddto.getSstate().equals("수료"))
			System.out.printf("%s님의 기본훈련 필증이 발급됩니다.\n", name);
	}

}
