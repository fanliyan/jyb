<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改文章页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/demo.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/static/ueditor1_4_3_3/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/static/ueditor1_4_3_3/ueditor.all.min.js">	</script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/static/ueditor1_4_3_3/lang/zh-cn/zh-cn.js"></script>

</head>

<body style="margin: 10px; font-family: microsoft yahei">

	<div id="p" class="easyui-panel" title="修改文章" style="padding: 10px;">
		
		<table cellspacing="20px">
			<tr>
				<td width="80px">标题：</td>
				<td><input type="text" id="title" name="title" style="width:400px" /></td>
			</tr>	
							
			<tr>
				<td valign="top">文章内容：</td>
				<td><script id="editor" name="connect" type="text/plain"
						style="width:613px; height:500px;"></script></td>
			</tr>
			<tr>
				<td></td>
				<td><a href="javascript:submitData()" class="easyui-linkbutton"
					data-options="iconCls:'icon-submit'">确认修改</a></td>
			</tr>
		</table>
	</div>




	<!-- 实例化编辑器 -->
	<script type="text/javascript">
		var ue = UE.getEditor('editor');
		ue.addListener("ready", function(){
			//通过UE自己封装的ajax请求数据
			UE.ajax.request("${pageContext.request.contextPath}/admin/showOneTrainee",
					{
						method: "post",
						async: false,
						data: {"tid":"${param.tid}"},
						onsuccess: function(result) { //根据id查询Blog，返回一个json格式的blog对象
							result = eval("(" + result.responseText + ")");
							$("#title").val(result.trainee.title);
																															
							UE.getEditor('editor').setContent(result.trainee.connect);
						}
					});
		});
	</script>
	<script type="text/javascript">
		function submitData() {
			var title = $("#title").val();
			
			var connect = UE.getEditor('editor').getContent();
			

			if (title == null || title == '') {
				$.messager.alert("系统提示", "请输入标题！");
			
			
			} 
			else {
				$.post("${pageContext.request.contextPath}/jiuye/editOnejiuye",
						{
							'tid': '${param.tid}',
							'title' : title,
							
							'connect' : connect
						}, function(result) {
							if (result.updateResult) {
								$.messager.alert("系统提示", "文章修改成功！");	
								window.location.href='jiuyeManage.jsp';	
							} else {
								$.messager.alert("系统提示", "文章修改失败！");
							}
						}, "json");
			}
		}
		
	</script>
</body>
</html>
