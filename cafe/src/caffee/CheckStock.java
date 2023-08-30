package caffee;

public class CheckStock {

	public Stock stock;
	static Kiosk kiosk;
	
	public CheckStock() {}
	
	public static void checkStock(Orders orders) {
		
		int beverKind = orders.getBeverKind();
		int beverShot = orders.getBeverShot();
		kiosk = new Kiosk();
		
		// 아메리카노
		if(beverKind == 0) {
						
			if(beverShot == 2) {
					
			}
			
		}
		else if(beverKind == 1) { // 바닐라라떼
						
		}
		else if(beverKind == 2) { // 딸바쥬스			
			
		}
	}
}