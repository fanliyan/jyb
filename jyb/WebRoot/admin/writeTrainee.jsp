<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>写文章页面</title>
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
	src="${pageContext.request.contextPath}/static/ueditor1_4_3_3/ueditor.all.min.js">
	
</script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="${pageContext.request.contextPath}/static/ueditor1_4_3_3/lang/zh-cn/zh-cn.js"></script>
<script src="${pageContext.request.contextPath}/static/js/uploadPreview.js" type="text/javascript"></script>
    <script>
       window.onload = function () { 
            new uploadPreview({ UpBtn: "up_img", DivShow: "imgdiv", ImgShow: "imgShow" });
        }
    </script>
</head>

<body style="margin: 10px; font-family: microsoft yahei">

	<div id="p" class="easyui-panel" title="编写文章" style="padding: 10px;">
	  <form id="addForm">
		<table cellspacing="20px">
			<tr>
				<td width="80px">标题：</td>
				<td><input type="text" id="title" name="title" style="width:400px" /></td>
			</tr>	
			<tr>
				<td width="80px">姓名：</td>
				<td><input type="text" id="name" name="name" style="width:400px" /></td>
			</tr>	
			<tr>
				<td width="80px">专业：</td>
				<td><input type="text" id="major" name="major" style="width:400px" /></td>
			</tr>	
			<tr>
				<td width="80px">实习单位：</td>
				<td><input type="text" id="company" name="company" style="width:400px" /></td>
			</tr>	
			<tr>
				<td width="80px">实习地点：</td>
				<td><input type="text" id="city" name="city" style="width:400px" /></td>
			</tr>
			<tr>
				<td width="80px">照片：</td>		
				<td><img id="imgShow" width="107px" height="153px" /><input name="file" type="file" id="up_img"></td>
			</tr>
			<input type="hidden" name="connect" id="connect">
			<tr>
				<td valign="top">文章内容：</td>
				<td><script id="editor" name="content" type="text/plain"
						style="width:613px; height:500px;"></script></td>
			</tr>
			<tr>
				<td></td>
				<td><a href="javascript:submitData()" class="easyui-linkbutton"
					data-options="iconCls:'icon-submit'">发布文章</a></td>
			</tr>
		</table>
	</form>
	</div>




	<!-- 实例化编辑器 -->
	<script type="text/javascript">
		var ue = UE.getEditor('editor');
	</script>
	<script type="text/javascript">
		function submitData() {
		
			var title = $("#title").val();
			var name = $("#name").val();
			var major = $("#major").val();
			var company = $("#company").val();
			var city = $("#city").val();
			var file = $("#up_img").val();
			var imgShow;
			
			var editor = UE.getEditor('editor');			 	
		    var connect = editor.getContent();
		    $("#connect").val(connect);				   							

			if (title == null && title == '') {
				$.messager.alert("系统提示", "请输入标题！");
			} else if (name == null && name == '') {
				$.messager.alert("系统提示", "请输入姓名！");
			} else if (major == null && major == '') {
				$.messager.alert("系统提示", "请输入专业！");
			} else if(company == null && company == ''){
			   $.messager.alert("系统提示", "请输入实习单位！");
			} else if(city == null && city == ''){
				 $.messager.alert("系统提示", "请输入实习地点！");
			} else if(file == null && file == ''){
				 $.messager.alert("系统提示", "请上传图片！");
			}else if(!editor.hasContents()){
				$.messager.alert("系统提示", "请输入文章内容！");
			}			
			 else {
				
			   var formData = new FormData($( "#addForm" )[0]);  
			     $.ajax({  
			          url: '${pageContext.request.contextPath}/admin/saveTrainee' ,  
			          type: 'POST',  
			          data: formData,  
			          async: false,  
			          cache: false,  
			          contentType: false,  
			          processData: false,  
			          success: function (data) {  
			              if(data.saveResult){
			              $.messager.alert("系统提示", "文章发布成功！");
			               clearValues(); 
			              }else{
			               $.messager.alert("系统提示", "文章发布失败！");
			              }		              
			          },  
			          error: function (data) {  
			             $.messager.alert("系统提示", "文章发布失败！");  
			          }  
			     });  
		}
	}
		
	/*  function getContent() {
		    var editor = UE.getEditor('editor');
		    var connect = editor.getContent();
		     if(!editor.hasContents()){
		         $.messager.alert("系统提示", "请输入内容！");
		     }else{
		        alert(UE.getEditor('editor').getContent());
		        document.getElementById('connect').value = connect;
		        }
	    }  */
		function clearValues() {
			 title = $("#title").val("");
			 name = $("#name").val("");
			 major = $("#major").val("");
			 company = $("#company").val("");
			 city = $("#city").val("");
			 file = $("#up_img").val("");
			 imgShow = $("#imgShow").attr({'src': ''});
			UE.getEditor("editor").setContent("");			
		}
	</script>
</body>
</html>
