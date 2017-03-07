<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.jyb.util.UrlKit"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>长春大学就业报</title>
    
     
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/layer.js"></script>
    
    
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.js"> </script>
<!--    建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--    这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/layer.css" type="text/css" rel="stylesheet">
	<link rel="shortcut icon" href="favicon.ico"/>
	<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
  </head>
  	<style type="text/css">
		* {
			margin: 0;
			padding: 0;
		}
		#head {
			padding-top:20px;
			width: 100%;
			height: 230px;
			background-image: url("images/a1.jpg");
			margin-top: 0px;
		}
		#head_nag {
			float:left;
			margin-top: 45px;
			margin-left: 208px;
			width: 936px;
			height: 72px;
			border-radius: 35px 0px 35px 0px;
			background: rgba(255, 255, 255, 0.5);
		}
		
		.logo {
			float:left;
			width: 274px;
			height: 72px;
			border-radius: 35px 0px 0px 0px;
		}
		
		.head_nag_u{
			float:right;
			color: rgb(86,86,84);
			font-size: 14px;
			margin-right: 100px;
			
		}
		.head_nag_u li{
			list-style: none;
			float: left;
			
			line-height: 80px;
			margin-left: 26px;
		}
		.head_nag_u a{
			text-decoration: none;
			color:rgb(86,86,84);
			font-weight: bold;
		}
		.head_nag_u a:HOVER {
			color: white;
	    }
	    .login_yes{
	    	color:red;
	    	line-height: 80px;
	    	margin-left: 26px;
	    }
	    
	    .sousuo{
	    	width: 200px;
	    	height: 30px;
	    	padding:5px;
	    	border-radius:15px;
	    	border: 2px solid rgb(7,127,169);
	    }
	    
	    .sousuo_button{
	    	width: 40px;
	    	height: 30px;
	    	margin-left:-30px;
	    	border-radius:0 15px 15px 0;
	    	border: none;
	    	background: rgb(7,127,169);
	    	color:white;
	    }
		
		/**
		*从这里开始是banner的样式
		*/
		.banner{
			width: 935px;
			margin:-20px auto;
			margin-bottom:20px ;
			background: rgb(218, 237, 246);
			border: 1px solid gainsboro;
		    box-shadow: 2px 0 2px #cccccc;
			font-size: 16px;
			color:rgb(121,121,145);
			padding:20px 10px;
		}
		
		.message_eve{
			width:100%;
			margin-top:10px;

			border-top: 1px solid rgb(121,121,121);
		}
		.banner p{
			margin-left: 0px;
		}
		.banner_con{
			margin-top:20px;
			width: 100%;
			height: 100px;
			border:1px solid rgb(121,121,121);
			color:black;
		}
		.banner_but{
			float:right;
			margin-top:10px;
			
			margin-bottom:10px;
			width: 60px;
			height:30px;
			background: #3399cc;
			border:none;
			color:white;
		}
		.message_conp{
				
		
		}
		.delect_button{
			float:right;
			margin-top:-20px;
			
			
			width: 40px;
			height:20px;
			background: #3399cc;
			border:none;
			color:white;
		}
		 /**
	    *这里开始是foot部分的样式
	    */
	     .foot{
	     	margin-top: 10px;
	     
	     }
	     .foot_1{
	     	float:left;
	     	width: 100%;
	     	height: 62px;
	     	border-bottom:1px solid rgb(73,73,71) ;
	     	background: rgb(86,86,84);
	     }
	     
	      .foot_1_u{
	    	float:left;
			color: rgb(184,188,174);
			font-size: 12px;
			margin-left: 200px;
	    }
	    
	     .foot_1_u li{
	     	float:left;
	     	list-style: none;
			line-height: 62px;
			margin-right: 50px;
	     
	     }
	     
	     .foot_1_u a{
			text-decoration: none;
			color:rgb(184,188,174);
		}
		.foot_1_u a:HOVER {
			color: white;
	    }
	     .foot_2{
	     	float:left;
	     	width: 100%;
	     	height: 150px;
	     	border-top:1px solid rgb(103,103,101);
	     	background: rgb(86,86,84);
	     
	     }
	     
	    .foot_2_1 {
	    	margin-top:20px;
	    	float: left;
	    	width: 680px;
	    	height: 100px;
	    	border-right: 1px solid rgb(73,73,71) ;
	    }
	   
	    .foot_2_1_u{
	    	float:left;
			color: rgb(184,188,174);
			font-size: 12px;
			margin-left: 200px;
	    }
	    
	     .foot_2_1_u li{
	     	
	     	list-style: none;
			line-height: 20px;
			
	     
	     }  
	     .foot_2_2{
	     	float:left;
	          color: rgb(184,188,174);
	          font-size: 12px;
	          padding-left: 10px;
	          margin-top:20px;
	          width: 500px;
	          height: 100px;
	          border-left: 1px solid rgb(103,103,101) ;
	     }
		.head_nag_u{
		
		color:red;
		}
	</style>

	<body>
		<%
			session.setAttribute("nowJsp" , "message/queryMessagePage");
		 %>
		<div id="head">
			<div id="head_nag">
				<a href="index">
					<img alt="" src="images/ccuJYBLogo.jpg" class="logo">
				</a>
				<ul class="head_nag_u">
					<li class="head_nag_u_message">
						<form action="querySearch" method="post">
			              <input type="text" name="title"  placeholder="关键字搜索" class="sousuo">
			              <input type="submit"  value="搜索" class="sousuo_button">
			         	</form>
					</li>
					<li class="head_nag_u_message">
						<a href="message/queryMessagePage">留言</a>
					</li>
				  	<%
						Map map = (Map)session.getAttribute("loginList");
						if(map!=null){
					%>
					<li class="login_yes"><b><%="欢迎你，"+ map.get("name") %></b></li>
					<%
						}else{
					%>
					<li id="open" class="head_nag_u_login" >
          				<a href="javascript:void(0)" onclick="showLogin()">登录</a>
        			</li> 		
					<%
						}
					%>
				</ul>
			</div>
		</div>
		<div class="banner">
			<br/>
			<p style="color:black;font-size: 26px; font-family:黑体; ">
				留言板
			</p>
			<br/>
			<hr width="100%" height="2px" color="rgb(61,162,240)">
			<form>
				<%-- <textarea type="text" name="connect" class="banner_con"  placeholder="我也要说一句……（140字内）"></textarea>
				--%><br>
				<script id="editor" name="editor" type="text/plain" style="width:930px;height:100px;" >
				
				</script>
				<input type="button" value="留言" name="button" id="open" class="banner_but" onclick="doSubmit('${loginList.uid}','${loginList.name}');">
			</form>
			<br><br>
			<hr width="100%" height="2px" color="rgb(61,162,240)">
			<br>
			<p style="color:black;font-size: 20px; font-family:黑体; ">
				全部留言
			</p>
			<br>
			<form id="turnPagefm" action="message/queryMessagePage">
				<c:forEach var="message" items="${messageList}" varStatus="status">
					<div style="table-layout:fixed; word-break: break-all;" class="message_eve">
						<!--<button id="message">查询全部留言</button>-->
						<br/>
						<p class="message_namep" style="color:rgb(86,86,84);font-size: 18px;font-family: 黑体;">
							@${message.name }
						</p>
						<p class="message_timep" style="color:rgb(86,86,84);font-size: 12px;font-family: 黑体;">
							${message.time}
						</p>
						<br/>
						<p class="message_conp" style="color:rgb(86,86,84);font-size: 18px;font-family: 宋体;">
							留言：<br/>${message.connect }
						</p>
						<!--<p>${message.mid}</p>-->
						<c:if test="${loginList.name == message.name || loginList.status == 2 || loginList.status == 3}">	
							<input type="hidden" name="mid" value="${message.mid}">
							<input class="delect_button" type="button" value="删除" onclick="del('${message.mid}')">
						</c:if>
							<input type="hidden" name="mid" value="${message.mid}">
							<input type="hidden" value="删除" onclick="del('${message.mid}')"class="delect_button">
					</div>		
				</c:forEach>
				<br>
				<hr width="100%" height="2px" color="rgb(86,86,84)">
				
				<%@ include file="common/turnPage.jsp" %>
			</form>
			
		</div>
		
		
		<div class="foot">
	   		<div class="foot_1">
	   			<ul class="foot_1_u">
					<li class="foot_1_u_np"><a href="javascript:void(0)">《长春大学就业报》简介</a></li>
					<li class="foot_1_u_ei"><a href="#">长春大学就业创业指导中心简介</a></li>
					<li class="foot_1_u_know"><a href="publish.jsp">发行地点</a></li>
					<li class="foot_1_u_trainee"><a href="contact.jsp">联系我们</a></li>
				</ul>
				<div style="float: right;margin-right: 200px;line-height: 62px; ">
        			<a href="index" style="color: rgb(213,213,213); font-size:12px;">返回顶部</a>
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

	
		<script type="text/javascript">
			function del(id){
			//alert(id);
				if(confirm("你真的要删除所选留言吗？？？")){
					location.href='message/delectMessage?mid='+id;
					
				}else{
					//alert("2");
				}
			}
			
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
			
			function doSubmit(uid,name){
				//alert(uid);
				//alert(name);
				if(name!=null && name!=""){
					var content = UE.getEditor('editor').getContent();
					var count = UE.getEditor('editor').getContentTxt().length;
					if(content!=""){
						if(count<=140){
							$.ajax({   
					           url:'message/insertMessage',   
					           type:'post',   
							   data: {"content":content,"name":name,"uid":uid},//发给服务器端的数据
					           dataType:'json',//服务器传给浏览器的数据格式
					           success:function(data){   //data:服务器端返回给浏览器端的数据
	// 						  	  alert(data);
	// 				              alert(data.result);
								  
						              if(data.result==1){
						              	alert("留言成功！");
						              	location.href="message/queryMessagePage";
						              }else{
						              	UE.getEditor('editor').setContent("");
						              }
					           },
							   error:function (XMLHttpRequest, textStatus, errorThrown) {
					        	   		alert(XMLHttpRequest);
					        	   		alert(textStatus);
					        	   		alert(errorThrown);
					           }
					       	});
				       	}else{
				            alert("字数过长，请简化后重新留言！");
				        }
					}else{
						alert("请输入留言后再进行留言！");
					}
				}else{
					if(confirm("留言需要登录，要进入登录页面吗？")){
						location.href="login.jsp";
					}
				}
			}
		
		
		 //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
	var ue = UE.getEditor('editor', {
		toolbars: [[
					        
		        'emotion', //表情、
			]
			],
			autoHeightEnabled: true,
			autoFloatEnabled: true,
			focus:true//初始化时获取焦点
		});
		 function getContent() {
        alert(UE.getEditor('editor').getContent());
    }  
		</script>
	</body>
</html>
