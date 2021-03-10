package dao;

import java.sql.*;

import javax.sql.DataSource;

import db.JdbcUtil.*;

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
}
