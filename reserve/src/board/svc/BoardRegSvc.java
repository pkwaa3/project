package board.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.BoardDAO;

import vo.Board;

public class BoardRegSvc {

	public boolean registBoard(Board board) {
		boolean isBoardSuccess = false;
		Connection con = null;
		try {
			
			con = getConnection();
			BoardDAO boardDao = BoardDAO.getInstance();
			boardDao.setConnection(con);
			
			int insertCount = boardDao.insertBoard(board);
			
			if(insertCount > 0) {
				commit(con);
				isBoardSuccess = true;
			} else {
				System.out.println("보드 등록 실패");
				rollback(con);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		
		return isBoardSuccess;
	}
	

}
