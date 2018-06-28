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
					<input type="hidden" id="privateCustId" name="privateCustId" value="${ctorder.privateCustId}"/>
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
							<label for="name">保险公司</label>
						</td>	
						<td>
								<input type="text" id="policyCompId" name="policyCompId" value="${ctorder.policyCompId}" readonly="readonly"/>
								<input type="text" id="policyCompany" name="policyCompany" value="${ctorder.policyCompany}"/>
								<input type="button" onclick="javascript:commonChooseDialog('policyCompId','policyCompany','选择保险公司','POLICY_COMPANY');" value="选择保险公司"/>											
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">产品</label>
						</td>	
						<td>
								<input type="text" id="prodId" name="prodId" value="${ctorder.prodId}" readonly="readonly"/>
								<input type="text" id="productName" name="productName" value="${ctorder.productName}"/>
								<input type="button" onclick="javascript:commonChooseDialog('prodId','productName','选择产品','PROD');" value="选择产品"/>											
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">产品编码</label>
						</td>	
						<td>
								<input type="text" id="productCode" name="productCode" value="${ctorder.productCode}"/>
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">机构</label>
						</td>	
						<td>
								<input type="text" id="orgId" name="orgId" value="${ctorder.orgId}" readonly="readonly"/>
								<input type="text" id="orgCompany " name="orgCompany" value="${ctorder.orgCompany}"/>
								<input type="button" onclick="javascript:commonChooseDialog('orgId','orgCompany','选择机构','ORG');" value="选择机构"/>											
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">投保人</label>
						</td>	
						<td>
								<input type="text" id="userId" name="userId" value="${ctorder.userId}" readonly="readonly"/>
								<input type="text" id="userName" name="userName" value="${ctorder.userName}"/>
								<input type="button" onclick="javascript:commonChooseDialog('userId','userName','选择投保人','PEOPLE');" value="选择投保人"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">险种</label>
						</td>	
						<td>
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
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">支付方式</label>
						</td>	
						<td>
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
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">支付期限</label>
						</td>	
						<td>
								<input 							       
								       id="payPeriod" 
								       name="payPeriod" 
									   value="${ctorder.payPeriod}"
								/>
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">订单状态</label>
						</td>	
						<td>
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
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">被保是否有社保</label>
						</td>	
						<td>
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
																				
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">跟投保是同一人</label>
						</td>	
						<td>
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
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">业务员</label>
						</td>	
						<td>
								<input type="text" id="salesId" name="salesId" value="${ctorder.salesId}" readonly="readonly"/>
								<input type="text" id="salesMan" name="salesMan" value="${ctorder.salesMan}"/>
								<input type="button" onclick="javascript:commonChooseDialog('salesId','salesMan','选择业务员','MANAGER_PEOPLE');" value="选择业务员"/>
																				
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
							<label for="name">佣金比率</label>
						</td>	
						<td>
								<input type="text" id="commissionRate" name="commissionRate" value="${ctorder.commissionRate}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">代理费比率</label>
						</td>	
						<td>
								<input type="text" id="proxyRate" name="proxyRate" value="${ctorder.proxyRate}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">代理费</label>
						</td>	
						<td>
								<input type="text" id="proxyFee" name="proxyFee" value="${ctorder.proxyFee}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">车牌号</label>
						</td>	
						<td>
								<input type="text" id="cardNo" name="cardNo" value="${ctorder.cardNo}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">单证号</label>
						</td>	
						<td>
								<input type="text" id="billNo" name="billNo" value="${ctorder.billNo}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">被保人数</label>
						</td>	
						<td>
								<input type="text" id="policyManCnt" name="policyManCnt" value="${ctorder.policyManCnt}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">总保额</label>
						</td>	
						<td>
								<input type="text" id="policyAmt" name="policyAmt" value="${ctorder.policyAmt}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">首期保费</label>
						</td>	
						<td>
								<input type="text" id="firstPolicyFee" name="firstPolicyFee" value="${ctorder.firstPolicyFee}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">续期保费</label>
						</td>	
						<td>
								<input type="text" id="nextPolicyFee" name="nextPolicyFee" value="${ctorder.nextPolicyFee}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">备注</label>
						</td>	
						<td>
								<input type="text" id="remark" name="remark" value="${ctorder.remark}"/>												
						</td>						   
					</tr>
					<!-- 
					<tr>	
						<td align="right">
							<label for="name">项目Id</label>
						</td>	
						<td>
								<input type="text" id="projectId" name="projectId" value="${ctorder.projectId}"/>												
						</td>						   
					</tr>
					-->
					<tr>	
						<td align="right">
							<label for="name">审批状态</label>
						</td>	
						<td>
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
		
			</table>	   
		</div>	
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
		$("#"+dialogDivId).dialog('destroy');
		//创建窗口
		createModalDialog(dialogDivId,url,_title, 600, 600);
		
		$("#"+dialogDivId).dialog('open');
	}
	
</script>

</body>

</html>