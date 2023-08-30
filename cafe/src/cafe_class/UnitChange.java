package cafe_class;

public class UnitChange {

	// int로 입력받은 선택값 enum안에 있는 String 으로 변경하기
	
	public static String toString_menu(int i) {
		return Menu_kor.values()[--i].toString();		// Menu_eng를 한국어로 바꾸기
	}
	
	public static String toString_temper(int i) {
		if(i == 0){
			return "";
		}
		return Menu_temper.values()[--i].toString();
	}
	
	public static String toString_where(int i) {
		if(Menu_where.values()[--i].toString().equals(Menu_where.STORE.toString())) {
			return "매장이용";
		}
		return "테이크아웃";
	}
	
	public static String toString_Pay(int i) {
		if (i == 0) {
			return "";
		}
		return Pay_Tool.values()[--i].toString();
	}
	
	/*------------------------------------------*/
	//선택메뉴(int) -> 금액(int)으로 변경
	public static int toMoney_menu(int i) {
		Menu_price p = new Menu_price();
		return p.getBeveragePrice()[i - 1];  	// list로 저장되어 있으므로 -1
	}
	
	public static int toMoney_where(int i){
		int money = 0;
		if(i==1){
			money = 500;
		}
		return money;
	}
}
