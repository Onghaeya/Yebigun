package com.yebigun.main;

import java.util.List;
import java.util.Scanner;

import com.yebigun.DAO.AdminDAO;
import com.yebigun.DTO.LrtDTO;
import com.yebigun.DTO.MemberDTO;
import com.yebigun.schedule.MainSchedule;
import com.yebigun.supply.MainSupply;
import com.yebigun.view.AdminView;

public class AdminUI {

	private Scanner sc;
	
	public AdminUI() {
		sc = new Scanner(System.in);
	}
	public void play(MemberDTO loginDTO) {

		boolean loop = true;
		AdminDAO dao = new AdminDAO();
		AdminView aview = new AdminView();
		Scanner sc = new Scanner(System.in);

		while (loop) {

			System.out.println("1. 전입 신고 확인");
			System.out.println("2. 훈련 일정 연기 신청 확인");
			System.out.println("3. 예비군 일정 통보");
			System.out.println("4. 독촉장");
			System.out.print("번호 선택(종료 5번) : ");
			int input = sc.nextInt();

			if (input == 1) { // 전입 신고 확인
				List<LrtDTO> list = dao.moveCheck(loginDTO); // 본인 한테 보내온 전입신고가 있는지 확인
				aview.viewMoveCheck(list); // 리스트 보여주기
				
			} else if (input == 2) { // 훈련 일정 연기 신청 확인
				List<LrtDTO> list = dao.scheduleCheck(loginDTO); // 본인 한테 보내온 훈련 일정 연기 신청 확인
				aview.viewScheduleCheck(list); // 리스트 보여주기
				
			} else if (input == 3) { // 예비군 일정 통보
				List<LrtDTO> list = dao.callSchedule(loginDTO); // 자신의 부대에 소속된 예비군중 아직 상태가 예정인 사람을 찾아서 예비군 일정을 알려준다..? 
				aview.viewCallSchedule(list); // 리스트 보여주기
				
			} else if (input == 4) { // 독촉장
				List<LrtDTO> list = dao.moneyCheck(loginDTO); // 미수료인 경우 독촉장 발송
				aview.viewMoneyCheck(list); // 리스트 보여주기
				
			} else if (input == 5) { // 종료
				loop = false;
				
			}

		}
		
	}

	public boolean start(boolean loop, MemberDTO loginDTO) {
		while (loop) {

			System.out.println("1. 부대 소속 예비군 확인");
			System.out.println("2. 물자 관리");
			System.out.println("3. 예비군 관리");
			System.out.println("4. 훈련 일정");
			System.out.print(" 번호 선택(5번 종료) : ");
			int a = sc.nextInt();
			sc.skip("\r\n");

			if (a == 1) {

				System.out.println("부대 소속 예비군 관리");

			} else if (a == 2) {

				MainSupply msp = new MainSupply();
				msp.start(loginDTO.getTseq() + "");
			} else if (a == 3) {

				// 효택스 작업
				AdminUI aui = new AdminUI();
				aui.play(loginDTO);

			} else if (a == 4) {
				MainSchedule ms = new MainSchedule();
				ms.ScheduleMain(loginDTO.getTseq() + "");

			} else if (a == 5)
				loop = false;
		} // while 문 종료
		return loop;
	}

	
	
}
