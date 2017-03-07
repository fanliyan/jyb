<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="favicon.ico"/>

  </head>
  
  <body>
    <h3>查询结果</h3>
    <form id="turnPagefm" action="querySearch">
       <input type="hidden" name="title" value="${title }">
       <c:forEach items="${list }" varStatus="status" var="items">
            ${items.category }&nbsp;&nbsp;&nbsp;<a href="showOneQueryResult?id=${items.id }&tablename=${items.tablename}">${items.title }</a>&nbsp;&nbsp;&nbsp;${items.time }<br/><br/>
       </c:forEach>      
     	<%@include file="common/turnPage.jsp"%>
     </form>
  </body>
</html>
