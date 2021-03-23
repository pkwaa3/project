package owner.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;


import dao.RestaurantDAO;
import vo.Restaurant;

public class OwnerRegiMarketListService {

	public ArrayList<Restaurant> getRestList(int owner_no) {
		ArrayList<Restaurant> restList = null;
		Connection con = null;
		try {
			con = getConnection();
			RestaurantDAO restaurantDAO = RestaurantDAO.getInstance();
			restaurantDAO.setConnection(con);
			
			restList = restaurantDAO.selectRestaurant(owner_no);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return restList;
	}

}
