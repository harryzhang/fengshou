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
							<label for="name">客户姓名</label>
						</td>	
						<td>
							<input type="text" id="userName" name="userName" value="${ctprivatecust.userName}"/>
						</td>											
					</tr>
					<tr>	
						<td align="right">
							<label for="name">客户手机号码</label>
						</td>	
						<td>
							<input type="text" id="phone" name="phone" value="${ctprivatecust.phone}"/>
						</td>
					</tr>
					<tr>	
						<td align="right">
							<label for="name">意向单类型</label>
						</td>	
						<td>
							
								<input size="20" 
								   class="easyui-combobox" 
								   id="privateCustType" 
								   name="privateCustType" 
								   value="${ctprivatecust.privateCustType}"
								   data-options="panelHeight:'90',
												valueField: 'value', 
												textField: 'text', 
												data: [{ text: '私人定制', value: '1' },
													   { text: '企业团购', value: '2' }]"
								/>
						</td>
					</tr>
					<tr>	
						<td align="right">
							<label for="name">客户性别</label>
						</td>	
						<td>
							<input size="20" 
								   class="easyui-combobox" 
								   id="gender" 
								   name="gender" 
								   value="${ctprivatecust.gender}"
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
							<label for="name">意向单状态</label>
						</td>	
						<td>
							<input size="20" 
							   class="easyui-combobox" 
							   id="status" 
							   name="status" 
							   value="${ctprivatecust.status}"
							   data-options="panelHeight:'90',
											valueField: 'value', 
											textField: 'text', 
											data: [{ text: '草稿', value: '1' },
												   { text: '作废', value: '2' },
												   { text: '已转订单', value: '3' }]"
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
								value="<fmt:formatDate value="${ctprivatecust.createTime}" pattern="yyyy-MM-dd"/>"
								class="easyui-datebox" size="14" data-options="editable : false"
								/>
						</td>
					</tr>
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