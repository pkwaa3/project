<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
nav ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

nav li {
  float: left;
  border-right:1px solid #bbb;
}

nav li:last-child {
  border-right: none;
}

nav li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

nav li a:hover:not(.active) {
  background-color: #111;
}

nav .active {
  background-color: #4CAF50;
}
</style>
</head>
<body>
	<nav>
	<ul>
  		<li><a class="active" href="../main.jsp">Home</a></li>
  		<li style="float:right"><a href="../index/login.jsp">로그인</a></li>
  		<li style="float:right"><a href="../index/login.jsp">회원가입</a></li>
	</ul>
	</nav>
</body>
</html>