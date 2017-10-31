package com.yebigun.schedule;

import java.util.List;

import com.yebigun.main.Check;
import com.yebigun.main.UI;
import com.yebigun.DAO.FoodDAO;
import com.yebigun.DAO.ScheduleDAO;
import com.yebigun.DTO.AllmobilscheduleDTO;
import com.yebigun.DTO.FoodDTO;
import com.yebigun.view.FoodView;
import com.yebigun.view.ScheduleView;

/**
 * 훈련 변경 관련업무 클래스
 * @author 박
 *
 */
class ScheduleModify {

	private ScheduleDAO dao = new ScheduleDAO();
	private ScheduleView sView = new ScheduleView();
	private FoodDAO dao2 = new FoodDAO();
	private FoodView fView = new FoodView();
	
	/**
	 * 해당 훈련의 훈련과정을 변경하는 메소드
	 * @param seq 변경할 훈련번호
	 */
	public void ModifyTseq(String seq) {
		
		String newSeq = null;
		boolean check = false;
		boolean loop = true;
		
		System.out.println();
		UI.word("일정 확인");
		List<AllmobilscheduleDTO> list = dao.ScheduleListAll();
		sView.ScheduleList(list);
		while (loop) {
			newSeq = UI.namedPause("일정 번호를 입력하세요");
			for (AllmobilscheduleDTO d : list) {
				if (d.getSeq().equals(newSeq)) {
					loop = false;
					check = true;
				}
			}
			if (!check) {
				System.out.println("번호를 확인하시고 다시 입력하세요");
				UI.pause();
			}
		}
		dao.ScheduleModifyTseq(seq, newSeq);
	}
	
	/**
	 * 해당 훈련의 훈련일자를 변경하는 메소드 
	 * @param seq 변경할 훈련번호
	 */
	public void ModifyDay(String seq) {
		
		String newDay = null;
		boolean check = false;
		boolean loop = true;
		
		System.out.println();
		while (loop) {
			System.out.println("훈련일을 입력하세요");
			newDay = UI.namedPause("YYMMDD 형식으로 입력");
			check = Check.YYMMDD(newDay);
			if (check) {
				loop = false;
				System.out.println();
			} else {
				System.out.println("올바른 날짜를 입력하세요");
				UI.pause();
			}
		}
		dao.ScheduleModifyDay(seq, newDay);
	}
	
	/**
	 * 해당 훈련의 훈련비를 변경하는 메소드
	 * @param seq 변경할 훈련번호
	 */
	public void ModifyPay(String seq) {
		
		String pay = null;
		
		System.out.println();
		pay = UI.namedPause("교통비를 입력하세요");
		
		dao.ScheduleModifyPay(seq, pay);
	}
	
	/**
	 * 해당 훈련의 배식을 변경하는 메소드
	 * @param seq 변경할 훈련번호
	 */
	public void ModifyFood(String seq) {
		
		String food = null;
		boolean check = false;
		boolean loop = true;
		
		System.out.println();
		UI.word("배식 확인");
		List<FoodDTO> list2 = dao2.FoodList();
		fView.FoodList(list2);
		while (loop) {
			food = UI.namedPause("배식 번호를 입력하세요");
			for (FoodDTO d : list2) {
				if (d.getSeq().equals(seq)) {
					loop = false;
					check = true;
				}
			}
			if (!check) {
				System.out.println("번호를 확인하시고 다시 입력하세요");
				UI.pause();
			}
		}
		dao.ScheduleModifyFood(seq, food);
	}
}
