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
<script type="text/javascript" src="<c:url value='/js/ctorder/ctorder.js?v=${jsversion}'/>"></script>
<style type="text/css">
.tdfont{
	font-size: 12px;
}
</style>
</head>
<body class="easyui-layout">

<div id="body" region="center" > 
  <!-- 查询条件区域 -->
	<div id="search_areaCtOrder_import"  class="easyui-panel" >
		<div id="conditon" >
			<form id="searchctOrderForm_import" action="<c:url  value='/ctorder/submitImport.html'/>" style="margin-top:50px;margin-left:5px;"  method="post"  enctype="multipart/form-data">
			      <table border="0">
			        <tr>
			          <td class="tdfont">请告诉我你导入的模板:
						 <select id="importType" name="importType">
								<option value="bxxh1">非车险</option>
								<option value="bxxh2">车险</option>
								<option value="bxxh3">寿险</option>
						</select>			          	
			          </td>
			          <td>
			          	<input type="file" id="importFile" name="importFile"/>
			          </td>
			          <!-- 
			          <td >
			              <a  href="javascript:void(0)" id="searchButton" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a> 
			              <a  href="javascript:void(0)" id="resetButton" class="easyui-linkbutton" iconCls="icon-reset" plain="true" >重置</a>
				      </td>
				       -->
				      <td >
			              <input type="button" value="上传" onclick="submitImport();">
				      </td>
			        </tr>
			      </table>
		     </form>
	     </div>
	</div>
  
  <!-- 数据表格区域 -->
  <div id="tt_CtOrderImport"></div>
  <div id="maskDiv"></div>
</div>

   
  <script type="text/javascript">
	  
  	  function submitImport(){
  		$("#maskDiv").html("<span>正在导入,您可以喝喝水,休息片刻</span>");
  		$("#maskDiv").dialog({modal:true,
  			                  title:"正在导入", 
  			                  width: 400,
  			          		  height: 150,
  			          		  closed: false,
  			          		  closable:false});
  		
  		$("#searchctOrderForm_import").submit();
  	  }
  
	  function view_import_ret(exportType) {

		  if(exportType){
			  $("#exportType").val(exportType);
		  }
		  
		  var exportTemplate = $("#bxxh").val();
	      var exportIframe = document.createElement('iframe');  
	      var query = $('#searchctOrderForm').serialize();
	      query = query.replace(/(&|^)(\w*?\d*?\-*?_*?)*?=?((?=&)|(?=$))/g, '');
	      exportIframe.src =httpUrl+"/ctorder/export.html?&rand=" + Math.random()+"&exportTemplate="+exportTemplate+"&"+query;
	      exportIframe.style.display = 'none';
	      document.body.appendChild(exportIframe);
	  }
  </script>
</body>
</html>