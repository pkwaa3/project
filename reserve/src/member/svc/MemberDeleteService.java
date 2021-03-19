package member.svc;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class MemberDeleteService {

	public boolean deleteMember(String id, String pass) {
		boolean isDeleteSuccess = false;
		Connection con = null;
		
		try {
			con = getConnection();
			MemberDAO memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			
			int deleteCount = memberDAO.deleteMember(id,pass);
			
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
