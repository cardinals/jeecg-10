<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="roomList" checkbox="true" pagination="true" fitColumns="true" title="房间表" actionUrl="roomController.do?datagrid" idField="id" sortName="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间编号"  field="roomNo"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="管区id"  field="managerId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="小区id"  field="commId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="楼宇id"  field="buildingId"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间类型"  field="roomType"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间状态"  field="roomStatus"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="装修情况"  field="decorateStatus"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="建筑面积"  field="buildArea"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="套内面积"  field="roomArea"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费服务对象"  field="chargeFor"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="公摊面积"  field="publicArea"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间顺序号"  field="roomNum"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间用途"  field="roomUseful"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="楼层数"  field="roomFloor"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="权属类型"  field="rightType"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="地址"  field="roomAddress"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单元号"  field="roomUnity"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="note"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="朝向"  field="roomToward"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="roomController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="roomController.do?goAdd" funname="add"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="roomController.do?goUpdate" funname="update"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="roomController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="roomController.do?goUpdate" funname="detail"  width="800" height="500"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'roomController.do?upload', "roomList");
}

//导出
function ExportXls() {
	JeecgExcelExport("roomController.do?exportXls","roomList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("roomController.do?exportXlsByT","roomList");
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
