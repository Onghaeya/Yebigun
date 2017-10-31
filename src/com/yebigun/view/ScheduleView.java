package com.yebigun.view;

import java.util.ArrayList;
import java.util.List;

import com.yebigun.main.UI;
import com.yebigun.DTO.AllmobilscheduleDTO;
import com.yebigun.DTO.MobilScheduleDTO;

/**
 * 일정 관련정보를 출력하는 클래스
 * @author 박
 *
 */
public class ScheduleView {
	
	/**
	 * 훈련 과정을 출력하는 메소드
	 * @param list 전체과정정보
	 * @return 전체과정의 고유번호를 담은 컬렉션
	 */
	public ArrayList<String> ScheduleList(List<AllmobilscheduleDTO> list) {
		ArrayList<String> selection = new ArrayList<String>();
		UI.line();
		System.out.println("번호    시작일    종료일  종류");
		UI.line();
		for (AllmobilscheduleDTO dto : list) {
			selection.add(dto.getSeq());
			System.out.printf("%2s.  %8s  %8s  %s\n", dto.getSeq(), dto.getStartday().substring(0, 10), dto.getEndday().substring(0, 10), dto.getName());
		}
		UI.line();
		return selection;
	}

	/**
	 * 훈련 일정을 출력하는 메소드
	 * @param list 전체훈련정보
	 * @return 전체일정의 고유번호를 담은 컬렉션
	 */
	public ArrayList<String> ScheduleDetail(List<MobilScheduleDTO> list) {
		ArrayList<String> seq = new ArrayList<String>();
		UI.line();
		System.out.println("번호    시작일  교통비    배식");
		UI.line();
		for (MobilScheduleDTO dto : list) {
			seq.add(dto.getSeq());
			System.out.printf("%2s.  %8s  %6s  %s\n", dto.getSeq(), dto.getStartdate().substring(0, 10), dto.getPay(), dto.getFseq());
		}
		UI.line();
		return seq;
	}
}
