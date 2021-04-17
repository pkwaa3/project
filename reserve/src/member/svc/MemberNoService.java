package member.svc;

import java.sql.Connection;

import dao.MemberDAO;

import static db.JdbcUtil.*;
import vo.Member;

public class MemberNoService {

	public Member getMember(String id) {
		Connection con = null;
		Member member= null;
		
		try {
			con=getConnection();
			MemberDAO memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			
			member=memberDAO.serchMemberNO(id);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		close(con);	
		}
		
		
		return member;
	}

}
