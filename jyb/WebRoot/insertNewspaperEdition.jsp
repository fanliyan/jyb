<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		<!-- <link rel="stylesheet" type="text/css" href="styles.css"> -->
		<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
		<style type="text/css">
        html{color:#000;overflow-y:scroll;overflow:-moz-scrollbars-vertical}
        .div{position:absolute; border:1px dashed blue; width:0; height:0;left:0; top:0; overflow:hidden;z-index:2;}
    	</style>
<!--    	<script type="text/javascript" src="jquery.js"></script>-->
	</head>

	<body>
		<div style="border: 1px solid red; width: 860px; height: 680px; margin-left: 200px;">

			<div style="border: 1px solid red; width: 444px; height: 680px; float: left;" id="localImag">
				<img style="position:absolute;margin-top: 0px;margin-left: 0px; z-index: 1;" id="preview" width='444px' height='680px' src='img/df_newspaper.jpg' />
			</div>

			<div style="border: 1px solid red; width: 400px; height: 680px; float: right;">
				<font color='red'>${msg}</font>
				<form id="form">
					<input type="file" name="doc" id="doc" onchange="setImagePreview()"><br/>
					第<select name="newspaperid"> 
						<c:forEach var="newspaper" items="${newspaperList}" varStatus="status">
						<option value="${newspaper.newspaperid}">${newspaper.editionnum}</option>
						</c:forEach>
					</select> 期
					第<input type="text" size="1" name="pagenum" id="pagenum"/>版<br/>
					标题：<input type="text" name="pagetitle" id="pagetitle"/><br/>
					格式：（距顶-距左-高度-宽度）
					<div id="formdiv">
						
					</div>
					<input type="button" value="提交" onclick="doSubmit()"/>
				</form>
			</div>
		</div>
	</body>
</html>
<script>
function doSubmit(){
		var doc = $("#doc").val();
		var pagenum = $("#pagenum").val();
		var pagetitle = $("#pagetitle").val();
		var w = null;
		var status = false;
		for(var i=1;i<7;i++){
			w = "#"+i+"w"
			w = $(w).val();
			if(w!=null && w!=""){
				var test = w.replace(/\px/g,"").split("-");
				if(test[0]!="" && test[1]!="" && test[2]!="" && test[3]!="" ){
				status = true;
				}
				break;
			}
		}
		if(doc == ""){
			alert("请添加图片文件！");
		}else if(pagenum == ""){
			alert("请添加板块号！");
		}else if(pagetitle == ""){
			alert("请添加板块标题！");
		}else if(!status){
			alert("请在图片上拖选进行添加板块！");
		}else{
			var x= document.getElementById("form");
			x.action='newspaperCtrl/insertNewspaperEdition';
			x.method="post";
			x.enctype="multipart/form-data";
			x.submit();
		}
}
	
function imgdragstart(){return false;} //禁止图片拖动
for(i in document.images)document.images[i].ondragstart=imgdragstart;//禁止图片拖动

function setImagePreview() {
	var docObj = document.getElementById("doc");
	var imgObjPreview = document.getElementById("preview");
	if (docObj.files && docObj.files[0]) {
		//火狐下，直接设img属性
		imgObjPreview.style.display = 'block';
		imgObjPreview.style.width = '444px';
		imgObjPreview.style.height = '680px';
		//imgObjPreview.src = docObj.files[0].getAsDataURL();
		//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
		imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
	} else {
		//IE下，使用滤镜
		docObj.select();
		var imgSrc = document.selection.createRange().text;
		var localImagId = document.getElementById("localImag");
		//必须设置初始大小
		localImagId.style.width = "444px";
		localImagId.style.height = "680px";
		//图片异常的捕捉，防止用户修改后缀来伪造图片
		try {
			localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
			localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
		} catch (e) {
			alert("您上传的图片格式不正确，请重新选择!");
		}
		imgObjPreview.style.display = 'none';
		document.selection.empty();
	}
}

$(function () {
        var wId = "w";
        var index = 0;
        var startX = 0, startY = 0;
        var flag = false;
        var retcLeft = "0px", retcTop = "0px", retcHeight = "0px", retcWidth = "0px";
        var big = document.getElementById("localImag");
        var t1 = 10;
        var l1 = 210;
        big.onmousedown = function(e){
        	if(parseInt(index)<6){
	            flag = true;
	            try{
	                var big = document.getElementById("localImag");
	                var evt = window.event || e;
	                var scrollTop = document.body.scrollTop || document.documentElement.scrollTop;
	                var scrollLeft = document.body.scrollLeft || document.documentElement.scrollLeft;
	                startX = evt.clientX + scrollLeft;
	                startY = evt.clientY + scrollTop;
	                index++;
	                var div = document.createElement("div");
	                div.id = wId + index;
	                div.className = "div";
	                div.style.marginLeft = startX+"px";
	                div.style.marginTop = startY+"px";
	                big.appendChild(div);
	            }catch(e){
	                //alert(e);
	            }
            }else{
            	alert("已添加到最大限度");
            }
        };
        
        big.onmouseup = function(){
            try{
                var big = document.getElementById("localImag");
				var InputsWrapper = document.getElementById("formdiv"); //Input boxes wrapper ID
				var input = document.createElement("input");
//                document.body.removeChild($(wId + index));
//                var div = document.createElement("div");
				var t = startY - t1+"px";
                var l = startX - l1+"px";
                input.type = "text";
                input.value = t+"-"+l+"-"+retcHeight+"-"+retcWidth;
                input.id = index + wId;
                input.name = wId + index;
                InputsWrapper.appendChild(input);
//                div.style.marginLeft = retcLeft;
//                div.style.marginTop = retcTop;
//                div.style.width = retcWidth;
//                div.style.height = retcHeight;
               // big.appendChild(div);
            }catch(e){
                //alert(e);
            }
            flag = false;
            retcLeft = "0px";
            retcTop = "0px";
            retcHeight = "0px";
            retcWidth = "0px";
        };
        big.onmousemove = function(e){
            if(flag){
                try{
                    var evt = window.event || e;
                    var scrollTop = document.body.scrollTop || document.documentElement.scrollTop;
                    var scrollLeft = document.body.scrollLeft || document.documentElement.scrollLeft;
                    retcLeft = (startX - evt.clientX - scrollLeft > 0 ? evt.clientX + scrollLeft : startX) + "px";
                    retcTop = (startY - evt.clientY - scrollTop > 0 ? evt.clientY + scrollTop : startY) + "px";
                    retcHeight = Math.abs(startY - evt.clientY - scrollTop) + "px";
                    retcWidth = Math.abs(startX - evt.clientX - scrollLeft) + "px";
                    $(wId + index).style.marginLeft = retcLeft;
                    $(wId + index).style.marginTop = retcTop;
                    $(wId + index).style.width = retcWidth;
                    $(wId + index).style.height = retcHeight;
                }catch(e){
                    //alert(e);
                }
            }
        };
        var $ = function(id){
            return document.getElementById(id);
        }
    });
</script>