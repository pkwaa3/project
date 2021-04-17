package board.svc;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
public class CartDelSvc {

	public int delete(String cartNo) {
		int cartDel=0;
		Connection con = null;
		try {
			con=getConnection();
			BoardDAO boardDAO=BoardDAO.getInstance();
			boardDAO.setConnection(con);
			cartDel= boardDAO.deleteCart(cartNo);
			if(cartDel>0) {
				commit(con);
				cartDel=1;
			}else {
				rollback(con);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return cartDel;
	}

}
