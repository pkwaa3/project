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

	private OwnerDAO() {
	}

	public static OwnerDAO getInstance() {
		if (instance == null) {
			instance = new OwnerDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	// 로그인아이디 조회
	public Owner selectOwner(String id) {
		Owner owner = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from owner where owner_id = ?";
		
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				owner = new Owner();
				owner.setOwner_id(id);
				owner.setOwner_pw(rs.getString("owner_pw"));
				owner.setOwner_name(rs.getString("owner_name"));
				owner.setOwner_age(rs.getString("owner_age"));
				owner.setOwner_gender(rs.getString("owner_gender"));
				owner.setOwner_number(rs.getString("owner_number"));
				owner.setOwner_email(rs.getString("owner_email"));
				owner.setOwner_no(rs.getInt("owner_no"));
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return owner;
	}

	// 오너 회원가입
	public int insertOwner(Owner owner) {
		
		int insert = 0;

		String sql="insert into owner(owner_id,owner_pw,owner_name,owner_age,owner_gender,owner_number,owner_email) values(?,?,?,?,?,?,?)";

		PreparedStatement pstmt = null;
		

		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, owner.getOwner_id());
			pstmt.setString(2, owner.getOwner_pw());
			pstmt.setString(3, owner.getOwner_name());
			pstmt.setString(4, owner.getOwner_age());
			pstmt.setString(5, owner.getOwner_gender());
			pstmt.setString(6, owner.getOwner_number());
			pstmt.setString(7, owner.getOwner_email());
			
			insert=pstmt.executeUpdate();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();

		}finally {
		close(pstmt);
		

		} 
		
		return insert;
	}
	//오너 회원 정보수정에서 회원 맞는지 검사
	public Owner selectModOwner(String id) {
		
		Owner owner = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from owner where owner_id=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				owner = new Owner();
				owner.setOwner_id(id);
				owner.setOwner_pw(rs.getString("owner_pw"));
				owner.setOwner_name(rs.getString("owner_name"));
				owner.setOwner_age(rs.getString("owner_age"));
				owner.setOwner_gender(rs.getString("owner_gender"));
				owner.setOwner_number(rs.getString("owner_number"));
				owner.setOwner_email(rs.getString("owner_email"));
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return owner;
	}
	//오너 회원 정보 수정
	public int updateOwner(Owner owner) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		
		String sql = "update owner set owner_pw=?, owner_name=?, owner_age=?, owner_gender=?, owner_number=?, owner_email=? where owner_id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, owner.getOwner_pw());
			pstmt.setString(2, owner.getOwner_name());
			pstmt.setString(3, owner.getOwner_age());
			pstmt.setString(4, owner.getOwner_gender());
			pstmt.setString(5, owner.getOwner_number());
			pstmt.setString(6, owner.getOwner_email());
			pstmt.setString(7, owner.getOwner_id());
		
			updateCount = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return updateCount;
	}
	
	//오너 회원탈퇴
	public int deleteOwner(String owner_id, String owner_pw) {
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from owner where owner_id=? and owner_pw=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, owner_id);
			pstmt.setString(2, owner_pw);
			System.out.println(owner_id);
			System.out.println(owner_pw);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
			 String sqlD="delete from owner where owner_id=?";
			 pstmt=con.prepareStatement(sqlD);
			 pstmt.setString(1, owner_id);
			 deleteCount=pstmt.executeUpdate();
				
			}else {
				System.out.println("<script>");
				System.out.println("alert('비밀번호불일치');");
				System.out.println("history.back();");
				System.out.println("</script>");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(pstmt);
			
		}
		return deleteCount;
	}

	

	

}
