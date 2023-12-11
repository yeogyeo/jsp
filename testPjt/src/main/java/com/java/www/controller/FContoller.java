package com.java.www.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.service.NListService;
import com.java.www.service.NViewService;
import com.java.www.service.Service;


@WebServlet("*.do")
public class FContoller extends HttpServlet {
	
       
   
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		String uri = request.getRequestURI();
		String cpath = request.getContextPath();
		String fileName = uri.substring(cpath.length()); // /main.do
		String url=null;
		Service service = null;
		
		switch (fileName) {
		case "/main.do": 
			response.sendRedirect("main.jsp");
			break;
		case "/n_list.do": 
			service = new NListService();
			service.execute(request, response);
			url="n_list.jsp";
			break;
		case "/n_view.do": 
			service = new NViewService();
			service.execute(request, response);
			url="n_view.jsp";
			break;
		
		
		}
		
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
