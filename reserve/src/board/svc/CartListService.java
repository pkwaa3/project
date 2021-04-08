package board.svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;

import static db.JdbcUtil.*;
import vo.Cart;

public class CartListService {

	public ArrayList<Cart> getList(int memberNo) {
		ArrayList<Cart> list = null;
		Connection con = null;
		
		try {
			con=getConnection();
			BoardDAO boardDAO = BoardDAO.getInstance();
			boardDAO.setConnection(con);
			list = boardDAO.getList(memberNo);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		
		return list;
	}

}
