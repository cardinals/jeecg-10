<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
	a:hover{cursor:pointer; color: black;}
	.fwxx{margin: 2px; padding: 2px; background-color: #FAFCFD; border:1px solid; border-color: #CCEFF5;}
	.dy{float: left; text-align: center;  margin-right: 10px; margin-top:5px; border: 1px solid;}
	.zt{width:120px; height:75px; background-color: #EEE9E9;}
	.zts{height: 25px; line-height: 25px; text-align: center;}
	.zl{background-color: #FFF68F;}
	.rz{background-color: #BFEFFF;}
</style>
<title>房屋状态图示</title>
<t:base type="jquery,easyui,tools"></t:base>
<link rel="stylesheet" href="plug-in/ztree/css/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/ztreeCreator.js"></script>
</head>
<body>
	<div class="easyui-layout" fit="true" scroll="no">
		<div  data-options="region:'west',title:'管理区域',split:true" style="width:200px;overflow: auto;">
			 <div class="clear">
			 </div> 
	        <div id="orgTree" class="ztree">
	        </div>
	        <input type="hidden" id="userName" name="userName" value="${userName}"/>
		</div>
		<div data-options="region:'center'" title="房屋状态图示" id="fwztts">
			<div id="fwxx">
			</div>
			<div id="dyh" style="margin: 2px; padding: 2px;">
			</div>
        </div>
	</div>
</body>
</html>
 <script src = "webpage/com/jeecg/wuyeglq/wuyeFwxxList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });

//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wuyeFwxxController.do?upload', "wuyeFwxxList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wuyeFwxxController.do?exportXls","wuyeFwxxList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wuyeFwxxController.do?exportXlsByT","wuyeFwxxList");
}

//加载树
var orgTree ;
function loadTree() {
	var zNodes;
	jQuery.ajax({  
        async : false,  
        cache:false,  
        type: 'POST',  
        dataType : "json",  
        url: 'wuyeFwxxController.do?getTreeData',//请求的action路径  
        error: function () {//请求失败处理函数  
            alert('请求失败');  
        },  
        success:function(data){ //请求成功后处理函数。
			console.log(data.obj)
            zNodes = data.obj;   //把后台封装好的简单Json格式赋给zNodes  
        }  
    });  
	var ztreeCreator = new ZtreeCreator('orgTree',"jeecgDemoController.do?getTreeData",zNodes)
 			.setCallback({onClick:zTreeOnLeftClick,onRightClick:zTreeOnRightClick})
 			.initZtree({},function(treeObj){orgTree = treeObj});
};

//左击
function zTreeOnLeftClick(event, treeId, treeNode) {	
 	curSelectNode = treeNode;
	var parentId = treeNode.id;
/* 	var url = "departController.do?update&id=" + curSelectNode.id; */
	if(treeNode.glqlx=="4"){
/* 		$.topCall.warn('该节点为根节点，请点击具体的组织');
		return false; */					
		$("#ztts").empty();
		$("#fwxx").empty();
		$("#dyh").empty();
		$.ajax({
			url:"wuyeFwztController.do?getDyzt",
			data:"lyid="+parentId,
			type:"POST",
			dataType : "json",
	        success:function(data){
	        	console.log(data)
				if(data.obj != null){
					for(var i = 0; i < data.obj.length; i++){						
						$("#dyh").append("<div id="+(data.obj[i])+"_dy"+"><a>"+(data.obj[i])+"单元</a></div>");
						$("#"+(data.obj[i])+"_dy").addClass("dy");
						lcxx(parentId,(data.obj[i]));
					}	
				}
				$("#fwxx").append("<table><tbody><tr><td><table><tbody><tr><td>房间数:</td><td>"+data.attributes.fjs+"&nbsp;</td><td>建筑面积:</td><td>"+(data.attributes.jzmj).toFixed(2)+"㎡&nbsp;</td><td>闲置:</td><td>"+data.attributes.fjs_kz+"&nbsp;</td><td>入住:</td><td>"+data.attributes.fjs_rz+"&nbsp;</td>");
				$("#fwxx").addClass("fwxx");
				/* $("#fwxx").append("<table><tbody><tr><td><img src="+"images/qianfei.png"+" alt="+"欠费提醒"+" border="+"0"+"></td><td>欠费:</td><td>98&nbsp;</td><td><img src="+"images/fydq.gif"+" alt="+"费用到期"+" border="+"0"+"></td><td>费用到期:</td><td>4&nbsp;</td><td><img src="+"images/htdq.png"+" alt="+"合同到期提醒"+" border="+"0"+"></td><td>合同到期:</td><td>1&nbsp;</td></tr></tbody></table>");	 */	
	        }  
		});
	}
};
function lcxx(parentId,dy){
 	$.ajax({
		url:"wuyeFwztController.do?getFwzt",
		data:"lyid="+parentId+"&dy="+dy,
		type:"POST",
		dataType : "json",
	    success:function(lcdata){	    	
	    	for(var j = 0; j < lcdata.attributes.zlcs; j++){
	    		$("#"+dy+"_dy").append("<div id="+(j+1)+"l"+"><table><tbody><tr id="+dy+"_"+(j+1)+"_lct"+"><td>"+(j+1)+"&nbsp;楼&nbsp;</td></div>");
	    	}
			$.each(lcdata.obj,function(index,fwxx){
				$("#"+dy+"_"+fwxx.lch+"_lct").append("<td id="+dy+"_"+fwxx.fjid+"_fjid"+"></td>");
 				$("#"+dy+"_"+fwxx.fjid+"_fjid").addClass("zt");
				$("#"+dy+"_"+fwxx.fjid+"_fjid").append("<div id="+dy+"_"+fwxx.fjid+"_bh"+"></div><div id="+dy+"_"+fwxx.fjid+"_xm"+"></div><div id="+dy+"_"+fwxx.fjid+"_zt"+"></div>");
				$("#"+dy+"_"+fwxx.fjid+"_bh").html(fwxx.fjbh);
				$("#"+dy+"_"+fwxx.fjid+"_zt").html(fwxx.fwzt);
				$("#"+dy+"_"+fwxx.fjid+"_fjid div").addClass("zts");
				if($("#"+dy+"_"+fwxx.fjid+"_zt").html()=='rz'){					
					if(fwxx.zflb=="0"){
						$.ajax({
							url:"wuyeFwztController.do?getYzxm_yz",
							data:"fjid="+fwxx.fjid,
							type:"POST",
							dataType : "json",
					        success:function(xmdata){
					        	$("#"+dy+"_"+fwxx.fjid+"_xm").html(xmdata.obj);
					        }					
						})
						$("#"+dy+"_"+fwxx.fjid+"_zt").html("非闲（自住）");
						$("#"+dy+"_"+fwxx.fjid+"_fjid").addClass("rz");
					}else if(fwxx.zflb=="1"){
						$.ajax({
							url:"wuyeFwztController.do?getYzxm_zh",
							data:"fjid="+fwxx.fjid,
							type:"POST",
							dataType : "json",
					        success:function(xmdata){
					        	$("#"+dy+"_"+fwxx.fjid+"_xm").html(xmdata.obj);
					        }					
						})
						$("#"+dy+"_"+fwxx.fjid+"_zt").html("非闲（租赁）");
						$("#"+dy+"_"+fwxx.fjid+"_fjid").addClass("zl");
						$("#"+dy+"_"+fwxx.fjid+"_xm").css("line-height","12px");
					}
				}else if($("#"+dy+"_"+fwxx.fjid+"_zt").html()=='xz'){
					$("#"+dy+"_"+fwxx.fjid+"_zt").html("闲置");
				}
			})
	    }
		
	})	 
}

/**
 * 树右击事件
 */
function zTreeOnRightClick(e, treeId, treeNode) {	
	if (treeNode) {
		orgTree.selectNode(treeNode);
		curSelectNode=treeNode;
		var isfolder = treeNode.isFolder;
		var h = $(window).height();
		var w = $(window).width();
		var menuWidth = 120;
		var menuHeight = 75;
		var menu = null;
		if (treeNode != null) {
			menu = $('#orgMenu');
		}
		var x = e.pageX, y = e.pageY;
		if (e.pageY + menuHeight > h) {
			y = e.pageY - menuHeight;
		}
		if (e.pageX + menuWidth > w) {
			x = e.pageX - menuWidth;
		}
		menu.menu('show', {
			left : x,
			top : y
		});
	}
};
//菜单对应项
function menuHandler(item) {
	if ('add' == item.name) {
		addNode();
	} else if ('remove' == item.name) {
		delNode();
	} else if ('sort' == item.name) {
		sortNode();
	} else if ('edit' == item.name) {
		editNode(1);
	} else if ('fresh' == item.name) {
		refreshNode();
	}
};
function refreshNode() {
	loadTree();
};

//添加节点
function addNode() {
	var selectNode = getSelectNode();
	if (!selectNode) 	return;
	var url = "departController.do?add&id=" + selectNode.id;
	$("#listFrame").attr("src", url);

};

//编辑节点
function editNode(type) {
	var selectNode = getSelectNode();
	if (!selectNode) 	return;
	//根节点 不能编辑
	if(selectNode.id=="0" && type==1 ){
		$.topCall.warn('该节点为根节点，不可编辑');
		return;
	}

	var url = "departController.do?update&id=" + selectNode.id;
	$("#listFrame").attr("src", url);

};


//删除
function delNode() {
	var selectNode = getSelectNode();
	var nodeId = selectNode.id;
	if (nodeId == "0") {
		$.topCall.warn('该节点为根节点，不可删除');
		return;
	} 
	var url = "jeecgFormDemoController.do?del&id="+nodeId;
	if(!confirm('温馨提示', '确定删除该组织以及该组织下的所有子组织？')){
		return;
	}
	jQuery.ajax({  
        async : false,  
        cache:false,  
        type: 'GET',  
        dataType : "json",  
        url: url,//请求的action路径  
        error: function () {//请求失败处理函数  
            alert('请求失败');  
        },  
        success:function(data){ //请求成功后处理函数。
		    if(data.success){
		    	orgTree.removeNode(selectNode);
				$("#listFrame").attr("src", "about:blank");
		    }else{
		    	alert(data.msg);
		    }
        }  
    });  
	
};
//选择资源节点。
function getSelectNode() {
	orgTree = $.fn.zTree.getZTreeObj("orgTree");
	var nodes = orgTree.getSelectedNodes();
	var node = nodes[0];
	return node;
};
</script>
<script>
	$(function() {
		loadTree();
	});

 </script>