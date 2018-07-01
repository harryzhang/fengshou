<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>订单</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache" />
<jsp:include page="../common_easyui_cus.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/icons.css'/>" />
<script type="text/javascript" src="<c:url value='/js/common/js/jquery-easyui-1.4.1/extension/jquery-easyui-datagridview/datagrid-detailview.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/ordercommission/ordercommission.js?v=${jsversion}'/>"></script>
<style type="text/css">
.tdfont{
	font-size: 12px;
}
</style>
</head>
<body class="easyui-layout">

<div id="body" region="center" > 
  <!-- 查询条件区域 -->
	<div id="search_areaOrderCommission"  class="easyui-panel" >
		<div id="conditon" >
			<form id="searchorderCommissionForm" style="margin-top:7px;margin-left:5px;" >
			      <table border="0">
			        <tr>
			          <td class="tdfont">查询条件:
			          	<input type="text" size="14" id="searchManagerName" name="searchManagerName" placeholder="业务员名称" >
			          	<input type="text" size="14" id="searchOrderNo" name="searchOrderNo" placeholder="保单编号" >
			          	<br>
			          	创建起始日期
			          	<input type="text" size="14"  class="easyui-datebox"  id="searchStartTime" name="searchStartTime" placeholder="创建起始日期" >
			          	至
			          	<input type="text" size="14"  class="easyui-datebox"  id="searchEndTime" name="searchEndTime" placeholder="创建起始日期" >
			          	
			          </td>
			          <td >
			              <a  href="javascript:void(0)" id="searchButton" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a> 
			              <a  href="javascript:void(0)" id="resetButton" class="easyui-linkbutton" iconCls="icon-reset" plain="true" >重置</a>
				      </td>
				      <td >
			              <a  href="javascript:to_export();" id="exportButton_bj" class="easyui-linkbutton" iconCls="icon-search" plain="true">导出</a> 
				      </td>
			        </tr>
			      </table>
		     </form>
	     </div>
    	<span id="openOrClose"></span> 
	</div>
  
  	<!-- 数据表格区域 -->
  <div id="tt_OrderCommission"></div>
  
</div>

  <div id="editOrderCommissionDiv"></div> 
  
  <script type="text/javascript">
  function to_export(exportType) {
      var exportIframe = document.createElement('iframe');  
      var query = $('#searchorderCommissionForm').serialize();
      query = query.replace(/(&|^)(\w*?\d*?\-*?_*?)*?=?((?=&)|(?=$))/g, '');
      exportIframe.src =httpUrl+"/ordercommission/export.html?&rand=" + Math.random()+"&"+query;
      exportIframe.style.display = 'none';
      document.body.appendChild(exportIframe);
  }
  </script>
   
</body>

</html>