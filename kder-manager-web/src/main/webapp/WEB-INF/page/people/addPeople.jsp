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
<form id="editPeopleForm" method="post" action="<c:url value='people/savePeople.html'/>"> 
		<div>
		
			<table width="100%" border="0" align="center" cellpadding="3">			  
					<input type="hidden" id="peopleId" name="peopleId" value="${people.peopleId}"/>
					<tr>	
						<td align="right">
							<label for="name">手机号码</label>
						</td>	
						<td>
								<input type="text" id="peoplePhone" name="peoplePhone" value="${people.peoplePhone}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">姓名</label>
						</td>	
						<td>
								<input type="text" id="peopleName" name="peopleName" value="${people.peopleName}"/>												
						</td>						   
					</tr>
					
					<tr>	
						<td align="right">
							<label for="name">注册日期</label>
						</td>	
						<td>
								<input type="text" 
								id="peopleDatetime" 
								name="peopleDatetime" 
								value="<fmt:formatDate value="${people.peopleDatetime}" pattern="yyyy-MM-dd"/>"
								class="easyui-datebox" size="14" data-options="editable : true"  
								/>
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">邮箱</label>
						</td>	
						<td>
								<input type="text" id="peopleMail" name="peopleMail" value="${people.peopleMail}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">状态</label>
						</td>	
						<td>
								<input type="text" id="peopleState" name="peopleState" value="${people.peopleState}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">身份证号码</label>
						</td>	
						<td>
								<input type="text" id="peopleCode" name="peopleCode" value="${people.peopleCode}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">是否已验证身份证号码</label>
						</td>	
						<td>
							<input type="text" id="peopleCodesenddate" name="peopleCodesenddate" value="${people.peopleCodesenddate}"/>
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">是否已验证手机号码</label>
						</td>	
						<td>
								<input type="text" id="peoplePhonecheck" name="peoplePhonecheck" value="${people.peoplePhonecheck}"/>												
						</td>						   
					</tr>
					<tr>	
						<td align="right">
							<label for="name">是否已验证邮箱</label>
						</td>	
						<td>
								<input type="text" id="peopleMaillcheck" name="peopleMaillcheck" value="${people.peopleMaillcheck}"/>												
						</td>						   
					</tr>
		
				<tr>
					<td colspan="2">
						<input id="submitButton" name="submitButton" type="button" onclick="people_submit();"  value="提交" />	
					</td>
				<tr>			 
			</table>	   
		</div>	
	</form>
	<script type="text/javascript">
		
    function people_submit(){
    	$.ajax({ 
    			url: "<c:url value='/people/savePeople.html'/>", 
    			data: $("#editPeopleForm").serialize(),
    			type:"post",
    			dataType:"json",
    			success: function(ret){
    	   	 		if(ret.code==="0"){
    	   	 			$.messager.confirm("保存成功",
    	   	 				           '是否继续添加？', 
    	   	 				           function(r){
						   	   			   if(r==false){
						   	   				$("#editPeopleDiv").dialog("close");
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