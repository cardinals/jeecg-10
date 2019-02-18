<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>应收费用审核</title>
<t:base type="jquery,easyui,tools"></t:base>
<link rel="stylesheet" href="plug-in/ztree/css/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/ztreeCreator.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
</head>
<body>
	<div class="easyui-layout" fit="true" scroll="no">
		<div  data-options="region:'west',title:'应收费用审核',split:true" style="width:200px;overflow: auto;">
			 <div class="clear"></div> 
			 <!-- 显示树 -->
	        <div id="orgTree" class="ztree"></div>
	        
	        <input type="hidden" id="userName" name="userName" value="${userName}"/>
		</div>
		<div data-options="region:'center'" title="">
    		<!-- <iframe width="100%" height="100%" id="center"  src="wuyeSfglFjsfxmszListPiliang.jsp" style="border:1px #fff solid; background:#fff;"></iframe> -->
			<div id="tt" tabPosition="top" border=flase style="width:100%;height:100%;margin:0px;padding:0px;overflow-x:hidden;width:auto;" class="easyui-tabs" fit="true">
				
			</div> 
        </div>

		
	</div>
</body>
</html>
<script>
$(function() {
	//加载数
	 $.fn.zTree.init($("#orgTree"), setting);
	
});


	//加载树
	var orgTree ;
	var setting = {  
	       data: {  
	           simpleData: {  
	               enable: true,  
	               idKey: "id",  
	               pIdKey: "fid",  
	               rootPId: 0  
	           }  
	       },  
	       async: {  
	           enable: true,  
	           url: "wuyeGlqController.do?getMyTreeData",  
	           autoParam: ["id"]  
	       }, 
	      /*  check:{
	    	   	enable: true,
		   		chkStyle: "checkbox",
		   		chkboxType: { "Y": "s", "N": "s" }
		   }, */
	       // 回调函数  
	       callback : {  
	           onCheck: function(event, treeId, treeNode) {  
	        	   zTreeOnCheck(event, treeId, treeNode)
	           },
	           onClick : function(event, treeId, treeNode, clickFlag) {  
	          	 	zTreeOnLeftClick(event, treeId, treeNode)
	           },
	       }  
	
	};  
	
	
	//左击
	function zTreeOnLeftClick(event, treeId, treeNode) {
		//获得所选中楼宇的主键
		//console.log(treeNode.id);
		//把楼宇id发送到后台
		var url = "&lyid = " + treeNode.id;
		
		$.post('wuyeSfglYsfyjlController.do?dataOfPost',{lyid:treeNode.id},function(){
			var url = "wuyeSfglYsfyjlController.do?list_child";
			$('#tt').html('<iframe scrolling="yes" frameborder="0"  src="'+url+'" width="100%" height="100%"></iframe>');
		}) 
	};
	
	
</script>
