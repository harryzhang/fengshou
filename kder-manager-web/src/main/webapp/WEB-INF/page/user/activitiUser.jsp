<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>审计定制导出</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache" />

<jsp:include page="../common_easyui_cus.jsp"></jsp:include>

<script type="text/javascript" src="<c:url value='/js/user/activityUser.js'/>"></script>

</head>
<body style="background: #ffffff;">
	<table cellspacing="0" cellpadding="0" style="width: 100%;border-top: 1px solid #e0ecff;">
		<tr style="height: 35px;margin: 4px;">
			
			<td style="border-bottom: 1px solid #e0ecff;width: 90%;">
				激活用户：<input type="text" id="acitivit_userName" value="">
			<a href="javascript:void(0);" onclick="acitivitUserName();" class="easyui-linkbutton" iconCls="icon-edit" plain="true">激活</a></td>
		</tr>
	</table>

</body>
</html>