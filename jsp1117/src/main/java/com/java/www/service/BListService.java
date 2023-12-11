package com.java.www.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.BoardDao;
import com.java.www.dto.BoardDto;

public class BListService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//dao 접근
		BoardDao bdao = new BoardDao();
		
		// ---- 하단넘버링 ----
		int rowPage = 10; //1페이지당 10개의 게시글표시
		int bottomPage = 10; //하단넘버링 개수
		
		//1. 전체개수
		int listCount = bdao.listCount();
		//2. 현제페이지
		int page = 1;
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
			System.out.println("request.getParameter page : "+page);
		}
		System.out.println("현재페이지 : "+page);
		
		//3. 최대 하단 넘버링페이지 41/10 = 4.1 - >(반올림) 5.0 ->(int형변환) 5
		int maxPage = (int)Math.ceil((double)listCount/rowPage);
		
		// 4. startPage : 하단넘버링 시작번호 (int)(5-1/10)*10 + 1 = 1
		int startPage = (int)((page-1)/bottomPage) * bottomPage + 1;
		
		//5. endPage : 하단넘버링 끝번호 1+10-1 = 10
		int endPage = startPage+bottomPage-1;
		
		//6. startRow - oracle에서 가져오는 시작번호 (3-1)*10+1 = 21
		int startRow = (page-1)*rowPage+1;
		//7.endRow - oracle에서 가져오는 끝번호 21+10-1 = 30
		int endRow = startRow+rowPage-1;
		
		// *** 전체게시글 가져오기 ***
		ArrayList<BoardDto> list = bdao.bList();
		
		//확인
		System.out.println("BListService list : "+list.get(0).getBno());
		
		//request추가
		request.setAttribute("list", list);
		request.setAttribute("listCount", listCount);

	}

}
