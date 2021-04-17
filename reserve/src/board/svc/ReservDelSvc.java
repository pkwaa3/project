package board.svc;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
public class ReservDelSvc {

	public int delete(String reservNo) {
		int reservDel = 0;
		Connection con= null;
		
		try {
			con=getConnection();
			BoardDAO boardDAO=BoardDAO.getInstance();
			boardDAO.setConnection(con);
			
			reservDel=boardDAO.delete(reservNo);
			if(reservDel>0) {
				commit(con);
				reservDel=1;
			}else {
				rollback(con);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return reservDel;
	}

}
