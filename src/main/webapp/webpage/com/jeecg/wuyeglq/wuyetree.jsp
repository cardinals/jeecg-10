<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>管理区域设置</title>
<t:base type="jquery,easyui,tools"></t:base>
<link rel="stylesheet" href="plug-in/ztree/css/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/ztreeCreator.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
</head>
<body>
	<div class="easyui-layout" fit="true" scroll="no">
		<div  data-options="region:'west',title:'管理区域设置',split:true" style="width:200px;overflow: auto;">
		   <div style="width:85px;float: left;margin-left: 8px;margin-top: 2px;">
			<a class="easyui-linkbutton l-btn l-btn-plain"  onclick="refrash()">
				<span class="bigger-110 no-text-shadow">　点击刷新　</span>
			</a>
			</div>
			 <div class="clear"></div> 
			 <!-- 显示树 -->
	        <div id="orgTree" class="ztree"></div>
	        
	        <input type="hidden" id="userName" name="userName" value="${userName}"/>
		</div>
		<div data-options="region:'center'" title="">
    <!-- <iframe width="100%" height="100%" id="center"  src="" style="border:1px #fff solid; background:#fff;"></iframe> -->
		<div id="tt" tabPosition="top" border=flase style="width:100%;height:100%;margin:0px;padding:0px;overflow-x:hidden;width:auto;" class="easyui-tabs" fit="true"></div>
        </div>

		<div class="hidden">
			<div id="gysMenu" class="easyui-menu" data-options="onClick:menuHandler" style="width: 120px;">
				<div data-options="name:'addSubOrg'">添加下级</div>
				<div data-options="name:'edit'">编辑</div> 
				<div data-options="name:'remove'">删除 </div> 
				<div data-options="name:'fresh'">刷新</div>
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
//刷新
function refrash(){
	//加载数
	 $.fn.zTree.init($("#orgTree"), setting);
}
var flag = true;
var TimeFn = null;


function addtt(title, url, id, icon, closable) {
	$('#tt').tabs('add',{
						id : id,
						title : title,
						content : createFramett(id,url),
						closable : closable = (closable == 'false') ? false
								: true,
						icon : icon
	});
}
$('#tt').tabs({onSelect : function(title) {
						var p = $(this).tabs('getTab', title);
						var url = p.find('iframe').attr('src');
						p.find('iframe').attr('src',url);
					}
				});
function createFramett(id,url) {
	var s = '<iframe id="'+id+'" scrolling="yes" frameborder="0"  src="'+url+'" width="100%" height="100%"></iframe>';
	return s;
}


//beforeDblClick事件
function beforeDbl(){
	flag = false;
	return true;
}
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
	       // 回调函数  
	       callback : {  
	           onClick : function(event, treeId, treeNode, clickFlag) {  
	           	zTreeOnLeftClick(event, treeId, treeNode)
	           }, 
	       	onRightClick : function(event, treeId, treeNode, clickFlag) {  
	       		var e = event;
	       		zTreeOnRightClick(e, treeId, treeNode)
	           }, 
	           onDblClick : function(event, treeId, treeNode, clickFlag) {  
	           	zTreeOnDblClick(event, treeId, treeNode)
	           }  
	
	       }  
	
	};  
	
	//左击
	function zTreeOnLeftClick(event, treeId, treeNode) {
		var selectNode = getSelectNode();
		flag = true;
		clearTimeout(TimeFn);
		setTimeout(function() {
			if (flag) {
				curSelectNode = treeNode;
				var parentId = treeNode.id;
				var orgType = treeNode.orgType;
				closeAllTab();
				var url = "wuyeGlqController.do?comDetail&id="+ treeNode.id;
				addtt('基本信息', url, '01', 'icon-comturn', 'false');

				$("#tt").tabs("select", 0);
			}
		}, 301);
	};
	
	/**
	 * 树右击事件
	 */
	function zTreeOnRightClick(e, treeId, treeNode) {
		if (treeNode) {
			orgTree.selectNode(treeNode);
			curSelectNode = treeNode;
			var isfolder = treeNode.isFolder;
			var h = $(window).height();
			var w = $(window).width();
			var menuWidth = 120;
			var menuHeight = 75;
			var menu = $('#gysMenu');
		
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
	//双击事件
	function zTreeOnDblClick(event, treeId, treeNode) {
		var selectNode = getSelectNode();
		curSelectNode = treeNode;
		
	}
	//菜单对应项
	function menuHandler(item) {
		if ('addSubOrg' == item.name) {
			addSubOrg();
		} else if ('edit' == item.name) {
			editNode();
		} else if ('remove' == item.name) {
			delNode();
		} else if ('fresh' == item.name) {
			refrash();
		}
	};
	
	
	//添加下级部门
	function addSubOrg() {
		var selectNode = getSelectNode();
		
		if(selectNode.glqlx == 4) {
			tip('不能添加下级节点！', {icon: 2});
			return false;
		}
		if (!selectNode)
			return;
		closeAllTab();
		//var url = "functionGroupController.do?add&id="+selectNode.id;
		//$("#listFrame").attr("src", url);
		var url = "wuyeGlqController.do?toAddSubOrg&pid=" + selectNode.id;
		addtt('添加下级部门', url, '01', 'icon-search', 'false');
	};

	

	function closeAllTab() {
		var tabs = $('#tt').tabs("tabs");
		var length = tabs.length;
		for (var i = 0; i < length; i++) {
			var onetab = tabs[0];
			var title = onetab.panel('options').tab.text();
			$("#tt").tabs("close", title);
		}

	}

	//添加一级节点
	function addOneNode() {
		closeAllTab();
		var url = "wuyeGlqController.do?toAddCompany";
		addtt('添加一级公司', url, '01', 'icon-search', 'false');
	};
	//编辑节点
	function editNode() {
		var selectNode = getSelectNode();
		if (!selectNode)
			return;
		//var url = "functionGroupController.do?update&id="+selectNode.id;
		//$("#listFrame").attr("src", url);
		closeAllTab();
		var url = "wuyeGlqController.do?comUpdate&id=" + selectNode.id;
		addtt('编辑', url, '01', 'icon-search', 'false');
	};

	//删除
	function delNode() {
		var selectNode = getSelectNode();
		var nodeId = selectNode.id;
		if (selectNode == 1) {
			tip('该节点为根节点，不可删除');return;
		} 
		var url = "wuyeGlqController.do?doDelYxbz&id=" + selectNode.id;
		if (selectNode.isParent) {
			tip('存在下级机构，不可删除!');
			return;
		}
		layer.confirm('确定删除该机构吗？', {
			btn : [ '确认', '取消' ]
		}, function() {
			jQuery.ajax({
				async : false,
				cache : false,
				type : 'GET',
				dataType : "json",
				url : url,//请求的action路径  
				error : function() {//请求失败处理函数  
					tip('请求失败');
				},
				success : function(data) { //请求成功后处理函数。
					if (data.success) {
						tip(data.msg);
						layer.closeAll();
						orgTree.removeNode(selectNode);
					} else {
						tip(data.msg);
					}
				}
			});
		}, function() {
			return;
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
