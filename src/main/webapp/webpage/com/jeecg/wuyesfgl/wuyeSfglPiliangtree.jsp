<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>收费管理批量设置</title>
<t:base type="jquery,easyui,tools"></t:base>
<link rel="stylesheet" href="plug-in/ztree/css/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/ztreeCreator.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
</head>
<body>
	<div class="easyui-layout" fit="true" scroll="no">
		<div  data-options="region:'west',title:'收费管理批量设置',split:true" style="width:200px;overflow: auto;">
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
	       check:{
	    	   	enable: true,
		   		chkStyle: "checkbox",
		   		chkboxType: { "Y": "s", "N": "s" }
		   },
	       // 回调函数  
	       callback : {  
	           onCheck: function(event, treeId, treeNode) {  
	        	   zTreeOnCheck(event, treeId, treeNode)
	           }
	       }  
	
	};  
	
	//勾选
	function zTreeOnCheck(event, treeId, treeNode) {
		orgTree = $.fn.zTree.getZTreeObj("orgTree");
		var checkedNodes = orgTree.getCheckedNodes(true);
		//console.log(checkedNodes);
		var nodeId = "";
		for(var i = 0; i<checkedNodes.length;i++){
			if(checkedNodes[i].glqlx == 4){
				nodeId += checkedNodes[i].id+",";
			}
		}
		//截取掉字符串最后的 ， 
		nodeId = nodeId.substring(0,nodeId.length-1);
		//console.log(nodeId);
		$.post('wuyeSfglFjsfxmszPiliangController.do?dataOfPost',{nodeId:nodeId},function(){
			
			var url = "wuyeSfglFjsfxmszPiliangController.do?piliangDo&doid=${doid}";
			
			$('#tt').html('<iframe scrolling="yes" frameborder="0"  src="'+url+'" width="100%" height="100%"></iframe>');
		}) 
		
	};
	
	
	
</script>
