package caffee;

public class Americano {
	
	private int iQuantity = 1;
	private boolean bIsIce = false;
	private int iCoffeeBean = 1;
	private int iWater = 1;
	private int iIce = 0;
	
	public Americano() {}
	
	public Americano(int iQuantity, boolean bIsIce, int iCoffeeBean, int iWater, int iIce) {
		this.iQuantity = iQuantity;
		this.bIsIce = bIsIce;
		this.iCoffeeBean = iCoffeeBean;
		this.iWater = iWater;
		this.iIce = iIce;
	}
}
