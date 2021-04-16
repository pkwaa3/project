package review.svc;
import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import dao.ReviewDAO;
import vo.Board;
import vo.Review;

public class ReviewListService {
	public int getListCount(int board_no) {
		int listCount = 0;
		Connection con = null;
		try {
			con = getConnection();
			ReviewDAO reviewDAO = ReviewDAO.getInstance();
			reviewDAO.setConnection(con);
			listCount = reviewDAO.selectListCount(board_no);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return listCount;
	}

	

	public ArrayList<Review> getArticleList(int reviewPage, int limit, int board_no) {
		ArrayList<Review> searchList = null;
		Connection con = null;
		try {
			con = getConnection();
			ReviewDAO reviewDAO = ReviewDAO.getInstance();
			reviewDAO.setConnection(con);
			searchList = reviewDAO.selectReviewList(reviewPage, limit, board_no);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		
		return searchList;
	}
}
