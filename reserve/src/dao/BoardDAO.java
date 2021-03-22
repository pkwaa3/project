package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.Board;
import vo.Menu;

public class BoardDAO {
	public static BoardDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	private BoardDAO() {}
	
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	public void setConnection(Connection con) {
		this.con=con;
	}
	//글등록
	public int insertArticle(Board board, ArrayList<Menu> list) {
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		int num = 0;
		String sql="";
		int insertCount =0;
		
		
		
		return insertCount;
	}
	
}
