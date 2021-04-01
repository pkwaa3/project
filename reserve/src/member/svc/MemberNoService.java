package member.svc;

import java.sql.Connection;

import dao.MemberDAO;

import static db.JdbcUtil.*;
import vo.Member;

public class MemberNoService {

	public int getMember(String id) {
		Connection con = null;
		int memberNo = 0;
		
		try {
			con=getConnection();
			MemberDAO memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			
			memberNo=memberDAO.serchMemberNO(id);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		close(con);	
		}
		
		
		return memberNo;
	}

}
