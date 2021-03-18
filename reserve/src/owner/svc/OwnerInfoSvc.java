package owner.svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.OwnerDAO;
import vo.Owner;

public class OwnerInfoSvc {

	public Owner getOwner(String id) {
		Owner owner = null;
		Connection con = null;
		
		try {
			
			con = getConnection();
			OwnerDAO ownerDao = OwnerDAO.getInstance();
			ownerDao.setConnection(con);
			
			owner = ownerDao.selectModOwner(id);
		
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(con);
		}
		
		
		return owner;
	}

}
