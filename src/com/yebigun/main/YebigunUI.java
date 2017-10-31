package com.yebigun.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yebigun.DAO.YebigunDAO;
import com.yebigun.DTO.AllmobilscheduleDTO;
import com.yebigun.DTO.DongDTO;
import com.yebigun.DTO.MemberDTO;
import com.yebigun.DTO.YebDTO;
import com.yebigun.DTO.mytroopsDTO;
import com.yebigun.view.YebigunView;

public class YebigunUI {
	
	
	private Scanner sc; 
	private YebigunView view;
	
	
	public YebigunUI() {
		sc = new Scanner(System.in);
		view = new YebigunView();
	}

	public void call(List<YebDTO> list, MemberDTO loginDTO) {

		Scanner sc = new Scanner(System.in);
		System.out.println("예비군 전입 신고 진행");
		boolean loop = true;
		List<String> location = new ArrayList<String>();

		for (YebDTO tdto : list) {
			location.add(tdto.getCity());
		} // 지역 추가

		while (loop) {

			System.out.print("지역 선택(0번 종료): ");
			int check = (sc.nextInt() - 1);
			if (check == -1)
				break;
			if (location.get(check).length() > 0) {
				YebigunDAO dao = new YebigunDAO();
				dao.loChange(loginDTO, location.get(check));
			}

		}

	}

	public boolean start(boolean loop, MemberDTO loginDTO) {
		while (loop) {
			System.out.println("1. 전입 신고");
			System.out.println("2. 훈련일정 확인");
			System.out.println("3. 나의 소속 부대 조회");
			System.out.println("4. 필증 발급");
			System.out.print(" 번호 선택(5번 종료) : ");
			int a = sc.nextInt();
			sc.skip("\r\n");

			if (a == 1) {

				YebigunDAO dao = new YebigunDAO();
				List<YebDTO> list = dao.moveCall(loginDTO);
				view.viewMoveCall(list);
				call(list, loginDTO);
				
			} else if (a == 2) {

				YebigunDAO dao = new YebigunDAO();
				List<AllmobilscheduleDTO> list = dao.schduleList(loginDTO);
				view.viewSchduleList(list);

			} else if (a == 3) { 

				YebigunDAO dao = new YebigunDAO();
				List<mytroopsDTO> list = dao.myPlace(loginDTO);
				view.viewMyPlace(list);

			} else if (a == 4) {

				YebigunDAO dao = new YebigunDAO();
				DongDTO ddto = dao.check(loginDTO);
				String name = loginDTO.getName();
				view.viewCheck(name, ddto);

			} else if (a == 5)
				loop = false;
		} // while 문 종료
		return loop;
	}

}
