<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>房间表管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wuyeCbglFjbController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${wuyeCbglFjbPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								房间ID:
							</label>
						</td>
						<td class="value">
						    <%-- <input id="fjid" name="fjid" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${wuyeCbglFjbPage.fjid}'/> --%>
						    <input id="fjid" name="fjid" type="text" style="width: 150px" class="inputxt" ignore="ignore" value='${wuyeCbglFjbPage.fjid}' readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房间id</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								公摊表ID:
							</label>
						</td>
						<td class="value">
						    <%-- <input id="gtbid" name="gtbid" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglFjbPage.gtbid}'/> --%>
							<input id="gtbid" name="gtbid" type="text" style="width: 150px" class="inputxt" ignore="ignore" value='${wuyeCbglFjbPage.gtbid}' readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公摊表ID</label>
						</td>						
					</tr>
					<tr style="display: none;">
						<td align="right">
							<label class="Validform_label">
								管理区id:
							</label>
						</td>
						<td class="value">
						    <input id="glqid" name="glqid" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglFjbPage.glqid}' readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">管理区id</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								房屋主键:
							</label>
						</td>
						<td class="value">
						    <input id="fwxxid" name="fwxxid" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglFjbPage.fwxxid}' readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房屋主键</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								房间地址:
							</label>
						</td>
						<td class="value">
						    <input id="fjdz" name="fjdz" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglFjbPage.fjdz}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房间地址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								仪表类型:
							</label>
						</td>
						<td class="value">
									<%-- <t:dictSelect field="yblx" type="list"  typeGroupCode="yblx"   defaultVal="${wuyeCbglFjbPage.yblx}" hasLabel="false"  title="仪表类型"></t:dictSelect> --%> 
							 	 <input id="yblx" name="yblx" type="text" style="width: 150px" class="inputxt" ignore="ignore" value='${wuyeCbglFjbPage.yblx}' readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">仪表类型</label>
						</td>						
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								仪表编号:
							</label>
						</td>
						<td class="value">
						    <input id="ybbh" name="ybbh" type="text" style="width: 150px" class="inputxt" ignore="ignore"  value='${wuyeCbglFjbPage.ybbh}' readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">仪表编号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								收费项目代码:
							</label>
						</td>
						<td class="value">
						    <input id="sfxmdm" name="sfxmdm" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglFjbPage.sfxmdm}' readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收费项目代码</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								倍率:
							</label>
						</td>
						<td class="value">
						    <input id="bl" name="bl" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglFjbPage.bl}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">倍率</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								初始读数:
							</label>
						</td>
						<td class="value">
						    <input id="csds" name="csds" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglFjbPage.csds}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">初始读数</label>
						</td>
					</tr>
					<tr>
<%-- 						<td align="right">
							<label class="Validform_label">
								有效标志:
							</label>
						</td>
						<td class="value">
						    <input id="yxbz" name="yxbz" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglFjbPage.yxbz}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">有效标志</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td> --%>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/wuyecbgl/wuyeCbglFjb.js"></script>		
<script>
$(document).ready(function(){
	$.ajax({
        type: 'POST',  
        dataType : "json",  
        url: 'wuyeCbglFjbController.do?getFjxx',
        data:'gtbid='+$("#gtbid").val()+'&yblx='+$("#yblx").val()+'&sfxmdm='+$("#sfxmdm").val(),
        success:function(data){ 	       	
        	$("#gtbid").val(data.attributes.ybbh)
        	$("#yblx").val(data.attributes.yblx)
        	$("#sfxmdm").val(data.attributes.xmmc)
        }
	})
})
</script>