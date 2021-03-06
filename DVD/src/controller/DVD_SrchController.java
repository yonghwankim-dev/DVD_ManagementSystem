package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.DVD;
import service.DVDService;

@WebServlet("/index/dvd_srch")
public class DVD_SrchController extends HttpServlet{
	private static Map<String, String> category_map = new HashMap<String, String>(){{put("주연","main_actor");}};
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/dvd_srch.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String category = category_map.get(request.getParameter("category"));
		String content = request.getParameter("content");
		String order = request.getParameter("order");
		List<DVD> dvd_list = null;
		
		try {
			if(content.equals(""))
			{
				dvd_list = DVDService.findDVDAllList();
			}
			else
			{
				dvd_list = DVDService.findDVDList(category, content, order);
			}
			
			request.setAttribute("dvd_list", dvd_list);
		} catch (SQLException e) {
			System.out.println("DVD_SrchController, DVD검색중 실패");
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/view/dvds.jsp").forward(request, response);
	}
	
}
