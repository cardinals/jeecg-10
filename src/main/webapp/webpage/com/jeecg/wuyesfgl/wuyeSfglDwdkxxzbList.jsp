<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<link rel="stylesheet" type="text/css"
	href="plug-in/ztree/css/zTreeStyle.css">
<script type="text/javascript"
	src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript"
	src="plug-in/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
<div class="easyui-layout" fit="true"
	style="width: 1000px; height: 600px;">
	<div region="west" split="true" title="" style="width:500px;">
		<t:datagrid name="wuyeSfglDkxxzbList" checkbox="true"
			pagination="true" fitColumns="false" title="单位代扣信息主表"
			actionUrl="wuyeSfglDwdkxxzbController.do?datagrid" idField="id"
			fit="true" queryMode="group">
			<t:dgCol title="主键" field="id" hidden="true" queryMode="single"
				width="120"></t:dgCol>
			
			<t:dgCol title="计费年度" field="year" queryMode="single" width="90" dictionary="year"></t:dgCol>
			<t:dgCol title="计费月份" field="month" queryMode="single" width="90" dictionary="months"></t:dgCol>
			<t:dgCol title="代扣单位" field="dkdw" dictionary="dkrDkdw" queryMode="single" width="90"></t:dgCol>
			<t:dgCol title="操作" field="opt" width="150"></t:dgCol>
			
			<t:dgFunOpt  title="生成扣款"  funname="doCreate(id)" urlclass="ace_button" />
			<t:dgFunOpt  title="代扣信息"  funname="doSelect(id)" urlclass="ace_button"/>
			<t:dgToolBar title="录入" icon="icon-add"
				url="wuyeSfglDwdkxxzbController.do?goAdd" funname="add"></t:dgToolBar>
			<t:dgToolBar title="编辑" icon="icon-edit"
				url="wuyeSfglDwdkxxzbController.do?goUpdate" funname="update"></t:dgToolBar>
			<t:dgToolBar title="删除"  icon="icon-remove" url="wuyeSfglDwdkxxzbController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
			<t:dgToolBar title="详情" icon="icon-search"
				url="wuyeSfglDwdkxxzbController.do?goUpdate" funname="detail"></t:dgToolBar>
			
		</t:datagrid>
	</div>
</div>
<div region="center" style="width: 500px;" id="sitePanel"
	class="easyui-panel">
	<iframe id="listFrame" src="" frameborder=0 width="100%" height="100%"></iframe>
</div>
<script src="webpage/com/jeecg/wuyesfgl/wuyeSfglDkxxzbList.js"></script>
<script type="text/javascript">
	/* 生成扣款 */
	function doCreate(id){
		var url = "wuyeSfglDwdkxxController.do?list&zbid="+id;
		
		parent.layer.confirm('确定生成当单位代扣扣款?', {icon: 3, title:'提示'}, function(index){
			//异步执行参数发送，以及添加操作
			 $.post("wuyeSfglDwdkxxzbController.do?insertDaikou",{dkid:id},function(data){
			    $("#listFrame").attr("src", url);
			    layer.msg(data);
			 });
			 parent.layer.close(index);
		});
		
	}
	
	/* 查看代扣信息 */
	function doSelect(id){
		var url = "wuyeSfglDwdkxxController.do?list&zbid="+id;
		$("#listFrame").attr("src", url);
	}


</script>