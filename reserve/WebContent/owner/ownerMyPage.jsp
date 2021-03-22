<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/*탑 목록*/
#topmenu {

}
#topmenu ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

#topmenu li {
  float: left;
  border-right:1px solid #bbb;
}

#topmenu li:last-child {
  border-right: none;
}

#topmenu li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

#topmenu li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #4CAF50;
}

/*탑 목록*/
#contentList {

}
#contentList ul {
	background-color: #333;
}
#contentList ul li {

}
#contentList li a {
	display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/*헤더*/
.header {
  background-color: #f1f1f1;
  padding: 30px;
  text-align: center;
  font-size: 35px;
}
/*본문 목록*/
.row:after {
  content: "";
  display: table;
  clear: both;
}
.column {
  float: left;
  width: 20%;
  padding: 10px;
  height: 500px; /* Should be removed. Only for demonstration */
}
</style>
</head>
<body>

아이디(세션) : <%= session.getAttribute("owner_id") %>
비밀번호(세션) : <%= session.getAttribute("owner_pw") %>
레스토랑 번호(세션) :<%=session.getAttribute("owner_no") %>


<table>
	<tr>
		<td><a href="ownerModInfoForm.own?id=<%=request.getParameter("owner_id") %>">회원 정보 수정</a></td>
	</tr>
	<tr>
		<td><a href="ownerRegiMarketForm.own?id=<%=request.getParameter("owner_id") %>">가게 정보 등록</a></td>
	</tr>
	<tr>
		<td><a href="ownerLogout.own?id=<%=request.getParameter("owner_id") %>">로그아웃</a></td>
	</tr>
	<tr>
		<td><a href="ownerDeleteForm.own?owner_id=<%=request.getParameter("owner_id") %>">회원탈퇴</a></td>
	</tr>
</table>

<nav id="topmenu">
<ul >
  <li><a class="active" href="main.com">Home</a></li>
<%
	request.setCharacterEncoding("utf-8");
	if(session.getAttribute("owner_id") == null){
%>
  <li style="float:right"><a href="index/login.jsp">로그인</a></li>
  <li style="float:right"><a href="index/login.jsp">회원가입</a></li>
</ul>
<%
	} else{
%>
		<li style="float:right"><a href="ownerMyPage.own?owner_id=<%=request.getParameter("owner_id") %>"><%=request.getParameter("owner_id") %>님 환영합니다.</a></li>
		<li style="float:right"><a href="ownerLogout.own">로그아웃</a></li>
		</ul>
<%
	}
%>
</nav>

<div class="header">
	<h2>마이 페이지</h2><p>
</div>
<div class="row">
  <div class="column" style="background-color:#aaa;">
  	<nav id="contentList">
  		<ul>
  			<li>d</li>
  			<li>d</li>
  		</ul>
  	</nav>
  </div>
  <div class="" style="background-color:#ccc;">Column</div>
</div>

</body>
</html>