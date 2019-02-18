<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>业主家庭成员</title>
<t:base type="jquery,easyui,tools"></t:base>
<link rel="stylesheet" href="plug-in/ztree/css/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/ztreeCreator.js"></script>
</head>
<body>
	<div class="easyui-layout" fit="true" scroll="no">
	  <!-- <div data-options="region:'east',title:'业主家庭成员',split:true" style="width:600px;overflow:auto;">-->
	  <div data-options="region:'center',title:'业主家庭成员',split:true" style="overflow:auto;"> 
 		<t:datagrid name="wuyeYzglYzjtcyList" checkbox="false" pagination="true" fitColumns="true" actionUrl="wuyeYzglYzjtcyController.do?datagrid" idField="id" fit="true" queryMode="group">
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
		   <t:dgCol title="迁入房间id"  field="fjid" hidden="true" queryMode="single"  width="120"></t:dgCol>
		   <t:dgCol title="业主主键"  field="fwyzxxid" hidden="true" queryMode="single"  width="120"></t:dgCol>
		   <t:dgCol title="户主及家庭成员姓名"  field="jtcyxm"  queryMode="single"  width="120"></t:dgCol>
		   <t:dgCol title="与户主关系"  field="hzgx"  queryMode="single" dictionary="hzgx" width="120"></t:dgCol>
		   <t:dgCol title="性别"  field="xb"  queryMode="single"  dictionary="sex"  width="120"></t:dgCol>
		   <t:dgCol title="身份证号"  field="sfzh"  queryMode="single"  width="120"></t:dgCol>
		   <t:dgCol title="人员现状" dictionary="yzXz" field="gzxz"  queryMode="single"  width="120"></t:dgCol>
		   <t:dgCol title="工作单位"  field="gzdw"  queryMode="single"  width="120"></t:dgCol>
		   <t:dgCol title="备注"  field="bz"  queryMode="single"  width="120"></t:dgCol>
		   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
		   <t:dgDelOpt title="删除" url="wuyeYzglYzjtcyController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
		   <t:dgToolBar title="录入" icon="icon-add" url="wuyeYzglYzjtcyController.do?goAdd&glqid=[glqid]&fwxxid={fwxxid}&fwyzxxid={fwyzxxid}" funname="add"></t:dgToolBar>
		   <t:dgToolBar title="编辑" icon="icon-edit" url="wuyeYzglYzjtcyController.do?goUpdate" funname="update"></t:dgToolBar>
		   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wuyeYzglYzjtcyController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
		   <t:dgToolBar title="查看" icon="icon-search" url="wuyeYzglYzjtcyController.do?goUpdate" funname="detail"></t:dgToolBar>
		   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
		   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
		   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
		   <t:dgToolBar title="返回" icon="icon-putout" funname="fanhui" ></t:dgToolBar>
		</t:datagrid>
		</div>	
	</div>
</body>
</html>
 <script type="text/javascript">
 $(document).ready(function(){
 });
function fanhui(){
	history.go(-1);
}
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wuyeYzglYzjtcyController.do?upload', "wuyeYzglYzjtcyList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wuyeYzglYzjtcyController.do?exportXls","wuyeYzglYzjtcyList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wuyeYzglYzjtcyController.do?exportXlsByT","wuyeYzglYzjtcyList");
}
</script>