package board.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import dao.MenuDAO;
import vo.Board;
import vo.Menu;

public class MenuModProService {

	public boolean BoardModPro(Board board) {
		boolean isBoardModSuccess =false;
		
		Connection con = null;
		
		try {

		con = getConnection();

			con = getConnection();

		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int insertBoCount = boardDAO.updateArticle(board);
		
		if(insertBoCount>0) {
			commit(con);
			isBoardModSuccess=true;
		}else {
			rollback(con);
			
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return isBoardModSuccess;
	}

	public boolean MenuModPro(ArrayList<Menu> list) {
		boolean isMenuModSuccess =false;
		Connection con = null;
		try {
			con = getConnection();
			MenuDAO menuDAO = MenuDAO.getInstance();
			menuDAO.setConnection(con);
			int insertMeCount = menuDAO.updateArticle(list);
			
			if(insertMeCount>0) {
				commit(con);
				isMenuModSuccess=true;
			}else {
				rollback(con);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return isMenuModSuccess;
	}

}
