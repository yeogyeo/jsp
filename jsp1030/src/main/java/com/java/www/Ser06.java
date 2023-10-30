package com.java.www;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Ser06")
public class Ser06 extends HttpServlet {
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction접근");
		request.setCharacterEncoding("utf-8"); //post방식 한글처리
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>서블릿</title>");
		writer.println("<style>");
		writer.println("div{background:yellow; width: 600px; height: 600px; }" );
		writer.println("*{text-align: center; font-size: 70px; margin: auto;}" );
		writer.println("</style>");
		writer.println("<script>alert('당신이 입력한 이름 : "+ request.getParameter("name") +"')</script>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<div>서블릿에서 만든 사각형</div>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet접근");
		doAction(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost접근");
		doAction(request, response);
	}
}