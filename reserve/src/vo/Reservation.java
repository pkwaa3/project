package vo;

import java.sql.Date;

public class Reservation {
	private int reserv_no;
	private int member_no;
	private int rest_no;
	private Date date;
	private int time;
	private int head;
	
	public int getReserv_no() {
		return reserv_no;
	}
	public void setReserv_no(int reserv_no) {
		this.reserv_no = reserv_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public int getRest_no() {
		return rest_no;
	}
	public void setRest_no(int rest_no) {
		this.rest_no = rest_no;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getHead() {
		return head;
	}
	public void setHead(int head) {
		this.head = head;
	}
	
	
	
}
