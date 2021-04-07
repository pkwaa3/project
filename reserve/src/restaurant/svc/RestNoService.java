package restaurant.svc;

import java.sql.Connection;

import dao.RestaurantDAO;

import static db.JdbcUtil.*;

public class RestNoService {

	public int getRestNo(int board_no) {
		int restNo = 0;
		Connection con = null;
		
		try {
			con=getConnection();
			RestaurantDAO restaurantDAO = RestaurantDAO.getInstance();
			restaurantDAO.setConnection(con);
			
			restNo = restaurantDAO.selectRestNo(board_no);
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return restNo;
	}

}
