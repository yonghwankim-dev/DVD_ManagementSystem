package entity;

public class Administrator {
	private int a_num;				// 관리자 번호
	private String id;				// 아이디
	private String name;			// 성명
	private String register_num;	// 주민등록번호
	private String email;			// 이메일
	private String phone;			// 연락처
	private String password;		// 비밀번호
	private String address;			// 주소
	
	public Administrator(int a_num, String id, String name, String register_num, String email, String phone,
			String password, String address) {
		this.a_num = a_num;
		this.id = id;
		this.name = name;
		this.register_num = register_num;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.address = address;
	}
	
	public int getA_num() {
		return a_num;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegister_num() {
		return register_num;
	}
	public void setRegister_num(String register_num) {
		this.register_num = register_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	
}
