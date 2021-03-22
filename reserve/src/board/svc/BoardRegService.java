package board.svc;

import java.sql.Connection;
import java.util.ArrayList;
import static db.JdbcUtil.*;
import dao.BoardDAO;
import vo.Board;
import vo.Menu;

public class BoardRegService {

	public boolean registArticle(Board board, ArrayList<Menu> list) {
		boolean isRegSuccess =false;
		Connection con = null;
		
		try {
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		int insertCount = boardDAO.insertArticle(board,list);
		
		if(insertCount>0) {
			commit(con);
			isRegSuccess=true;
		}else {
			rollback(con);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return isRegSuccess;
	}

}
