<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wuyeCbglSbcbjlList" checkbox="true" pagination="true" fitColumns="true" title="水表抄表记录" actionUrl="wuyeCbglSbcbjlController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="管理区" dictionary="wuye_glq,id,glqmc" field="glqid"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="房屋主键" hidden="true" field="fwxxid"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="房间编号" dictionary="wuye_fwxx,fjid,fjbh" field="fjid"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="计费起始日期"  field="jfqsrq"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="计费结束日期"  field="jfjsrq"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>   
   <t:dgCol title="姓名"  field="xm"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="房间地址"  field="fjdz"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="仪表属性"  field="ybsx"  queryMode="group"  dictionary="ybsx"  width="120"></t:dgCol>
   <t:dgCol title="仪表ID" hidden="true" field="ybid"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="仪表编号"  field="ybbh"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="上月指数"  field="syzs"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="本月指数"  field="byzs"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="倍率"  field="bl"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="本月流量"  field="byyl"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="换表用量"  field="hbyl"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公摊量"  field="gtl"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="实际用量"  field="sjyl"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="抄表人"  field="cbr"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="抄表时间"  field="cbsj"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bz"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wuyeCbglSbcbjlController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wuyeCbglSbcbjlController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wuyeCbglSbcbjlController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wuyeCbglSbcbjlController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="wuyeCbglSbcbjlController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%-- <t:dgToolBar title="导入抄表" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
   <t:dgToolBar title="导出现有抄表" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
  <%--  <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
   <t:dgToolBar title="导出抄表模板" icon="icon-putout" funname="dcScmb"></t:dgToolBar>
   <t:dgToolBar title="导入抄表模板" icon="icon-put" funname="drScmb"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/wuyecbgl/wuyeCbglSbcbjlList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
  function dcScmb(){
	  JeecgExcelExport("wuyeCbglSbcbjlController.do?dcscmb","wuyeCbglSbcbjlList");
  }
 
  function drScmb(){
	  openuploadwin('Excel导入', "wuyeCbglSbcbjlController.do?upload1","wuyeCbglSbcbjlList");
  }
  
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wuyeCbglSbcbjlController.do?upload', "wuyeCbglSbcbjlList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wuyeCbglSbcbjlController.do?exportXls","wuyeCbglSbcbjlList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wuyeCbglSbcbjlController.do?exportXlsByT","wuyeCbglSbcbjlList");
}

 </script>