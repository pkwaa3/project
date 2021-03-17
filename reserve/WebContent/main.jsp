<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>	
	function okseoul(f) {
		document.getElementById("where").value=f.seoul.value;
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
	function okjoongsik(f) {
		document.getElementById("menu").value=f.joongsik.value;
		}
	function okyangsik(f) {
		document.getElementById("menu").value=f.yangsik.value;
		}
</script>
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
  background: #73AD21;
  padding: 20px; 
  width: 200px;
  height: 100px;  
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
.button {
  background-color: white; 
  color: black; 
  border-radius: 10px;
  border: 2px solid #4CAF50;
  font-size:15px;
 
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

.dropdown:active  .dropdown-content {
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
  height: 300px; /* Should be removed. Only for demonstration */
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
</style>

</head>
<body>
<ul class="nav">
  <li><a class="active" href="main.jsp">Home</a></li>
  <li style="float:right"><a href="index/login.jsp">로그인</a></li>
  <li style="float:right"><a href="index/login.jsp">회원가입</a></li>
</ul>


<h2>CSS Template using Float</h2>
<p>In this example, we have created a header, three equal columns and a footer. On smaller screens, the columns will stack on top of each other.</p>
<p>Resize the browser window to see the responsive effect.</p>

<div class="header">
  <h2>Header</h2><p>
  		<form>

  		
  			
  			<div class="dropdown">
  				<span> 
  					<div id="rcorners1">지역<br><i style="font-size:50%;">어디 갈래?</i>
  					<input class="intext" type="text" name="where" id="where" size="10" readonly/>
  					</div>
  				</span>
  					<div class="dropdown-content">
  						<p><input class="button" type="button" name="seoul" id="seoul" value="서울" onclick="okseoul(this.form)"></p>
  						<p><input class="button" type="button" name="daegu" id="daegu" value="대구" onclick="okdaegu(this.form)"></p>
  						<p><input class="button" type="button" name="busan" id="busan" value="부산" onclick="okbusan(this.form)"></p>
  					</div>
  			</div>
  			<div class="dropdown">
  				<span>
  				  	<div id="rcorners1" >메뉴<br><i style="font-size:50%;">뭐 먹고 싶어?</i>
  				  	<input type="text" name="menu" id="menu" size="10" readonly/>
  				  	</div>
  				  </span>
  				  	<div class="dropdown-content">
  						<p><input type="button" name="hansik" id="hansik" value="한식" onclick="okhansik(this.form)"></p>
  						<p><input type="button" name="joongsik" id="joongsik" value="중식" onclick="okjoongsik(this.form)"></p>
  						<p><input type="button" name="yangsik" id="yangsik" value="양식" onclick="okyangsik(this.form)"></p>
  					</div>

  		</form>
  		
  
</div>

<div class="row">
  <div class="column" style="background-color:#aaa;">Column</div>
  <div class="column" style="background-color:#bbb;">Column</div>
  <div class="column" style="background-color:#ccc;">Column</div>
</div>

<div class="footer">
  <p>Footer</p>
</div>

</body>
</html>