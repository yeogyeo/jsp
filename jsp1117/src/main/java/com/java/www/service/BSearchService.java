package com.java.www.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.BoardDao;
import com.java.www.dto.BoardDto;

public class BSearchService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String bcategory = request.getParameter("bcategory");
		String bsearch = request.getParameter("bsearch");
		
		//dao  접근
		BoardDao bdao = new BoardDao();
		ArrayList<BoardDto> list = bdao.bSearch(bcategory,bsearch);
		System.out.println("BSearchService list개수 : "+list.size());
		//request 추가
		request.setAttribute("list", list);
		request.setAttribute("listCount", list.size());

	}

}
