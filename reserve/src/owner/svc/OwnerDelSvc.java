package owner.svc;
import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.OwnerDAO;

public class OwnerDelSvc {

	public boolean Del(int ownerNo) {
		boolean isDel = false;
		Connection con=null;
		
		try {
			con=getConnection();
			OwnerDAO ownerDAO=OwnerDAO.getInstance();
			ownerDAO.setConnection(con);
			
			int delete=ownerDAO.Del(ownerNo);
			
			if(delete>0) {
				commit(con);
				isDel=true;
			}else {
				rollback(con);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return isDel;
	}

}
