package board.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.Board;


import vo.Restaurant;

public class MarketSearchService {

	public int getListCount() {
		int listCount = 0;
		Connection con = null;
		try {
			con = getConnection();
			BoardDAO boardDAO = BoardDAO.getInstance();
			boardDAO.setConnection(con);
			listCount = boardDAO.selectListCount();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return listCount;
	}

	public ArrayList<Board> getSeletSearch(int page, int limit, String local, String kind) {
		ArrayList<Board> searchList = null;
		Connection con = null;
		try {
			con = getConnection();
			BoardDAO boardDAO = BoardDAO.getInstance();
			boardDAO.setConnection(con);
			searchList = boardDAO.selectSearchList(page, limit, local, kind);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		
		return searchList;
	}

}
