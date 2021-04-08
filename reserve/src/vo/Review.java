package vo;

import java.sql.Date;

public class Review {
	
	
	int board_no;
	String member_id;
	String owner_id;
	String review_content;
	Date review_date;
	int review_re_ref;
	int review_re_lev;
	int review_re_seq;
	int review_no;
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public Date getReview_date() {
		return review_date;
	}
	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}
	public int getReview_re_ref() {
		return review_re_ref;
	}
	public void setReview_re_ref(int review_re_ref) {
		this.review_re_ref = review_re_ref;
	}
	public int getReview_re_lev() {
		return review_re_lev;
	}
	public void setReview_re_lev(int review_re_lev) {
		this.review_re_lev = review_re_lev;
	}
	public int getReview_re_seq() {
		return review_re_seq;
	}
	public void setReview_re_seq(int review_re_seq) {
		this.review_re_seq = review_re_seq;
	}
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}


	
	
	
}
