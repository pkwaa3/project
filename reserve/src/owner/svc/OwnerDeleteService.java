package owner.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.OwnerDAO;

public class OwnerDeleteService {

	public boolean deleteOwner(String owner_id, String owner_pw) {
		boolean isDeleteSuccess = false;
		Connection con = null;
		
		try {
			con = getConnection();
			OwnerDAO ownerDao = OwnerDAO.getInstance();
			ownerDao.setConnection(con);
			
			int deleteCount = ownerDao.deleteOwner(owner_id, owner_pw);
			
			if(deleteCount>0) {
				commit(con);
				isDeleteSuccess = true;
			}else {
				rollback(con);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(con);
		}
		return isDeleteSuccess;
	}

}
