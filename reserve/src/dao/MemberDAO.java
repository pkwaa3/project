package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import vo.Member;

public class MemberDAO {
	public static MemberDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	private MemberDAO() {}
	
	public static MemberDAO getInstance(){
		if(instance == null){
			instance = new MemberDAO();
		}
		return instance;
	}
	public void setConnection(Connection con){
		this.con = con;
	}

	public Member selectMember(String id) {

		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where member_id=?";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setMember_id(id);
				member.setMember_pw(rs.getString("password"));
				member.setMember_name(rs.getString("name"));
				member.setMember_age(rs.getInt("age"));
				member.setMember_gender(rs.getString("gender"));
				member.setMember_number(rs.getInt("number"));
				member.setMember_email(rs.getString("email"));
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return member;
	}

	public int insertMember(Member member) {

		int insertCount = 0;
		PreparedStatement pstmt = null;
		String sql = "insert into member(member_id, member_pw, member_name, member_age, member_gender, member_number, member_email) values(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  member.getMember_id());
			pstmt.setString(2,  member.getMember_pw());
			pstmt.setString(3,  member.getMember_name());
			pstmt.setInt(4,  member.getMember_age());
			pstmt.setString(5,  member.getMember_gender());
			pstmt.setInt(6,  member.getMember_number());
			pstmt.setString(7,  member.getMember_email());
			
			
			insertCount = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
}
