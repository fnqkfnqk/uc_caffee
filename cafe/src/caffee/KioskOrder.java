package caffee;

import java.util.Scanner;

public class KioskOrder {
	
	boolean wantToCancel = false;	// 주문 취소 여부
	boolean orderCheck = true;		//주문확인 결과
	public int[] stockMount = new int[7];
	
	Scanner sc = new Scanner(System.in);
	
	public KioskOrder() {
		start();
	}
	
	private void start() {
		aa();
	}
	
	private void aa() {
		while(!wantToCancel) {
			Mention m = new Mention();
			
			System.out.println(m.getMention1_welcome());
			System.out.println(m.geta());
			System.out.print(m.getMention2_where());
			String beverwhere = sc.nextLine();
			System.out.println(m.geta());
			printMenu();
			String beverkind = sc.nextLine();
			System.out.println(m.getMention4_ice_hot());
			String bevericehot = sc.nextLine();
			System.out.println(m.getMention5_shot());
			String bevershot = sc.nextLine();
			
			
		}
	}
	
	//메뉴 출력
	private void printMenu() {
		Menu_kor[] menukor = Menu_kor.values();
		Price p = new Price();
		int[] priceArr	= p.getBeveragePrice();
		
		System.out.println("\t----------------------");
		System.out.println("\t메뉴");
		for(int i = 0; i<Menu_kor.values().length; i++) {
			System.out.printf("\t%d. %s\t%d원\n", i+1, menukor[i], priceArr[i]);
		}
		System.out.println("\t----------------------");
	}
}
