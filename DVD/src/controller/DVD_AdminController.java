package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.DVD;
import service.DVDManageService;
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
		request.setCharacterEncoding("utf-8");
		
		// 체크박스를 선택하지 않은 경우 되돌아간다.
		if(request.getParameterValues("chk")==null)
		{
			this.doGet(request, response);
			return;
		}
		
		String cmd = request.getParameter("cmd");
		
		
		switch(cmd)
		{
		case "수정":
			int d_num = Integer.parseInt(request.getParameterValues("chk")[0]);
			DVD updatedDVD = null;
			try {
				updatedDVD = DVDService.findDVDByNum(d_num);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("updatedDVD", updatedDVD);
			request.getRequestDispatcher("/WEB-INF/view/dvd_admin/update.jsp").forward(request, response);
			break;
			
		case "삭제":
			try {
				int[] d_nums = Arrays.asList(request.getParameterValues("chk")).stream().mapToInt(Integer::parseInt).toArray();
				boolean result = DVDManageService.DeleteDVD(d_nums);
				if(result)
				{
					System.out.println("dvd 자료 삭제완료");
				}
				else
				{
					throw new SQLException();
				}
			} catch (SQLException e) {
				System.out.println("DVD_AdminController, dvd 자료 삭제 실패");
				e.printStackTrace();
			}
			this.doGet(request, response);
			break;
		case "새로고침":
			this.doGet(request, response);
			break;
		default:
			this.doGet(request, response);
			break;
		}
		
	}
	
}
