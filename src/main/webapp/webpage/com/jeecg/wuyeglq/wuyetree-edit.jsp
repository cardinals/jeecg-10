<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>编辑</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" callback="@Override callbackOrg" action="wuyeGlqController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${wuyeglq.id }"/>
		<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
		        <tr>
					<td align="right">
						<label class="Validform_label">
							管理区名称:
						</label>
					</td>
					<td class="value">
					     	<input id="glqmc" name="glqmc" type="text" value="${wuyeglq.glqmc}"
					style="width: 150px" class="inputxt" ignore="ignore" /> <span class="Validform_checktip"></span>
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
					     	<textarea id="glqms" name="glqms" rows="5" cols="80">${wuyeglq.glqms}</textarea>
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
				        <input name="fid" id="fid" type="text" value="${wuyeglq.fid}"/>
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">上级编码</label>
					</td>
				</tr>
				<tr>
					<td align="right" style="width: 30%;height:30px">
						<label class="Validform_label">
							管理区类型:
						</label>
					</td>
					<td class="value">
					<t:dictSelect field="glqlx" extendJson="{class:'form-control'}" typeGroupCode="glqlx" type="select" defaultVal="${wuyeglq.glqlx}"></t:dictSelect>
				</td>
				</tr>
				<tr>
					<td align="right" style="height:30px">
						<label class="Validform_label">
							排序号:
						</label>
					</td>
					<td class="value">
					      <input name="pxh" id="pxh" type="text" value="${wuyeglq.pxh}"/>
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
	$('#btn_sub').click();
}

function callbackOrg(data){
	if(data.success==true){
		parent.layer.alert(data.msg, {
	        icon: 1,
	        shadeClose: false,
	        title: '提示'
	    },function(index){
	    	/* parent.loadTree();
			location.reload(); */
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