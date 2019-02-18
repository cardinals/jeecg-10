<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wuyeCbglFjbList" checkbox="true" pagination="true" fitColumns="true" title="房间表管理" actionUrl="wuyeCbglGtbController.do?datagrid_ly" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="管理区" dictionary="wuye_glq,id,glqmc" field="glqid"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房屋主键" hidden="true" field="fwxxid"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间编号" dictionary="wuye_fwxx,fjid,fjbh" field="fjid"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="公摊表编号" dictionary="wuye_cbgl_gtb,id,ybbh"  field="gtbid"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间地址"  field="fjdz"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费项目代码" dictionary="wuye_sfgl_sfxmsz,xmdm,xmmc" field="sfxmdm"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="仪表编号"  field="ybbh"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="仪表类型"  field="yblx"  queryMode="single"  dictionary="yblx"  width="120"></t:dgCol>
   <t:dgCol title="倍率"  field="bl"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="初始读数"  field="csds"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="有效标志" hidden="true" field="yxbz"  queryMode="single"  width="120"></t:dgCol>
   <t:dgToolBar title="查看" icon="icon-search" url="wuyeCbglFjbController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="批量修改"  icon="icon-remove" url="wuyeCbglGtbController.do?doPl" funname="doPl"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/wuyecbgl/wuyeCbglFjbList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wuyeCbglFjbController.do?upload', "wuyeCbglFjbList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wuyeCbglFjbController.do?exportXls","wuyeCbglFjbList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wuyeCbglFjbController.do?exportXlsByT","wuyeCbglFjbList");
}

function doPl(title,url,gname) {
	gridname=gname;
    var ids = [];
    var rows = $("#"+gname).datagrid('getSelections');
    if (rows.length > 0) {
    	$.dialog.setting.zIndex = getzIndex(true);
    	$.dialog.confirm('你确定修改该数据吗?', function(r) {
		   if (r) {
				for ( var i = 0; i < rows.length; i++) {
					ids.push(rows[i].id);
				}
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
		tip("请选择需要修改的数据");
	}
}
 </script>