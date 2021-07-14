package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.DVD;
import service.DVDService;

@WebServlet("/index/dvd_admin")
public class DVD_AdminController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<DVD> dvd_list = DVDService.findDVDAllList();
			request.setAttribute("dvd_list", dvd_list);
		} catch (SQLException e) {
			System.out.println("DVD_AdminController, DVD목록 호출 실패");
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/view/dvd_admin.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		switch(cmd)
		{
		case "추가":
			break;
		case "수정":
			break;
		case "삭제":
			break;
		case "새로고침":
			break;
		default:
			break;
		}
	}
	
}
