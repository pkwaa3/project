package board.svc;

import vo.Reservation;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.ReservationDAO;
public class ReservationService {

	public boolean reservation(Reservation reservation) {
		boolean reserv = false;
		Connection con = null;
		int insertRe = 0;
		
		
		try {
			con=getConnection();
			ReservationDAO reservDAO = ReservationDAO.getInstance();
			reservDAO.setConnection(con);
			
			insertRe=reservDAO.reservation(reservation);
			
			if(insertRe>0) {
				commit(con);
				reserv=true;
			}else {
				rollback(con);
			}
			
		}catch(Exception e) {
		e.printStackTrace();	
		}finally {
			close(con);
		}
		
		
		
		return reserv;
	}

}
