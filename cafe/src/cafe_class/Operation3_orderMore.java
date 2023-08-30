package cafe_class;

import java.util.Scanner;

public class Operation3_orderMore implements Operation{
	
	@Override
	public boolean[] bExecute(Scanner sc) {
		String request 		= "";		//입력 버튼
		boolean goToNext 	= false;	//반복 플래그 변수
		boolean orderMore	= false;	//추가 주문 여부 리턴
		boolean[] bOrderMoreAndDummy = new boolean[2];
		bOrderMoreAndDummy[0] =  orderMore;
		bOrderMoreAndDummy[1] =  false;
		
		Orders data = OrderCollection.get_orderData();			// OrderCollection클래스의 인스턴스 호출
		OrderCollection spec = OrderCollection.getInstance();
		spec.add_oderInfo(data);								// add_orderInfo() 메서드 호출(주문사항 list 에 삽입하기)

		// 추가 주문 여부 반복문
		while(!goToNext) {
			Mention ment = new Mention();
			System.out.print(ment.getMENT3_ORDER_MORE());
			request = sc.next().trim().toLowerCase();
			
			// y or n 입력확인
			boolean isYesOrNo = CheckRequest.isYesOrNo(request);
			if(isYesOrNo) {
				if(request.equals("y")) {
	        		orderMore = true;
	        		bOrderMoreAndDummy[0] =  orderMore;
	        	}
				else {
				}
	        	goToNext = true;
			}
			else {
				System.out.println(ment.getMENT6_YN_ONLY());
			}
		}
		return bOrderMoreAndDummy;
	}
}
