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
 * 훈련과 훈련과정을 추가하는 클래스
 * @author 박
 *
 */
class ScheduleAdd {

	private ScheduleDAO dao = new ScheduleDAO();
	private ScheduleView sView = new ScheduleView();
	private FoodDAO dao2 = new FoodDAO();
	private FoodView fView = new FoodView();
	
	/**
	 * 훈련일정을 추가하는 메소드
	 * @param troopSeq 로그인 이후로 받아온 관리자 고유번호
	 */
	public void ScheduleAdds(String troopSeq) {
		
		String seq = null;
		String pay = null;
		String food = null;
		String startday = null;
		boolean loop = true;
		boolean check = false;
		
		UI.clear();
		System.out.println("훈련장별 훈련 일정 추가");
		System.out.println();
		
		while (loop) {
			List<AllmobilscheduleDTO> list = dao.ScheduleListAll();
			sView.ScheduleList(list);
			seq = UI.namedPause("일정 번호를 입력하세요");
			for (AllmobilscheduleDTO d : list) {
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
		
		loop = true;
		check = false;
		while (loop) {
			System.out.println("훈련일을 입력하세요");
			startday = UI.namedPause("YYMMDD 형식으로 입력");
			check = Check.YYMMDD(startday);
			if (check) {
				loop = false;
				System.out.println();
			} else {
				System.out.println("올바른 날짜를 입력하세요");
				UI.pause();
			}
		}
		System.out.println();
		pay = UI.namedPause("교통비를 입력하세요");
		
		loop = true;
		check = false;
		while (loop) {
			List<FoodDTO> list2 = dao2.FoodList();
			fView.FoodList(list2);
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
		dao.ScheduleAdd(startday, pay, seq, food, troopSeq);
		System.out.println("훈련 추가가 완료되었습니다");
	}//Adds

	/**
	 * 훈련과정을 추가하는 메소드
	 */
	public void ScheduleAddsAll() {	//과정 추가
		
		String start = null;
		String end = null;
		String[] recog = {"동원", "동미참", "동원보충", "동미참보충"};
		boolean loop = true;
		boolean check = false;
		
		UI.clear();
		System.out.println("전국단위 훈련 일정 추가");
		System.out.println();
		while (loop) {
			System.out.println("훈련 시작일을 입력하세요");
			start = UI.namedPause("YYMMDD 형식으로 입력");
			check = Check.YYMMDD(start);
			if (check) {
				loop = false;
				System.out.println(start);
			} else {
				System.out.println("올바른 날짜를 입력하세요");
				UI.pause();
			}
		}
		loop = true;
		while (loop) {
			System.out.println("훈련 종료일을 입력하세요");
			end = UI.namedPause("YYMMDD 형식으로 입력");
			check = Check.YYMMDD(end);
			if (check) {
				loop = false;
				System.out.println(end);
			} else {
				System.out.println("올바른 날짜를 입력하세요");
				UI.pause();
			}
		}
		loop = true;
		while (loop) {
			System.out.println("훈련 종류를 선택하세요");
			System.out.println("1. 동원, 2. 동미참, 3. 동원보충, 4. 동미참보충");
			start = UI.namedPause("번호를 입력하세요");
			if (start.equals("1")) {
				dao.ScheduleAddAll(start, end, recog[0]);
				loop = false;
			} else if (start.equals("2")) {
				dao.ScheduleAddAll(start, end, recog[1]);
				loop = false;
			} else if (start.equals("3")) {
				dao.ScheduleAddAll(start, end, recog[2]);
				loop = false;
			} else if (start.equals("4")) {
				dao.ScheduleAddAll(start, end, recog[3]);
				loop = false;
			} else {
				System.out.println("올바른 번호를 입력하세요");
				UI.pause();
			}
		}
		System.out.println("훈련 추가가 완료되었습니다");
	}//AddsAll
}
