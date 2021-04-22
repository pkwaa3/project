package owner.svc;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.OwnerDAO;
public class OwnerNoService {

	public int getNo(String owner_id) {
		int ownerNo=0;
		Connection con=null;
		
		try {
			con=getConnection();
			OwnerDAO ownerDAO =OwnerDAO.getInstance();
			ownerDAO.setConnection(con);
			
			ownerNo=ownerDAO.getNo(owner_id);
					
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return ownerNo;
	}

}
