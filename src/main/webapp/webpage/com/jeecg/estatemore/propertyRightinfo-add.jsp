<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>房间产权信息表</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="propertyRightinfoController.do?doAdd" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id"/>
		<div class="form-group">
			<label for="roomId" class="col-sm-3 control-label">房间id：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="roomId" name="roomId" type="text" maxlength="36" class="form-control input-sm" placeholder="请输入房间id"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="nowRight" class="col-sm-3 control-label">房屋所有权人 现：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="nowRight" name="nowRight" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入房屋所有权人 现"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="nowCertificate" class="col-sm-3 control-label">证件名称 现：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="nowCertificate" name="nowCertificate" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入证件名称 现"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="nowCardnum" class="col-sm-3 control-label">证件号码 现：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="nowCardnum" name="nowCardnum" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入证件号码 现"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="oldRight" class="col-sm-3 control-label">房屋所有权人 原：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="oldRight" name="oldRight" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入房屋所有权人 原"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="oldCertificate" class="col-sm-3 control-label">证件名称 原：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="oldCertificate" name="oldCertificate" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入证件名称 原"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="oldCardnum" class="col-sm-3 control-label">证件号码 原：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="oldCardnum" name="oldCardnum" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入证件号码 原"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="changeBy" class="col-sm-3 control-label">变更人：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="changeBy" name="changeBy" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入变更人"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="changeDate" class="col-sm-3 control-label">变更日期：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="changeDate" name="changeDate" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入变更日期"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="note" class="col-sm-3 control-label">备注：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="note" name="note" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入备注"  ignore="ignore" />
				</div>
			</div>
		</div>
	</form>
	</div>
 </div>
<script type="text/javascript">
var subDlgIndex = '';
$(document).ready(function() {
	//单选框/多选框初始化
	$('.i-checks').iCheck({
		labelHover : false,
		cursor : true,
		checkboxClass : 'icheckbox_square-green',
		radioClass : 'iradio_square-green',
		increaseArea : '20%'
	});
	
	//表单提交
	$("#formobj").Validform({
		tiptype:function(msg,o,cssctl){
			if(o.type==3){
				validationMessage(o.obj,msg);
			}else{
				removeMessage(o.obj);
			}
		},
		btnSubmit : "#btn_sub",
		btnReset : "#btn_reset",
		ajaxPost : true,
		beforeSubmit : function(curform) {
		},
		usePlugin : {
			passwordstrength : {
				minLen : 6,
				maxLen : 18,
				trigger : function(obj, error) {
					if (error) {
						obj.parent().next().find(".Validform_checktip").show();
						obj.find(".passwordStrength").hide();
					} else {
						$(".passwordStrength").show();
						obj.parent().next().find(".Validform_checktip").hide();
					}
				}
			}
		},
		callback : function(data) {
			var win = frameElement.api.opener;
			if (data.success == true) {
				frameElement.api.close();
			    win.reloadTable();
			    win.tip(data.msg);
			} else {
			    if (data.responseText == '' || data.responseText == undefined) {
			        $.messager.alert('错误', data.msg);
			        $.Hidemsg();
			    } else {
			        try {
			            var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
			            $.messager.alert('错误', emsg);
			            $.Hidemsg();
			        } catch (ex) {
			            $.messager.alert('错误', data.responseText + "");
			            $.Hidemsg();
			        }
			    }
			    return false;
			}
		}
	});
		
});
</script>
</body>
</html>