<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SHOW MESSAGE</title>
</head>
<body>
	<h2>show Message!</h2>
	设备编号:${device.deviceNo}</br>
	设备名字:${device.deviceName} </br>
	物理地址:${device.rowPointer}</br>
	设备类型:${device.deviceType}</br>
	设备创建时间:${device.createDateStr}</br>
	<hr style=" height:2px;border:none;border-top:2px dotted #185598;"/>
	设备列表:</br>
	  <c:forEach var="obj" items="${devices}">
	  	${obj.serialNo}&nbsp;&nbsp;
		${obj.deviceNo}&nbsp;&nbsp;
		${obj.deviceName}&nbsp;&nbsp;
		${obj.deviceType}&nbsp;&nbsp;
		${obj.deviceCataegory}&nbsp;&nbsp;
		${obj.deviceNature}&nbsp;&nbsp;
		${obj.specNo}&nbsp;&nbsp;
		${obj.deviceStatus}&nbsp;&nbsp;
		${obj.rowPointer}&nbsp;&nbsp;
		${obj.createUser}&nbsp;&nbsp;
		${obj.createDateStr}</br>
	  </c:forEach>
	  
</body>
</html>
