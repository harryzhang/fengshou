
$(function(){
/*#############################################search form begin#################################*/	
		
	$("#searchorgForm #searchButton").on("click",function(){
		$("#tt_Org").datagrid('load',{
			'searchOrgName': $("#searchorgForm #searchOrgName").val(),
			'searchCodeStr':$("#searchorgForm #searchCodeStr").val()		
		});
	});
	
	$("#searchorgForm #resetButton").on("click",function(){
		$("#searchorgForm").form('reset');
	});
	
/*#############################################search form end#################################*/		
	
/*##########################grid init begin####################################################*/
/*##########################grid toolbar begin#################################################*/
	var toolbar_tt = [
					{
						iconCls:"icon-edit",
						text:"新增/编辑",
						handler:to_addorg
					}
	          	];
	
/*######################grid toolbar end##############################*/
/*######################grid columns begin##############################*/
	var columns_tt = [
      			[	 				
							{field:'id',title:'id',width:100,hidden:true},						
								{field:"orgCode",title:"机构编码",width:180,align:"center"},
								{field:"orgName",title:"组织机构名称",width:180,align:"center"},
								{field:"parentId",title:"上级组织",width:180,align:"center"},
								{field:"status",title:"状态",width:180,align:"center"},
								{field:"createTime",title:"创建日期",width:180,align:"center",formatter:dateTimeFormatter},
								{field:"createBy",title:"创建人",width:180,align:"center"},
								{field:"updateTime",title:"更新日期",width:180,align:"center",formatter:dateTimeFormatter},
								{field:"updateBy",title:"更新人",width:180,align:"center"},
					{field:"操作",title:"操作",width:80,align:"left",
	 					formatter:function(value,row,index){
	 					  var str= '<a href="javascript:void(0);" onclick="to_editorg(\''+row.id+'\');">编辑</a>';
	 					  return str;
	 					}
	 				}	 				
	 			]
	 	];
/*######################grid columns end##############################*/
	
	$("#tt_Org").datagrid({
		url:httpUrl+"/org/listOrg.html?&rand=" + Math.random(),
		height:$("#body").height()-$('#search_areaOrg').height()-10,
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
			'searchOrgName': $("#searchorgForm #searchOrgName").val(),
			'searchCodeStr':$("#searchorgForm #searchCodeStr").val()
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
function to_addorg(){
	to_edit('');
}
/**
 * 编辑
 * @param id
 */
function to_editorg(id){
	
	var url = httpUrl+"/org/addOrg.html?&rand=" + Math.random()+"&id="+id;
	$('#editOrgDiv').dialog({
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
					handler:save_Org
				},
				{
					iconCls:"icon-no",text:"关闭",
					handler:function(){
						$("#editOrgDiv").dialog("close");
				}
		}]
	});
}

function save_Org(){
	var formdata = $("#editOrgForm").serialize();
	console.info("formdata");
	console.info(formdata);
	var  url =httpUrl+"/org/saveOrg.html?&rand=" + Math.random();
	 $.ajax({   
		 type: 'POST',
		 dataType: 'json',
		 url: url,  
		 data:$("#editOrgForm").serialize(),
		 success: function(data){ 
			 if(data.code ==="0"){
				 $("#editOrgDiv").dialog("close");
				 $('tt_Org').datagrid('reload');
				 $.messager.alert("提示","操作成功","info");
			 }else{
				 $.messager.alert("提示","操作失败","error");
			 }   
		 } 
	});
}


function reloadDataGrid()
{
	$("tt_Org").datagrid("reload");
}




/*##########################公用方法##begin############################*/

//监听窗口大小变化
window.onresize = function(){
	setTimeout(domresize,300);
};
//改变表格和查询表单宽高
function domresize(){
	$('tt_Org').datagrid('resize',{  
		height:$("#body").height()-$('#search_areaOrg').height()-5,
		width:$("#body").width()
	});
	$('#search_areaOrg').panel('resize',{
		width:$("#body").width()
	});
	$('#detailLoanDiv').dialog('resize',{  
		height:$("#body").height()-25,
		width:$("#body").width()-30
	});
}
 
/*##########################公用方法##end############################*/