<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>审计定制导出</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache" />

<jsp:include page="../common_easyui_cus.jsp"></jsp:include>

<script type="text/javascript" src="<c:url value='/js/zreport/index.js'/>"></script>

</head>
<body style="background: #ffffff;">
	<table cellspacing="0" cellpadding="0" style="width: 100%;border-top: 1px solid #e0ecff;">
		<tr style="height: 35px">
			<td style="border-bottom: 1px solid #e0ecff">1</td>
			<td style="border-bottom: 1px solid #e0ecff;width: 90%;">陕西道生名下所有在库业务的借款人收款账户信息</td>
			<td style="border-bottom: 1px solid #e0ecff"><a href="javascript:void(0);" onclick="reportA();" class="easyui-linkbutton" iconCls="icon-edit" plain="true">导出</a></td>
		</tr>
		<tr style="height: 35px;margin: 4px;">
			<td style="border-bottom: 1px solid #e0ecff">2</td>
			<td style="border-bottom: 1px solid #e0ecff;width: 90%;">
				<input type="text" id="search_startDate" value="2018-02-28"  class="easyui-datebox" size="14" data-options="editable : false" />至
				<input type="text" id="search_endDate" value="2018-03-02"  class="easyui-datebox" size="14" data-options="editable : false" />期间，所有收款人为
				<input type="text" id="search_userName" value="杨士林">的业务明细清单
			</td>
			<td style="border-bottom: 1px solid #e0ecff"><a href="javascript:void(0);" onclick="reportB();" class="easyui-linkbutton" iconCls="icon-edit" plain="true">导出</a></td>
		</tr>
	</table>

</body>
</html>