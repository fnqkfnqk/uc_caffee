package cafe_class;
import java.util.Scanner;

public class Operation5_payment implements Operation{
	
	public Operation5_payment(Scanner sc) {
		bExecute(sc);
	}
	
	@Override
	public boolean[] bExecute(Scanner sc) {
		int input = 0; // 주문내역 저장
		boolean goToNext = false; //
		boolean wantToCancel = false; // 리턴 객체
		boolean paySuccess = false;
		Orders order = OrderCollection.get_orderData();
		
		boolean[] bOrderMoreAndDummy = new boolean[2];
		bOrderMoreAndDummy[0] =  wantToCancel;
		bOrderMoreAndDummy[1] =  paySuccess;

		// 입력 반복문
		while (!goToNext) {
			// 맨트 출력 및 입력값받기
			Mention ment = new Mention();
			System.out.print(ment.getMENT9_PAY_TOOL()); //1.카드,2.현금
			String request = sc.next().toLowerCase();
			// 입력값이 숫자인지 확인
			boolean isNumber = CheckRequest.isNumber(request);
			// 만약 입력값이 숫자가 맞다면
			if (isNumber) {
				int changeStrToNum = Integer.parseInt(request); // 위에 String 으로 받아온 숫자를 int로 변경
				int range = Pay_Tool.values().length; // 메뉴(enum) 범위

				// 입력받은 숫자가 범위에 존재하는지 확인
				if (0 < changeStrToNum && changeStrToNum < range + 1) {
					input = changeStrToNum; // 존재한다면 주문내역저장변수에 할당
					
					String sPay = UnitChange.toString_Pay(changeStrToNum);
					System.out.println(sPay+" 로 결제");
					
					System.out.println("재고 확인 후 결제가 마저 진행됩니다. 잠시만 기다려 주세요.");
					System.out.println();
					Operation6_checkstock.checkStock();
					
					if (sPay == "CASH") {
						System.out.print("현금을 넣어주세요 : ");
						int cashMoney = sc.nextInt();
						System.out.println("받은 금액 : " + cashMoney);
						int charge = cashMoney - (UnitChange.toMoney_menu(order.getMenu_eng()) + UnitChange.toMoney_where(order.getWhere()));
						if (charge>=0) {
							System.out.println("잔돈을 받아주세요 - > " + charge);
							System.out.println("받기 : (Enter)");
							sc.nextLine();
							sc.nextLine();
							System.out.println("주문이 완료됐습니다.");
							System.out.println("음료를 제조중이니 조금만 기다려 주세요.");
							// Making_drink 실행
						} else {
							System.out.println("돈이 부족합니다. 다시 결제해 주세요.");
							System.out.println();
							continue; //while문으로 처음부터
						}
						
					}else if(sPay == "CARD"){
						System.out.println("카드를 넣어주세요.");
						System.out.println("카드 넣기 : (Enter)");
						sc.nextLine();
						sc.nextLine();
						System.out.println("결제가 완료됐습니다. 카드를 뽑아주세요 : (Enter)");
						sc.nextLine();
						System.out.println("주문이 완료됐습니다.");
						System.out.println("음료를 제조중이니 조금만 기다려 주세요.");
						// Making_drink 실행
					} else {
						System.out.println("오류 발생");
					}
					
					paySuccess = true;
					bOrderMoreAndDummy[1] =  paySuccess;
					goToNext = true;
				} else {
					System.out.println("번호를 다시 입력바랍니다 (1~2)");
				}
			}
			// 결제 취소 시
			else if (request.equals("c")) {
				System.out.println(ment.getMENT4_CANCEL());

				// y or n 입력 확인
				request = sc.next().trim().toLowerCase();
				boolean isYesOrNo = CheckRequest.isYesOrNo(request);

				if (isYesOrNo && request.equals("y")) {
					System.out.println(ment.getMENT5_ORDER_AGAIN());
					wantToCancel = true;
					break;
				} else {
					System.out.println(ment.getMENT6_YN_ONLY());
				}
			}
		}

		// 요청사항 반영
		order.setTemper(input);

		return bOrderMoreAndDummy; // 주문계속진행시 false, 취소를 원할 시 true로
	}
}