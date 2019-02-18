<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="companyList" checkbox="true" pagination="true" fitColumns="true" title="公司表" actionUrl="companyController.do?datagrid" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="物业公司名称"  field="comName"  query="true"  queryMode="single"  width="120" url="managerareaController.do?list&fatherId={id}"></t:dgCol>
   <t:dgCol title="公司负责人"  field="comContact"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="联系电话"  field="comPhone"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人"  field="createBy"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createDate"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="companyController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgDefOpt title="查看管区" url="managerareaController.do?list&fatherId={id}" urlclass="ace_button" urlfont="fa-trash-o"></t:dgDefOpt>
   <t:dgToolBar title="录入" icon="icon-add" url="companyController.do?goAdd" funname="add"  width="768"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="companyController.do?goUpdate" funname="update"  width="768"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="companyController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="companyController.do?goUpdate" funname="detail"  width="768"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
	 //var ahrefformat = function(value,row,index){
		 //return '<a href="javascript:loading(\''+row.id+'\')">'+value+'</a>';
	 //}
 });
 
 	//function loading(id){
 		//window.location.href="managerareaController.do?list";
 	//}  
 
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'companyController.do?upload', "companyList");
}

//导出
function ExportXls() {
	JeecgExcelExport("companyController.do?exportXls","companyList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("companyController.do?exportXlsByT","companyList");
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
