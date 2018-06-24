<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>编辑保险公司</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache" />
<jsp:include page="../common_easyui_cus.jsp"></jsp:include>
</head>
<body>

<!-- 内容 -->
<form id="editPolicyCompanyForm" method="post" action="<c:url value='/policycompany/savePocilyCompany.html'/>"> 
		<div>
		
			<table width="100%" border="0" align="center" cellpadding="3">			  
					<input type="hidden" id="id" name="id" value="${policyCompany.id}"/>
					<tr>	
						<td align="right">
							<label for="name">公司名称</label>
						</td>	
						<td>
							<input type="text" id="policyName" name="policyName" value="${policyCompany.policyName}"/>												
						</td>
					</tr>
					<tr>	
						<td align="right">
							<label for="name">简称</label>
						</td>	
						<td>
							<input type="text" id="shortName" name="shortName" value="${policyCompany.shortName}"/>												
						</td>
					</tr>
					<tr>	
						<td align="right">
							<label for="name">官网地址</label>
						</td>	
						<td>
							<input type="text" id="homeUrl" name="homeUrl" value="${policyCompany.homeUrl}"/>												
						</td>
					</tr>
					<tr>	
						<td align="right">
							<label for="name">banner地址</label>
						</td>	
						<td>
							<input type="text" id="bannerUrl" name="bannerUrl" value="${policyCompany.bannerUrl}"/>												
						</td>
					</tr>
					<tr>	
						<td align="right">
							<label for="name">类别</label>
						</td>	
						<td>
							<input type="text" id="companyType" name="companyType" value="${policyCompany.companyType}"/>												
						</td>
					</tr>
					<tr>	
						<td align="right">
							<label for="name">联系人姓名</label>
						</td>	
						<td>
							<input type="text" id="contactName" name="contactName" value="${policyCompany.contactName}"/>												
						</td>
					</tr>
					<tr>	
						<td align="right">
							<label for="name">联系人手机号码</label>
						</td>	
						<td>
							<input type="text" id="contactPhone" name="contactPhone" value="${policyCompany.contactPhone}"/>												
						</td>
					</tr>
					<tr>	
						<td align="right">
							<label for="name">办公地址</label>
						</td>	
						<td>
							<input type="text" id="address" name="address" value="${policyCompany.address}"/>												
						</td>
					</tr>
					<tr>	
						<td align="right">
							<label for="name">注册地址</label>
						</td>	
						<td>
							<input type="text" id="companyRegAddress" name="companyRegAddress" value="${policyCompany.companyRegAddress}"/>												
						</td>
					</tr>
					<tr>	
						<td align="right">
							<label for="name">业务员</label>
						</td>	
						<td>
							<input type="text" id="managerName" name="managerName" value="${policyCompany.managerName}"/>												
						</td>
					</tr>
					<tr>	
						<td align="right">
							<label for="name">合作状态</label>
						</td>	
						<td>
							<input type="text" id="partnerStatus" name="partnerStatus" value="${policyCompany.partnerStatus}"/>												
						</td>
					</tr>
					<tr>	
						<td align="right">
							<label for="name">合作日期</label>
						</td>	
						<td>
							<input type="text" 
								id="partnerDate" 
								name="partnerDate" 
								value="<fmt:formatDate value="${policyCompany.partnerDate}" pattern="yyyy/MM/dd"/>"
								class="easyui-datebox" size="14" data-options="editable : true" formatter  
								/>												
						</td>
					</tr>
					<tr>	
						<td align="right">
							<label for="name">状态</label>
						</td>	
						<td>
							<input type="text" id="status" name="status" value="${policyCompany.status}"/>												
						</td>
					</tr>
			 	<tr>
					<td colspan="2">
						<input id="submitButton" name="submitButton" type="button" onclick="policycompany_sbtfcn();" value="提交" />	
					</td>
				<tr>				
			</table>	   
		</div>	
	</form>
	<script type="text/javascript">
    function policycompany_sbtfcn(){
    	$.ajax({ 
    			url: "<c:url value='/policycompany/savePolicyCompany.html'/>", 
    			data: $("#editPolicyCompanyForm").serialize(),
    			type:"post",
    			dataType:"json",
    			success: function(ret){
    	   	 		if(ret.code==="0"){    	   	 			
    	   	 			$.messager.confirm("保存成功",
    	   	 				           '是否继续添加？', 
    	   	 				           function(r){
						   	   			   if(r==false){
						   	   				$("#editPolicyCompanyDiv").dialog("close");
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