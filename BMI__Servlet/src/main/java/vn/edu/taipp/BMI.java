package vn.edu.taipp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class BMI
 */
public class BMI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BMI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	    
	        out.println("<html><head><title>BMI Calculator</title></head><body>");
	        out.println("<h2>Tính chỉ số BMI</h2>");
	        out.println("<form method='POST' action ='/BMI__Servlet/BMI'>");
	        out.println("Chiều cao (cm): <input type='text' name='height'><br>");
	        out.println("Cân nặng (kg): <input type='text' name='weight'><br>");
	        out.println("<input type='submit' value='Tính BMI'>");
	        out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
	     PrintWriter out = response.getWriter();
	        
		 String heightStr = request.getParameter("height");
	     String weightStr = request.getParameter("weight");
	     double bmi = 0;
	        String category = "";

	        // Kiểm tra nếu người dùng đã nhập dữ liệu
	        if (heightStr != null && weightStr != null) {
	            try {
	                double height = Double.parseDouble(heightStr) / 100; // Đổi cm -> m
	                double weight = Double.parseDouble(weightStr);
	                bmi = weight / (height * height);

	                // Xác định phân loại BMI
	                if (bmi < 18.5) category = "Gầy";
	                else if (bmi < 24.9) category = "Bình thường";
	                else if (bmi < 29.9) category = "Thừa cân";
	                else category = "Béo phì";
	            } catch (NumberFormatException e) {
	                category = "Dữ liệu không hợp lệ!";
	            }
	        }
	}

}
