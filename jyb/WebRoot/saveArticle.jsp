<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>修改界面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" charset="utf-8"
	src="ueditor/ueditor.config.js"></script>
<script type="text/javascript"> src="js/jquery-1.11.0.min.js"</script>
<script type="text/javascript" charset="utf-8"
	src="ueditor/ueditor.all.min.js">
	
</script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#butSubmit").click(function() {
			if ($("#articleTitle").val() == '') {
				window.alert("标题不能为空");
			}else if(!UE.getEditor('editor').hasContents()){
				window.alert("内容不能为空");
			}
		});
	});
</script>

</head>

<body>
<%
	String code=request.getParameter("code");
		if("1".equals(code)){
			out.println("<font color='red'>添加成功！</font><br/>");
		}
		else if("-2".equals(code)){
		out.println("<font color='red'>添加失败！</font><br/>");
	}
%>
	<form action="articleCtrl/saveArticle" method="post"
		enctype="multipart/form-data">
		标题：<input type="text" name="title" id="articleTitle" /><br /> 
		<div>
			<script id="editor" name="connect" type="text/plain" style="width:1024px;height:500px;">
			
			</script>
			
		</div>
		<input type="submit" value="上传" id="butSubmit">
		<!-- <input type="submit" onclick="getContent()" value="发布"> <input
			type="reset" value="重置" id="r" onclick="reSet()"> -->
	</form>
	
	
	<script type="text/javascript">
		//实例化编辑器
		//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
			var ue = UE.getEditor('editor', {

				toolbars : [ [ 'undo', //撤销
				'redo', //重做
				'bold', //加粗
				'italic', //斜体
				'underline', //下划线
				'strikethrough', //删除线
				'formatmatch', //格式刷
				'pasteplain', //纯文本粘贴模式
				'removeformat', //清除格式
				'link', //超链接
				'unlink', //取消链接
				'anchor', //锚点
				'|', 'emotion', //表情、
				'autotypeset', //自动排版
				'source', //源代码
				'fullscreen', //全屏
				'preview', //预览
				], [ 'fontfamily', //字体
				'fontsize', //字号
				'paragraph', //段落格式

				'justifyleft', //居左对齐
				'justifyright', //居右对齐
				'justifycenter', //居中对齐
				'justifyjustify', //两端对齐
				'forecolor', //字体颜色
				'backcolor', //背景色
				'insertorderedlist', //有序列表
				'insertunorderedlist', //无序列表
				'lineheight', //行间距
				'|', 'simpleupload', //单图上传
				'insertimage', //多图上传
				'imagenone', //默认
				'imageleft', //左浮动
				'imageright', //右浮动
				'imagecenter', //居中
				'|', 'attachment', //附件
				], [ 'inserttable', //插入表格
				'edittable', //表格属性
				'edittd', //单元格属性
				'insertrow', //前插入行
				'insertcol', //前插入列
				'mergeright', //右合并单元格
				'mergedown', //下合并单元格
				'deleterow', //删除行
				'deletecol', //删除列
				'splittorows', //拆分成行
				'splittocols', //拆分成列
				'splittocells', //完全拆分单元格
				'deletecaption', //删除表格标题
				'inserttitle', //插入标题
				'mergecells', //合并多个单元格
				'deletetable', //删除表格
				'insertparagraphbeforetable', //"表格前插入行"
				'|', 'insertcode', //代码语言
				'|', 'help', //帮助
				] ],
				autoHeightEnabled : true,
				autoFloatEnabled : true,
				focus : true,
				//初始化时获取焦点

			});
			
	</script>
</body>
</html>
