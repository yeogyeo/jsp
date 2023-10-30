package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/S_02")
public class Ser1030_02 extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// h2태그를 생성 후 controller페이지로 사용이 됩니다.
		System.out.println("doGet접근");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>서블릿파일</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h2>S_02페이지입니다.2</h2>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
		
		
	}//doGet
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost접근");
	}//doPost

}
