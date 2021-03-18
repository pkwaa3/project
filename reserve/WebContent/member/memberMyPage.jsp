<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#wrap{
		width:1000px;
		height:800px;
		margin:0 auto;
		color:#fff;
		font-size:40px;
		text-align:center;
	}
	#header{
		width:1000px;
		height:100px;
		line-height:100px;
		background:#2e7d32;
	}
	
	#side{
		float:left;
		width:300px;
		height:600x;
		line-height:600px;
		background:#43a047;
	}
	#side .ul{
		list-style-type:none;
		margin:10px;
		padding:10px;
		overflow:hedden;
	}
	#side .li{
		border:1px solid white;
	}
	#side .li a{
		display:block;
		color:white;
		text-align:center;
		padding:10px 10px;
		text-decoration:none;
	} 
	#side .li a:hover{
		background-color:yellow;
	}
	#contents{
		float:left;
		width:700px;
		height:600px;
		line-height:600px;
		background:#4caf50;
	}
	#footer{
		float:left;
		width:1000px;
		height:100px;
		line-height:100px;
		background:#66bb6a;
	}

</style>
</head>
<jsp:include page="../head.jsp" />
<body>
	<div id="wrap">
		<div id="header">예약하는홈페이지</div>		
		<div id="side">
			<ul>
				<li>1</li>
				<li>2</li>
				<li>3</li>
				<li>4</li>
			</ul>
		</div>
		<div id="contents"></div>
		<div id="footer"></div>
	</div>
</body>
</html>