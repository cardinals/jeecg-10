<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wuyeSfglSfxmszList" checkbox="true" pagination="true" fitColumns="false" title="收费项目管理" actionUrl="wuyeSfglSfxmszController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="管理区ID"  field="glqid" dictionary="wuye_glq where glqlx='2',id,glqmc" query="true" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="管理区名称"  field="glqmc" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费项目代码"  field="xmdm"  queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="收费项目名称"  field="xmmc"  queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="收费方式" dictionary="sffs" field="sffs"  queryMode="single"   width="120"></t:dgCol>
   <t:dgCol title="计费方式" dictionary="jffs"  field="jffs"  queryMode="single" width="120"></t:dgCol>
   <t:dgCol title="计费周期"  field="jfzq"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费周期单位" dictionary="jfzqdw" field="jfzqdw"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费单价"  field="jfdj"  queryMode="single"  width="120"></t:dgCol>
   
   <t:dgCol title="是否收费" dictionary="cfcz" field="sfbz" queryMode="single"  width="120"></t:dgCol>
   
   <t:dgCol title="计费精度" dictionary="jfjd"  field="jfjd"  queryMode="single"  width="120"></t:dgCol>
   
   <t:dgCol title="滞纳金率"  field="znjl"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="滞纳金开始天数"  field="znjksts"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计算公式"  field="jsgs"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="打印次序"  field="dycx"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wuyeSfglSfxmszController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wuyeSfglSfxmszController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wuyeSfglSfxmszController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wuyeSfglSfxmszController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="wuyeSfglSfxmszController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/wuyesfgl/wuyeSfglSfxmszList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wuyeSfglSfxmszController.do?upload', "wuyeSfglSfxmszList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wuyeSfglSfxmszController.do?exportXls","wuyeSfglSfxmszList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wuyeSfglSfxmszController.do?exportXlsByT","wuyeSfglSfxmszList");
}

 </script>