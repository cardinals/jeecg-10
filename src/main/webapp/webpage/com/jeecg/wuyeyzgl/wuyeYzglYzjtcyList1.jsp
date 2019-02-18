<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>房屋业主</title>
<t:base type="jquery,easyui,tools"></t:base>
<link rel="stylesheet" href="plug-in/ztree/css/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/ztreeCreator.js"></script>
</head>
<body>
 <div class="easyui-layout" fit="true" scroll="no">
  <div data-options="region:'center',title:'房屋业主',split:true" style="width：50%; overflow:auto;">
 	  <t:datagrid name="wuyeYzglFwyzxxList" checkbox="false" pagination="true" fitColumns="true" actionUrl="wuyeYzglYzjtcyController.do?dataid" idField="id" fit="true" queryMode="group">
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
	   <t:dgCol title="管理区id"  field="glqid" hidden="true" queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="房屋主键"  field="fwxxid" hidden="true" queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="房间ID"  field="fjid" hidden="true" queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="业主属性"  field="yzSx"  queryMode="single"  width="120" query="true" dictionary="yzSx"></t:dgCol>
	   <t:dgCol title="业主名称"  field="yzMc"  queryMode="single"  width="120" query="true"></t:dgCol>
	   <t:dgCol title="身份证号"  field="yzSfzh"  queryMode="single"  width="120" query="true"></t:dgCol>
	   <t:dgCol title="工作单位"  field="yzGzdw"  queryMode="single"  width="120"></t:dgCol>
	   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
	   <t:dgDefOpt title="添加家庭成员" url="wuyeYzglYzjtcyController.do?list&id={fjid}&glqid={glqid}&fwxxid={fwxxid}&fwyzxxid={id}" urlclass="ace_button"  urlfont="fa-trash-o" ></t:dgDefOpt>
	  </t:datagrid>
  </div>
 </div>
</body>
</html>
 <script type="text/javascript">
 $(document).ready(function(){
 });

//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wuyeYzglYzjtcyController.do?upload', "wuyeFwxxList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wuyeYzglYzjtcyController.do?exportXls","wuyeFwxxList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wuyeYzglYzjtcyController.do?exportXlsByT","wuyeFwxxList");
}
</script>
