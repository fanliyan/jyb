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
<script src="${pageContext.request.contextPath}/static/js/uploadPreview.js" type="text/javascript"></script>
    <script>
       window.onload = function () { 
            new uploadPreview({ UpBtn: "up_img", DivShow: "imgdiv", ImgShow: "imgShow" });
        }
    </script>
</head>

<body style="margin: 10px; font-family: microsoft yahei">

	<div id="p" class="easyui-panel" title="修改文章" style="padding: 10px;">
	 <form id="editeForm">
	     <input type="hidden" name="tid" id="tid">
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
				<td><img id="imgShow" alt="暂时没有图片" src="" width="107px" height="153px"/><input type="file" name="file" id="up_img" /></td>
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
		</form>
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
							$("#tid").val(result.trainee.tid);
							$("#title").val(result.trainee.title);
							$("#name").val(result.trainee.name);
							$("#major").val(result.trainee.major);
							$("#company").val(result.trainee.company);
							$("#city").val(result.trainee.city);
							$("#imgShow").attr({'src': result.trainee.photo, 'title': result.trainee.name});																										
							UE.getEditor('editor').setContent(result.trainee.connect);
						}
					});
		});
	</script>
	<script type="text/javascript">
		function submitData() {
			var title = $("#title").val();
			var name = $("#name").val();
			var major = $("#major").val();
			var company = $("#company").val();
			var city = $("#city").val();	
			var tid =  $("#tid").val();	
			var connect = UE.getEditor('editor').getContent();
			

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
			} 
			else {
				var formData = new FormData($( "#editeForm" )[0]);  
			     $.ajax({  
			          url: '${pageContext.request.contextPath}/admin/editOneTrainee',  
			          type: 'POST',  
			          data: formData,  
			          async: false,  
			          cache: false,  
			          contentType: false,  
			          processData: false,  
			          success: function (data) {  
			              if(data.updateResult){
			              $.messager.alert("系统提示", "文章修改成功！");
			              }else{
			               $.messager.alert("系统提示", "文章修改失败！");
			              }		              
			          },  
			          error: function (data) {  
			             $.messager.alert("系统提示", "文章修改失败！");  
			          }  
			     });  
		}
	}
		
	</script>
</body>
</html>
