package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import static db.JdbcUtil.*;
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
	public int insertArticle(Board board) {
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		int num = 0;
		int insertCount =0;
		
		
		try {
			pstmt = con.prepareStatement("select max(board_no) from board");
			rs= pstmt.executeQuery();
			if(rs.next()) {
				num=rs.getInt(1)+1;
			}else { 
				num =1;
			}
			String sql="insert into board(owner_no,rest_no,kind,board_subject,board_content,"
					+ "board_readcount,board_re_ref,board_re_lev,board_re_seq,board_date) values(?,?,?,?,?,?,?,?,?,now())";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, board.getOwner_no());
			pstmt.setInt(2, board.getRest_no());
			pstmt.setString(3, board.getKind());
			pstmt.setString(4, board.getBoard_subject());
			pstmt.setString(5, board.getBoard_content());
			pstmt.setInt(6,0);
			pstmt.setInt(7,num);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			
			insertCount=pstmt.executeUpdate();
			
				
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		return insertCount;
	}
	
}
