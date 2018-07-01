<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>报表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache" />
<jsp:include page="../common_easyui_cus.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/icons.css'/>" />
<script type="text/javascript" src="<c:url value='/js/common/js/jquery-easyui-1.4.1/extension/jquery-easyui-datagridview/datagrid-detailview.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/report/report.js?v=${jsversion}'/>"></script>
<style type="text/css">
.tdfont{
	font-size: 12px;
}
</style>
</head>
<body class="easyui-layout">

<div id="body" region="center" > 
  <!-- 查询条件区域 -->
	<div id="search_areaOrder_report"  class="easyui-panel" >
		<div id="conditon" >
			<form id="searchctOrderReportForm" style="margin-top:7px;margin-left:5px;" >
			      <table border="0">
			        <tr>
			          <td class="tdfont">查询条件:
			          	<input type="text" size="14" id="searchOrgName" name="searchOrgName" placeholder="机构名称" >
			          	<input type="text" size="14" id="searchCompanyName" name="searchCompanyName" placeholder="保险公司名称" >
			          	<input type="text" size="14" id="searchProductName" name="searchProductName" placeholder="保险产品名称" >
			          	<input type="text" size="14" id="searchManagerName" name="searchManagerName" placeholder="业务员名称" >
			          	<input type="hidden" size="14" id="reportType" name="reportType" value="${reportType}" >
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
				      </td>
			        </tr>
			        <tr>
			          <td class="tdfont">汇总字段:
			          	<label>按机构</label><input type="checkbox" size="14" id="groupByOrg" name="searchOrg" value="org">
			          	<label>按保险公司</label><input type="checkbox" size="14" id="groupByCompany" name="searchCompany" value="company">
			          	<label>按保险产品</label><input type="checkbox" size="14" id="groupByProduct" name="searchProduct" value="product" >
			          	<label>按业务员</label><input type="checkbox" size="14" id="groupByManager" name="searchManager" value="manager" >
			          </td>
			          <td ></td>
				      <td ></td>
			        </tr>
			        <tr>
			          <td class="tdfont">时间汇总方式:
			          	<label>按月</label><input type="radio" size="14" id="groupByType-m" name="groupByTypeDate" value="m">
			          	<label>按周</label><input type="radio" size="14" id="groupByType-w" name="groupByTypeDate" value="w">
			          	<label>按日</label><input type="radio" size="14" id="groupByType-d" name="groupByTypeDate" value="d">
			          </td>
			          <td ></td>
				      <td ></td>
			        </tr>
			      </table>
		     </form>
	     </div>
	</div>
  
  	<!-- 数据表格区域 -->
  <div id="tt_Order_report"></div>
  
</div>

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