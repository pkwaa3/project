package review.svc;
import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import dao.ReviewDAO;
import vo.Board;
import vo.Review;

public class ReviewListService {
	public int getListCount() {
		int listCount = 0;
		Connection con = null;
		try {
			con = getConnection();
			ReviewDAO reviewDAO = ReviewDAO.getInstance();
			reviewDAO.setConnection(con);
			listCount = reviewDAO.selectListCount();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return listCount;
	}

	public ArrayList<Review> getArticleList(int page, int limit, String board_no) {
		ArrayList<Review> searchList = null;
		Connection con = null;
		try {
			con = getConnection();
			ReviewDAO reviewDAO = ReviewDAO.getInstance();
			reviewDAO.setConnection(con);
			searchList = reviewDAO.selectSearchList(page, limit, board_no);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		
		return searchList;
	}
}
