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
<style type="text/css">
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
<!-- 게시판 리스트 -->
<section id="listForm">
	<h2>
		글 목록&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="boardWriteForm.bo">게시판 글쓰기</a>
	</h2>
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
			<td><%=restList.get(i).getName() %></td>
			<td><%=restList.get(i).getLocal() %></td>
			<td><%=restList.get(i).getKind() %></td>
			
		</tr>
		<%} %>
	</table>
</section>



<% } else { %>
	<section id="emptyArea">등록된 글이 없습니다.</section>
<%} %> 	
</body>
</html>