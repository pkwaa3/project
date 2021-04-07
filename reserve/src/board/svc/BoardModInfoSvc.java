package board.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.BoardDAO;
import vo.Board;

public class BoardModInfoSvc {

	public Board getboardModInfo(String restNo) {
		Board board = null;
		Connection con = null;
		
		try {
			
			con = getConnection();
			BoardDAO boardDao = BoardDAO.getInstance();
			boardDao.setConnection(con);
			
			board = boardDao.selectModBoard(restNo);
		
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(con);
		}
		
		
		return board;
	}

}
