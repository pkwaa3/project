<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
        font-family:"맑은 고딕", "고딕", "굴림";
    }
	#wrap{
		width:1000px;
		height:800px;
		margin:0 auto;
		color:#fff;
		font-size:20px;
		text-align:center;
	}
	#header{
		width:1000px;
		height:100px;
		line-height:100px;
		background:#2e7d32;
	}
	
	#aside{
		float:left;
		width:300px;
		height:600px;
		line-height:600px;
		background:#43a047;
	}
	#aside ul{
  		list-style-type: none;
	}
	#aside li {
    border-bottom:1px solid white;
    display: inline;
   	float: center;	
    font-weight:bold;
}
	#aside li:last-child {
 		 border-right: none;
	}
	#aside li a{
		display:block;
		color : white;
		text-align:center;
		padding:0 auto;
		text-decoration:none;
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
		<div id="aside">
			<ul>
				<li><a href="">내글목록</a></li>
				<li><a href="">예약내역</a></li>
				<li><a href="">찜목록</a></li>
				<li><a href="">회원정보수정</a></li>
				<li><a href="">회원탈퇴</a></li>
			</ul>
		</div>
		<div id="contents"></div>
		<div id="footer"></div>
	</div>
</body>
</html>