package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.Board;
import vo.Menu;
import vo.Restaurant;

public class MenuDAO {

	public static MenuDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;

	private MenuDAO() {
	}

	public static MenuDAO getInstance() {
		if (instance == null) {
			instance = new MenuDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	

	public int insertArticle(ArrayList<Menu> list, int rest_no) {
//		public int insertArticle(ArrayList<Menu> list) {

		PreparedStatement pstmt = null;
		String sql = "";
		ResultSet rs = null;
		int insertMeCount = 0;
		int num=0;

		try {
			sql = "select board_no from board where rest_no =? ";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, rest_no);

			//pstmt.setInt(1, list.get(0).getRest_no());
			
			rs = pstmt.executeQuery();
			if(rs.next())
			num = rs.getInt("board_no");
			System.out.println("board_no"+num);
			
			for (int i = 1; i < list.size(); i++) {
				String sql1 = "insert into menu(rest_no,board_no,menu_name,menu_price,menu_org_img,menu_sys_img) values(?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql1);
				pstmt.setInt(1, rest_no);
				pstmt.setInt(2, num);
				pstmt.setString(3, list.get(i).getMenu_name());
				pstmt.setInt(4, list.get(i).getMenu_price());
				pstmt.setString(5, list.get(i).getMenu_org_img());
				pstmt.setString(6, list.get(i).getMenu_sys_img());
				
				insertMeCount = pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return insertMeCount;
	}


	//글조회
	public ArrayList<Menu> selectMenu(int board_no) {
		ArrayList<Menu> list = new ArrayList<Menu>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from menu where board_no=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Menu menu = new Menu();
				menu.setBoard_no(rs.getInt("board_no"));
				menu.setMenu_no(rs.getInt("menu_no"));
				menu.setRest_no(rs.getInt("rest_no"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_price(rs.getInt("menu_price"));
				menu.setMenu_org_img(rs.getString("menu_org_img"));
				menu.setMenu_sys_img(rs.getString("menu_sys_img"));
				
				list.add(menu);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return list;
	}
//메뉴 수정폼
	public ArrayList<Menu> selectModMenu(String restNo) {
		ArrayList<Menu> menuList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from menu where rest_no= ?";
		
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, restNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Menu menu = new Menu();
				menu.setMenu_no(rs.getInt("menu_no"));
				menu.setRest_no(rs.getInt("rest_no"));
				menu.setBoard_no(rs.getInt("board_no"));
				menu.setMenu_name(rs.getString("menu_name"));
				menu.setMenu_price(rs.getInt("menu_price"));
				menu.setMenu_org_img(rs.getString("menu_org_img"));
				menu.setMenu_sys_img(rs.getString("menu_sys_img"));
				
				menuList.add(menu);
			}
		} catch(Exception e) {
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return menuList;
	}
	//메뉴 수정
	public int updateArticle(ArrayList<Menu> list) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		
		try {

			for(int i = 0; i < list.size(); i++) {
				String sql = "update menu set menu_name=?, menu_price=?, menu_org_img=?, menu_sys_img=? where menu_no=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, list.get(i).getMenu_name());
				pstmt.setInt(2, list.get(i).getMenu_price());
				pstmt.setString(3, list.get(i).getMenu_org_img());
				pstmt.setString(4, list.get(i).getMenu_sys_img());
				pstmt.setInt(5, list.get(i).getMenu_no());
				updateCount = pstmt.executeUpdate();	
			}
			System.out.println(updateCount );
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			
		}
		return updateCount;
	}
	


}
