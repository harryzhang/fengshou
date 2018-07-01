
$(function(){
/*#############################################search form begin#################################*/	
		
	$("#searchctOrderReportForm #searchButton").on("click",function(){
		$("#tt_Order_report").datagrid('load',{
			'searchOrgName': $("#searchctOrderReportForm #searchOrgName").val(),
			'searchCompanyName':$("#searchctOrderReportForm #searchCompanyName").val(),	
			'searchProductName':$("#searchctOrderReportForm #searchProductName").val(),
			'searchManagerName':$("#searchctOrderReportForm #searchManagerName").val(),
			'reportType':$("#searchctOrderReportForm #reportType").val(),
			'searchStartTime':$("#searchctOrderReportForm #searchStartTime").datebox("getValue"),
			'searchEndTime':$("#searchctOrderReportForm #searchEndTime").datebox("getValue"),
			'groupByOrg':$("#searchctOrderReportForm #groupByOrg").val(),
			'groupByProduct':$("#searchctOrderReportForm #groupByProduct").val(),
			'groupByManager':$("#searchctOrderReportForm #groupByManager").val(),
			'groupByTypeDate':$('#searchctOrderReportForm input[name="groupByTypeDate"]:checked').val()
			
		});
	});
	
	$("#searchctOrderReportForm #resetButton").on("click",function(){
		$("#searchctOrderReportForm").form('reset');
	});
	
/*#############################################search form end#################################*/		
	
/*##########################grid init begin####################################################*/
/*##########################grid toolbar begin#################################################*/
	var toolbar_tt = [];
	
/*######################grid toolbar end##############################*/
/*######################grid columns begin##############################*/
	var columns_tt = [
      			[	 		{field:"orgName",title:"机构",width:180,align:"center"},		
							{field:"policyCompany",title:"保险公司",width:180,align:"center"},
							{field:"productName",title:"产品名称",width:180,align:"center"},
							{field:"userName",title:"投保人姓名",width:180,align:"center"},
							{field:"orderAmt",title:"保单金额",width:180,align:"center"},
							{field:"salesMan",title:"业务员",width:180,align:"center"},
							{field:"commissionAmt",title:"佣金",width:180,align:"center"}	 				
	 			]
	 	];
/*######################grid columns end##############################*/
	
	$("#tt_Order_report").datagrid({
		url:httpUrl+"/report/queryReport.html?&rand=" + Math.random(),
		height:$("#body").height()-$('#search_areaOrder_report').height()-10,
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
		columns:columns_tt,
		toolbar:toolbar_tt,
		queryParams:{
			'searchOrgName': $("#searchctOrderReportForm #searchOrgName").val(),
			'searchCompanyName':$("#searchctOrderReportForm #searchCompanyName").val(),	
			'searchProductName':$("#searchctOrderReportForm #searchProductName").val(),
			'searchManagerName':$("#searchctOrderReportForm #searchManagerName").val(),
			'reportType':$("#searchctOrderReportForm #reportType").val(),
			'searchStartTime':$("#searchctOrderReportForm #searchStartTime").datebox("getValue"),
			'searchEndTime':$("#searchctOrderReportForm #searchEndTime").datebox("getValue"),
			'groupByOrg':$("#searchctOrderReportForm #groupByOrg").val(),
			'groupByProduct':$("#searchctOrderReportForm #groupByProduct").val(),
			'groupByManager':$("#searchctOrderReportForm #groupByManager").val(),
			'groupByTypeDate':$('#searchctOrderReportForm input[name="groupByTypeDate"]:checked').val()
			
		},
		onLoadSuccess:function(data){//根据状态限制checkbox
			
		}
	});
});
/*##########################grid init end###################################################*/