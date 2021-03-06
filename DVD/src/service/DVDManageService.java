package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.DVD;

public class DVDManageService {
	
	// DVD 추가
	public static boolean InsertDVD(DVD newDVD) throws SQLException
	{
		
		Connection con = null;
		PreparedStatement pst = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			String sql = "insert into dvd(d_num,director, release_date, title, category, d_borrow_fee, rating) "
					+ "values(DVD_SEQ.nextval, ?, ?, ?, ?, ?, ?)";

			
			con = DriverManager.getConnection(url,"DVD_USER","DVD_USER");
			pst = con.prepareStatement(sql);
			pst.setString(1, newDVD.getDirector());
			pst.setDate(2, new Date(newDVD.getRelease_date().getTime()));
			pst.setString(3, newDVD.getTitle());
			pst.setString(4, newDVD.getCategory());
			pst.setInt(5, newDVD.getD_borrow_fee());
			pst.setInt(6, newDVD.getRating());
			result = pst.executeUpdate();
			
			if(result==0)
			{
				throw new SQLException();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("InsertDVD 메서드, DVD 자료 생성중 실패");
			e.printStackTrace();
		}finally {
			pst.close();
			con.close();
		}
		
		return (result!=0 ? true : false);

	}
	
	// DVD 업데이트
	public static boolean UpdateDVD(DVD updatedDVD) throws SQLException
	{
		Connection con = null;
		PreparedStatement pst = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			String sql = "update dvd set director = ?, "
					+ "release_date = ?, "
					+ "title= ?, "
					+ "category= ?, "
					+ "d_borrow_fee = ?, "
					+ "rating= ? "
					+ "where d_num= ?";
			

			
			con = DriverManager.getConnection(url,"DVD_USER","DVD_USER");
			pst = con.prepareStatement(sql);
			pst.setString(1, updatedDVD.getDirector());
			pst.setDate(2, new Date(updatedDVD.getRelease_date().getTime()));
			pst.setString(3, updatedDVD.getTitle());
			pst.setString(4, updatedDVD.getCategory());
			pst.setInt(5, updatedDVD.getD_borrow_fee());
			pst.setInt(6, updatedDVD.getRating());
			pst.setInt(7, updatedDVD.getD_num());
			result = pst.executeUpdate();
			
			if(result==0)
			{
				throw new SQLException();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("UpdateDVD 메서드, DVD 자료 수정중 실패");
			e.printStackTrace();
		}finally {
			pst.close();
			con.close();
		}
		
		return (result!=0 ? true : false);
	}
	
	// DVD 삭제
	public static boolean DeleteDVD(int[] d_num) throws SQLException
	{
		Connection con = null;
		PreparedStatement pst = null;
		int result = 0;
		
		// 삭제할 번호 쿼리 생성
		StringBuilder sb = new StringBuilder();
		
		for(int d : d_num)
		{	
			sb.append(d+", ");
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		String query = sb.toString().trim();
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
			String sql = "delete from dvd where d_num in ("+query+")";
						
			con = DriverManager.getConnection(url,"DVD_USER","DVD_USER");
			pst = con.prepareStatement(sql);
			result = pst.executeUpdate();
			
			if(result==0)
			{
				throw new SQLException();
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("UpdateDVD 메서드, DVD 자료 수정중 실패");
			e.printStackTrace();
		}finally {
			pst.close();
			con.close();
		}
		
		return (result!=0 ? true : false);
	}
	
	// DVD 새로고침
	public static boolean RefreshDVD()
	{
		return false;
	}
}
