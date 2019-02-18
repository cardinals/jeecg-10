<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
	table { width: 100%; min-height: 30px; line-height: 30px; text-align: center; border-color:#e7e7e7; border-collapse: collapse; margin-top: 3px;}  
	.jc{ font-weight:900;} 
	h5{ margin-bottom: -2px; margin-top: -2px;}
</style>
<title>房屋业主概况</title>
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
		<div data-options="region:'center'" style="display: none;" title="房屋业主概况" id="fwyzgk">
			<h5>房间资料</h5>
			<table border="1">
				<tr>
					<td class="jc">房间编号</td>
					<td id="fjbh"></td>
					<td class="jc">楼层号</td>
					<td id="lch"></td>
				</tr>
				<tr>
					<td class="jc">单元号</td>
					<td id="dyh"></td>
					<td class="jc">房间类型</td>
					<td id="fjlx"></td>
				</tr>
				<tr>
					<td class="jc">建筑面积</td>
					<td id="jzmj"></td>
					<td class="jc">套内面积</td>
					<td id="tnmj"></td>
				</tr>
				<tr>
					<td class="jc">房屋户型</td>
					<td id="fwhx"></td>
					<td class="jc">房间用途</td>
					<td id="fjyt"></td>
				</tr>
				<tr>
					<td class="jc">房屋状态</td>
					<td id="fwzt"></td>
					<td class="jc">房间地址</td>
					<td id="fjdz"></td>
				</tr>								
			</table >
			<h5>缴费情况</h5>
			<table border="1">
				<tr>
					<td class="jc">近期缴费日期</td>					
					<td class="jc">近期缴费金额</td>
					<td class="jc">累计缴费合计</td>
				</tr>
				<tr>
					
					<td id="jqjfrq">#</td>
					<td id="jqjfje">#</td>
					<td id="ljjfhj">#</td>
				</tr>
			</table>
			<h5>业主信息</h5>
        </div>
	</div>
</body>
</html>
 <script src = "webpage/com/jeecg/wuyeglq/wuyeFwxxList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){

 });
//加载树
var orgTree ;
var zNodes;
function loadTree() {	
	jQuery.ajax({  
        async : false,  
        cache:false,  
        type: 'POST',  
        dataType : "json",  
        url: 'wuyeFwyzgkController.do?getTreeData', //请求的action路径  
        error: function () {//请求失败处理函数  
            alert('请求失败');  
        },  
        success:function(data){ //请求成功后处理函数。
            zNodes = data.obj;   //把后台封装好的简单Json格式赋给zNodes  
        }  
    });  
	var ztreeCreator = new ZtreeCreator('orgTree',"wuyeFwyzgkController.do?getTreeData",zNodes)
 			.setCallback({onClick:zTreeOnLeftClick,onRightClick:zTreeOnRightClick})
 			.initZtree({},3,function(treeObj){orgTree = treeObj});
};

//左击
function zTreeOnLeftClick(event, treeId, treeNode) {	
	curSelectNode = treeNode;
	var parentId = treeNode.id;
	if(treeNode.glqlx != '1' && treeNode.glqlx != '2' && treeNode.glqlx != '3' && treeNode.glqlx != '4'){
		$("#fwyzgk").css("display","block");
		 $.ajax({
		        type: 'POST',  
		        dataType : "json",  
		        url: "wuyeFwyzgkController.do?getFwxx&fjid="+curSelectNode.id,
		        success:function(data){	
		        	$("#fjlx").empty();
		        	$("#fwhx").empty();
		        	$("#fwzt").empty();
		        	$("#fjbh").empty();
		        	$("#lch").empty();
		        	$("#dyh").empty();
		        	$("#jzmj").empty();
		        	$("#tnmj").empty();
		        	$("#fjyt").empty();
		        	$("#fjdz").empty();
		        	$("#jqjfrq").empty();
		        	$("#jqjfje").empty();
		        	$("#ljjfhj").empty();
		        	$("#lsyz").remove();
		        	$("#lsyzk").remove();
		        	$("#lszh").remove();
		        	$("#lszhk").remove();
		       		for(var i = 0; i < 10; i ++){
		       			$("#yzxxk").remove();
		       			$("#yzxxk"+i).remove();
		       		}
		        	//房间类型
		        	if(data.attributes.fwlx == null || data.attributes.fwlx == ''){
		        		$("#fjlx").html("无");
		        	}else{
		        		$("#fjlx").html(data.attributes.fwlx);
		        	}		
		        	//房屋户型
		        	if(data.attributes.fwhx == null || data.attributes.fwhx == ''){
		        		$("#fwhx").html("无");
		        	}else{
		        		$("#fwhx").html(data.attributes.fwhx);
		        	}		
		        	//房屋状态
		        	if(data.attributes.fwzt == null || data.attributes.fwzt == ''){
		        		$("#fwzt").html("无");
		        	}else{
		        		$("#fwzt").html(data.attributes.fwzt);
		        	}		
		        	//房间编号
		        	if(data.attributes.fwxx.fjbh == null || data.attributes.fwxx.fjbh == ''){
		        		$("#fjbh").html("无");
		        	}else{
		        		$("#fjbh").html(data.attributes.fwxx.fjbh);
		        	}		        	
		        	//楼宇
		        	if(data.attributes.lym == null || data.attributes.lym == ''){
		        		$("#lch").html("无");
		        	}else{
		        		$("#lch").html(data.attributes.lym);
		        	}
		        	//单元
		        	$("#dyh").html(data.attributes.fwxx.dyh+"单元");		
		        	//建筑面积
		        	$("#jzmj").html(data.attributes.fwxx.jzmj+"㎡");
		        	//套内面积
		        	$("#tnmj").html(data.attributes.fwxx.tnmj+"㎡");		
		        	//房屋用途
		        	if(data.attributes.fwxx.fwyt == '' || data.attributes.fwxx.fwyt == null){
		        		$("#fjyt").html("无");		        
		        	}else{
		        		$("#fjyt").html(data.attributes.fwxx.fwyt);		        
		        	}
		        	//房屋地址	
		        	$("#fjdz").html(treeNode.getParentNode().getParentNode().name+data.attributes.lym+data.attributes.fwxx.dyh+"单元"+data.attributes.fwxx.fjbh+"号");
		       		//房间统计
		       		$("#jqjfrq").html(data.attributes.jqjfrq);//近期缴费日期
		       		$("#jqjfje").html(data.attributes.jqjfje);//近期缴费金额
		       		$("#ljjfhj").html(data.attributes.ljjfhj);//累计缴费合计		       		
		        	//业主信息
		       		if(data.attributes.yzxx.length != 0){
			       		for(var i = 0; i < data.attributes.yzxx.length; i++){
			       			if(data.attributes.yzxx[i].xm == ''){
			       				data.attributes.yzxx[i].xm = "无";
			       			}
							//业主
			       			$("#fwyzgk").append("<table border="+"1"+" id="+"yzxxk"+i+"><tr><td  class="+"jc"+">业主姓名</td><td>"+data.attributes.yzxx[i].xm+"</td><td  class="+"jc"+">业主状态</td><td>"+data.attributes.yzxx[i].yzsx+"</td><td  class="+"jc"+">业主现状</td><td>"+data.attributes.yzxx[i].yzxz+"</td></tr></table>");		       									
							$.ajax({
				 		        type: 'POST',  
				 		        dataType : "json",  
				 		        url: "wuyeFwyzgkController.do?getYzjtgx&yzid="+data.attributes.yzxx[i].id+"&zb="+i,
				 		        success:function(data){		
									$("#yzxxk"+data.attributes.zb).append("<tr><td colspan="+"6"+"   class="+"jc"+" >业主家庭关系</td></tr>");
									$("#yzxxk"+data.attributes.zb).append("<tr><td colspan="+"2"+" class="+"jc"+">姓名</td><td colspan="+"2"+" class="+"jc"+">与业主关系</td><td colspan="+"2"+" class="+"jc"+">人员现状</td></tr>");
									if(data.obj.length != 0){		
										for(var j = 0; j < data.obj.length; j++){
											if(data.obj[j].xm == null){
												data.obj[j].xm = "无";
											}
											$("#yzxxk"+data.attributes.zb).append("<tr><td colspan="+"2"+">"+data.obj[j].xm+"</td><td colspan="+"2"+">"+data.obj[j].hzgx+"</td><td colspan="+"2"+">"+data.obj[j].yzxz+"</td></tr>");
										}
									}else{
										$("#yzxxk"+data.attributes.zb).append("<tr><td colspan="+"2"+">无</td><td colspan="+"2"+">无</td><td colspan="+"2"+">无</td></tr>");
									}
				 		        }				       			
				 		      })
			       		}		       			
		       		}else{
		       			$("#fwyzgk").append("<table border="+"1"+" id="+"yzxxk"+"><tr><td  class="+"jc"+">业主姓名</td><td>无</td><td  class="+"jc"+">业主状态</td><td>无</td><td  class="+"jc"+">业主现状</td><td>无</td></tr></table>");
		       		}
					//=============================
					$("#fwyzgk").append("<h5 id = "+"lsyz"+">历史业主<h5>");
		       		$.ajax({
		 		        type: 'POST',  
		 		        dataType : "json",  
		 		        url: "wuyeFwyzgkController.do?getlsyz&fjid="+curSelectNode.id,
		 		        success:function(data){		
		 		        	$("#fwyzgk").append("<table border="+"1"+" id="+"lsyzk"+"><tr><td  class="+"jc"+">业主姓名</td><td  class="+"jc"+">性别</td><td  class="+"jc"+">入住时间</td><td  class="+"jc"+">迁出时间</td></tr></table>");
		 		        	if(data.obj.length != 0){	 				 		        		
		 		        		for(var g = 0; g < data.obj.length; g++){
		 		        			$("#lsyzk").append("<tr><td>"+data.obj[g].yzmc+"</td><td>"+data.obj[g].yzxb+"</td><td>"+data.obj[g].rzrq+"</td><td>"+data.obj[g].qcrq+"</td></tr>");
		 		        		}
		 						$("#fwyzgk").append("<h5 id = "+"lszh"+">历史租户<h5>");
		 	 		       		$.ajax({
		 			 		        type: 'POST',  
		 			 		        dataType : "json",  
		 			 		        url: "wuyeFwyzgkController.do?getlszh&fjid="+curSelectNode.id,
		 			 		        success:function(data){		
		 			 		        	$("#fwyzgk").append("<table border="+"1"+" id="+"lszhk"+"><tr><td  class="+"jc"+">租户姓名</td><td  class="+"jc"+">性别</td><td  class="+"jc"+">入住时间</td><td  class="+"jc"+">迁出时间</td></tr></table>");
		 			 		        	if(data.obj.length != 0){	 				 		        		
		 			 		        		for(var g = 0; g < data.obj.length; g++){
		 			 		        			$("#lszhk").append("<tr><td>"+data.obj[g].yzmc+"</td><td>"+data.obj[g].yzxb+"</td><td>"+data.obj[g].rzrq+"</td><td>"+data.obj[g].qcrq+"</td></tr>");
		 			 		        		}
		 			 		        	}else{
		 			 		        		$("#lszhk").append("<tr><td>无</td><td>无</td><td>无</td><td>无</td></tr>");
		 			 		        	}
		 			 		        }
		 			       		}) 
		 		        	}else{
		 		        		$("#lsyzk").append("<tr><td>无</td><td>无</td><td>无</td><td>无</td></tr>");
		 						$("#fwyzgk").append("<h5 id = "+"lszh"+">历史租户<h5>");
		 	 		       		$.ajax({
		 			 		        type: 'POST',  
		 			 		        dataType : "json",  
		 			 		        url: "wuyeFwyzgkController.do?getlszh&fjid="+curSelectNode.id,
		 			 		        success:function(data){		
		 			 		        	$("#fwyzgk").append("<table border="+"1"+" id="+"lszhk"+"><tr><td  class="+"jc"+">租户姓名</td><td  class="+"jc"+">性别</td><td  class="+"jc"+">入住时间</td><td  class="+"jc"+">迁出时间</td></tr></table>");
		 			 		        	if(data.obj.length != 0){	 				 		        		
		 			 		        		for(var g = 0; g < data.obj.length; g++){
		 			 		        			$("#lszhk").append("<tr><td>"+data.obj[g].yzmc+"</td><td>"+data.obj[g].yzxb+"</td><td>"+data.obj[g].rzrq+"</td><td>"+data.obj[g].qcrq+"</td></tr>");
		 			 		        		}
		 			 		        	}else{
		 			 		        		$("#lszhk").append("<tr><td>无</td><td>无</td><td>无</td><td>无</td></tr>");
		 			 		        	}
		 			 		        }
		 			       		}) 
		 		        	}
		 		        }
		       		})
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