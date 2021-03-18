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
<jsp:include page="../head.jsp" />
<body>
<form name="ownerModInfoForm" action="ownerModInfoPro.own" method="post">
	<table>
		<tr>
			<td colspan="2">회원 정보 수정</td>
		</tr>
		<tr>
			<td><label for="id">아이디 : </label></td>
			<td><input type="text" name="id" id="id" value="<%=owner.getOwner_id() %>" readonly></td>
		</tr>
		<tr>
			<td><label for="id">비밀번호 : </label></td>
			<td><input type="password" name="pass" id="pass" value='<%=owner.getOwner_pw()%>'/></td>
		</tr>
		<tr>
			<td><label for="name">이름 : </label></td>
			<td><input type="text" name="name" id="name" value='<%=owner.getOwner_name()%>'/></td>
		</tr>
		<tr>
			<td><label for="age">나이 : </label></td>
			<td><input type="text" name="age" id="age" value='<%=owner.getOwner_age()%>'/></td>
		</tr>
		<tr>
			<td><label for="gender">성별 : </label></td>
			<td><input type="radio" name="gender" value="남" ${member.gender eq '남' ? 'checked':''} id="gender1">남자
				<input type="radio" name="gender" value="여" ${member.gender eq '여' ? 'checked':''} id="gender2">여자</td>
		</tr>
		<tr>
			<td><label for="email">전화번호 : </label></td>
			<td><input type="text" name="email" id="email" value='<%=owner.getOwner_number()%>'/></td>
		</tr>
		<tr>
			<td><label for="email">이메일 주소 : </label></td>
			<td><input type="text" name="email" id="email" value='<%=owner.getOwner_email()%>'/></td>
		</tr>
		<tr>
			<td colspan="2"><a href="javascript:ownerModInfoForm.submit();">수정</a> &nbsp;&nbsp;
			<a href="javascript:joinform.reset()">다시작성</a></td>
		</tr>
	</table>
</form>
</body>
</html>