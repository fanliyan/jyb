<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%-- 要将此页面包含到form表单中，并且form表单的id是turnPagefm --%>
<script language="JavaScript" type="text/JavaScript">
<!--
function strtrim(str){//去除前后空白
        var i = 0;
        var len = str.length;
        if ( str == "" ) return( str );
        j = len -1;
        begin = true;
        end = true;
        while ( begin == true && i< len)
        {
           if ( str.charAt(i) == " " )
                {
                  i=i+1;
                  begin=true;
                }
                else
                {
                        begin=false;
                }
        }

        while  (end== true && j>=0)
        {
            if (str.charAt(j)==" ")
                {
                        j=j-1;
                        end=true;
                }
                else
                {
                        end=false;
                }
        }
        if ( i > j ) return ("")
        trimstr = str.substring(i,j+1);
        return trimstr;
}

function goFirstPage(){
	if(validateForm()){
		document.getElementById("pageNum").value=1;
		turnPagefm.submit();
  }
}

function goPrePage(){
	if(validateForm()){
		var pv = parseInt(document.getElementById("pageNum").value);
		if (pv == 1)
		{
			pv =2;
		}
		document.getElementById("pageNum").value = pv-1;
		turnPagefm.submit();
	}
}

function goNextPage(){
	if(validateForm()){
		var pv = parseInt(document.getElementById("pageNum").value);
		if (pv == document.getElementById("pageCount").value)
		{
			pv =0;
		}
		document.getElementById("pageNum").value = pv+1;
		turnPagefm.submit();	
	}  
}

function goLastPage(){
	if(validateForm()){
		document.getElementById("pageNum").value = document.getElementById("pageCount").value;
  		turnPagefm.submit();	
	}  
  
}

function validateForm() {
        var form = document.getElementById("turnPagefm");
        if(form==null){
        	alert('需要id为turnPagefm的表单！');
        	return;
        }
        var errors = false;
        // field name: rowInOnePage
        // validator name: requiredstring

        var error = "每页显示记录数不能为空";
        var tmp = document.getElementById("rowInOnePage").value;
        tmp = strtrim(tmp);
        if (tmp == "" ) {
        	document.getElementById("rowInOnePage").focus();
        	alert(error);
        	return false;
        }
       
        // field name: rowInOnePage
        // validator name: int
        if (document.getElementById("rowInOnePage").value) {
        	//alert($F("rowInOnePage"));
            field = document.getElementById("rowInOnePage").value;
           var error = "每页显示记录数应该在 10 至 100 之间";
            if (parseInt(field) < 10 ||
                        parseInt(field) > 100) {
                    document.getElementById("rowInOnePage").focus();
                   alert(error);
                    return false;
            }
        }
        return !errors;
}

function go(){
  if(validateForm()){
		document.all.pageNum.value = document.all.pageIndex.value;
		turnPagefm.submit();	
	}  
}
//-->
</script>
	<table width="97%" style="margin-left: 10px;">
		<tr>
			<td align="left" style="line-height:40px;" >
     			<c:if test="${turnPage!=null&&turnPage.pageCount>0}">
           			共${turnPage.total}条记录&nbsp;&nbsp;
          			当前页数为：${turnPage.pageNum}/${turnPage.pageCount}&nbsp;&nbsp;&nbsp;&nbsp;
					每页显示 <input id="rowInOnePage" type="text" name="rowInOnePage" style="width:20px" value="${turnPage.rowInOnePage}" maxlength="3" size="2" /> 条记录&nbsp;
		  				  <input id="pageNum" type="hidden" name = "pageNum" value="${turnPage.pageNum}"/>
		  				  <input id="pageCount" type="hidden" name = "pageCount" value="${turnPage.pageCount}"/>
						  <c:if test="${turnPage.pageNum!=1}"> 
		  					<a href="javascript:void(0)" onclick="goFirstPage()">第一页</a>&nbsp;
		 				 	<a href="javascript:void(0)" onclick="goPrePage()">上一页</a>
	  					 </c:if>&nbsp;&nbsp;
	    				 <c:if test="${turnPage.pageCount > turnPage.pageNum}"> 
	      					<a href="javascript:void(0)" onclick="goNextPage()">下一页</a>&nbsp;
	      					<a href="javascript:void(0)" onclick="goLastPage()">最后一页</a>
	    				 </c:if>&nbsp;&nbsp;
	      				 <input type='button' style="width:30px; background: #3399cc; color:white;" value='转到' onclick="go();">
	      				 第<input id="pageIndex" style="width:20px" size='2' value="${turnPage.pageNum}">页
				</c:if>
			</td>
		</tr>
	</table>