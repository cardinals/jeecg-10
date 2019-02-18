<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wuyeFwxxCqbgList" checkbox="false" pagination="true" fitColumns="true" title="房屋产权变更表" actionUrl="wuyeFwxxCqbgController.do?datagrid" idField="id" fit="true" queryMode="group"  sortName="createDate" sortOrder="desc">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="房屋主键"  field="fwxxid"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房屋所有权人_现"  field="fwsyqrXz"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="证件类型_现"  field="zjmcXz"  queryMode="single"  dictionary="zjlx"  width="120"></t:dgCol>
   <t:dgCol title="证件号码_现"  field="zjhmXz"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房屋所有权人_原"  field="fwsyqrYl"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="证件类型_原"  field="zjmcYl"  queryMode="single"  dictionary="zjlx"  width="120"></t:dgCol>
   <t:dgCol title="证件号码_原"  field="zjhmYl"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bz"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wuyeFwxxCqbgController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wuyeFwxxCqbgController.do?goAdd" funname="add"></t:dgToolBar><%-- 
   <t:dgToolBar title="编辑" icon="icon-edit" url="wuyeFwxxCqbgController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wuyeFwxxCqbgController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
   <t:dgToolBar title="查看" icon="icon-search" url="wuyeFwxxCqbgController.do?goUpdate" funname="detail"></t:dgToolBar>
 <%--   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/wuyeglq/wuyeFwxxCqbgList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wuyeFwxxCqbgController.do?upload', "wuyeFwxxCqbgList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wuyeFwxxCqbgController.do?exportXls","wuyeFwxxCqbgList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wuyeFwxxCqbgController.do?exportXlsByT","wuyeFwxxCqbgList");
}

 </script>