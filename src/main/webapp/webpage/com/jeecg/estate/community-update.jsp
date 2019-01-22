<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>小区表</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="communityController.do?doUpdate" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id" value="${community.id}"/>
	<div class="form-group">
		<label for="commName" class="col-sm-3 control-label">小区名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="commName" name="commName" value='${community.commName}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入小区名称"  datatype="*"  ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="commAddress" class="col-sm-3 control-label">小区地址：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="commAddress" name="commAddress" value='${community.commAddress}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入小区地址"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="commMan" class="col-sm-3 control-label">小区负责人：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="commMan" name="commMan" value='${community.commMan}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入小区负责人"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="commPhone" class="col-sm-3 control-label">联系电话：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="commPhone" name="commPhone" value='${community.commPhone}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入联系电话"  datatype="m" ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="fatherId" class="col-sm-3 control-label">所属管区id：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="fatherId" name="fatherId" value='${community.fatherId}' type="text" maxlength="36" class="form-control input-sm" placeholder="请输入所属管区id"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="coverArea" class="col-sm-3 control-label">占地面积：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="coverArea" name="coverArea" value='${community.coverArea}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入占地面积"  datatype="n" ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="buildingArea" class="col-sm-3 control-label">建筑面积：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="buildingArea" name="buildingArea" value='${community.buildingArea}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入建筑面积"  datatype="n" ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="createBy" class="col-sm-3 control-label">创建人：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="createBy" name="createBy" value='${community.createBy}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入创建人"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="createDate" class="col-sm-3 control-label">创建时间：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
      		    <input id="createDate" name="createDate" type="text" class="form-control input-sm laydate-date" placeholder="请输入创建时间"  ignore="ignore"  value="<fmt:formatDate pattern='yyyy-MM-dd' type='date' value='${community.createDate}'/>" />
                <span class="input-group-addon" ><span class="glyphicon glyphicon-calendar"></span></span>
			</div>
		</div>
	</div>
	</form>
	</div>
 </div>
<script type="text/javascript">
var subDlgIndex = '';
$(document).ready(function() {
	$(".laydate-datetime").each(function(){
		var _this = this;
		laydate.render({
		  elem: _this,
		  format: 'yyyy-MM-dd HH:mm:ss',
		  type: 'datetime',
		  ready: function(date){
		  	 $(_this).val(DateJsonFormat(date,this.format));
		  }
		});
	});
	$(".laydate-date").each(function(){
		var _this = this;
		laydate.render({
		  elem: _this,
		  format: 'yyyy-MM-dd',
		  ready: function(date){
		  	 $(_this).val(DateJsonFormat(date,this.format));
		  }
		});
	});
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