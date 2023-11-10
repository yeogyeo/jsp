package com.java.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.MemberDao;
import com.java.www.dto.MemberDto;


@WebServlet("/Do_mlogin")
public class Do_mlogin extends HttpServlet {
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String uid = request.getParameter("id");
		String upw = request.getParameter("pw");
		//객체선언 후 메소드 호출
		MemberDao mdao = new MemberDao();
		MemberDto mdto = mdao.mloginCheck(uid, upw);
		
		String msg = "";
		String url = "";
		if(mdto==null) { //실패시
			//섹션
		    msg = "아이디 또는 패스워드가 일치하지 않습니다. 다시 로그인해주세요.";
		    url = "mlogin.jsp";
		}else { //성공시
			session.setAttribute("session_id", uid);
			session.setAttribute("session_name", mdto.getName());
			msg = "로그인 되었습니다.";
			url = "mindex.jsp";
			
		}//if
		
		//html페이지
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<html>");
		writer.print("<head><title>로그인체크</title></head>");
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
