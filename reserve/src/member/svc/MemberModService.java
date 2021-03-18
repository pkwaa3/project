package member.svc;

import java.sql.Connection;

import dao.MemberDAO;
import vo.Member;
import static db.JdbcUtil.*;
public class MemberModService {

	public boolean modifyMember(Member member) {
		boolean isModifySuccess = false;
		Connection con = null;
		
		try {
			con=getConnection();
			MemberDAO memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			
			int updateCount = memberDAO.updateMember(member);
			
			if(updateCount > 0) {
				commit(con);
				isModifySuccess =true;
			}else {
				rollback(con);
				isModifySuccess=false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return isModifySuccess;
	}

}
