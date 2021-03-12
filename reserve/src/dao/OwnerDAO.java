package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static db.JdbcUtil.*;
import javax.sql.DataSource;

import vo.Owner;

public class OwnerDAO {
	public static OwnerDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	private OwnerDAO() {}
	
	public static OwnerDAO getInstance(){
		if(instance == null){
			instance = new OwnerDAO();
		}
		return instance;
	}
	public void setConnection(Connection con){
		this.con = con;
	}
	
	//로그인아이디 조회
	public String selectLoginId(Owner owner) {
		String loginId = null;
		String sql="select owner_id from owner where owner_id =? and owner_pw=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, owner.getOwner_id());
			pstmt.setString(2, owner.getOwner_pw());
			rs=pstmt.executeQuery();
			
			if(rs.next()) 
			loginId=rs.getString("owner_id");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return loginId;
	}

}
