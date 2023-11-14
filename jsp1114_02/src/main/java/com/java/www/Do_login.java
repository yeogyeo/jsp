package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.Dao.MemberDao;
import com.java.Dto.MemberDto;


@WebServlet("/dologin.do")
public class Do_login extends HttpServlet {
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");
		String id =request.getParameter("id");
		String pw =request.getParameter("pw");
		
		MemberDao mdao = new MemberDao();
		MemberDto mdto = mdao.loginCheck(id, pw);
		
		String msg = "";
		String url = "";
		if(mdto!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("session_id", mdto.getId());
			session.setAttribute("session_name", mdto.getName());
			
			msg = "로그인 성공";
			url = "main.jsp";
		}else {
			msg = "응 실패";
			url = "login.jsp";
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<html>");
		writer.print("<head><title>로그인</title></head>");
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
		System.out.println("doPost");
		doAction(request, response);
	}

}
