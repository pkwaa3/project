package owner.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;


import dao.RestaurantDAO;
import vo.Restaurant;

public class MarketModInfoProSvc {

	public boolean modifyRestaurantInfo(Restaurant restaurant) {
		boolean isModifySuccess = false;
		Connection con = null;
		
		try {
			con = getConnection();
			RestaurantDAO restaurantDao = RestaurantDAO.getInstance();
			restaurantDao.setConnection(con);
			
			int updateCount = restaurantDao.updateRestaurant(restaurant);
			
			if(updateCount > 0) {
				commit(con);
				isModifySuccess = true;
			} else {
				rollback(con);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		
		
		return isModifySuccess;
	}

}
