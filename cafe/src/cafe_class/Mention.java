package cafe_class;

public class Mention {
	
	private final String MENT_WELCOME = "--------------------------------------\n"
										+ " **** Acorn 카페에 오신 것을 환영합니다 ****"
										+ "\n--------------------------------------";
	private final String MENT0_WHERE		= "\n1.매장이용(+500원) 2.테이크아웃(+0원) 선택 : ";
	private final String MENT1_CHOOSE	= "\n메뉴를 선택해주세요. (주문취소 c): ";
	private final String MENT2_TEMPER	= "\n2.ice 2.hot 선택 (주문취소 c): ";
    private final String MENT3_ORDER_MORE 	= "\n추가주문 하시겠습니까? (y/n): ";
    private final String MENT4_CANCEL		= "\n주문을 취소하시겠습니까? (y/n): ";
	private final String MENT5_ORDER_AGAIN 	= "\n주문이 취소되었습니다. 다시 입력해주세요";
	private final String MENT6_YN_ONLY		= "\ny 혹은 n을 입력바랍니다";
	private final String MENT7_NUMBER_ONLY 	= "\n숫자를 입력바랍니다";
	private final String MENT8_PAY = "\n결제를 시작합니다.";
	private final String MENT9_PAY_TOOL = "\n1.카드 2.현금 선책 (주문취소 c): ";
	private final String MENT10_ICE_ONLY 	= "\n ....주스는 자동으로 ICE로 선택됩니다....";
		
	public String getMENT_WELCOME() {
		return MENT_WELCOME;
	}
	public String getMENT0_WHERE() {
		return MENT0_WHERE;
	}
	public String getMENT1_CHOOSE() {
		return MENT1_CHOOSE;
	}
	public String getMENT2_TEMPER() {
		return MENT2_TEMPER;
	}
	public String getMENT3_ORDER_MORE() {
		return MENT3_ORDER_MORE;
	}
	public String getMENT4_CANCEL() {
		return MENT4_CANCEL;
	}
	public String getMENT5_ORDER_AGAIN() {
		return MENT5_ORDER_AGAIN;
	}
	public String getMENT6_YN_ONLY() {
		return MENT6_YN_ONLY;
	}
	public String getMENT7_NUMBER_ONLY() {
		return MENT7_NUMBER_ONLY;
	}
	public String getMENT8_PAY() {
		return MENT8_PAY;
	}
	public String getMENT9_PAY_TOOL() {
		return MENT9_PAY_TOOL;
	}
	public String getMENT10_ICE_ONLY() {
		return MENT10_ICE_ONLY;
	}
	
}
