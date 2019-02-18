<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wuyeSfglFjsfxmszList" checkbox="true" pagination="true" fitColumns="true" title="收费项目批量设置" actionUrl="wuyeSfglFjsfxmszPiliangController.do?datagrid" idField="id" fit="true" queryMode="group">
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
   
  	<t:dgCol title="管理区ID"  field="glqid" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="楼宇ID"  field="lyid" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房屋主键"  field="fwxxid" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间ID"  field="fjid" hidden="true" queryMode="single"  width="120"></t:dgCol> 
   <t:dgCol title="收费项目ID" hidden="true" field="sfxmid"  queryMode="single"  width="120"></t:dgCol>
   
   
   <t:dgCol title="管理处"  field="glqmc"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费项目代码"  field="xmdm"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费项目名称"  field="xmmc"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费单价"  field="jfdj"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否收费"  field="sfbz"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费周期"  field="jfzq"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费周期单位"  field="jfzqdw"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="优惠类型" dictionary="yhlx" field="yhlx"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="折扣/金额"  field="yhbl"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bz"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" hidden="true" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wuyeSfglFjsfxmszController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wuyeSfglFjsfxmszController.do?goAdd&fjid=${fjid}" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wuyeSfglFjsfxmszController.do?goUpdate&fjid=${fjid}" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wuyeSfglFjsfxmszController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="wuyeSfglFjsfxmszController.do?goUpdate&fjid=${fjid}" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/wuyesfgl/wuyeSfglFjsfxmszList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wuyeSfglFjsfxmszController.do?upload', "wuyeSfglFjsfxmszList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wuyeSfglFjsfxmszController.do?exportXls","wuyeSfglFjsfxmszList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wuyeSfglFjsfxmszController.do?exportXlsByT","wuyeSfglFjsfxmszList");
}

 </script>