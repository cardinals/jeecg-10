<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" id="vvv" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wuyeSfglYsfyjlList" checkbox="true" pagination="false" fitColumns="false" title="收费明细" actionUrl="wuyeSfglYsfyjlController.do?datagrid&lyid=${lyid}" idField="ysfyjl" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="管区ID" hidden="true" field="glqid"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="管理区"  field="glqmc"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="小区ID" hidden="true" field="xqid"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="楼宇ID" hidden="true" field="lyid"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房屋主键" hidden="true" field="fwxxid"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间ID"  field="fjid"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间编号"  field="fjbh"  queryMode="single"  width="120" query="true" ></t:dgCol>
   <t:dgCol title="业主主键" hidden="true" field="fwyzxxid"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="业主姓名"  field="yzmc"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费状态"  field="sfzt"  queryMode="single" dictionary="sfzt" width="120" query="true" ></t:dgCol>
   <t:dgCol title="收费项目代码"  field="sfxmdm"  queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="收费项目名称"  field="sfxmmc"  queryMode="single"  width="120" query="true"></t:dgCol>
   <t:dgCol title="计费起始时间"  field="jfqssj"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费终止时间"  field="jfjzsj"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="数量"  field="sl"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="价格"  field="jg"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="应收金额"  field="ysje"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="起数"  field="qss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="止数"  field="jzs"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="倍率"  field="bl"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="公摊"  field="gts"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费年度"  field="jfnd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费月份"  field="jfyf"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费起始日期"  field="sfqsrq"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费截止日期"  field="sfjzrq"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="滞纳金起始日期"  field="znjqsrq"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bz"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核状态"  field="shzt"  queryMode="single" dictionary="shzt" width="120" query="true"></t:dgCol>
   <t:dgCol title="审核时间"  field="shsj"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核人员"  field="shry"  queryMode="single"  width="120"></t:dgCol>
  <%--  <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wuyeSfglYsfyjlController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wuyeSfglYsfyjlController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="修改" icon="icon-edit" url="wuyeSfglYsfyjlController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wuyeSfglYsfyjlController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
   <t:dgToolBar title="查看" icon="icon-search" url="wuyeSfglYsfyjlController.do?goUpdate" funname="detail"></t:dgToolBar>
  <%--  <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
   <t:dgToolBar title="审核" icon="icon-edit" url="wuyeSfglYsfyjlController.do?doShenhe" funname="shenheALLSelect"></t:dgToolBar>  --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/wuyesfgl/wuyeSfglYsfyjlList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });


 /**
  * 审核
  * @param title
  * @param url
  * @param gname
  * @return
  */
 function shenheALLSelect(title,url,gname) {
 	gridname=gname;
     var ids = [];
     var rows = $("#"+gname).datagrid('getSelections');
     if (rows.length > 0) {
     	$.dialog.setting.zIndex = getzIndex(true);
     	$.dialog.confirm('你确定通过审核吗?', function(r) {
 		   if (r) {
 				for ( var i = 0; i < rows.length; i++) {
 					ids.push(rows[i].id);
 				}
 				console.log(ids);
 				$.ajax({
 					url : url,
 					type : 'post',
 					data : {
 						ids : ids.join(',')
 					},
 					cache : false,
 					success : function(data) {
 						var d = $.parseJSON(data);
 						if (d.success) {
 							var msg = d.msg;
 							tip(msg);
 							reloadTable();
 							$("#"+gname).datagrid('unselectAll');
 							ids='';
 						}
 					}
 				});
 			}
 		});
 	} else {
 		tip("请选择需要审核的数据");
 	}
 } 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wuyeSfglYsfyjlController.do?upload', "wuyeSfglYsfyjlList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wuyeSfglYsfyjlController.do?exportXls","wuyeSfglYsfyjlList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wuyeSfglYsfyjlController.do?exportXlsByT","wuyeSfglYsfyjlList");
}

 </script>