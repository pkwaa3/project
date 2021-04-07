package board.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import dao.MenuDAO;
import vo.Board;
import vo.Menu;

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

	public ArrayList<Menu> getMenuModInfo(String restNo) {
		ArrayList<Menu> menuList = null;
		Connection con = null;
		
		try {
			
			con = getConnection();
			MenuDAO menuDao = MenuDAO.getInstance();
			menuDao.setConnection(con);
			
			menuList = menuDao.selectModMenu(restNo);
		
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(con);
		}
		
		
		return menuList;
	}

}
