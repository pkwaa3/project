package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

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

}
