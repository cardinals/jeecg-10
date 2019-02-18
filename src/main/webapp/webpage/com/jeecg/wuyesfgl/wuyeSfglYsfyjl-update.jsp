<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>应收费用记录-编辑</title>
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
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wuyeSfglYsfyjlController.do?doUpdate" tiptype="1" >
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${wuyeSfglYsfyjlPage.id}' >
			
			
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);">应收费用记录</a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
					<div class="row show-grid" style="display:none">
			          <div class="col-xs-3 text-center">
			          	<b>管区ID：</b>
			          </div>
			          <div class="col-xs-3">
						<input id="glqid" name="glqid" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglYsfyjlPage.glqid}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">管区ID</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>小区ID：</b>
			          </div>
			          <div class="col-xs-3">
						<input id="xqid" name="xqid" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglYsfyjlPage.xqid}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">小区ID</label>
			          </div>
					</div>
			          
			        
					<div class="row show-grid" style="display:none">
			          <div class="col-xs-3 text-center">
			          	<b>楼宇ID：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="lyid" name="lyid" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglYsfyjlPage.lyid}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">楼宇ID</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>房屋主键：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="fwxxid" name="fwxxid" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglYsfyjlPage.fwxxid}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">房屋主键</label>
			          </div>
					</div>
			          
			        
					<div class="row show-grid" style="display:none">
			          <div class="col-xs-3 text-center">
			          	<b>房间ID：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="fjid" name="fjid" type="text" class="form-control" datatype="n"  ignore="ignore"  value='${wuyeSfglYsfyjlPage.fjid}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">房间ID</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>业主主键：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="fwyzxxid" name="fwyzxxid" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglYsfyjlPage.fwyzxxid}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">业主主键</label>
			          </div>
					</div>
					<!-- 自定显示内容 start -->
					<div class="row show-grid" style="display:block">
			          <div class="col-xs-3 text-center">
			          	<b>管理区：</b>
			          </div>
			          <div class="col-xs-3">
						<input type="text" name="glqmc" class="form-control" ignore="ignore"  value='${glqmc }' readonly/>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">管理区</label>
			          </div>
			          <div class="col-xs-3 text-center">
			          	<b>房间编号：</b>
			          </div>
			          <div class="col-xs-3">
						<input type="text" name="fjbh" class="form-control" ignore="ignore"  value='${fjbh }' readonly/>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">房间编号</label>
			          </div>
					</div>
			      <!-- 自定显示内容 end -->    
			        
					<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>业主姓名：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="yzmc" name="yzmc" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglYsfyjlPage.yzmc}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">业主姓名</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>收费状态：</b>
			          </div>
			          <div class="col-xs-3">
						<t:dictSelect extendJson="{class:'form-control'}" field="sfzt" typeGroupCode="sfzt" type="select" defaultVal="${wuyeSfglYsfyjlPage.sfzt}"></t:dictSelect>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收费状态</label>
			          </div>
					</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>收费项目代码：</b>
			          </div>
			          <div class="col-xs-3">
						<input id="sfxmdm" name="sfxmdm" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglYsfyjlPage.sfxmdm}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收费项目代码</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>收费项目名称：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="sfxmmc" name="sfxmmc" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglYsfyjlPage.sfxmmc}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收费项目名称</label>
			          </div>
							</div>
			          
			        
					<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>计费起始时间：</b>
			          </div>
			          <div class="col-xs-3">
						<input id="jfqssj" name="jfqssj" type="text" ignore="ignore"
						style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"
						class="form-control" value='${wuyeSfglYsfyjlPage.jfqssj}' 
						onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费起始时间</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>计费终止时间：</b>
			          </div>
			          <div class="col-xs-3">
						<input id="jfjzsj" name="jfjzsj" type="text" ignore="ignore"
						style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"
						class="form-control" value='${wuyeSfglYsfyjlPage.jfjzsj}' 
						onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费终止时间</label>
			          </div>
					</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>数量：</b>
			          </div>
			          <div class="col-xs-3">
						<input id="sl" name="sl" type="text" class="form-control" datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeSfglYsfyjlPage.sl}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">数量</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>价格：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="jg" name="jg" type="text" class="form-control" datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeSfglYsfyjlPage.jg}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">价格</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>应收金额：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="ysje" name="ysje" type="text" class="form-control" datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeSfglYsfyjlPage.ysje}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">应收金额</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>起数：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="qss" name="qss" type="text" class="form-control" datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeSfglYsfyjlPage.qss}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">起数</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>止数：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="jzs" name="jzs" type="text" class="form-control" datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeSfglYsfyjlPage.jzs}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">止数</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>倍率：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="bl" name="bl" type="text" class="form-control" datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeSfglYsfyjlPage.bl}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">倍率</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>公摊：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="gts" name="gts" type="text" class="form-control" datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeSfglYsfyjlPage.gts}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">公摊</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>计费年度：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="jfnd" name="jfnd" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglYsfyjlPage.jfnd}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费年度</label>
			          </div>
							</div>
			          
			        
					<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>计费月份：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="jfyf" name="jfyf" type="text" class="form-control" ignore="ignore"  value='${wuyeSfglYsfyjlPage.jfyf}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费月份</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>收费起始日期：</b>
			          </div>
			          <div class="col-xs-3">
						<input id="sfqsrq" name="sfqsrq" type="text" ignore="ignore"
						style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"
						class="form-control" value='${wuyeSfglYsfyjlPage.sfqsrq}' 
						onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收费起始日期</label>
			          </div>
					</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>收费截止日期：</b>
			          </div>
			          <div class="col-xs-3">
						<input id="sfjzrq" name="sfjzrq" type="text" ignore="ignore"
						style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"
						class="form-control" value='${wuyeSfglYsfyjlPage.sfjzrq}' 
						onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收费截止日期</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>滞纳金起始日期：</b>
			          </div>
			          <div class="col-xs-3">
						<input id="znjqsrq" name="znjqsrq" type="text" ignore="ignore"
						style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"
						class="form-control" value='${wuyeSfglYsfyjlPage.znjqsrq}' 
						onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">滞纳金起始日期</label>
			          </div>
							</div>
			          
			        <div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>审核状态：</b>
			          </div>
			          <div class="col-xs-3">
						<t:dictSelect  extendJson="{class:'form-control'}" field="shzt" typeGroupCode="shzt" type="select" readonly="readonly" defaultVal="${wuyeSfglYsfyjlPage.shzt}"></t:dictSelect>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">审核状态</label>
			          </div>
			          
			          <div class="col-xs-3 text-center">
			          	<b>审核时间：</b>
			          </div>
			          <div class="col-xs-3">
						<input id="shsj" name="shsj" readonly type="text" class="form-control" ignore="ignore"  value='${wuyeSfglYsfyjlPage.shsj}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">审核时间</label>
			          </div>
						
					</div>
					
					<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>审核人员：</b>
			          </div>
			          <div class="col-xs-3">
						<input id="shry" name="shry" readonly type="text" class="form-control" ignore="ignore"  value='${wuyeSfglYsfyjlPage.shry}' />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">审核人员</label>
			          </div>
					</div>
					
					<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>备注：</b>
			          </div>
			          <div class="col-xs-3">
						<textarea id="bz" name="bz" cols="77">${wuyeSfglYsfyjlPage.bz}</textarea>
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
<script src = "webpage/com/jeecg/wuyesfgl/wuyeSfglYsfyjl.js"></script>		
</html>