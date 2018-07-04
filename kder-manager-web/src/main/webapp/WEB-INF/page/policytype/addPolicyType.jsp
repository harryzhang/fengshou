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
<form id="editPolicyTypeForm" method="post" action="<c:url value='policytype/savePolicyType.html'/>"> 
		<div>
		
			<table width="100%" border="0" align="center" cellpadding="3">			  
					<input type="hidden" id="id" name="id" value="${policytype.id}"/>
					<tr>	
						<td align="right">
							<label for="name">code</label>
						</td>	
						<td>
								<input type="text" id="code" name="code" value="${policytype.code}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">name</label>
						</td>	
						<td>
								<input type="text" id="name" name="name" value="${policytype.name}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">status</label>
						</td>	
						<td>
								<input type="text" id="status" name="status" value="${policytype.status}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">parentId</label>
						</td>	
						<td>
								<input type="text" id="parentId" name="parentId" value="${policytype.parentId}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">remark</label>
						</td>	
						<td>
								<input type="text" id="remark" name="remark" value="${policytype.remark}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">createUserId</label>
						</td>	
						<td>
								<input type="text" id="createUserId" name="createUserId" value="${policytype.createUserId}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">updateUserId</label>
						</td>	
						<td>
								<input type="text" id="updateUserId" name="updateUserId" value="${policytype.updateUserId}"/>												
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
								value="<fmt:formatDate value="createTime" pattern="yyyy-MM-dd"/>"
								class="easyui-datebox" size="14" data-options="editable : true"  
								/>
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">updateTime</label>
						</td>	
						<td>
								<input type="text" 
								id="updateTime" 
								name="updateTime" 
								value="<fmt:formatDate value="updateTime" pattern="yyyy-MM-dd"/>"
								class="easyui-datebox" size="14" data-options="editable : true"  
								/>
						</td>						   
					</tr>
		
				<tr>
					<td colspan="2">
						<input id="submitButton" name="submitButton" type="button" onclick="policytype_submit();"  value="提交" />	
					</td>
				<tr>			 
			</table>	   
		</div>	
	</form>
	<script type="text/javascript">
		
    function policytype_submit(){
    	$.ajax({ 
    			url: "<c:url value='/policytype/savePolicyType.html'/>", 
    			data: $("#editPolicyTypeForm").serialize(),
    			type:"post",
    			dataType:"json",
    			success: function(ret){
    	   	 		if(ret.code==="0"){
    	   	 			$.messager.confirm("保存成功",
    	   	 				           '是否继续添加？', 
    	   	 				           function(r){
						   	   			   if(r==false){
						   	   				$("#editPolicyTypeDiv").dialog("close");
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