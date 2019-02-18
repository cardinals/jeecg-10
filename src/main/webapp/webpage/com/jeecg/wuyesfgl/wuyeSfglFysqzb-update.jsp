<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>费用收取主表</title>
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
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wuyeSfglFysqzbController.do?doUpdate" tiptype="1" >
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${wuyeSfglFysqzbPage.id}' >
			
			
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);">费用收取主表</a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>管理区id：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="glqid" name="glqid" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglFysqzbPage.glqid}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">管理区id</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>楼宇id：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="lyid" name="lyid" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglFysqzbPage.lyid}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">楼宇id</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>房屋主键：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="fwwxxid" name="fwwxxid" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglFysqzbPage.fwwxxid}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">房屋主键</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>房间id：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="fjid" name="fjid" type="text" class="form-control" datatype="n"  ignore="ignore"  value='${wuyeSfglFysqzbPage.fjid}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">房间id</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>业主主键：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="fwyzxxid" name="fwyzxxid" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglFysqzbPage.fwyzxxid}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">业主主键</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>业主名称：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="yzmc" name="yzmc" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglFysqzbPage.yzmc}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">业主名称</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>计费年度：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="jfnd" name="jfnd" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglFysqzbPage.jfnd}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费年度</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>计费月份：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="jfyf" name="jfyf" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglFysqzbPage.jfyf}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费月份</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>收据号：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="sjh" name="sjh" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglFysqzbPage.sjh}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收据号</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>费用类型：</b>
			          </div>
			          <div class="col-xs-3">
								<t:dictSelect field="fylx" type="list" extendJson="{class:'form-control'}"   typeGroupCode="fylx"  defaultVal="${wuyeSfglFysqzbPage.fylx}" hasLabel="false"  title="费用类型"></t:dictSelect>     
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">费用类型</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>交费方式：</b>
			          </div>
			          <div class="col-xs-3">
								<t:dictSelect field="jffs" type="list" extendJson="{class:'form-control'}"   typeGroupCode="skfs"  defaultVal="${wuyeSfglFysqzbPage.jffs}" hasLabel="false"  title="交费方式"></t:dictSelect>     
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">交费方式</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>应收金额：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="ysje" name="ysje" type="text" class="form-control" datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeSfglFysqzbPage.ysje}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">应收金额</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>抹零金额：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="mlje" name="mlje" type="text" class="form-control" datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeSfglFysqzbPage.mlje}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">抹零金额</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>滞纳金：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="znj" name="znj" type="text" class="form-control" datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeSfglFysqzbPage.znj}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">滞纳金</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>实收金额：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="ssje" name="ssje" type="text" class="form-control" datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeSfglFysqzbPage.ssje}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">实收金额</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>客付金额：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="skje" name="skje" type="text" class="form-control" datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeSfglFysqzbPage.skje}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">客付金额</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>找零金额：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="zlje" name="zlje" type="text" class="form-control" datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeSfglFysqzbPage.zlje}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">找零金额</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>收费人员：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="sfry" name="sfry" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglFysqzbPage.sfry}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收费人员</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>收费时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="sfsj" name="sfsj" type="text" style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"  class="form-control" onClick="WdatePicker()" ignore="ignore"  value='<fmt:formatDate value='${wuyeSfglFysqzbPage.sfsj}' type="date" pattern="yyyy-MM-dd"/>' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收费时间</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>开票方式：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="kpfs" name="kpfs" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglFysqzbPage.kpfs}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">开票方式</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>备注：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="bz" name="bz" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglFysqzbPage.bz}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">备注</label>
			          </div>
							<div class="col-xs-2 text-center"><b></b></div>
			         		<div class="col-xs-4"></div>
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
<script src = "webpage/com/jeecg/wuyesfgl/wuyeSfglFysqzb.js"></script>		
</html>