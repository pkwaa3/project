package review.svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.ReviewDAO;
import vo.Review;

public class ReviewWriteProService {

	public boolean registArticle(Review review) {
		
		boolean isWriteSuccess = false;
		Connection con = null;
		
		try {
		con = getConnection();
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		reviewDAO.setConnection(con);
		int insertCount = reviewDAO.insertArticle(review);
		
		if(insertCount > 0) {
			commit(con);
			isWriteSuccess = true;
		} else {
			rollback(con);
		}
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return isWriteSuccess;
	}

}
