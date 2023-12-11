package com.java.www.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.www.dao.MemberDao;
import com.java.www.dto.MemberDto;

public class MDLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("서비스 아이디 : "+id);
		
		
		MemberDao mdao = new MemberDao();
		MemberDto mdto = mdao.mDologin(id,pw);
		HttpSession session = request.getSession();
		
		
		if(mdto != null) {
			
			session.setAttribute("session_id", mdto.getId());
			session.setAttribute("session_name", mdto.getName());
		}
		System.out.println(mdto.getId());

	}

}
