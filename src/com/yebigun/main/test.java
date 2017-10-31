package com.yebigun.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import com.yebigun.DTO.SchedulelrtDTO;

public class test {
	
	public static void main(String[] args) {
//		

		test1();
//			UI.line();
//			UI.word("1. 회원관리");
//			UI.word("2. 관리");
//			UI.word("3. 가나다라마바사아자차카");
//			UI.word("0. 종료");
//			UI.dbline();
//			work();
//			work2();
//			work3();
//			dummy();
//			dummy2();
//			remake();
//		Connection conn = null;
//		Statement stat = null;
//		
//		try {
//			
//			conn = Util.open();
//			stat = conn.createStatement();
//			
//			if (!conn.isClosed()) {
//				System.out.println("연결?");
//				
//				String sql = "drop table test";
//				stat.executeUpdate(sql);
//				
//				System.out.println("완료?");
//				
//			} else {
//				System.out.println("DB 연결이 원활하지 않습니다. 관리자에게 연락하세요");
//			}
//			
//			stat.close();
//			conn.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
//
//	private static void work3() {
//		try {
//			BufferedWriter writer = new BufferedWriter(new FileWriter("예비군.txt"));
//			testDTO dto = new testDTO();
//			Random ran = new Random();
//			int i = 1;
//			
//			for (int a=1;a<2001;a++){
//				String[] sur = {"김","이","박","최","정","장","조","양","한","서","오","남궁","황보","강","유","원","윤","성","황","안",
//						"김","이","박","김","이","박","최","정","조","한","유","김","이","박"};
//				String[] aname = {"동","현","선","영","민","주","대","지","흥","기","화","상","성","병","석","공","왕","전","연","덕","용","시","경","재","헌","길"};
//				String[] bname = {"광","온","고","명","신","배","춘","도","하","효","규","진","호","혁","빈","후","무","천","수","환","완","창","회","보","균","서","한","안","조"};
//				String name = sur[ran.nextInt(sur.length)]+aname[ran.nextInt(aname.length)]+bname[ran.nextInt(bname.length)];
//				
//				String tel = "010"+(ran.nextInt(99999999-10000000)+10000000);
//				String done;
//				int y = (ran.nextInt(17+1-11)+11);
//				int m = (ran.nextInt(12)+1);
//				int d = (ran.nextInt(31)+1);
//				if (y < 14) {
//					done = "동미참";
//				} else {
//					done = "동원";
//				}
//				String yy; String mm = null;
//				if (y < 10) {
//					yy = "0"+y;
//				} else {
//					yy = y+"";
//				}
//				switch (m) {
//				case 1:
//					mm = "0"+m;
//					break;
//				case 2:
//					mm = "0"+m;
//					if (d > 28) d = (ran.nextInt(28)+1);
//					break;
//				case 3:
//					mm = "0"+m;
//					break;
//				case 4:
//					mm = "0"+m;
//					if (d > 30) d = (ran.nextInt(30)+1);
//					break;
//				case 5:
//					mm = "0"+m;
//					break;
//				case 6:
//					mm = "0"+m;
//					if (d > 30) d = (ran.nextInt(30)+1);
//					break;
//				case 7:
//					mm = "0"+m;
//					break;
//				case 8:
//					mm = "0"+m;
//					break;
//				case 9:
//					mm = "0"+m;
//					if (d > 30) d = (ran.nextInt(30)+1);
//					break;
//				case 10:
//					mm = m+"";
//					break;
//				case 11:
//					mm = m+"";
//					if (d > 30) d = (ran.nextInt(30)+1);
//					break;
//				case 12:
//					mm = m+"";
//					break;
//				}
//				String dd = d+"";
//				if (d < 10) {
//					dd = "0"+d;
//				}
//				String released = yy+mm+dd;
//				y = y - 2;
//				if (y < 10) {
//					yy = "0"+y;
//				} else {
//					yy = y+"";
//				}
//				String seq = yy+"-"+(ran.nextInt(99999999-10000000)+10000000);
//				
//				String valid = "완료";
//				
//				String[] tarmy = {"육군", "육군", "육군", "육군", "육군", "육군", "해군", "공군", "해병"};
//				String army = tarmy[ran.nextInt(tarmy.length)];
//				
//				String[] trank = {"이병", "일병", "상병", "하사", "중사", "소위", "중위", "대위",
//						"병장","병장","병장","병장","병장","병장","병장","병장","병장","병장","병장","병장","병장","병장","병장"};
//				String rank = trank[ran.nextInt(trank.length)];
//				
//				String num = (ran.nextInt(221)+1)+"";
//				
//				String total = "insert into lrt values (lrtSeq.nextval,'"+name+"','"+tel+"','"+released+"','"+seq+"','"+valid+"','"+
//						army+"','"+rank+"','"+done+"',"+num+","+i+");";
//				
//				if (a%100 == 0) {
//					i++;
//					System.out.println(i);
//				}
//				
//				writer.write(total);
//				writer.newLine();
//			}
//			writer.close();
//			System.out.println("완료");
//		} catch (Exception e) {
//			System.out.println("### test.work3 ###");
//			e.printStackTrace();
//		}
//		
//	}
//
//	private static void work2() {
//
//		try {
//			ArrayList<SchedulelrtDTO> sList = new ArrayList<SchedulelrtDTO>();
//			BufferedReader reader = new BufferedReader(new FileReader ("예비군.txt"));
//			String copy = null;
//			int count = 1;
//			while ((copy = reader.readLine()) != null) {
//				SchedulelrtDTO s = new SchedulelrtDTO();
//				String[] temp = copy.split(",");
////					System.out.println(temp[0]+temp[1]+temp[2]+temp[3]+temp[4]+temp[5]+temp[6]+temp[7]+temp[8]+temp[9]);
//				String endday = temp[3].substring(1, 3);
//				if (Integer.parseInt(endday)>12) {
//					s.setSeq(temp[0]);
//					s.setAseq("1");
//					s.setRseq(count+"");
//					s.setState("null);");
//					sList.add(s);
//					System.out.println("!!!");
//				} else {
//					s.setSeq(temp[0]);
//					s.setAseq("2");
//					s.setRseq(count+"");
//					s.setState("null);");
//					sList.add(s);
//					System.out.print(".");
//				}
//				count++;
//			}//while
//			reader.close();
//			
//			BufferedWriter writer = new BufferedWriter(new FileWriter ("일정+예비군.txt"));
//			
//			for(SchedulelrtDTO n : sList) {
//				String line = String.format("insert into schedulelrt values (schedulelrtSeq.nextval,%s,%s,%s",n.getAseq(),n.getRseq(),n.getState());
//				writer.write(line);
//				writer.newLine();
//			}
//			writer.close();
//			
//		} catch (Exception e) {
//			System.out.println("### test.work2 ###");
//			e.printStackTrace();
//		}
//	}
//
//	private static void dummy2() {
//		
//		String a = "insert into allschedule values (allscheduleSeq.nextval,";
////		360개
//		try {
//			BufferedWriter writer = new BufferedWriter(new FileWriter("일정목록.txt"));
//			int e = 1;
//			for (int b=1;b<19;b++){
//				for (int d=1;d<21;d++) {
//					if (b%3 == 1) {
//						for (int c=1;c<4;c++){
//							String total = (a+e+","+c+");");
//							writer.write(total);
//							writer.newLine();
//						}
//					} else if (b%3 == 2) {
//						for (int c=4;c<7;c++){
//							String total = (a+e+","+c+");");
//							writer.write(total);
//							writer.newLine();
//						}
//					} else {
//						for (int c=7;c<9;c++) {
//							String total = (a+e+","+c+");");
//							writer.write(total);
//							writer.newLine();
//						}
//					}
//					e++;
//				}
//			}
//			writer.close();
//			System.out.println("완료");
//		} catch (Exception e) {
//			System.out.println("### test.dummy2 ###");
//			e.printStackTrace();
//		}
//		
//	}
//
//	private static void dummy() {
//	
//		Random rnd = new Random();
//		String a = "insert into mobilschedule values (mobilscheduleSeq.nextval,";
//		String[] day = {"'170801'", "'170802'", "'170803'", "'170816'", "'170817'", "'170818'",
//						"'171001'", "'171002'", "'171003'", "'171016'", "'171017'", "'171018'"}; 
//		String[] pay = {"30000", "20000", "25000", "10000", "15000"};
//		String total;
//		int food = 1;
//		int daycount = 0;
//		
//		try {
//			BufferedWriter writer = new BufferedWriter(new FileWriter("전체세부일정.txt"));
//			for (int schedule=1;schedule<5;schedule++) {
//				for (int bigcount=1;bigcount<4;bigcount++) {
//					for (int place=1;place<21;place++) {
//						if (food == 51) {
//							food = 1;
//						}
//						total = a+day[daycount]+","+(pay[rnd.nextInt(pay.length)]+","+schedule+","+food+","+place+");");
//						writer.write(total);
//						writer.newLine();
//						food++;
//					}
//				daycount++;
//				}
//			}
//			writer.close();
//			System.out.println("완료");
//		} catch (Exception e) {
//			System.out.println("### test.dummy ###");
//			e.printStackTrace();
//		}
//		
//		
//		
//	}
//
//	public static void work() {
//		
//		try {
//			ArrayList<SchedulelrtDTO> sList = new ArrayList<SchedulelrtDTO>();
//			BufferedReader reader = new BufferedReader(new FileReader ("yebigun.txt"));
//			BufferedReader reader2 = new BufferedReader(new FileReader ("yebigun2.txt"));
//			String copy = null;
//			String copy2 = null;
//			int count = 1;
//			
//			while ((copy2 = reader2.readLine()) != null) {
//				String[] temp2 = copy2.split(",");
//				SchedulelrtDTO s = new SchedulelrtDTO();
////				System.out.println(temp2[0]+temp2[1]+temp2[2]+temp2[3]);
//				String num = temp2[2];
//				while ((copy = reader.readLine()) != null) {
//					String[] temp = copy.split(",");
////					System.out.println(temp[0]+temp[1]+temp[2]+temp[3]+temp[4]+temp[5]+temp[6]+temp[7]+temp[8]+temp[9]);
//					String endday = temp[3].substring(1, 3);
//					System.out.print(num+" ");
//					System.out.println(count+" ");
//					System.out.println(endday);
//					if (Integer.parseInt(num) == count && Integer.parseInt(endday)>12) {
//						String state = "null);";
//						String aseq = "12";
//						String training = temp[9];
//						switch (training) {
//							case "4":
//								aseq = "15";
//								break;
//							case "5":
//								aseq = "15";
//								break;
//							case "6":
//								aseq = "15";
//								break;
//							case "7":
//								aseq = "15";
//								break;
//							case "14":
//								aseq = "15";
//								break;
//							case "15":
//								aseq = "15";
//								break;
//							case "19":
//								aseq = "15";
//								break;
//							case "20":
//								aseq = "15";
//								break;
//						}
//						s.setSeq(temp2[0]);
//						s.setAseq(aseq);
//						s.setRseq(temp2[2]);
//						s.setState(state);
//						sList.add(s);
//						System.out.println("!!!");
//					} 
//					count++;
//				}//while
//				s.setSeq(temp2[0]);
//				s.setAseq(temp2[1]);
//				s.setRseq(temp2[2]);
//				s.setState(temp2[3]);
//				sList.add(s);
//				System.out.print(".");
//				
//				count = 1;
//			}//while
//			reader2.close();
//			reader.close();
//			
//			BufferedWriter writer = new BufferedWriter(new FileWriter ("yebigun2new.txt"));
//			
//			for(SchedulelrtDTO n : sList) {
//				String line = String.format("%s,%s,%s,%s",n.getSeq(),n.getAseq(),n.getRseq(),n.getState());
//				writer.write(line);
//				writer.newLine();
//			}
//			writer.close();
//			
//		} catch (Exception e) {
//			System.out.println("### test.work ###");
//			e.printStackTrace();
//		}
//	}

	private static void test1() {
//		Calendar test = Calendar.getInstance();
//		test.set(2017, 02, 31);
		
		Calendar test2 = new GregorianCalendar(2017, 02, 30);
		System.out.printf("%d-%d-%d\n", test2.get(Calendar.YEAR), test2.get(Calendar.MONTH), test2.get(Calendar.DATE));
		
		
	
	}
}
