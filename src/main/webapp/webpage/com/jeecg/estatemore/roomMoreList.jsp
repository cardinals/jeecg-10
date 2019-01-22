<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="roomMoreList" checkbox="true" pagination="true" fitColumns="true" title="房间扩展信息表" actionUrl="roomMoreController.do?datagrid" idField="id" sortName="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间id"  field="roomId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="产权人"  field="propertyRight"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="产权人证件号"  field="propertyIdcard"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入住时间"  field="liveDate"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否为减免户"  field="isoff"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="减免原因"  field="offReason"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="roomMoreController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="roomMoreController.do?goAdd" funname="add"  width="768"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="roomMoreController.do?goUpdate" funname="update"  width="768"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="roomMoreController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="roomMoreController.do?goUpdate" funname="detail"  width="768"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'roomMoreController.do?upload', "roomMoreList");
}

//导出
function ExportXls() {
	JeecgExcelExport("roomMoreController.do?exportXls","roomMoreList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("roomMoreController.do?exportXlsByT","roomMoreList");
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
