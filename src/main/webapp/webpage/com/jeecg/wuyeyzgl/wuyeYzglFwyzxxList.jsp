<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wuyeYzglFwyzxxList" checkbox="true" pagination="true" fitColumns="false" title="业主档案管理" actionUrl="wuyeYzglFwyzxxController.do?datagrid" idField="id" fit="true" queryMode="group">
  
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="管理区id"  field="glqid" hidden="true"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房屋主键"  field="fwxxid" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间ID"  field="fjid"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="业主编码"  field="yzBm"  queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="业主属性"  field="yzSx"  queryMode="single"  width="120" dictionary="yzSx"></t:dgCol>
   <t:dgCol title="业主类型"  field="yzLx" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="业主名称"  field="yzMc"  queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="联系人"  field="yzLxr"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="yzXb"  queryMode="single" dictionary="sex"  width="120"></t:dgCol>
   <t:dgCol title="出生日期"  field="yzCsrq"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="身份证号"  field="yzSfzh"  queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="工作单位"  field="yzGzdw"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="座机号"  field="yzZuoj"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="手机号"  field="yzShouj"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="传真号"  field="yzChuanz"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="业主现状"  field="yzXz"  queryMode="single" dictionary="yzXz" width="120"></t:dgCol>
   <t:dgCol title="代扣人姓名"  field="dkrXm"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="代扣方式"  field="dkrDkfs" dictionary="dkrDkfs" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="代扣银行"  field="dkrDkyh" dictionary="dkrDkyh" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="代扣银行账号"  field="dkrDkyhzh"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="代扣单位"  field="dkrDkdw"  queryMode="single" dictionary="dkrDkdw" width="120"></t:dgCol>
   <t:dgCol title="代扣单位工号"  field="dkrDkdwgh"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="代扣人联系电话"  field="dkrLxdh"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="代扣人现状"  field="dkrXz"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="担保人姓名"  field="dbrXm"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="担保人单位"  field="dbrDw"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="担保人工号"  field="dbrGh"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="担保人联系电话"  field="dbrLxdh"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否减免"  field="sfjm" queryMode="single"  width="120" query="true" dictionary="cfcz"></t:dgCol>
   <t:dgCol title="减免类型"  field="jmyy"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费开始日期"  field="sfksrq"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费截止日期"  field="sfjzrq"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bz"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="有效标志" hidden="true" field="yxbz"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wuyeYzglFwyzxxController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <%-- <t:dgToolBar title="录入" icon="icon-add" url="wuyeYzglFwyzxxController.do?goAdd" funname="add"></t:dgToolBar> --%>
   <t:dgToolBar title="完善信息" icon="icon-edit" url="wuyeYzglFwyzxxController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wuyeYzglFwyzxxController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="wuyeYzglFwyzxxController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/wuyeyzgl/wuyeYzglFwyzxxList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wuyeYzglFwyzxxController.do?upload', "wuyeYzglFwyzxxList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wuyeYzglFwyzxxController.do?exportXls","wuyeYzglFwyzxxList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wuyeYzglFwyzxxController.do?exportXlsByT","wuyeYzglFwyzxxList");
}

 </script>