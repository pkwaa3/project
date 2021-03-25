package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.Menu;

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

			for (int i = 0; i < list.size(); i++) {
				String sql1 = "insert into menu(rest_no,board_no,menu_name,menu_price,menu_img) valeus(?,?,?,?,?)";
				pstmt = con.prepareStatement(sql1);
				pstmt.setInt(1, list.get(i).getRest_no());
				pstmt.setInt(2, num);
				pstmt.setString(3, list.get(i).getMenu_name());
				pstmt.setInt(4, list.get(i).getMenu_price());
				pstmt.setString(5, list.get(i).getMenu_img());

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

}
