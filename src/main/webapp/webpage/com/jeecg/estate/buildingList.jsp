<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="buildingList" checkbox="true" pagination="true" fitColumns="true" title="楼宇表" actionUrl="buildingController.do?datagrid&commId=${commId}" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="楼宇编号"  field="buildNum"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="楼宇名称"  field="buildName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="楼宇地址"  field="buildAddress"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="楼宇类型"  field="buildType"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="楼宇结构"  field="buildStru"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="楼宇朝向"  field="buildToward"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="楼层数" field="buildFloor" queryMode="single" width="80"></t:dgCol>
   <t:dgCol title="备注"  field="note"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属小区id"  field="commId"  query="true"  queryMode="single"  width="120" hidden="true"></t:dgCol>
   <t:dgCol title="所属管区id"  field="manaId"  queryMode="single"  width="120" hidden="true"></t:dgCol>
   <t:dgCol title="所属公司id"  field="comId"  queryMode="single"  width="120" hidden="true"></t:dgCol>
   <t:dgCol title="创建人"  field="createBy"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createDate"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="buildingController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="buildingController.do?goAdd&commId=${commId}&managerId=${managerId}&companyId=${companyId}" funname="add"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="buildingController.do?goUpdate" funname="update"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="buildingController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="buildingController.do?goUpdate" funname="detail"  width="800" height="500"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'buildingController.do?upload', "buildingList");
}

//导出
function ExportXls() {
	JeecgExcelExport("buildingController.do?exportXls","buildingList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("buildingController.do?exportXlsByT","buildingList");
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
