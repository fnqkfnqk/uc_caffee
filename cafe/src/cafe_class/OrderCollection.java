package cafe_class;

import java.util.ArrayList;
import java.util.List;

public class OrderCollection {

	// 데이터 공유를 쉽게 하기 위해 singleton으로 구성함.
	
    private static OrderCollection orderSpec = null;
    private static List<Orders> orderList = null;
    private static Orders order = null;
    
    private OrderCollection(){	}

    public static OrderCollection getInstance(){
        if(orderSpec == null){
        	orderSpec = new OrderCollection();
        }
        return orderSpec;
    }

    public static List<Orders> get_orderList(){
        if(orderList == null){
        	orderList = new ArrayList<>();
        }
        return orderList;
    }
    
    public static Orders get_orderData() {
    	if(order == null) {
    		order = new Orders();
    	}
    	return order;
    }
    // 리스트 데이터 리셋하기.
//	private void resetData(){
//		orderList = null;
//	}
	
    // 리스트에 데이터 추가하기
	public List<Orders> add_oderInfo(Orders data){
		orderList = get_orderList();		// 새로운 ArrayList 생성
		
		// Orders에서 data받아오기
		Orders orderData = new Orders();
		orderData.setMenu_eng(data.getMenu_eng())
				.setTemper(data.getTemper())
				.setWhere(data.getWhere());
		
		orderList.add(orderData);
		
		return orderList;
	}
	
	// List에 담긴 정보 초기화
	public void reset_orderInfo() {
		orderList = null;
	}
    
}
