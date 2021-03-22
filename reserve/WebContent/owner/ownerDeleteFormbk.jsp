<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="vo.Owner" %>
    <%
    	Owner owner = (Owner)request.getAttribute("owner");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<form action="ownerDelete.own" method="post">
<table border="0">
	<tr>
		<td>탈퇴하려면 비밀번호 입력</td>
		<td><input type="password" name="owner_pw" id="owner_pw" /></td>
		<td><input type="hidden" name="owner_id" id="owner_id" value="<%=request.getParameter("owner_id") %>"/></td>
	</tr>
	<tr>
		<td colspan="3"><input type="submit" value="탈퇴하기" /></td>
		
</table>
</form>

</body>
</html>