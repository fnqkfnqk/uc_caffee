package cafe_class;

public class Orders {
	
	private int menu_eng;	// 종류(1, 2, 3)
	private int temper;		// ice or hot(1, 2)
	private int where;		// store or to go(1, 2)
	private int money; 
	
	
	public int getMenu_eng() {
		return menu_eng;
	}
	public Orders setMenu_eng(int menu_eng) {
		this.menu_eng = menu_eng;
		return this;
	}
	public int getTemper() {
		return temper;
	}
	public Orders setTemper(int temper) {
		this.temper = temper;
		return this;
	}
	public int getWhere() {
		return where;
	}
	public Orders setWhere(int where) {
		this.where = where;
		return this;
	}
	public int getMoney() {
		return money;
	}
	public Orders setMoney(int money) {
		this.money = money;
		return this;
	}
	
	
}
