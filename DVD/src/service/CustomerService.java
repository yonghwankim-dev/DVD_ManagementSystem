package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Customer;

public class CustomerService {
	// 이름으로 검색
	public static List<Customer> findCustomerListByName(String name) throws SQLException
	{
		List<Customer> c_info_list = new ArrayList<Customer>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			String sql = "select * from customer where name like ?";
			
			con = DriverManager.getConnection(url,"DVD_USER","DVD_USER");
			pst = con.prepareStatement(sql);
			pst.setString(1, "%"+name+"%");
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				Customer customer = new Customer(
													rs.getInt("c_num"),
													rs.getString("id"),
													rs.getString("name"),
													rs.getString("register_num"),
													rs.getString("email"),
													rs.getString("phone"),
													rs.getString("password"),
													rs.getString("address"),
													rs.getInt("point")
												);
				c_info_list.add(customer);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("findCustomerListByName 메서드, 고객정보 이름 탐색 실패");
			e.printStackTrace();
		}finally {
			rs.close();
			pst.close();
			con.close();
		}
		
		return c_info_list;
	}
	
	// ID로 검색
	public static List<Customer> findCustomerListById(String id) throws SQLException
	{
		List<Customer> c_info_list = new ArrayList<Customer>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			String sql = "select * from customer where id like ?";
			
			con = DriverManager.getConnection(url,"DVD_USER","DVD_USER");
			pst = con.prepareStatement(sql);
			pst.setString(1, "%"+id+"%");
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				Customer customer = new Customer(
													rs.getInt("c_num"),
													rs.getString("id"),
													rs.getString("name"),
													rs.getString("register_num"),
													rs.getString("email"),
													rs.getString("phone"),
													rs.getString("password"),
													rs.getString("address"),
													rs.getInt("point")
												);
				c_info_list.add(customer);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("findCustomerListById 메서드, 고객정보 ID 탐색 실패");
			e.printStackTrace();
		}finally {
			rs.close();
			pst.close();
			con.close();
		}
		
		return c_info_list;
	}
	
	// 전체보기
	public static List<Customer> findCustomerAllList() throws SQLException
	{
		List<Customer> c_info_list = new ArrayList<Customer>();
		Connection con = null;
		Statement pst = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			String sql = "select * from customer";
			
			con = DriverManager.getConnection(url,"DVD_USER","DVD_USER");
			pst = con.createStatement();
			rs = pst.executeQuery(sql);
			
			while(rs.next())
			{
				Customer customer = new Customer(
													rs.getInt("c_num"),
													rs.getString("id"),
													rs.getString("name"),
													rs.getString("register_num"),
													rs.getString("email"),
													rs.getString("phone"),
													rs.getString("password"),
													rs.getString("address"),
													rs.getInt("point")
												);
				c_info_list.add(customer);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("findCustomerAllList 메서드, 고객정보 전체 탐색 실패");
			e.printStackTrace();
		}finally {
			rs.close();
			pst.close();
			con.close();
		}
		
		return c_info_list;
	}
}
