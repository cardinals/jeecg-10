<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wuyeCbglGtbList" checkbox="true" pagination="true" fitColumns="true" title="公摊表管理" actionUrl="wuyeCbglGtbController.do?datagrid" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="管理区" field="glqid" queryMode="single" query="true" dictionary="wuye_glq where glqlx = '2' and yxbz = '1',id,glqmc" width="120"></t:dgCol>
   <t:dgCol title="仪表编号"  field="ybbh"  queryMode="single" query="true" width="120"></t:dgCol>
   <t:dgCol title="仪表类型"  field="yblx"  queryMode="single" query="true" dictionary="yblx"  width="120"></t:dgCol>
   <t:dgCol title="倍率"  field="bl"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="初始读数"  field="csds"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="父ID" hidden="true" field="fid"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="有效标志" hidden="true" field="yxbz"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wuyeCbglGtbController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgOpenOpt title="批量修改" url="wuyeCbglGtbController.do?goPl&yblx={yblx}&gtbid={id}" height="500" width="1200" urlclass="ace_button"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wuyeCbglGtbController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wuyeCbglGtbController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wuyeCbglGtbController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="wuyeCbglGtbController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/wuyecbgl/wuyeCbglGtbList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wuyeCbglGtbController.do?upload', "wuyeCbglGtbList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wuyeCbglGtbController.do?exportXls","wuyeCbglGtbList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wuyeCbglGtbController.do?exportXlsByT","wuyeCbglGtbList");
}

 </script>