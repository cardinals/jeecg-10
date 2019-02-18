<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>电表抄表记录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <link rel="stylesheet" href="plug-in/ztree/css/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/ztreeCreator.js"></script>
 </head>
 <body>
   	<div class="easyui-layout" fit="true" scroll="no">
		<div  data-options="region:'west',title:'管理区域',split:true" style="width:167px;overflow: auto;">
	        <div id="orgTree" class="ztree"></div>
		</div>
		<div data-options="region:'center',border:false" style="text-align: center;">
			 <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wuyeCbglDbcbjlController.do?doAdd" >
		<input id="id" name="id" type="hidden" value="${wuyeCbglSbcbjlPage.id }"/>
		<table style="width: 600px; display: none;" cellpadding="0" cellspacing="1" class="formtable" id="tab">
				<tr>
					<td align="right">
						<label class="Validform_label">
							计费起始日期:
						</label>
					</td>
					<td class="value">
							   <input id="jfqsrq" name="jfqsrq" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" value="" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">计费起始日期</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							计费结束日期:
						</label>
					</td>
					<td class="value">
							   <input id="jfjsrq" name="jfjsrq" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" value=""/>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">计费结束日期</label>
						</td>
					</tr>		
				<tr>
					<td align="right">
						<label class="Validform_label">
							房间ID:
						</label>
					</td>
					<td class="value">
					     	 <!-- <input id="fjid" name="fjid" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" /> -->
					     	  <!-- onclick="popupClick(this,'id,fjid,glqid,fwxxid,ybbh,bl','ybid,fjid,glqid,fwxxid,ybbh,bl','cbgl_fjb_sb')"  -->
					     	 <input id="fjid" name="fjid" type="text" class="inputxt" ignore="ignore" readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房间id</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							仪表属性:
						</label>
					</td>
					<td class="value">
							  <%-- <t:dictSelect id="ybsx" field="ybsx" type="list"  typeGroupCode="ybsx"  defaultVal="${wuyeCbglSbcbjlPage.ybsx}" hasLabel="false"  title="仪表属性" ></t:dictSelect> --%>
							  <input id="ybsx" name="ybsx" type="text" class="inputxt" ignore="ignore" value="房间表" readonly="readonly"/> 
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">仪表属性</label>
						</td>	
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							姓名:
						</label>
					</td>
					<td class="value">
					     	 <input id="xm" name="xm" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>
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
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							仪表编号:
						</label>
					</td>
					<td class="value">
					     	<!-- <input id="ybbh" name="ybbh" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" readonly="readonly"/> -->
							<select id="ybbh" name="ybbh" >
								   
							</select>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">仪表编号</label>
						</td>				
					<td align="right">
						<label class="Validform_label">
							仪表ID:
						</label>
					</td>
					<td class="value">
							<input id="ybid" name="ybid" type="text" style="width: 150px" class="inputxt"  ignore="ignore" readonly="readonly"/>
<!-- 					     	<input id="ybid" name="ybid" type="text" class="form-control" ignore="ignore" popup="false" onclick="" />		 -->	 		     	
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">仪表ID</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							上月指数:
						</label>
					</td>
					<td class="value">
					     	 <input id="syzs" name="syzs" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="0" readonly="readonly" value="0.0"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">上月指数</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							本月指数:
						</label>
					</td>
					<td class="value">
					     	 <input id="byzs" name="byzs" type="text" style="width: 150px" class="inputxt" datatype="/^(-?\d+)(\.\d+)?$/" ignore="ignore" value="0.0"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本月指数</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							倍率:
						</label>
					</td>
					<td class="value">
					     	 <input id="bl" name="bl" type="text" style="width: 150px" class="inputxt"  ignore="ignore" readonly="readonly" value="1.0"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">倍率</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							本月用量:
						</label>
					</td>
					<td class="value">
					     	 <input id="byyl" name="byyl" type="text" style="width: 150px" class="inputxt"  ignore="ignore" readonly="readonly" value="0.0"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本月流量</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							换表用量:
						</label>
					</td>
					<td class="value">
					     	 <input id="hbyl" name="hbyl" type="text" style="width: 150px" class="inputxt" datatype="/^(-?\d+)(\.\d+)?$/" ignore="ignore" value="0.0" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">换表用量</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							公摊量:
						</label>
					</td>
					<td class="value">
					     	 <input id="gtl" name="gtl" type="text" style="width: 150px" class="inputxt" datatype="/^(-?\d+)(\.\d+)?$/" ignore="ignore" value="0.0" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公摊量</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							实际用量:
						</label>
					</td>
					<td class="value">
					     	 <input id="sjyl" name="sjyl" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="0.0"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际用量</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							抄表人:
						</label>
					</td>
					<td class="value">
					     	 <input id="cbr" name="cbr" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value='${wuyeCbglSbcbjlPage.cbr}' readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">抄表人</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							抄表时间:
						</label>
					</td>
					<td class="value">
							   <input id="cbsj" name="cbsj" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">抄表时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="bz" name="bz" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
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
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">管理区ID</label>
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
				
				
			</table>
		</t:formvalid>
		</div>
	</div>
 </body>
  <script src = "webpage/com/jeecg/wuyecbgl/wuyeCbglDbcbjl.js"></script>		
    <script type="text/javascript">
  //编写自定义JS代码
    $(document).ready(function(){
/*  	  var fjb = "popupClick(this,'id,ybbh,bl','ybid,ybbh,bl','cbgl_fjb_sb')";
 	  var gtb = "popupClick(this,'id,ybbh,bl','ybid,ybbh,bl','cbgl_gtb_sb')";
		$("select#ybsx").change(function(){
			$("#ybid").attr("onclick","");
		    if($(this).val()==1){
		    	$("#ybid").attr("onclick",gtb);
		    }else if($(this).val()==2){
		    	$("#ybid").attr("onclick",fjb);
		    }
		});
		$("#ybid").click(function(){
	 		 if($('#ybsx option:selected').text()=="-- 请选择 -- "){
		 			$("#ybid").val("");
		 			$("#ybbh").val("");
				 alert("请选择仪表属性！");
			 }			
		}) */

		//格式化日期
		function setDate(date){
		  y=date.getFullYear();
		  m=date.getMonth()+1;
		  d=date.getDate();
		  m=m<10?"0"+m:m;
		  d=d<10?"0"+d:d;
		  return y+"-"+m+"-"+d;
		}
		 

		//获取当前月的第一天
		function getCurrentMonthFirst(){
		 var date=new Date();
		 date.setDate(1);
		 return date;
		}

		//获取当前月的最后一天
		function getCurrentMonthLast(){
		 var date=new Date();
		 var currentMonth=date.getMonth();
		 var nextMonth=++currentMonth;
		 var nextMonthFirstDay=new Date(date.getFullYear(),nextMonth,1);
		 var oneDay=1000*60*60*24;
		 return new Date(nextMonthFirstDay-oneDay);
		}
		
		function getDangtiandate(){
			var myDate = new Date();    
			myDate.toLocaleDateString();
			return myDate;
		}
		
		$("#jfqsrq").val(setDate(getCurrentMonthFirst()));
		$("#jfjsrq").val(setDate(getCurrentMonthLast()));
		$("#cbsj").val(setDate(getDangtiandate()));
		
		$("select#ybbh").change(function(){
	 		 if($('#ybbh option:selected').text()!="-- 请选择 -- "){				
	 			 $.ajax({
	 		        type: 'POST',  
	 		        dataType : "json",  
	 		        url: 'wuyeCbglDbcbjlController.do?getYbxx',
	 		        data:'ybbh='+$('#ybbh option:selected').text()+'&fjid='+$("#fjid").val(),
	 		        success:function(data){ 		      
	 		        	$("#glqid").val(data.obj[0].glqid);
	 		        	$("#fwxxid").val(data.obj[0].fwxxid);
	 		        	$("#ybid").val(data.obj[0].id);
	 		        	$("#bl").val(data.obj[0].bl);
	 		        	$("#syzs").val(data.attributes.syzs);
	 		        }
	 			 })
			 }	
		})

		$("#byzs").change(function(){
			$("#byyl").val("");
 			if($("#byzs").val() < $("#syzs").val()){
				alert("请填写正确的指数！")
				$("#byyl").val("");
				return false;
			}
			  $("#byyl").val((($("#byzs").val()-$("#syzs").val())*$("#bl").val()).toFixed(2));
			  
		});
		
		$("#sjyl").click(function(){
			$("#sjyl").val("");
			if($("#byyl").val() == ''){
				$("#sjyl").val("");
				return false;
			}
			var d1 = parseFloat($("#byyl").val());
			var d2 = parseFloat($("#hbyl").val());
			var d3 = parseFloat($("#gtl").val());
			$("#sjyl").val((d1+d2+d3).toFixed(2));
		})

	});
    </script>  	 
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
        url: 'wuyeCbglDbcbjlController.do?getTreeData', //请求的action路径  
        error: function () {//请求失败处理函数  
            alert('请求失败');  
        },  
        success:function(data){ //请求成功后处理函数。
            zNodes = data.obj;   //把后台封装好的简单Json格式赋给zNodes  
        }  
    });  
	var ztreeCreator = new ZtreeCreator('orgTree',"wuyeCbglDbcbjlController.do?getTreeData",zNodes)
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
		$("#ybbh").empty();
		$("#fjdz").val("");
		$("#xm").val("");
		$.ajax({
	        type: 'POST',  
	        dataType : "json",  
	        url: 'wuyeCbglDbcbjlController.do?getYbbh',
	        data:'fjid='+parentId,
	        success:function(data){	        	
	        	$("#ybbh").append("<option value="+" "+">-- 请选择 -- </option>");
	        	$("#fjdz").val(treeNode.getParentNode().getParentNode().name+data.attributes.lym+data.attributes.dyh+"单元"+data.attributes.fjbh+"号");
	        	$("#cbr").val(data.attributes.user);
	        	$("#xm").val(data.attributes.yzmc);
				for(var i = 0; i < data.obj.length; i++){						
					$("#ybbh").append("<option value="+data.obj[i].ybbh+">"+data.obj[i].ybbh+"</option>")
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
	