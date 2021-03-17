package dao;

import static db.JdbcUtil.close;

import java.sql.*;

import javax.sql.DataSource;

import db.JdbcUtil.*;
import vo.Company;

public class CompanyDAO {
	public static CompanyDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	private CompanyDAO() {}
	
	public static CompanyDAO getInstance(){
		if(instance == null){
			instance = new CompanyDAO();
		}
		return instance;
	}
	public void setConnection(Connection con){
		this.con = con;
	}
	//로그인아이디 조회
	public String selectLoginId(Company company) {
		String loginId = null;
		String sql="select com_id from company where com_id =? and com_pw=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, company.getCom_id());
			pstmt.setString(2, company.getCom_pw());
			rs=pstmt.executeQuery();
			
			if(rs.next()) 
			loginId=rs.getString("com_id");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return loginId;
	}
	//컴퍼니 회원가입
	public int insertCompany(Company company) {
		int insert = 0;

		String sql="insert into company values(?,?,?)";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, company.getCom_id());
			pstmt.setString(2, company.getCom_pw());
			pstmt.setString(3, company.getCom_admin());
			
			insert=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return insert;
	}
}
