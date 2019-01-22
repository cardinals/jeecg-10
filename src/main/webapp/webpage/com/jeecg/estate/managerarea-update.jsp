<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>管区表</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="managerareaController.do?doUpdate" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id" value="${managerarea.id}"/>
	<div class="form-group">
		<label for="areaName" class="col-sm-3 control-label">管区名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="areaName" name="areaName" value='${managerarea.areaName}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入管区名称"  datatype="*"  ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="areaAddress" class="col-sm-3 control-label">管区地址：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="areaAddress" name="areaAddress" value='${managerarea.areaAddress}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入管区地址"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="areaMan" class="col-sm-3 control-label">管区负责人：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="areaMan" name="areaMan" value='${managerarea.areaMan}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入管区负责人"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="areaPhone" class="col-sm-3 control-label">联系电话：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="areaPhone" name="areaPhone" value='${managerarea.areaPhone}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入联系电话"  datatype="m" ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="fatherId" class="col-sm-3 control-label">所属公司id：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="fatherId" name="fatherId" value='${managerarea.fatherId}' type="text" maxlength="36" class="form-control input-sm" placeholder="请输入所属公司id"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="coverArea" class="col-sm-3 control-label">占地面积：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="coverArea" name="coverArea" value='${managerarea.coverArea}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入占地面积"  datatype="n" ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="buildingArea" class="col-sm-3 control-label">建筑面积：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="buildingArea" name="buildingArea" value='${managerarea.buildingArea}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入建筑面积"  datatype="n" ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="createBy" class="col-sm-3 control-label">创建人：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="createBy" name="createBy" value='${managerarea.createBy}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入创建人"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="createDate" class="col-sm-3 control-label">创建时间：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
      		    <input id="createDate" name="createDate" type="text" class="form-control input-sm laydate-date" placeholder="请输入创建时间"  ignore="ignore"  value="<fmt:formatDate pattern='yyyy-MM-dd' type='date' value='${managerarea.createDate}'/>" />
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