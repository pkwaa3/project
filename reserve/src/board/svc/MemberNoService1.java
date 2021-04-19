package board.svc;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class MemberNoService1 {

	public int getMemberno(String id) {
		int memberNo = 0;
		Connection con = null;
		
		try {
			con=getConnection();
			MemberDAO memberDAO= MemberDAO.getInstance();
			memberDAO.setConnection(con);
			memberNo=memberDAO.getMemberNo(id);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return memberNo;
	}

}
