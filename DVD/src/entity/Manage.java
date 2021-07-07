package entity;

public class Manage {
	private int a_m_num;	// 관리자 번호
	private int d_m_num;	// DVD 번호
	
	public Manage(int a_m_num, int d_m_num) {
		this.a_m_num = a_m_num;
		this.d_m_num = d_m_num;
	}
	
	public int getA_m_num() {
		return a_m_num;
	}
	public void setA_m_num(int a_m_num) {
		this.a_m_num = a_m_num;
	}
	public int getD_m_num() {
		return d_m_num;
	}
	public void setD_m_num(int d_m_num) {
		this.d_m_num = d_m_num;
	}
	
	
}
