package com.yebigun.main;

import java.util.Scanner;

/**
 * UI관련 도구모음 클래스
 * @author 박
 *
 */
public class UI {

	static Scanner scan = new Scanner(System.in);
	private static String input = "";

	public static void line(){
		System.out.println("----------------------------------------------------------------------------------------------------");
	}//line
	
	public static void dbline(){
		System.out.println("====================================================================================================");
	}//dbline

	/**
	 * 검색어를 요구하여 입력받을 때 사용하는 메소드
	 * @return 입력받은 값을 반환
	 */
	public static String searchPause() {
		System.out.print("검색하실 내용 입력> ");
		input = scan.nextLine();
		return input;
	}//searchPause
	
	/**
	 * 수정을 요구하여 입력받을 때 사용하는 메소드
	 * @return 입력받은 값을 반환
	 */
	public static String editPause() {
		System.out.print("수정하실 내용 입력> ");
		input = scan.nextLine();
		return input;
	}//editPause
	
	/**
	 * 프로그램 수행 중 잠시 정지하여 Enter를 입력받을 때 사용하는 메소드
	 */
	public static void pause() {
		System.out.printf("[계속하시려면 Enter를 눌러주세요]\n");
		scan.nextLine();
	}//pause
	
	/**
	 * 원하는 문자열을 요구하여 입력받을 때 사용하는 메소드
	 * @param name 사용자로부터 입력받기 원하는 것을 받아옴
	 * @return 입력받은 값을 반환
	 */
	public static String namedPause(String name) {
		System.out.printf("%s> ", name);
		input = scan.nextLine();
		return input;
	}//namedPause
	
	/**
	 * 프로그램 수행 중 잠시 정지하여 아무 입력이나 받을 때 사용하는 메소드
	 * @return 입력받은 값을 반환
	 */
	public static String input() {
		System.out.print("입력> ");
		input = scan.nextLine();
		return input;
	}//input
	
	/**
	 * 100줄의 공백을 출력하여 화면을 정리하는 메소드
	 */
	public static void clear() {
		for (int i=0;i<100;i++) {
			System.out.println();
		}
	}//clear
	
	/**
	 * 요청한 문자열을 화면 가운데에 출력하는 메소드 
	 * @param word 사용자로부터 요청받은 문자열
	 */
	public static void word(String word){
		if (word.length() <= 100) {
			System.out.println("                                        "+word);
		} else {
			System.out.println(word);
		}
	}//word
	
	/**
	 * 이전 화면으로 돌아갈 때 사용하는 메소드
	 * @return false값을 돌려준다
	 */
	public static boolean backPause() {
		System.out.print("이전 화면으로 돌아갑니다. 엔터를 눌러주세요");
		scan.nextLine();
		return false;
	}//backPause
	
	public static void requestPause() {
		System.out.print("확인하신 후 다시 입력해주세요. 엔터를 눌러주세요");
		scan.nextLine();
	}//requestPause
	
	public static void successPause() {
		System.out.println("성공적으로 처리되었습니다. 엔터를 눌러주세요");
		scan.nextLine();
	}//successPause
	
	/**
	 * 화면에 출력되는 문자열의 길이를 조정할 때 사용하는 메소드
	 * @param word 조정을 원하는 문자열
	 * @param length 원하는 길이
	 * @return 조정된 문자열 값
	 */
	public static String length(String word, int length) {
		String value = word;
		value = value.replaceAll(" ", "");
		int valength = value.length();
		if (valength<length) {
			for (;valength<length;valength++) {
				value = value + "　";
			}
			return value;
		} else if (valength>length) {
			value = value.substring(0, length);
			return value;
		} else {
			return value;
		}
	}//length
}
