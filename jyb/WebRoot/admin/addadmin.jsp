<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加管理员</title>
    
    
    
  <script src="<%=basePath%>bootstrap/js/jquery-1.11.1.js"></script>
<script src="<%=basePath%>bootstrap/js/bootstrap.js"></script>
<script src="<%=basePath%>js/util.js"></script>
   <body>
	
	<script type="text/javascript">
	register = function() {
			var fm = $("#reg_fm"), uname = $("#uname"), nick = $("#nick"), pwd = $("#pwd"), pho = $("#pho"),error = $("#reg_error");

			if (!$.trim(uname.val())) return error.html("用户名不能为空");
			if (($.trim(uname.val()).length)>8) return error.html("用户名不能超过8位");
			if (!$.trim(nick.val())) return error.html("邮箱不能为空");
			if (!$.trim(pwd.val())) return error.html("密码不能为空");
			if (!$.trim(pho.val())) return error.html("电话不能为空");

			// 用ajax进行数据提交
		//$.post("test/register", fm.serialize());

			//	if (true) {
			//		$("#username").val(uname.val());
					// 注册成功，隐藏注册对话框，清空表单内容
			//		uname.val("");
			//		pwd.val("");
			//		nick.val("");
			//		pho.val("");
			//		error.html("");
			//		$("#register").modal("hide");
					//alert("注册成功！");
			//	} else {
			//		error.html(r.msg);
			//	}
			 var username=$("#uname").val();
	         var password=$("#pwd").val();
	         var email=$("#nick").val();
	         var phone=$("#pho").val();
			 $.ajax({   
         url:'admin/addadmin',   
         type:'post',   
		 data: {'username':username,'password':password,'email':email,'phone':phone},//发给服务器端的数据
         dataType:'json',
         success:function(data){   //data:服务器端返回给浏览器端的数据
		  	//alert(data);
            alert(data.result);
            //alert(data.loginResult);
            //alert(data.has);
		  		 // alert(data.result);
		  	  if(data.result==0){
		  		 alert('用户名已经存在');
		  		 $("#register").modal("hide");
		  			  }else{
		  			 alert('注册成功');
		  			  $("#username").val(uname.val());
			//	 注册成功，隐藏注册对话框，清空表单内容
				uname.val("");
				pwd.val("");
				nick.val("");
				pho.val("");
				error.html("");
				$("#register").modal("hide");
		  		  }
		  	  
         },
		   error:function (XMLHttpRequest, textStatus, errorThrown) {
      	   		alert(XMLHttpRequest);
      	   		alert(textStatus);
      	   		alert(errorThrown);
         }
     });
			
			}
</script>
	<div>
	
	<form id="reg_fm"   >
						<table align="center">
							<tr>
								<td>
									<label for="uname">用户名：</label>
								</td>
								<td style="width: 85%;">
									<input id="uname" name="username" type="text" class="input-block-level" placeholder="注个响亮的用户名">
								</td>
							</tr>
							<tr>
								<td>
									<label for="nick">邮&nbsp;&nbsp;&nbsp;&nbsp;箱：</label>
								</td>
								<td>
									<input id="nick" name="email" type="text" class="input-block-level" placeholder="请输入你的邮箱">
								</td>
							</tr>
							<tr>
								<td>
									<label for="pwd">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
								</td>
								<td>
									<input id="pwd" name="password" type="password" class="input-block-level" placeholder="千万要记住密码哦">
								</td>
							</tr>
							<tr>
								<td>
									<label for="pho">电&nbsp;&nbsp;&nbsp;&nbsp;话：</label>
								</td>
								<td>
									<input id="pho" name="phone" type="text" class="input-block-level" placeholder="请输入你的电话">
								</td>
							</tr>
							<tr>
								<td colspan="2" style="color: red;height: 20px;" id="reg_error"></td>
							</tr>
							<tr>
								
								<td>
								<input  type="button" class="btn btn-large btn-primary" onclick="register()" value="提交" />  
								</td>
							</tr>
						</table>
					</form>
					</div>
		<!-- <div class="modal-footer">
		  <a class="btn btn-large btn-primary" onclick="register()">注册</a>
				</div> -->
  </body>
</html>
