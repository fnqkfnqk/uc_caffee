package caffee;

public class Price {
	private final int Price01 = 1500;	// 아메리카노
	private final int Price02 = 3000;	// 바닐라라떼
	private final int Price03 = 4500;	// 딸바쥬스
	
	public int[] getBeveragePrice() {    	
    	int[] priceArr = {Price01, Price02, Price03};
    	return priceArr;
    }
}
