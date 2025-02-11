package vn.edu.taipp.Vidu_doPostservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Info
 */
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter dau_ghi_kq = response.getWriter();
		dau_ghi_kq.print("Bạn vừa gửi yêu cầu dạng GET");
		dau_ghi_kq.print("<form method = POST action = '/Vidu_doPostservlet/Info'>");
		dau_ghi_kq.print("<label>Họ: </label>");
		dau_ghi_kq.println("<input type='text' name='ho' />");
		dau_ghi_kq.print("<label>Tên: </label>");
		dau_ghi_kq.println("<input type='text' name='ten'/> <br>");
		dau_ghi_kq.println("<input type='submit' value='Gửi đi'/>");
		dau_ghi_kq.print("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter dau_ghi_kq = response.getWriter();
		String ho = request.getParameter("ho");
		String ten = request.getParameter("ten");
		dau_ghi_kq.println("Bạn vừa gửi yêu cầu dạng Post");
		dau_ghi_kq.print("Họ: "); dau_ghi_kq.print(ho);
		dau_ghi_kq.print("Tên: "); dau_ghi_kq.print(ten);

	}

}
