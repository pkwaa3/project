package board.svc;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
public class CartSearchSvc {

	public String getboard(int restNo) {
		String boardNo=null;
		Connection con=null;
		
		try {
			con=getConnection();
			BoardDAO boardDAO= BoardDAO.getInstance();
			boardDAO.setConnection(con);
			
			boardNo=boardDAO.getNo(restNo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return boardNo;
	}

}
