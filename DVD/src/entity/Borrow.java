package entity;

import java.util.Date;

public class Borrow {
	private int c_b_num;		// 회원번호
	private int d_b_num;		// dvd번호
	private int borrow_fee;		// 대여료
	private Date borrow_date;	// 대여일자
	private Date return_date;	// 반납예정일자
	
	
	
	public Borrow(Date borrow_date) {
		this(-1,-1,-1,borrow_date,null);
	}

	public Borrow(int c_b_num, int d_b_num, int borrow_fee, Date borrow_date, Date return_date) {
		this.c_b_num = c_b_num;
		this.d_b_num = d_b_num;
		this.borrow_fee = borrow_fee;
		this.borrow_date = borrow_date;
		this.return_date = return_date;
	}
	
	public int getC_b_num() {
		return c_b_num;
	}
	public void setC_b_num(int c_b_num) {
		this.c_b_num = c_b_num;
	}
	public int getD_b_num() {
		return d_b_num;
	}
	public void setD_b_num(int d_b_num) {
		this.d_b_num = d_b_num;
	}
	public int getBorrow_fee() {
		return borrow_fee;
	}
	public void setBorrow_fee(int borrow_fee) {
		this.borrow_fee = borrow_fee;
	}
	public Date getBorrow_date() {
		return borrow_date;
	}
	public void setBorrow_date(Date borrow_date) {
		this.borrow_date = borrow_date;
	}
	public Date getReturn_date() {
		return return_date;
	}
	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}
	
	
}
