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

import controller.DVD_AdminController;
import entity.DVD;
import service.DVDManageService;
import service.DVDService;

@WebServlet("/index/dvd_admin/update")
public class DVD_UpdatePageContoller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/dvd_admin/update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int d_num = Integer.parseInt(request.getParameter("d_num"));
		String title = request.getParameter("title");
		String director = request.getParameter("director");
		String category = request.getParameter("category");
		int rating = Integer.parseInt(request.getParameter("rating"));
		int d_borrow_fee = Integer.parseInt(request.getParameter("borrow_fee"));
		
		String release_date_ = null;
		Date release_date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			release_date_ = request.getParameter("release_date");
			release_date = sdf.parse(release_date_);
			
			DVD updatedDVD = new DVD(d_num, director, release_date, title, category, d_borrow_fee, rating);
			
			boolean result = DVDManageService.UpdateDVD(updatedDVD);
			if(result)
			{
				System.out.println("DVD 자료 수정 성공");
			}
			else
			{
				throw new SQLException();
			}
		} catch (ParseException | SQLException e) {
			System.out.println("DVD_UpdatePageController, DVD 자료 수정 실패");
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/index/dvd_admin").forward(request, response);
	}
	
	
	
}
