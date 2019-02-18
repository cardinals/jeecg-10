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
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wuyeCbglGtbController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${wuyeCbglGtbPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								管理区ID:
							</label>
						</td>
						<td class="value">
						   <%--  <input id="glqid" name="glqid" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglGtbPage.glqid}'/> --%>
						   	<select id="glqid" name="glqid" >
								<c:forEach items="${glqList }" var="i">
									<c:choose>
										<c:when test="${wuyeCbglGtbPage.glqid == i.id }">
											<option value="${i.id }" selected>${i.glqmc}</option>
										</c:when>
										<c:otherwise>
											<option value="${i.id }">${i.glqmc}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select> 
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">管理区ID</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								仪表编号:
							</label>
						</td>
						<td class="value">
						    <input id="ybbh" name="ybbh" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglGtbPage.ybbh}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">仪表编号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								仪表类型:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="yblx" type="list"  typeGroupCode="yblx"   defaultVal="${wuyeCbglGtbPage.yblx}" hasLabel="false"  title="仪表类型" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">仪表类型</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								倍率:
							</label>
						</td>
						<td class="value">
						    <input id="bl" name="bl" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeCbglGtbPage.bl}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">倍率</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								初始读数:
							</label>
						</td>
						<td class="value">
						    <input id="csds" name="csds" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeCbglGtbPage.csds}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">初始读数</label>
						</td>
					</tr>
					<tr style="display: none;">
						<td align="right">
							<label class="Validform_label">
								父ID:
							</label>
						</td>
						<td class="value">
						    <input id="fid" name="fid" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglGtbPage.fid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">父ID</label>
						</td>
					</tr>
					<tr style="display: none;">
 						<td align="right">
							<label class="Validform_label">
								有效标志:
							</label>
						</td>
						<td class="value">
						    <input id="yxbz" name="yxbz" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglGtbPage.yxbz}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">有效标志</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/wuyecbgl/wuyeCbglGtb.js"></script>		
