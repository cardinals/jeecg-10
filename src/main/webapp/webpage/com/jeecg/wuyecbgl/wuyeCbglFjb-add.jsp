<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>房间表管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <link rel="stylesheet" href="plug-in/ztree/css/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/ztreeCreator.js"></script>  
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
	<div class="easyui-layout" fit="true" scroll="no">
		<div data-options="region:'west',title:'管理区域',split:true"style="width: 167px; overflow: auto;">
			<div id="orgTree" class="ztree"></div>
		</div>
		<div data-options="region:'center',border:false" style="text-align: center; ">
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wuyeCbglFjbController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${wuyeCbglFjbPage.id }"/>
		<table style="width: 580px; display: none;" cellpadding="0" cellspacing="1" class="formtable" id="tab">
				<tr>
					<td align="right">
						<label class="Validform_label">
							房间ID:
						</label>
					</td>
					<td class="value">
					     	<!--  <input id="fjid" name="fjid" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" /> -->
					     	<input id="fjid" name="fjid" type="text" class="inputxt" ignore="ignore" onclick="popupClick(this,'glqid,fjid,id','glqid,fjid,fwxxid','cbgl_fjid')" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房间id</label>
						</td>				
					<td align="right">
						<label class="Validform_label">
							公摊表ID:
						</label>
					</td>
					<td class="value">
					     	<!-- <input id="gtbid" name="gtbid" type="text" style="width: 150px" class="inputxt"  ignore="ignore" /> -->
					     	<!--  <input id="gtbid" name="gtbid" type="text" class="inputxt" ignore="ignore" onclick="popupClick(this,'id','gtbid','cbgl_gtb')" /> -->
					     	<select id="gtbid" name="gtbid" >
								   
							</select>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公摊表ID</label>
						</td>
					</tr>
				<tr style="display: none;">
					<td align="right">
						<label class="Validform_label">
							管理区id:
						</label>
					</td>
					<td class="value">
					     	 <input id="glqid" name="glqid" type="text" style="width: 150px" class="inputxt"  ignore="ignore" readonly="readonly" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">管理区id</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							房屋主键:
						</label>
					</td>
					<td class="value">
					     	 <input id="fwxxid" name="fwxxid" type="text" style="width: 150px" class="inputxt"  ignore="ignore" readonly="readonly" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房屋主键</label>
						</td>						
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							房间地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="fjdz" name="fjdz" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房间地址</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							仪表类型:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect id="yblx" field="yblx" type="list"  typeGroupCode="yblx"  defaultVal="${wuyeCbglFjbPage.yblx}" hasLabel="false"  title="仪表类型" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">仪表类型</label>
						</td>						
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							仪表编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="ybbh" name="ybbh" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="${wuyeCbglFjbPage.ybbh }" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">仪表编号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							收费项目代码:
						</label>
					</td>
					<td class="value">
					     	 <!-- <input id="sfxmdm" name="sfxmdm" type="text" style="width: 150px" class="inputxt"  ignore="ignore" /> -->
					     	<select id="sfxmdm" name="sfxmdm" >
								   
							</select>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收费项目代码</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							倍率:
						</label>
					</td>
					<td class="value">
					     	 <input id="bl" name="bl" type="text" style="width: 150px" class="inputxt"   ignore="ignore" value="1.0"/>
					     	  <!-- datatype="/^(-?\d+)(\.\d+)?$/" -->
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">倍率</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							初始读数:
						</label>
					</td>
					<td class="value">
					     	 <input id="csds" name="csds" type="text" style="width: 150px" class="inputxt"   ignore="ignore" value="0.0"/>
					     	 <!-- datatype="/^(-?\d+)(\.\d+)?$/" -->
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">初始读数</label>
						</td>
					</tr>
				<tr style="display: none;">
 					<td align="right">
						<label class="Validform_label">
							有效标志:
						</label>
					</td>
					<td class="value">
					     	 <input id="yxbz" name="yxbz" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">有效标志</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>				
			</table>
		</t:formvalid>		
		</div>
	</div>
</body>
  <script src = "webpage/com/jeecg/wuyecbgl/wuyeCbglFjb.js"></script>		
  <script>
//加载树
var orgTree ;
var zNodes;
function loadTree() {	
	jQuery.ajax({  
        async : false,  
        cache:false,  
        type: 'POST',  
        dataType : "json",  
        url: 'wuyeCbglFjbController.do?getTreeData', //请求的action路径  
        error: function () {//请求失败处理函数  
            alert('请求失败');  
        },  
        success:function(data){ //请求成功后处理函数。
        	console.log(data)
            zNodes = data.obj;   //把后台封装好的简单Json格式赋给zNodes  
        }  
    });  
	var ztreeCreator = new ZtreeCreator('orgTree',"wuyeCbglFjbController.do?getTreeData",zNodes)
 			.setCallback({onClick:zTreeOnLeftClick,onRightClick:zTreeOnRightClick})
 			.initZtree({},3,function(treeObj){orgTree = treeObj});
};

//左击
function zTreeOnLeftClick(event, treeId, treeNode) {
	curSelectNode = treeNode;
	var parentId = treeNode.id;
	if(treeNode.glqlx != '1' && treeNode.glqlx != '2' && treeNode.glqlx != '3' && treeNode.glqlx != '4'){
		$("#tab").css("display","block");
		$("#fjid").val(parentId)
		$("#gtbid").empty();
		$.ajax({
			type : 'POST',
			dataType : "json",
			url : 'wuyeCbglFjbController.do?getFwxx',
			data : 'fjid=' + parentId,
			success : function(data) {
				$("#glqid").val(data.obj[0].glqid);
				$("#fwxxid").val(data.obj[0].id);
				$("#fjdz").val(treeNode.getParentNode().getParentNode().name+data.attributes.lym+data.obj[0].dyh+"单元"+data.obj[0].fjbh+"号");
				$("#gtbid").append("<option value="+""+">-- 请选择 -- </option>");
				for(var i = 0; i < data.attributes.gtb.length; i++){						
					$("#gtbid").append("<option value="+data.attributes.gtb[i].ybbh+">"+data.attributes.gtb[i].ybbh+"</option>")
				}
			}
		})
}
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
				if (!selectNode)
					return;
				var url = "departController.do?add&id=" + selectNode.id;
				$("#listFrame").attr("src", url);

			};

			//编辑节点
			function editNode(type) {
				var selectNode = getSelectNode();
				if (!selectNode)
					return;
				//根节点 不能编辑
				if (selectNode.id == "0" && type == 1) {
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
				var url = "jeecgFormDemoController.do?del&id=" + nodeId;
				if (!confirm('温馨提示', '确定删除该组织以及该组织下的所有子组织？')) {
					return;
				}
				jQuery.ajax({
					async : false,
					cache : false,
					type : 'GET',
					dataType : "json",
					url : url,//请求的action路径  
					error : function() {//请求失败处理函数  
						alert('请求失败');
					},
					success : function(data) { //请求成功后处理函数。
						if (data.success) {
							orgTree.removeNode(selectNode);
							$("#listFrame").attr("src", "about:blank");
						} else {
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
<script>
$(document).ready(function(){
	$("select#yblx").change(function(){		
		$("#sfxmdm").empty();
		$.ajax({
	        type: 'POST',  
	        dataType : "json",  
	        url: 'wuyeCbglFjbController.do?getXmxx',
	        data:'yblx='+$('#yblx option:selected').text(),
	        success:function(data){ 
				$("#sfxmdm").append("<option value="+" "+">-- 请选择 -- </option>");
				for(var i = 0; i < data.obj.length; i++){						
					$("#sfxmdm").append("<option value="+data.obj[i].xmmc+">"+data.obj[i].xmmc+"</option>")
				}
	        }
		})
	});
})
</script> 		
