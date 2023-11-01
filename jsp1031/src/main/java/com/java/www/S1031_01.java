package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/S01")
public class S1031_01 extends HttpServlet {
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");  //post 한글철기
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		System.out.println("id : "+request.getParameter("id"));
		System.out.println("hobby : "+Arrays.toString(request.getParameterValues("hobby")));
	
		//배열을 hobbys 변수에 입력
		String[] hobbys = request.getParameterValues("hobby");  //배열변수
		String hobby = "";
		for(int i=0;i<hobbys.length;i++) {
			if(i==0) hobby=hobbys[i];            //game
			else hobby += "," + hobbys[i]; //,golf,run,cook,book
			//game,golf,run,cook,book
		}//for
		
		writer.println("<html>");
		writer.println("<head><title>form데이터</title></head>");
		writer.println("<body>");
		writer.println("checkbox hobby 배열 : "+Arrays.toString(request.getParameterValues("hobby")));
		writer.println("<br>");
		writer.println("checkbox hobby 1개의 문자열: "+hobby);
		writer.println("<br>");
		writer.println("radio gerder : "+request.getParameter("id"));
		writer.println("<br>");
		writer.println("select address : "+request.getParameter("address"));
		writer.println("<br>");
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
	}//doAction
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request, response);
	}//doPost

}//class
