package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Customer;
import entity.DVD;

public class DVDService {
	// DVD 번호 검색
	public static DVD findDVDByNum(int d_num) throws SQLException
	{
		DVD dvd = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			String sql = "select * from dvd where d_num = ?"; 

			
			con = DriverManager.getConnection(url,"DVD_USER","DVD_USER");
			pst = con.prepareStatement(sql);
			pst.setInt(1, d_num);
			rs = pst.executeQuery();
			
			if(rs.next())
			{
				dvd = new DVD(rs.getInt("d_num"),
								rs.getString("director"),
								rs.getDate("release_date"),
								rs.getString("title"),
								rs.getString("category"),
								rs.getInt("d_borrow_fee"),
								rs.getInt("rating"));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("findDVDList 메서드, DVD검색중 실패");
			e.printStackTrace();
		}finally {
			rs.close();
			pst.close();
			con.close();
		}
		
		return dvd;

	}
	
	// DVD 전체 검색
	public static List<DVD> findDVDAllList() throws SQLException
	{
		List<DVD> dvd_list = new ArrayList<DVD>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			String sql = "select d.d_num, d.director, d.release_date, d.title, d.category, d.d_borrow_fee, d.rating " +  
						"from dvd d " +
						"order by d.d_num"; 

			
			con = DriverManager.getConnection(url,"DVD_USER","DVD_USER");
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				DVD dvd = new DVD(
									rs.getInt("d_num"),
									rs.getString("director"),
									rs.getDate("release_date"),
									rs.getString("title"),
									rs.getString("category"),
									rs.getInt("d_borrow_fee"),
									rs.getInt("rating")
									);	
				dvd_list.add(dvd);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("findDVDList 메서드, DVD검색중 실패");
			e.printStackTrace();
		}finally {
			rs.close();
			pst.close();
			con.close();
		}
		
		return dvd_list;
	}
	
	// DVD 검색
	public static List<DVD> findDVDList(String category, String content, String order) throws SQLException
	{
		List<DVD> dvd_list = new ArrayList<DVD>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			String sql = "select d.d_num, d.director, d.release_date, d.title, d.category, d.d_borrow_fee, d.rating " +  
						"from dvd d, actor a " +
						"where d.d_num=a.d_a_num and a."+category+ " = ? " +
						"order by d.d_num "+order; 

			
			con = DriverManager.getConnection(url,"DVD_USER","DVD_USER");
			pst = con.prepareStatement(sql);
			pst.setString(1, content);
			
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				DVD dvd = new DVD(
									rs.getInt("d_num"),
									rs.getString("director"),
									rs.getDate("release_date"),
									rs.getString("title"),
									rs.getString("category"),
									rs.getInt("d_borrow_fee"),
									rs.getInt("rating")
									);	
				dvd_list.add(dvd);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("findDVDList 메서드, DVD검색중 실패");
			e.printStackTrace();
		}finally {
			rs.close();
			pst.close();
			con.close();
		}
		
		return dvd_list;
	}
	
	
}
