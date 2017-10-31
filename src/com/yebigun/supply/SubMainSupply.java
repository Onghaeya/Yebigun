package com.yebigun.supply;

import java.util.ArrayList;
import java.util.List;

import com.yebigun.DAO.SupplyDAO;
import com.yebigun.DTO.AsupplyDTO;
import com.yebigun.DTO.SupplyDTO;
import com.yebigun.main.UI;
import com.yebigun.view.SupplyView;

class SubMainSupply {

	public void start(String troopSeq) {
		
		SupplyDAO dao = new SupplyDAO();
		SupplyView view = new SupplyView();
		String input;
		String innerinput;
		boolean loop = true;
		
		while (loop) {
			
			boolean loop2 = true;
			
			UI.clear();
			UI.word("보급품 관리 업무");
			UI.dbline();
			UI.word("1. 품목관리");
			UI.word("2. 보급품관리");
			System.out.println();
			UI.word("0. 이전 메뉴로");
			System.out.println();
			UI.line();
			input = UI.input();
			
			if (input.equals("1")) {
				while (loop2) {
					UI.clear();
					UI.word("품목 관리 업무");
					
					List<SupplyDTO> list = dao.supplyList();
					view.supplyList(list);
					
					UI.word("1. 품목추가");
					UI.word("2. 품목명 수정");
					UI.word("3. 품목삭제");
					System.out.println();
					UI.word("0. 이전 메뉴로");
					System.out.println();
					UI.line();
					input = UI.input();
					
					if (input.equals("1")) {
						input = UI.namedPause("새로운 물품 이름을 입력하세요");
						dao.supplyInsert(input);
					} else if (input.equals("2")) {
						input = UI.namedPause("수정할 품목번호를 입력하세요");
						innerinput = UI.namedPause("물품 이름을 새로 입력하세요");
						dao.supplyModify(input, innerinput);
					} else if (input.equals("3")) {
						input = UI.namedPause("삭제할 품목번호를 입력하세요");
						System.out.println("정말로 삭제하시겠습니까?");
						innerinput = UI.namedPause("삭제를 원하시면 예, 아니면 아무 키나 눌러주세요");
						if (innerinput.equals("예")) {
							dao.supplyDelete(input);
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
					UI.word("수량 관리 업무");
					
					List<AsupplyDTO> list = dao.asupplyList(troopSeq);
					seq = view.asupplyList(list);
					
					UI.dbline();
					UI.word("1. 보급품추가");
					UI.word("2. 보급품 수량 수정");
					UI.word("3. 보급품파기");
					System.out.println();
					UI.word("0. 이전 메뉴로");
					System.out.println();
					UI.line();
					input = UI.input();
					
					if (input.equals("1")) {
						List<SupplyDTO> list2 = dao.supplyList();
						view.supplyList(list2);
						input = UI.namedPause("추가할 보급품의 번호를 입력하세요");
						innerinput = UI.namedPause("추가할 보금품의 수량을 입력하세요");
						dao.asupplyInsert(troopSeq, input, innerinput);
					} else if (input.equals("2")) {
						input = UI.namedPause("수정할 보급품의 번호를 입력하세요");
						innerinput = UI.namedPause("수량을 새로 입력하세요"); 
						dao.asupplyModify(troopSeq, input, innerinput);
					} else if (input.equals("3")) {
						input = UI.namedPause("파기할 보급품의 번호를 입력하세요");
						if (seq.contains(input)) {
							System.out.println("정말로 삭제하시겠습니까?");
							innerinput = UI.namedPause("삭제를 원하시면 예, 아니면 아무 키나 눌러주세요");
							if (innerinput.equals("예")) {
								dao.asupplyDelete(input);
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
