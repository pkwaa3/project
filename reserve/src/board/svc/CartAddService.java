package board.svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.Cart;
import static db.JdbcUtil.*;
public class CartAddService {

	public int addCart(Cart cart) {
		int addCart = 0;
		Connection con = null;
		
		try {
			con=getConnection();
			BoardDAO boardDAO = BoardDAO.getInstance();
			boardDAO.setConnection(con);
			
			addCart=boardDAO.addCart(cart);
			
			if(addCart >0) {
				commit(con);
			}
			else {
				rollback(con);
				addCart=0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return addCart;
	}

}
