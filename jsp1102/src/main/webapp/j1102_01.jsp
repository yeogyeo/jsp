<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<%
	   out.println("<h2>1에서 100까지 합</h2>");
	   int sum = 0;
	   for(int i=1;i<=100;i++){
		   sum += i;
		   out.println("더할 숫자 : "+i+"<br>");
	   }
	   out.println("==============================<br>");
	   out.println("합계 : "+sum+"<br>");
	%>
	
	</body>
</html>