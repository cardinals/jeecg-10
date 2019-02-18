<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>收费项目管理-更新</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="online/template/ledefault/css/vendor.css">
  <link rel="stylesheet" href="online/template/ledefault/css/bootstrap-theme.css">
  <link rel="stylesheet" href="online/template/ledefault/css/bootstrap.css">
  <link rel="stylesheet" href="online/template/ledefault/css/app.css">
  
  <link rel="stylesheet" href="plug-in/Validform/css/metrole/style.css" type="text/css"/>
  <link rel="stylesheet" href="plug-in/Validform/css/metrole/tablefrom.css" type="text/css"/>
  
  <script type="text/javascript" src="plug-in/jquery/jquery-1.8.3.js"></script>
  <script type="text/javascript" src="plug-in/tools/dataformat.js"></script>
  <script type="text/javascript" src="plug-in/easyui/jquery.easyui.min.1.3.2.js"></script>
  <script type="text/javascript" src="plug-in/easyui/locale/zh-cn.js"></script>
  <script type="text/javascript" src="plug-in/tools/syUtil.js"></script>
  <script type="text/javascript" src="plug-in/My97DatePicker/WdatePicker.js"></script>
  <script type="text/javascript" src="plug-in/lhgDialog/lhgdialog.min.js"></script>
  <script type="text/javascript" src="plug-in/tools/curdtools_zh-cn.js"></script>
  <script type="text/javascript" src="plug-in/tools/easyuiextend.js"></script>
  <script type="text/javascript" src="plug-in/Validform/js/Validform_v5.3.1_min_zh-cn.js"></script>
  <script type="text/javascript" src="plug-in/Validform/js/Validform_Datatype_zh-cn.js"></script>
  <script type="text/javascript" src="plug-in/Validform/js/datatype_zh-cn.js"></script>
  <script type="text/javascript" src="plug-in/Validform/plugin/passwordStrength/passwordStrength-min.js"></script>
  <script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.config.js"></script>
  <script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.all.min.js"></script>
  
</head>
<style>
	#glqid{height:26px;padding: 2px 5px;font-size: 12px;line-height: 1.42857143;color: #555555; border: 1px solid #cccccc;border-radius: 4px;}
</style>
 <body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wuyeSfglSfxmszController.do?doUpdate" tiptype="1" >
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" id="sfxmid" name="id" value='${wuyeSfglSfxmszPage.id}' >
			
			
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);">收费项目管理</a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
						<div class="row show-grid">
				          <div class="col-xs-3 text-center">
				          	<b>管理区：</b>
				          </div>
				          <div class="col-xs-3">
							<%-- <input id="glqid" name="glqid" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglSfxmszPage.glqid}' /> --%>
							<select id="glqid" name="glqid" >
								<option value="">-- 请选择 --</option>
								<c:forEach items="${glqList }" var="i">
									<c:choose>
										<c:when test="${wuyeSfglSfxmszPage.glqid == i.id }">
											<option value="${i.id }" selected>${i.glqmc}</option>
										</c:when>
										<c:otherwise>
											<option value="${i.id }">${i.glqmc}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select> 
							<span class="Validform_checktip" style="float:left;height:0px;"></span>
							<label class="Validform_label" style="display: none">管理区ID</label>
				          </div>
						</div>
			          
			        
						<div class="row show-grid">
				          <div class="col-xs-3 text-center">
				          	<b>项目代码：</b>
				          </div>
				          <div class="col-xs-3">
							<input id="xmdm" name="xmdm" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglSfxmszPage.xmdm}' />
							<span class="Validform_checktip" style="float:left;height:0px;"></span>
							<label class="Validform_label" style="display: none">项目代码</label>
				          </div>
						</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>项目名称：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="xmmc" name="xmmc" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglSfxmszPage.xmmc}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">项目名称</label>
			          </div>
						</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>收费方式：</b>
			          </div>
			          <div class="col-xs-3">
						<%-- <input id="sffs" name="sffs" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglSfxmszPage.sffs}' /> --%>
						<t:dictSelect extendJson="{class:'form-control'}" field="sffs" typeGroupCode="sffs" type="select" defaultVal="${wuyeSfglSfxmszPage.sffs}"></t:dictSelect>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收费方式</label>
			          </div>
						</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>计费方式：</b>
			          </div>
			          <div class="col-xs-3">
						<%-- <input id="jffs" name="jffs" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglSfxmszPage.jffs}' /> --%>
						<t:dictSelect extendJson="{class:'form-control'}" field="jffs" typeGroupCode="jffs" type="select" defaultVal="${wuyeSfglSfxmszPage.jffs}"></t:dictSelect>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费方式</label>
			          </div>
						</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>计费周期：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="jfzq" name="jfzq" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglSfxmszPage.jfzq}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费周期</label>
			          </div>
						</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>计费周期单位：</b>
			          </div>
			          <div class="col-xs-3">
						<%-- <input id="jfzqdw" name="jfzqdw" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglSfxmszPage.jfzqdw}' /> --%>
						<t:dictSelect extendJson="{class:'form-control'}" field="jfzqdw" typeGroupCode="jfzqdw" type="select" defaultVal="${wuyeSfglSfxmszPage.jfzqdw}"></t:dictSelect>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费周期单位</label>
			          </div>
						</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>计费单价：</b>
			          </div>
			          <div class="col-xs-3">
						<input id="jfdj" name="jfdj" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglSfxmszPage.jfdj}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费单价</label>
			          </div>
						</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>是否收费：</b>
			          </div>
			          <div class="col-xs-3">
						<%-- <input id="sfbz" name="sfbz" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglSfxmszPage.sfbz}' /> --%>
						<t:dictSelect extendJson="{class:'form-control'}" field="sfbz" typeGroupCode="cfcz" type="select" defaultVal="${wuyeSfglSfxmszPage.sfbz}"></t:dictSelect>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">是否收费</label>
			          </div>
						</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>计费精度：</b>
			          </div>
			          <div class="col-xs-3">
						<%-- <input id="jfjd" name="jfjd" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglSfxmszPage.jfjd}' /> --%>
						<t:dictSelect extendJson="{class:'form-control'}" field="jfjd" typeGroupCode="jfjd" type="select" defaultVal="${wuyeSfglSfxmszPage.jfjd}"></t:dictSelect>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费精度</label>
			          </div>
						</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>滞纳金率：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="znjl" name="znjl" type="text" class="form-control" datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeSfglSfxmszPage.znjl}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">滞纳金率</label>
			          </div>
						</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>滞纳金开始天数：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="znjksts" name="znjksts" type="text" class="form-control" datatype="n"  ignore="ignore"  value='${wuyeSfglSfxmszPage.znjksts}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">滞纳金开始天数</label>
			          </div>
						</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>计算公式：</b>
			          </div>
			          <div class="col-xs-3">
						<%-- <input id="jsgs" name="jsgs" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglSfxmszPage.jsgs}' /> --%>
						<textarea cols="77" id="jsgs" name="jsgs">${wuyeSfglSfxmszPage.jsgs}</textarea>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计算公式</label>
			          </div>
						</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>打印次序：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="dycx" name="dycx" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglSfxmszPage.dycx}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">打印次序</label>
			          </div>
						</div>
			          
			        
			          <div class="row" id = "sub_tr" style="display: none;">
				        <div class="col-xs-12 layout-header">
				          <div class="col-xs-6"></div>
				          <div class="col-xs-6"><button type="button" onclick="neibuClick();" class="btn btn-default">提交</button></div>
				        </div>
				      </div>
			     </div>
			   </div>
			   
			   <div class="con-wrapper" id="con-wrapper2" style="display: block;"></div>
			 </div>
  </t:formvalid>

<script type="text/javascript">
   $(function(){
    //查看模式情况下,删除和上传附件功能禁止使用
	if(location.href.indexOf("load=detail")!=-1){
		$(".jeecgDetail").hide();
	}
	
	if(location.href.indexOf("mode=read")!=-1){
		//查看模式控件禁用
		$("#formobj").find(":input").attr("disabled","disabled");
	}
	if(location.href.indexOf("mode=onbutton")!=-1){
		//其他模式显示提交按钮
		$("#sub_tr").show();
	}
   });

  var neibuClickFlag = false;
  function neibuClick() {
	  neibuClickFlag = true; 
	  $('#btn_sub').trigger('click');
  }
  
  $("#xmdm").on("blur",function(){
		var value = $(this).val();
		var id = $("#sfxmid").val();
		if(value == ""){
			layer.msg("项目代码不能为空！")
		}else{
			$.post('wuyeSfglSfxmszController.do?existence',{xmdm:value,id:id},function(data){
				if(data == "err"){
					$("#xmdm").val("");
					layer.msg("项目代码已经存在，重新输入！")
				}
			}) 
		}
	})
</script>
 </body>
<script src = "webpage/com/jeecg/wuyesfgl/wuyeSfglSfxmsz.js"></script>		
</html>