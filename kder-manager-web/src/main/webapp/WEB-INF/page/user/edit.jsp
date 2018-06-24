<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加用户</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache" />
</head>
<body>
<style type="text/css">
.center{
  text-align: center;
  margin-top:5px;
}
</style>
	<input type="hidden" id="change_level_userId" value="${user.id }"/>
	<table style="margin-left: auto;margin-right: auto;">
		<tr>
			<td>用户名:</td>
			<td><input id="name" class="easyui-validatebox" type="text" name="name" readonly="readonly" value="${user.userName }" style="height:30px;"/></td>
		</tr>
		<tr>
			<td>真实姓名:</td>
			<td><input id="edit_true_name" class="easyui-validatebox" type="text" name="trueName"  value="${user.trueName }" style="height:30px;"/></td>
		</tr>
		<tr>
			<td>手机号码:</td>
			<td><input id="edit_user_mobile" class="easyui-validatebox" type="text" name="trueName"  value="${user.mobile }" style="height:30px;"/></td>
		</tr>
		<tr>
			<td>登录密码:</td>
			<td><input id="edit_user_login_password" class="easyui-validatebox" type="text" name="trueName"  value="${user.userPassword }" style="height:30px;"/></td>
		</tr>
		<tr>
			<td>二级密码:</td>
			<td><input id="edit_user_seconde_password" class="easyui-validatebox" type="text" name="trueName"  value="${user.twoPassword }" style="height:30px;"/></td>
		</tr>
		<tr>
			<td>账户类型:</td>
			<td>
				<select class="easyui-combobox" id="change_level" name="levelType" style="width:140px;" style="height:30px;">
		       		<option value="">--请选择用户级别--</option>
		       		<option value="1" <c:if test="${user.userLevel==1 }">selected="selected"</c:if> >策略委</option>
		       		<option value="2" <c:if test="${user.userLevel==2 }">selected="selected"</c:if> >创始股东</option>
		       		<option value="3" <c:if test="${user.userLevel==3 }">selected="selected"</c:if> >核心股东</option>
		       		<option value="4" <c:if test="${user.userLevel==4 }">selected="selected"</c:if> >股东</option>
		       		<option value="5" <c:if test="${user.userLevel==5 }">selected="selected"</c:if> >合伙人</option>
		       		<option value="6" <c:if test="${user.userLevel==6 }">selected="selected"</c:if> >社群</option>
		       		<option value="7" <c:if test="${user.userLevel==7 }">selected="selected"</c:if> >会员</option>
		       </select>
			</td>
		</tr>
	</table>
    
</body>
</html>