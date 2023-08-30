package cafe_class;

import java.util.List;

public class Operation6_checkstock {
	
	public Operation6_checkstock() {}
	
	public static void checkStock() {
		
		List<Orders> orderList = OrderCollection.get_orderList();;
		StockInit stockinit = KioskOrder.stockinit;
		
		int[] stockmount = stockinit.getStockmont();
		
		int menu = -1;
		int temper = -1;
		
		// 주문 리스트 받기
		for(Orders order: orderList) {   
			
	        menu = order.getMenu_eng();
	        temper = order.getTemper();
	        
	        // 재고 확인
	        printStock(stockmount, menu, temper, stockinit);
	        
        } 
	}
	
	
	public static void printStock(int[] stockmount, int menu, int temper, StockInit stockinit) {
		
		if(menu == 1) { // 아메리카노
			System.out.println("재고 아메리카노");
			
			// 원두 부족 시
			if(stockmount[0]<=0) {
				StockRefill.refillstock(stockinit, 0);
				System.out.print("원두 리필 중");
				staySec(2);
				System.out.println("원두 리필 완료");
				System.out.println();
			
			}
			else {
				stockmount[0] -= 1;
			}
			// ICE 음료 주문 시
			if(temper == 1) {
				if(stockmount[1]<=0) {	// 얼음 부족 시
					StockRefill.refillstock(stockinit, 1);
					System.out.print("얼음 리필 중");
					staySec(2);
					System.out.println("얼음 리필 완료");
					System.out.println();
				
				}
				else {
					stockmount[1] -= 1;
				}
			}
		}
		else if(menu == 2) { // 바닐라라떼
			System.out.println("재고 바닐라라떼");
			// 원두 부족 시
			if(stockmount[0]<=0) {
				StockRefill.refillstock(stockinit, 0);
				System.out.print("원두 리필 중");
				staySec(2);
				System.out.println("원두 리필 완료");
				System.out.println();
			
			}
			else {
				stockmount[0] -= 1;	
			}
			// 우유 부족 시
			if(stockmount[4]<=0) {
				StockRefill.refillstock(stockinit, 4);
				System.out.print("우유 리필 중");
				staySec(2);
				System.out.println("우유 리필 완료");
				System.out.println();
				
			}
			else {
				stockmount[4] -= 1;
			}
			// ICE 음료 주문 시
			if(temper == 1) {
				if(stockmount[1]<=0) {
					StockRefill.refillstock(stockinit, 1);
					System.out.print("얼음 리필 중");
					staySec(2);
					System.out.println("얼음 리필 완료");
					System.out.println();
					
				}
				else {
					stockmount[1] -= 1;
				}
			}
		}
		else if(menu == 3) { // 딸바쥬스			
			System.out.println("재고 딸바쥬스");
			// 얼음 부족 시
			if(stockmount[1]<=0) {
				StockRefill.refillstock(stockinit, 1);
				System.out.print("얼음 리필 중");
				staySec(2);
				System.out.println("얼음 리필 완료");
				System.out.println();
				
			}
			else {
				stockmount[1] -= 1;
			}
			// 딸기 부족 시
			if(stockmount[5]<=0) {
				StockRefill.refillstock(stockinit, 5);
				System.out.print("딸기 리필 중");
				staySec(2);
				System.out.println("딸기 리필 완료");
				System.out.println();
				
			}
			else {
				stockmount[5] -= 1;
			}
			// 바나나 부족 시
			if(stockmount[6]<=0) {
				StockRefill.refillstock(stockinit, 6);
				System.out.print("바나나 리필 중");
				staySec(2);
				System.out.println("바나나 리필 완료");
				System.out.println();
				
			}
			else {
				stockmount[6] -= 1;
			}
			// 우유 부족 시
			if(stockmount[4]<=0) {
				StockRefill.refillstock(stockinit, 4);
				System.out.print("우유 리필 중");
				staySec(2);
				System.out.println("우유 리필 완료");
				System.out.println();
				
			}
			else {
				stockmount[4] -= 1;
			}
		}
		else {
			System.out.println("주문 오류");
		}
	}
	
	public static void staySec(int sec) {
        for (int i = sec; i > 0; i--) {
            System.out.print(". ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("sleep 실행 중 에러");
                e.printStackTrace();
            }
        }
        System.out.println();
    }
	
	
}