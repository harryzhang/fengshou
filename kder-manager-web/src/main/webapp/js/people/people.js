
$(function(){
/*#############################################search form begin#################################*/	
		
	$("#searchpeopleForm #searchButton").on("click",function(){
		$("#tt_People").datagrid('load',{
			'searchUserName': $("#searchpeopleForm #searchUserName").val(),
			'searchPhone':$("#searchpeopleForm #searchPhone").val()		
		});
	});
	
	$("#searchpeopleForm #resetButton").on("click",function(){
		$("#searchpeopleForm").form('reset');
	});
	
/*#############################################search form end#################################*/		
	
/*##########################grid init begin####################################################*/
/*##########################grid toolbar begin#################################################*/
	var toolbar_tt = [
					{
						iconCls:"icon-edit",
						text:"新增",
						handler:to_addpeople
					}
	          	];
	
/*######################grid toolbar end##############################*/
/*######################grid columns begin##############################*/
	var columns_tt = [
      			[	 				
							{field:'peopleId',title:'peopleId',width:100,hidden:true},						
								{field:"peoplePhone",title:"手机号码",width:180,align:"center"},
								{field:"peopleName",title:"用户姓名",width:180,align:"center"},
								{field:"peopleDatetime",title:"注册日期",width:180,align:"center",formatter:dateTimeFormatter},
								{field:"peopleMail",title:"邮箱",width:180,align:"center"},
								{field:"peopleState",title:"状态",width:180,align:"center"},
								{field:"peopleCode",title:"身份证号码",width:180,align:"center"},
								{field:"peopleCodesenddate",title:"身份证号是否验证",width:180,align:"center",formatter:dateTimeFormatter},
								{field:"peoplePhonecheck",title:"手机号码是否验证",width:180,align:"center"},
								{field:"peopleMaillcheck",title:"邮箱是否验证",width:180,align:"center"},
					{field:"操作",title:"操作",width:80,align:"left",
	 					formatter:function(value,row,index){
	 					  var str= '<a href="javascript:void(0);" onclick="to_editpeople(\''+row.peopleId+'\');">查看明细</a>';
	 					  return str;
	 					}
	 				}	 				
	 			]
	 	];
/*######################grid columns end##############################*/
	
	$("#tt_People").datagrid({
		url:httpUrl+"/people/listPeople.html?&rand=" + Math.random(),
		height:$("#body").height()-$('#search_areaPeople').height()-10,
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
		idField:"peopleId",
		columns:columns_tt,
		toolbar:toolbar_tt,
		queryParams:{
			'searchUserName': $("#searchpeopleForm #searchUserName").val(),
			'searchPhone':$("#searchpeopleForm #searchPhone").val()
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
function to_addpeople(){
	to_editpeople('');
}
/**
 * 编辑
 * @param id
 */
function to_editpeople(id){
	
	var url = httpUrl+"/people/addPeople.html?&rand=" + Math.random()+"&id="+id;
	$('#editPeopleDiv').dialog({
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
					handler:save_People
				},
				{
					iconCls:"icon-no",text:"关闭",
					handler:function(){
						$("#editPeopleDiv").dialog("close");
				}
		}]
	});
}

function save_People(){
	var formdata = $("#editPeopleForm").serialize();
	console.info("formdata");
	console.info(formdata);
	var  url =httpUrl+"/people/savePeople.html?&rand=" + Math.random();
	 $.ajax({   
		 type: 'POST',
		 dataType: 'json',
		 url: url,  
		 data:$("#editPeopleForm").serialize(),
		 success: function(data){ 
			 if(data.code ==="0"){
				 $("#editPeopleDiv").dialog("close");
				 $('tt_People').datagrid('reload');
				 $.messager.alert("提示","操作成功","info");
			 }else{
				 $.messager.alert("提示","操作失败","error");
			 }   
		 } 
	});
}


function reloadDataGrid()
{
	$("tt_People").datagrid("reload");
}




/*##########################公用方法##begin############################*/

//监听窗口大小变化
window.onresize = function(){
	setTimeout(domresize,300);
};
//改变表格和查询表单宽高
function domresize(){
	$('tt_People').datagrid('resize',{  
		height:$("#body").height()-$('#search_areaPeople').height()-5,
		width:$("#body").width()
	});
	$('#search_areaPeople').panel('resize',{
		width:$("#body").width()
	});
	$('#detailLoanDiv').dialog('resize',{  
		height:$("#body").height()-25,
		width:$("#body").width()-30
	});
}
 
/*##########################公用方法##end############################*/