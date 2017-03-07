<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加实习生信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <form action="" method="post">
       	    姓名：<input type="text" name="name"/><br/>
       	   专业：<input type="text" name="major"/><br/>
       	    实习单位：<input type="text" name="company"/><br/>
       	    实习地点：<input type="text" name="city"/><br/>    	 
       	     照片：<input type="file" name="photo"/><br/>
       	  <input type="submit" value="提交"/>
     </form>
  </body>
</html>
