<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>实习生感想</title>
     <link rel="stylesheet" type="text/css" href="css/select.css">
	<link type="text/css" href="css/common.css" rel="stylesheet" />
    <link type="text/css" href="css/main.css" rel="stylesheet" />
    <link type="text/css" href="css/head.css" rel="stylesheet" />
   
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/layer.js"></script>
    <link href="css/layer.css" type="text/css" rel="stylesheet">
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="./css/traineedetail.css">
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
  <body>
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
	
	<div id="contents">
	    <div id="xinxizixun">
	        <div id="left">
	            <div class="xinxi1">
	                <div class="x1">
	                    <p>信息资讯</p>
	                </div>
	            </div>
	            <ul class="xinxi2">
	                <li class="x2">
	                    <div class="d1"><img src="images/xinxiimg.png"></div>
	                    <p>往期报纸</p>
	                    <div class="d2"></div>
	                </li>
	                <li class="list" ><a href="newspaperCtrl/showNewspaper">长春大学就业报</a></li>
	                <li class="list"><a href="xrcNewspaperCtrl/showNewspaper">新人才报</a></li>
	            </ul>
	            <ul class="xinxi3">
	                <li class="x2">
	                    <div class="d1"><img src="images/xinxiimg.png"></div>
	                    <p>就业新闻</p>
	                    <div class="d2"></div>
	                </li>
	                <li class="list"><a href="jiuye/queryUserPage" >就业新闻</a></li>
	            </ul>
	            <ul class="xinxi4">
	                <li class="x2">
	                    <div class="d1"><img src="images/xinxiimg.png"></div>
	                    <p>毕业须知</p>
	                    <div class="d2"></div>
	                </li>
	                <li class="list" ><a href="articleCtrl/selectAllTitle" >毕业早知道</a></li>
	                
	            </ul>
	            <ul class="xinxi5">
	                <li class="x2">
	                    <div class="d1"><img src="images/xinxiimg.png"></div>
	                    <p>加油吧实习生</p>
	                    <div class="d2"></div>
	                </li>
	                <li class="list"><a href="trainee/queryTraineeLike">实习生简介</a></li>
	                
	            </ul>
	            <ul class="xinxi6">
	                <li class="x2">
	                    <div class="d1"><img src="images/xinxiimg.png"></div>
	                    <p>关于我们</p>
	                    <div class="d2"></div>
	                </li>
	                <li class="list" style="background:#3399CC;">
	                	<a href="JYBabstract.jsp" style=" color:#ffffff; ">长春大学就业报简介</a>
	                </li>
	                <li class="list" >
	                	<a href="contact.jsp" >联系我们</a>
	                </li>
	                <li class="list" >
	                	<a href="publish.jsp" >发布地点</a>
	                </li>
	            </ul>
	        </div>
	        <div id="right">
	            <div class="top">
	                <p>关于我们</p>
	                <ul>
	                    <li class="img"></li>
	                    <li class="tex">长春大学就业报简介</li>
	                    
	                </ul>
	            </div>
      
			 	<div class="out">
			         <div class="trainee_right">
			              <h2 class="title">长春大学就业报简介</h2>
			              <div class="publisher" style="font-size: 12px;">
			              		发布者：长春大学就业报&nbsp;&nbsp;&nbsp;
			              		发布时间：2016.9.1&nbsp;&nbsp;
			              		浏览量：<%@include file="visits.jsp" %>
			              </div>
			              <div class="content" style=" margin-left: 50px;">
			              <p>长春大学就业报是由长春大学就业创业指导中心创办的校级组织，负责出版印刷《<strong>长春大学就业报</strong>》。同时，承办吉林省教育厅和省就业指导中心的《<strong>新人才报</strong>》的出版印刷。</p><p><br/>长春大学就业报<strong>宗旨</strong>：为在校生传递就业信息，加强就业指导，为应届生交流择业经验，完善就业服务。</p><p><br/>长春大学就业报下设秘书部（新媒体运营）、新闻采编部、责任校对部、美术编辑部<strong>四大部门</strong>。</p>
			              </div>
			         </div>
			    </div>
	     	 </div>
		</div>
	</div>
      	<div class="foot">
	   		<div class="foot_1">
	   			<ul class="foot_1_u">
					<li class="foot_1_u_np"><a href="JYBabstract.jsp">《长春大学就业报》简介</a></li>
					<li class="foot_1_u_ei"><a href="JYBabstract.jsp">长春大学就业创业指导中心简介</a></li>
					<li class="foot_1_u_know"><a href="publish.jsp">发行地点</a></li>
					<li class="foot_1_u_trainee"><a href="contact.jsp">联系我们</a></li>
				</ul>
				<div style="float: right;margin-right: 200px;line-height: 62px; ">
        			<a href="JYBabstract.jsp" style="color: rgb(213,213,213); font-size:12px;">返回顶部</a>
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
