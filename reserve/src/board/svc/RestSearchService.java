package board.svc;

import java.sql.Connection;

import dao.BoardDAO;

import static db.JdbcUtil.*;
import vo.Board;

public class RestSearchService {

	public int findRestNo(String board1) {
		int rest_no = 0;
		Connection con = null;
		
		try {
			con=getConnection();
			BoardDAO boardDAO = BoardDAO.getInstance();
			boardDAO.setConnection(con);
			
			rest_no = boardDAO.findRestNo(board1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}		finally {
			close(con);
		}
	
		return rest_no;
	}

}
