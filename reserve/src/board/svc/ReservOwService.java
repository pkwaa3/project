package board.svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ReservationDAO;

import static db.JdbcUtil.*;
import vo.Reservation;

public class ReservOwService {

	public ArrayList<Reservation> getInfo(int rest_no) {
		ArrayList<Reservation> list = null;
		Connection con = null;
		
		try {
			con=getConnection();
			ReservationDAO reservDAO = ReservationDAO.getInstance();
			reservDAO.setConnection(con);
			
			list=reservDAO.getOwList(rest_no);
			
		}catch(Exception e) {
			
		}finally {
			close(con);
		}
		return list;
	}

}
