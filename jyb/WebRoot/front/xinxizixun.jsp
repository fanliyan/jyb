<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>信息咨询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" href="favicon.ico"/>
	<link type="text/css" href="css/common.css" rel="stylesheet" />
    <link type="text/css" href="css/main.css" rel="stylesheet" />
     <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
   <!--  <script type="text/javascript" src="js/jquery.js"></script> -->
    <script type="text/javascript">

    </script>

  </head>
  
  <body>
    <div class="head">
        <div id="head">
            <div class="head_nag">
                <a href="#"><img alt="" src="images/ccuJYBLogo.jpg" class="logo"></a>
                <ul class="head_nag_u">
                    <li></li>
                </ul>
            </div>
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
                    <li class="list"><a href="#this">长春大学就业报</a></li>
                    <li class="list"><a href="#this">新人才报</a></li>
                </ul>
                <ul class="xinxi3">
                    <li class="x2">
                        <div class="d1"><img src="images/xinxiimg.png"></div>
                        <p>就业新闻</p>
                        <div class="d2"></div>
                    </li>
                    <li class="list"><a href="#this">就业新闻</a></li>
                </ul>
                <ul class="xinxi4">
                    <li class="x2">
                        <div class="d1"><img src="images/xinxiimg.png"></div>
                        <p>毕业须知</p>
                        <div class="d2"></div>
                    </li>
                    <li class="list"><a href="#this">毕业早知道</a></li>
                </ul>
                <ul class="xinxi5">
                    <li class="x2">
                        <div class="d1"><img src="images/xinxiimg.png"></div>
                        <p>加油吧实习生</p>
                        <div class="d2"></div>
                    </li>
                    <li class="list"><a href="javascript:void(0)" onclick="b();">实习生简介</a></li>
                    <li class="list"><a href="javascript:void(0)">实习生事例</a></li>
                </ul>
                <ul class="xinxi6">
                    <li class="x2">
                        <div class="d1"><img src="images/xinxiimg.png"></div>
                        <p>关于我们</p>
                        <div class="d2"></div>
                    </li>
                    <li class="list"><a href="#this">长春大学就业报简介</a></li>
                </ul>
            </div>
            <div id="right">
                <div class="top">
                    <p>长春大学就业报</p>
                    <ul>
                        <li class="img"></li>
                        <li class="tex">往期报纸</li>
                        <li class="tex">长春大学就业报</li>
                    </ul>
                </div>
                <!--长春大学就业报-->
                <div class="right1 right">
                    <div id="news1">
                        <dl>
                            <a href="#this">
                                <dd><img src="images/job33-18.jpg" title="就业报第33期" /></dd>
                                <dt>就业报第33期<span style="float: right;">2015年11月03日</span></dt>
                            </a>
                        </dl>
                        <dl>
                            <a href="#this">
                                <dd><img src="images/job34-18.jpg"  title="就业报第34期" /></dd>
                                <dt>就业报第34期<span style="float: right;">2015年11月03日</span></dt>
                            </a>
                        </dl>
                        <dl>
                            <a href="#this">
                                <dd><img src="images/job35-18.jpg"  title="就业报第35期" /></dd>
                                <dt>就业报第35期<span style="float: right;">2016年04月25日</span></dt>
                            </a>
                        </dl>
                        <dl>
                            <a href="#this">
                                <dd><img src="images/job36-18.jpg"  title="就业报第36期" /></dd>
                                <dt>就业报第36期<span style="float: right;">2016年06月15日</span></dt>
                            </a>
                        </dl>
                        <dl>
                            <a href="#this">
                                <dd><img src="images/job37-14.jpg"  title="毕业季特刊" /></dd>
                                <dt>就业报第36期<span style="float: right;">2016年06月20日</span></dt>
                            </a>
                        </dl>
                        <dl>
                            <a href="#this">
                                <dd><img src="images/quality-18.jpg"  title="就业质量年度报告" /></dd>
                                <dt>就业报第36期<span style="float: right;">2015年11月03日</span></dt>
                            </a>
                        </dl>
                    </div>
                </div>
                <!--新人才报-->
                <div class="right2 right">
                    <div id="news2">
                        <dl>
                            <a href="#this">
                                <dd><img src="images/new223-14.jpg" title="新人才报报第223期" /></dd>
                                <dt>新人才报报第223期<span style="float: right;">2016年03月08日</span></dt>
                            </a>
                        </dl>
                        <dl>
                            <a href="#this">
                                <dd><img src="images/new224%201-4.jpg" title="新人才报报第224期" /></dd>
                                <dt>新人才报报第224期<span style="float: right;">2016年03月15日</span></dt>
                            </a>
                        </dl>
                        <dl>
                            <a href="#this">
                                <dd><img src="images/new225%201-4.jpg" title="新人才报报第225期" /></dd>
                                <dt>新人才报报第225期<span style="float: right;">2016年03月22日</span></dt>
                            </a>
                        </dl>
                        <dl>
                            <a href="#this">
                                <dd><img src="images/new226-14.jpg" title="新人才报报第226期" /></dd>
                                <dt>新人才报报第226期<span style="float: right;">2016年03月29日</span></dt>
                            </a>
                        </dl>
                        <dl>
                            <a href="#this">
                                <dd><img src="images/new227-14.jpg" title="新人才报报第227期" /></dd>
                                <dt>新人才报报第227期<span style="float: right;">2016年04月05日</span></dt>
                            </a>
                        </dl>
                        <dl>
                            <a href="#this">
                                <dd><img src="images/new228%201-4.jpg" title="新人才报报第228期" /></dd>
                                <dt>新人才报报第228期<span style="float: right;">2016年03月12日</span></dt>
                            </a>
                        </dl>
                    </div>
                </div>
                <!--就业新闻-->
                <div class="right3 right">
                    <div id="news">
                        <ul>
                            <li><a href="#this">该写些什么呢<span style="float: right;">2016-08-07</span></a></li>
                            <li><a href="#this">这个东西没有定高，你可以无限的加li<span style="float: right;">2016-08-07</span></a></li>
                            <li><a href="#this">这是没有影响的<span style="float: right;">2016-08-07</span></a></li>
                            <li><a href="#this">有问题的话可以问我，一直在线<span style="float: right;">2016-08-07</span></a></li>
                        </ul>
                    </div>
                </div>
                <!--毕业早知道-->
                <div class="right4 right">
                    <div id="leave">
                        <ul>
                            <li><a href="#this">该写些什么呢<span style="float: right;">2016-08-07</span></a></li>
                            <li><a href="#this">这个东西没有定高，你可以无限的加li<span style="float: right;">2016-08-07</span></a></li>
                            <li><a href="#this">这是没有影响的<span style="float: right;">2016-08-07</span></a></li>
                            <li><a href="#this">有问题的话可以问我，一直在线<span style="float: right;">2016-08-07</span></a></li>
                        </ul>
                    </div>
                </div>
                <!--实习生简介-->
                <div class="right5 right">
                    <ul id="search">
                        <li>姓名&nbsp;<input class="text" type="text" /></li>
                        <li>实习单位&nbsp;<input class="text" type="text" /></li>
                        <li>标题&nbsp;<input class="text" type="text" /></li>
                        <li>专业&nbsp;<input class="text" type="text" /></li>
                        <li>实习地点&nbsp;<input class="text" type="text" /></li>
                        <li><input type="submit" class="btn1 btn" value="查询" /></li>
                    </ul>
                     <script type="text/javascript">
                    function b(){
                      alert("222");
                      $("#right").load("trainee/queryTraineeLike");
                      }
                    </script>
                    <div id="graduate">
                   
                      <c:forEach items="${traineeList }" varStatus="status" var="item"> 
                        <dl>
                            <a href="#this">
                                <dd>
                                    <div class="img">
                                        <img alt="暂时没有图片" src="${item.photo }" title="${item.name }"/>
                                    </div>
                                </dd>
                                <dt>
                                <div>
                                    <p><strong>姓名：</strong>${item.name }</p>
                                    <p><strong>专业：</strong>${item.major }</p>
                                    <p><strong>实习地点：</strong>${item.city }</p>
                                    <p><strong>实习单位：</strong>${item.company }</p>
                                    <p><strong>标题：</strong>${item.title }</p>
                                </div>
                                </dt>
                            </a>
                        </dl>  
                       </c:forEach>                    
                    </div>
                </div>
                <!--实习生事例-->
                <div class="right6 right"></div>
                <!--长春大学就业报简介-->
                <div class="right7 right"></div>
                <ul class="page">
                    <li>1/2</li>
                    <li>共n条记录</li>
                    <li>每页显示<input class="text" type="text" />条记录</li>
                    <li>首页</li>
                    <li>上一页</li>
                    <li>下一页</li>
                    <li>尾页</li>
                    <li><input class="btn" type="button" value="跳转到" />第</li>
                    <li><input class="text" type="text">页</li>
                </ul>
            </div>
        </div>
    </div>
    <div id="footer">

    </div>
</body>
</html>
