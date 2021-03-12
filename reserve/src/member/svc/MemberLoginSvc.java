package member.svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.MemberDAO;
import vo.Member;

public class MemberLoginSvc {

	public Member getMember(String id) {
		
		Member member = null;
		Connection con = null;
		try {
			
			con = getConnection();
			MemberDAO memberDao = MemberDAO.getInstance();
			memberDao.setConnection(con);
			
			member = memberDao.selectMember(id);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		
		return member;
	}

}
