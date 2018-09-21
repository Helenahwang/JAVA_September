<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<form>
		<div id="msg"></div>
		아이디:<input type="text" id="id"/><br/>
		비밀번호:<input type="password" id="pw"/><br/>
	</form>
	
</body>
<script src="resources/js/jquery.js"></script>
<script>
var ids=document.getElementById("id");
var msg=document.getElementById("msg");
ids.addEventListener("blur", function(){
	$.ajax({
		url:"idcheck",
		data:{"id":ids.value},
		dataType:"json",
		success:function(data){
			if(data.result == "true"){
				msg.innerHTML = "사용 가능한 아이디입니다."
				msg.style.color = "green";
				
			}else{
				msg.innerHTML = "사용 불가능한 아이디입니다."
				msg.style.color = "red";
			}
			
		}
	});
});

</script>


</html>
