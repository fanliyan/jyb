<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="favicon.ico"/>
  </head>
  
  <body>
    <form action="newspaperCtrl/toInsertNewspaperEdition" method="get">
    	<input type="submit" value="跳转到上传版面的部分">
    </form>
    
    <form action="newspaperCtrl/toUploadNewspaperPart" method="post">
    	第<input type="text" name="editionnum" size="1">期
    	第<input type="text" name="pagenum" size="1">版
    	<input type="submit" value="跳转到上传版面板块文章的部分">
    </form>
    
    <form action="newspaperCtrl/toNewspaper" method="get">
    	<input type="submit" value="跳转到报纸的部分">
    </form>
    
    <form action="newspaperCtrl/showNewspaper" method="get">
    	<input type="submit" value="跳转到全部报纸的部分">
    </form>
  </body>
</html>