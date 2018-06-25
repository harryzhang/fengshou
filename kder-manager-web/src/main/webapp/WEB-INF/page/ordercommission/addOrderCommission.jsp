<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>编辑订单佣金</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache" />
<jsp:include page="../common_easyui_cus.jsp"></jsp:include>
</head>
<body>

<!-- 内容 -->
<form id="editOrderCommissionForm" method="post" action="<c:url value='ordercommission/saveOrderCommission.html'/>"> 
		<div>
		
			<table width="100%" border="0" align="center" cellpadding="3">			  
					<input type="hidden" id="id" name="id" value="${ordercommission.id}"/>
					<tr>	
						<td align="right">
							<label for="name">业务员ID</label>
						</td>	
						<td>
								<input type="text" id="userId" name="userId" value="${ordercommission.userId}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">保单ID</label>
						</td>	
						<td>
								<input type="text" id="orderId" name="orderId" value="${ordercommission.orderId}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">业务员姓名</label>
						</td>	
						<td>
								<input type="text" id="userName" name="userName" value="${ordercommission.userName}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">佣金</label>
						</td>	
						<td>
								<input type="text" id="commissionAmt" name="commissionAmt" value="${ordercommission.commissionAmt}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">保单编码</label>
						</td>	
						<td>
								<input type="text" id="orderNo" name="orderNo" value="${ordercommission.orderNo}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">是否有效</label>
						</td>	
						<td>
								<input type="text" id="status" name="status" value="${ordercommission.status}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">审批状态</label>
						</td>	
						<td>
								<input type="text" id="auditStatus" name="auditStatus" value="${ordercommission.auditStatus}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">审批日期</label>
						</td>	
						<td>
								<input type="text" 
								id="auditTime" 
								name="auditTime" 
								value="<fmt:formatDate value="${ordercommission.auditTime}" pattern="yyyy-MM-dd"/>"
								class="easyui-datebox" size="14" data-options="editable : true"  
								/>
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">审批人ID</label>
						</td>	
						<td>
								<input type="text" id="auditId" name="auditId" value="${ordercommission.auditId}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">创建人ID</label>
						</td>	
						<td>
								<input type="text" id="createBy" name="createBy" value="${ordercommission.createBy}"/>												
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
								value="<fmt:formatDate value="${ordercommission.createTime}" pattern="yyyy-MM-dd"/>"
								class="easyui-datebox" size="14" data-options="editable : true"  
								/>
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
								value="<fmt:formatDate value="${ordercommission.updateTime}" pattern="yyyy-MM-dd"/>"
								class="easyui-datebox" size="14" data-options="editable : true"  
								/>
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">更新人ID</label>
						</td>	
						<td>
								<input type="text" id="updateBy" name="updateBy" value="${ordercommission.updateBy}"/>												
						</td>						   
					</tr>
		
				<tr>
					<td colspan="2">
						<input id="submitButton" name="submitButton" type="button" onclick="ordercommission_submit();"  value="提交" />	
					</td>
				<tr>			 
			</table>	   
		</div>	
	</form>
	<script type="text/javascript">
		
    function ordercommission_submit(){
    	$.ajax({ 
    			url: "<c:url value='/ordercommission/saveOrderCommission.html'/>", 
    			data: $("#editOrderCommissionForm").serialize(),
    			type:"post",
    			dataType:"json",
    			success: function(ret){
    	   	 		if(ret.code==="0"){
    	   	 			$.messager.confirm("保存成功",
    	   	 				           '是否继续添加？', 
    	   	 				           function(r){
						   	   			   if(r==false){
						   	   				$("#editOrderCommissionDiv").dialog("close");
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