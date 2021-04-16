package board.svc;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
public class CartOverlapSvc {

	public int cart(int memberNo, String restName) {
		int cartOver=0;
		Connection con = null;
		
		try {
			con=getConnection();
			BoardDAO boardDAO= BoardDAO.getInstance();
			boardDAO.setConnection(con);
			
			cartOver=boardDAO.cart(memberNo,restName);
			
			
			
		}catch(Exception e) {
			
		}finally {
			close(con);
		}
		
		return cartOver;
	}

}
