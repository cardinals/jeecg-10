<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="communityList" checkbox="true" pagination="true" fitColumns="true" title="小区表" actionUrl="communityController.do?datagrid&fatherId=${fatherId}" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="小区名称"  field="commName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="小区地址"  field="commAddress"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="小区负责人"  field="commMan"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="联系电话"  field="commPhone"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属管区id"  field="fatherId"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="占地面积"  field="coverArea"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="建筑面积"  field="buildingArea"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人"  field="createBy"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createDate"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="communityController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgDefOpt title="查看楼宇" url="buildingController.do?list&commId={id}" urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="communityController.do?goAdd&fatherId=${fatherId}" funname="add"  width="768"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="communityController.do?goUpdate" funname="update"  width="768"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="communityController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="communityController.do?goUpdate" funname="detail"  width="768"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'communityController.do?upload', "communityList");
}

//导出
function ExportXls() {
	JeecgExcelExport("communityController.do?exportXls","communityList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("communityController.do?exportXlsByT","communityList");
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
