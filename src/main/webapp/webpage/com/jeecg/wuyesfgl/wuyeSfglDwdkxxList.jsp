<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wuyeSfglDwdkxxList" checkbox="true" pagination="true" fitColumns="false" title="单位代扣信息" actionUrl="wuyeSfglDwdkxxController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="年度"  field="year"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="月份"  field="month"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="代扣单位"  field="dkdw"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="住户姓名"  field="zhxm"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="实收金额"  field="ssje"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="代扣单位工号"  field="dkdwgh"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="提交金额"  field="tjje"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="实际扣款额"  field="sjkke"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="交易日期"  field="jyrq"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="zt"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="响应信息"  field="xyxx"  queryMode="single"  width="120"></t:dgCol>
  
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgOpenOpt url="wuyeSfglYhdkxxController.do?goDetails&id={id}" title="查看明细" height="500" width="1200" urlclass="ace_button"></t:dgOpenOpt>
   
   <t:dgToolBar title="查看" icon="icon-search" url="wuyeSfglDwdkxxController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入扣款结果" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出代扣信息" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/wuyesfgl/wuyeSfglDwdkxxList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wuyeSfglDwdkxxController.do?upload', "wuyeSfglDwdkxxList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wuyeSfglDwdkxxController.do?exportXls","wuyeSfglDwdkxxList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wuyeSfglDwdkxxController.do?exportXlsByT","wuyeSfglDwdkxxList");
}

 </script>