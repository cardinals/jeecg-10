<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>楼宇表</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="buildingController.do?doAdd" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id"/>
		<div class="row">
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					楼宇编号：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="buildNum" type="text" class="form-control input-sm" maxlength="32"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					楼宇名称：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="buildName" type="text" class="form-control input-sm" maxlength="32"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					楼宇地址：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="buildAddress" type="text" class="form-control input-sm" maxlength="32"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					楼宇类型：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="buildType" type="text" class="form-control input-sm" maxlength="32"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					楼宇结构：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="buildStru" type="text" class="form-control input-sm" maxlength="32"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					楼宇朝向：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="buildToward" type="text" class="form-control input-sm" maxlength="32"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					楼层数：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="buildFloor" type="text" class="form-control input-sm" maxlength="16"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					备注：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="note" type="text" class="form-control input-sm" maxlength="32"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					所属小区id：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input id="some1" type="text" class="form-control input-sm" maxlength="36"  datatype="*"  ignore="checked"  value="${idMap.commId}" disabled="disabled"/>
					<input id="commId" name="commId" type="text" class="form-control input-sm" maxlength="36" ignore="ignore" value="${idMap.commId}" style="display:none;"/>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					所属管区id：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input id="some2" type="text" class="form-control input-sm" maxlength="36"  ignore="ignore"  value="${idMap.managerId}" disabled="disabled"/>
					<input id="manaId" name="manaId" type="text" class="form-control input-sm" maxlength="36" ignore="ignore" value="${idMap.managerId}" style="display:none;"/>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					所属公司id：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input id="some3" type="text" class="form-control input-sm" maxlength="36"  ignore="ignore"  value="${idMap.companyId}" disabled="disabled"/>
					<input id="comId" name="comId" type="text" class="form-control input-sm" maxlength="36" ignore="ignore" value="${idMap.companyId}" style="display:none;"/>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					创建人：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input id="createBy" name="createBy" type="text" class="form-control input-sm" maxlength="32"  ignore="ignore"  value="${userN}"/>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					创建时间：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input id="riqi" type="text" class="form-control input-sm" maxlength="32"  ignore="ignore" style="display:none;"/>
					<input id="createDate" name="createDate" type="text" class="form-control input-sm" maxlength="32" ignore="ignore" value=""/>
				</div>
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
	alert(document.getElementById("createBy").value);
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
function getDate(){
	//debugger;
	var today = new Date(); 
	var date = ""; 
	date = (today.getFullYear()) +"-" + (today.getMonth() + 1 ) + "-" + today.getDate(); 
	return date;
	}
//自动添加日期
document.getElementById("createDate").value=getDate();
</script>
</body>
</html>