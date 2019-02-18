<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>通用Excel导入${controller_name}</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <link rel="stylesheet" href="plug-in/ztree/css/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/ztreeCreator.js"></script>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:formvalid formid="formobj" layout="div" dialog="true" beforeSubmit="upload">
	<fieldset class="step">
	<div class="form">
			<table cellpadding="0" cellspacing="1" class="formtable" id="tab">
				<tr>
					<td align="right">
						<label class="Validform_label">
							计费起始日期:
						</label>
					</td>
					<td class="value">
							   <input id="jfqsrq" name="jfqsrq" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" value="" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">计费起始日期</label>
						</td>
					</tr>		
					<tr>
					<td align="right">
						<label class="Validform_label">
							计费结束日期:
						</label>
					</td>
					<td class="value">
							   <input id="jfjsrq" name="jfjsrq" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" value=""/>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">计费结束日期</label>
						</td>					
					</tr>
				</table>
		<t:upload name="fiels" buttonText="选择要导入的文件" uploader="${controller_name}.do?${empty method_name?'drscmb':method_name }" extend="*.xls;*.xlsx" id="file_upload" formData="jfqsrq,jfjsrq"></t:upload>
	</div>
	<div class="form" id="filediv" style="height: 50px"></div>
	</fieldset>
</t:formvalid>
</body>
</html>
