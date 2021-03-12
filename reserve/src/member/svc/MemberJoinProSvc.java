package member.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.MemberDAO;
import vo.Member;

public class MemberJoinProSvc {

	public boolean joinMember(Member member) {
		
		boolean isJoinSuccess = false;
		Connection con = null;
		try {
			
			con = getConnection();
			MemberDAO memberDao = MemberDAO.getInstance();
			memberDao.setConnection(con);
			
			int insertCount = memberDao.insertMember(member);
			
			if(insertCount > 0) {
				commit(con);
				isJoinSuccess = true;
			} else {
				rollback(con);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		
		return isJoinSuccess;
	}

}
