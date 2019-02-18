<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>房屋租赁信息-修改</title>
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
	$(function(){
		$(".topbutton1").on("click",function(){
			$(".yzxx").show();
			$(".dkrxx").hide();
			$(".dbrxx").hide();
			$(".qtxx").hide();
		})
		$(".topbutton2").on("click",function(){
			$(".yzxx").hide();
			$(".dkrxx").show();
			$(".dbrxx").hide();
			$(".qtxx").hide();
		})
		$(".topbutton3").on("click",function(){
			$(".yzxx").hide();
			$(".dkrxx").hide();
			$(".dbrxx").show();
			$(".qtxx").hide();
		})
		$(".topbutton4").on("click",function(){
			$(".yzxx").hide();
			$(".dkrxx").hide();
			$(".dbrxx").hide();
			$(".qtxx").show();
		})
	})
</script>
<style type="text/css">
	.topbutton{display:inline-block;padding:5px 10px;border:1px solid #aaa;margin:5px 5px 5px 0;text-decoration:none;}
</style>
</head>

 <body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wuyeYzglFwyzxxController.do?doUpdate" tiptype="1" >
			<input type="hidden" id="btn_sub" class="btn_sub"/>
			<input type="hidden" name="id" value='${wuyeYzglFwyzxxPage.id}' >
			
			<div class="tab-wrapper">
			    <!-- tab -->
			    <ul class="nav nav-tabs">
			      <li role="presentation" class="active"><a href="javascript:void(0);">房屋业主信息</a></li>
			    </ul>
			    <a class="topbutton topbutton1" href="#">业主信息</a>
				<a class="topbutton topbutton2" href="#">代扣人信息</a>
				<a class="topbutton topbutton3" href="#">担保人信息</a>
				<a class="topbutton topbutton4" href="#">其他信息</a>
				
			    <!-- tab内容 -->
			    <div class="con-wrapper" id="con-wrapper1" style="display: block;">
			      <div class="row form-wrapper">
			      		<!-- 业主信息================================================================================== -->
						<div class="yzxx">
							<div class="row show-grid">
						          <div class="col-xs-3 text-center">
						          	<b>所在楼盘：</b>
						          </div>
						          <div class="col-xs-3">
									<input id="szlp" name="szlp" type="text" readonly class="form-control" ignore="ignore"  value='${louyu}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">所在楼盘</label>
						          </div>
						          
						        
						          <div class="col-xs-3 text-center">
						          	<b>所在房间：</b>
						          </div>
						          <div class="col-xs-3">
									<input id="szfj" name="szfj" type="text" readonly class="form-control" ignore="ignore"  value='${fjbh}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">所在房间</label>
						          </div>
							</div> 
							<div class="row show-grid">
						          <div class="col-xs-3 text-center">
						          	<b>房间ID：</b>
						          </div>
						          <div class="col-xs-3">
									<input id="fjid" name="fjid" type="text" class="form-control" datatype="n" readonly  ignore="ignore"  value='${wuyeYzglFwyzxxPage.fjid}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">房间ID</label>
						          </div>
						          <div class="col-xs-3 text-center">
						          	<b>业主编码：</b>
						          </div>
						          <div class="col-xs-3">
									<input id="yzBm" name="yzBm" type="text" class="form-control" readonly ignore="ignore"  value='${wuyeYzglFwyzxxPage.yzBm}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">业主编码</label>
						          </div>
							</div>
			          
			        
							<div class="row show-grid">
						          <div class="col-xs-3 text-center">
						          	<b>业主属性：</b>
						          </div>
						          <div class="col-xs-3">
									<%-- <input id="yzSx" name="yzSx" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.yzSx}' /> --%>
									<t:dictSelect  extendJson="{class:'form-control'}"  field="yzSx" typeGroupCode="yzSx" readonly="readonly" type="select" defaultVal="${wuyeYzglFwyzxxPage.yzSx}"></t:dictSelect>
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">业主属性</label>
						          </div>
						          
						        
						          <div class="col-xs-3 text-center" style="display: none">
						          	<b>业主类型：</b>
						          </div>
						          <div class="col-xs-3" style="display: none">
											<%-- <input id="yzLx" name="yzLx" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.yzLx}' /> --%>
									<t:dictSelect field="yzLx" typeGroupCode="yzLx" type="select" defaultVal="${wuyeYzglFwyzxxPage.yzLx}"></t:dictSelect>
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">业主类型</label>
						          </div>
							</div>
							<div class="row show-grid">
						          <div class="col-xs-3 text-center">
						          	<b>业主名称：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="yzMc" name="yzMc" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.yzMc}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">业主名称</label>
						          </div>
						           <div class="col-xs-3 text-center">
						          	<b>联系人：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="yzLxr" name="yzLxr" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.yzLxr}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">联系人</label>
						          </div>
						   	</div>   
						   	<div class="row show-grid">    
						         
						          <div class="col-xs-3 text-center">
						          	<b>性别：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="yzXb" name="yzXb" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.yzXb}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">性别</label>
						          </div>
						          <div class="col-xs-3 text-center">
						          	<b>出生日期：</b>
						          </div>
						          <div class="col-xs-3">
									<%-- <input id="yzCsrq" name="yzCsrq" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.yzCsrq}' /> --%>
									<input id="yzCsrq" name="yzCsrq" type="text" ignore="ignore"
									style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"
									class="form-control" value='${wuyeYzglFwyzxxPage.yzCsrq}'
									onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">出生日期</label>
						          </div>
							</div>
						   	<div class="row show-grid">
						           <div class="col-xs-3 text-center">
						          	<b>身份证号：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="yzSfzh" name="yzSfzh" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.yzSfzh}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">身份证号</label>
						          </div>
						           <div class="col-xs-3 text-center">
						          	<b>工作单位：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="yzGzdw" name="yzGzdw" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.yzGzdw}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">工作单位</label>
						          </div>
						          
							</div>
						   	<div class="row show-grid">
						          <div class="col-xs-3 text-center">
						          	<b>座机号：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="yzZuoj" name="yzZuoj" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.yzZuoj}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">座机号</label>
						          </div>
						         <div class="col-xs-3 text-center">
						          	<b>手机号：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="yzShouj" name="yzShouj" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.yzShouj}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">手机号</label>
						          </div>	 
							</div> 
							<div class="row show-grid">
						          
						          <div class="col-xs-3 text-center" hidden="hidden">
						          	<b>传真号：</b>
						          </div>
						          <div class="col-xs-3"  hidden="hidden">
											<input id="yzChuanz" name="yzChuanz" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.yzChuanz}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">传真号</label>
						          </div>
						          
						          <div class="col-xs-3 text-center" >
						          	<b>租赁费：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="zlf" name="zlf" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.zlf}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">租赁费</label>
						          </div>
						          
						          <div class="col-xs-3 text-center">
						          	<b>业主现状：</b>
						          </div>
						          <div class="col-xs-3">
									<%-- <input id="yzXz" name="yzXz" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.yzXz}' /> --%>
									<t:dictSelect  extendJson="{class:'form-control'}"  field="yzXz" typeGroupCode="yzXz" type="select" defaultVal="${wuyeYzglFwyzxxPage.yzXz}"></t:dictSelect>
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">业主现状</label>
						          </div>
						          
							</div>
						</div>
							
						    
			          <!-- 代扣人信息================================================================================== -->	
					
						<div class="dkrxx" style="display:none">
							<div class="row show-grid">
						          <div class="col-xs-3 text-center">
						          	<b>代扣人姓名：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="dkrXm" name="dkrXm" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.dkrXm}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">代扣人姓名</label>
						          </div>
						          
						          <div class="col-xs-3 text-center">
						          	<b>代扣人工作单位：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="dkrGzdw" name="dkrGzdw" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.dkrGzdw}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">代扣人工作单位</label>
						          </div>
							</div>
			        
							<div class="row show-grid">
						          <div class="col-xs-3 text-center">
						          	<b>代扣方式：</b>
						          </div>
						          <div class="col-xs-3">
											<%-- <input id="dkrDkfs" name="dkrDkfs" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.dkrDkfs}' /> --%>
									<t:dictSelect extendJson="{class:'form-control'}" field="dkrDkfs" typeGroupCode="dkrDkfs" type="select" defaultVal="${wuyeYzglFwyzxxPage.dkrDkfs}"></t:dictSelect>
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">代扣方式</label>
						          </div>
						          
						          <div class="col-xs-3 text-center">
						          	<b>代扣银行：</b>
						          </div>
						          <div class="col-xs-3">
									<t:dictSelect extendJson="{class:'form-control'}" field="dkrDkyh" typeGroupCode="dkrDkyh" type="select" defaultVal="${wuyeYzglFwyzxxPage.dkrDkyh}"></t:dictSelect>
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">代扣银行</label>
						          </div>
							</div>
			        
							<div class="row show-grid">
						          <div class="col-xs-3 text-center">
						          	<b>代扣银行账号：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="dkrDkyhzh" name="dkrDkyhzh" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.dkrDkyhzh}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">代扣银行账号</label>
						          </div>
						          
						          <div class="col-xs-3 text-center">
						          	<b>代扣单位：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="dkrDkdw" name="dkrDkdw" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.dkrDkdw}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">代扣单位</label>
						          </div>
							</div>
			        
							<div class="row show-grid">
						          <div class="col-xs-3 text-center">
						          	<b>代扣单位工号：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="dkrDkdwgh" name="dkrDkdwgh" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.dkrDkdwgh}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">代扣单位工号</label>
						          </div>
						        
						          <div class="col-xs-3 text-center">
						          	<b>代扣人联系电话：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="dkrLxdh" name="dkrLxdh" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.dkrLxdh}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">代扣人联系电话</label>
						          </div>
							</div>
			        
							<div class="row show-grid">
						          <div class="col-xs-3 text-center">
						          	<b>代扣人现状：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="dkrXz" name="dkrXz" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.dkrXz}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">代扣人现状</label>
						          </div>
						   	</div>  
						   	 
						</div>   	
						<!-- 担保人信息================================================================================== -->	
					
						<div class="dbrxx" style="display:none"> 
							<div class="row show-grid">    
						          <div class="col-xs-3 text-center">
						          	<b>担保人姓名：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="dbrXm" name="dbrXm" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.dbrXm}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">担保人姓名</label>
						          </div>
						          <div class="col-xs-3 text-center">
						          	<b>担保人单位：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="dbrDw" name="dbrDw" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.dbrDw}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">担保人单位</label>
						          </div>
							</div>
			        
							<div class="row show-grid">
						          <div class="col-xs-3 text-center">
						          	<b>担保人工号：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="dbrGh" name="dbrGh" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.dbrGh}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">担保人工号</label>
						          </div>
						          <div class="col-xs-3 text-center">
						          	<b>担保人联系电话：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="dbrLxdh" name="dbrLxdh" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.dbrLxdh}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">担保人联系电话</label>
						          </div>
							</div>
						
						</div>  	
						   	    
						<!-- 其他信息================================================================================== -->	
					
						<div class="qtxx" style="display:none">     
							<div class="row show-grid">
						          <div class="col-xs-3 text-center">
						          	<b>是否减免：</b>
						          </div>
						          <div class="col-xs-3">
											<%-- <input id="sfjm" name="sfjm" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.sfjm}' /> --%>
									<t:dictSelect extendJson="{class:'form-control'}" field="sfjm" typeGroupCode="cfcz" type="select" defaultVal="${wuyeYzglFwyzxxPage.sfjm}"></t:dictSelect>
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">是否减免</label>
						          </div>
						           <div class="col-xs-3 text-center">
						          	<b>减免原因：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="jmyy" name="jmyy" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.jmyy}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">减免原因</label>
						          </div>
							</div>
			          
			        
							<div class="row show-grid">
						        
						          <div class="col-xs-3 text-center">
						          	<b>收费开始日期：</b>
						          </div>
						          <div class="col-xs-3">
									<%-- <input id="sfksrq" name="sfksrq" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.sfksrq}' /> --%>
									<input id="sfksrq" name="sfksrq" type="text" ignore="ignore"
									style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"
									class="form-control" value='${wuyeYzglFwyzxxPage.sfksrq}' 
									onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">收费开始日期</label>
						          </div>
						           <div class="col-xs-3 text-center">
						          	<b>收费截止日期：</b>
						          </div>
						          <div class="col-xs-3">
											<%-- <input id="sfjzrq" name="sfjzrq" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.sfjzrq}' /> --%>
									<input id="sfjzrq" name="sfjzrq" type="text" ignore="ignore"
									style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"
									class="form-control" value='${wuyeYzglFwyzxxPage.sfjzrq}'
									onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">收费截止日期</label>
						          </div>
							</div>
			          
						    <div class="row show-grid">    
						          <div class="col-xs-3 text-center">
						          	<b>备注：</b>
						          </div>
						          <div class="col-xs-3">
									<%-- <input id="bz" name="bz" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.bz}' /> --%>
									<textarea id="bz"  name="bz" cols="80">${wuyeYzglFwyzxxPage.bz}</textarea>
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">备注</label>
						          </div>
							</div>
			          
			        
							<%-- <div class="row show-grid">
						          <div class="col-xs-3 text-center">
						          	<b>有效标志：</b>
						          </div>
						          <div class="col-xs-3">
											<input id="yxbz" name="yxbz" type="text" class="form-control" ignore="ignore"  value='${wuyeYzglFwyzxxPage.yxbz}' />
									<span class="Validform_checktip" style="float:left;height:0px;"></span>
									<label class="Validform_label" style="display: none">有效标志</label>
						          </div>
										<div class="col-xs-2 text-center"><b></b></div>
						         		<div class="col-xs-4"></div>
							</div> --%>
						
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
<script src = "webpage/com/jeecg/wuyeyzgl/wuyeYzglFwyzxx.js"></script>		
</html>