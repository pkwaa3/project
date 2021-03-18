package member.svc;

import java.sql.Connection;

import dao.MemberDAO;

import static db.JdbcUtil.*;
import vo.Member;

public class MemberInfoService {

	public Member getMember(String id) {
		Member member = null;
		Connection con = null;
		
		try {
			con = getConnection();
			MemberDAO memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			
			member = memberDAO.selectMember(id);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(con);
		}
		return member;
	}

}
