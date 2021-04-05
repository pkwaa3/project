<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="reservation.bo" method="post" name="">
<input type="text" id="id" name="id" value="<%=session.getAttribute("id")%>">
<input type="text" name="board_no" id="board_no" value="23">
인원수<input type="text" name="head" id="head"/>
날짜<input type="text" name="date" id="date"/>
시간<input type="text" name="time" id="time">
<input type="submit" value="전송">전송
</form>
</body>
</html>