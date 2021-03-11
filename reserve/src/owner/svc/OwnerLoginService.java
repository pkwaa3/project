package owner.svc;

import vo.Owner;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.OwnerDAO;
public class OwnerLoginService {

	public static boolean login(Owner owner) {
		Connection con = getConnection();
		OwnerDAO ownerDAO = OwnerDAO.getInstance();
		ownerDAO.setConnection(con);
		
		boolean loginResult = false;
		
		String loginId=ownerDAO.selectLoginId(owner);
		if(loginId != null) {
			loginResult = true;
		}
		
		close(con);
		
		return loginResult;
	}

}
