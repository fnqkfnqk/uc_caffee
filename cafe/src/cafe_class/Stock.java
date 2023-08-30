package cafe_class;

public enum Stock {
	COFFEEBEAN(1),
	ICE(2),
	WATER(3),
	MILK(4),
	STRAWBERRY(5),
	BANANA(6);
	
	private final int stock;

    Stock(int stock) {
        this.stock = stock;
    }

    public int getNumber() {
        return stock;
    }

}