<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	a{
		text-decoration:none;
	}

</style> 

</head>
<body>

	<%
		session.setAttribute("aa","jj");
	%>

	프로젝트 이름까지의 경로: 
	${pageContext.request.contextPath} <!-- /0903class -->
	
	<input type = "button" value="클릭" id="btn" />
	
	<a href="logout">로그아웃</a>
	
	<nav>
		<ul>
			<li><a href="login.do">로그인</a>
			<li><a href="register.do">회원가입</a>
		</ul>
	</nav>
	
	
</body>
<script src= "${pageContext.request.contextPath}/resources/js/jquery.js"></script> <!-- {request.contextPath}는 WebContent이다. -->

<script>
	//이벤트처리
	$('#btn').bind('click', function(){
		console.log("로그를 출력합니다")	
	})


	//로그아웃 버튼을 누르지 않고, 브라우저 창을 닫거나 새로 고침을 할 때 
	$(window).bind("beforeunload", function(){
		$.ajax({
			url:"logout"
		})
	})

	//스크립에 $로 시작하면 jquery를 사용하는 것이다.
	//문서의 내용을 전부 읽자마자 
	$(function(){
		alert("jquery를 사용합니다.")
	})
</script>

</html>