<%@page import="vo.Reservation"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	ArrayList<Reservation> list = (ArrayList<Reservation>)request.getAttribute("list"); 
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
리스트<br>
<c:if test="${list != null }">
	<c:forEach var="list" items="${list }" varStatus="status">
	에약번호 : ${list.reserv_no }<br>
	식당번호 : ${list.rest_no }<br>
	날짜 : ${list.date }<br>
	인원수 : ${list.head }<br>
	시간 : ${list.time }<br>
	가게이름 : ${list.restName }
	123<br>
	
	</c:forEach>
</c:if>
<c:if test="${list eq null }">
예약 정보가 없습니다. 예약해주세오
</c:if>

</body>
</html>