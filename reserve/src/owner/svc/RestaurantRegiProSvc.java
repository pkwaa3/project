package owner.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;
import java.sql.Connection;
import dao.RestaurantDAO;
import vo.Restaurant;


public class RestaurantRegiProSvc {

	public boolean regiRestaurant(Restaurant restaurant) {
		
		boolean isRegiSuccess = false;
		RestaurantDAO restaurantDao = RestaurantDAO.getInstance();
		Connection con = getConnection();
		restaurantDao.setConnection(con);
		
		int insert = restaurantDao.insertRestaurant(restaurant);
		
		if(insert > 0 ) {
			isRegiSuccess =true;
			commit(con);
			
		} else {
			rollback(con);
			
		}
		
		close(con);
		return isRegiSuccess;
	}

}
