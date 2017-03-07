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
  
  	<h1>更改报纸版面标题</h1>
    <form id="form1">
    	第<input type="text" name="editionnum" id="editionnum" size="1">期
    	第<input type="text" name="pagenum" id="pagenum" size="1">版
    	标题：<input type="text" name="pagetitle" id="pagetitle">
    	<input type="button" value="发布" onclick="doSubmit();">
    </form>
  </body>
</html>
<script type="text/javascript">
function doSubmit(){
		var editionnum = $("#editionnum").val();
		var pagenum = $("#pagenum").val();
		var pagetitle = $("#pagetitle").val();
		if(editionnum == ""){
			alert("请输入期号！");
		}else if(pagenum == ""){
			alert("请输入版号！");
		}else if(pagetitle == ""){
			alert("请输入相应的版号标题！");
		}else{
			$.ajax({   
	           url:'newspaperCtrl/updateNewspaperEdition',   
	           type:'post',   
			   data: {"editionnum":editionnum,"pagenum":pagenum,"pagetitle":pagetitle},//发给服务器端的数据
	           dataType:'json',//服务器传给浏览器的数据格式
	           success:function(data){   //data:服务器端返回给浏览器端的数据
			  	  //alert(data);
	              //alert(data.result);
	              if(data.result==1){
	              	alert("修改成功！");
	              }else{
	              	alert("修改失败，请核对后重新修改！");
	              }
	           },
			   error:function (XMLHttpRequest, textStatus, errorThrown) {
	        	   		alert(XMLHttpRequest);
	        	   		alert(textStatus);
	        	   		alert(errorThrown);
	           }
	       });
		}
}
</script>