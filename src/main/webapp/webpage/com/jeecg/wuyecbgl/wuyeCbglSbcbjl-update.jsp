<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>水表抄表记录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>

 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wuyeCbglSbcbjlController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${wuyeCbglSbcbjlPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								计费起始日期:
							</label>
						</td>
						<td class="value">
									  <input id="jfqsrq" name="jfqsrq" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${wuyeCbglSbcbjlPage.jfqsrq}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">计费起始日期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								计费结束日期:
							</label>
						</td>
						<td class="value">
									  <input id="jfjsrq" name="jfjsrq" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${wuyeCbglSbcbjlPage.jfjsrq}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">计费结束日期</label>
						</td>
					</tr>		
					<tr>
						<td align="right">
						<label class="Validform_label">
								房间ID:
							</label>
						</td>
						<td class="value">
						   <%--  <input id="fjid" name="fjid" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${wuyeCbglSbcbjlPage.fjid}'/> --%>
							<input id="fjid" name="fjid" type="text" class="inputxt" ignore="ignore" value='${wuyeCbglSbcbjlPage.fjid}' readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房间id</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								仪表属性:
							</label>
						</td>
						<td class="value">
									<input id="ybsx" name="ybsx" type="text" class="inputxt" typeGroupCode="ybsx" value='${wuyeCbglSbcbjlPage.ybsx}' readonly="readonly"/>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">仪表属性</label>
						</td>						

					</tr>
					<tr>						
						<td align="right">
							<label class="Validform_label">
								姓名:
							</label>
						</td>
						<td class="value">
						    <input id="xm" name="xm" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglSbcbjlPage.xm}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">姓名</label>
						</td>				
						<td align="right">
							<label class="Validform_label">
								房间地址:
							</label>
						</td>
						<td class="value">
						    <input id="fjdz" name="fjdz" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglSbcbjlPage.fjdz}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房间地址</label>
						</td>
					</tr>
					<tr style="display: none;">
						<td align="right">
							<label class="Validform_label">
								管理区id:
							</label>
						</td>
						<td class="value">
						    <input id="glqid" name="glqid" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglSbcbjlPage.glqid}' readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">管理区id</label>
						</td>							
						<td align="right">
							<label class="Validform_label">
								房屋主键:
							</label>
						</td>
						<td class="value">
						    <input id="fwxxid" name="fwxxid" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglSbcbjlPage.fwxxid}' readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房屋主键</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								仪表编号:
							</label>
						</td>
						<td class="value">
						   <input id="ybbh" name="ybbh" type="text" style="width: 150px" class="inputxt" ignore="ignore"  value='${wuyeCbglSbcbjlPage.ybbh}' readonly="readonly"/>
<%-- 						   	<select id="ybbh" name="ybbh" >		
						   		<option>${wuyeCbglSbcbjlPage.ybbh}</option>						
							</select> --%>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">仪表编号</label>
						</td>					
						<td align="right">
							<label class="Validform_label">
								仪表ID:
							</label>
						</td>
						<td class="value">
						  <input id="ybid" name="ybid" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglSbcbjlPage.ybid}' readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">仪表ID</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								上月指数:
							</label>
						</td>
						<td class="value">
						    <input id="syzs" name="syzs" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglSbcbjlPage.syzs}' readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">上月指数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								本月指数:
							</label>
						</td>
						<td class="value">
						    <input id="byzs" name="byzs" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeCbglSbcbjlPage.byzs}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本月指数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								倍率:
							</label>
						</td>
						<td class="value">
						    <input id="bl" name="bl" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglSbcbjlPage.bl}' readonly="readonly" readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">倍率</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								本月流量:
							</label>
						</td>
						<td class="value">
						    <input id="byyl" name="byyl" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglSbcbjlPage.byyl}' readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本月流量</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								换表用量:
							</label>
						</td>
						<td class="value">
						    <input id="hbyl" name="hbyl" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeCbglSbcbjlPage.hbyl}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">换表用量</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								公摊量:
							</label>
						</td>
						<td class="value">
						    <input id="gtl" name="gtl" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${wuyeCbglSbcbjlPage.gtl}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公摊量</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								实际用量:
							</label>
						</td>
						<td class="value">
						    <input id="sjyl" name="sjyl" type="text" style="width: 150px" class="inputxt" ignore="ignore"  value='${wuyeCbglSbcbjlPage.sjyl}' readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">实际用量</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								抄表人:
							</label>
						</td>
						<td class="value">
						    <input id="cbr" name="cbr" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglSbcbjlPage.cbr}' readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">抄表人</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								抄表时间:
							</label>
						</td>
						<td class="value">
									  <input id="cbsj" name="cbsj" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${wuyeCbglSbcbjlPage.cbsj}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">抄表时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						    <input id="bz" name="bz" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wuyeCbglSbcbjlPage.bz}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/wuyecbgl/wuyeCbglSbcbjl.js"></script>		
  <script type="text/javascript">
  //编写自定义JS代码
     $(document).ready(function(){
		
 		$("#byzs").change(function(){
			$("#byyl").val("");
			if($("#byzs").val() < $("#syzs").val()){
				alert("请填写正确的指数！")
				$("#byyl").val("");
				return false;
			}
			  $("#byyl").val((($("#byzs").val()-$("#syzs").val())*$("#bl").val()).toFixed(2));
			  
		});
		
		$("#sjyl").click(function(){
			$("#sjyl").val("");
			if($("#byyl").val() == ''){
				$("#sjyl").val("");
				return false;
			}
			var d1 = parseFloat($("#byyl").val());
			var d2 = parseFloat($("#hbyl").val());
			var d3 = parseFloat($("#gtl").val());
			$("#sjyl").val((d1+d2+d3).toFixed(2));
		})   	

		
	});
  </script>