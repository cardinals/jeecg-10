<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>房间收费项目修改</title>
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
   <script type="text/javascript">
  //编写自定义JS代码
  </script>
</head>
<style>
	#sfxmid{height:26px;padding: 2px 5px;font-size: 12px;line-height: 1.42857143;color: #555555; border: 1px solid #cccccc;border-radius: 4px;}
</style>
 <body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wuyeSfglFjsfxmszController.do?doUpdate" tiptype="1" >
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${wuyeSfglFjsfxmszPage.id}' >
			
			
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);">房间收费项目修改</a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
						<div class="row show-grid" style="display:none">
				          <div class="col-xs-3 text-center">
				          	<b>管理区ID：</b>
				          </div>
				          <div class="col-xs-3">
									<input id="glqid" name="glqid" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglFjsfxmszPage.glqid}' />
							<span class="Validform_checktip" style="float:left;height:0px;"></span>
							<label class="Validform_label" style="display: none">管理区ID</label>
				          </div>
						</div>
			          
			        
							<div class="row show-grid" style="display:none">
			          <div class="col-xs-3 text-center">
			          	<b>楼宇ID：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="lyid" name="lyid" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglFjsfxmszPage.lyid}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">楼宇ID</label>
			          </div>
						</div>
			          
			        
							<div class="row show-grid" style="display:none">
			          <div class="col-xs-3 text-center">
			          	<b>房屋主键：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="fwxxid" name="fwxxid" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglFjsfxmszPage.fwxxid}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">房屋主键</label>
			          </div>
						</div>
			          
			          <div class="row show-grid">
				          <div class="col-xs-3 text-center">
				          	<b>房间编号：</b>
				          </div>
				          <div class="col-xs-3">
							<input id="fjbh" name="fjbh" type="text" class="form-control"  ignore="ignore" value="${wuyefwxx.fjbh }" readonly/>
							<span class="Validform_checktip" style="float:left;height:0px;"></span>
							<label class="Validform_label" style="display: none">房屋主键</label>
				          </div>
						</div>
			        
						<div class="row show-grid">
				          <div class="col-xs-3 text-center">
				          	<b>房间ID：</b>
				          </div>
				          <div class="col-xs-3">
									<input id="fjid" name="fjid" type="text" class="form-control" datatype="n"  ignore="ignore"  value='${wuyeSfglFjsfxmszPage.fjid}' readonly/>
							<span class="Validform_checktip" style="float:left;height:0px;"></span>
							<label class="Validform_label" style="display: none">房间ID</label>
				          </div>
						</div>
			          
			        
						<div class="row show-grid">
				          <div class="col-xs-3 text-center">
				          	<b>收费项目：</b>
				          </div>
				          <div class="col-xs-3">
							<%-- <input id="sfxmid" name="sfxmid" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglFjsfxmszPage.sfxmid}' /> --%>
							<select id="sfxmid" name="sfxmid" >
								<option value="">-- 请选择 --</option>
								<c:forEach items="${sfxmszList }" var="i">
									<c:choose>
										<c:when test="${wuyeSfglFjsfxmszPage.sfxmid == i.id }">
											<option value="${i.id }" selected>${i.xmmc}</option>
										</c:when>
										<c:otherwise>
											<option value="${i.id }">${i.xmmc}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select> 
							<span class="Validform_checktip" style="float:left;height:0px;"></span>
							<label class="Validform_label" style="display: none">收费项目ID</label>
				          </div>
						</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>优惠类型：</b>
			          </div>
			          <div class="col-xs-3">
						<%-- <input id="yhlx" name="yhlx" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglFjsfxmszPage.yhlx}' /> --%>
						<t:dictSelect field="yhlx" extendJson="{class:'form-control'}" typeGroupCode="yhlx" type="select" defaultVal="${wuyeSfglFjsfxmszPage.yhlx}"></t:dictSelect>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">优惠类型</label>
			          </div>
						</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>折扣/金额：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="yhbl" name="yhbl" type="text" class="form-control" datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeSfglFjsfxmszPage.yhbl}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">折扣系数</label>
			          </div>
						</div>
			          
			        
						<div class="row show-grid">
				          <div class="col-xs-3 text-center">
				          	<b>备注：</b>
				          </div>
				          <div class="col-xs-3">
							<textarea id="bz"  name="bz" cols="77">${wuyeSfglFjsfxmszPage.bz}</textarea>
							<span class="Validform_checktip" style="float:left;height:0px;"></span>
							<label class="Validform_label" style="display: none">备注</label>
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

</script>
 </body>
<script src = "webpage/com/jeecg/wuyesfgl/wuyeSfglFjsfxmsz.js"></script>		
</html>