package com.java.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.service.ListService;
import com.java.www.service.MDLoginService;
import com.java.www.service.SelectOneService;
import com.java.www.service.Service;
import com.java.www.service.writeService;


@WebServlet("*.do")
public class FController extends HttpServlet {
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");
	    String uri = request.getRequestURI();
	    String cPath = request.getContextPath();
	    String fileName = uri.substring(cPath.length());
	    System.out.println("파일명 : "+fileName);
	    
	    Service service = null;
	    String url = null;
	    switch (fileName) {
	    case "/index.do" :
	    	response.sendRedirect("index.jsp");
	    	break;
	    case "/mInsert.do" :
	    	response.sendRedirect("mInsert.jsp");
	    	break;
	    case "/login.do" :
	    	response.sendRedirect("login.jsp");
	    	break;
	    case "/doLogin.do" :
	    	service = new MDLoginService();
	    	service.execute(request, response);
	    	url = "doLogin.jsp";
	    	break;
	    case "/logout.do" :
	    	response.sendRedirect("logout.jsp");
	    	break;
	    case "/list.do" :
	    	service = new ListService();
	    	service.execute(request, response);
	    	System.out.println("FC : list.jsp호출");
	    	url = "list.jsp";
	    	break;
	    case "/bView.do" :
	    	service = new SelectOneService();
	    	service.execute(request, response);
	    	System.out.println("FC : bView.jsp호출");
	    	url = "bView.jsp";
	    	break;
	    case "/write.do" :
	    	response.sendRedirect("write.jsp");
	    	break;
	    case "/bwrite.do" :
	    	service = new writeService();
	    	service.execute(request, response);
	    	System.out.println("FC : write.jsp호출");
	    	url = "bwrite.jsp";
	    	break;
	    	
	    	
	    	
	    	
	    	
	    	
	    }//switch
		
		if(url!=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		
		
		
		
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
