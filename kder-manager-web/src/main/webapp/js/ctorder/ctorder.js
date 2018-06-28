
$(function(){
/*#############################################search form begin#################################*/	
		
	$("#searchctOrderForm #searchButton").on("click",function(){
		$("#tt_CtOrder").datagrid('load',{
			'searchUserName': $("#searchctOrderForm #searchUserName").val(),
			'searchRecognizeeName':$("#searchctOrderForm #searchRecognizeeName").val(),	
			'searchOrderNo':$("#searchctOrderForm #searchOrderNo").val(),
			'searchUserPhone':$("#searchctOrderForm #searchUserPhone").val()
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
							{field:"policyCompany",title:"保险公司",width:180,align:"center"},
							{field:"productName",title:"产品名称",width:180,align:"center"},
							{field:"userName",title:"投保人姓名",width:180,align:"center"},
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
							{field:"updateTime",title:"更新日期",width:180,align:"center",formatter:dateTimeFormatter},
							{field:"操作",title:"操作",width:80,align:"left",
								formatter:function(value,row,index){
									var str= '<a href="javascript:void(0);" onclick="to_editctOrder(\''+row.orderId+'\');">编辑</a>';
									return str;
								}
							}	 				
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
			'searchUserName': $("#searchctOrderForm #searchUserName").val(),
			'searchRecognizeeName':$("#searchctOrderForm #searchRecognizeeName").val(),
			'searchOrderNo':$("#searchctOrderForm #searchOrderNo").val(),
			'searchUserPhone':$("#searchctOrderForm #searchUserPhone").val()
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
function to_addctOrder(){
	to_editctOrder('');
}
/**
 * 编辑
 * @param id
 */
function to_editctOrder(id){
	
	var url = httpUrl+"/ctorder/addCtOrder.html?&rand=" + Math.random()+"&orderId="+id;
	$('#editCtOrderDiv').dialog({
		title: "新增",
		width: 860,
		height: 600,
		closed: false,
		closable:false,
		cache: false,
		href: url,
		modal: true,
		toolbar:[
				{
					iconCls:"icon-save",text:"保存",
					handler:save_CtOrder
				},
				{
					iconCls:"icon-no",text:"关闭",
					handler:function(){
						$("#editCtOrderDiv").dialog("close");
				}
		}]
	});
}

function save_CtOrder(){
	$.ajax({ 
			url: httpUrl+"/ctorder/saveCtOrder.html", 
			data: $("#editCtOrderForm").serialize(),
			type:"post",
			dataType:"json",
			success: function(ret){
	   	 		if(ret.code==="0"){
	   	 			$.messager.confirm("保存成功",
	   	 				           '是否继续添加？', 
	   	 				           function(r){
					   	   			   if(r==false){
					   	   				$("#editCtOrderDiv").dialog("close");
					   	   			   }
	   						});
	   	 		}else{
	   	 			$.messager.alert("error",ret.msg);
	   	 		}
	      	}
	        });
}

function reloadDataGrid()
{
	$("tt_CtOrder").datagrid("reload");
}




/*##########################公用方法##begin############################*/

//监听窗口大小变化
window.onresize = function(){
	setTimeout(domresize,300);
};
//改变表格和查询表单宽高
function domresize(){
	$('tt_CtOrder').datagrid('resize',{  
		height:$("#body").height()-$('#search_areaCtOrder').height()-5,
		width:$("#body").width()
	});
	$('#search_areaCtOrder').panel('resize',{
		width:$("#body").width()
	});
	$('#detailLoanDiv').dialog('resize',{  
		height:$("#body").height()-25,
		width:$("#body").width()-30
	});
}
 
/*##########################公用方法##end############################*/