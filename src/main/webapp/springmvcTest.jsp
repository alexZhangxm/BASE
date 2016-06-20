<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="./js/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(function(){
	$("#rowId").click(function(){
		var rowPointer=$("#rowPointer").val();
		  alert(rowPointer);
	});
	//已用on代替live,delegate实现动态绑定
	$("#box").on("click",".button",function(){
		alert("test");
	});
});
</script>

<title>欢迎</title>
</head>
<body>
	<h2>Hello springMVC!</h2>
	<form action="login.htm">
		用户登录账号：<input name="userId" type="text"/>
		设备序列号：<input name="serialNo" type="text"/>
		设备名称：<input name="deviceName" type="text"/>
		<input type="submit">
	</form>
   <hr style=" height:2px;border:none;border-top:2px dotted #185598;"/>
       物理地址:<input id="rowPointer" type="text"/> 
         <input type="button" value="查询" id="rowId"></br>
       <!-- <button type="button" id="rowId">查询</button> -->
	<span>当前IP：<%=request.getRemoteAddr() %></span>
	<div id="box">
		<input type="button" class="button" value="按钮"/>
	</div>
</body>
</html>
