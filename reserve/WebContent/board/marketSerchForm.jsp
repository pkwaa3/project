<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@page import="vo.PageInfo" %>
    <%@page import="vo.Board" %>
    <%@page import="java.util.*" %>
    <%@page import="java.text.SimpleDateFormat"%>
    
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
<title>Insert title here</title>
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
				<a href="boardDetail.bo?board_num=<%=searchList.get(i).getBoard_no() %>&page=<%=nowPage %>">
				<%=searchList.get(i).getBoard_subject() %>
				</a>
			</td>
			<td><%=searchList.get(i).getOwner_no() %></td>
			<td><%=searchList.get(i).getBoard_date() %></td>
			<td><%=searchList.get(i).getBoard_readcount() %></td>
		</tr>
		<%} %>
	</table>
</section>
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