package board.svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.RestaurantDAO;

import static db.JdbcUtil.*;
import vo.Reservation;

public class RestaurantFindService {

	public String[] getName(ArrayList<Reservation> list) {
		String[] name = null;
		Connection con = null;
		
		try {
			con=getConnection();
			RestaurantDAO restDAO = RestaurantDAO.getInstance();
			restDAO.setConnection(con);
			
			name=restDAO.findName(list);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return name;
	}

}
