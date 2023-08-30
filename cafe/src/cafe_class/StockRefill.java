package cafe_class;

public class StockRefill {
	
	public StockRefill() {}
	
	// 재고 리필
	// 100로 맞추기
	public static void refillstock(StockInit stockinit, int stockNum) {
		
		int[] stockmount;
		
		stockmount = stockinit.getStockmont();
		stockmount[stockNum] = 100;
		
		stockinit.setStockmont(stockmount);
	}
}
