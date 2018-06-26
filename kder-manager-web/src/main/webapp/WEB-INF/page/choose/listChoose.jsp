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
	<div id="search_areaCommonChoose"  class="easyui-panel" >
		<div id="conditon" >
			<form id="searchCommonChooseForm" style="margin-top:7px;margin-left:5px;" >
			      <table border="0">
			        <tr>
			          <td class="tdfont">查询条件:
			          	<input type="text" size="14" id="searchName" name="searchName" placeholder="名称" >
			          	<input type="text" size="14" id="searchCode" name="searchCode" placeholder="编码" >
			          	<input type="text" size="14" id="chooseType" name="chooseType" value="${chooseType}">
			          	<input type="text" size="14" id="retId" name="retId" value="${retId}">
			          	<input type="text" size="14" id="retText" name="retText" value="${retText}">
			          </td>
			          <td >
			              <a  href="javascript:void(0)" id="searchButton" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a> 
			              <a  href="javascript:void(0)" id="resetButton" class="easyui-linkbutton" iconCls="icon-reset" plain="true" >重置</a>
				      </td>
			        </tr>
			      </table>
		     </form>
	     </div>
	</div>
  
  	<!-- 数据表格区域 -->
  <div id="tt_CommonChoose"></div>
  
</div>
<script type="text/javascript">

$(function(){
/*#############################################search form begin#################################*/	
		
	$("#searchCommonChooseForm #searchButton").on("click",function(){
		$("#tt_CommonChoose").datagrid('load',{
			'searchName': $("#searchCommonChooseForm #searchName").val(),
			'chooseType':$("#searchCommonChooseForm #chooseType").val(),		
			'searchCode':$("#searchCommonChooseForm #searchCode").val()		
		});
	});
	
	$("#searchCommonChooseForm #resetButton").on("click",function(){
		$("#searchCommonChooseForm").form('reset');
	});
	
/*#############################################search form end#################################*/		
	
/*##########################grid init begin####################################################*/
/*##########################grid toolbar begin#################################################*/
	var toolbar_tt = [
					{
						iconCls:"icon-edit",
						text:"选择",
						handler:to_addctOrder
					}
	          	];
	
/*######################grid toolbar end##############################*/
/*######################grid columns begin##############################*/
	var columns_tt = [
      			[	 				
							
							{field:'id',title:'id',width:100,hidden:true},
							{ field: 'checked', title: 'Choice', width: 30,
		                        formatter: function(value, row, index) {
		                            return '<input type="radio" name="selectRadio" id="selectRadio"' + index + '    value="' + row.id + '" />';
		                        }
		                    },
							{field:"name",title:"名称",width:280},							
							{field:"操作",title:"操作",width:100,align:"left",
								formatter:function(value,row,index){
									var str= '<a href="javascript:void(0);" onclick="dochoose(\''+row.id+'\');">选择</a>';
									return str;
								}
							}	 				
	 			]
	 	];
/*######################grid columns end##############################*/
	
	$("#tt_CommonChoose").datagrid({
		url:httpUrl+"/choose/doChoose.html?&rand=" + Math.random(),
		height:$("#body").height()-$('#search_areaCommonChoose').height()-10,
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
			'searchName': $("#searchCommonChooseForm #searchName").val(),
			'searchCode':$("#searchCommonChooseForm #searchCode").val(),
			'chooseType':$("#searchCommonChooseForm #chooseType").val()
		},
		onLoadSuccess:function(data){//根据状态限制checkbox
			
		},
		onClickRow:  
            function () {  
                //单击行的时候，将单选按钮设置为选中  
                var SelectedRow = $('#tt_CommonChoose').datagrid("getSelected");  
                $("input[name='selectRadio'][value='"+SelectedRow.id+"']").attr("checked", true);
            }        
	});	
});
/*##########################grid init end###################################################*/
function dochoose(){
	$("#tt_CommonChoose").dialog("close");
}


</script>
</body>
</html>