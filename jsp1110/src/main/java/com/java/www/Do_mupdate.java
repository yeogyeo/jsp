package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.MemberDao;


@WebServlet("/Do_mupdate")
public class Do_mupdate extends HttpServlet {
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		String hobby = "";
		for(int i=0;i<hobbys.length;i++) {
			if(i==0) hobby = hobbys[i];
			else hobby +=","+hobbys[i];
		}//for
		
		//1명의 회원정보수정 메소드 호출
		MemberDao mdao = new MemberDao();
		int result = mdao.memberUpdate(id,phone,gender,hobby);
		
		String msg = "";
		String url = "";
		if(result==1) { //성공
		    msg = "회원정보가 수정되었습니다.";
		    url = "mview.jsp?id="+id;
		}else { //실패
			msg = "회원정보가 제대로 수정되지 않았습니다.";
			url = "mview.jsp?id="+id;
			
		}//if
		
		//html페이지
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<html>");
		writer.print("<head><title>회원정보수정</title></head>");
		writer.print("<body>");
		writer.print("<script>");
		writer.print("alert('"+msg+"');");
		writer.print("location.href='"+url+"';");
		writer.print("</script>");
		writer.print("</body>");
		writer.print("</html>");
		writer.close();
		
	}
		
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}

}
