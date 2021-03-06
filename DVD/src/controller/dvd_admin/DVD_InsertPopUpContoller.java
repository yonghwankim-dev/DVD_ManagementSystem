package controller.dvd_admin;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.DVD;
import service.DVDManageService;
import service.DVDService;

@WebServlet("/index/dvd_admin/insert")
public class DVD_InsertPopUpContoller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/dvd_admin/insert.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String director = request.getParameter("director");
		String category = request.getParameter("category");
		int rating = Integer.parseInt(request.getParameter("rating"));
		int d_borrow_fee = Integer.parseInt(request.getParameter("borrow_fee"));
		
		System.out.println("title : " + title);
		System.out.println("director : " + director);
		System.out.println("category : " + category);
		System.out.println("rating: " + rating);
		System.out.println("d_borrow_fee : " + d_borrow_fee);
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String release_ = request.getParameter("release_date");	// 2021-07-14
			
			System.out.println("release_date : " + release_);
			Date release_date = sdf.parse(release_);
			
			DVD newDVD = new DVD(-1, director, release_date, title, category, d_borrow_fee, rating);
			boolean result = DVDManageService.InsertDVD(newDVD);
			if(result)
			{
				System.out.println("DVD 자료 삽입 성공");
			}
			else
			{
				throw new SQLException();
			}
			
			request.setAttribute("dvd_list", DVDService.findDVDAllList());
		} catch (ParseException | SQLException e) {
			System.out.println("DVD_InsertPopUpController, DVD 자료 삽입 실패");
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/view/dvd_admin.jsp").forward(request, response);
	}
	
	
	
}
