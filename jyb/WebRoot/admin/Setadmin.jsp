<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>文章管理页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	
	
		
	function searchBlog() {
		$("#dg").datagrid("load", {
			"name":$("#s_title").val()
		});
	}
	
	function deleteBlog() {
		var selectedRows = $("#dg").datagrid("getSelections");
		if(selectedRows.length == 0) {
			$.messager.alert("系统提示", "请选择要删除的数据");
			return;
		}
		var idsStr = [];
		for(var i = 0; i < selectedRows.length; i++) {
			idsStr.push(selectedRows[i].aid);
		}
		var aids = idsStr.join(","); //1,2,3,4	
		$.messager.confirm("系统提示", "<font color=red>您确定要删除选中的"+selectedRows.length+"条数据么？</font>", function(r) {
			if(r) {
				$.post("${pageContext.request.contextPath}/admin/batchDeleteadmin",
						{aids: aids}, function(result){
							if(result.deleteResult) {
								$.messager.alert("系统提示", "数据删除成功！");
								$("#dg").datagrid("reload");
							} else {
								$.messager.alert("系统提示", "数据删除失败！");
							}
						}, "json");
			}
		});
	}
	
	function openBlogModifyTab() {
		var selectedRows = $("#dg").datagrid("getSelections");
		if(selectedRows.length == 0) {
			$.messager.alert("系统提示", "请选择要设置的管理员");
			return;
		}
		var idsStr = [];
		for(var i = 0; i < selectedRows.length; i++) {
			idsStr.push(selectedRows[i].aid);
		}
		var aids = idsStr.join(","); //1,2,3,4	
		$.messager.confirm("系统提示", "<font color=red>您确定要设置选中的"+selectedRows.length+"管理员么？</font>", function(r) {
			if(r) {
				$.post("${pageContext.request.contextPath}/admin/setadminaid",
						{aids: aids}, function(result){
							if(result.deleteResult) {
								$.messager.alert("系统提示", "设置管理员成功！");
								$("#dg").datagrid("reload");
							} else {
								$.messager.alert("系统提示", "管理员设置失败！");
							}
						}, "json");
			}
		});
	}
	function quxiaoshezhi() {
		var selectedRows = $("#dg").datagrid("getSelections");
		if(selectedRows.length == 0) {
			$.messager.alert("系统提示", "请选择要设置的管理员");
			return;
		}
		var idsStr = [];
		for(var i = 0; i < selectedRows.length; i++) {
			idsStr.push(selectedRows[i].aid);
		}
		var aids = idsStr.join(","); //1,2,3,4	
		$.messager.confirm("系统提示", "<font color=red>您确定要设置选中的"+selectedRows.length+"管理员么？</font>", function(r) {
			if(r) {
				$.post("${pageContext.request.contextPath}/admin/quxiaosetadminaid",
						{aids: aids}, function(result){
							if(result.deleteResult) {
								$.messager.alert("系统提示", "取消管理员成功！");
								$("#dg").datagrid("reload");
							} else {
								$.messager.alert("系统提示", "取消管理员失败！");
							}
						}, "json");
			}
		});
	}
	function reload() {
		$("#dg").datagrid("reload");
	}
	
	//添加管理员
	function addadmin() {
		
		window.parent.openTab("修改文章","addadmin.jsp" , "icon-writeblog");
	}
</script>

</head>

<body style="margin: 1px; font-family: microsoft yahei">
<table id="dg" title="超级管理员" class="easyui-datagrid" fitColumns="true" pagination="true"
	url="${pageContext.request.contextPath}/admin/setadmin" toolbar="#tb" rownumbers="true">
	<thead>
		<tr>
			<th field="cb" checkbox="true" align="center"></th>
			<th field="aid" width="20" align="center" hidden="true">ID</th>	
			<th field="name" width="200" >姓名</th>
			<th field="email" width="100" align="center">邮箱</th> 
			<th field="phone" width="100" align="center">电话</th> 
			
		</tr>
	</thead>
</table>
<div id="tb"> 
	<div>
		&nbsp;姓名&nbsp;<input type="text"  id="s_title" size="20" onkeydown="if(event.keyCode==13) searchBlog()">
		<a href="javascript:searchBlog()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		<a href="javascript:deleteBlog()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
	<!-- 	<a href="javascript:openBlogModifyTab()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">设置超级管理员</a>	
		<a href="javascript:quxiaoshezhi()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">取消设置超级管理员</a>	 -->
<%  %>
<div hidden="true">		
<a href="javascript: addadmin()" class="easyui-linkbutton" iconCls="icon-edit" plain="true"  >添加管理员</a>	
</div>
	

<%
  
 String status1= (String) request.getSession().getAttribute("status");
if(status1.equals("3")){
    	 
%>
		<a href="javascript: addadmin()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">添加管理员</a>	
  
 
      <%
         	}
         %>


		<a href="javascript:reload()" class="easyui-linkbutton" iconCls="icon-reload" plain="true">刷新</a>		
	</div>
</div>
</body>
</html>
