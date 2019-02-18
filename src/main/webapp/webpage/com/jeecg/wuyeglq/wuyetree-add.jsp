<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%@ page import="com.jeecg.wuyeglq.entity.WuyeGlqEntity" %>
<!DOCTYPE html>
<html>
 <head>
  <title>添加一级部门</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" callback="@Override callbackOrg" action="wuyeGlqController.do?doAdd" >
					<input id="id" name="id" type="hidden" />
		<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							管理区名称:
						</label>
					</td>
					<td class="value">
					     	<input id="glqmc"  name="glqmc" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">管理区名称</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							管理区描述:
						</label>
					</td>
					<td class="value">
					     	<textarea id="glqms"  name="glqms" rows="5" cols="80"></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">管理区描述</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							上级编码:
						</label>
					</td>
					<td class="value">
				        <input name="fid"  id="fid" type="text" value="${wuyeAdd.id}" readonly/>
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">上级编码</label>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							管理区类型:
						</label>
					</td>
					<td class="value">
					     	<t:dictSelect extendJson="{class:'form-control'}" field="glqlx" typeGroupCode="glqlx" type="select" defaultVal="${wuyeglqlx}"></t:dictSelect>
					     	
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">管理区类型</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							排序号:
						</label>
					</td>
					<td class="value">
					     	<input id="pxh"  name="pxh" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">排序号</label>
						</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
						</label>
					</td>
					<td class="value">
					     	<button type="button" class="blueButton" style="width:80px;height:30px" onclick="formSubmit();">保存 </button>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/system/position/tSCompanyPositionList.js"></script>		
<script type="text/javascript">
function formSubmit(){
	if($("#pxh").val() == "" || $("#pxh").val() == null){
		parent.layer.msg("排序号不能为空")
	}else{
		$('#btn_sub').click();
	}
}

function callbackOrg(data){
	if(data.success==true){
		parent.layer.alert(data.msg, {
	        icon: 1,
	        shadeClose: true,
	        title: '提示'
	    },function(index){
	    	
	    	parent.layer.close(index);
	    	
	    });
	}else{
		parent.layer.alert(data.msg, {
	        icon: 0,
	        shadeClose: false,
	        title: '提示'
	    },function(index){
	    	parent.layer.close(index);
	    });
	}
	//tip(data.msg);
}
</script>