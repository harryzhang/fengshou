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
<form id="editCtOrderForm" method="post" action="<c:url value='ctorder/saveCtOrder.html'/>"> 
		<div>
		
			<table width="100%" border="0" align="center" cellpadding="3">			  
					<input type="hidden" id="orderId" name="orderId" value="${ctorder.orderId}"/>
					<tr>	
						<td align="right">
							<label for="name">保单号</label>
						</td>	
						<td>
								<input type="text" id="orderNo" name="orderNo" value="${ctorder.orderNo}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">产品Id</label>
						</td>	
						<td>
								<input type="text" id="prodId" name="prodId" value="${ctorder.prodId}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">用户Id</label>
						</td>	
						<td>
								<input type="text" id="userId" name="userId" value="${ctorder.userId}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">订单状态</label>
						</td>	
						<td>
								<input type="text" id="orderStatus" name="orderStatus" value="${ctorder.orderStatus}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">保障期限</label>
						</td>	
						<td>
								<input type="text" id="orderPeriod" name="orderPeriod" value="${ctorder.orderPeriod}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">保障起始日期</label>
						</td>	
						<td>
								<input type="text" 
								id="startTime" 
								name="startTime" 
								value="<fmt:formatDate value="${ctorder.startTime}" pattern="yyyy-MM-dd"/>"
								class="easyui-datebox" size="14" data-options="editable : true"  
								/>
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">保障截止日期</label>
						</td>	
						<td>
								<input type="text" 
								id="endTime" 
								name="endTime" 
								value="<fmt:formatDate value="${ctorder.endTime}" pattern="yyyy-MM-dd"/>"
								class="easyui-datebox" size="14" data-options="editable : true"  
								/>
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">保单金额</label>
						</td>	
						<td>
								<input type="text" id="orderAmt" name="orderAmt" value="${ctorder.orderAmt}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">投保人证件号</label>
						</td>	
						<td>
								<input type="text" id="userCertNo" name="userCertNo" value="${ctorder.userCertNo}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">投保人证件类别</label>
						</td>	
						<td>
								<input type="text" id="userCertType" name="userCertType" value="${ctorder.userCertType}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">投保人地址</label>
						</td>	
						<td>
								<input type="text" id="userAddress" name="userAddress" value="${ctorder.userAddress}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">投保人手机号</label>
						</td>	
						<td>
								<input type="text" id="userPhone" name="userPhone" value="${ctorder.userPhone}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">被保人姓名</label>
						</td>	
						<td>
								<input type="text" id="recognizeeName" name="recognizeeName" value="${ctorder.recognizeeName}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">被保人生日</label>
						</td>	
						<td>
								<input type="text" 
								id="recognizeeBirth" 
								name="recognizeeBirth" 
								value="<fmt:formatDate value="${ctorder.recognizeeBirth}" pattern="yyyy-MM-dd"/>"
								class="easyui-datebox" size="14" data-options="editable : true"  
								/>
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">被保人证件类型</label>
						</td>	
						<td>
								<input type="text" id="recognizeeCertType" name="recognizeeCertType" value="${ctorder.recognizeeCertType}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">被保人证件号</label>
						</td>	
						<td>
								<input type="text" id="recognizeeCertNo" name="recognizeeCertNo" value="${ctorder.recognizeeCertNo}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">被保人手机号</label>
						</td>	
						<td>
								<input type="text" id="recognizeePhone" name="recognizeePhone" value="${ctorder.recognizeePhone}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">被保人地址</label>
						</td>	
						<td>
								<input type="text" id="recognizeeAddress" name="recognizeeAddress" value="${ctorder.recognizeeAddress}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">被保人性别</label>
						</td>	
						<td>
								<input type="text" id="recognizeeGender" name="recognizeeGender" value="${ctorder.recognizeeGender}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">被保是否有社保</label>
						</td>	
						<td>
								<input type="text" id="recognizeeSecurity" name="recognizeeSecurity" value="${ctorder.recognizeeSecurity}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">跟投保是同一人</label>
						</td>	
						<td>
								<input type="text" id="isSame" name="isSame" value="${ctorder.isSame}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">业务员Id</label>
						</td>	
						<td>
								<input type="text" id="salesId" name="salesId" value="${ctorder.salesId}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">业务员姓名</label>
						</td>	
						<td>
								<input type="text" id="salesMan" name="salesMan" value="${ctorder.salesMan}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">佣金</label>
						</td>	
						<td>
								<input type="text" id="commissionAmt" name="commissionAmt" value="${ctorder.commissionAmt}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">项目Id</label>
						</td>	
						<td>
								<input type="text" id="projectId" name="projectId" value="${ctorder.projectId}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">审批状态</label>
						</td>	
						<td>
								<input type="text" id="auditStatus" name="auditStatus" value="${ctorder.auditStatus}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">审批日期</label>
						</td>	
						<td>
								<input type="text" 
								id="auditDate" 
								name="auditDate" 
								value="<fmt:formatDate value="${ctorder.auditDate}" pattern="yyyy-MM-dd"/>"
								class="easyui-datebox" size="14" data-options="editable : false"  
								/>
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
								value="<fmt:formatDate value="${ctorder.createTime}" pattern="yyyy-MM-dd"/>"
								class="easyui-datebox" size="14" data-options="editable : false"  
								/>
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">更新日期 </label>
						</td>	
						<td>
								<input type="text" 
								id="updateTime" 
								name="updateTime" 
								value="<fmt:formatDate value="${ctorder.updateTime}" pattern="yyyy-MM-dd"/>"
								class="easyui-datebox" size="14" data-options="editable : false"  
								/>
						</td>						   
					</tr>
		
				<tr>
					<td colspan="2">
						<input id="submitButton" name="submitButton" type="button" onclick="ctorder_submit();"  value="提交" />	
					</td>
				<tr>			 
			</table>	   
		</div>	
	</form>
	<script type="text/javascript">
		
    function ctorder_submit(){
    	$.ajax({ 
    			url: "<c:url value='/ctorder/saveCtOrder.html'/>", 
    			data: $("#editCtOrderForm").serialize(),
    			type:"post",
    			dataType:"json",
    			success: function(ret){
    	   	 		if(ret.code==="0"){
    	   	 			$.messager.confirm("保存成功",
    	   	 				           '是否继续添加？', 
    	   	 				           function(r){
						   	   			   if(r==false){
						   	   				$("#editCtOrderDiv").dialog("close");
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