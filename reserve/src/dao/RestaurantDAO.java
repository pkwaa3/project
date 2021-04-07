package dao;


import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.Reservation;
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

	public ArrayList<Restaurant> RestInfo(int owner_no) {
		ArrayList<Restaurant> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql= "select name,rest_no,address from restaurant where owner_no =?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, owner_no);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Restaurant restaurant = new Restaurant();
				restaurant.setName(rs.getString("name"));
				restaurant.setRest_no(rs.getInt("rest_no"));
				restaurant.setAddress(rs.getString("address"));
				
				
				list.add(restaurant);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
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
	//rest_no 찾기
	public int searchRestNo(String board_subject) {
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		int rest_no =0;
		try {
			sql= "select rest_no from restaurant where name =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, board_subject);
			rs=pstmt.executeQuery();
			
			if(rs.next()) rest_no = rs.getInt("rest_no"); 
				
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return rest_no;
	}

	public int selectRestNo(int board_no) {
		int restNo = 0;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql="";
		
		try {
			sql="select rest_no from board where board_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,board_no);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				restNo=rs.getInt("rest_No");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return restNo;
	}

	//레스토랑 수정 인포 폼
	public Restaurant selectModRestaurant(String restNo) {
		Restaurant restaurant = null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql="";
		
		try {
			sql="select * from restaurant where rest_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,restNo);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				restaurant = new Restaurant();
				restaurant.setRest_no(rs.getInt("rest_no"));
				restaurant.setOwner_no(rs.getInt("owner_no"));
				restaurant.setName(rs.getString("name"));
				restaurant.setKind(rs.getString("kind"));
				restaurant.setAddress(rs.getString("address"));
				restaurant.setLocal(rs.getString("local"));
				restaurant.setMax_head(rs.getString("max_head"));
				restaurant.setOpen(rs.getString("open"));
				restaurant.setClose(rs.getString("close"));
				restaurant.setTell(rs.getString("tell"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return restaurant;
	}
	//레스토랑 수정 업데이트
	public int updateRestaurant(Restaurant restaurant) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		
		String sql = "update restaurant set name=?, kind=?, address=?, local=?, max_head=?, open=?, close=?, tell=? where rest_no=?";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2, restaurant.getKind());
			pstmt.setString(3, restaurant.getAddress());
			pstmt.setString(4, restaurant.getLocal());
			pstmt.setString(5, restaurant.getMax_head());
			pstmt.setString(6, restaurant.getOpen());
			pstmt.setString(7, restaurant.getClose());
			pstmt.setString(8, restaurant.getTell());
			pstmt.setInt(9, restaurant.getRest_no());
		
			updateCount = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return updateCount;
	}
	//가게이름찾기

//	public String[] findName(ArrayList<Reservation> list) {
//		String[] name = null;
//		
//		PreparedStatement pstmt= null;
//		ResultSet rs= null;
//		String sql="";
//		try {
//			sql="select name from restaurant where rest_no =?";
//			for(int i=0; i<list.size();i++) {
//			pstmt=con.prepareStatement(sql);
//			pstmt.setInt(1, list.get(i).getRest_no());
//			
//			rs=pstmt.executeQuery();
//			System.out.println(list.get(i).getRest_no());
//			
//			if(rs.next()) {
//				System.out.println(rs.getString("name"));
//				name[i]=rs.getString("name");
//			}
//			System.out.println(name[i]);
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			close(rs);
//			close(pstmt);
//		}
//		
//		return name;
//	}

	public String[] findName(ArrayList<Reservation> list) {
		String[] name = null;
		
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		String sql="";
		try {
			sql="select name from restaurant where rest_no =?";
			for(int i=0; i<list.size();i++) {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, list.get(i).getRest_no());
			
			rs=pstmt.executeQuery();
			System.out.println(list.get(i).getRest_no());
			
			if(rs.next()) {
				System.out.println(rs.getString("name"));
				name[i]=rs.getString("name");
			}
			System.out.println(name[i]);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return name;

	}

	
}
