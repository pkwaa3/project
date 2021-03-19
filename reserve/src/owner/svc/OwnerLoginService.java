package owner.svc;

import vo.Owner;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.OwnerDAO;
public class OwnerLoginService {

	public Owner getOwner(String id) {
		Owner owner= null;
		Connection con = null;
		try {
			con = getConnection();
			OwnerDAO ownerDAO = OwnerDAO.getInstance();
			ownerDAO.setConnection(con);
			
			owner = ownerDAO.selectOwner(id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
				
		return owner;
	}

}
