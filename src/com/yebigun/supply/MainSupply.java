package com.yebigun.supply;

import com.yebigun.main.UI;

public class MainSupply {
	
	public void start(String troopSeq) {
		
		String input;
		boolean loop = true;
        
        while (loop) {
        	
			UI.clear();
			UI.word("보급 업무");
			UI.dbline();
			UI.word("1. 총기관리");
			UI.word("2. 탄약관리");
			UI.word("3. 수류탄관리");
			UI.word("4. 보급품관리");
			System.out.println();
			UI.word("0. 이전 메뉴로");
			System.out.println();
			UI.line();
			input = UI.input();
			
			if (input.equals("1")) {
				
			} else if (input.equals("2")) {
				SubMainAm s2 = new SubMainAm();
				s2.start(troopSeq);
			} else if (input.equals("3")) {
				SubMainExp s3 = new SubMainExp();
				s3.start(troopSeq);
			} else if (input.equals("4")) {
				SubMainSupply s4 = new SubMainSupply();
				s4.start(troopSeq);

			} else if (input.equals("0")) {
				loop = UI.backPause();
			} else {
				UI.requestPause();
			}

        }
	}
}
	
	/*
	
	
	



    private static void updateSupply()
    {
          System.out.println("보급품 수정");
          
          System.out.println("1. 기존 번호: ");
          String seq = sc.nextLine();
          
          System.out.println("2. 변경될 보급품: ");
          String name = sc.nextLine();
          
          String sql = "update supply set name=? where seq=?";
          
          try
          {
                PreparedStatement pstat = conn.prepareStatement(sql);
                
                pstat.setString(1, name);
                pstat.setString(2, seq);
                
                pstat.executeQuery();
                
                System.out.println("변경완료");
          }
          catch (Exception e)
          {
                e.printStackTrace();
          }
          sc.nextLine();
          
    }

    private static void deleteSupply()
    {
         System.out.println("보급품 삭제");
         
         System.out.println("보급물품: ");
         String seq = sc.nextLine();
         
         String sql = "delete from supply where seq="+seq;
         
         try
    {
               int result = stat.executeUpdate(sql);
               if(result>0)
                     System.err.println("보급품 삭제");
               else
                     System.out.println("존재하지 않는 번호 입니다.");
    }
    catch (Exception e)
    {
          e.printStackTrace();
    }
          
    }

    private static void addSupply()
    {
          System.out.println("**보급물품 추가");
          
          System.out.println("추가 물품: " );
          String name = sc.nextLine();
          
          String sql = String.format("insert into supply values(supplyseq.nextval, '%s')",name);
          
          try
          {
                stat.executeUpdate(sql);
                System.out.println("보급품 추가");
          }
          catch (Exception e)
          {
                e.printStackTrace();
          }
    }

    private static void GRENADElist()
    {
          {
                
                System.out.println("보급수류탄 관리");
                
                String sql = "select * from GRENADE";
                
                try
                {
                      ResultSet rs = stat.executeQuery(sql);
                      
                      while(rs.next()) {
                            System.out.printf("%s\t%s\t%s\n"
                                        ,rs.getString("seq")
                                        ,rs.getString("name")
                                        ,rs.getString("typ"));
                      }
                      System.out.println("1.수류탄추가");
                      System.out.println("2.수류탄삭제");
                      System.out.println("3.수류탄변경");
                      
                      int a = sc.nextInt();
                      sc.nextLine();
                      
                      if(a==1)  addGRENADE();
                      else if (a==2) deleteGRENADE();
                      else if (a==3) updateGRENADE();
                }
                catch (Exception e)
                {
                      System.out.print(e.toString());
                }
                
          }
          
    }

    private static void updateGRENADE()
    {
          System.out.println("수류탄 수정");
          
          System.out.print("1. 기존 번호: ");
          String seq = sc.nextLine();
          
  
          System.out.print("2. 변경될 수류탄명: ");
          String name = sc.nextLine();
          
          System.out.print("3. 변경될 수류탄타입: ");
          String typ = sc.nextLine();
          
          
          
          String sql = "update GRENADE set  name =?, TYP=? where seq =?";
          
          try
          {
               
                PreparedStatement pstat = conn.prepareStatement(sql);
                
                pstat.setString(1, name);
                pstat.setString(2, typ);
                pstat.setString(3, seq);
              
                
                pstat.executeQuery();
                
                System.out.println("변경완료");
                
          }
          catch (Exception e)
          {
                e.printStackTrace();
          }
          sc.nextLine();
    }

    private static void deleteGRENADE()
    {
          System.out.println("수류탄삭제");
          System.out.println("번호: ");
          String seq = sc.nextLine();
          
          String sql = "delete from GRENADE where SEQ="+seq;
          
          try
        {
              int result = stat.executeUpdate(sql);
              if(result>0)
                    System.err.println("수류탄 삭제");
              else
                    System.out.println("존재하지 않는 번호 입니다.");
              
                
        }
        catch (Exception e)
        {
              e.printStackTrace();
        }
          sc.nextLine();
          
    }

    private static void addGRENADE()
    {
          System.out.println("**수류탄 추가**");
          
          
          System.out.println();
         
          
          System.out.print("추가할 수류탄명: ");
    
          String name = sc.nextLine();
          
          System.out.print("추가할 수류탄타입: ");
          String TYP = sc.nextLine();
          TYP = TYP.replace("'","''");
          
          String sql = String.format("insert into GRENADE values (GRENADESEQ.nextval, '%s','%s')",name,TYP);
          
          try
          {
         
                stat.executeUpdate(sql);
                System.out.println("수류탄 추가");
          }
          catch (Exception e)
          {
                e.printStackTrace();
          }
          sc.nextLine();  
          
    }

    private static void AAMMUNITIONlsit()
    {

          System.out.println("보급탄약 관리");
          
          String sql = "select * from AMMUNITION";
          
          try
          {
                ResultSet rs = stat.executeQuery(sql);
                
                while(rs.next()) {
                      System.out.printf("%s\t%s\t%s\n"
                                  ,rs.getString("seq")
                                  ,rs.getString("name")
                                  ,rs.getString("typ"));
                }
                System.out.println("1.탄약추가");
                System.out.println("2.탄약삭제");
                System.out.println("3.탄약변경");
                
                int a = sc.nextInt();
                sc.nextLine();
                
                if(a==1)  addAMMUNITION();
                else if (a==2) deleteAMMUNITION();
                else if (a==3) updateAMMUNITION();
          }
          catch (Exception e)
          {
                System.out.print(e.toString());
          }
          
    }

    private static void updateAMMUNITION()
    {
System.out.println("수류탄 수정");
          
          System.out.print("1. 기존 번호: ");
          String seq = sc.nextLine();
          
  
          System.out.print("2. 변경될 탄약명: ");
          String name = sc.nextLine();
          
          System.out.print("3. 변경될 탄약타입: ");
          String typ = sc.nextLine();
          
          
          
          String sql = "update AMMUNITION set  name =?, TYP=? where seq =?";
          
          try
          {
               
                PreparedStatement pstat = conn.prepareStatement(sql);
                
                pstat.setString(1, name);
                pstat.setString(2, typ);
                pstat.setString(3, seq);
              
                
                pstat.executeQuery();
                
                System.out.println("변경완료");
                
          }
          catch (Exception e)
          {
                e.printStackTrace();
          }
          sc.nextLine();
    }

    private static void deleteAMMUNITION()
    {
          System.out.println("탄약삭제");
          
          System.out.println("번호: ");
          String seq = sc.nextLine();
          
          String sql = "delete from AMMUNITION where SEQ="+seq;
          
          try
        {
              int result = stat.executeUpdate(sql);
              if(result>0)
                    System.err.println("탄약 삭제");
              else
                    System.out.println("존재하지 않는 번호 입니다.");
              
                
        }
        catch (Exception e)
        {
              e.printStackTrace();
        }
          sc.nextLine();
          
    }

    private static void addAMMUNITION()
    {
          System.out.println("**탄약 추가**");
          
          
          System.out.println();
         
          
          System.out.print("추가할 탄약명: ");
    
          String name = sc.nextLine();
          
          System.out.print("추가할 탄약타입: ");
          String TYP = sc.nextLine();
          TYP = TYP.replace("'","''");
          
          String sql = String.format("insert into AMMUNITION values (AMMUNITIONSEQ.nextval, '%s','%s')",name,TYP);
          
          try
          {
         
                stat.executeUpdate(sql);
                System.out.println("탄약 추가");
          }
          catch (Exception e)
          {
                e.printStackTrace();
          }
          sc.nextLine();  
          
    }

    private static void GunManagerlist()
    {
          System.out.println("총기관리");
          
          String sql = "select * from gunManager";
          
          try
          {
                ResultSet rs = stat.executeQuery(sql);
                
                while(rs.next()) {
                      
                      System.out.printf("%s\t%s\t%s\t%s\n"
                                        ,rs.getString("seq")
                                        ,rs.getString("num")
                                        ,rs.getString("typ")
                                        ,rs.getString("state"));
                }
                System.out.println("1.총기추가");
                System.out.println("2.총기삭제");
                System.out.println("3.총기변경");
                int a = sc.nextInt();
                sc.nextLine();
                
                if(a==1)  addGun();
                else if (a==2) deletegun();
                else if (a==3) updategun();
                
                
                
                
          }
          catch (Exception e)
          {
                e.printStackTrace();
          }
          
    }

    private static void updategun()
    {
          System.out.println("총기수정");
          
          System.out.println("기존 번호: ");
          String seq = sc.nextLine();
          
  
          System.out.println("변경될 총기번호");
          String num = sc.nextLine();
          
          System.out.println("변경될 총기명");
          String typ = sc.nextLine();
          
          System.out.println("고장유무");
          String state = sc.nextLine();
          
          
          String sql = "update GUNMANAGER SET num=?, typ=?, state=? where seq=?";
          //String sql = "update GUNMANAGER SET ?=num, ?=TYP, ?=state, where ?=seq";
          //String sql = String.format("update GUNMANAGER set ('%s'=v2seq, '%s'=vnum, '%s'=vtyp, '%s'=vstate where '%s'="+v1seq),;
         // update GUNMANAGER SET num = 3082, typ = '소총임',  state = '비정상'  where seq = 3082;
            
          //String sql = String.format("insert into GunManager values (GUNMANAGERSEQ.nextval, '%s','%s','%s')",NUM,TYP,STATE);
          //sql = "insert into tblAddress values (addressSeq.nextval,?,?,?,?,default,?)";
          
          
          //String sql = "update GUNMANAGER SET num = " +num+ ", typ = '" +typ+ "',  state = '" +state+ "' where seq = " +seq;
          
          try
          {
               
                PreparedStatement pstat = conn.prepareStatement(sql);
                
                pstat.setString(1, num);
                pstat.setString(2, typ);
                pstat.setString(3, state);
                pstat.setString(4, seq);
                
                pstat.executeQuery();
                
//                if(pstat>0)
//                      System.err.println("총기 수정");
//                else
//                      System.out.println("존재하지 않는 번호 입니다.");
                
          }
          catch (Exception e)
          {
                e.printStackTrace();
          }
          sc.nextLine();
    }

    private static void deletegun()
    {
            System.out.println("총기삭제");
            
            System.out.println("번호: ");
            String seq = sc.nextLine();
            
            String sql = "delete from GUNMANAGER where SEQ="+seq;
            
            try
          {
                int result = stat.executeUpdate(sql);
                if(result>0)
                      System.err.println("총기 삭제");
                else
                      System.out.println("존재하지 않는 번호 입니다.");
                
                  
          }
          catch (Exception e)
          {
                e.printStackTrace();
          }
            sc.nextLine();
    }

    private static void YebigunList()
    {
          System.out.println("부대 소속 예비군 확인");
          
          String sql = "select * from lrt";
          
          
          
          try
     {
          ResultSet rs = stat.executeQuery(sql);
          
          
          while(rs.next()) {
                
         
          System.out.printf("%s%5s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t\n"
                      ,rs.getString("Seq")
                      ,rs.getString("name")
                      ,rs.getString("tel")
                      ,rs.getString("endday")
                      ,rs.getString("num")
                      ,rs.getString("state")
                      ,rs.getString("soldier")
                      ,rs.getString("rank")
                      ,rs.getString("pseq")
                      ,rs.getString("tseq"));
            
                   
                      
                  
          
          }
    
          
     }
     catch (Exception e)
     {
           e.printStackTrace();
           
     }
          sc.nextLine();
          
     }

    private static void addGun()
    {
          System.out.println("**총기 추가**");
          
          System.out.println("추가할 총기: ");
          String NUM = sc.nextLine();
          
          System.out.println();
          //NUM = NUM.replace("'","''");
          
          System.out.print("추가할 총기번호: ");
          //int typ = sc.nextInt();
          String TYP = sc.nextLine();
          
          System.out.print("상태: ");
          String STATE = sc.nextLine();
          STATE = STATE.replace("'","''");
          
          String sql = String.format("insert into GunManager values (GUNMANAGERSEQ.nextval, '%s','%s','%s')",NUM,TYP,STATE);
          
          try
          {
         
                stat.executeUpdate(sql);
                System.out.println("총기 추가");
          }
          catch (Exception e)
          {
                e.printStackTrace();
          }
          sc.nextLine();
    }
          
    }

*/