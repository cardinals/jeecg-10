<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>房屋迁入管理</title>
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
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wuyeYzglFwqrglController.do?doAdd" tiptype="1" >
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" id="id" name="id"/>
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);">房屋迁入管理</a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
							<div class="row show-grid"  style="display:none">
			          <div class="col-xs-3 text-center">
			          	<b>管理区id：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="glqid" name="glqid" type="text" class="form-control"  ignore="ignore"  value="${glqId}"/>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">管理区id</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>房屋主键：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="fwxxid" name="fwxxid" type="text" class="form-control"  ignore="ignore" value="${fwxxid}"/>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">房屋主键</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>迁入房间id：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="fjid" name="fjid" type="text" class="form-control"  datatype="n"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">迁入房间id</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>迁入房间编号：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="fjbh" name="fjbh" type="text" class="form-control"  ignore="ignore" value="${fjbh}"/>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">迁入房间编号</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>入住日期：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="rzrq" name="rzrq" type="text" ignore="ignore" style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"  class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">入住日期</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>收费服务对象：</b>
			          </div>
			          <div class="col-xs-3">
								<t:dictSelect field="sffwdx" type="list" extendJson="{class:'form-control'}"   typeGroupCode="sfdx"  hasLabel="false"  title="收费服务对象"></t:dictSelect>     
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收费服务对象</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>客户ID：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="khid" name="khid" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">客户ID</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>客户姓名：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="khxm" name="khxm" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">客户姓名</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>联系电话：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="lxdh" name="lxdh" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">联系电话</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>迁入后房间状态：</b>
			          </div>
			          <div class="col-xs-3">
								<t:dictSelect field="qrhfjzt" type="list" extendJson="{class:'form-control'}"   typeGroupCode="fwzt"  hasLabel="false"  title="迁入后房间状态"></t:dictSelect>     
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">迁入后房间状态</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>收费开始日期：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="sfksrq" name="sfksrq" type="text" ignore="ignore" style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"  class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收费开始日期</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>收费结束日期：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="sfjsrq" name="sfjsrq" type="text" ignore="ignore" style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"  class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收费结束日期</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>备注：</b>
			          </div>
			          <div class="col-xs-3">								
								<textarea id="bz" name="bz"  class="form-control"
								ignore="ignore"  cols="22"  style ="width:545px ;height:45px " ></textarea>
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
<script src = "webpage/com/jeecg/wuyeyzgl/wuyeYzglFwqrgl.js"></script>		
</html>