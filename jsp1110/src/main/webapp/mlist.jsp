<%@page import="com.java.www.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.java.www.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
	<%if(session.getAttribute("session_id")==null){%>
   		<script>
   			alert("로그인을 하셔야 접급이 가능합니다.");
   			location.href="mlogin.jsp";
   		</script>
   	<%}%>
		<meta charset="UTF-8">
		<title>회원전체리스트</title>
		<style>
		  *{margin:0; padding:0;}
		  div{width:1000px; margin:30px auto; text-align: center;}
		  h1{margin-bottom:30px;}
		  table,th,td{border:1px solid black; border-collapse: collapse;
		  font-size: 16px;}
		  th,td{width:200px; height:40px;}
		  button{width:200px; height:60px; margin-top:30px;}
		</style>
	</head>
	<body>
	<div>
	   <h1>회원전체리스트</h1>
	   
	      <table>
	        <tr>
	          <th>아이디</th>
	          <th>패스워드</th>
	          <th>이름</th>
	          <th>성별</th>
	          <th>가입일</th>
	        </tr>
	        <%
	        	MemberDao mdao = new MemberDao();
	        	//전체회원리스트 가져오기
	        	ArrayList<MemberDto> list = mdao.memberAll();
	        	MemberDto mdto = null;
	        	for(int i=0;i<list.size();i++){
	        		mdto = list.get(i);
	        		
	        		
	        	%>	
	        	
	        <tr>
	        	<td><%= mdto.getId() %></td>
	        	<td><%= mdto.getPw()%></td>
	        	<td><a href="mview.jsp?id=<%=mdto.getId()%>"><%= mdto.getName()%></a></td>
	        	<td><%= mdto.getGender()%></td>
	        	<td><%= mdto.getMdate()%></td>
	        </tr>
	       <%}%>
	        	
	        
	      </table>
	       <a href="mwrite.jsp"><button type="button">회원추가</button></a>
	       <a href="mindex.jsp"><button type="button">홈으로</button></a>
	  </div>
	</body>
</html>