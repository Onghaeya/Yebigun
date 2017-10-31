package com.yebigun.main;

import java.util.Scanner;

import com.yebigun.DAO.LoginDAO;
import com.yebigun.DTO.MemberDTO;
import com.yebigun.schedule.MainSchedule;
import com.yebigun.view.YebigunView;

public class Start {

	private Scanner sc;
	private MemberDTO loginDTO; // 로그인한 회원 정보를 갖고있기위한 DTO
	private LoginDAO loginDao;

	public Start() {
		sc = new Scanner(System.in);
		loginDTO = new MemberDTO();
		loginDao = new LoginDAO();
	}

	public void start() {

		String id = null;
		String pwd = null;
		int check = 0;
		boolean allLoop = true;
		boolean loop = true;

		while (allLoop) {

			while (loop) {
				System.out.println("1. 관리자 로그인");
				System.out.println("2. 예비군 로그인");
				System.out.print("선택(1 or 2) : ");
				check = sc.nextInt(); // 관리자, 예비군 구분...
				sc.skip("\r\n");
				if (check >= 3)
					break;
				System.out.print("ID : ");
				id = sc.nextLine();
				System.out.print("PWD : ");
				pwd = sc.nextLine();

				if ((loginDTO = loginDao.logIn(id, pwd, check)) == null) {

					System.out.println("아이디 비번을 확인해주세요.");

				} else {

					System.out.println("로그인 성공");

					if (check == 1) { // 관리자

						AdminUI aui = new AdminUI();
						loop = aui.start(loop, loginDTO);

					} else if (check == 2) { // 예비군

						YebigunUI yui = new YebigunUI();
						loop = yui.start(loop, loginDTO);

					}
				}
			}

			allLoop = false;

		}
		sc.close(); // 스캐너 닫기
		loginDao.close(); // 연결 끊기
	}

}
