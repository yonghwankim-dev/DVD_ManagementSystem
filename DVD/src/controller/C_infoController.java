package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Customer;
import service.CustomerService;
import service.FamilyService;

@WebServlet("/index/c_info")
public class C_infoController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<Customer> c_info_list = CustomerService.findCustomerAllList();
			request.setAttribute("c_info_list", c_info_list);
		} catch (SQLException e) {
			System.out.println("C_infoController, doGet, 고객정보 전체 탐색 실패");
			e.printStackTrace();
		}
				
		request.getRequestDispatcher("/WEB-INF/view/c_info.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String search = request.getParameter("search");
		List<Customer> c_info_list = null;
		
		
		try {
			switch(search)
			{
				case "이름검색":
					c_info_list = CustomerService.findCustomerListByName(name);
					break;
				case "가족검색":
					c_info_list = FamilyService.findFamilyListByName(name);
					break;
				case "ID검색":
					c_info_list = CustomerService.findCustomerListById(id);
					break;
				case "전체보기":
					c_info_list = CustomerService.findCustomerAllList();
					break;
				default:
					break;
			}
			
			request.setAttribute("c_info_list", c_info_list);
		}catch(Exception e)
		{
			System.out.println("C_infoController, doPost, 고객 정보 탐색 실패");
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/view/c_info.jsp").forward(request, response);
	}
	
}
