package cafe_class;

import java.util.Scanner;

public class Operation1_menu implements Operation {

	@Override
	 public boolean[] bExecute(Scanner sc) {
		int input 	= 0;				// 주문내역 저장
		boolean goToNext = false;			// 
		boolean wantToCancel = false;		// 리턴 객체
		boolean[] bOrderMoreAndDummy = new boolean[2];
		bOrderMoreAndDummy[0] =  wantToCancel;
		bOrderMoreAndDummy[1] =  false;
		// 0: wantToCancel, 1: isSB
		Orders order = OrderCollection.get_orderData();
		
		// 입력 반복문
		while(!goToNext) {
			// 맨트 출력 및 입력값받기
			Mention ment = new Mention();
			System.out.print(ment.getMENT1_CHOOSE());
			String request = sc.next().toLowerCase();
			// 입력값이 숫자인지 확인
			boolean isNumber = CheckRequest.isNumber(request);
				// 만약 입력값이 숫자가 맞다면
				if(isNumber) {
					int changeStrToNum = Integer.parseInt(request);		// 위에 String 으로 받아온 숫자를 int로 변경
					int range = Menu_eng.values().length;				// 메뉴(enum) 범위
					
					// 입력받은 숫자가 범위에 존재하는지 확인
					if(0 < changeStrToNum && changeStrToNum < range+1) {
						input = changeStrToNum;			// 존재한다면 주문내역저장변수에 할당
						
						//요청사항 출력하기
						int iWhere = order.getWhere();
						String sWhere = UnitChange.toString_where(iWhere);
						String sMenu = UnitChange.toString_menu(changeStrToNum);
						System.out.printf("%s(%s)\n", sWhere, sMenu);
						
						if(input == 3) {
							bOrderMoreAndDummy[1] = true;
						}
						
						
	            		goToNext = true;
	            	} else {System.out.println("번호를 다시 입력바랍니다 (1~6)");}         
	            }
				// 주문 취소 시
				else if(request.equals("c")) {
					System.out.println(ment.getMENT4_CANCEL());
					
					//y or n 입력 확인
	            	request = sc.next().trim().toLowerCase();
	            	boolean isYesOrNo = CheckRequest.isYesOrNo(request);
	            	
	            	if(isYesOrNo && request.equals("y")) {
						System.out.println(ment.getMENT5_ORDER_AGAIN());
	                	wantToCancel = true;
	                	break;
	            	}
	            	else {System.out.println(ment.getMENT6_YN_ONLY());}
	            }
		    }
		
		//요청사항 반영
        order.setMenu_eng(input);
    	
    	return bOrderMoreAndDummy;		// 주문계속진행시 false, 취소를 원할 시 true로
		}
					
}


	
	

