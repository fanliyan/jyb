<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>长春大学就业报</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">  
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/layer.js"></script>
    <link rel="shortcut icon" href="favicon.ico"/>
    <link href="css/layer.css" type="text/css" rel="stylesheet">
    <link href="css/head.css" type="text/css" rel="stylesheet">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->					
	<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
	<style type="text/css">
		*{ margin:0; padding:0; list-style: none;}
		a{ text-decoration: none; color:black;}
		#copy a{ line-height: 32px; font-size: 12px; margin-left: 20px;}
		#copy a:hover{ color:#3399cc;}
		#copy a span{ font-size: 14px; line-height: 32px;}
		.nav{ width:522px; height: 37px; background: #E8E8E8; border-bottom:1px solid #BDBDBD; box-shadow:-1px 0 3px #BDBDBD, 0 0 3px #BDBDBD; list-style: none;}
		.nav p{ float: left; font-size: 12px; line-height: 37px; padding-left: 15px;}
		.nav a{ float: right; font-size: 12px; margin-right: 20px; line-height: 37px;}
		.nav a:hover{ color:#3399cc;}
		.nav a span{ font-size: 14px; line-height: 37px;}
		#news1 ul li{width: 280px; line-height:27px; float: left; padding-left: 20px; text-align: left;}
		#news1 ul li a{ width: 300px; display:block; font-size: 12px;}
		#news1 ul li:hover{ background: #cccccc; width: 280px; line-height:27px;}
		#news2 ul li{width: 180px; line-height:27px; float: left; padding-left: 20px; text-align: left;}
		#news2 ul li a{ width: 200px; line-height:27px; font-size: 12px; display:block;}
		#news2 ul li:hover{ background: #cccccc; width: 180px; line-height:27px;} 
	</style>
  </head>
  <script type="text/javascript">
  	function showLogin(){
		layer.open({
             type:2,
             title:false,
             closeBtn:1, //关闭按钮
             shade:0.5,
             area:['382px','350px'],
             shadeClose:true,
             content:['login.jsp','no']   //no表示不显示滚动条
         });
    }
  </script>
  <body onload="showPart('${partid}');">
  	<%
			session.setAttribute("nowJsp" , "news");
		 %>
		<div id="head">
			<div id="head_nag">
				<a href="index"><img alt="" src="images/ccuJYBLogo.jpg" class="logo"></a>
				<ul class="head_nag_u">
					<li class="head_nag_u_message">
						<form action="querySearch" method="post">
			              <input type="text" name="title"  placeholder="关键字搜索" class="sousuo">
			              <input type="submit"  value="搜索" class="sousuo_button">
			         	</form>
					</li>
					<li class="head_nag_u_message"><a href="message/queryMessagePage">留言</a></li>
				  	<%
						Map map = (Map)session.getAttribute("loginList");
						if(map!=null){
					%>
					<li class="login_yes"><b><%="欢迎你，"+ map.get("name") %></b></li>
					<%
						}else{
					%>
					<li id="open" class="head_nag_u_login" ">
						<a href="javascript:void(0)" onclick="showLogin()">登录</a>
					</li>		
					<%
						}
					%>
				</ul>
			</div>
		</div>
    <div style="width: 1000px; height: 600px; margin: 0 auto; position: relative;clear:left;">
			<div style="position:relative; top:-80px; width: 444px; height: 715px; float: left; cursor: pointer;" id="localImag">
				<img style="position:absolute;margin-top: 0px;margin-left: 0px; z-index: 1; width:444px; height:680px;border: 1px solid #3399cc;" id="preview" src='${imgname}'/>
				<c:forEach var="part" items="${partList}" varStatus="status">
					<div style="position:absolute; margin-top: ${part.t}px; margin-left: ${part.l}px; width: ${part.w}px; height: ${part.h}px;z-index: 2;" onclick="showPart('${part.partid}');" title="${part.parttitle}"></div>
				</c:forEach>
				<div id="copy" style="width:444px; height:32px; position: absolute; top:680px; left:0; border-bottom: 3px solid #3399cc;">
					<a href="javaScript:void(0);" onclick="toNewspaper('${newspaper.editionnum}','${pagenum-1}');"><span><</span>  上一版</a>
					<a href="javaScript:void(0);" onclick="toNewspaper('${newspaper.editionnum}','${pagenum+1}');">下一版 <span>></span></a>
				</div>
			</div>

			<div id="content_out" style=" width:505px; background:rgba(255,255,122,0.3); display:none; position: absolute; top:0; left:480px; z-index:10; background:#ffffff;"></div>
			<div id="content" style="width: 520px; height:635px; float: right;">
							<div class="nav">
					<p>长春大学就业报   —  第${newspaper.editionnum}期</p>
					<a href="javaScript:void(0);" onclick="toNewspaper('${newspaper.editionnum+1}','1');">下一期      <span>></span></a>
					<a href="javaScript:void(0);" onclick="toNewspaper('${newspaper.editionnum-1}','1');"><span><</span>  上一期</a>
				
				</div>
				<div style="width:520px; height:570px; margin-top:20px;">
					<div id="news1" style="background:#efefef; width: 300px; height: 570px; margin-right:14px; float: left;"> 
						<div style="width: 300px; line-height: 30px; color:#ffffff; font-family:’微软雅黑‘; background:#3399cc; text-align: center;">
							版面信息
						</div>
						<ul style="width: 300px; margin-top: 20px; list-style: none;">
							<c:forEach var="part" items="${partList}" varStatus="status">
								<li>
									<a href="javaScript:void(0);" onclick="showPart('${part.partid}');">${part.parttitle}</a>
								</li>
							</c:forEach>
						</ul>
					</div>
					<div id="news2" style="background:#efefef; width: 200px; height: 570px; float: right;">
						<div style=" color:#ffffff; font-family:’微软雅黑‘; background:#3399cc; width: 200px; line-height: 30px;text-align: center;">
							本期版面
						</div>
						<ul style="width: 200px; margin-top: 20px;">
							<c:forEach var="edition" items="${editionList}" varStatus="status">
								<li>
									<a href="javaScript:void(0);" onclick="toNewspaper('${newspaper.editionnum}','${edition.pagenum}');">${edition.pagetitle}</a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<form id="form1">
			<input type="hidden" name="editionnum" id="editionnum">
			<input type="hidden" name="pagenum" id="pagenum">
			<input type="hidden" id="maxPagenum" value="${maxPagenum}">
			<input type="hidden" id="maxEditionnum" value="${maxEditionnum}">
		</form>
		
		 <div class="foot">
	   		<div class="foot_1">
	   			<ul class="foot_1_u">
					<li class="foot_1_u_np"><a href="JYBabstract.jsp">《长春大学就业报》简介</a></li>
					<li class="foot_1_u_ei"><a href="javascript:void(0)">长春大学就业创业指导中心简介</a></li>
					<li class="foot_1_u_know"><a href="publish.jsp">发行地点</a></li>
					<li class="foot_1_u_trainee"><a href="contact.jsp">联系我们</a></li>
				</ul>
				<div style="float: right;margin-right: 200px;line-height: 62px; ">
        			<a href="newspaperCtrl/toNewspaper" style="color: rgb(213,213,213); font-size:12px;">返回顶部</a>
        		</div>
	   		</div>
	   		<div class="foot_2">
	   			<div class="foot_2_1">
		   			<ul class="foot_2_1_u">
						<li class="foot_2_1_u_np">版权所有：《长春大学就业报》编辑部</li>
						<li class="foot_2_1_u_ei">内容所有：《长春大学就业报》|长春大学就业信息网</li>
						<li class="foot_2_1_u_know">吉林省长春市朝阳区卫星路6543号长春大学第三教学楼501室</li>
						<li class="foot_2_1_u_trainee">投稿邮箱：ccdxjyb@163.com|邮编：130022</li>
						<li class="foot_2_1_u_trainee">新闻热线：0431-85250402</li>
					</ul>
				</div>
				<div class="foot_2_2">
					<img alt="" src="images/jyb2.jpg" style="width: 100px;height: 100px;float:left;">
          			<p style="float: left; width: 100px;height: 100px;margin-left: 10px;line-height: 20px;">
          				（扫一扫关注<b>长春大学就业报</b>微信公众平台，轻松获取最新最权威的就业资讯）
          			</p>	
          			<img alt="" src="images/zhongxin.jpg"style="margin-left:30px;width: 100px;height: 100px;float:left;">
          			<p style="float: left; width: 105px;height: 100px;margin-left: 10px;line-height: 18px;">
          				（扫一扫关注<b>长春大学就业创业指导中心</b>微信公众平台，轻松获取最新最权威的就业资讯）
          			</p>
				</div>
	   		</div>
  	 	</div>   
		
  </body>
</html>
<script type="text/javascript">
	function showPart(partid){
		if(partid!=null && partid!=""){
			$.ajax({   
	           url:'newspaperCtrl/selectNewspaperPart',   
	           type:'post',
			   data: {"partid":partid},//发给服务器端的数据
	           dataType:'json',//服务器传给浏览器的数据格式
	           success:function(data){   //data:服务器端返回给浏览器端的数据
			  	  //alert(data);
	              //alert(data.parttitle);
	              //alert(data.content);
	           	  var parttitle=data.parttitle;
	           	  var content=data.content;
	           	  var uploadtime=data.uploadtime;
	              var hits=data.hits;
	              var admin=data.name;
	           	  var content1 = document.getElementById("content");
	           	  content1.style.overflowX="visible";
	           	  content1.style.overflowY="scroll";
	           	  content1.innerHTML = "<h1 style='line-height:50px; margin-top:30px;text-align:center;'>"+parttitle+"</h1><p style=' line-height:40px; background:#3399cc; color:#ffffff; font-size:12px; text-align: center;'>发布者："+admin+"&nbsp;&nbsp;&nbsp;&nbsp;上传时间:"+uploadtime+"&nbsp;&nbsp;&nbsp;&nbsp;点击量:"+hits+"</p>"+content;
	           	  var content_out = document.getElementById("content_out");
	           	  content_out.style.display="block";
	           	  content_out.innerHTML = "<h1 style='line-height:50px; margin-top:30px;text-align:center;'>"+parttitle+"</h1><p style=' line-height:40px; background:#3399cc; color:#ffffff; font-size:12px; text-align: center;'>发布者："+admin+"&nbsp;&nbsp;&nbsp;&nbsp;上传时间:"+uploadtime+"&nbsp;&nbsp;&nbsp;&nbsp;点击量:"+hits+"</p>";
			   },
			   error:function (XMLHttpRequest, textStatus, errorThrown) {
	        	   		alert(XMLHttpRequest);
	        	   		alert(textStatus);
	        	   		alert(errorThrown);
	           }
	       });
		}
	}

	function toNewspaper(editionnum,pagenum){
//		alert(editionnum);
//		alert(pagenum);
		var maxPagenum = $("#maxPagenum").val();
		var maxEditionnum = $("#maxEditionnum").val();
		if(parseInt(pagenum)>parseInt(maxPagenum)){
			pagenum = 1;
			editionnum = parseInt(editionnum) + 1;
		}
		if(parseInt(pagenum)< 1){
			pagenum = 1;
			editionnum = parseInt(editionnum) - 1;
		}
		if(parseInt(editionnum)> parseInt(maxEditionnum)){
			alert("已经是最新一期了");
		}else{
			$("#editionnum").val(editionnum);
			$("#pagenum").val(pagenum);
			var x= document.getElementById("form1");
	    	x.method="post";
	    	x.action="newspaperCtrl/toNewspaper";
	    	x.submit();
    	}
	}
</script>