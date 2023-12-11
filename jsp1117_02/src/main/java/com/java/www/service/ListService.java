package com.java.www.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.BoardDao;
import com.java.www.dto.BoardDto;

public class ListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao bdao = new BoardDao();
		ArrayList<BoardDto> list = bdao.list();
		
		System.out.println("리스트서비스 리스트 : "+list.get(0).getBno());
		
		request.setAttribute("list", list);

	}

}
