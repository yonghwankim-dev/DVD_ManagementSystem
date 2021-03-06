package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Borrow;
import entity.Customer;
import entity.DVD;
import entity.loan_list.Loan;

public class BorrowService {
	// 대여 목록 상세 검색
	public static List<Loan> findBorrowList(String category, String content) throws SQLException
	{
		List<Loan> loan_list = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			String sql = "select d.d_num, d.title, d.release_date, c.id, c.name, c.phone, b.borrow_date " +
						"from dvd d, customer c, borrow b " +
						"where d.d_num = b.d_b_num and c.c_num = b.c_b_num and c."+category+"= ? " +
						"order by d.d_num ";

			
			con = DriverManager.getConnection(url,"DVD_USER","DVD_USER");
			pst = con.prepareStatement(sql);
			pst.setString(1, content);
			
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				DVD dvd = new DVD(
									rs.getInt("d_num"),
									rs.getDate("release_date"),
									rs.getString("title")
								);
				Customer customer = new Customer(
												rs.getString("id"),
												rs.getString("name"),
												rs.getString("phone")
											);
				
				Borrow borrow = new Borrow(
												rs.getDate("borrow_date")
											);
				
				Loan loan = new Loan(dvd, customer, borrow);
				loan_list.add(loan);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("findBorrowList 메서드, 대여목록 검색 실패");
			e.printStackTrace();
		}finally {
			rs.close();
			pst.close();
			con.close();
		}
		
		return loan_list;
	}
	
	// 대여 목록 전체 검색
	public static List<Loan> findBorrowAllList() throws SQLException
	{
		List<Loan> loan_list = new ArrayList<>();
		
		Connection con = null;
		Statement pst = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			String sql = "select d.d_num, d.title, d.release_date, c.id, c.name, c.phone, b.borrow_date " +
						"from dvd d, customer c, borrow b " +
						"where d.d_num = b.d_b_num and c.c_num = b.c_b_num " +
						"order by d.d_num ";

			
			con = DriverManager.getConnection(url,"DVD_USER","DVD_USER");
			pst = con.createStatement();
			
			rs = pst.executeQuery(sql);
			
			while(rs.next())
			{
				DVD dvd = new DVD(
									rs.getInt("d_num"),
									rs.getDate("release_date"),
									rs.getString("title")
								);
				Customer customer = new Customer(
												rs.getString("id"),
												rs.getString("name"),
												rs.getString("phone")
											);
				
				Borrow borrow = new Borrow(
												rs.getDate("borrow_date")
											);
				
				Loan loan = new Loan(dvd, customer, borrow);
				loan_list.add(loan);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("findBorrowAllList 메서드, 대여목록 검색 실패");
			e.printStackTrace();
		}finally {
			rs.close();
			pst.close();
			con.close();
		}
		
		return loan_list;
	}
}
