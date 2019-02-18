<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>银行代扣信息表</title>
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

 <body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wuyeSfglYhdkxxController.do?doUpdate" tiptype="1" >
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${wuyeSfglYhdkxxPage.id}' >
			
			
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);">银行代扣信息表</a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
			      
					<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>计费年度：</b>
			          </div>
			          <div class="col-xs-3">
						<input id="year" name="year" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglYhdkxxPage.year}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费年度</label>
			          </div>
					</div>
					<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>计费月份：</b>
			          </div>
			          <div class="col-xs-3">
						<input id="month" name="month" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglYhdkxxPage.month}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费月份</label>
			          </div>
					</div>
					<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>银行编码：</b>
			          </div>
			          <div class="col-xs-3">
						<t:dictSelect field="yhbm" extendJson="{class:'form-control'}" typeGroupCode="dkrDkyh" type="select" defaultVal="${wuyeSfglYhdkxxPage.yhbm}"></t:dictSelect>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">银行编码</label>
			          </div>
					</div>
			          
			        <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>住户姓名：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="zhxm" name="zhxm" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglYhdkxxPage.zhxm}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">住户姓名</label>
			          </div>
					</div>
					<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>实收金额：</b>
			          </div>
			          <div class="col-xs-3">
						<input id="ssje" name="ssje" type="text" class="form-control" datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeSfglYhdkxxPage.ssje}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">实收金额</label>
			          </div>
					</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>账户：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="zh" name="zh" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglYhdkxxPage.zh}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">账户</label>
			          </div>
						</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>提交金额：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="tjje" name="tjje" type="text" class="form-control" datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeSfglYhdkxxPage.tjje}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">提交金额</label>
			          </div>
						</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>实际扣款额：</b>
			          </div>
			          <div class="col-xs-3">
						<input id="sjkke" name="sjkke" type="text" class="form-control" datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeSfglYhdkxxPage.sjkke}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">实际扣款额</label>
			          </div>
						</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>交易日期：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="jyrq" name="jyrq" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglYhdkxxPage.jyrq}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">交易日期</label>
			          </div>
						</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>状态：</b>
			          </div>
			          <div class="col-xs-3">
						<input id="zt" name="zt" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglYhdkxxPage.zt}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">状态</label>
			          </div>
						</div>
			          
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>响应信息：</b>
			          </div>
			          <div class="col-xs-3">
						<textarea id="xyxx" name="xyxx" cols="77">${wuyeSfglYhdkxxPage.xyxx}</textarea>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">响应信息</label>
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
<script src = "webpage/com/jeecg/wuyesfgl/wuyeSfglYhdkxx.js"></script>		
</html>