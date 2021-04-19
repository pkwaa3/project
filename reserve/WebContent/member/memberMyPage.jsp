<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:::회원마이페이지|야먹자:::</title>
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
  height: 500px; /* Should be removed. Only for demonstration */
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
  <li><a class="active" href="main.com?id=${id }">Home</a></li>
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
		<li style="float:right"><a href="memberMyPage.mem?id=<%=session.getAttribute("id") %>"><%=session.getAttribute("id") %>님 환영합니다.</a></li>
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
  <div style="background-color:#ccc; height:500px; text-align:center; ">
   <h1 style="align:center; text-align:center; padding:200px;">${id }님의 마이페이지 입니다.</h1>
   </div>
</div>
<div class="footer">

  <p>Copyright &copy; Your Website 2020</p>
</div>
</body>
</html>