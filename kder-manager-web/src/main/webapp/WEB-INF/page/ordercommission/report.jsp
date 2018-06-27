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
			          </td>
			          <td >
			              <a  href="javascript:void(0)" id="searchButton" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a> 
			              <a  href="javascript:void(0)" id="resetButton" class="easyui-linkbutton" iconCls="icon-reset" plain="true" >重置</a>
				      </td>
				      <!-- 
				      <td >
			              <a  href="javascript:to_export();" id="exportButton_bj" class="easyui-linkbutton" iconCls="icon-search" plain="true">导出</a> 
				      </td>
				       -->
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
  <script type="text/javascript">

  $(function(){
  /*#############################################search form begin#################################*/	
  		
  	$("#searchorderCommissionForm #searchButton").on("click",function(){
  		$("#tt_OrderCommission").datagrid('load',{
  			'searchManagerName': $("#searchorderCommissionForm #searchManagerName").val(),
  			'searchOrderNo':$("#searchorderCommissionForm #searchOrderNo").val()		
  		});
  	});
  	
  	$("#searchorderCommissionForm #resetButton").on("click",function(){
  		$("#searchorderCommissionForm").form('reset');
  	});
  	
  /*#############################################search form end#################################*/		
  	
  /*##########################grid init begin####################################################*/
  /*##########################grid toolbar begin#################################################*/
  	var toolbar_tt = [
  					{
  						iconCls:"icon-edit",
  						text:"新增",
  						handler:to_addorderCommission
  					}
  	          	];
  	
  /*######################grid toolbar end##############################*/
  /*######################grid columns begin##############################*/
  	var columns_tt = [
        			[	 				
  							{field:'id',title:'id',width:100,hidden:true},						
  							{field:"userId",title:"用户ID",width:180,hidden:true},
  							{field:"orderId",title:"订单ID",hidden:true},
  							{field:"userName",title:"用户名称",width:180,align:"center"},
  							{field:"commissionAmt",title:"佣金",width:180,align:"center"},
  							{field:"orderNo",title:"订单编号",width:180,align:"center"},
  							{field:"status",title:"记录状态",width:180,align:"center",
  								formatter:function(value,row,index){
  			 						if(value=="1"){
  			 							return "待审批";
  			 						}else if(value=="2"){
  			 							return "审批中";
  			 						}else if(value=="3"){
  			 							return "已审批";
  			 						}else if(value=="4"){
  			 							return "已发放";
  			 						}else if(value=="5"){
  			 							return "作废";
  			 						}
  				 				}
  							},
  							{field:"auditStatus",title:"状态",width:180,align:"center",
  								formatter:function(value,row,index){
  			 						if(value=="1"){
  			 							return "待审批";
  			 						}else if(value=="2"){
  			 							return "审批中";
  			 						}else if(value=="3"){
  			 							return "已审批";
  			 						}else if(value=="4"){
  			 							return "审核不通过";
  			 						}
  				 				}
  							},
  							{field:"auditTime",title:"审批时间",width:180,align:"center",formatter:dateTimeFormatter},
  							{field:"auditId",title:"审批人",width:180,align:"center"},
  							{field:"createBy",title:"创建人",width:180,align:"center"},
  							{field:"createTime",title:"创建时间",width:180,align:"center",formatter:dateTimeFormatter},
  							{field:"updateTime",title:"更新时间",width:180,align:"center",formatter:dateTimeFormatter},
  							{field:"updateBy",title:"创建人",width:180,align:"center"},
  							{field:"操作",title:"操作",width:80,align:"left",
  								formatter:function(value,row,index){
  									var str= '<a href="javascript:void(0);" onclick="to_editorderCommission(\''+row.id+'\');">编辑</a>';
  									return str;
  								}	
  							}	 				
  	 			]
  	 	];
  /*######################grid columns end##############################*/
  	
  	$("#tt_OrderCommission").datagrid({
  		url:httpUrl+"/ordercommission/listOrderCommission.html?&rand=" + Math.random(),
  		height:$("#body").height()-$('#search_areaOrderCommission').height()-10,
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
  		idField:"id",
  		columns:columns_tt,
  		toolbar:toolbar_tt,
  		queryParams:{
  			'searchManagerName': $("#searchorderCommissionForm #searchManagerName").val(),
  			'searchOrderNo':$("#searchorderCommissionForm #searchOrderNo").val()
  		},
  		onLoadSuccess:function(data){//根据状态限制checkbox
  			
  		}
  	});
  	
  	/*$(window).resize(function (){
  		domresize();
  	 }); */
  /*##########################grid init end###################################################*/
  });


  /**
   * 新增
   * @param id
   */
  function to_addorderCommission(){
  	to_editorderCommission('');
  }
  /**
   * 编辑
   * @param id
   */
  function to_editorderCommission(id){
  	
  	var url = httpUrl+"/ordercommission/addOrderCommission.html?&rand=" + Math.random()+"&id="+id;
  	$('#editOrderCommissionDiv').dialog({
  		title: "新增",
  		width: 760,
  		height: 500,
  		closed: false,
  		closable:false,
  		cache: false,
  		href: url,
  		modal: true,
  		toolbar:[
  				{
  					iconCls:"icon-save",text:"保存",
  					handler:save_OrderCommission
  				},
  				{
  					iconCls:"icon-no",text:"关闭",
  					handler:function(){
  						$("#editOrderCommissionDiv").dialog("close");
  				}
  		}]
  	});
  }

  function save_OrderCommission(){
  	var formdata = $("#editOrderCommissionForm").serialize();
  	console.info("formdata");
  	console.info(formdata);
  	var  url =httpUrl+"/ordercommission/saveOrderCommission.html?&rand=" + Math.random();
  	 $.ajax({   
  		 type: 'POST',
  		 dataType: 'json',
  		 url: url,  
  		 data:$("#editOrderCommissionForm").serialize(),
  		 success: function(data){ 
  			 if(data.code ==="0"){
  				 $("#editOrderCommissionDiv").dialog("close");
  				 $('tt_OrderCommission').datagrid('reload');
  				 $.messager.alert("提示","操作成功","info");
  			 }else{
  				 $.messager.alert("提示","操作失败","error");
  			 }   
  		 } 
  	});
  }


  function reloadDataGrid()
  {
  	$("tt_OrderCommission").datagrid("reload");
  }




  /*##########################公用方法##begin############################*/

  //监听窗口大小变化
  window.onresize = function(){
  	setTimeout(domresize,300);
  };
  //改变表格和查询表单宽高
  function domresize(){
  	$('tt_OrderCommission').datagrid('resize',{  
  		height:$("#body").height()-$('#search_areaOrderCommission').height()-5,
  		width:$("#body").width()
  	});
  	$('#search_areaOrderCommission').panel('resize',{
  		width:$("#body").width()
  	});
  	$('#detailLoanDiv').dialog('resize',{  
  		height:$("#body").height()-25,
  		width:$("#body").width()-30
  	});
  }
   
  /*##########################公用方法##end############################*/
  </script>
   
</body>

</html>