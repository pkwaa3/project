package dao;

import static db.JdbcUtil.*;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import vo.Member;

public class MemberDAO {
	public static MemberDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	public MemberDAO() {}
	
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
				member.setMember_pw(rs.getString("member_pw"));
				member.setMember_name(rs.getString("member_name"));
				member.setMember_age(rs.getString("member_age"));
				member.setMember_gender(rs.getString("member_gender"));
				member.setMember_number(rs.getString("member_number"));
				member.setMember_email(rs.getString("member_email"));
				
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
			pstmt.setString(4,  member.getMember_age());
			pstmt.setString(5,  member.getMember_gender());
			pstmt.setString(6,  member.getMember_number());
			pstmt.setString(7,  member.getMember_email());
			
			
			insertCount = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	//정보수정
	public int updateMember(Member member) {
		int updateCount = 0;
		PreparedStatement pstmt=null;
		String sql="update member set member_pw = ? , member_name=?,member_age=?,member_gender=?,member_number=?,member_email=? where member_id =?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getMember_pw());
			pstmt.setString(2, member.getMember_name());
			pstmt.setString(3, member.getMember_age());
			pstmt.setString(4, member.getMember_gender());
			pstmt.setString(5, member.getMember_number());
			pstmt.setString(6, member.getMember_email());
			pstmt.setString(7, member.getMember_id());
			updateCount = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			
		}

		return updateCount;
	}
	
	//멤버 회원 탈퇴
	public int deleteMember(String id, String pass) {
		int deleteCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where member_id=? and member_pw=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
			 String sqlD="delete from member where member_id=?";
			 pstmt=con.prepareStatement(sqlD);
			 pstmt.setString(1, id);
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
	//멤버 번호 찾기
	public int serchMemberNO(String id) {
		int memberNo=0;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		String sql="select member_no from member where member_id=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) 
				memberNo = rs.getInt("member_no");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return memberNo;
	}

}
