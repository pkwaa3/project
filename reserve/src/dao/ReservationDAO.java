package dao;

import static db.JdbcUtil.*;
import java.sql.*;

import javax.sql.*;

import vo.Reservation;

public class ReservationDAO {
	public static ReservationDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	private ReservationDAO() {}
	
	public static ReservationDAO getInstance() {
		if(instance == null) {
			instance= new ReservationDAO();
		}
		
		return instance;
	}
	
	public void setConnection(Connection con) {
		this.con=con;
	}
	//예약액션
	public boolean reservation(Reservation reservation) {
		boolean reserv =  false;
		Connection con = null;
		PreparedStatement pstmt= null;
		
		
		
		return reserv;
	}
	
	
	
}
