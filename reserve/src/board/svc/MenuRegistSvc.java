package board.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MenuDAO;
import vo.Menu;

public class MenuRegistSvc {

	public boolean registMenu(ArrayList<Menu> menuList) {
		boolean isMenuSuccess =false;
		Connection con = null;
		try {
			con = getConnection();
			MenuDAO menuDao = MenuDAO.getInstance();
			menuDao.setConnection(con);
			int insertMenuCount = menuDao.insertMenu(menuList);
			
			if(insertMenuCount>0) {
				commit(con);
				isMenuSuccess=true;
			}else {
				System.out.println("메뉴 등록 실패");
				rollback(con);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return isMenuSuccess;
	}

}
