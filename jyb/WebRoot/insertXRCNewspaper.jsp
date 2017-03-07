<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'creatnewspaper.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
  </head>
  
  <body>
  
  	<h1>发布新一期的报纸</h1>
	<font color='red'>${msg}</font>
    <form id="form1">
    	第<input type="text" name="editionnum" id="editionnum" size="1">期
    	<input type="button" value="发布" onclick="doSubmit()">
    </form>
  </body>
</html>
<script>
function doSubmit(){
	var editionnum = $("#editionnum").val();
	if(editionnum!=null){
		var x= document.getElementById("form1");
    	x.method="post";
    	x.action="xrcNewspaperCtrl/insertNewspaper";
    	x.submit();
	}
}
</script>