<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传xml文件</title>
</head>
<body>
	<h1>上传成功!!</h1>
	<a href="/index.jsp">返回</a>
	 <add-item item-descriptor="richMedia" id="300001">
	<c:forEach items= "${lists}" var="addItem">
		<add-item item-descriptor="${addItem.itemDescriptor}" id="${addItem.id }">
	</c:forEach>
</body>
</html>