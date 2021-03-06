<%@page import="vo.Reservation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="vo.Restaurant" %>
    <%@page import="java.util.*" %>
    <%@page import="java.text.SimpleDateFormat"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
 ArrayList<Reservation> list = (ArrayList<Reservation>)request.getAttribute("list"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:::회원예약정보|야먹자:::</title>
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

/*콘텐트 목록*/
#contentList {

}
#contentList ul {
	background-color: #333;
	margin: 0;
 	 padding: 0;
  	overflow: hidden;
  	
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
#contentList li a:hover:not(.active) {
  background-color: #111;
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
  height: 400px; /* Should be removed. Only for demonstration */
}


/* 콘텐츠*/
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}

/* Full-width input fields */
input[type=text], input[type=password]{
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
  padding: 14px 20px;
  background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
  pad	;
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 30%; /* Could be more or less, depending on screen size */
  padding:5px;
}

/* 리스트 스타일*/
#registForm {
		width:500px;
		height:600px;
		border:1px solid red;
		margin:auto;
	}
	h2 {
		text-align:center;
	}
	table {
  border-collapse: collapse;
  width: 1200px;
  margin:auto; 
}

td {
  text-align: center;
  padding: 8px;
}
th {
  text-align: center;
  padding: 8px;
}
td a{
	text-decoration:none;
}
tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #4CAF50;
  color: white;
}
	#tr_top {
		background:#4CAF50;
		text-align:center;
	}
	#pageList {
		margin:auto;
		width:500px;
		text-align:center;
	}
	#emptyArea {
		margin:auto;
		width:500px;
		text-align:center;
	}
	
	.review {
	text-align:center;
	margin:auto;
	
}
.footer {
  background-color: #343a40 !important;
  padding: 10px;
  width:100%;
  height:30px;
  
  bottom:0;
  align:center;
  padding-top:3rem;
  padding-bottom:3rem;
}
.footer p{	
	text-align:center;
	margin:0;
	color:#fff;
	align:center;
	size:1.5em;
}
</style>
</head>
<body>

<nav id="topmenu">
<ul >
  <li><a class="active" href="main.com">Home</a></li>
<%
	request.setCharacterEncoding("utf-8");
	if(session.getAttribute("id") == null){
%>
   <li style="float:right"><a href="login.com">로그인</a></li>
  <li style="float:right"><a href="join.com">회원가입</a></li>
</ul>
<%
	} else{
%>
		<li style="float:right"><a href="memberMyPage.mem"><%=session.getAttribute("id") %>님 환영합니다.</a></li>
		<li style="float:right"><a href="memberLogout.mem">로그아웃</a></li>
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
  			<li><a href="memberModInfoForm.mem?id=<%=session.getAttribute("id") %>">회원 정보 수정</a></li>
			<li><a href="reservInfo.mem?member_id=${id }">예약 내역</a></li>
			<li><a href="cartList.bo?member_id=${id }">찜 목록</a></li>
  			<li><a href="memberDeleteForm.mem?member_id=<%=session.getAttribute("id") %>">회원탈퇴</a></li>
  			
  		</ul>
  	</nav>
  </div>
  <div class="" style="background-color:#ccc;">
  	<div style="background-color:#fefefe; width:50%; border: 1px solid #888;margin: 5% auto 15% auto;padding:5px;">
 <section id="listForm">
  <h1>예약내역</h1>
  <label for="id"><b>최근 10개 까지만 조회됩니다.</b></label>
 <table style=" width:100%;">
		<c:if test="${list ne null }">
		<tr id="tr_top">
			<th>예약번호</th>
			<th>가게이름</th>
			<th>예약날짜</th>
			<th>예약시간</th>
			<th>인원수</th>
			<th></th>
			
		</tr>
<c:forEach var="list" items="${list }" begin="0" end="9">	
		<tr>
			<td>${list.reserv_no }</td>
			<td>${list.restName }</td>
			<td>${list.date }</td>
			<td>${list.time }</td>
			<td>${list.head }</td>
			<td><a href="reservDelete.bo?reserv_no=${list.reserv_no }">예약취소</a></td>
			
		</tr>
		</c:forEach>
	</table>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	
</section>
</div>
</c:if>
<c:if test="${list eq null }">
찜 목록이 비어있습니다.
</c:if>	

  </div>
</div>
<div class="footer">
  <p>Copyright &copy; Your Website 2020</p>
</div>
</body>
</html>