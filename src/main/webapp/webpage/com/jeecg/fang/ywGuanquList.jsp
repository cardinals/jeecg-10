<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="ywGuanquList" checkbox="true" pagination="true" treegrid="true" treeField="gqName" fitColumns="true" title="管理区域设置" actionUrl="ywGuanquController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="管区名称"  field="gqName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="管区上级"  field="parentId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="ywGuanquController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="ywGuanquController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="ywGuanquController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="ywGuanquController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="ywGuanquController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/fang/ywGuanquList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
		$("#ywGuanquList").treegrid({
 				 onExpand : function(row){
 					var children = $("#ywGuanquList").treegrid('getChildren',row.id);
 					 if(children.length<=0){
 					 	row.leaf=true;
 					 	$("#ywGuanquList").treegrid('refresh', row.id);
 					 }
 				}
 		});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'ywGuanquController.do?upload', "ywGuanquList");
}

//导出
function ExportXls() {
	JeecgExcelExport("ywGuanquController.do?exportXls","ywGuanquList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("ywGuanquController.do?exportXlsByT","ywGuanquList");
}

/**
 * 获取表格对象
 * @return 表格对象
 */
function getDataGrid(){
	var datagrid = $('#'+gridname);
	return datagrid;
}
 </script>