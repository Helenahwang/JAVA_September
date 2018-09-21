<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다양한 뷰 출력</title>
<style>
	h3:hover{ <!-- 마우스 올라갔을 때 색깔 변한다 -->
		color:blue;
	}
	span{
		margin:10px;
		border:3px Solid Green;
		border-radius:15px;
		float:left;
		width:300px;
		height:140px;
		text-align:center;
	}

</style>


</head>
<body>
	<a href="excel.xls">엑셀로 출력</a><br/>
	<a href="data.pdf">pdf로 출력</a><br/>
	<a href="jsonview.json">jsonview로 출력</a><br/>
	
	
	<a href="data.csv">CVS로 출력</a><br/>
	<a href="data.json">JSON로 출력</a><br/>
	<a href="#" id= "ajaxdata">AJAX로 JSON 가져오기</a><br/>
	<div id="disp"></div>
	
</body>

<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

<script>

<!--
$("#ajaxdata").on("click", function(){
	
})
-->
	document.getElementById("ajaxdata").addEventListener("click",function(){
		$.ajax({
			url : "data.json",
			data:{},
			dataType:"json",
			success:function(data){
				<!--for(tmp in data){alert(data[tmp].name + " : "+data[tmp].group)-->
				
				output=""
				for(tmp in data){
					output += "<span>"+"<h3>"; //<span>:공간만듬 <h3>:제목란 <p>:본문란 
					output += data[tmp].name + "</h3>";
					output += "<p>" + data[tmp].group;
					output += "</p>"+"</span>";
	
				} 
				document.getElementById("disp").innerHTML=output;
					
					
					
				
			}
		
		
		});
		
	})

	<!--$(function(){alert("jquery 설정 확인")})-->
	
</script>
</html>