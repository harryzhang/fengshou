
$(function(){
/*#############################################search form begin#################################*/	
		
	$("#searchpolicyCompanyForm #searchButton").on("click",function(){
		$("#tt_PolicyCompany").datagrid('load',{
			'searchPolicyName': $("#searchpolicyCompanyForm #searchPolicyName").val(),
			'searchManagerName':$("#searchpolicyCompanyForm #searchManagerName").val()		
		});
	});
	
	$("#searchpolicyCompanyForm #resetButton").on("click",function(){
		$("#searchpolicyCompanyForm").form('reset');
	});
	
/*#############################################search form end#################################*/		
	
/*##########################grid init begin####################################################*/
/*##########################grid toolbar begin#################################################*/
	var toolbar_tt = [
					{
						iconCls:"icon-edit",
						text:"新增",
						handler:to_addpolicyCompany
					}
	          	];
	
/*######################grid toolbar end##############################*/
/*######################grid columns begin##############################*/
	var columns_tt = [
      			[	 				
							{field:'id',title:'id',width:100,hidden:true},						
							{field:"policyName",title:"公司名称",width:280,align:"center"},			
							{field:"shortName",title:"公司简称",width:280,align:"center"},			
							{field:"homeUrl",title:"官网地址",width:180,align:"center"},			
							{field:"bannerUrl",title:"banner地址",width:180,align:"center"},			
							{field:"companyType",title:"类别",width:180,align:"center"},			
							{field:"contactName",title:"联系人姓名",width:280,align:"center"},			
							{field:"contactPhone",title:"联系人手机号码",width:180,align:"center"},			
							{field:"address",title:"办公地址",width:280,align:"center"},			
							{field:"companyRegAddress",title:"注册地址",width:180,align:"center"},			
							{field:"managerName",title:"业务员",width:180,align:"center"},			
							{field:"partnerStatus",title:"合作状态",width:180,align:"center"},			
							{field:"partnerDate",title:"合作日期",width:180,align:"center",formatter:dateTimeFormatter},			
							{field:"status",title:"有效状态",width:180,align:"center"},			
							{field:"createTime",title:"创建日期",width:180,align:"center",formatter:dateTimeFormatter},			
							{field:"createBy",title:"创建人",width:180,align:"center"},			
							{field:"updateTime",title:"修改日期",width:180,align:"center" ,formatter:dateTimeFormatter},			
							{field:"updateBy",title:"更新人",width:180,align:"center"},			
					{field:"操作",title:"操作",width:80,align:"left",
	 					formatter:function(value,row,index){
	 					  var str= '<a href="javascript:void(0);" onclick="to_editpolicyCompany(\''+row.id+'\');">编辑</a>';
	 					  return str;
	 					}
	 				}	 				
	 			]
	 	];
/*######################grid columns end##############################*/
	
	$("#tt_PolicyCompany").datagrid({
		url:httpUrl+"/policycompany/listPolicyCompany.html?&rand=" + Math.random(),
		height:$("#body").height()-$('#search_areaPolicyCompany').height()-10,
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
			'searchPolicyName': $("#searchpolicyCompanyForm #searchPolicyName").val(),
			'searchManagerName':$("#searchpolicyCompanyForm #searchManagerName").val()
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
function to_addpolicyCompany(){
	to_editpolicyCompany('');
}
/**
 * 编辑
 * @param id
 */
function to_editpolicyCompany(id){
	
	var url = httpUrl+"/policycompany/addPolicyCompany.html?&rand=" + Math.random()+"&id="+id;
	$('#editPolicyCompanyDiv').dialog({
		title: "新增/编辑",
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
					handler:save_PolicyCompany
				},
				{
					iconCls:"icon-no",text:"关闭",
					handler:function(){
						$("#editPolicyCompanyDiv").dialog("close");
				}
		}]
	});
}

function save_PolicyCompany(){
	var formdata = $("#editPolicyCompanyForm").serialize();
	console.info("formdata");
	console.info(formdata);
	var  url =httpUrl+"/policycompany/savePolicyCompany.html?&rand=" + Math.random();
	 $.ajax({   
		 type: 'POST',
		 dataType: 'json',
		 url: url,  
		 data:$("#editPolicyCompanyForm").serialize(),
		 success: function(data){ 
			 if(data.code ==="0"){
				 $("#editPolicyCompanyDiv").dialog("close");
				 $('tt_PolicyCompany').datagrid('reload');
				 $.messager.alert("提示","操作成功","info");
			 }else{
				 $.messager.alert("提示","操作失败","error");
			 }   
		 } 
	});
}


function reloadDataGrid()
{
	$("tt_PolicyCompany").datagrid("reload");
}




/*##########################公用方法##begin############################*/

//监听窗口大小变化
window.onresize = function(){
	setTimeout(domresize,300);
};
//改变表格和查询表单宽高
function domresize(){
	$('tt_PolicyCompany').datagrid('resize',{  
		height:$("#body").height()-$('#search_areaPolicyCompany').height()-5,
		width:$("#body").width()
	});
	$('#search_areaPolicyCompany').panel('resize',{
		width:$("#body").width()
	});
	$('#detailLoanDiv').dialog('resize',{  
		height:$("#body").height()-25,
		width:$("#body").width()-30
	});
}
 
/*##########################公用方法##end############################*/