package owner.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.OwnerDAO;
import vo.Owner;

public class OwnerModInfoProSvc {

	public boolean modifyOwnerInfo(Owner owner) {
		boolean isModifySuccess = false;
		Connection con = null;
		
		try {
			con = getConnection();
			OwnerDAO ownerDao = OwnerDAO.getInstance();
			ownerDao.setConnection(con);
			
			int updateCount = ownerDao.updateOwner(owner);
			
			if(updateCount > 0) {
				commit(con);
				isModifySuccess = true;
			} else {
				rollback(con);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		
		
		return isModifySuccess;
	}

}
