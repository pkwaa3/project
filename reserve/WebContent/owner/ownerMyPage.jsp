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
</style>
</head>
<body>
<nav id="topmenu">
<ul >
  <li><a class="active" href="mainLoginOwner.com">Home</a></li>
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
		<li style="float:right"><a href="ownerMyPage.own?owner_id=<%=session.getAttribute("owner_id") %>"><%=session.getAttribute("owner_id") %>님 환영합니다.</a></li>
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
  			<li><a href="ownerModInfoForm.own?owner_id=<%=session.getAttribute("owner_id") %>">회원 정보 수정</a></li>
  			<li><a href="ownerRegiMarketForm.own?owner_id=<%=session.getAttribute("owner_id") %>">가게 정보 등록</a></li>
  			<li><a href="boardRegForm.bo?owner_id=<%=session.getAttribute("owner_id") %>">가게 등록</a></li>
  			<li><a href="ownerRegiMarketList.own?owner_id=<%=session.getAttribute("owner_id") %>">가게 등록 리스트</a></li>
  			<li><a href="">예약 내역</a></li>
  			<li><a href="ownerDeleteForm.own?owner_id=<%=session.getAttribute("owner_id") %>">회원탈퇴</a></li>
  			
  			
  		</ul>
  	</nav>
  </div>
  <div class="" style="background-color:#ccc;">
  	아이디 : <%=session.getAttribute("owner_id") %>
  	비밀번호 : <%=session.getAttribute("owner_pw") %>
  	아이디 번호 : <%=session.getAttribute("owner_no") %>
  	가게 번호 : <%=session.getAttribute("rest_no") %>
  </div>
</div>

</body>
</html>