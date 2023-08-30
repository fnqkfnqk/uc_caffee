package cafe_class;

import java.util.Scanner;

public class KioskOrder {
	public static StockInit stockinit = new StockInit();
	boolean wantToCancel = false;	// 주문 취소 여부
	boolean orderMore = true;		//추가주문 여부
	boolean orderCheck = true;		//주문확인 결과
	boolean[] bOperationlist = new boolean[2];
	Scanner sc = new Scanner(System.in);
	
	public KioskOrder() {
		initstock(stockinit);
		
		while(true) {
			reset();
			printName();
			start();
		}
	}
	
	// 재고 초기화
	private void initstock(StockInit stockinit) {
		
		int[] stockmount;
		
		stockmount = StockInit.initStock();
		
		stockinit.setStockmont(stockmount);
	}
	
	// 주문을 받고, 주문확인 후 결재하는 메서드 호출
	private void start() {
		wantToCancel= false;
        orderMore = true;
        orderCheck = true;

        //추가주문 여부
        while (orderMore) {
          	wantToCancel        = false;
        	boolean[] boolArr   = receiveOrder(); 
        	orderMore           = boolArr[0];
        }
        
      //주문확인 결과
        if(orderCheck){
            new Operation5_payment(sc);
            new Making_drink();
            new Receive_drink();
        } else {
        	orderMore = true;
        	orderCheck = true;
        	this.start();
        }

    }
	
	// Operation인터페이스객체를 호출하여 주문받기
	private boolean[] receiveOrder() {
		
		boolean[] booleans = new boolean[2]; 	// 추가주문여부와 취소여부를 저장할 boolean array
		
		while(!wantToCancel) {
			printMenu();
			Operation oper = null;		//	null로 초기화
			// To go or Store
            oper = new Operation0_where();
            bOperationlist = oper.bExecute(sc);
            wantToCancel = bOperationlist[0];
            if(wantToCancel) { reset(); break; }
            
            // 음료 종류
            oper = new Operation1_menu();
            bOperationlist = oper.bExecute(sc);
            wantToCancel = bOperationlist[0];
            if(wantToCancel) { reset(); break; }
            
            //음료 온도
            	/*  위에서 반환된 bOperationlist를 사용하기 위해
            	 *  Operation2_temper생성자를 만들어 bOperationlist[1]이 isJuice를 사용함.
            	 */ 
            oper = new Operation2_temper(bOperationlist);			
            bOperationlist = oper.bExecute(sc);
            wantToCancel = bOperationlist[0];
            if(wantToCancel) { reset(); break; }
            
            // 추가 주문
            oper = new Operation3_orderMore();
            bOperationlist = oper.bExecute(sc);
            orderMore = bOperationlist[0];
            
            // 추가주문을 하지 않는다면 주문확인으로 넘어감
            if(!orderMore) {			
            	oper = new Operation4_orderCheck();
            	bOperationlist = oper.bExecute(sc);
            	orderCheck = bOperationlist[0];
            	
            	break;
            }
           
		}
            
        booleans[0] = orderMore;
        booleans[1] = wantToCancel;
        return booleans;
	}
	
    //주문취소시 List를 null로 만듬
    private void reset(){
//        System.out.println("reset 호출");
        OrderCollection col = OrderCollection.getInstance();
        col.reset_orderInfo();
    }
    
    // 카페 이름 출력
    private void printName() {
    	Mention mention = new Mention();
    	
    	System.out.println(mention.getMENT_WELCOME());
    }
    
	//메뉴 출력
	private void printMenu() {
		Menu_kor[] menukor = Menu_kor.values();
		Menu_price price = new Menu_price();
		int[] priceArr	= price.getBeveragePrice();
		
		System.out.println("\t----------------------");
		System.out.println("\t메뉴");
		for(int i = 0; i<Menu_kor.values().length; i++) {
			System.out.printf("\t %d. %s\t%d원\n", i+1, menukor[i], priceArr[i]);
		}
		System.out.println("\t----------------------");
	}
}

