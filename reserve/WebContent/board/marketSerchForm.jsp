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
    		ArrayList<Menu> menuSearchList = (ArrayList<Menu>)request.getAttribute("menuSearchList");
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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Insert title here</title>
<style>
/* 카드*/
div.gallery {
  margin: 5px;
  border: 1px solid #ccc;
  float: left;
  width: 180px;
}

div.gallery:hover {
  border: 1px solid #777;
}

div.gallery img {
  width: 100%;
  height: auto;
}

div.desc {
  padding: 15px;
  text-align: center;
}

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
  <li><a class="active" href="main.com">Home</a></li>
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
<h2>CSS Template using Float</h2>
<p>In this example, we have created a header, three equal columns and a footer. On smaller screens, the columns will stack on top of each other.</p>
<p>Resize the browser window to see the responsive effect.</p>
<!-- 게시판 리스트 -->
<section id="listForm">
	<h2>
		글 목록&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="boardWriteForm.bo">게시판 글쓰기</a>
	</h2>
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
			<td>사진</td>
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
			<td><%=menuSearchList.get(i).getMenu_sys_img() %></td>
		</tr>
		<%} %>
	</table>
</section>


	<c:if test="${searchList != null }">
	
	<table>
		<tr>
			<c:forEach var="result" items="${searchList }" varStatus="status">
			<td>
				
				<!-- 
					<div class="card">
					<div class="cardImg">
						<img src="upload/${result.main_org_img }" id="mainImg" width=200px height=200px /><br>
					</div>
					<div class="cardSubject">
					 	${result.board_subject } <br>
				 	</div>
				 </div>
				  -->
				 <div class="w3-container">
  						<div class="w3-card-4" style="width:200px" "height=100px">
   							 <img src="upload/${result.main_org_img }" id="mainImg"  alt="Alps" style="width:100%">
   								 <div class="w3-container w3-center">
      								<p>${result.board_subject }</p>
   						 		</div>
 						 </div>
				</div>
				
				<div class="gallery">
  					<a target="_blank" href="upload/${result.main_org_img }">
   						 <img src="upload/${result.main_org_img }" alt="Cinque Terre" width="600" height="400">
 					 </a>
  					<div class="desc">${result.board_subject }</div>
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
	<c:if test="${searchList == null }">
		<div class="div_empty">
			검색 결과가 없습니다.
		</div>
	</c:if>





<section id="pageList">
	<%if(nowPage<=1) { %>
		[이전]&nbsp;
	<% }else { %>
		<a href="boardList.bo?page=<%=nowPage-1 %>">[이전]</a>&nbsp;
	<%} %>
	
	<%for(int a=startPage; a<=endPage; a++) {
		if(a==nowPage) {%>
			[<%=a %>]
		<%}else{ %>
			<a href="boardList.bo?page=<%=a %>">[<%=a %>]
			</a>&nbsp;
		<%} %>
	<%} %>
	<%if(nowPage>=maxPage) { %>
		[다음]
	<%}else{ %>
		<a href="boardList.bo?page=<%=nowPage+1 %>">[다음]</a>
	<%} %>	
</section>
<% } else { %>
	<section id="emptyArea">등록된 글이 없습니다.</section>
<%} %>
</body>
</html>