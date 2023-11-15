package com.java.www.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.BoardDao;
import com.java.www.dto.BoardDto;

public class BListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDao bdao = new BoardDao();
		ArrayList<BoardDto> list = bdao.listSeledtAll();
		
		//request객체에 추가
		request.setAttribute("list", list);
	}

}
