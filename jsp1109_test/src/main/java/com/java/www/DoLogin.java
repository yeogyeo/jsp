package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DoLogin_01
 */
@WebServlet("/DoLogin")
public class DoLogin extends HttpServlet {
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String uid = request.getParameter("id");
		String upw = request.getParameter("pw");
		String msg = "";
		String url = "";
		
		System.out.println("id : "+uid);
		System.out.println("id : "+upw);
		
		MemberDao mdao = new MemberDao();
		
		MemberDto mdto = mdao.loginCheck(uid,upw);
		if(mdto==null) {
			msg = "아이디 또는 패스워드가 일치하지 않습니다. 다시 로그인하세요.";
			url = "login.jsp";
		}else {
			msg = "로그인 되었습니다.";
			url = "main.jsp";
			session.setAttribute("session_id", uid);
			session.setAttribute("session_nicName", uid);
		}
		
		response.setContentType("text/html; charset=utf8");
		PrintWriter writer = response.getWriter();
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<title>로그인체크</title>");
		writer.print("</head>");
		writer.print("<body>");
		writer.print("<script>");
		writer.print("alert('"+msg+"');");
		writer.print("location.href='"+url+"';");
		writer.print("</script>");
		writer.print("</body>");
		writer.print("</html>");
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request, response);
	}

} // HttpServlet

