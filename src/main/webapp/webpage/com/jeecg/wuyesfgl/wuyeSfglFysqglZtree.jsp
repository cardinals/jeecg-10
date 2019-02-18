<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>物业费用收取</title>
<t:base type="jquery,easyui"></t:base>
<link rel="stylesheet" href="plug-in/ztree/css/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/ztreeCreator.js"></script>
</head>
<body>
	<div class="easyui-layout" fit="true" scroll="no">
		<div  data-options="region:'west',title:'管理区域设置',split:true" style="width:200px;overflow: auto;">
	        <div id="orgTree" class="ztree"></div>
		</div>
		<div data-options="region:'center',border:false" style="text-align: center;">
			 	<iframe id="listFrame" src=""  frameborder="no" width="100%" height="100%"></iframe>
		</div>
	</div>
</body>
</html>
<script>
//加载树
var orgTree ;
var zNodes;
function loadTree() {	
	jQuery.ajax({  
        async:false,  
        cache:false,  
        type: 'POST',  
        dataType : "json",  
        url: 'wuyeFwxxCqbgController.do?getTreeData', //请求的action路径  
        error: function () {//请求失败处理函数  
            alert('请求失败');  
        },  
        success:function(data){ //请求成功后处理函数。
            zNodes = data.obj;   //把后台封装好的简单Json格式赋给zNodes  
        }  
    });  
	var ztreeCreator = new ZtreeCreator('orgTree',"wuyeFwxxCqbgController.do?getTreeData",zNodes)
 			.setCallback({onClick:zTreeOnLeftClick,onRightClick:zTreeOnRightClick})
 			.initZtree({},3,function(treeObj){orgTree = treeObj});
};

//左击
function zTreeOnLeftClick(event, treeId, treeNode) {
	curSelectNode = treeNode;
	var parentId = treeNode.id;
	var url = "wuyeSfglFysqglController.do?list&id=" + curSelectNode.id;
 	for(var i=0;i<zNodes.length;i++){
		if(parentId==zNodes[i].parentId){			
			$("#listFrame").attr("src","");
			return false;
		}
	} 
	$("#listFrame").attr("src", url);
};
/**
 * 树右击事件
 */
function zTreeOnRightClick(e, treeId, treeNode) {	
};

function refreshNode() {
	loadTree();
};
</script>
<script>
	$(function() {
		loadTree();
	});

</script>