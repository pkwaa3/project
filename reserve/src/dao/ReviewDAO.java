package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static db.JdbcUtil.*;
import javax.sql.DataSource;

import vo.Board;
import vo.Review;

public class ReviewDAO {
	public static ReviewDAO instance;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	private ReviewDAO() {}
	
	public static ReviewDAO getInstance() {
		if(instance == null) {
			instance = new ReviewDAO();
		}
		return instance;
	}
	public void setConnection(Connection con) {
		this.con=con;
	}
	
	//리뷰 글 등록
	public int insertArticle(Review review) {
		PreparedStatement pstmt = null;
		
		
		String sql = "";
		int insertCount = 0;
		
		try { 
			
			if(review.getMember_id() == null) {
				
			sql="insert into review(board_no, owner_id, review_content, review_date, review_re_ref, review_re_lev, review_re_seq) values(?,?,?,now(),?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review.getBoard_no());
			pstmt.setString(2, review.getOwner_id());
			pstmt.setString(3, review.getReview_content());
			pstmt.setInt(4, 0);
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			
			} else {
				
				sql="insert into review(board_no, member_id, review_content, review_date, review_re_ref, review_re_lev, review_re_seq) values(?,?,?,now(),?,?,?)";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, review.getBoard_no());
				pstmt.setString(2, review.getMember_id());
				pstmt.setString(3, review.getReview_content());
				pstmt.setInt(4, 0);
				pstmt.setInt(5, 0);
				pstmt.setInt(6, 0);	
				
			}
			
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("boardInsert 에러 : " + e);
			e.printStackTrace();
		} finally {

			close(pstmt);
		}
		return insertCount;
	}

	public int selectListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement("select count(*) from review");
			rs= pstmt.executeQuery();
			
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

	public ArrayList<Review> selectSearchList(int page, int limit, String board_no) {
		ArrayList<Review> articleList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from review where board_no = ? order by review_re_ref desc, review_re_seq asc limit ?, ?";
		int startrow = (page - 1) * limit;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board_no);
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, limit);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Review review = new Review();
				
				review.setBoard_no(rs.getInt("board_no"));
				review.setMember_id(rs.getString("member_id"));
				review.setOwner_id(rs.getString("owner_id"));
				review.setReview_content(rs.getString("review_content"));
				review.setReview_date(rs.getDate("review_date"));
				review.setReview_re_ref(rs.getInt("review_re_ref"));
				review.setReview_re_lev(rs.getInt("review_re_lev"));
				review.setReview_re_seq(rs.getInt("review_re_seq"));
				
				
				
				articleList.add(review);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return articleList;
	}

	public ArrayList<Review> selectReviewList(int reviewPage, int limit, int board_no) {
		ArrayList<Review> articleList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from review where board_no = ? order by review_re_ref desc, review_re_seq asc limit ?, ?";
		int startrow = (reviewPage - 1) * limit;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, limit);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Review review = new Review();
				
				review.setBoard_no(rs.getInt("board_no"));
				review.setMember_id(rs.getString("member_id"));
				review.setOwner_id(rs.getString("owner_id"));
				review.setReview_content(rs.getString("review_content"));
				review.setReview_date(rs.getDate("review_date"));
				review.setReview_re_ref(rs.getInt("review_re_ref"));
				review.setReview_re_lev(rs.getInt("review_re_lev"));
				review.setReview_re_seq(rs.getInt("review_re_seq"));
				
				
				
				articleList.add(review);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return articleList;
	}
	
	
}
