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

import entity.loan_list.Loan;
import service.BorrowService;

@WebServlet("/index/loan_list")
public class Loan_ListController extends HttpServlet{
	private static Map<String, String> category_map = new HashMap<String, String>(){{put("이름","name");}};
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/loan_list.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String category = category_map.get(request.getParameter("category"));
		String content = request.getParameter("content");
		String search = request.getParameter("search");
		
		List<Loan> loan_list = null;
		try {
			switch(search)
			{
			case "검색":
				loan_list = BorrowService.findBorrowList(category, content);
				break;
			case "전체보기":
				loan_list = BorrowService.findBorrowAllList();
				break;
			default:
				break;
			}
			request.setAttribute("loan_list", loan_list);
		}catch(SQLException e)
		{
			System.out.println("Loan_ListController, 검색/전체보기 수행 실패");
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/view/loans.jsp").forward(request, response);
	}
	
}
