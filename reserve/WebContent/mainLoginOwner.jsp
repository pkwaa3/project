<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="js/jquery.js"></script>
<script>	
	function okseoul(f) {
		document.getElementById("where").value=f.seoul.value;
		}
	function okinchoen(f) {
		document.getElementById("where").value=f.inchoen.value;
		}
	function okdaejeon(f) {
		document.getElementById("where").value=f.daejeon.value;
		}
	function okgwangju(f) {
		document.getElementById("where").value=f.gwangju.value;
		}
	function okulsan(f) {
		document.getElementById("where").value=f.ulsan.value;
		}
	function okdaegu(f) {
		document.getElementById("where").value=f.daegu.value;
		}
	function okbusan(f) {
		document.getElementById("where").value=f.busan.value;
		}
	function okhansik(f) {
		document.getElementById("menu").value=f.hansik.value;
		}
	function okilsik(f) {
		document.getElementById("menu").value=f.ilsik.value;
		}
	function okjoongsik(f) {
		document.getElementById("menu").value=f.joongsik.value;
		}
	function okyangsik(f) {
		document.getElementById("menu").value=f.yangsik.value;
		}
	function okbunsik(f) {
		document.getElementById("menu").value=f.bunsik.value;
		}
	function okjjimtang(f) {
		document.getElementById("menu").value=f.jjimtang.value;
		}
	function okcafe(f) {
		document.getElementById("menu").value=f.cafe.value;
		}
	//                      슬라이드 바
	


</script>
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
  background-color: #f1f1f1;
  padding: 30px;
  text-align: center;
  font-size: 35px;
}

/* Create three equal columns that floats next to each other */
.column {
  float: left;
  width: 33.33%;
  padding: 10px;
  height: 350px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the footer */
.footer {
  background-color: #f1f1f1;
  padding: 10px;
  text-align: center;
}

/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
@media (max-width: 600px) {
  .column {
    width: 100%;
  }
}
.title {
	text-align:center;
}
/*               슬라이드 바                            */
/*--------좌우슬라이딩---------*/ 
*{margin:0;padding:0;}
    ul,li{list-style:none;}
    .slide{height:300px;overflow:hidden;}
    .slide ul{width:calc(100% * 4);display:flex;animation:slide 15s infinite;} /* slide를 8초동안 진행하며 무한반복 함 */
    .slide li{width:calc(100% / 4);height:300px;}
    .slide li:nth-child(1){background:#ffa;}
    .slide li:nth-child(2){background:#faa;}
    .slide li:nth-child(3){background:#afa;}
    .slide li:nth-child(4){background:#aaf;}
    @keyframes slide {
      0% {margin-left:0;} /* 0 ~ 10  : 정지 */
      10% {margin-left:0;} /* 10 ~ 25 : 변이 */
      25% {margin-left:-100%;} /* 25 ~ 35 : 정지 */
      35% {margin-left:-100%;} /* 35 ~ 50 : 변이 */
      50% {margin-left:-200%;}
      60% {margin-left:-200%;}
      75% {margin-left:-300%;}
      85% {margin-left:-300%;}
      100% {margin-left:0;}


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
  <li style="float:right"><a href="login.com">로그인</a></li>
  <li style="float:right"><a href="join.com">회원가입</a></li>
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
<br><br>
<div class="title">
<h2>이름</h2>
</div>
<br><br><br>


<div class="header">
  
  	<form name="marketSerch" action="marketSearch.bo" method="post">

  		
  			<div id="rcorners1">
  				<div class="dropdown">
  					<span> 
  						<div>
  							<input class="searchInput" type="text" name="where" id="where" size="10" placeholder="지역 선택" readonly/>
  						</div>
  					</span>
  						<div class="dropdown-content">
  							<p><input class="button" type="button" name="seoul" id="seoul" value="서울" onclick="okseoul(this.form)"></p>
  							<p><input class="button" type="button" name="inchoen" id="inchoen" value="인천" onclick="okinchoen(this.form)"></p>
  							<p><input class="button" type="button" name="daejeon" id="daejeon" value="대전" onclick="okdaejeon(this.form)"></p>
  							<p><input class="button" type="button" name="gwangju" id="gwangju" value="광주" onclick="okgwangju(this.form)"></p>
  							<p><input class="button" type="button" name="daegu" id="daegu" value="대구" onclick="okdaegu(this.form)"></p>
  							<p><input class="button" type="button" name="ulsan" id="ulsan" value="울산" onclick="okulsan(this.form)"></p>
  							<p><input class="button" type="button" name="busan" id="busan" value="부산" onclick="okbusan(this.form)"></p>
  						</div>
  				</div>
  				<div class="dropdown">
  					<span>
  				  		<div>
  				  			<input class="searchInput" type="text" name="menu" id="menu" size="10" placeholder="메뉴 선택" readonly/>
  				  		</div>
  				  	</span>
  				  	<div class="dropdown-content">
  						<p><input class="button" type="button" name="hansik" id="hansik" value="한식" onclick="okhansik(this.form)"></p>
  						<p><input class="button" type="button" name="joongsik" id="joongsik" value="중식" onclick="okjoongsik(this.form)"></p>
  						<p><input class="button" type="button" name="ilsik" id="ilsik" value="일식" onclick="okilsik(this.form)"></p>
  						<p><input class="button" type="button" name="yangsik" id="yangsik" value="양식" onclick="okyangsik(this.form)"></p>
  						<p><input class="button" type="button" name="bunsik" id="bunsik" value="분식" onclick="okbunsik(this.form)"></p>
  						<p><input class="button" type="button" name="jjimtang" id="jjimtang" value="찜탕" onclick="okjjimtang(this.form)"></p>
  						<p><input class="button" type="button" name="cafe" id="cafe" value="카페" onclick="okcafe(this.form)"></p>
  						
  					</div>
  				</div>
  				
  					<div class="dropdown">
  						<button  class="searchButton" type="submit">   <i class="glyphicon glyphicon-search"></i></button>
  						
  					</div>
			</div>
  		</form>
  		
  
</div>

<div class="row">
  <div class="column" style="background-color:#aaa;">
  	<div class="slide">
    <ul>
      <li><img src="img/slider1.PNG" id="img"></li>
      <li><img src="img/slider2.PNG" id="img"></li>
      <li><img src="img/slider3.PNG" id="img"></li>
      <li><img src="img/slider4.PNG" id="img"></li>
    </ul>
  </div>
  </div>
  <div class="column" style="background-color:#bbb;">
  


  <div class="slide">
    <ul>
      <li><img src="img/slider1.PNG" id="img"></li>
      <li><img src="img/slider2.PNG" id="img"></li>
      <li><img src="img/slider3.PNG" id="img"></li>
      <li><img src="img/slider4.PNG" id="img"></li>
    </ul>
  </div>


  
  
  
  </div>
  <div class="column" style="background-color:#ccc;">
  	<div class="slide">
    <ul>
      <li><img src="img/slider1.PNG" id="img"></li>
      <li><img src="img/slider2.PNG" id="img"></li>
      <li><img src="img/slider3.PNG" id="img"></li>
      <li><img src="img/slider4.PNG" id="img"></li>
    </ul>
  </div>
  
  
  </div>
  <br><br><br><br>
</div>

<div class="footer">

  <p>Footer</p>
</div>

</body>
</html>