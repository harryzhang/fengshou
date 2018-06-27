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
								<input type="text" id="userName" name="userName" value="${ordercommission.userName}"/>
								<input type="button" onclick="javascript:commonChooseDialog('userId','userName','选择业务员','MANAGER_PEOPLE');" value="选择业务员"/>
																				
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">保单</label>
						</td>	
						<td>
								<input type="text" id="orderId" name="orderId" value="${ordercommission.orderId}"/>
								<input type="text" id="orderNo" name="orderNo" value="${ordercommission.orderNo}"/>
								<input type="button" onclick="javascript:commonChooseDialog('userId','userName','选择保单','ORDER');" value="选择保单"/>												
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
							<label for="name">是否有效</label>
						</td>	
						<td>
								<input size="20" 
								       class="easyui-combobox" 
								       id="status" 
								       name="status" 
									   value="${ordercommission.status}"
									   data-options="panelHeight:'90',
							 						valueField: 'value', 
							 						textField: 'text', 
							 						data: [{ text: '待审批', value: '1' },
							 							   { text: '审批中', value: '2' },
							 							   { text: '已审批', value: '3' },
							 							   { text: '已发放', value: '4' },
							 							   { text: '作废', value: '5' }]"
								/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">审批状态</label>
						</td>	
						<td>
								<input size="20" 
								       class="easyui-combobox" 
								       id="auditStatus" 
								       name="auditStatus" 
									   value="${ordercommission.auditStatus}"
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
								<input type="text" id="auditId" name="auditId" value="${ordercommission.auditId}" readonly="readonly"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">创建人ID</label>
						</td>	
						<td>
								<input type="text" id="createBy" name="createBy" value="${ordercommission.createBy}" readonly="readonly"/>												
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
								<input type="text" id="updateBy" name="updateBy" value="${ordercommission.updateBy}" readonly="readonly"/>												
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
		var url="<c:url value='/choose/index.html?chooseType='/>"+chooseType+"&retId="+retId+"&retText="+retText+"&=dialogDivId"+dialogDivId;
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