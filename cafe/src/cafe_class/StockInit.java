package cafe_class;

//import java.util.ArrayList;
//import java.util.List;

public class StockInit {
	private int[] stockmount;
	
	public StockInit() {}
	
	public int[] getStockmont() {
		return stockmount;
	}

	public void setStockmont(int[] stockmount) {
		this.stockmount = stockmount;
	}	
	
	public static int[] initStock() {
//		System.out.println("초기화");
//		List<Integer> stockmount = new ArrayList<Integer>();
		int[] stockmount = new int[7];
		
		for(int i=0; i<stockmount.length; i++) {
			stockmount[i] = 0;
		}
		
		return stockmount;
	}
}
