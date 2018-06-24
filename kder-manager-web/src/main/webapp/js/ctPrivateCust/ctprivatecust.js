
$(function(){
/*#############################################search form begin#################################*/	
		
	$("#searchctPrivateCustForm #searchButton").on("click",function(){
		$("#tt_CtPrivateCust").datagrid('load',{
			'searchUserName': $("#searchctPrivateCustForm #searchUserName").val(),
			'searchPhone':$("#searchctPrivateCustForm #searchPhone").val()		
		});
	});
	
	$("#searchctPrivateCustForm #resetButton").on("click",function(){
		$("#searchctPrivateCustForm").form('reset');
	});
	
/*#############################################search form end#################################*/		
	
/*##########################grid init begin####################################################*/
/*##########################grid toolbar begin#################################################*/
	var toolbar_tt = [
					{
						iconCls:"icon-edit",
						text:"新增",
						handler:to_addctPrivateCust
					}
	          	];
	
/*######################grid toolbar end##############################*/
/*######################grid columns begin##############################*/
	var columns_tt = [
      			[	 				
							{field:'id',title:'id',width:100,hidden:true},						
								{field:"userName",title:"用户姓名",width:180,align:"center"},
								{field:"phone",title:"手机号码",width:180,align:"center"},
								{field:"gender",title:"性别",width:180,align:"center"},
								{field:"status",title:"状态",width:180,align:"center"},
								{field:"createTime",title:"意向单申请日期",width:180,align:"center",formatter:dateTimeFormatter},
					{field:"操作",title:"操作",width:180,align:"left",
	 					formatter:function(value,row,index){
	 					  var str= '<a href="javascript:void(0);" onclick="to_editctPrivateCust(\''+row.id+'\');">编辑</a>';
	 					  str= str+ '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);" onclick="convertOrder(\''+row.id+'\');">意向单转订单</a>';
	 					  return str;
	 					}
	 				}	 				
	 			]
	 	];
/*######################grid columns end##############################*/
	
	$("#tt_CtPrivateCust").datagrid({
		url:httpUrl+"/ctprivatecust/listCtPrivateCust.html?&rand=" + Math.random(),
		height:$("#body").height()-$('#search_areaCtPrivateCust').height()-10,
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
			'searchUserName': $("#searchctPrivateCustForm #searchUserName").val(),
			'searchPhone':$("#searchctPrivateCustForm #searchPhone").val()
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
function to_addctPrivateCust(){
	to_edit('');
}
/**
 * 编辑
 * @param id
 */
function to_editctPrivateCust(id){
	
	var url = httpUrl+"/ctprivatecust/addCtPrivateCust.html?&rand=" + Math.random()+"&id="+id;
	$('#editCtPrivateCustDiv').dialog({
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
					handler:save_CtPrivateCust
				},
				{
					iconCls:"icon-no",text:"关闭",
					handler:function(){
						$("#editCtPrivateCustDiv").dialog("close");
				}
		}]
	});
}

/**
 * 编辑
 * @param id
 */
function convertOrder(id){
	
	var url = httpUrl+"/ctorder/convertOrder.html?&rand=" + Math.random()+"&privateCustId="+id;
	$('#editCtOrderDiv').dialog({
		title: "意向单转订单",
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
					handler:function(){
						$.ajax({ 
			    			url: "<c:url value='/ctorder/saveCtOrder.html'/>", 
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
				},
				{
					iconCls:"icon-no",text:"关闭",
					handler:function(){
						$("#editCtOrderDiv").dialog("close");
				}
		}]
	});

}



function reloadDataGrid()
{
	$("tt_CtPrivateCust").datagrid("reload");
}




/*##########################公用方法##begin############################*/

//监听窗口大小变化
window.onresize = function(){
	setTimeout(domresize,300);
};
//改变表格和查询表单宽高
function domresize(){
	$('tt_CtPrivateCust').datagrid('resize',{  
		height:$("#body").height()-$('#search_areaCtPrivateCust').height()-5,
		width:$("#body").width()
	});
	$('#search_areaCtPrivateCust').panel('resize',{
		width:$("#body").width()
	});
	$('#detailLoanDiv').dialog('resize',{  
		height:$("#body").height()-25,
		width:$("#body").width()-30
	});
}
 
/*##########################公用方法##end############################*/