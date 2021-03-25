package board.svc;

import java.sql.Connection;
import java.util.ArrayList;
import static db.JdbcUtil.*;
import dao.BoardDAO;
import dao.MenuDAO;
import vo.Board;
import vo.Menu;

public class BoardRegService {

	public boolean registArticle(Board board) {
		boolean isBoRegSuccess =false;
		
		Connection con = null;
		
		try {
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int insertBoCount = boardDAO.insertArticle(board);
		
		if(insertBoCount>0) {
			commit(con);
			isBoRegSuccess=true;
		}else {
			rollback(con);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return isBoRegSuccess;
	}

	public boolean registArticle(ArrayList<Menu> list) {
		boolean isMeRegSuccess =false;
		Connection con = null;
		try {
			MenuDAO menuDAO = MenuDAO.getInstance();
			menuDAO.setConnection(con);
			int insertMeCount = menuDAO.insertArticle(list);
			if(insertMeCount>0) {
				commit(con);
				isMeRegSuccess=true;
			}else {
				rollback(con);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return isMeRegSuccess;
	}

}
