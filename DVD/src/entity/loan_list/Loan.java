package entity.loan_list;


import entity.Borrow;
import entity.Customer;
import entity.DVD;

// 대여목록을 담기 위한 클래스
public class Loan {
	private DVD dvd;
	private Customer customer;
	private Borrow borrow;
	
	public Loan(DVD dvd, Customer customer, Borrow borrow) {
		this.dvd = dvd;
		this.customer = customer;
		this.borrow = borrow;
	}

	public DVD getDvd() {
		return dvd;
	}

	public void setDvd(DVD dvd) {
		this.dvd = dvd;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Borrow getBorrow() {
		return borrow;
	}

	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}
	
	
	
}
