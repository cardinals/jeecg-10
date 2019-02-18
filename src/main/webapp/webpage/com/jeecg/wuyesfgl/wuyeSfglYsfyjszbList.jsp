<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<link rel="stylesheet" type="text/css" href="plug-in/ztree/css/zTreeStyle.css">
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
<div class="easyui-layout" fit="true" style="width: 1000px; height: 600px;">
	<div region="west" split="true" title=""  style="width: 530px;">
   <t:datagrid name="wuyeSfglYsfyjszbList"  pagination="true" fitColumns="true" title="应收费用计算表" actionUrl="wuyeSfglYsfyjszbController.do?datagrid" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="算费范围"  field="sffwmc"  queryMode="single"  width="200"></t:dgCol>
   <t:dgCol title="算费范围id"  field="sffw"  queryMode="single"  formatterjs="treeFormater" width="120" hidden="true"></t:dgCol>
   <t:dgCol title="计费年度"  field="jfnd"  queryMode="single"  dictionary="year"  width="100"></t:dgCol>
   <t:dgCol title="计费月份"  field="jfyf"  queryMode="single"  dictionary="months"  width="80"></t:dgCol>   
   <t:dgCol title="操作" field="opt" width="300"></t:dgCol>
   <t:dgDelOpt  title="删除" url="wuyeSfglYsfyjszbController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgFunOpt  title="收费项目"  funname="sumbitClick(id)" urlclass="ace_button" urlfont="fa-home"/>
   <t:dgFunOpt  title="计算"  funname="countClick(id)" urlclass="ace_button" urlfont="fa-clock-o"/>
   <t:dgToolBar title="添加" icon="icon-add" url="wuyeSfglYsfyjszbController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wuyeSfglYsfyjszbController.do?goUpdate" funname="update"></t:dgToolBar>    
   <%-- <t:dgToolBar title="删除"  icon="icon-remove" url="wuyeSfglYsfyjszbController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="wuyeSfglYsfyjszbController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
	</div>	
</div>
<div region="center"  style="width: 500px;"id="sitePanel" class="easyui-panel">
<iframe id="listFrame" src=""  frameborder=0 width="100%" height="100%"></iframe>
</div>
<script>	
	function sumbitClick(id){
		var url = "wuyeSfglYsfyjsxmController.do?list&id="+id;
		$("#listFrame").attr("src", url);
	}
	//计算
	function countClick(id){
		jQuery.ajax({  
	        cache: false,  
	        type: 'POST',  
	        dataType : "json",  
	        url: "wuyeSfglYsfyjsxmController.do?countCost",//请求的action路径  
	        data:{'id':id},
	        error: function () {//请求失败处理函数  
	            alert('请求失败');  
	        },
		    success:function(data){ //请求成功后处理函数
		    	parent.layer.close(1);
		    	parent.layer.msg(data.msg);
	        }  
	    });
		//加载层
		parent.layer.msg('正在计算...', {
		  index:1,
		  icon: 16,
		  shade: 0.01,
		  time: 0
		});
	}
	
</script>