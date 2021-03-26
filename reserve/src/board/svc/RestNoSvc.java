package board.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.BoardDAO;
import dao.RestaurantDAO;

public class RestNoSvc {

	public int searchRestNo(String board_subject) {
		int rest_no = 0;
		Connection con = null;
		
		try {
			con=getConnection();
			RestaurantDAO restaurantDAO = RestaurantDAO.getInstance();
			restaurantDAO.setConnection(con);
			
			rest_no = restaurantDAO.searchRestNo(board_subject);
			
		}catch(Exception e) {
			e.printStackTrace();
		}		finally {
			close(con);
		}
	
		return rest_no;
	}
	

}
