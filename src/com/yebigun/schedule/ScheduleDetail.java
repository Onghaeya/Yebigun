package com.yebigun.schedule;

import java.util.ArrayList;
import java.util.List;

import com.yebigun.main.UI;
import com.yebigun.DAO.ScheduleDAO;
import com.yebigun.DTO.MobilScheduleDTO;
import com.yebigun.view.ScheduleView;

/**
 * 해당 부대의 훈련 상세일정을 확인하고 수정/삭제 기능을 담은 클래스
 * @author 박
 *
 */
class ScheduleDetail {
	
	/**
	 * 해당 부대의 훈련일정을 출력하고 관련업무로 분기시키는 메소드
	 * @param troopSeq 로그인 이후로 받아온 관리자 고유번호
	 * @param scheduleSeq 변경할 훈련의 고유번호
	 */
	public void ScheduleDetails (String troopSeq, String scheduleSeq) {

		ScheduleDAO dao = new ScheduleDAO();
		ScheduleView sView = new ScheduleView();
		ScheduleModify mod = new ScheduleModify();
		boolean loop = true;
		String input;
		String innerinput;
		
		while (loop) {
			ArrayList<String> seq = new ArrayList<String>();
			
			UI.clear();
			UI.word("훈련 일정 세부 사항");
			
			List<MobilScheduleDTO> list = dao.ScheduleDetail(troopSeq, scheduleSeq);
			seq = sView.ScheduleDetail(list);
			
			UI.dbline();
			UI.word("1. 일정 변경");
			UI.word("2. 훈련일 변경");
			UI.word("3. 교통비 변경");
			UI.word("4. 배식 변경");
			System.out.println();
			UI.word("99. 해당 훈련 삭제");
			System.out.println();
			UI.word("0. 이전 메뉴로");
			input = UI.input();
			
			if (input.equals("1")) {
				input = UI.namedPause("변경할 훈련 번호를 입력하세요");
				if (seq.contains(input)) {
					mod.ModifyTseq(input);
				} else {
					System.out.println("확인 후 다시 시도하세요");
					UI.pause();
				}
			} else if (input.equals("2")) {
				input = UI.namedPause("변경할 훈련 번호를 입력하세요");
				if (seq.contains(input)) {
					mod.ModifyDay(input);
				} else {
					System.out.println("확인 후 다시 시도하세요");
					UI.pause();
				}
			} else if (input.equals("3")) {
				input = UI.namedPause("변경할 훈련 번호를 입력하세요");
				if (seq.contains(input)) {
					mod.ModifyPay(input);
				} else {
					System.out.println("확인 후 다시 시도하세요");
					UI.pause();
				}
			} else if (input.equals("4")) {
				input = UI.namedPause("변경할 훈련 번호를 입력하세요");
				if (seq.contains(input)) {
					mod.ModifyFood(input);
				} else {
					System.out.println("확인 후 다시 시도하세요");
					UI.pause();
				}
			} else if (input.equals("99")) {
				input = UI.namedPause("삭제할 훈련 번호를 입력하세요");
				if (seq.contains(input)) {
					System.out.println("정말로 삭제하시겠습니까?");
					innerinput = UI.namedPause("삭제를 원하시면 예, 아니면 아무 키나 눌러주세요");
					if (innerinput.equals("예")) {
						dao.ScheduleDel(input);
					} else {
						UI.pause();
					}
				} else {
					System.out.println("확인 후 다시 시도하세요");
					UI.pause();
				}
			} else if (input.equals("0")) {
				loop = UI.backPause();
			} else {
				UI.requestPause();
			}
		}
	}
}
