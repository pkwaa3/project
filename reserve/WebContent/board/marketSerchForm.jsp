<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@page import="vo.PageInfo" %>
    <%@page import="vo.Board" %>
    <%@page import="vo.Menu" %>
    <%@page import="java.util.*" %>
    <%@page import="java.text.SimpleDateFormat"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
    <%
        	ArrayList<Board> searchList = (ArrayList<Board>)request.getAttribute("searchList");
    	
                    	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
                    	int listCount = pageInfo.getList_count();
                    	int nowPage = pageInfo.getPage();
                    	int maxPage = pageInfo.getMax_page();
                    	int startPage = pageInfo.getStart_page();
                    	int endPage = pageInfo.getEnd_page();
        %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>:::가게목록|야먹자:::</title>
<style>
/* 카드*/
div.polaroid {
  width: 250px;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  text-align: center;
  margin:auto;
}

div.container {
  padding: 10px;
}


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
  background: #73AD21;
  padding: 20px; 
  width: 200px;
  height: 100px;  
  font-size:30px;
  display: inline-block;
  cursor:pointer;
}
#rcorners2 {
  border-radius: 10px;
  background: #73AD21;
  padding: 5px; 
  width: 50px;
  height: 30px;  
  font-size:15px;
  display: inline-block;
  cursor:pointer;
  text-align:center;
  text-decoration: none;
  margin:20px;
}
#rcorners2 a:link, a:visited {

  color: white;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}
.box {
	width: 700px;
    height: 70px;
	text-align:center;
	margin:0 auto;
	border: 2px solid black;
	display: inline-block;
	border-radius: 25px;
	 
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

.dropdown:hover  .dropdown-content {
  display: block;
}

.dropdown:visited  .dropdown-content {
  display: block;
}
/* 페이지 */
#pageList {
		margin:auto;
		width:500px;
		text-align:center;
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
<p>
	<div style="text-align:center">
	<div class="box">

		<div id="rcorners2"><a href="marketSearch1.bo?where=서울&menu=<%=request.getAttribute("kind") %>">서울</a></div>
		<div id="rcorners2"><a href="marketSearch1.bo?where=인천&menu=<%=request.getAttribute("kind") %>">인천</a></div>
		<div id="rcorners2"><a href="marketSearch1.bo?where=대전&menu=<%=request.getAttribute("kind") %>">대전</a></div>
		<div id="rcorners2"><a href="marketSearch1.bo?where=광주&menu=<%=request.getAttribute("kind") %>">광주</a></div>
  		<div id="rcorners2"><a href="marketSearch1.bo?where=대구&menu=<%=request.getAttribute("kind") %>">대구</a></div>
  		<div id="rcorners2"><a href="marketSearch1.bo?where=울산&menu=<%=request.getAttribute("kind") %>">울산</a></div>
  		<div id="rcorners2"><a href="marketSearch1.bo?where=부산&menu=<%=request.getAttribute("kind") %>">부산</a></div>
  	</div>
  	<div class="box">

		<div id="rcorners2"><a href="marketSearch1.bo?where=<%=request.getAttribute("local") %>&menu=한식">한식</a></div>
		<div id="rcorners2"><a href="marketSearch1.bo?where=<%=request.getAttribute("local") %>&menu=중식">중식</a></div>
  		<div id="rcorners2"><a href="marketSearch1.bo?where=<%=request.getAttribute("local") %>&menu=양식">양식</a></div>
  		<div id="rcorners2"><a href="marketSearch1.bo?where=<%=request.getAttribute("local") %>&menu=양식">일식</a></div>
  		<div id="rcorners2"><a href="marketSearch1.bo?where=<%=request.getAttribute("local") %>&menu=분식">분식</a></div>
  		<div id="rcorners2"><a href="marketSearch1.bo?where=<%=request.getAttribute("local") %>&menu=한식">찜탕</a></div>
  		<div id="rcorners2"><a href="marketSearch1.bo?where=<%=request.getAttribute("local") %>&menu=카페디저트">카페</a></div>
  	</div>
  	</div>
  		
 <p>
<!-- 게시판 리스트 -->

<div style="text-align:center">
	<h2>
	<br><br>
		<%=request.getAttribute("local") %>&nbsp;&nbsp;
		<%=request.getAttribute("kind") %>&nbsp;&nbsp;맛집 정보입니다.
	</h2>
	<br><br>
</div>
	<!-- 
	<section id="listForm">
	<table>
		<%
			if(searchList != null && listCount > 0) {				
		%>	
		<tr id="tr_top">
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>날짜</td>
			<td>조회수</td>
			
		</tr>
		<%
			for(int i=0; i<searchList.size(); i++) {
		%>
		<tr>
			<td><%=searchList.get(i).getBoard_no() %></td>
			<td>
				<%if(searchList.get(i).getBoard_re_lev() != 0) {%>
				<%for(int a=0; a<=searchList.get(i).getBoard_re_lev()*2; a++) { %>
				&nbsp;
				<%} %> ▶
				<% } else{ %> ▶ <% } %>
				<a href="boardView.bo?board_no=<%=searchList.get(i).getBoard_no() %>&page=<%=nowPage %>">
				<%=searchList.get(i).getBoard_subject() %>
				</a>
			</td>
			<td><%=searchList.get(i).getOwner_no() %></td>
			<td><%=searchList.get(i).getBoard_date() %></td>
			<td><%=searchList.get(i).getBoard_readcount() %></td>
			<td><img src="upload/<%=searchList.get(i).getMain_org_img() %>" width=50px height=50px> </td>
			
		</tr>
		<%} %>
	</table>
	
</section>
 -->
	<div style="border:1px solid black; margin:auto; width:1400px; display:block;">
	<c:if test="${searchList != null }">
	
	<table>
		<tr>
			<c:forEach var="result" items="${searchList }" varStatus="status">
			<td>
	
				 
 				
 				<div class="polaroid" style="width:300px; margin:20px;">
 					 <a  href="boardView.bo?board_no=${result.board_no }&page=<%=nowPage %>">
  						<img src="upload/${result.main_org_img }" id="mainImg" alt="mainImg" style="width:300px; height:200px;">
  					</a>
				  	<div class="container">
    						<p>${result.board_subject }</p>
  					</div>
				</div>
				 
			</td>
			<c:if test="${((status.index+1) mod 4) == 0 }">
		</tr>
		<tr>
			</c:if>
			</c:forEach>
		</tr>
	</table>
	</c:if>

	<c:if test="${searchList eq null }">
		<div class="div_empty">
			검색 결과가 없습니다.
		</div>
	</c:if>
	</div>
<p>



<section id="pageList">
	<%if(nowPage<=1) { %>
		[이전]&nbsp;
	<% }else { %>
		<a style="color:black; text-decoration:none;" href="marketSearch.bo?page=<%=nowPage-1 %>&where=<%=request.getAttribute("local") %>&menu=<%=request.getAttribute("kind") %>">[이전]</a>&nbsp;
	<%} %>
	
	<%for(int a=startPage; a<=endPage; a++) {
		if(a==nowPage) {%>
			[<%=a %>]
		<%}else{ %>
			<a style="color:black; text-decoration:none;" href="marketSearch.bo?page=<%=a %>&where=<%=request.getAttribute("local") %>&menu=<%=request.getAttribute("kind") %>">[<%=a %>]
			</a>&nbsp;
		<%} %>
	<%} %>
	<%if(nowPage>=maxPage) { %>
		[다음]
	<%}else{ %>
		<a style="color:black; text-decoration:none;" href="marketSearch.bo?page=<%=nowPage+1 %>&where=<%=request.getAttribute("local") %>&menu=<%=request.getAttribute("kind") %>">[다음]</a>
	<%} %>	
</section>
<% } else { %>
	<section id="emptyArea">등록된 글이 없습니다.</section>
<%} %>

</body>
</html>