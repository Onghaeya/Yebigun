package com.yebigun.supply;

import java.util.ArrayList;
import java.util.List;

import com.yebigun.DAO.SupplyDAO;
import com.yebigun.DTO.AgrenadeDTO;
import com.yebigun.DTO.GrenadeDTO;
import com.yebigun.main.UI;
import com.yebigun.view.SupplyView;


class SubMainExp {

	public void start(String troopSeq) {
		
		SupplyDAO dao = new SupplyDAO();
		SupplyView view = new SupplyView();
		String input;
		String innerinput;
		String input2;
		boolean loop = true;
		
		while (loop) {
			
			boolean loop2 = true;
			
			UI.clear();
			UI.word("수류탄 관리 업무");
			UI.dbline();
			UI.word("1. 수류탄 종류 관리");
			UI.word("2. 수류탄 보급 관리");
			System.out.println();
			UI.word("0. 이전 메뉴로");
			System.out.println();
			UI.line();
			input = UI.input();
			
			if (input.equals("1")) {
				while (loop2) {
					UI.clear();
					UI.word("수류탄 종류 관리 업무");
					
					List<GrenadeDTO> list = dao.grenadeList();
					view.grenadeList(list);
					
					UI.word("1. 종류추가");
					UI.word("2. 종류 이름 수정");
					UI.word("3. 종류삭제");
					System.out.println();
					UI.word("0. 이전 메뉴로");
					System.out.println();
					UI.line();
					input = UI.input();
					
					if (input.equals("1")) {
						input = UI.namedPause("새로운 수류탄 이름을 입력하세요");
						innerinput = UI.namedPause("새로운 수류탄 종류를 입력하세요");
						dao.grenadeInsert(input, innerinput);
					} else if (input.equals("2")) {
						input = UI.namedPause("수정할 종류 번호를 입력하세요");
						innerinput = UI.namedPause("수류탄 이름을 새로 입력하세요");
						input2 = UI.namedPause("종류 이름을 새로 입력하세요");
						dao.grenadeModify(input, innerinput, input2);
					} else if (input.equals("3")) {
						input = UI.namedPause("삭제할 종류 번호를 입력하세요");
						System.out.println("정말로 삭제하시겠습니까?");
						innerinput = UI.namedPause("삭제를 원하시면 예, 아니면 아무 키나 눌러주세요");
						if (innerinput.equals("예")) {
							dao.grenadeDelete(input);
						} else {
							UI.pause();
						}
					} else if (input.equals("0")) {
						loop2 = UI.backPause();
					} else {
						UI.requestPause();
					}
				}
			} else if (input.equals("2")) {
				while (loop2) {
					ArrayList<String> seq = new ArrayList<String>();
					
					UI.clear();
					UI.word("수류탄 보급 관리 업무");
					
					List<AgrenadeDTO> list = dao.agrenadeList(troopSeq);
					seq = view.agrenadeList(list);
					
					UI.dbline();
					UI.word("1. 수류탄 종류 추가");
					UI.word("2. 수류탄 수량 수정");
					UI.word("3. 수류탄 파기");
					System.out.println();
					UI.word("0. 이전 메뉴로");
					System.out.println();
					UI.line();
					input = UI.input();
					
					if (input.equals("1")) {
						List<GrenadeDTO> list2 = dao.grenadeList();
						view.grenadeList(list2);
						input = UI.namedPause("추가할 수류탄 종류의 번호를 입력하세요");
						innerinput = UI.namedPause("추가할 수류탄의 수량을 입력하세요");
						dao.agrenadeInsert(troopSeq, input, innerinput);
					} else if (input.equals("2")) {
						input = UI.namedPause("수정할 수류탄 종류의 번호를 입력하세요");
						innerinput = UI.namedPause("수량을 새로 입력하세요"); 
						dao.agrenadeModify(troopSeq, input, innerinput);
					} else if (input.equals("3")) {
						input = UI.namedPause("파기할 수류탄의 번호를 입력하세요");
						if (seq.contains(input)) {
							System.out.println("정말로 삭제하시겠습니까?");
							innerinput = UI.namedPause("삭제를 원하시면 예, 아니면 아무 키나 눌러주세요");
							if (innerinput.equals("예")) {
								dao.agrenadeDelete(input);
							} else {
								UI.pause();
							}
						} else {
							System.out.println("확인 후 다시 시도하세요");
							UI.pause();
						}
					} else if (input.equals("0")) {
						loop2 = UI.backPause();
					} else {
						UI.requestPause();
					}
				}
			} else if (input.equals("0")) {
				loop = UI.backPause();
			} else {
				UI.requestPause();
			}
		}
	}
}
