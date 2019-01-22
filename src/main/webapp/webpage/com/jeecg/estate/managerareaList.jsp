<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="managerareaList" checkbox="true" pagination="true" fitColumns="true" title="管区表" actionUrl="managerareaController.do?datagrid&fatherId=${fatherId}" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="管区名称"  field="areaName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="管区地址"  field="areaAddress"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="管区负责人"  field="areaMan"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="联系电话"  field="areaPhone"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司id"  field="fatherId"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="占地面积"  field="coverArea"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="建筑面积"  field="buildingArea"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="创建人"  field="createBy"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="160"></t:dgCol>
   <t:dgDelOpt title="删除" url="managerareaController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgDefOpt title="查看小区" url="communityController.do?list&fatherId={id}" urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="managerareaController.do?goAdd&fatherId=${fatherId}" funname="add"  width="768"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="managerareaController.do?goUpdate" funname="update"  width="768"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="managerareaController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="managerareaController.do?goUpdate" funname="detail"  width="768"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'managerareaController.do?upload', "managerareaList");
}

//导出
function ExportXls() {
	JeecgExcelExport("managerareaController.do?exportXls","managerareaList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("managerareaController.do?exportXlsByT","managerareaList");
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
