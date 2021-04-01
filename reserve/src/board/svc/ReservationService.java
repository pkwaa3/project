package board.svc;

import vo.Reservation;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.ReservationDAO;
public class ReservationService {

	public boolean reservation(Reservation reservation) {
		boolean reserv = false;
		Connection con = null;
		
		
		try {
			con=getConnection();
			ReservationDAO reservDAO = ReservationDAO.getInstance();
			reservDAO.setConnection(con);
			
			reserv=reservDAO.reservation(reservation);
			
			
		}catch(Exception e) {
		e.printStackTrace();	
		}finally {
			close(con);
		}
		
		
		
		return reserv;
	}

}
