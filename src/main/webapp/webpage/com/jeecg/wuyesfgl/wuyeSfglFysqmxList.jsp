<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wuyeSfglFysqmxList" checkbox="true" pagination="true" fitColumns="false" title="费用收取明细" actionUrl="wuyeSfglFysqmxController.do?datagrid" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="管理区id"  field="glqid"  queryMode="single"  width="120" hidden="true" ></t:dgCol>
   <t:dgCol title="收费主表id"  field="sfzbid"  queryMode="single"  width="120" hidden="true" ></t:dgCol>
   <t:dgCol title="应收费用记录id"  field="ysfyjlid"  queryMode="single"  width="120" hidden="true" ></t:dgCol>
   <t:dgCol title="应收类型"  field="sflx"  queryMode="single"  dictionary="yslx"  width="120"  hidden="true" ></t:dgCol>
   <t:dgCol title="收费状态"  field="sfzt"  queryMode="single"  dictionary="sfzt"  width="120"></t:dgCol>
   <t:dgCol title="收费项目代码"  field="sfxmdm"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费项目名称"  field="sfxmmc"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费起始时间"  field="jfqssj"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费截止时间"  field="jfjzsj"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="数量"  field="sl"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="价格"  field="jg"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="应收金额"  field="ysje"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="实收金额"  field="ssje"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="滞纳金"  field="znj"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bz"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
  <%--  <t:dgDelOpt title="删除" url="wuyeSfglFysqmxController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wuyeSfglFysqmxController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wuyeSfglFysqmxController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wuyeSfglFysqmxController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
   <t:dgToolBar title="查看" icon="icon-search" url="wuyeSfglFysqmxController.do?goUpdate" funname="detail"></t:dgToolBar>
 <%--   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/wuyesfgl/wuyeSfglFysqmxList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wuyeSfglFysqmxController.do?upload', "wuyeSfglFysqmxList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wuyeSfglFysqmxController.do?exportXls","wuyeSfglFysqmxList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wuyeSfglFysqmxController.do?exportXlsByT","wuyeSfglFysqmxList");
}

 </script>