
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		
		<meta charset="UTF-8">
		<title>게시글보기</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
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
			$(function(){
				$("")
			});
		
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
	          <td>${bdto.bno}</td>
	        </tr>
	        <tr>
	          <th>작성자</th>
	          <td>${bdto.id}</td>
	        </tr>
	        <tr>
	          <th>날짜</th>
	          <td><fmt:formatDate value="${bdto.bdate}" pattern="yyyy/MM/dd"/> </td>
	        </tr>
	        <tr>
	          <th>제목</th>
	          <td>${bdto.btitle}</td>
	        </tr>
	        <tr>
	          <th>내용</th>
	          <td>${bdto.bcontent}</td>
	        </tr>
	        <tr>
	          <th>이미지</th>
	          <td>
         		  <c:if test="${bdto.bfile !=null }">
		          <img src="upload/${bdto.bfile}">
		          </c:if>
		          <c:if test="${bdto.bfile ==null }">
		          <i class="fa fa-stop" aria-hidden="true"></i> 첨부파일 없음
		          </c:if>
	          </td>
	        </tr>
	      </table>
	       <a href="update.do"><button type="button" id="fbtn">게시글수정</button></a>
	       <a href="delete.do"><button type="button" id="delbtn">게시글삭제</button></a>
	       <a href="list.do"><button type="button" id="fbtn">게시글리스트</button></a>
	  
	  </div>
	
	</body>
</html>