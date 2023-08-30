package cafe_class;

import java.util.Scanner;

//KioskOrder클래스  - receiveOrder() 메서드에서 호출함
public interface Operation {
	// override를 위해 선언
	boolean[] bExecute(Scanner sc);
	
	class CheckRequest{
		
		// 입력값이 숫자인지 확인하기
		public static boolean isNumber(String request){
            boolean isNum = false;
            try{
                Integer.parseInt(request);
                isNum = true;
            } catch (NumberFormatException nfe){
                nfe.getMessage();
            } catch (Exception e){
                e.getMessage();
            }
            return isNum;
        }
		
		// 입력값이 Yes 혹은 No인지 확인하기
		public static boolean isYesOrNo(String request) {
			boolean isYesOrNo = false;
			if(request.equals("y") || request.equals("n")) {isYesOrNo = true;}
			return isYesOrNo;
		}
	}
}
