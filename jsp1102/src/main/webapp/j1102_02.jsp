<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>jsp-스크립트릿</title>
		<style>
			table{width:750px; margin:50px auto;}
			th,td{width:80px; height:30px;}
			table,th,td{text-align:center;
			border:1px solid black; border-collapse: collapse;}
		</style>
	</head>
	<body>
	<table>
		<tr>
			<th>단</th>
			<th>*</th>
			<th>숫자</th>
			<th>=</th>
			<th>곱셈</th>
		</tr>
		<%
		   for(int i=2;i<=9;i++){
			   for(int j=1;j<=9;j++){
				   
	   %>	 
		
		<tr>
			<th><%= i %></th>
			<th>*</th>
			<th><%= j %></th>
			<th>=</th>
			<th><%= (i*j) %></th>
		</tr>
		
	   <%
			   }
		   }
	   %>  
	</table>	
	<%
	   //구구단을 출력을 해보세요.
	   
	
	%>
	
	
	
	
	</body>
</html>