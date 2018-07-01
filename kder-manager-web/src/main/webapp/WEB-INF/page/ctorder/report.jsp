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
<script type="text/javascript" src="<c:url value='/js/ctorder/ctorder_report.js?v=${jsversion}'/>"></script>
<style type="text/css">
.tdfont{
	font-size: 12px;
}
</style>
</head>
<body class="easyui-layout">

<div id="body" region="center" > 
  <!-- 查询条件区域 -->
	<div id="search_areaCtOrder"  class="easyui-panel" >
		<div id="conditon" >
			<form id="searchctOrderForm" style="margin-top:7px;margin-left:5px;" >
			      <table border="0">
			        <tr>
			          <td class="tdfont">查询条件:
			          	<input type="text" size="14" id="searchUserName" name="searchUserName" placeholder="投保人姓名" >
			          	<input type="text" size="14" id="searchOrderNo" name="searchOrderNo" placeholder="保单号" >
			          	<input type="text" size="14" id="searchRecognizeeName" name="searchRecognizeeName" placeholder="被保人姓名" >
			          	<input type="text" size="14" id="searchUserPhone" name="searchUserPhone" placeholder="投保人手机号" >
			          	<br>
			          	申请起始日期
			          	<input type="text" size="14"  class="easyui-datebox"  id="searchStartTime" name="searchStartTime" placeholder="申请起始日期" >
			          	至
			          	<input type="text" size="14"  class="easyui-datebox"  id="searchEndTime" name="searchEndTime" placeholder="申请起始日期" >
			          	
			          </td>
			          <td >
			              <a  href="javascript:void(0)" id="searchButton" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a> 
			              <a  href="javascript:void(0)" id="resetButton" class="easyui-linkbutton" iconCls="icon-reset" plain="true" >重置</a>
				      </td>
				      <td >
			              <a  href="javascript:to_export('bj');" id="exportButton_bj" class="easyui-linkbutton" iconCls="icon-search" plain="true">导出保监会</a> 
			              <a  href="javascript:to_export('bxxh');" id="exportButton_bxxh" class="easyui-linkbutton" iconCls="icon-reset" plain="true" >导出保险协会</a>
			              <a  href="javascript:to_export('bxgs');" id="exportButton_bxgs" class="easyui-linkbutton" iconCls="icon-reset" plain="true" >导出保险公司</a>
				      </td>
			        </tr>
			      </table>
		     </form>
	     </div>
    	<span id="openOrClose"></span> 
	</div>
  
  	<!-- 数据表格区域 -->
  <div id="tt_CtOrder"></div>
  
</div>

  <div id="editCtOrderDiv"></div> 
  <div id="exportCtOrderDiv"></div> 
   
  <script type="text/javascript">
  function to_export(exportType) {
      var exportIframe = document.createElement('iframe');  
      var query = $('#searchctOrderForm').serialize();
      query = query.replace(/(&|^)(\w*?\d*?\-*?_*?)*?=?((?=&)|(?=$))/g, '');
      exportIframe.src =httpUrl+"/ctorder/export.html?&rand=" + Math.random()+"&exportType="+exportType+"&"+query;
      exportIframe.style.display = 'none';
      document.body.appendChild(exportIframe);
  }
  </script>
</body>

</html>