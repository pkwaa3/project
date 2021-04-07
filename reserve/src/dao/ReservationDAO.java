package dao;

import static db.JdbcUtil.*;
import java.sql.*;
import java.util.ArrayList;

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
		
		try {
			String sql="insert into reservation(member_no,rest_no,date,time,head,restName) values(?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,reservation.getMember_no());
			pstmt.setInt(2,reservation.getRest_no());
			pstmt.setString(3,reservation.getDate());
			pstmt.setString(4,reservation.getTime());
			pstmt.setString(5,reservation.getHead());
			pstmt.setString(6, reservation.getRestName());
			
			
			insertRe=pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			close(pstmt);
		}
		
		
		
		return insertRe;
	}

	public ArrayList<Reservation> getList(int memberNo) {
		ArrayList<Reservation> list = new ArrayList<>();
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			String sql="select * from reservation where member_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rs=pstmt.executeQuery();
			
			System.out.println(rs +"뭐임?");
			
			while(rs.next()) {
				Reservation reservation = new Reservation();
				
				reservation.setReserv_no(Integer.parseInt(rs.getString("reserv_no")));
				reservation.setDate(rs.getString("date"));
				reservation.setRest_no(Integer.parseInt(rs.getString("rest_no")));
				reservation.setTime(rs.getString("time"));
				reservation.setHead(rs.getString("head"));
				reservation.setRestName(rs.getString("restName"));
				
				list.add(reservation);		
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
			
		return list;
	}
	
	
	
}
