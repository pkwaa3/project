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
			<td><label for="owner_id">아이디 : </label></td>
			<td><input type="text" name="owner_id" id="owner_id" value="<%=owner.getOwner_id() %>" readonly></td>
		</tr>
		<tr>
			<td><label for="owner_pw">비밀번호 : </label></td>
			<td><input type="password" name="owner_pw" id="owner_pw" value='<%=owner.getOwner_pw()%>'/></td>
		</tr>
		<tr>
			<td><label for="owner_name">이름 : </label></td>
			<td><input type="text" name="owner_name" id="owner_name" value='<%=owner.getOwner_name()%>'/></td>
		</tr>
		<tr>
			<td><label for="owner_age">나이 : </label></td>
			<td><input type="text" name="owner_age" id="owner_age" value='<%=owner.getOwner_age()%>'/></td>
		</tr>
		<tr>
			<td><label for="owner_gender">성별 : </label></td>
			<td><input type="radio" name="owner_gender" value="남" ${member.gender eq '남' ? 'checked':''} id="gender1">남자
				<input type="radio" name="owner_gender" value="여" ${member.gender eq '여' ? 'checked':''} id="gender2">여자</td>
		</tr>
		<tr>
			<td><label for="owner_number">전화번호 : </label></td>
			<td><input type="text" name="owner_number" id="owner_number" value='<%=owner.getOwner_number()%>'/></td>
		</tr>
		<tr>
			<td><label for="owner_email">이메일 주소 : </label></td>
			<td><input type="text" name="owner_email" id="owner_email" value='<%=owner.getOwner_email()%>'/></td>
		</tr>
		<tr>
			<td colspan="2"><a href="javascript:ownerModInfoForm.submit();">수정</a> &nbsp;&nbsp;
			<a href="javascript:joinform.reset()">다시작성</a></td>
		</tr>
	</table>
</form>
</body>
</html>