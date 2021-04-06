package board.svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ReservationDAO;

import static db.JdbcUtil.*;
import vo.Reservation;

public class ReservInfoService {

	public ArrayList<Reservation> getInfo(int memberNo) {
		ArrayList<Reservation> list = null;
		Connection con = null;
		try {
			con=getConnection();
			ReservationDAO reservDAO = ReservationDAO.getInstance();
			reservDAO.setConnection(con);
			
			list=reservDAO.getList(memberNo);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		
		return list;
	}

	

}
