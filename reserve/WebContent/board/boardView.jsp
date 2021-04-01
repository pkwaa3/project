<%@page import="vo.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	
	Board board = (Board)request.getAttribute("board");
	ArrayList<Menu> list = (ArrayList<Menu>)request.getAttribute("list");
	String nowPage=(String)request.getAttribute("page");
	if(nowPage==null) nowPage="1";
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#articleForm{
	width:500px;
	height:500px;
	border:1px solid red;
	margin:auto;
}
h2{
	text-align:center;
}
#basicInfoArea{
	height:40px;
	text-align:center;
}
#articleContentArea{
	background:;
	margin-top:20px;
	height:350px;
	text-align:center;
	overflow:auto;
}
#commandList{
	margin:auto;
	width:500px;
	text-align:center;
}
</style>
</head>
<body>

<!-- 게시판 수정 -->
	<section id="articleForm">
	<h2>글 내용 상세보기</h2>
		<section id="basicInfoArea">
			제목 : <%=board.getBoard_subject() %>
			<img src="upload/<%=board.getMain_org_img() %>" ><%=board.getMain_org_img() %>

<%
	for(int i=0; i<list.size(); i++){
%>
		<img src="upload/<%=list.get(i).getMenu_sys_img() %>"/>
		이름 : <%=list.get(i).getMenu_name() %>가격 : <%=list.get(i).getMenu_price() %>
<%		
	}
%>
	</section>
	<section id="articleContentArea">
			<br><br><br><br><br><br><%=board.getBoard_content() %>
		</section>	
	</section>
	<section id="commandList">
	<a href="boardList.bo?page=<%=nowPage %>">[목록]</a>
	&nbsp;&nbsp;
	
	</section>
</body>
</html>