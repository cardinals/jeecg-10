<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wuyeCbglFjbList" checkbox="true" pagination="true" fitColumns="true" title="房间表管理" actionUrl="wuyeCbglFjbController.do?datagrid_fj" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="管理区"  field="glqid" dictionary="wuye_glq where glqlx = '2' and yxbz = '1',id,glqmc" queryMode="single"  query="true" width="120" ></t:dgCol>
   <t:dgCol title="房屋主键" hidden="true" field="fwxxid"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间编号" dictionary="wuye_fwxx,fjid,fjbh" field="fjid"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="公摊表编号" dictionary="wuye_cbgl_gtb,id,ybbh"  field="gtbid"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间地址"  field="fjdz"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费项目代码" dictionary="wuye_sfgl_sfxmsz,xmdm,xmmc" field="sfxmdm"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="仪表编号"  field="ybbh"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="仪表类型"  field="yblx" dictionary="yblx" queryMode="single" query="true" width="120"></t:dgCol>
   <t:dgCol title="倍率"  field="bl"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="初始读数"  field="csds"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="有效标志" hidden="true" field="yxbz"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wuyeCbglFjbController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wuyeCbglFjbController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wuyeCbglFjbController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wuyeCbglFjbController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="wuyeCbglFjbController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/wuyecbgl/wuyeCbglFjbList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wuyeCbglFjbController.do?upload', "wuyeCbglFjbList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wuyeCbglFjbController.do?exportXls","wuyeCbglFjbList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wuyeCbglFjbController.do?exportXlsByT","wuyeCbglFjbList");
}

 </script>