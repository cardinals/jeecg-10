<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>应收费用计算项目表</title>
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
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wuyeSfglYsfyjsxmController.do?doAdd" tiptype="1" >
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" id="id" name="id"/>
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);">应收费用计算项目表 
			      </a></li>
			    </ul>
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
							<div class="row show-grid" style="display:none">
			          <div class="col-xs-3 text-center">
			          	<b>管理区id：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="glqid" name="glqid" type="text" class="form-control"  ignore="ignore"  value="${zNodes.glqid}"/>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">管理区id</label>
			          </div>
			          
			          <div class="col-xs-3 text-center">
			          	<b>主表id：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="zbid" name="zbid" type="text" class="form-control"  ignore="ignore"   value="${zbid}"/>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">主表id</label>
			          </div>
			        
			          <div class="col-xs-3 text-center">
			          	<b>收费项目代码：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="sfxmdm" name="sfxmdm" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收费项目代码</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>收费项目名称：</b>
			          </div>
			          <div class="col-xs-3">
								<t:dictSelect id="sfxmmc"  field="sfxmmc" type="list"  dictTable="wuye_sfgl_sfxmsz"  dictField="xmmc"  dictText="xmmc" defaultVal="" dictCondition=" where glqid='${glqid}'  and xmmc in (select x.xmmc FROM wuye_sfgl_sfxmsz x where NOT EXISTS (SELECT f.sfxmmc FROM wuye_sfgl_ysfyjsxm f WHERE f.sfxmmc = x.xmmc AND f.zbid='${zbid}'))"  hasLabel="false"  title="机构"  extendJson="{class:'form-control'}" ></t:dictSelect>
								<%-- <input id="sfxmmc" name="sfxmmc" type="text" class="form-control"  ignore="ignore" value="${fxmszPage.xmmc}"/> --%>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收费项目名称</label>
			          </div>
			          
			        			         			        
			          <div class="col-xs-3 text-center"  >
			          	<b>收费方式：</b>
			          </div>
			          <div class="col-xs-3">
								<t:dictSelect  extendJson="{class:'form-control',disabled='disabled'}"  id="tsffs" field="sffs"  typeGroupCode="sffs"  type="list" ></t:dictSelect>								
								<input hidden="hidden"  id="sffs" name="sffs" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收费方式</label>
			          </div>		
							</div>
			          		        		        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>计费方式：</b>
			          </div>
			          <div class="col-xs-3">
			          			<t:dictSelect  extendJson="{class:'form-control',disabled='disabled'}"  id="tjffs"  field="jffs" typeGroupCode="jffs" type="select"></t:dictSelect>
								<input  hidden="hidden"   id="jffs" name="jffs" type="text" class="form-control"  ignore="ignore"  />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费方式</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>计费周期：</b>
			          </div>
			          <div class="col-xs-3">
								<input  readonly="readonly"   id="jfzq" name="jfzq" type="text" class="form-control"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费周期</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>计费周期单位：</b>
			          </div>
			          <div class="col-xs-3">
			          			<t:dictSelect  extendJson="{class:'form-control',disabled='disabled'}" id="tjfzqdw"  field="jfzqdw" typeGroupCode="jfzqdw" type="select"></t:dictSelect>
								<input  hidden="hidden"   id="jfzqdw" name="jfzqdw" type="text" class="form-control"  ignore="ignore"  />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费周期单位</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>计费单价(元)：</b>
			          </div>
			          <div class="col-xs-3">
								<input  readonly="readonly"  id="jfdj" name="jfdj" type="text" class="form-control"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费单价</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>计费精度：</b>
			          </div>
			          <div class="col-xs-3">
			          			<t:dictSelect extendJson="{class:'form-control',disabled='disabled'}" id="tjfjd"  field="jfjd"  typeGroupCode="jfjd" type="select"></t:dictSelect>
								<input  hidden="hidden"  id="jfjd" name="jfjd" type="text" class="form-control"  ignore="ignore"  />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费精度</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>滞纳金率：</b>
			          </div>
			          <div class="col-xs-3">
								<input  readonly="readonly"  id="znjl" name="znjl" type="text" class="form-control"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">滞纳金率</label>
			          </div>
							</div>
			          
			        
							<div class="row show-grid">
			          <div class="col-xs-3 text-center">
			          	<b>滞纳金开始天数：</b>
			          </div>
			          <div class="col-xs-3">
								<input  readonly="readonly"  id="znjksts" name="znjksts" type="text" class="form-control"  datatype="n"  ignore="ignore"  />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">滞纳金开始天数</label>
			          </div>
			          
			        
			          <div class="col-xs-3 text-center">
			          	<b>计算公式：</b>
			          </div>
			          <div class="col-xs-3">
			          			<textarea  readonly="readonly"    class="form-control"    id="jsgs"  name="jsgs"  ignore="ignore"></textarea>
								
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计算公式</label>
			          </div>
							</div>
			          
			        <div class="row show-grid">	          
			          <div class="col-xs-3 text-center">
			          	<b>计费开始时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="jfqssj" name="jfqssj" type="text" ignore="ignore" style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"  class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${jfqssj}"/>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费开始时间</label>
			          </div>
			          
			          <div class="col-xs-3 text-center">
			          	<b>计费终止时间：</b>
			          </div>
			          <div class="col-xs-3">
								<input id="jfjzsj" name="jfjzsj" type="text" ignore="ignore" style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"  class="form-control" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="${jfjzsj}"/>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">计费终止时间</label>
			          </div>
			           <div class="col-xs-3 text-center" hidden="hidden">
			          	<b>收费项目id：</b>
			          </div>
			          <div class="col-xs-3" hidden="hidden">
								<input id="sfxmid" name="sfxmid" type="text" class="form-control"  ignore="ignore"  />
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">收费项目id</label>
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
  //项目名称变更事件
  $("#sfxmmc").change(function(){
	  var val = $('#sfxmmc option:selected').val();
	  loadTree(val);
  });
  function loadTree(val) {
	  
		jQuery.ajax({  
	        async : false,  
	        cache:false,  
	        type: 'POST',  
	        dataType : "json",  
	        url: "wuyeSfglYsfyjsxmController.do?goAdd2&name="+val,//请求的action路径  
	        error: function () {//请求失败处理函数  
	            alert('请求失败');  
	        },
		    success:function(data){ //请求成功后处理函数。            
				$('#glqid').val(data.glqid);		        
				$('#sfxmdm').val(data.xmdm);
				$('#sffs').val(data.sffs);$('#tsffs').val(data.sffs);
				$('#jffs').val(data.jffs);$('#tjffs').val(data.jffs);				
				$('#jfzq').val(data.jfzq);
				$('#jfzqdw').val(data.jfzqdw);$('#tjfzqdw').val(data.jfzqdw);
				$('#jfdj').val(data.jfdj);
				$('#jfjd').val(data.jfjd);$('#tjfjd').val(data.jfjd);
				$('#znjl').val(data.znjl);
				$('#znjksts').val(data.znjksts);
			    $('#jsgs').val(data.jsgs);
			    $('#sfxmid').val(data.id);
	        }  
	    });
   }
</script>
 </body>
<script src = "webpage/com/jeecg/wuyesfgl/wuyeSfglYsfyjsxm.js"></script>		
</html>