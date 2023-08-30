package cafe_class;

import java.util.List;
import java.util.Scanner;

public class Operation4_orderCheck implements Operation{

	public boolean[] bExecute(Scanner sc) {
        boolean goToNext 	= false;	//반복 플래그 변수
        boolean OrderCheck	= false;	//주문 확인결과 리턴
        boolean[] bOrderMoreAndDummy = new boolean[2];
		bOrderMoreAndDummy[0] =  OrderCheck;
		bOrderMoreAndDummy[1] =  false;
		int money = 0;
        
        //주문내역 출력하기
        List<Orders> orderList = OrderCollection.get_orderList(); 
        
        //OrderCollection 접근해서 List에 담긴 요청사항 출력하기
        System.out.println();
        for(Orders order: orderList) {   
        	int where = order.getWhere();
	        int menu = order.getMenu_eng();
	        int temper = order.getTemper();
	        
	        String str1 = UnitChange.toString_where(where);
	        String str2 = UnitChange.toString_menu(menu);
	        String str3 = UnitChange.toString_temper(temper);	
	        
			money += (UnitChange.toMoney_menu(menu) + UnitChange.toMoney_where(where));
			
	        System.out.printf("%s(%s/%s)\n", str2, str3, str1);
        }
        
        System.out.println("금액 : "+ money);
        System.out.print("결제하시겠습니까? (y/n): ");
        
        //주문확인 결과를 받기위한 반복문
        while(!goToNext) {
            Mention ment = new Mention();
            String request = sc.next().trim().toLowerCase();
            boolean isYesOrNo = CheckRequest.isYesOrNo(request);

            if(isYesOrNo) {
                if(request.equals("y")){
                    goToNext = true;
                    OrderCheck = true;
                    
                    bOrderMoreAndDummy[0] = OrderCheck;

                    break;
                } else if(request.equals("n")){
                    System.out.println(ment.getMENT5_ORDER_AGAIN());
                    goToNext = true;
                    break;
                }
            } else {
                System.out.println(ment.getMENT6_YN_ONLY());
            }
        }
        return bOrderMoreAndDummy;
    }
}

