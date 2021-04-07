<%@page import="vo.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	ArrayList<Cart> list = (ArrayList<Cart>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${list ne null }">
	<c:forEach var="list" items="${list }">
	식당이름 : ${list.restName }<br>
	식당 사진 : <img src="upload/${list.img }" ><br>
	식당 번호 : ${list.rest_no }<br>
	찜 번호 : ${list.cart_no }
	
	
	</c:forEach>
</c:if>
<c:if test="${list eq null }">
	찜 목록 정보가 없다
</c:if>
</body>
</html>