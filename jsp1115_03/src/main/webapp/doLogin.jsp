<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 체크</title>
	</head>
	<body>
	  <c:if test="${result==1}">
	    <script>
	      alert("로그인 성공");
	      location.href="index.do";
	    </script>
	  </c:if>
	  <c:if test="${result!=1}">
	    <script>
	      alert("응 아니야");
	      location.href="login.do";
	    </script>
	  </c:if>
	
	</body>
</html>