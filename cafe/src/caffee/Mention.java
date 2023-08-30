package caffee;

public class Mention {

	private final String MENT01_welcome = "------------------------------------\n"
										+ " **** ㅇㅇ카페에 오신 것을 환영합니다 ****"
										+ "\n------------------------------------";
	private final String MENT02_where = "매장(1)/포장(2)을 선택하세요 (주문 취소: c) ";
	private final String MENT03_choose = "메뉴를 선택하세요 (주문 취소: c) ";
	private final String MENT04_ice_hot = "ICE(1)/HOT(2)을 선택하세요 (주문 취소: c) ";
	private final String MENT05_shot = "샷 추가를 선택하세요(y/n) (주문 취소: c) ";
	private final String MENT06_more = "추가 주문을 선택하세요(y/n) (주문 취소: c) ";
	private final String Ment07_ = "카드(1)/현금(2) 결제를 선택하세요 (주문 취소: c) ";
	
	private final String a = "------------------------------------";
	
	public String getMention1_welcome() {return MENT01_welcome;}
	public String getMention2_where() {return MENT02_where;}
	public String getMention3_choose() {return MENT03_choose;}
	public String getMention4_ice_hot() {return MENT04_ice_hot;}
	public String getMention5_shot() {return MENT05_shot;}
	public String getMention6_more() {return MENT06_more;}
	public String getMention7_() {return Ment07_;}
	
	public String geta() {return a;}
}
