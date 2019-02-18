<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wuyeSfglYsfyjsxmList" checkbox="true" pagination="true" fitColumns="false" title="应收费用计算项目表" actionUrl="wuyeSfglYsfyjsxmController.do?datagrid" idField="id" fit="true" queryMode="group" >
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
   <t:dgCol title="管理区id"  field="glqid"  queryMode="single"  width="120" hidden="true"></t:dgCol>
   <t:dgCol title="收费项目代码"  field="sfxmdm"  queryMode="single"  width="120" hidden="true"></t:dgCol>
   <t:dgCol title="收费项目名称"  field="sfxmmc"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费开始时间"  field="jfqssj"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费终止时间"  field="jfjzsj"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费方式"  dictionary="sffs"  field="sffs"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费方式"  dictionary="jffs"  field="jffs"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费周期"  field="jfzq"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费周期单位" dictionary="jfzqdw"  field="jfzqdw"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费单价"  field="jfdj"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费精度" dictionary="jfjd"  field="jfjd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="滞纳金率"  field="znjl"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="滞纳金开始天数"  field="znjksts"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计算公式"  field="jsgs"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wuyeSfglYsfyjsxmController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="添加" icon="icon-add" url="wuyeSfglYsfyjsxmController.do?goAdd" funname="add" width="880"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wuyeSfglYsfyjsxmController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wuyeSfglYsfyjsxmController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="wuyeSfglYsfyjsxmController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/wuyesfgl/wuyeSfglYsfyjsxmList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });   
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wuyeSfglYsfyjsxmController.do?upload', "wuyeSfglYsfyjsxmList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wuyeSfglYsfyjsxmController.do?exportXls","wuyeSfglYsfyjsxmList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wuyeSfglYsfyjsxmController.do?exportXlsByT","wuyeSfglYsfyjsxmList");
}

 </script>