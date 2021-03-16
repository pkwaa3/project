package vo;

import java.sql.Date;

public class Reserv_info {
	private int reserv_info_no;
	private int rest_no;
	private Date date;
	private String time;
	private String rest_head;
	
	public int getReserv_info_no() {
		return reserv_info_no;
	}
	public void setReserv_info_no(int reserv_info_no) {
		this.reserv_info_no = reserv_info_no;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRest_head() {
		return rest_head;
	}
	public void setRest_head(String rest_head) {
		this.rest_head = rest_head;
	}
	
	
}
