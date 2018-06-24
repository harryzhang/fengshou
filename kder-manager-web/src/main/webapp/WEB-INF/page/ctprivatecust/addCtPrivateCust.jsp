<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>编辑字典</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache" />
<jsp:include page="../common_easyui_cus.jsp"></jsp:include>
</head>
<body>

<!-- 内容 -->
<form id="editCtPrivateCustForm" method="post" action="<c:url value='ctprivatecust/saveCtPrivateCust.html'/>"> 
		<div>
		
			<table width="100%" border="0" align="center" cellpadding="3">			  
					<input type="hidden" id="id" name="id" value="${ctprivatecust.id}"/>
					<tr>	
						<td align="right">
							<label for="name">userName</label>
						</td>	
						<td>
							<input type="text" id="userName" name="userName" value="${ctprivatecust.userName}"/>
						</td>											
					</tr>
					<tr>	
						<td align="right">
							<label for="name">phone</label>
						</td>	
						<td>
							<input type="text" id="phone" name="phone" value="${ctprivatecust.phone}"/>
						</td>
					</tr>
					<tr>	
						<td align="right">
							<label for="name">gender</label>
						</td>	
						<td>
							<input type="text" id="gender" name="gender" value="${ctprivatecust.gender}"/>
						</td>
					</tr>
					<tr>	
						<td align="right">
							<label for="name">status</label>
						</td>	
						<td>
							<input type="text" id="status" name="status" value="${ctprivatecust.status}"/>
						</td>
					</tr>
					<tr>	
						<td align="right">
							<label for="name">createTime</label>
						</td>	
						<td>
							<input type="text" 
								id="createTime" 
								name="createTime" 
								value="<fmt:formatDate value="${ctprivatecust.createTime}" pattern="yyyy-MM-dd"/>"
								class="easyui-datebox" size="14" data-options="editable : true"  
								/>
						</td>
					</tr>
		
				<tr>
					<td colspan="2">
						<input id="submitButton" name="submitButton" type="button" onclick="ctprivatecust_submit();"  value="提交" />	
					</td>
				<tr>			 
			</table>	   
		</div>	
	</form>
	<script type="text/javascript">
    function ctprivatecust_submit(){
    	$.ajax({ 
    			url: "<c:url value='/ctprivatecust/saveCtPrivateCust.html'/>", 
    			data: $("#editCtPrivateCustForm").serialize(),
    			type:"post",
    			dataType:"json",
    			success: function(ret){
    	   	 		if(ret.code==="0"){
    	   	 			$.messager.confirm("保存成功",
    	   	 				           '是否继续添加？', 
    	   	 				           function(r){
						   	   			   if(r==false){
						   	   				$("#editCtPrivateCustDiv").dialog("close");
						   	   			   }
    	   						});
    	   	 		}else{
    	   	 			$.messager.alert("error",ret.msg);
    	   	 		}
    	      	}
    	        });
    }
	
</script>

</body>

</html>