package cafe_class;

import java.util.Scanner;

public class Operation2_temper implements Operation{
	
	boolean[] bWantToCancelAndIsJuice;
	
	public Operation2_temper(boolean[] bWantToCancelAndIsJuice) {		// 
		this.bWantToCancelAndIsJuice = bWantToCancelAndIsJuice;
	}

	@Override
	 public boolean[] bExecute(Scanner sc) {
		int input 	= 0;				// 주문내역 저장
		boolean goToNext = false;			// 
		boolean wantToCancel = false;		// 리턴 객체
		String sTemper = null;	
		Orders order = OrderCollection.get_orderData();
		
		// 입력 반복문
		while(!goToNext) {
			Mention ment = new Mention();
			if(bWantToCancelAndIsJuice[1]) {		// bWantToCancelAndIsJuice[1] = isJucie임.
				System.out.println(ment.getMENT10_ICE_ONLY());
				sTemper = UnitChange.toString_temper(1);		// 이건 아이스 고정이니까 1로 두고 딸바를 하면 바로 추가주문으로 넘어가니까 취소는 필요없음.
				input = 1;										// 요청사항반영에 필요한 인자
				goToNext = true;
			}
			else {
				// 맨트 출력 및 입력값받기
				System.out.print(ment.getMENT2_TEMPER());
				String request = sc.next().toLowerCase();
				
				// 입력값이 숫자인지 확인
				boolean isNumber = CheckRequest.isNumber(request);
					// 만약 입력값이 숫자가 맞다면
					if(isNumber) {
						int changeStrToNum = Integer.parseInt(request);		// 위에 String 으로 받아온 숫자를 int로 변경
						int range = Menu_temper.values().length;				// 메뉴(enum) 범위
						
						// 입력받은 숫자가 범위에 존재하는지 확인
						if(0 < changeStrToNum && changeStrToNum < range+1) {
							input = changeStrToNum;			// 존재한다면 주문내역저장변수에 할당
							
							sTemper = UnitChange.toString_temper(changeStrToNum);
							
		            		goToNext = true;
		            	} else {System.out.println("번호를 다시 입력바랍니다 (1~2)");}         
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
//							bWantToCancelAndIsJuice[0] = true;		// wantToCancel 임.
		                	break;
		            	}
		            	else {System.out.println(ment.getMENT6_YN_ONLY());}
		            }
				}
			
			//요청사항 출력하기
			int iWhere = order.getWhere();
			int iMenu = order.getMenu_eng();
			String sWhere = UnitChange.toString_where(iWhere);
			String sMenu = UnitChange.toString_menu(iMenu);
			
			System.out.printf(">>> %s(%s/%s)\n", sMenu, sWhere, sTemper);
			
		    }
		
		
		//요청사항 반영
        order.setTemper(input);
    	
    	return bWantToCancelAndIsJuice;		// 주문계속진행시 false, 취소를 원할 시 true로
		}
			
}
