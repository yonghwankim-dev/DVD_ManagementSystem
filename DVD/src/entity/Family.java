package entity;

public class Family {
	private int c_f_num;	// 회원번호
	private String f_name;	// 가족성명
	private String f_id;	// 가족아이디

	public Family(int c_f_num, String f_name, String f_id) {
		this.c_f_num = c_f_num;
		this.f_name = f_name;
		this.f_id = f_id;
	}
	
	public int getC_f_num() {
		return c_f_num;
	}
	public void setC_f_num(int c_f_num) {
		this.c_f_num = c_f_num;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getF_id() {
		return f_id;
	}
	public void setF_id(String f_id) {
		this.f_id = f_id;
	}
	
	
}
