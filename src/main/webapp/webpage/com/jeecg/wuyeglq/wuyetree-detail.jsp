<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>查看详情</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" callback="@Override callbackOrg" action="systemController.do?saveDepart" >
					<input id="id" name="id" type="hidden" />
		<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable" disabled="disabled">
				<tr>
					<td align="right" style="width: 30%;height:30px">
						<label class="Validform_label">
							管理区名称:
						</label>
					</td>
					<td class="value">
				         ${wuyeglq.glqmc}
					</td>
				</tr>
				<tr>
					<td align="right" style="width: 30%;height:30px">
						<label class="Validform_label">
							管理区描述:
						</label>
					</td>
					<td class="value">
					         ${wuyeglq.glqms}
						</td>
				</tr>
				<tr>
					<td align="right" style="width: 30%;height:30px">
						<label class="Validform_label">
							上级编码:
						</label>
					</td>
					<td class="value">
					          ${wuyeglq.fid}
					</td>
				</tr>
				<tr>
					<td align="right" style="width: 30%;height:30px">
						<label class="Validform_label">
							管理区类型:
						</label>
					</td>
					<td class="value">
					<t:dictSelect extendJson="{class:'form-control'}" field="glqlx" typeGroupCode="glqlx" type="select" defaultVal="${wuyeglq.glqlx}"></t:dictSelect>
				</td>
				</tr>
				<tr>
					<td align="right" style="height:30px">
						<label class="Validform_label">
							排序号:
						</label>
					</td>
					<td class="value">
					     ${wuyeglq.pxh}
					</td>
				</tr>
				<%-- <tr>
					<td align="right" style="height:30px">
						<label class="Validform_label">
							有效标志:
						</label>
					</td>
					<td class="value">
					     ${wuyeglq.yxbz}
					</td>
				</tr> --%>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/system/position/tSCompanyPositionList.js"></script>		
