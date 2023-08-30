package cafe_class;

import java.util.List;

public class Making_drink {

	public Making_drink() {
		whatDrink();
	}
	 public static void whatDrink() {
		 	List<Orders> orderList = OrderCollection.get_orderList();;
	
		 	int menu = -1;
			int temper = -1;
			boolean isIce = false;
			
			for(Orders order: orderList) {
				menu = order.getMenu_eng();
		        temper = order.getTemper();
		        
		        if(temper == 1)isIce = true;
		    	
		        if (menu == 1) { // 아메리카노
		            makeAmericano(isIce);
		        } else if (menu == 2) { // 바닐라라떼
		            makeVanillaLatte(isIce);
		        } else if (menu == 3) { // 딸바주스
		            makeStrawberryBananaJuice();
		        }
	        }
			
	    }
	
	    public static void makeAmericano(boolean isIce) {
	        System.out.println("아메리카노 만들기 시작!");
	        System.out.print("원두 꺼내기");
	        staySec(5);
	        System.out.print("원두 가는 중");
	        staySec(10);
	        System.out.print("원두 내리기");
	        staySec(15);
	        if (isIce) { //아이스 아메리카노
	        	System.out.println("컵 가져오기");
	        	staySec(2);
	        	System.out.println("얼음 꺼내서 컵에 담기");
	        	staySec(3);
	        	System.out.println("샷 컵에 붓기");
	        	staySec(3);
	        	System.out.println("찬 물 컵에 꽉 채우기");
	        	staySec(3);
	        	System.out.println("섞는 중");
	        	staySec(3);
	        	System.out.println("아이스 아메리카노 완성~");
	        } else { //따듯한 아메리카노
	        	System.out.println("잔 가져오기");
	        	staySec(2);
	        	System.out.println("샷 잔에 붓기");
	        	staySec(3);
	        	System.out.println("따듯한 물 잔에 꽉 채우기");
	        	staySec(3);
	        	System.out.println("섞는 중");
	        	staySec(3);
	        	System.out.println("따뜻한 아메리카노 완성~");
	        }
	    }
	
	    public static void makeVanillaLatte(boolean isIce) {
	        System.out.println("바닐라라떼 만들기 시작!");
	        System.out.println("원두 꺼내기");
	        staySec(5);
	        System.out.print("원두 가는 중");
	        staySec(10);
	        System.out.print("원두 내리기");
	        staySec(15);
	        if (isIce) { //아이스
	        	System.out.println("컵 가져오기");
	        	staySec(2);
	        	System.out.println("얼음 꺼내서 컵에 담기");
	        	staySec(3);
	        	System.out.println("샷 컵에 붓기");
	        	staySec(3);
	        	System.out.println("냉장고에서 우유 꺼내서 컵에 꽉 채우기");
	        	staySec(5);
	        	System.out.println("시럽 1번 짜서 넣기");
	        	staySec(2);
	        	System.out.println("섞는 중");
	        	staySec(3);
	        	System.out.println("아이스 바닐라라떼 완성~");
	        } else { //따듯
	        	System.out.println("잔 가져오기");
	        	staySec(2);
	        	System.out.println("샷 잔에 붓기");
	        	staySec(3);
	        	System.out.println("냉장고에서 우유 꺼내서 우유 데우는 중");
	        	staySec(10);
	        	System.out.println("데운 우유 잔에 꽉 채우기");
	        	staySec(3);
	        	System.out.println("시럽 1번 짜서 넣기");
	        	staySec(2);
	        	System.out.println("섞는 중");
	        	staySec(3);
	        	System.out.println("따뜻한 바닐라라떼 완성~");
	        }
	    }
	
	    public static void makeStrawberryBananaJuice() {
	        System.out.println("딸기바나나주스 만들기 시작!");
	        System.out.println("딸기와 바나나 냉장고에서 꺼내기");
	    	staySec(3);
	    	System.out.println("딸기와 바나나 믹서기에 가는중");
	    	staySec(10);
	    	System.out.println("컵 가져오기");
	    	staySec(2);
	    	System.out.println("갈린 딸기와 바나나를 컵에 채우기");
	    	staySec(4);
	    	System.out.println("냉장고에서 우유 꺼내서 컵에 꽉 채우기");
	    	staySec(5);
	    	System.out.println("시럽 1번 짜서 넣기");
	    	staySec(2);
	    	System.out.println("섞는 중");
	    	staySec(3);
	    	System.out.println("딸기바나나주스 완성~");
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
