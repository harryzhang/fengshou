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
<form id="editOrgForm" method="post" action="<c:url value='org/saveOrg.html'/>"> 
		<div>
		
			<table width="100%" border="0" align="center" cellpadding="3">			  
					<input type="hidden" id="id" name="id" value="${org.id}"/>
					<tr>	
						<td align="right">
							<label for="name">组织机构编码</label>
						</td>	
						<td>
								<input type="text" id="orgCode" name="orgCode" value="${org.orgCode}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">组织机构名称</label>
						</td>	
						<td>
								<input type="text" id="orgName" name="orgName" value="${org.orgName}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">上级组织ID</label>
						</td>	
						<td>
								<input type="text" id="parentId" name="parentId" value="${org.parentId}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">状态</label>
						</td>	
						<td>
								<input type="text" id="status" name="status" value="${org.status}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">创建日期</label>
						</td>	
						<td>
								<input type="text" 
								id="createTime" 
								name="createTime" 
								value="<fmt:formatDate value="${org.createTime}" pattern="yyyy-MM-dd"/>"
								class="easyui-datebox" size="14" data-options="editable : false"  
								/>
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">创建人</label>
						</td>	
						<td>
								<input type="text" id="createBy" name="createBy" value="${org.createBy}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">更新日期</label>
						</td>	
						<td>
								<input type="text" 
								id="updateTime" 
								name="updateTime" 
								value="<fmt:formatDate value="${org.updateTime}" pattern="yyyy-MM-dd"/>"
								class="easyui-datebox" size="14" data-options="editable : true"  
								/>
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">更新人</label>
						</td>	
						<td>
								<input type="text" id="updateBy" name="updateBy" value="${org.updateBy}"/>												
						</td>						   
					</tr>
		
				<tr>
					<td colspan="2">
						<input id="submitButton" name="submitButton" type="button" onclick="org_submit();"  value="提交" />	
					</td>
				<tr>			 
			</table>	   
		</div>	
	</form>
	<script type="text/javascript">
		
    function org_submit(){
    	$.ajax({ 
    			url: "<c:url value='/org/saveOrg.html'/>", 
    			data: $("#editOrgForm").serialize(),
    			type:"post",
    			dataType:"json",
    			success: function(ret){
    	   	 		if(ret.code==="0"){
    	   	 			$.messager.confirm("保存成功",
    	   	 				           '是否继续添加？', 
    	   	 				           function(r){
						   	   			   if(r==false){
						   	   				$("#editOrgDiv").dialog("close");
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