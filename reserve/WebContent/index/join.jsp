<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>:::회원가입|야먹자:::</title>
<style>

/*목록*/
 ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

 li {
  float: left;
  border-right:1px solid #bbb;
}

 li:last-child {
  border-right: none;
}

 li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

 li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #4CAF50;
}

/*검색*/
#rcorners1 {
  border-radius: 25px;
  background: #333;
  padding: 20px; 
  width: 800px;
  height: 90px;  
  font-size:30px;
  display: inline-block;
  cursor:pointer;
}
/*인풋 */
.intext {
	border: none; 
	background-color: white; 
	text-align:center;
}
.searchInput {
  background-color: white; 
  color: black; 
  border-radius: 10px;
  border: 2px solid #333;
  font-size:15px;
  text-align:center;
  width : 300px;
  height : 50px;

}
.searchButton {
  background-color: white; 
  color: black; 
  border-radius: 10px;
  border: 2px solid #333;
  font-size:15px;
  text-align:center;
  width : 50px;
  height : 50px;
}
.button {
  background-color: white; 
  color: black; 
  border-radius: 10px;
  border: 2px solid #4CAF50;
  font-size:15px;
  text-align:center;
  
  
 
}
.button:hover {
  background-color: #4CAF50;
  color: white;
}


/*드롭다운*/
.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  border-radius: 25px;
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  padding: 12px 16px;
  z-index: 1;
}

.dropdown:hover  .dropdown-content {
  display: block;
}

.dropdown:visited  .dropdown-content {
  display: block;
}

/*본문*/

* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
.header {
  margin-top:250px;
  background-color: #ffffff;
  padding: 30px;
  text-align: center;
  font-size: 35px;
}

/* Create three equal columns that floats next to each other */
.column {
  float: left;
  width: 33.33%;
  padding: 10px;
  height: 300px; /* Should be removed. Only for demonstration */
  align:center;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}
.row a{
	text-decoration:none;
	color:black;
	align:right;
	font-size:1.5em;
}
/* Style the footer */
.footer {
  background-color: #343a40 !important;
  padding: 10px;
  width:100%;
  height:100px;
  position:fixed;
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
.column img{
	width:300px;
	height:250px;
}

/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
@media (max-width: 768px) {
  .column {
    width: 100%;
  	padding: 100px;
  	height: 300px; /* Should be removed. Only for demonstration */
  	align:center;
  	margin-top:50px;
  	margin-left:0px;
  	
  }
  
  .column img{
  	width:250px;
  	height:150px;
  }
}@media (max-width: 1460px) {
  .column {
    width: 66.66%;
  	padding: 10px;
  	height: 300px; /* Should be removed. Only for demonstration */
  	align:center;
  }
  
  .column img{
  	width:500px;
  	height:300px;
  }
}

</style>
</head>
<body>

<ul class="nav">
  <li><a class="active" href="main.com">Home <i class="glyphicon glyphicon-home"></i></a></li>
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

<div class="row">
  <div class="column" style=" margin-left:120px; margin-right:120px; margin-top:250px; text-align:center;"><br><a href="ownerJoinForm.own"><img src="img/점장.jpg" id="img"><br>점장 회원가입</a></div>
  <div class="column" style=" margin-left:120px; margin-right:120px; margin-top:250px; text-align:center;"><a href="memberJoinForm.mem"><img src="img/손님.png" id="img"><br>일반회원 회원가입</a></div>
  
</div>
<br><br><br><br><br><br><br><br><br><br><br><br>

<div class="footer">

  <p>Copyright &copy; Your Website 2020</p>
</div>
</body>
</html>