package vo;

import java.sql.Date;

public class Board {
	private int board_no;
	private int owner_no;
	private int rest_no;
	private String board_content;
	private String main_org_img;
	private String main_sys_img;
	private String addr;
	private String board_subject;
	private Date board_date;
	private int board_readcount;
	private int board_re_ref;
	private int board_re_lev;
	private int board_re_seq;

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getOwner_no() {
		return owner_no;
	}

	public void setOwner_no(int owner_no) {
		this.owner_no = owner_no;
	}

	public int getRest_no() {
		return rest_no;
	}

	public void setRest_no(int rest_no) {
		this.rest_no = rest_no;
	}

	public String getBoard_subject() {
		return board_subject;
	}

	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	
	public Date getBoard_date() {
		return board_date;
	}

	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	public int getBoard_readcount() {
		return board_readcount;
	}

	public void setBoard_readcount(int board_readcount) {
		this.board_readcount = board_readcount;
	}

	public int getBoard_re_ref() {
		return board_re_ref;
	}

	public void setBoard_re_ref(int board_re_ref) {
		this.board_re_ref = board_re_ref;
	}

	public int getBoard_re_lev() {
		return board_re_lev;
	}

	public void setBoard_re_lev(int board_re_lev) {
		this.board_re_lev = board_re_lev;
	}

	public int getBoard_re_seq() {
		return board_re_seq;
	}

	public void setBoard_re_seq(int board_re_seq) {
		this.board_re_seq = board_re_seq;
	}

	

	

	public String getMain_org_img() {
		return main_org_img;
	}

	public void setMain_org_img(String main_org_img) {
		this.main_org_img = main_org_img;
	}

	public String getMain_sys_img() {
		return main_sys_img;
	}

	public void setMain_sys_img(String main_sys_img) {
		this.main_sys_img = main_sys_img;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	
}
