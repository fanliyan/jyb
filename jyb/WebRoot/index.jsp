<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>长春大学就业报主页</title>
    
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/layer.js"></script>
    <link href="css/layer.css" type="text/css" rel="stylesheet">
    <link rel="shortcut icon" href="favicon.ico"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <style type="text/css">
        /**
          * 这是全部调整  
          */
        *{
          margin: 0;
          padding: 0;
          border: none;
          list-style: none;
        }
        
        /**
        *从这里开始是页面 head部分的样式
        */
        .head{
          width: 100%;
          height: 72px;
          background: rgb(86,86,84);
        }
        .head_nag {
          margin-top: 20px;
          margin-left: 208px;
          width: 936px;
          height: 72px;
          border-radius: 35px 0px 35px 0px;
          background: rgba(53, 97, 124, 0.5);
        }
        .logo {
          float:left;
          margin-left:200px;
          width: 274px;
          height: 72px;
          
          /*border-radius: 35px 0px 0px 0px;*/
        }
        
        .head_nag_u{
          float:right;
          margin-right:192px;
          color: rgb(213,213,213);
          font-size: 14px;
          
        }
        .head_nag_u li{
          list-style: none;
          float: left;
          
          line-height: 80px;
          margin-left: 26px;
        }
        .head_nag_u a{
          text-decoration: none;
          color:rgb(213,213,213);
        }
        .head_nag_u a:HOVER {
          color: white;
        }
        .login_yes{
          color:rgb(213,213,213);
          font-size:16px;
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
        *这里开始是banner部分的样式
        */
        .banner{
          position:relative;
          width: 100%;
          
         
        }
        .banner_lunbo{
          
        }
        #banner_img{
        	
          width:100%;
          height:540px;
          margin-top:-10px;
          float:left;
          z-index: -2px;
        /*  margin-left: 120px;*/
          /*border: 1px solid red;*/
        }
        
        .f5{
          position: absolute;
          top: 200px;
          right: 10px;
          background: rgba(86,86,84,0.5);
          width: 30px;
          height: 60px;
          cursor: pointer;
          
        }
        .f5_img{
          margin-top: 10px;
          margin-left: 5px;
          width: 20px;
          height: 40px;
        }
       .f6{
          position: absolute;
          top: 200px;
          left:20px;
          background: rgba(86,86,84,0.5);
          width: 30px;
          height: 60px;
          cursor: pointer;
        }
        .f6_img{
          margin-top: 10px;
          margin-left: 5px;
          width: 20px;
          height: 40px;
        }
        .banner_navigation{
          position:absolute;
          width: 244px;
          height: 461px;
          top:50px;
          left:200px;
          background: rgba(86,86,84,0.5);
          z-index:2px;
		  filter: alpha(opacity=50); //0 代表的是隐藏，就是透明度最低。
          -moz-opacity:0.5;
        }
        
        .banner_navigation_u{
          float:left;
          margin-top:50px;
          color: rgb(213,213,213);
          font-size: 14px;
        }
        
        .banner_navigation_u li{
          list-style: none;
          width:220px;
          line-height: 80px;
          padding-left: 26px;
         
        }
         
        .banner_navigation_u a{
          text-decoration: none;
          
          color:rgb(213,213,213);
        }
        .banner_navigation_u a:HOVER {
          width:200px;
          height:80px;
         
          color: white;
        }
        /*  .banner_navigation_u div:HOVER {
          width:200px;
          height:80px;
          background:blue;
          color: white;
          }*/
        .banner_news{
          float: left;
         
          width: 950px;
          
          margin-left: 208px;
          margin-top: 10px;
        }
        .banner_news p{
          font-size: 30px;
          font-family: "微软雅黑";
        }
        .banner_news_left{
          border:1px solid red;
          float:left;
         
          width: 450px;
        }
        .banner_news_right{
          float:right;
          border:1px solid red;
          width: 450px;
        } 
        .f1{
          width:500px; 
          height:461px;
          position:absolute;
          top:50px;
          left:444px;
          z-index:3; 
          display: none;
          background: rgba(86,86,84,0.75);
          color:rgb(213,213,213);
        }
        
        .jyb_newspaper{
        	float:left;
        	border: 1px solid rgb(86,86,84);
        	width: 200px;
        	height: 290px;
        	margin-top: 20px;
        	margin-left: 20px;
        	background: white;
        }
        .f1_p1{
        	font-family: "微软雅黑";
        	font-size: 26px;
        	color:rgb(213,213,213);
        	margin-left: 20px;
        	margin-top: 20px;
        
        }
        .f1_p2{
        	
        	font-family: "微软雅黑";
        	font-size: 14px;
        	color:black;
        	margin-left: 11px;
        	padding-top: 11px;
        	
        }
        .jyb_newspapaer_img1{
        	float:left;
        	width: 178px;
        	height:240px;
        	margin-top: 11px;
        	margin-left: 11px;
        }
        .xrc_newspaper{
        	float:left;
        	border: 1px solid rgb(86,86,84);
        	width: 200px;
        	height: 290px;
        	margin-top: 20px;
        	margin-left: 20px;
        	background: white;
        }
         .xrc_newspapaer_img2{
         	float:left;
        	width: 178px;
        	height:240px;
        	margin-top: 11px;
        	margin-left: 11px;
        }
        .f2{
          width:500px; 
           
          position:absolute;
          height:461px;
          top:50px;
          left:444px;
          z-index:3; 
          display: none;
          background: rgba(86,86,84,0.75);
          color:rgb(213,213,213);
        }
        .f2 a{
        	color: rgb(213,213,213);
        	font-size: 12px;
        	text-decoration: none;
        	display: block;
        	line-height: 30px;
        }
        .f2 a:HOVER{
        	color: #3399cc;
        }
        .f3{
           width:500px; 
           height:461px;
           top:50px;
           left:444px;
           position:absolute;
           z-index:3;  
           display: none;
           background: rgba(86,86,84,0.75);
          color:rgb(213,213,213);
        }
        .f3 a{
        	color: rgb(213,213,213);
        	font-size: 12px;
        	text-decoration: none;
        	display: block;
        	line-height: 30px;
        }
        .f3 a:HOVER{
        	color: #3399cc;
        }
        .f4{
          width:500px; 
          height:461px;
          top:50px;
          left:444px; 
          position:absolute;
          z-index:3;  
          display:none;
          background: rgba(86,86,84,0.75);
          color:rgb(213,213,213);
        }
        .f4 a{
        	color: rgb(213,213,213);
        	font-size: 12px;
        	text-decoration: none;
        	display: block;
        	line-height: 30px;
        }
        .f4 a:HOVER{
        	color: #3399cc;
        }
        
         
         /**
          *这里开始是foot部分的样式
          */
        .foot{
         
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
          margin-left: 150px;
        }
        
        .foot_1_u li{
          float:left;
          list-style: none;
          line-height: 62px;
          margin-left: 50px;
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
          width: 700px;
          height: 100px;
         
          border-right: 1px solid rgb(73,73,71) ;
        }
      
        .foot_2_1_u{
          float:left;
          color: rgb(184,188,174);
          font-size: 12px;
          margin-left: 150px;
        }
        
        .foot_2_1_u li{
          list-style: none;
          line-height: 20px;
          margin-left: 50px;
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
  </style>
  <script type="text/javascript">
    var i=0;
    function banner(){/*整体思想：①先var一个名，通过document.id找到图片 
                     ②将要循环播放的图片放在一个新定义的数组里 
                             ③将img标签里的src路径用遍历数组的方法表示出来  
                 ④考虑循环到最后一张的时候重新遍历（通过重新给数组里的参数赋值）*/
                  
      var img=document.getElementById("banner_img");//img1取得的图片名，byId是找到div里的banner
      var arr=[
               "images/index_banner_img1.jpg",
               "images/11635558_133358893000_2.jpg",
               "images/318761-15041Z91U353.jpg",
               "images/7090204_115624509000_2.jpg"
              ];
      img.src=arr[i];
      i++; 
      if(i>=arr.length){
        i=0;
      }
      		
    }
    
    function banner1(k){
      clearInterval(s);
      i=k;
      banner();
      s=setInterval("banner()", 3000);
    }
    var s=setInterval("banner()", 3000);/*3s一切换*/
    function ffloat(t){
      var list=document.getElementById("c3").getElementsByTagName("li");
      var f=document.getElementsByName("f");
      f[t].style.display="block";
      for(var j=0;j<list.length;j++){
        list[j].style.background="none";
        list[j].style.color="black";
      }
      list[t].style.background="rgba(86,86,84,0.5)";
      list[t].style.color="#ffffff";
    }
    function ffloat1(){
    var list=document.getElementById("c3").getElementsByTagName("li");
      var f=document.getElementsByName("f");
      for(var j=0;j<=f.length;j++){
        f[j].style.display="none";
        list[j].style.background="none";
        list[j].style.color="black";
      }
    }
	$(function(){
		var arr=[
               "images/index_banner_img1.jpg",
               "images/11635558_133358893000_2.jpg",
               "images/318761-15041Z91U353.jpg",
               "images/7090204_115624509000_2.jpg"
              ];
		$(".f5").click(function(){
			if(i>=arr.length){
				i=0;
			}
			clearInterval(s);
			banner();
			s=setInterval("banner()", 3000);
		})
		$(".f6").click(function(){
			if(i<=0){
				i=arr.length-2;
			}else if(i==1){
				i=arr.length-1;
			}else{
				i=i-2;
			}
			clearInterval(s);
			banner();
			s=setInterval("banner()", 3000);
		})
	})
  	
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
	  <%
	      session.setAttribute("nowJsp" , "index");//把当前页面的路径存在session的nowJsp中
	  %> 
  	  <div class="head">
	      <div class="navigation">
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
		          <li class="login_yes">
		             <b><%="欢迎你，"+ map.get("name") %> </b>
		          </li>
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
      <div style="width: 100%;height: 475px;background: rgba(86,86,84,0.2);">
      <div class="banner">
	      <div class="banner_navigation" id="c3">
	        <ul class="banner_navigation_u">
	          <li onmouseover="ffloat(0)" onmouseout="ffloat1()" >
	            <a href="newspaperCtrl/showNewspaper">
	              <div class="li_d">
	                	往期报纸
	              </div>
	            </a>
	            <hr width="200px" />
	          </li>
	          <li onmouseover="ffloat(1)" onmouseout="ffloat1()" >
	            <a href="jiuye/queryUserPage">
	              <div class="li_d">
	         		       就业信息
	              </div>
	            </a>
	            <hr width="200px"/>
	          </li>
	          <li onmouseover="ffloat(2)" onmouseout="ffloat1()" >
	            <a href="articleCtrl/selectAllTitle">
	              <div class="li_d">
	           		     毕业须知
	              </div>
	            </a>
	            <hr width="200px"/>
	          </li>
	          <li onmouseover="ffloat(3)" onmouseout="ffloat1()" >
	            <a href="trainee/queryTraineeLike">
	              <div class="li_d">
	         		       加油实习生
	              </div>
	            </a>
	          </li>
        	</ul>
        </div>
      
        <!-- 白色导航的隐藏div -->
        <div class="f1" name="f" onmouseover="ffloat(0)" onmouseout="ffloat1()">
      		<p class="f1_p1">往期报纸</p>
        	<div class="jyb_newspaper">
        		<a href="newspaperCtrl/showNewspaper">
        			<img class="jyb_newspapaer_img1" alt="" src="images/36-1.jpg">
        		</a>
        		<p class="f1_p2">《长春大学就业报》</p>
        	</div>
        	<div class="xrc_newspaper">
        		<a href="xrcNewspaperCtrl/showNewspaper">
        			<img class="xrc_newspapaer_img2" alt="" src="images/xrc225-1.jpg">
        		</a>
        		<p class="f1_p2">《新人才报》</p>
        	</div>
        </div>
        <div class="f2" name="f" onmouseover="ffloat(1)" onmouseout="ffloat1()">
        	<p class="f1_p1">就业信息</p>
        	<ul style="margin: 20px 20px 0 10px; list-style: none;">
          		<c:forEach items="${jiuyelist }" varStatus="status" var="item"> 	
        			<li style="border-bottom: 1px dashed white; padding-left: 10px;"><a href="jiuye/showOnejiuye?tid=${item.tid }">${item.title }</a></li>		
         		</c:forEach> 
         	</ul>      
        </div>
      	<div class="f3" name="f" onmouseover="ffloat(2)" onmouseout="ffloat1()">
	        <p class="f1_p1">毕业须知</p>
	        <table style="border-collapse:collapse; font-size: 12px; margin: 20px 20px 0 10px;">
				<c:forEach var="item" items="${articleList}" varStatus="status">
					<tr style="border-bottom: 1px dashed white; height:30px;padding-left:10px;">
						<td align="left" style="background: url('../images/newsbgbg.jpg') no-repeat 9px 14px; left: 30px;">
						<c:if test="${item.status_0_1==1}">
							<span style="color: rgb(213,213,213); float:left; line-height:30px;padding-left:10px;"><b>【置顶】</b></span>
							</c:if> 
							<a href="articleCtrl/selectArticleOne?id=${item.id}" style="display:block; float:left; width:400px; line-height:30px; padding-left: 10px;"  >
								${item.title}
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
      	</div>
      	<div class="f4" name="f" onmouseover="ffloat(3)" onmouseout="ffloat1()">
      		<p class="f1_p1">加油实习生</p>
	      	<ul style="margin: 20px 20px 0 20px; list-style: none;">
		       	<c:forEach items="${list }" varStatus="status" var="item">
		         	<li style="border-bottom: 1px dashed #cccccc; padding-left: 20px;">
		         		<a href="trainee/showOneTrainee?tid=${item.tid }">${item.title }</a>
		         	</li>
		        </c:forEach>
	        </ul>       	
      	</div>
      	<div class="banner_lunbo">       
	        <img id="banner_img" alt="loading……" src="images/index_banner_img1.jpg">
	        <div class="f5">
	          <img alt="" src="images/jiantou.png" class="f5_img">
	        </div>
	        <div class="f6">
	          <img alt="" src="images/jiantou1.png" class="f6_img">
	        </div>
      	</div>
      	<%--<div class="banner_news">
		     	<div class="banner_news_left">
		          <p>长春大学就业新闻</p>
		         	<c:forEach items="${jiuyelist }" varStatus="status" var="item">
		         		<a href="jiuye/showOnejiuye?tid=${item.tid }">${item.title }</a>
		         		<br>
		      		</c:forEach>     
		      	</div>
		        <div class="banner_news_right">
		          	<p>长春大学就业新闻</p>
		          	<c:forEach items="${jiuyelist }" varStatus="status" var="item" begin="0" end="0">
		         		<a href="jiuye/showOnejiuye?tid=${item.tid }">${item.connect}</a>
		         		<br>
		         	</c:forEach> 
	        	</div>
      		</div> --%>
    	</div>
    	</div>
    	<div class="foot">
      		<div class="foot_1">
        		<ul class="foot_1_u">
         			<li class="foot_1_u_np">
            			<a href="JYBabstract.jsp">《长春大学就业报》简介</a>
          			</li>
		            <li class="foot_1_u_ei">
		            	<a href="JYBabstract.jsp">长春大学就业创业指导中心简介</a>
		            </li>
		            <li class="foot_1_u_know">
		            	<a href="publish.jsp">发行地点</a>
		            </li>
		          	<li class="foot_1_u_trainee">
		            	<a href="contact.jsp">联系我们</a>
		            </li>
        		</ul>
        		<div style="float: right;margin-right: 200px;line-height: 62px; ">
        			<a href="index" style="color: rgb(213,213,213); font-size:12px;">返回顶部</a>
        		</div>
      		</div>
      		<div class="foot_2">
        		<div class="foot_2_1">
          			<ul class="foot_2_1_u">
            			<li class="foot_2_1_u_np">
              				版权所有：《长春大学就业报》编辑部
            			</li>
            			<li class="foot_2_1_u_ei">
              				内容所有：《长春大学就业报》|长春大学就业信息网
            			</li>
            			<li class="foot_2_1_u_know">
              				地址：吉林省长春市朝阳区卫星路6543号长春大学第三教学楼501室
            			</li>
            			<li class="foot_2_1_u_trainee">
              				投稿邮箱：ccdxjyb@163.com|邮编：130022
            			</li>
            			<li class="foot_2_1_u_trainee">
              				新闻热线：0431-85250402
            			</li>
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
