<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>编辑订单</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache" />
<jsp:include page="../common_easyui_cus.jsp"></jsp:include>
</head>
<body>

<!-- 内容 -->
<form id="editCtOrderForm" method="post" action="<c:url value='ctorder/saveCtOrder.html'/>"> 
		
<style>
	.window{
		background:#fff;
	}
	.panel-title{
		border: 1px solid #95b8e7;
	    border-bottom: 0;
	    position: relative;
	    padding: 3px 5px;
	    top: 6px;
	}
	.panel-tool{
		display: none;
	}
    #div1{
        min-width: 1400px;
    }
	#div1 .header{
		background: #f4f4f4;
		height:28px;
    	padding: 3px 0 2px;
    	width: 100%;
    	border-bottom:1px solid #ccc;
	}
	.l_btn_size {
	    color: #95b8e7;
	    border-color: #95b8e7;
	    background: transparent;
	}
	.l_btn_size:visited, .l_btn_size:hover {
	    color: #fff;
	    border-color: #95b8e7;
	    background: #95b8e7;
	}
	.quotaModule, .personalMsg{		
		width: 90%;  	
		margin-top:30px;
	}
	
	.div1-table{
		width: 100%;
	}
	.div1-table thead{
	    background: #dce1f8;
	    height: 30px;
	    border: 1px solid #dce1f8;
	}
	.div1-table thead tr td{
	    padding: 5px;
	}
	.div1-table thead tr td span{
	    color: #0e2d5f;
	    font-size:10px;
	}
	.table-body{
		padding: 30px 0;
    	display: block;
    	border: 1px solid #95b8e7;
   	    width: 100%;
   	    margin-top: -2px;
	}
	.div1-table tbody tr:first-child{
		margin-top: 20px;	   
	}
	.div1-table tbody tr:last-child{
		margin-bottom: 20px;
	}
	.div1-table tbody tr td{
		text-indent: 10px;
	    padding: 10px;
        min-width: 300px;
	}
    .div1-table tbody tr td b{
        font-weight: normal;
        color: #333;
    }
	.personalMsg{
		margin-top: 30px;
	}
    #tab4 a{
        display: inline-block;
        padding: 0 10px 30px 0;
    }
</style>
<div id = "div1">
	<!-- 隐藏id-->
	<input type="hidden" id="orderId" name="orderId" value="${ctorder.orderId}"/>
	<input type="hidden" id="privateCustId" name="privateCustId" value="${ctorder.privateCustId}"/>
						
	<!-- 投保人信息 -->
	<div class='quotaModule'>
		<table class="div1-table"> 
			<thead >
				<tr><td colspan="3"><span><b>投保人信息</b>&nbsp;</span></td>
				</tr>
			</thead>
			<tbody class="table-body">       
				<tr style="width:90%;height:35px;"> 
					<td style="border:0;width:90%;font-size:10px;" colspan="3"><b>投保人: </b>
					<font style="color:#000;font-weight:bold;">
						<input type="text" id="userId" name="userId" value="${ctorder.userId}" readonly="readonly"/>
						<input type="text" id="userName" name="userName" value="${ctorder.userName}"/>
						<input type="button" onclick="javascript:commonChooseDialog('userId','userName','选择投保人','PEOPLE');" value="选择投保人"/>	
					</font>
					</td>					
				</tr>
				<tr style="width:90%;height:35px;">					
					<td style="border:0;width:25%;font-size:10px;"><b>投保人证件号码: </b>
					   <input type="text" id="userCertNo" name="userCertNo" value="${ctorder.userCertNo}"/>
					</td> 
					<td style="border:0;width:25%;font-size:10px;"><b>投保人证件类别: </b>
						<font style="color:#000;font-weight:bold;">  
						   <input size="20" 
								   class="easyui-combobox" 
								   id="userCertType" 
								   name="userCertType" 
								   value="${ctorder.userCertType}"
								   data-options="panelHeight:'90',
												valueField: 'value', 
												textField: 'text', 
												data: [{ text: '身份证', value: '0' },
													   { text: '港澳通行证', value: '2' }]"
							/>
						</font>
					</td> 
					<td style="border:0;width:25%;font-size:10px;" colspan="2"><b>投保人地址: </b>
						<font style="color:#000;font-weight:bold;"> 
						   <input type="text" id="userAddress" name="userAddress" value="${ctorder.userAddress}"/>
						</font>
					</td> 
				</tr>
				<tr style="width:90%;height:35px;">            
					<td style="border:0;width:25%;font-size:10px;"><b>投保人手机号: </b>
						<font style="color:#000;font-weight:bold;">
							<input type="text" id="userPhone" name="userPhone" value="${ctorder.userPhone}"/>
						</font>
					</td>
					<td style="border:0;width:25%;font-size:10px;"><b>投保人生日：</b>
					<font style="color:#000;font-weight:bold;">  
						<input type="text" 
								id="userBirth" 
								name="userBirth" 
								value="${ctorder.userBirth}"
								class="easyui-datebox" size="14" data-options="editable : false"  
								/>
					</font>
					</td> 
					<td style="border:0;width:25%;font-size:10px;"></td>
					<td style="border:0;width:25%;font-size:10px;"></td>
				</tr>        
			</tbody>        
		</table>
		
	</div>
	<!-- 投保人信息 end-->

	<!--被保人信息 -->
	<div class='quotaModule'>
		<table class="div1-table"> 
			<thead>
				<tr><td colspan="3"><span"><b>被保人信息</b>&nbsp;</span></td></tr>
			</thead>
			<tbody class="table-body">
			 <tr style="width:90%;height:35px;"> 
				<td  style="border:0;width:25%;font-size:10px;"><b>跟投保是同一人: </b>
					<font style="color:#000;font-weight:bold;">
						<input size="20" 
							   class="easyui-combobox" 
							   id="isSame" 
							   name="isSame" 
							   value="${ctorder.isSame}"
							   data-options="panelHeight:'90',
											valueField: 'value', 
											textField: 'text', 
											data: [{ text: '是', value: 'true' },
												   { text: '否', value: 'false' }]"
						/>
					</font>
				</td> 
				<td style="border:0;width:25%;font-size:10px;"><b>被保人姓名：</b>
					<font style="color:#000;font-weight:bold;">  
						<input type="text" id="recognizeeName" name="recognizeeName" value="${ctorder.recognizeeName}"/>	
					</font>
				</td> 
				<td  style="border:0;width:25%;font-size:10px;"><b>被保人生日: </b>
					<font style="color:#000;font-weight:bold;">  
					   <input type="text" 
							id="recognizeeBirth" 
							name="recognizeeBirth" 
							value="<fmt:formatDate value="${ctorder.recognizeeBirth}" pattern="yyyy-MM-dd"/>"
							class="easyui-datebox" size="14" data-options="editable : false" 
							/>
					</font>
				</td> 				
			</tr>        
			<tr style="width:90%;height:35px;"> 
				<td style="border:0;width:25%;font-size:10px;"><b>被保人证件类型： </b>
					<font style="color:#000;font-weight:bold;">
						<input size="20" 
							   class="easyui-combobox" 
							   id="recognizeeCertType" 
							   name="recognizeeCertType" 
							   value="${ctorder.recognizeeCertType}"
							   data-options="panelHeight:'90',
											valueField: 'value', 
											textField: 'text', 
											data: [{ text: '身份证', value: '0' },
												   { text: '港澳通行证', value: '2' }]"
								/>
					</font>
				</td>
				<td  style="border:0;width:25%;font-size:10px;"><b>被保人证件号: </b>
					<font style="color:#000;font-weight:bold;">
						<input type="text" id="recognizeeCertNo" name="recognizeeCertNo" value="${ctorder.recognizeeCertNo}"/>
					</font>
				</td> 
				<td style="border:0;width:25%;font-size:10px;"><b>被保人手机号：</b>
					<font style="color:#000;font-weight:bold;">  
						<input type="text" id="recognizeePhone" name="recognizeePhone" value="${ctorder.recognizeePhone}"/>	
					</font>
				</td> 
				<td style="border:0;width:25%;font-size:10px;"></td> 
			</tr>
				
			<tr style="width:90%;height:35px;">
				<td  style="border:0;width:25%;font-size:10px;"><b>被保人地址: </b>
					<font style="color:#000;font-weight:bold;">  
					   <input type="text" id="recognizeeAddress" name="recognizeeAddress" value="${ctorder.recognizeeAddress}"/>
					</font>
				</td> 
				<td style="border:0;width:25%;font-size:10px;"><b>被保人性别： </b>
					<font style="color:#000;font-weight:bold;">
						<input size="20" 
							   class="easyui-combobox" 
							   id="recognizeeGender" 
							   name="recognizeeGender" 
							   value="${ctorder.recognizeeGender}"
							   data-options="panelHeight:'90',
											valueField: 'value', 
											textField: 'text', 
											data: [{ text: '男', value: '男' },
												   { text: '女', value: '女' }]"
						/>
					</font>
				</td>			
				<td style="border:0;width:25%;font-size:10px;"><b>被保是否有社保： </b>
					<font style="color:#000;font-weight:bold;">
						<input size="20" 
							   class="easyui-combobox" 
							   id="recognizeeSecurity" 
							   name="recognizeeSecurity" 
							   value="${ctorder.recognizeeSecurity}"
							   data-options="panelHeight:'90',
											valueField: 'value', 
											textField: 'text', 
											data: [{ text: '有', value: '0' },
												   { text: '无', value: '1' }]"
						/>
					</font>
				</td>
				<td style="border:0;width:25%;font-size:10px;"></td> 
			</tr>
			</tbody>
		</table>
	</div>
	<!--被保人信息 end -->

	<!--投保产品信息 -->
	<div class='personalMsg'>
		<table class="div1-table"> 
			<thead><tr><td colspan="3"><span"><b>投保产品信息</b>&nbsp;
			</span></td></tr>
			</thead>
			<tbody class="table-body">
			 <tr style="width:90%;height:35px;"> 
				<td  style="border:0;width:90%;font-size:10px;" colspan="3"><b>保险公司: </b>
					<font style="color:#000;font-weight:bold;">
						<input type="text" id="policyCompId" name="policyCompId" value="${ctorder.policyCompId}" readonly="readonly"/>
						<input type="text" id="policyCompany" name="policyCompany" value="${ctorder.policyCompany}"/>
						<input type="button" onclick="javascript:commonChooseDialog('policyCompId','policyCompany','选择保险公司','POLICY_COMPANY');" value="选择保险公司"/>
					</font>
				</td>
			</tr>
			<tr style="width:90%;height:35px;"> 				
				<td style="border:0;width:90%;font-size:10px;" colspan="3"><b>机构：</b>
					<font style="color:#000;font-weight:bold;">  
						<input type="text" id="orgId" name="orgId" value="${ctorder.orgId}" readonly="readonly"/>
						<input type="text" id="orgCompany " name="orgCompany" value="${ctorder.orgCompany}"/>
						<input type="button" onclick="javascript:commonChooseDialog('orgId','orgCompany','选择机构','ORG');" value="选择机构"/>
					</font>
				</td> 
			</tr>
			
			<tr style="width:90%;height:35px;"> 
				<td  style="border:0;width:90%;font-size:10px;" colspan="3"><b>产品名称: </b>
					<font style="color:#000;font-weight:bold;">  
						<input type="text" id="prodId" name="prodId" value="${ctorder.prodId}" readonly="readonly"/>
						<input type="text" id="productName" name="productName" value="${ctorder.productName}"/>
						<input type="button" onclick="javascript:commonChooseDialog('prodId','productName','选择产品','PROD');" value="选择产品"/>											
					</font>
				</td> 
				
			</tr>
			
			
			<tr style="width:90%;height:35px;">
				<td style="border:0;width:25%;font-size:10px;"><b>产品编码： </b>
					<font style="color:#000;font-weight:bold;">
						<input type="text" id="productCode" name="productCode" value="${ctorder.productCode}"/>
					</font>
				</td>			
				<td style="border:0;width:25%;font-size:10px;"><b>险种： </b>
					<font style="color:#000;font-weight:bold;">
						<input size="20" 
							   class="easyui-combobox" 
							   id="policyType" 
							   name="policyType" 
							   value="${ctorder.policyType}"
							   data-options="panelHeight:'90',
											valueField: 'value', 
											textField: 'text', 
											data: [{ text: '车险', value: '1' },
												   { text: '非车险', value: '2' },
												   { text: '寿险', value: '3' }]"
						/>
					</font>
				</td> 
			</tr>
			</tbody>
		</table>
	</div>
	<!--投保产品信息  end-->

	<!--保单基本信息 -->
	<div class='personalMsg'>
		<table class="div1-table"> 
			<thead><tr><td colspan="3"><span"><b>保单基本信息</b>&nbsp;
			</span></td></tr>
			</thead>
			<tbody class="table-body">
			 <tr style="width:90%;height:35px;"> 
				<td  style="border:0;width:25%;font-size:10px;"><b>保单号: </b>
					<font style="color:#000;font-weight:bold;">
					   <input type="text" id="orderNo" name="orderNo" value="${ctorder.orderNo}" />
					</font>
				</td> 
				<td style="border:0;width:25%;font-size:10px;"><b>保单总金额：</b>
					<font style="color:#000;font-weight:bold;">  
						<input type="text" id="orderAmt" name="orderAmt" value="${ctorder.orderAmt}"/>
					</font>
				</td> 
				<td  style="border:0;width:25%;font-size:10px;"><b>总保额：</b>
					<font style="color:#000;font-weight:bold;">  
						<input type="text" id="policyAmt" name="policyAmt" value="${ctorder.policyAmt}"/>
					</font>			
				</td> 				
			</tr>
			
			<tr style="width:90%;height:35px;"> 
				<td  style="border:0;width:25%;font-size:10px;"><b>保障期限: </b>
					<font style="color:#000;font-weight:bold;">  
					   <input type="text" id="orderPeriod" name="orderPeriod" value="${ctorder.orderPeriod}"/>
					</font>
				</td> 
				<td style="border:0;width:25%;font-size:10px;"><b>保障起始日期： </b>
				<font style="color:#000;font-weight:bold;">
					<input type="text" 
							id="startTime" 
							name="startTime" 
							value="<fmt:formatDate value="${ctorder.startTime}" pattern="yyyy-MM-dd"/>"
							class="easyui-datebox" size="14" data-options="editable : false"  
							/>
				</font>
				</td> 
				<td style="border:0;width:25%;font-size:10px;"><b>保障截止日期： </b>
				<font style="color:#000;font-weight:bold;">
					<input type="text" 
							id="endTime" 
							name="endTime" 
							value="<fmt:formatDate value="${ctorder.endTime}" pattern="yyyy-MM-dd"/>"
							class="easyui-datebox" size="14" data-options="editable : false" 
							/>
				</font>
				</td> 								
			</tr>
			
			<tr style="width:90%;height:35px;"> 
				<td style="border:0;width:25%;font-size:10px;"><b>投保日期： </b>
				<font style="color:#000;font-weight:bold;">
					<input type="text" 
							id="createTime" 
							name="createTime" 
							value="<fmt:formatDate value="${ctorder.createTime}" pattern="yyyy-MM-dd"/>"
							class="easyui-datebox" size="14" data-options="editable : false"  
							/>
				</font>
				</td>
				<td  style="border:0;width:25%;font-size:10px;"><b>订单状态: </b>
					<font style="color:#000;font-weight:bold;">  
					   <input size="20" 
							   class="easyui-combobox" 
							   id="orderStatus" 
							   name="orderStatus" 
							   value="${ctorder.orderStatus}"
							   data-options="panelHeight:'90',
											valueField: 'value', 
											textField: 'text', 
											data: [{ text: '草稿', value: '1' },
												   { text: '审批中', value: '2' },
												   { text: '已生效订单', value: '3' },
												   { text: '在续订单', value: '4' },
												   { text: '已完成订单', value: '5' }]"
						/>
					</font>
				</td>
				<td  style="border:0;width:25%;font-size:10px;"><b>备注: </b>
					<font style="color:#000;font-weight:bold;">  
					   <input type="text" id="remark" name="remark" value="${ctorder.remark}"/>
					</font>
				</td> 
				<td style="border:0;width:25%;font-size:10px;"></td>
			</tr>
			<tr style="width:90%;height:35px;"> 
				<td style="border:0;width:25%;font-size:10px;"><b>订单来源： </b>
				<font style="color:#000;font-weight:bold;">
					<input size="20" 
							   class="easyui-combobox" 
							   id="orderFrom" 
							   name="orderFrom" 
							   value="${ctorder.orderFrom}"
							   data-options="panelHeight:'90',
											valueField: 'value', 
											textField: 'text', 
											data: [{ text: '线上', value: '1' },
												   { text: '线下', value: '2' }]"
						/>
				</font>
				</td>
				<td  style="border:0;width:25%;font-size:10px;">
				</td>
				<td  style="border:0;width:25%;font-size:10px;">
				</td> 
				<td style="border:0;width:25%;font-size:10px;"></td>
			</tr>					
			</tbody>
		</table>
	</div>
	<!--保单基本信息 end -->

	<!--支付信息信息 -->
	<div class='personalMsg'>
		<table class="div1-table"> 
			<thead><tr><td colspan="3"><span"><b>支付信息</b>&nbsp;
			</span></td></tr>
			</thead>
			<tbody class="table-body">
				<tr style="width:90%;height:35px;"> 
					<td  style="border:0;width:25%;font-size:10px;"><b>支付方式: </b>
						<font style="color:#000;font-weight:bold;">
						   <input size="20" 
								   class="easyui-combobox" 
								   id="payType" 
								   name="payType" 
								   value="${ctorder.payType}"
								   data-options="panelHeight:'90',
												valueField: 'value', 
												textField: 'text', 
												data: [{ text: '月付', value: '1' },
													   { text: '季付', value: '2' },
													   { text: '年付', value: '3' },
													   { text: '长付', value: '4' }]"
								/>
						</font>
					</td> 
					<td style="border:0;width:25%;font-size:10px;"><b>支付期限：</b>
						<font style="color:#000;font-weight:bold;">  
							<input 	id="payPeriod" 
								   name="payPeriod" 
								   value="${ctorder.payPeriod}"
							/>
						</font>
					</td> 
					<td  style="border:0;width:25%;font-size:10px;">
					</td>
				</tr>	
			</tbody>
		</table>
	</div>
	<!--支付信息 end -->

	<!--业务员和佣金 -->
	<div class='personalMsg'>
		<table class="div1-table"> 
			<thead><tr><td colspan="3"><span"><b>业务员和佣金信息</b>&nbsp;
			</span></td></tr>
			</thead>
			<tbody class="table-body">
			 <tr style="width:90%;height:35px;"> 
				<td  style="border:0;width:25%;font-size:10px;" colspan="3"><b>业务员: </b>
					<font style="color:#000;font-weight:bold;">
						<input type="text" id="salesId" name="salesId" value="${ctorder.salesId}" readonly="readonly"/>
						<input type="text" id="salesMan" name="salesMan" value="${ctorder.salesMan}"/>
						<input type="button" onclick="javascript:commonChooseDialog('salesId','salesMan','选择业务员','MANAGER_PEOPLE');" value="选择业务员"/>
										
					</font>
				</td>			
			</tr>
			<tr style="width:90%;height:35px;">
				<td style="border:0;width:25%;font-size:10px;"><b>佣金：</b>
					<font style="color:#000;font-weight:bold;">  
						<input type="text" id="commissionAmt" name="commissionAmt" value="${ctorder.commissionAmt}"/>	
					</font>
				</td> 
				<td  style="border:0;width:25%;font-size:10px;"><b>佣金比率：</b>
					<font style="color:#000;font-weight:bold;">  
						<input type="text" id="commissionRate" name="commissionRate" value="${ctorder.commissionRate}"/>
					</font>					
				</td> 
				<td style="border:0;width:25%;font-size:10px;"><b>代理费：</b>
					<font style="color:#000;font-weight:bold;">  
						<input type="text" id="proxyFee" name="proxyFee" value="${ctorder.proxyFee}"/>	
					</font>
				</td>			
			</tr>
			<tr style="width:90%;height:35px;">				
				<td style="border:0;width:25%;font-size:10px;"><b>代理费比率：</b>
					<font style="color:#000;font-weight:bold;">  
						<input type="text" id="proxyRate" name="proxyRate" value="${ctorder.proxyRate}"/>
					</font>
				</td>
				<td style="border:0;width:25%;font-size:10px;"></td>
				<td style="border:0;width:25%;font-size:10px;"></td>
				<td style="border:0;width:25%;font-size:10px;"></td>
			</tr>			
			</tbody>
		</table>
	</div>
	<!--业务员和佣金 end -->

	<!--审核信息 -->
	<div class='personalMsg'>
		<table class="div1-table"> 
			<thead><tr><td colspan="3"><span"><b>审核信息</b>&nbsp;
			</span></td></tr>
			</thead>
			<tbody class="table-body">
			 <tr style="width:90%;height:35px;"> 
				<td  style="border:0;width:25%;font-size:10px;"><b>审批状态: </b>
					<font style="color:#000;font-weight:bold;">
						<input size="20" 
							   class="easyui-combobox" 
							   id="auditStatus" 
							   name="auditStatus" 
							   value="${ctorder.auditStatus}"
							   data-options="panelHeight:'90',
											valueField: 'value', 
											textField: 'text', 
											data: [{ text: '待审批', value: '1' },
												   { text: '审批中', value: '2' },
												   { text: '已审批', value: '3' },
												   { text: '审批不通过', value: '4' }]"
						/>			
					</font>
				</td> 
				<td style="border:0;width:25%;font-size:10px;"><b>审批日期：</b>
					<font style="color:#000;font-weight:bold;">  
						<input type="text" 
								id="auditDate" 
								name="auditDate" 
								value="<fmt:formatDate value="${ctorder.auditDate}" pattern="yyyy-MM-dd"/>"
								class="easyui-datebox" size="14" data-options="editable : false"  
								/>
					</font>
				</td> 
				<td  style="border:0;width:25%;font-size:10px;"><b>最后更新日期：</b>
					<font style="color:#000;font-weight:bold;">  
						<input type="text" 
								id="updateTime" 
								name="updateTime" 
								value="<fmt:formatDate value="${ctorder.updateTime}" pattern="yyyy-MM-dd"/>"
								class="easyui-datebox" size="14" data-options="editable : false"  
								/>
					</font>					
				</td>
				<td style="border:0;width:25%;font-size:10px;"></td>				
			</tr>				
			</tbody>
		</table>
	</div>
	<!--审核信息 end-->

	<!-- tab 页-->
	<div class="cardbox" >
		<div style="height:41px;">
			<ul id="oneul">
				<li><a href="#" id="lia1" class="lia" onclick="checked(1)" style="background-color:#95b8e7;color:#fff;text-decoration: none;">车险资料</a></li>
				<li><a href="#" id="lia2" class="lia" onclick="checked(2)" >非车险资料</a></li>
				<li><a href="#" id="lia3" class="lia" onclick="checked(3)">寿险资料</a></li>
			</ul>
		</div>
		
		<!--车险资料-->
		<div id="tab1" class="card" > 
			
				<table class="div1-table comDiv" > 			
					<tr style="width:100%;height:40px;"> 
						<td style="border:0;width:30%;font-size:10px;" colspan="3">
							<font style="color:#000;font-weight:bold;">车牌号
								<input type="text" id="cardNo" name="cardNo" value="${ctorder.cardNo}"/>	
							</font>
						</td> 
					</tr>
				</table>
		</div>
		<!-- 车险资料 end -->
		
		<!-- 非车险资料 -->
		<div id="tab2" class="card " style="display:none">
		
		</div>        
		<!--非车险资料 end-->
		
		
		<!--寿险资料-->
		<div id="tab3" class="card" style="display:none"> 
			
				<table class="div1-table comDiv" >
					<tr style="width:100%;height:45px;"> 
						<td style="border:0;width:33%;font-size:10px;"><b>单证号: </b>
							<font style="color:#000;font-weight:bold;">
								<input type="text" id="billNo" name="billNo" value="${ctorder.billNo}"/>
							</font>
						</td> 
						<td style="border:0;width:33%;font-size:10px;"><b>被保人数: </b>
							<font style="color:#000;font-weight:bold;">
								<input type="text" id="policyManCnt" name="policyManCnt" value="${ctorder.policyManCnt}"/>	
							</font>
						</td> 						
					</tr>							
					<tr style="width:100%;height:40px;"> 
						<td style="border:0;width:30%;font-size:10px;"><b>首期保费: </b>
							<font style="color:red;font-weight:bold;">
								<input type="text" id="firstPolicyFee" name="firstPolicyFee" value="${ctorder.firstPolicyFee}"/>
							</font>
						</td>
						<td style="border:0;width:33%;font-size:10px;"><b>续期保费: </b>
							<font style="color:#000;font-weight:bold;">
									<input type="text" id="nextPolicyFee" name="nextPolicyFee" value="${ctorder.nextPolicyFee}"/>
							</font>
						</td>   						
					</tr>
				</table>
		</div>
		<!-- 寿险资料 end -->
	</div>
	<!-- tab 页面 end -->
     
</div>

<style type="text/css">
div#div1 ul#oneul{
    list-style:none; /* 去掉ul前面的符号 */
    margin: 0px; /* 与外界元素的距离为0 */
    padding: 0px; /* 与内部元素的距离为0 */
    width: auto; /* 宽度根据元素内容调整 */
}
div#div1 ul#oneul li{
    float:left; /* 向左漂移，将竖排变为横排 */
}

div#div1 ul#oneul li a, div#div1 ul#oneul li a:visited{
    background-color: #dce1f8; /* 背景色 */
    color: #666; /* 文字颜色 */
    display: block; /* 此元素将显示为块级元素，此元素前后会带有换行符 */
    line-height: 1.8em; /* 行高 */
    padding: 8px 15px; /* 内部填充的距离 */
    text-decoration: none; /* 不显示超链接下划线 */
    white-space: nowrap; /* 对于文本内的空白处，不会换行，文本会在在同一行上继续，直到遇到 <br> 标签为止。 */
    font-size: 1.2rem;
}
/* div中的ul中的a样式(鼠标移动到元素中的样式) */
div#div1 ul#oneul li a:hover{
    background-color: #95b8e7; /* 背景色 */
    color: #fff; /* 文字颜色 */
    text-decoration: none; /* 不显示超链接下划线 */
}
/* div中的ul中的a样式(鼠标点击元素时的样式) */
div#div1 ul#oneul li a:active{
    background-color: #95b8e7; /* 背景色 */
    color: #fff; /* 文字颜色 */
    text-decoration: none; /* 不显示超链接下划线 */
}
#div1{
background-color: #fff !important;
}
.cardbox{
	background: transparent;
	padding-top: 30px;
    width: 90%;
}
.cardbox h1{
font-size: 18px;
color:#3F3F3F;
}
.cardbox h2{
font-size: 16px;
color:#3F3F3F;
}
.cardbox div.card{
    width:100%;
}
.comDiv{
    border:1px solid #95b8e7; 
}
div#detailLoanDiv{
background-color: #F5F5F5  !important;
}
.tagbox{
width:18px;
height:18px;
padding:2px;
background-color: #8C8282;
border:1px soild #ffffff;
margin: 1px;
float: left;
text-align: center;
vertical-align: middle;
font-size: 16px;
font-weight: bold;
}
.tagY{
color:#ffffff;
background-color: #68A886;
}
.tagN{
color:#ffffff;
background-color: #9E4E4E;
}
.ml10{margin-left: 10px;}
.red{color:red;}
.green{color:#217B03;}
.yellow{color:yellow;}
.l_btn_size{
margin-left:10px !important; 
text-decoration: none !important; 
padding: 4px 14px !important;
}
#propert_ul ul{
    list-style:none; /* 去掉ul前面的符号 */
    margin: 0px; /* 与外界元素的距离为0 */
    padding: 0px; /* 与内部元素的距离为0 */
    width: auto; /* 宽度根据元素内容调整 */
}
#person_ul ul{
    list-style:none; /* 去掉ul前面的符号 */
    margin: 0px; /* 与外界元素的距离为0 */
    padding: 0px; /* 与内部元素的距离为0 */
    width: auto; /* 宽度根据元素内容调整 */
}
.tab6-title{
    width: 100%;
}
.tab6-title td{
    padding-top: 60px !important;
}
.tab6-title td h1{
    color: #0e2d5f;
    text-align: left;
}
.tab6-content{
    border: 0;
    width: 50%;
    font-size: 10px;
}
.tab6-msg{
    width: 100%;
}
.tab6-msg td{
    padding-bottom: 60px !important;
}
.tab6-msg td p{
    color: #333;
    text-align: left;
}
</style>
<script type="text/javascript">
function checked(type){
         
    $(".lia").css("backgroundColor","#465c71");
    $(".lia").css("color","#dde4ec");
    var count = $(".lia").length;   
    for(var i=1;i<=count;i++){
        var tab =$("#tab"+i);
        var lia = $("#lia"+i);
        if(type == i){
            tab.css("display","block");
            lia.css("backgroundColor","#bfcbd6");
            lia.css("color","#465c71");
        }else{
            tab.css("display","none");
            lia.css("backgroundColor","#465c71");
            lia.css("color","#dde4ec");
        }
    }
   
}

/*
function getInspectResult(userId,loanId){
    var obj = {};
    obj.userId = userId;
    obj.loanId = loanId;
    var url = "/loan/getInspectResult.html?rand=" + Math.random();
    $.post(url,obj,function(data){
        $("#tab16").html(data);
    });
}
*/

</script>
		
</form>
<script type="text/javascript">
	
	/**
	 * 创建一个模态 Dialog
	 * 
	 * @param id divId
	 * @param _url Div链接
	 * @param _title 标题
	 * @param _width 宽度
	 * @param _height 高度
	 * @param _icon ICON图标
	 */
	function createModalDialog(id, _url, _title, _width, _height, _icon){
	    $("body").append("<div id='"+id+"' class='easyui-window'></div>");
	    if (_width == null)
	        _width = 800;
	    if (_height == null)
	        _height = 500;

	    $("#"+id).dialog({
	        title: _title,
	        width: _width,
	        height: _height,
	        cache: false,
	        iconCls: _icon,
	        href: _url,
	        collapsible: false,
	        minimizable:false,
	        maximizable: true,
	        resizable: false,
	        modal: true,
	        closed: true
	    });
	}
	
	function commonChooseDialog(retId,retText,_title,chooseType){
		var dialogDivId = "c_ch_w";
		var url="<c:url value='/choose/index.html?chooseType='/>"+chooseType+"&retId="+retId+"&retText="+retText+"&dialogDivId="+dialogDivId;
		//移除存在的Dialog
		$("#"+dialogDivId).remove();
		//先根据div的id删除，但界面元素还是会存在dialog div，还需执行dialog的销毁操作
		//$("#"+dialogDivId).dialog('destroy');
		//创建窗口
		createModalDialog(dialogDivId,url,_title, 600, 600);
		
		$("#"+dialogDivId).dialog('open');
	}
	
</script>

</body>
</html>