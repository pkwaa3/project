package owner.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.OwnerDAO;
import dao.RestaurantDAO;
import vo.Owner;
import vo.Restaurant;

public class MarketInfoSvc {

	public Restaurant getRestaurant(String restNo) {
		Restaurant restaurant = null;
		Connection con = null;
		
		try {
			
			con = getConnection();
			RestaurantDAO restaurantDao = RestaurantDAO.getInstance();
			restaurantDao.setConnection(con);
			
			restaurant = restaurantDao.selectModRestaurant(restNo);
		
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(con);
		}
		
		
		return restaurant;
	}

}
