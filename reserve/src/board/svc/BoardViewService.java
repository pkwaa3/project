package board.svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import dao.MenuDAO;

import static db.JdbcUtil.*;
import vo.Board;
import vo.Menu;

public class BoardViewService {

	public Board getArticle(int board_no) {
		Board board =null;
		Connection con = null;
		
		try {
			con =getConnection();
			BoardDAO boardDAO = BoardDAO.getInstance();
			boardDAO.setConnection(con);
			
			int readCount = boardDAO.readCount(board_no);
			if(readCount >0) {
				commit(con);
			} else {
				rollback(con);
			}
			board = boardDAO.selectBoard(board_no);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return board;
	}

	public ArrayList<Menu> getMenu(int board_no) {
		ArrayList<Menu> list = null;
		Connection con = null;
	try {
		con = getConnection();
		MenuDAO menuDAO = MenuDAO.getInstance();
		menuDAO.setConnection(con);
		
		list = menuDAO.selectMenu(board_no);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return list;
	}

}
