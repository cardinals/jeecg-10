<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" id="vvv" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wuyeSfglYsfyjlList" checkbox="true" pagination="true" fitColumns="false" title="代扣信息目录" actionUrl="wuyeSfglYhdkxxController.do?datagridDaikou&dkid=${dkid}" idField="ysfyjl" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
  
   <t:dgCol title="业主姓名"  field="yzmc"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费项目名称"  field="sfxmmc"  queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="应收金额"  field="ysje"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费年度"  field="jfnd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费月份"  field="jfyf"  queryMode="single"  width="120"></t:dgCol>
   
   <t:dgToolBar title="查看" icon="icon-search" url="wuyeSfglYsfyjlController.do?goUpdate" funname="detail"></t:dgToolBar>
  <%--  <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
   <t:dgToolBar title="审核" icon="icon-edit" url="wuyeSfglYsfyjlController.do?doShenhe" funname="shenheALLSelect"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/wuyesfgl/wuyeSfglYsfyjlList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });



 </script>