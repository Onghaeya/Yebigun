package com.yebigun.schedule;

import java.util.ArrayList;
import java.util.List;

import com.yebigun.main.UI;
import com.yebigun.DAO.ScheduleDAO;
import com.yebigun.DTO.AllmobilscheduleDTO;
import com.yebigun.view.ScheduleView;

/**
 * 일반관리자의 훈련 변경 관련업무가 출력/분기되는 클래스
 * @author 박
 *
 */
public class MainSchedule {
	
	/**
	 * 훈련일정을 출력하고 관련 업무를 분기시키는 메소드
	 * @param troopSeq 로그인 이후로 받아온 관리자 고유번호
	 */
	public void ScheduleMain(String troopSeq) {
		
		ScheduleDAO dao = new ScheduleDAO();
		ScheduleView sView = new ScheduleView();
		ArrayList<String> selection = new ArrayList<String>();
		Boolean loop = true;
		
		while (loop) {
			
			String input;
			UI.clear();
			UI.word(" 훈련 일정");

			List<AllmobilscheduleDTO> list = dao.ScheduleListAll();
			selection = sView.ScheduleList(list);
			
			UI.word("01. 훈련장별 훈련 일정 추가");
			UI.word("02. 전국단위 훈련 일정 추가");	//관리자 계정 분리 필요...
			System.out.println();
			UI.word("0. 이전 메뉴로");
			System.out.println();
			UI.line();
			System.out.println("일정 번호를 선택하시면 자세한 내용을 확인 및 수정, 삭제하실 수 있습니다");
			input = UI.namedPause("일정 번호 혹은 메뉴번호를 입력하세요");
			
			if (selection.contains(input)) {
				ScheduleDetail detail = new ScheduleDetail();
				detail.ScheduleDetails(troopSeq, input);
			} else if (input.equals("01")) {
				ScheduleAdd add = new ScheduleAdd();
				add.ScheduleAdds(troopSeq);
			} else if (input.equals("02")) {
				ScheduleAdd add = new ScheduleAdd();
				add.ScheduleAddsAll();
			} else if (input.equals("0")) {
				loop = UI.backPause();
			} else {
				UI.requestPause();
			}
		}
	}
	
	
}
