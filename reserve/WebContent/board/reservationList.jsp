<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="vo.Restaurant" %>
    <%@page import="java.util.*" %>
    <%@page import="java.text.SimpleDateFormat"%>
    
    <%
        	ArrayList<Restaurant> restList = (ArrayList<Restaurant>)request.getAttribute("restList");
                    	
        %>
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
		margin:auto;
		width:450px;
	}
	#tr_top {
		background:orange;
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
  			<li><a href="boardRegInfoForm.bo?owner_id=<%=session.getAttribute("owner_id") %>">메뉴 등록</a></li>
  			<li><a href="ownerRegiMarketList.own?owner_id=<%=session.getAttribute("owner_id") %>">가게 등록 리스트</a></li>
  			<li><a href="">예약 내역</a></li>
  			<li><a href="ownerDeleteForm.own?owner_id=<%=session.getAttribute("owner_id") %>">회원탈퇴</a></li>
  			
  		</ul>
  	</nav>
  </div>
  <div class="" style="background-color:#ccc;">
  	
 <section id="listForm">
 <table>
		<%
			if(restList != null ) {				
		%>	
		<tr id="tr_top">
			<td>순번</td>
			<td>가게 번호</td>
			<td>가게 이름</td>
			<td>지역</td>
			<td>메뉴 종류</td>
			
		</tr>
		<%
			for(int i=0; i<restList.size(); i++) {
		%>
		<tr>
			<td><%= i %>
			<td><%=restList.get(i).getRest_no() %></td>
			<td><a href="reservInfoOw.own?rest_no=<%=restList.get(i).getRest_no() %>"><%=restList.get(i).getName() %></a></td>
			<td><%=restList.get(i).getLocal() %></td>
			<td><%=restList.get(i).getKind() %></td>
			
		</tr>
		<%} %>
	</table>
	
</section>
	
	<% } else { %>
	<section id="emptyArea">등록된 글이 없습니다.</section>
<%} %> 	

  </div>
</div>

</body>
</html>