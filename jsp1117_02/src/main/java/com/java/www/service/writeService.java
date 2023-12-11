package com.java.www.service;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.www.dao.BoardDao;
import com.java.www.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class writeService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao bdao = new BoardDao();
		
		String btitle="",bcontent="",id="",bfile="";
		int result = 0;
		BoardDto bdto = null;
		
		String upt = "c:/upload";
		int size = 10*1024*1024;
		try {
			MultipartRequest mt = new MultipartRequest(request, upt, size, "utf-8", new DefaultFileRenamePolicy());
			btitle = mt.getParameter("btitle");
			bcontent = mt.getParameter("bcontent");
			id = mt.getParameter("id");
			
			Enumeration files = mt.getFileNames();
			while(files.hasMoreElements()) {
				String f = (String)files.nextElement();
				bfile = mt.getFilesystemName(f);
			}
			bdto = new BoardDto(btitle, bcontent, id, bfile);
			result = bdao.bwrite(bdto);
			
		} catch (Exception e) {e.printStackTrace();}
			
		

	}

}
