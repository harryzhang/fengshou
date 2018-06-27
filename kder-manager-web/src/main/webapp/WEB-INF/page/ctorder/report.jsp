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
			          	<input type="text" size="14" id="searchStartDate" name="searchStartDate" placeholder="保单创建起始时间" >
			          	---<input type="text" size="14" id="searchEndDate" name="searchEndDate" placeholder="保单创建截止时间" >
			          </td>
			          <td >
			              <a  href="javascript:void(0)" id="searchButton" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a> 
			              <a  href="javascript:void(0)" id="resetButton" class="easyui-linkbutton" iconCls="icon-reset" plain="true" >重置</a>
				      </td>
				      <!-- 
				      <td >
			              <a  href="javascript:to_export('bj');" id="exportButton_bj" class="easyui-linkbutton" iconCls="icon-search" plain="true">导出保监会</a> 
			              <a  href="javascript:to_export('bxxh');" id="exportButton_bxxh" class="easyui-linkbutton" iconCls="icon-reset" plain="true" >导出保险协会</a>
			              <a  href="javascript:to_export('bxgs');" id="exportButton_bxgs" class="easyui-linkbutton" iconCls="icon-reset" plain="true" >导出保险公司</a>
				      </td>
				       -->
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
  <script type="text/javascript">

  $(function(){
  /*#############################################search form begin#################################*/	
  		
  	$("#searchctOrderForm #searchButton").on("click",function(){
  		$("#tt_CtOrder").datagrid('load',{
  			'searchStartDate': $("#searchctOrderForm #searchStartDate").val(),
  			'searchEndDate':$("#searchctOrderForm #searchEndDate").val()		
  		});
  	});
  	
  	$("#searchctOrderForm #resetButton").on("click",function(){
  		$("#searchctOrderForm").form('reset');
  	});
  	
  /*#############################################search form end#################################*/		
  	
  /*##########################grid init begin####################################################*/
  /*##########################grid toolbar begin#################################################*/
  	var toolbar_tt = [
  					{
  						iconCls:"icon-edit",
  						text:"新增/编辑",
  						handler:to_addctOrder
  					}
  	          	];
  	
  /*######################grid toolbar end##############################*/
  /*######################grid columns begin##############################*/
  	var columns_tt = [
        			[	 				
  							{field:'orderId',title:'orderId',width:100,hidden:true},
  							{field:"userId",title:"用户ID",width:180,hidden:true},
  							{field:"prodId",title:"产品ID",width:180,hidden:true},
  							{field:"salesId",title:"业务员ID",width:180,hidden:true},
  							{field:"projectId",title:"项目ID",width:180,hidden:true},
  							{field:"auditInstanceId",title:"审批Id",width:180,hidden:true},
  							{field:"orderNo",title:"保单号",width:180,align:"center"},
  							{field:"userName",title:"用户姓名",width:180,align:"center"},
  							{field:"orderStatus",title:"订单状态",width:180,align:"center",
  								formatter:function(value,row,index){
  			 						if(value=="1"){
  			 							return "草稿";
  			 						}else if(value=="2"){
  			 							return "审批中";
  			 						}else if(value=="3"){
  			 							return "已生效订单";
  			 						}else if(value=="4"){
  			 							return "在续订单";
  			 						}else if(value=="5"){
  			 							return "已完成订单";
  			 						}
  				 				}
  							},
  							{field:"orderPeriod",title:"保障期限",width:180,align:"center"},
  							{field:"startTime",title:"保障起始日期",width:180,align:"center",formatter:dateTimeFormatter},
  							{field:"endTime",title:"保障截止日期",width:180,align:"center",formatter:dateTimeFormatter},
  							{field:"orderAmt",title:"保单金额",width:180,align:"center"},							
  							{field:"userPhone",title:"投保用户手机号",width:180,align:"center"},
  							{field:"recognizeeName",title:"被保用户姓名",width:180,align:"center"},							
  							{field:"recognizeeCertNo",title:"被保用户证件号码",width:180,align:"center"},
  							{field:"recognizeePhone",title:"被保用户手机号",width:180,align:"center"},
  							{field:"salesMan",title:"业务员",width:180,align:"center"},
  							{field:"commissionAmt",title:"佣金",width:180,align:"center"},							
  							{field:"auditStatus",title:"审批状态",width:180,align:"center",
  								formatter:function(value,row,index){
  			 						if(value=="1"){
  			 							return "待审批";
  			 						}else if(value=="2"){
  			 							return "审批中";
  			 						}else if(value=="3"){
  			 							return "已审批";
  			 						}else if(value=="4"){
  			 							return "审批不通过";
  			 						}
  				 				}
  							},
  							{field:"auditDate",title:"审批日期",width:180,align:"center",formatter:dateTimeFormatter},							
  							{field:"createTime",title:"创建日期",width:180,align:"center",formatter:dateTimeFormatter},
  							{field:"updateTime",title:"更新日期",width:180,align:"center",formatter:dateTimeFormatter}  								 				
  	 			]
  	 	];
  /*######################grid columns end##############################*/
  	
  	$("#tt_CtOrder").datagrid({
  		url:httpUrl+"/ctorder/listCtOrder.html?&rand=" + Math.random(),
  		height:$("#body").height()-$('#search_areaCtOrder').height()-10,
  		width:$("#body").width(),
  		rownumbers:true,
  		fitColumns:true,
  		singleSelect:false,//配合根据状态限制checkbox
  		autoRowHeight:true,
  		striped:true,
  		checkOnSelect:false,//配合根据状态限制checkbox
  		selectOnCheck:false,//配合根据状态限制checkbox
  		loadFilter : function(data){
  			return {
  				'rows' : data.datas,
  				'total' : data.total,
  				'pageSize' : data.pageSize,
  				'pageNumber' : data.page
  			};
  		},
  		pagination:true,
  		showPageList:true,
  		pageSize:20,
  		pageList:[10,20,30],
  		idField:"orderId",
  		columns:columns_tt,
  		toolbar:toolbar_tt,
  		queryParams:{
  			'searchStartDate': $("#searchctOrderForm #searchStartDate").val(),
  			'searchEndDate':$("#searchctOrderForm #searchEndDate").val()
  		},
  		onLoadSuccess:function(data){//根据状态限制checkbox
  			
  		}
  	});
  	
 
  
  });
  /*##########################grid init end###################################################*/


  function reloadDataGrid()
  {
  	$("tt_CtOrder").datagrid("reload");
  }
  </script>
</body>

</html>