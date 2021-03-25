package dao;

import static db.JdbcUtil.*;
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
	//페이지
	public int selectListCount(String local, String kind) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from restaurant where local=? and kind=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, local);
			pstmt.setString(2, kind);
			rs = pstmt.executeQuery();
			
			if(rs.next()) listCount = rs.getInt(1);
		} catch(Exception e) {
			System.out.println("getListCount 에러  : " + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;
	}
	//서치 목록
	public ArrayList<Board> selectSearchList(int page, int limit, String local, String kind) {
		ArrayList<Board> searchList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from board b left join restaurant r on b.rest_no=r.rest_no  where r.local = ? and b.kind = ? order by BOARD_RE_REF desc, BOARD_RE_SEQ asc limit ?, ?";
		int startrow = (page - 1) * limit;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, local);
			pstmt.setString(2, kind);
			pstmt.setInt(3, startrow);
			pstmt.setInt(4, limit);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				board.setBoard_no(rs.getInt("board_no"));
				board.setOwner_no(rs.getInt("owner_no"));
				board.setRest_no(rs.getInt("rest_no"));
				board.setBoard_content(rs.getString("board_content"));
				board.setKind(rs.getString("kind"));
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_date(rs.getDate("board_date"));
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("BOARD_RE_SEQ"));
				board.setBoard_readcount(rs.getInt("board_readcount"));
				
				searchList.add(board);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return searchList;
	}
	
}
