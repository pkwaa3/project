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
	
	public int reservation(Reservation reservation) {
		int insertRe =  0;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			String sql="insert into reservation(member_no,rest_no,date,time,head) values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,reservation.getMember_no());
			pstmt.setInt(2,reservation.getRest_no());
			pstmt.setString(3,reservation.getDate());
			pstmt.setString(4,reservation.getTime());
			pstmt.setString(5,reservation.getHead());
			
			
			insertRe=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		return insertRe;
	}
	
	
	
}
