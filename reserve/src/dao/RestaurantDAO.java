package dao;


import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;
import vo.Restaurant;


public class RestaurantDAO {

	public static RestaurantDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;

	private RestaurantDAO() {
	}

	public static RestaurantDAO getInstance() {
		if (instance == null) {
			instance = new RestaurantDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}
	
	// 가게 정보 등록
	public int insertRestaurant(Restaurant restaurant) {

		int insert = 0;

		String sql="insert into restaurant(owner_no, kind, address, local, max_head, open, close, name, tell) values(?,?,?,?,?,?,?,?,?)";

		PreparedStatement pstmt = null;
		

		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, restaurant.getOwner_no());
			pstmt.setString(2, restaurant.getKind());
			pstmt.setString(3, restaurant.getAddress());
			pstmt.setString(4, restaurant.getLocal());
			pstmt.setString(5, restaurant.getMax_head());
			pstmt.setString(6, restaurant.getOpen());
			pstmt.setString(7, restaurant.getClose());
			pstmt.setString(8, restaurant.getName());
			pstmt.setString(9, restaurant.getTell());
			
			insert=pstmt.executeUpdate();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();

		}finally {
		close(pstmt);
		

		} 
		return insert;
	}

	public Restaurant RestInfo(int owner_no) {
		Restaurant rest = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql= "select * from restaurant where owner_no =?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, owner_no);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				rest=new Restaurant();
				rest.setRest_no(rs.getInt("rest_no"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return null;
	}

	public ArrayList<Restaurant> selectRestaurant(int owner_no) {
		ArrayList<Restaurant> restList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from restaurant where owner_no= ?";
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, owner_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Restaurant restaurant = new Restaurant();
				restaurant.setRest_no(rs.getInt("rest_no"));
				restaurant.setName(rs.getString("name"));
				restaurant.setKind(rs.getString("kind"));
				restaurant.setAddress(rs.getString("address"));
				restaurant.setLocal(rs.getString("local"));
				restaurant.setMax_head(rs.getString("max_head"));
				restaurant.setOpen(rs.getString("open"));
				restaurant.setClose(rs.getString("close"));
				restaurant.setTell(rs.getString("tell"));
				
				restList.add(restaurant);
			}
		} catch(Exception e) {
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return restList;
	}
}
