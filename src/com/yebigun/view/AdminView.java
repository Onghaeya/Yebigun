package com.yebigun.view;

import java.util.List;

import com.yebigun.DTO.AllmobilscheduleDTO;
import com.yebigun.DTO.LrtDTO;

public class AdminView {

	public void viewMoveCheck(List<LrtDTO> list) {

		for(LrtDTO ldto : list) {
			
			System.out.printf("메시지 : %s님이 전입신고를 신청했습니다.\n",ldto.getName());
			
		}
		
		
		
	}

	public void viewScheduleCheck(List<LrtDTO> list) {

		for (LrtDTO ldto : list) {

			System.out.printf("메시지 : %s님이 훈련 연기를 신청했습니다.\n",ldto.getName());

		}

	}

	public void viewCallSchedule(List<LrtDTO> list) {

		for (LrtDTO ldto : list) {
			
			System.out.printf("메시지 : %s님이 훈련 예정입니다.\n",ldto.getName());
			
		}
		
	}

	public void viewMoneyCheck(List<LrtDTO> list) {

		for (LrtDTO ldto : list) {
			
			System.out.printf("메시지 : %s님 돈 내세요.\n",ldto.getName());
		}
		
	}

	public void viewSchduleList(List<AllmobilscheduleDTO> list) {

		for (AllmobilscheduleDTO adto : list) {
			
			System.out.println("");
			
		}
		
	}

}
