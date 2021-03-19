<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디 : <%=request.getParameter("owner_id") %>
비밀번호 :<%=request.getParameter("owner_pw") %>
번호 :<%=request.getParameter("owner_no") %>
번호 :<%=session.getAttribute("owner_no") %>


<table>
	<tr>
		<td><a href="ownerModInfoForm.own?id=<%=request.getParameter("owner_id") %>">회원 정보 수정</a></td>
	</tr>
	<tr>
		<td><a href="ownerRegiMarketForm.own?id=<%=request.getParameter("owner_id") %>">가게 정보 등록</a></td>
	</tr>
</table>
</body>
</html>