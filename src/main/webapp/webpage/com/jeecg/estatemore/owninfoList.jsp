<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="owninfoList" checkbox="true" pagination="true" fitColumns="true" title="业主租户信息" actionUrl="owninfoController.do?datagrid" idField="id" sortName="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间id"  field="roomId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="业主租户名称"  field="ownerName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户属性"  field="ownerAttribute"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="联系人"  field="ownerContact"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="座机"  field="ownerLandline"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="手机号"  field="ownerPhone"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="传真"  field="ownerFax"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="ownerIdcard"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="生日"  field="ownerBirthday"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="其他联系方式"  field="otherContact"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="交房日期"  field="datePayment"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入住日期"  field="liveinDate"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="住户卡号"  field="ownerBankid"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="装修日期"  field="decorateDate"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费开始日期"  field="payStart"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费截止日期"  field="payEnd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人"  field="createBy"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createTime"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="owninfoController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="owninfoController.do?goAdd" funname="add"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="owninfoController.do?goUpdate" funname="update"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="owninfoController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="owninfoController.do?goUpdate" funname="detail"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'owninfoController.do?upload', "owninfoList");
}

//导出
function ExportXls() {
	JeecgExcelExport("owninfoController.do?exportXls","owninfoList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("owninfoController.do?exportXlsByT","owninfoList");
}

//bootstrap列表图片格式化
function btListImgFormatter(value,row,index){
	return listFileImgFormat(value,"image");
}
//bootstrap列表文件格式化
function btListFileFormatter(value,row,index){
	return listFileImgFormat(value);
}

</script>
