
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="copyright" content="@copy; KYUNGIL UNIVERSITY LIBRARY.">
<meta
	content="initial-scale=1, maximum-scale=1.0, minimum-scale=1.0, width=device-width, user-scalable=no"
	name="viewport">
<meta name="format-detection" content="telephone=no">
<!--아이폰 전화번호 스타일 초기화-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>BookDrive</title>
<!-- 홈페이지 이름 -->
<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="bdstyle/style/ko/standard/common.css">
<link rel="stylesheet" href="bdstyle/style/ko/thema/pc/main.css">
<link rel="stylesheet" href="bdstyle/style/ko/thema/tablet/main.css"
	media="screen and (min-width:768px) and (max-width:1024px)">
<link rel="stylesheet" href="bdstyle/style/ko/thema/mobile/main.css"
	media="screen and (max-width:767px)">

<!-- SCRIPT -->
<script type="text/javascript">
	var imgPath = 'bdstyle/image/';
</script>
<script type="text/javascript" src="bdstyle/script/jquery-1.8.3.min.js"></script>
<script type="text/javascript"
	src="bdstyle/script/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="bdstyle/script/main.js"></script>
<script type="text/javascript" src="bdstyle/js/common/cookie.js"
	charset="utf-8"></script>
<style>
.search {
	background-image: url(bdstyle/image/search.jpg);
	max-width:100%;height:1080px;
	background-size: cover;

}

.ikc-search-wrap {
	position: relative;
	max-width: 870px;
	padding: 25px;
	margin: 0 auto 0;
	background-color: rgba(255, 255, 255, .6);
	
	
	
}

.ikc-search-wrap .ikc-search form {
	position: relative;
	width: 100%;
	height: 66px;
	background-color: #fff;
	box-shadow: 0 3px 8px 0 rgba(0, 0, 0, .2)
}

.ikc-search-wrap .ikc-search form span {
	width: 100%;
	border: none
}

.ikc-search-wrap .ikc-search form input {
	height: 66px;
	padding: 0;
	text-indent: 25px;
	border: 3px solid #ddccac;
	border-radius: 0;
	box-sizing: border-box;
	color: #292a2c;
	font-weight: 200;
}

.ikc-search-wrap .ikc-search form input::-webkit-input-placeholder {
	color: #86868a
}

.ikc-search-wrap .ikc-search form input:-ms-input-placeholder {
	color: #86868a
}

.ikc-search-wrap .ikc-search form input::-moz-placeholder {
	color: #86868a
}

.ikc-search-wrap .ikc-search form input:-moz-placeholder {
	color: #86868a
}

.ikc-search-wrap .ikc-search form input[type=text]::-ms-clear {
	display: none
}

.ikc-search-wrap .ikc-search form .searchBtn {
	position: absolute;
	top: 0;
	right: 0;
	width: 0;
	height: 66px;
	padding: 0;
	margin: 0;
	padding: 0 20px 0 45px;
	background: url(bdstyle/image/ko/solution/common/ico/searchBtnBg.png)
		no-repeat 20px 50% #ddccac;
	border: 1px solid #ddccac;
	color: #fff;
}
#divContents {
	width: 100%;
	padding: 0;
}
</style>


<!-- divHeader -->

</head>
<body>
	<div id="divAccessibility">
		<ul>
			<li><a href="https://cham.kiu.ac.kr/#divTopMenu">메뉴 바로가기</a></li>
			<li><a href="https://cham.kiu.ac.kr/#divContents">본문
					바로가기(skip to content)</a></li>
			<li><a href="https://cham.kiu.ac.kr/#divSearch">검색 바로가기</a></li>
			<li><a href="https://cham.kiu.ac.kr/#divFooter">도서관정보 바로가기</a></li>
		</ul>
	</div>
	<div id="divWrapper">
		

<style>
#divTopMenu>ul>li>a {
	font-weight: 200;
}

#divGlobalMenu>div>ul li.login a {
	font-weight: 200;
}

#divGlobalMenu>div>ul li a {
	font-weight: 200;
}
</style>
<!-- menu_top START -->
<div id="divHeader">
	<div id="divGlobalMenu">
		<div>
			<ul>
				<li class="login">
					<!-- 세션에 로그인된 아이디가 있으면 로그아웃, 없으면 로그인 --> 
						
							<a href="loginForm.log" title="로그인">로그인</a>
						
						 </li>

				<li><a href="joinForm.mem" title="회원가입 ">회원가입</a></li>
			</ul>
		</div>
	</div>
	<!-- //Global Menu -->
	<!-- header -->
	<div class="header">
		<h1 class="logo">
			<a href="template_main.jsp" title="Book-Drive"><img
				src="bdstyle/image/mainlogo.png" height="45px"></a>
		</h1>
		<div id="divTopMenu">
			<h2 class="skip">주메뉴</h2>
			<ul>
				<li class=""><a href="bookSearch.bk" title="소장자료검색">소장자료검색</a>
				</li>

				<li class=""><a href="bookDriveMain.bk" title="book Drive">Book
						Drive</a></li>

				<li class=""><a href="javascript:return false;" title="개인서비스">개인서비스</a>
					<div>
						<ul>
							<li><a
								href="myRentalList.mem?id=&index="
								title="대출내역 ">대출/예약내역</a></li>
							<li><a
								href="bookCartList.bk?index=&page=&search=&value="
								title="도서보관함 ">도서 보관함</a></li>
							<li><a href="qnaBoard.bo?index="
								title="나의 문의사항">나의 문의사항</a></li>
							<li><a href="wishBoard.bo?index="
								title="도서이용신청">도서이용신청</a></li>
							<li class="last"><a
								href="memInfo.mem?id=" title="개인정보 관리">개인정보
									관리</a></li>
						</ul>
					</div></li>
				<li class=""><a href="javascript:return false;" title="게시판">게시판</a>
					<div>
						<ul>
							<li><a href="freeBoard.bo" title="자유게시판">자유게시판</a></li>
							<li class="last"><a href="noticeBoard.bo" title="공지사항">공지사항</a></li>
						</ul>
					</div></li>
				<li><a href="javascript:return false;" title="Information">Information</a>
					<div>
						<ul>
							<li><a href="about.mem" title="About">About</a></li>
							<li><a href="loanInfo.mem" title="이용안내">이용안내</a></li>
							<li><a href="service.mem" title="도서관서비스">도서관서비스</a></li>
							<li class="last"><a href="note.mem" title="이용시 유의사항">이용시 유의사항</a></li>
						</ul>
					</div></li>
			</ul>
		</div>
		<a href="javascript:void();" class="wholeMenuOpen" title="전체메뉴"><img
			src="bdstyle/image/ko/local/wholeMenuOpen.png" alt="전체메뉴"></a>
		<!-- //Top Menu -->
		<!-- Whole Menu -->
		<div class="wholeMenu">
			<h2 class="skip">전체메뉴보기</h2>
			<ul>
				<li><h3>
						<a href="javascript:return false;" title="소장자료검색">소장자료검색</a>
					</h3>
					<ul>
						<li><a href="bookSearch.bk" title="소장자료검색">소장자료검색</a></li>
					</ul></li>
				<li><h3>
						<a href="javascript:return false;" title="Book Drive">Book Drive</a>
					</h3>
					<ul>
						<li><a href="bookDriveMain.bk" title="Book Drive">Book Drive</a></li>
					</ul></li>
				<li><h3>
						<a href="javascript:return false;" title="개인서비스">개인서비스</a>
					</h3>
					<ul>
						<li><a
							href="myRentalList.mem?id=&index="
							title="대출/예약내역">대출/예약내역</a></li>
						<li><a
							href="bookCartList.bk?index=&page=&search=&value="
							title="도서보관함 ">도서 보관함</a></li>
						<li><a href="qnaBoard.bo?index="
							title="내문의사항">내문의사항</a></li>
						<li><a href="wishBoard.bo?index="
							title="도서이용신청">도서이용신청</a></li>
						<li class="last"><a
							href="memInfo.mem?id=" title="개인정보 관리">개인정보
								관리</a></li>
					</ul></li>
				<li><h3>
						<a href="javascript:return false;" title="게시판">게시판</a>
					</h3>
					<ul>
						<li><a href="freeBoard.bo" title="자유게시판">자유게시판</a></li>
						<li class="last"><a href="noticeBoard.bo" title="공지사항">공지사항</a></li>
					</ul></li>
				<li class="last"><h3>
						<a href="javascript:return false;" title="Information">Information</a>
					</h3>
					<ul>
						<li><a href="about.mem"
							title="About">About</a></li>
						<li><a href="loanInfo.mem"
							title="이용안내">이용안내</a></li>
						<li><a href="service.mem"
							title="도서관서비스">도서관서비스</a></li>
						<li><a href="note.mem"
							title="이용시 유의사항">이용시 유의사항</a></li>
					</ul></li>
			</ul>
			<a href="javascript:void();" class="wholeMenuClose"
				title="전체메뉴 닫기"><img
				src="bdstyle/image/ko/local/wholeMenuClose.gif" alt="전체메뉴 닫기"></a>
		</div>
	</div>
</div>
<!-- menu_top END -->
		<hr>
		<div id="divContentsW">
			<div id="divContents">

				<div class="search">
					<br> <br> <br> <br> <br> <br>
					<div class="ikc-search-wrap">
						<div class="ikc-search">
							<form name="searchForm" ng-submit="search()"
								class="ng-pristine ng-valid" action="bookSearchPro.bk">
									<input type="hidden" name="index" value="">
								<span tabindex="-1" role="presentation"
									class="k-widget k-autocomplete k-header ikc-search-keyword ng-pristine ng-untouched ng-valid k-state-default"
									style=""><input ik-auto-complete="" name="value"
									class="ikc-search-keyword ng-pristine ng-untouched ng-valid k-input ng-empty"
									placeholder="소장자료를 한번에 검색합니다." id="keyword" ng-model="keyword"
									data-role="autocomplete" type="text" autocomplete="off"
									role="textbox" aria-haspopup="true" aria-disabled="false"
									aria-readonly="false" aria-owns="keyword_listbox"
									aria-autocomplete="list" style="width: 100%;"><span
									class="k-icon k-loading" style="display: none"></span></span>
								<button type="submit" class="searchBtn"></button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

		<hr>
		
<!-- menu_bottom START -->
<style>

</style>
<div id="divFooter">
	<div class="footer">
		<p class="copyright">ⓒ2020 Book-Drive. All rights reserved.</p>
		<p class="copyrightM">ⓒ2020 Book-Drive. All rights reserved.</p>
	</div>
</div>
<!-- menu_bottom END -->
	</div>
</body>
</html>