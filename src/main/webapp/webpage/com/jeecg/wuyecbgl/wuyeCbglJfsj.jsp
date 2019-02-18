<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
 <head>
  <title>公摊表管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="" >
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
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
				<tr>	
		</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/wuyecbgl/wuyeCbglGtb.js"></script>		
