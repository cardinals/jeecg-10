<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>	
<link rel="stylesheet" type="text/css" href="plug-in/ztree/css/zTreeStyle.css">
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
<div class="easyui-layout" fit="true" style="width: 1000px; height: 600px;">
	<div region="west" split="true" title=""  style="width: 700px;">
  <t:datagrid name="wuyeSfglFysqzbList" checkbox="true" pagination="true" fitColumns="false" title="费用收取主表" actionUrl="wuyeSfglFysqzbController.do?datagrid" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="管理区id"  field="glqid"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="楼宇id"  field="lyid"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房屋主键"  field="fwwxxid"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间id"  field="fjid"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="业主主键"  field="fwyzxxid"  hidden="true"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="业主名称"  field="yzmc"  queryMode="single"  width="100"  query="true"></t:dgCol>
   <t:dgCol title="计费年度"  field="jfnd"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="计费月份"  field="jfyf"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="收据号"  field="sjh"  queryMode="single"  width="120"  query="true"></t:dgCol>
   <t:dgCol title="费用类型"  field="fylx"  queryMode="single"  dictionary="fylx"  width="80"></t:dgCol>
   <t:dgCol title="交费方式"  field="jffs"  queryMode="single"  dictionary="skfs"  width="80"></t:dgCol>
   <t:dgCol title="应收金额"  field="ysje"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="抹零金额"  field="mlje"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="滞纳金"  field="znj"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="实收金额"  field="ssje"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="客付金额"  field="skje"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="找零金额"  field="zlje"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="收费人员"  field="sfry"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="收费时间"  field="sfsj"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="开票方式"  field="kpfs"  queryMode="single"  width="80"  dictionary="kpfs"></t:dgCol>
   <t:dgCol title="交易号"  field="jyh"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bz"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
<%--    <t:dgDelOpt title="删除" url="wuyeSfglFysqzbController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wuyeSfglFysqzbController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wuyeSfglFysqzbController.do?goUpdate" funname="update"></t:dgToolBar> 
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wuyeSfglFysqzbController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
  <%--  <t:dgToolBar title="查看" icon="icon-search" url="wuyeSfglFysqzbController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
   <%-- <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
   <t:dgFunOpt funname="sumbitClick(id)"  title="明细"  urlclass="ace_button" urlfont="fa-file-o"></t:dgFunOpt>
  </t:datagrid>
	</div>	
</div>
<div region="center"  style="width: 300px;"id="sitePanel" class="easyui-panel">
<iframe id="listFrame" src=""  frameborder=0 width="100%" height="100%"></iframe>
</div>
<script>	
	function sumbitClick(id){
		var url = "wuyeSfglFysqmxController.do?list&id="+id;
		$("#listFrame").attr("src", url);
	}	
</script>
 <script type="text/javascript">
 $(document).ready(function(){
 });
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wuyeSfglFysqzbController.do?upload', "wuyeSfglFysqzbList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wuyeSfglFysqzbController.do?exportXls","wuyeSfglFysqzbList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wuyeSfglFysqzbController.do?exportXlsByT","wuyeSfglFysqzbList");
}
 </script>