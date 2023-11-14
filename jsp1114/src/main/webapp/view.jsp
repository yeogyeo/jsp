
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.java.www.Dto.BoardDto"%>
<%@page import="com.java.www.Dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%
			int bno = Integer.parseInt(request.getParameter("bno"));
			//1개 데이터 가져오기 - dto
			BoardDao bdao = new BoardDao();
			BoardDto bdto = bdao.selectOne(bno);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		%>
		<meta charset="UTF-8">
		<title>게시글보기</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<style>
		  *{margin:0; padding:0;}
		  div{width:1000px; margin:30px auto; text-align: center;}
		  h1{margin-bottom:30px;}
		  table{width:100%;}
		  table,th,td{border:1px solid black; border-collapse: collapse;
		  font-size: 16px;}
		  th{height:40px;}
		  img{width:80%;}
		  button{width:150px; height:40px; margin-top:30px;}
		</style>
		<script>
			
		
		</script>
	</head>
	<body>
		
	<div>
	   <h1>회원정보 보기</h1>
	   
	      <table>
	      <colgroup>
	      	<col width="20%">
	      	<col width="80%">
	      </colgroup>
	        <tr>
	          <th>번호</th>
	          <td><%= bdto.getBno() %></td>
	        </tr>
	        <tr>
	          <th>작성자</th>
	          <td><%= bdto.getId() %></td>
	        </tr>
	        <tr>
	          <th>날짜</th>
	          <td><%= sdf.format(bdto.getBdate()) %></td>
	        </tr>
	        <tr>
	          <th>제목</th>
	          <td><%= bdto.getBtitle() %></td>
	        </tr>
	        <tr>
	          <th>내용</th>
	          <td><%= bdto.getBcontent() %></td>
	        </tr>
	        <tr>
	          <th>이미지</th>
	          <td><img src="upload/<%=bdto.getBfile() %>"></td>
	        </tr>
	      </table>
	       <a href="update.jsp"><button type="button" id="fbtn">게시글수정</button></a>
	       <a href="delete.jsp"><button type="button" id="fbtn">게시글삭제</button></a>
	       <a href="list.jsp"><button type="button" id="fbtn">게시글리스트</button></a>
	  
	  </div>
	
	</body>
</html>