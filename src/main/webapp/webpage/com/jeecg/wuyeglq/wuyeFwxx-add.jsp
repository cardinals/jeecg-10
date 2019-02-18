<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>房屋基本信息</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="online/template/ledefault/css/vendor.css">
<link rel="stylesheet" href="online/template/ledefault/css/bootstrap-theme.css">
<link rel="stylesheet" href="online/template/ledefault/css/bootstrap.css">
<link rel="stylesheet" href="online/template/ledefault/css/app.css">

<link rel="stylesheet" href="plug-in/Validform/css/metrole/style.css" type="text/css" />
<link rel="stylesheet" href="plug-in/Validform/css/metrole/tablefrom.css" type="text/css" />

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
<script type="text/javascript" charset="utf-8" src="plug-in/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="plug-in/ueditor/ueditor.all.min.js"></script>

<script type="text/javascript">
	//编写自定义JS代码
</script>
</head>

<body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password"
		layout="table" action="wuyeFwxxController.do?doAdd" tiptype="1">
		<input type="hidden" id="btn_sub" class="btn_sub" />
		<input type="hidden" id="id" name="id" />
		<div class="tab-wrapper">
			<!-- tab -->
			<ul class="nav nav-tabs">
				<li role="presentation" class="active"><a
					href="javascript:void(0);">房屋基本信息</a></li>
			</ul>
			<!-- tab内容 -->
			<div class="con-wrapper" id="con-wrapper1" style="display: block;">
				<div class="row form-wrapper">
					<div class="row show-grid" style="display: none">
						<div class="col-xs-3 text-center">
							<b>房间ID：</b>
						</div>
						<div class="col-xs-3">
							<input id="fjid" name="fjid" type="text" class="form-control"
								ignore="ignore" /> <span class="Validform_checktip"
								style="float: left; height: 0px;"></span> <label
								class="Validform_label" style="display: none">房间ID</label>
						</div>


						<div class="col-xs-3 text-center">
							<b>管理区id：</b>
						</div>
						<div class="col-xs-3">
							<input id="glqid" name="glqid" type="text" class="form-control"
								ignore="ignore" value="${glqid }" /> <span
								class="Validform_checktip" style="float: left; height: 0px;"></span>
							<label class="Validform_label" style="display: none">管理区id</label>
						</div>
					</div>


					<div class="row show-grid">
						<div class="col-xs-3 text-center" style="display: none">
							<b>楼宇id：</b>
						</div>
						<div class="col-xs-3" style="display: none">
							<input id="lyid" name="lyid" type="text" class="form-control"
								ignore="ignore" value="${lyid}" /> <span
								class="Validform_checktip" style="float: left; height: 0px;"></span>
							<label class="Validform_label" style="display: none">楼宇id</label>
						</div>


						<div class="col-xs-3 text-center">
							<b>总楼层数：</b>
						</div>
						<div class="col-xs-3">
							<input id="zlcs" name="zlcs" type="text" class="form-control"
								datatype="n" ignore="ignore" /> <span
								class="Validform_checktip" style="float: left; height: 0px;"></span>
							<label class="Validform_label" style="display: none">总楼层数</label>
						</div>
						<div class="col-xs-3 text-center">
							<b>所在楼层：</b>
						</div>
						<div class="col-xs-3">
							<input id="lch" name="lch" type="text" class="form-control"
								datatype="n" ignore="ignore" /> <span
								class="Validform_checktip" style="float: left; height: 0px;"></span>
							<label class="Validform_label" style="display: none">楼层号</label>
						</div>
						

					</div>


					<div class="row show-grid">
						<div class="col-xs-3 text-center">
							<b>单元号：</b>
						</div>
						<div class="col-xs-3">
							<input id="dyh" name="dyh" type="text" class="form-control"
								ignore="ignore" /> <span class="Validform_checktip"
								style="float: left; height: 0px;"></span> <label
								class="Validform_label" style="display: none">单元号</label>
						</div>
						<div class="col-xs-3 text-center">
							<b>房间编号：</b>
						</div>
						<div class="col-xs-3">
							<input id="fjbh" name="fjbh" type="text" class="form-control"
								ignore="ignore" /> <span class="Validform_checktip"
								style="float: left; height: 0px;"></span> <label
								class="Validform_label" style="display: none">房间编号</label>
						</div>
					</div>


					<div class="row show-grid">
						<div class="col-xs-3 text-center">
							<b>收费服务对象：</b>
						</div>
						<div class="col-xs-3">
							<!-- <input id="sffwdx" name="sffwdx" type="text" class="form-control"  ignore="ignore" /> -->
							<t:dictSelect field="sffwdx" type="list"
								extendJson="{class:'form-control'}" typeGroupCode="sfdx"
								hasLabel="false" title="收费服务对象"></t:dictSelect>
							<span class="Validform_checktip"
								style="float: left; height: 0px;"></span> <label
								class="Validform_label" style="display: none">收费服务对象</label>
						</div>

						<div class="col-xs-3 text-center">
							<b>楼型：</b>
						</div>
						<div class="col-xs-3">
							<t:dictSelect field="loux" type="list"
								extendJson="{class:'form-control'}" typeGroupCode="lx"
								hasLabel="false" title="楼型"></t:dictSelect>
							<span class="Validform_checktip"
								style="float: left; height: 0px;"></span> <label
								class="Validform_label" style="display: none">楼型</label>
						</div>
					</div>


					<div class="row show-grid">
						<div class="col-xs-3 text-center">
							<b>建筑面积：</b>
						</div>
						<div class="col-xs-3">
							<input id="jzmj" name="jzmj" type="text" class="form-control"
								datatype="/^(-?\d+)(\.\d+)?$/" ignore="ignore" /> <span
								class="Validform_checktip" style="float: left; height: 0px;"></span>
							<label class="Validform_label" style="display: none">建筑面积</label>
						</div>


						<div class="col-xs-3 text-center">
							<b>套内面积：</b>
						</div>
						<div class="col-xs-3">
							<input id="tnmj" name="tnmj" type="text" class="form-control"
								datatype="/^(-?\d+)(\.\d+)?$/" ignore="ignore" /> <span
								class="Validform_checktip" style="float: left; height: 0px;"></span>
							<label class="Validform_label" style="display: none">套内面积</label>
						</div>
					</div>


					<div class="row show-grid">
						<div class="col-xs-3 text-center">
							<b>公摊面积：</b>
						</div>
						<div class="col-xs-3">
							<input id="gtmj" name="gtmj" type="text" class="form-control"
								datatype="/^(-?\d+)(\.\d+)?$/" ignore="ignore" /> <span
								class="Validform_checktip" style="float: left; height: 0px;"></span>
							<label class="Validform_label" style="display: none">公摊面积</label>
						</div>


						<div class="col-xs-3 text-center">
							<b>阳台面积：</b>
						</div>
						<div class="col-xs-3">
							<input id="ytmj" name="ytmj" type="text" class="form-control"
								datatype="/^(-?\d+)(\.\d+)?$/" ignore="ignore" /> <span
								class="Validform_checktip" style="float: left; height: 0px;"></span>
							<label class="Validform_label" style="display: none">阳台面积</label>
						</div>
					</div>


					<div class="row show-grid">
						<div class="col-xs-3 text-center">
							<b>房屋户型：</b>
						</div>
						<div class="col-xs-3">
							<t:dictSelect field="fwhx" type="list"
								extendJson="{class:'form-control'}" typeGroupCode="fwhx"
								hasLabel="false" title="房屋户型"></t:dictSelect>
							<span class="Validform_checktip"
								style="float: left; height: 0px;"></span> <label
								class="Validform_label" style="display: none">房屋户型</label>
						</div>


						<div class="col-xs-3 text-center">
							<b>房屋类型：</b>
						</div>
						<div class="col-xs-3">
							<t:dictSelect field="fwlx" type="list"
								extendJson="{class:'form-control'}" typeGroupCode="fwlx"
								hasLabel="false" title="房屋类型"></t:dictSelect>
							<span class="Validform_checktip"
								style="float: left; height: 0px;"></span> <label
								class="Validform_label" style="display: none">房屋类型</label>
						</div>
					</div>


					<div class="row show-grid">
						<div class="col-xs-3 text-center">
							<b>住房类别：</b>
						</div>
						<div class="col-xs-3">
							<t:dictSelect field="zflb" type="list"
								extendJson="{class:'form-control'}" typeGroupCode="zflb"
								hasLabel="false" title="住房类别"></t:dictSelect>
							<span class="Validform_checktip"
								style="float: left; height: 0px;"></span> <label
								class="Validform_label" style="display: none">住房类别</label>
						</div>


						<div class="col-xs-3 text-center">
							<b>房屋用途：</b>
						</div>
						<div class="col-xs-3">
							<input id="fwyt" name="fwyt" type="text" class="form-control"
								ignore="ignore" /> <span class="Validform_checktip"
								style="float: left; height: 0px;"></span> <label
								class="Validform_label" style="display: none">房屋用途</label>
						</div>
					</div>


					<div class="row show-grid">
						<div class="col-xs-3 text-center">
							<b>房屋朝向：</b>
						</div>
						<div class="col-xs-3">
							<input id="fwcx" name="fwcx" type="text" class="form-control"
								ignore="ignore" /> <span class="Validform_checktip"
								style="float: left; height: 0px;"></span> <label
								class="Validform_label" style="display: none">房屋朝向</label>
						</div>


						<div class="col-xs-3 text-center">
							<b>房屋状态：</b>
						</div>
						<div class="col-xs-3">
							<t:dictSelect field="fwzt" type="list"
								extendJson="{class:'form-control'}" typeGroupCode="fwzt"
								hasLabel="false" title="房屋状态"></t:dictSelect>
							<span class="Validform_checktip"
								style="float: left; height: 0px;"></span> <label
								class="Validform_label" style="display: none">房屋状态</label>
						</div>
					</div>


					<div class="row show-grid">
						<div class="col-xs-3 text-center">
							<b>竣工日期：</b>
						</div>
						<div class="col-xs-3">
							<input id="jgrq" name="jgrq" type="text" ignore="ignore"
								style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"
								class="form-control"
								onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" /> <span
								class="Validform_checktip" style="float: left; height: 0px;"></span>
							<label class="Validform_label" style="display: none">竣工日期</label>
						</div>


						<div class="col-xs-3 text-center">
							<b>交房日期：</b>
						</div>
						<div class="col-xs-3">
							<input id="jfrq" name="jfrq" type="text" ignore="ignore"
								style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"
								class="form-control"
								onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" /> <span
								class="Validform_checktip" style="float: left; height: 0px;"></span>
							<label class="Validform_label" style="display: none">交房日期</label>
						</div>
					</div>


					<div class="row show-grid">
						<div class="col-xs-3 text-center">
							<b>装修日期：</b>
						</div>
						<div class="col-xs-3">
							<input id="zxrq" name="zxrq" type="text" ignore="ignore"
								style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"
								class="form-control"
								onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" /> <span
								class="Validform_checktip" style="float: left; height: 0px;"></span>
							<label class="Validform_label" style="display: none">装修日期</label>
						</div>


						<div class="col-xs-3 text-center">
							<b>入住日期：</b>
						</div>
						<div class="col-xs-3">
							<input id="rzrq" name="rzrq" type="text" ignore="ignore"
								style="background: url('plug-in/ace/images/datetime.png') no-repeat scroll right center transparent;"
								class="form-control"
								onClick="WdatePicker({dateFmt:'yyyy-MM-dd'})" /> <span
								class="Validform_checktip" style="float: left; height: 0px;"></span>
							<label class="Validform_label" style="display: none">入住日期</label>
						</div>
					</div>


					<div class="row show-grid">
						<div class="col-xs-3 text-center">
							<b>产权人：</b>
						</div>
						<div class="col-xs-3">
							<input id="fwcqr" name="fwcqr" type="text" class="form-control"
								ignore="ignore" /> <span class="Validform_checktip"
								style="float: left; height: 0px;"></span> <label
								class="Validform_label" style="display: none">产权人</label>
						</div>


						<div class="col-xs-3 text-center">
							<b>产权人类型：</b>
						</div>
						<div class="col-xs-3">
							<input id="cqrzjlx" name="cqrzjlx" type="text"
								class="form-control" ignore="ignore" /> <span
								class="Validform_checktip" style="float: left; height: 0px;"></span>
							<label class="Validform_label" style="display: none">产权人类型</label>
						</div>
					</div>


					<div class="row show-grid">
						<div class="col-xs-3 text-center">
							<b>产权人号码：</b>
						</div>
						<div class="col-xs-3">
							<input id="cqrzjhm" name="cqrzjhm" type="text"
								class="form-control" ignore="ignore" /> <span
								class="Validform_checktip" style="float: left; height: 0px;"></span>
							<label class="Validform_label" style="display: none">产权人号码</label>
						</div>


						<div class="col-xs-3 text-center">
							<b>是否拆分出租：</b>
						</div>
						<div class="col-xs-3">
							<t:dictSelect field="cfczbz" type="list"
								extendJson="{class:'form-control'}" typeGroupCode="cfcz"
								hasLabel="false" title="是否拆分出租"></t:dictSelect>
							<span class="Validform_checktip"
								style="float: left; height: 0px;"> </span> <label
								class="Validform_label" style="display: none">是否拆分出租</label>
						</div>
					</div>


					<div class="row show-grid" style="display: none">
						<div class="col-xs-3 text-center">
							<b>排序号：</b>
						</div>
						<div class="col-xs-3">
							<input id="pxh" name="pxh" type="text" class="form-control"
								datatype="n" ignore="ignore" value="${pxh }" /> <span
								class="Validform_checktip" style="float: left; height: 0px;"></span>
							<label class="Validform_label" style="display: none">排序号</label>
						</div>

						<div class="col-xs-3 text-center">
							<b>有效标志：</b>
						</div>
						<div class="col-xs-3">
							<input id="yxbz" name="yxbz" type="text" class="form-control"
								ignore="ignore" value="${yxbz }" /> <span
								class="Validform_checktip" style="float: left; height: 0px;"></span>
							<label class="Validform_label" style="display: none">有效标志</label>
						</div>
						<div class="col-xs-2 text-center">
							<b></b>
						</div>
						<div class="col-xs-4"></div>
					</div>

					<div class="row show-grid">
						<div class="col-xs-3 text-center">
							<b>证件类型：</b>
						</div>
						<div class="col-xs-3">
							<t:dictSelect field="zjmc" type="list"
								extendJson="{class:'form-control'}" typeGroupCode="zjlx"
								hasLabel="false" title="证件类型"></t:dictSelect>
							<span class="Validform_checktip"
								style="float: left; height: 0px;"></span> <label
								class="Validform_label" style="display: none">证件类型</label>
						</div>

						<div class="col-xs-3 text-center">
							<b>证件号码：</b>
						</div>
						<div class="col-xs-3">
							<input id="zjhm" name="zjhm" type="text" class="form-control"
								ignore="ignore" /> <span class="Validform_checktip"
								style="float: left; height: 0px;"></span> <label
								class="Validform_label" style="display: none">证件号码</label>
						</div>
						<div class="col-xs-2 text-center">
							<b></b>
						</div>
						<div class="col-xs-4"></div>
					</div>


					<div class="row" id="sub_tr" style="display: none;">
						<div class="col-xs-12 layout-header">
							<div class="col-xs-6"></div>
							<div class="col-xs-6">
								<button type="button" onclick="neibuClick();"
									class="btn btn-default">提交</button>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="con-wrapper" id="con-wrapper2" style="display: block;"></div>
		</div>
	</t:formvalid>

	<script type="text/javascript">
		$(function() {
			//查看模式情况下,删除和上传附件功能禁止使用
			if (location.href.indexOf("load=detail") != -1) {
				$(".jeecgDetail").hide();
			}

			if (location.href.indexOf("mode=read") != -1) {
				//查看模式控件禁用
				$("#formobj").find(":input").attr("disabled", "disabled");
			}
			if (location.href.indexOf("mode=onbutton") != -1) {
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
<script src="webpage/com/jeecg/wuyeglq/wuyeFwxx.js"></script>
</html>