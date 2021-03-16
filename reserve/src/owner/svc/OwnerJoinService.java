package owner.svc;

import dao.OwnerDAO;
import vo.Owner;
import static db.JdbcUtil.*;

import java.sql.Connection;
public class OwnerJoinService {

	public boolean joinMember(Owner owner) {
		boolean joinSuccess = false;
		OwnerDAO ownerDAO = OwnerDAO.getInstance();
		Connection con = getConnection();
		ownerDAO.setConnection(con);
		
		int insert = ownerDAO.insertOwner(owner);
		if(insert > 0 ) {
			joinSuccess =true;
			commit(con);
			
		} else {
			rollback(con);
			
		}
		
		close(con);
		
		
		return joinSuccess;
	}

}
