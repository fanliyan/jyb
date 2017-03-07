<%@ page language="java" import="java.util.*" import="com.jyb.util.UrlKit"
	contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章管理</title>
	<link rel="stylesheet" type="text/css" href="css/select.css">
	<link type="text/css" href="css/common.css" rel="stylesheet" />
    <link type="text/css" href="css/main.css" rel="stylesheet" />
    <link type="text/css" href="css/head.css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/layer.js"></script>
    <link href="css/layer.css" type="text/css" rel="stylesheet">
	<link rel="shortcut icon" href="favicon.ico"/>
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
                   		<div class="d1">
                   			<img src="images/xinxiimg.png">
                   		</div>
                    	<p><b>往期报纸</b></p>
                    	<div class="d2">
                    	</div>
                	</li>
	                <li class="list" >
	                	<a href="newspaperCtrl/showNewspaper">长春大学就业报</a>
	                </li>
	                <li class="list">
	                	<a href="xrcNewspaperCtrl/showNewspaper">新人才报</a>
	                </li>
	            </ul>
	            <ul class="xinxi3">
	                <li class="x2">
	                    <div class="d1">
	                    	<img src="images/xinxiimg.png">
	                    </div>
	                    <p><b>就业新闻</b></p>
	                    <div class="d2">
	                    </div>
	                </li>
	                <li class="list">
	                	<a href="jiuye/queryUserPage">就业新闻</a>
	                </li>
	            </ul>
	            <ul class="xinxi4">
	                <li class="x2">
	                    <div class="d1">
	                    	<img src="images/xinxiimg.png">
	                    </div>
	                    <p><b>毕业须知</b></p>
	                    <div class="d2">
	                    </div>
	                </li>
	                <li class="list" style="background:#3399CC;">
	                	<a href="articleCtrl/selectAllTitle" style=" color:#ffffff; ">毕业早知道</a>
	                </li>
	            </ul>
	            <ul class="xinxi5">
	                <li class="x2">
	                    <div class="d1">
	                    	<img src="images/xinxiimg.png">
	                    </div>
	                    <p><b>加油吧实习生</b></p>
	                    <div class="d2">
	                    </div>
	                </li>
	                <li class="list">
	                	<a href="trainee/queryTraineeLike">实习生简介</a>
	                </li>
	            </ul>
	            <ul class="xinxi6">
	                <li class="x2">
	                    <div class="d1">
	                    	<img src="images/xinxiimg.png">
	                    </div>
	                    <p><b>关于我们</b></p>
	                    <div class="d2">
	                    </div>
	                </li>
	                <li class="list">
	                	<a href="JYBabstract.jsp">长春大学就业报简介</a>
	                </li>
	                <li class="list" >
	                	<a href="contact.jsp" >联系我们</a>
	                </li>
	                <li class="list" >
	                	<a href="publish.jsp" >发行地点</a>
	                </li>
	            </ul>
        	</div>
	        <div id="right">
	            <div class="top">
	                <p>毕业须知</p>
	                <ul>
	                    <li class="img"></li>
	                    <li class="tex">毕业须知</li>
		                <li class="tex">毕业早知道</li>
	                </ul>
	            </div>
		        <form id="turnPagefm" action="<%=UrlKit.getDomain(request)%>/articleCtrl/selectAllTitle" method="post">
					<div id="showAll">	
						<div>
							<table border="1px">
								<tr>
									<td>
										<%--<div
											style="width: 220px; height: 43px; float: left; border: 1px solid black;">&nbsp;&nbsp;&nbsp;文章标题
										</div>
										--%>
										<div style="float: right;">
											<div style=" float: right;">
												<input value="搜索" type="submit" style="line-height: 25px; padding: 0 10px; background: #3399cc; color:#ffffff; border-radius:10px;">
											</div>
											<div style=" float: left; margin-right: 5px;" >
												<input name="title" placeholder="请输入关键字"	style="height: 25px; border-radius:10px; padding-left: 5px;border: 1px solid rgb(204,204,204);">
											</div>
										</div>
									</td>
									<c:if test="${loginList.status==2 ||loginList.status==3 }">
										<td id="t3">
											&nbsp;&nbsp;&nbsp;
											操作 <a href="saveArticle.jsp">
													<img alt="" src="images/add.png">
											    </a>
										</td>
									</c:if>
								</tr>
							</table>
						</div>
						<div>
							<table style="border-collapse:collapse; font-size: 12px;">
								<c:forEach var="item" items="${list}" varStatus="status">
									<tr style="border-bottom: 1px dashed #cccccc; height:35px;">
										<td id="t1" align="left" style="background: url('images/newsbgbg.jpg') no-repeat 9px 14px; padding-left: 30px;">
											<c:if test="${item.status_0_1==1}">
												<span style="color: black; float:left; line-height:35px;">
													【置顶】
												</span>
											</c:if> 
											<a href="articleCtrl/selectArticleOne?id=${item.id}" style="display:block; float:left; width:300px; line-height:35px;"  >
												${item.title}
											</a>
										</td>
										<td id="t2" align="center">
											${item.time}
										</td>
										<c:if test="${loginList.status==2 ||loginList.status==3 }">
											<td id="t3" align="right">
												<a	href="articleCtrl/updateArticleOne?id=${item.id}">
													<img src="images/edit.png"/>
												</a> 
												<a href="articleCtrl/deleteArticle?id=${item.id}">
													<img src="images/delete.png"/>
												</a> 
												<a href="articleCtrl/updateArticleStatus_0_1?id=${item.id}">
													<img src="images/stick.png"/>
												</a> 
												<a href="articleCtrl/updateArticleStatus_1_0?id=${item.id}">
													<img src="images/remove.png"/>
												</a>
											</td>
										</c:if>
								</c:forEach>
							</table>
						</div>	
					</div>
					<div style="margin-left: 30px;">
						<%@include file="turnPage.jsp"%>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="foot">
	   	<div class="foot_1">
	   		<ul class="foot_1_u">
				<li class="foot_1_u_np">
					<a href="../JYBabstract.jsp">《长春大学就业报》简介</a>
				</li>
				<li class="foot_1_u_ei">
					<a href="#">长春大学就业创业指导中心简介</a>
				</li>
				<li class="foot_1_u_know">
					<a href="../contact.jsp">发行地点</a>
				</li>
				<li class="foot_1_u_trainee">
					<a href="../publish.jsp">联系我们</a>
				</li>
				
			</ul>
			<div style="float: right;margin-right: 200px;line-height: 62px; ">
        			<a href="articleCtrl/selectAllTitle" style="color: rgb(213,213,213); font-size:12px;">返回顶部</a>
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