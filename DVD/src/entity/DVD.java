package entity;

import java.util.Date;

public class DVD {
	private int d_num;			// DVD 번호
	private String director;	// 감독
	private Date release_date;	// 개봉일
	private String title;		// 제목
	private String category;	// 장르
	private int d_borrow_fee;	// 대여료
	private int rating;		// 관람등급
	
	
	
	public DVD(int d_num, Date release_date, String title) {
		this(d_num, null, release_date, title, null, -1, -1);
	}

	public DVD(int d_num, String director, Date release_date, String title, String category, int d_borrow_fee,
			int rating) {
		this.d_num = d_num;
		this.director = director;
		this.release_date = release_date;
		this.title = title;
		this.category = category;
		this.d_borrow_fee = d_borrow_fee;
		this.rating = rating;
	}
	
	public int getD_num() {
		return d_num;
	}
	public void setD_num(int d_num) {
		this.d_num = d_num;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getD_borrow_fee() {
		return d_borrow_fee;
	}
	public void setD_borrow_fee(int d_borrow_fee) {
		this.d_borrow_fee = d_borrow_fee;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
}
