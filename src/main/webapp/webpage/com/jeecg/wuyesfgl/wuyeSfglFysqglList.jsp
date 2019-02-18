<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<style>
.wuye.sfgl.td{
	padding-left:35px; 
	height:28px;
}
</style>
<obejct id="LODOP" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA"></obejct>
<div class="easyui-layout" id="" fit="true"  >	
 <div  region="north"   style="padding:0px;border:0px;height:100px;" >
     <form  id="wyfrom" class="wuye sfgl" >
  		<table class="wuye sfgl" >
  			<tr class="wuye sfgl tr" >
  				<td  id="fjbh" class="wuye sfgl td " >房间编号 : </td>
  				<td  id="jzmj" class="wuye sfgl td ">建筑面积 : </td>
  				<td  id="yzmc" class="wuye sfgl td ">业主名称 : </td>
  				<td  id="yzsj" class="wuye sfgl td ">联系电话 : </td>
  			</tr>
  			<tr class="wuye sfgl tr" >
  				<td class="wuye sfgl td ">应收费用：<input  name="ysfy"  id="ysfy"   /></td>
  				<td class="wuye sfgl td ">实收费用：<input  type="text"  name="sffy"   id="sffy" /> </td>
  				<td class="wuye sfgl td ">找零：<input  name="zl"   id="zl"   /></td>
  				<td class="wuye sfgl td ">交费日期：<input  name="jfrq"   id="jfrq"  /></td>
  			</tr>
   			<tr class="wuye sfgl tr" >
  				<td class="wuye sfgl td ">收据号：<input  name="sjh"  id="sjh"  type="text" /></td>
  			</tr>
  		</table>
  		<div id="wuyeSfglYsfyjlListtb" style="padding: 3px; height: 25px">
		  	 <div style="float: left;">
				   <a href="#" id="sf"  class="easyui-linkbutton" plain="true"  icon="icon-money"  onclick="charge();">收费</a>
			  </div>
	  		  <div align="right" class="searchColums">
	  			  交费年月：<select  id="jfny"  name="jfny"><option>--请选择--</option></select>
	  			  收费对象：<t:dictSelect id="sfdx"   field="sfdx"   type="list"  dictTable="wuye_sfgl_ysfyjl"   dictField="yzmc"  dictText="yzmc"  dictCondition=" where  fjid='${fjid}' AND shzt='1' AND sfzt='0'  group by  yzmc"  extendJson="{class:'form-control'}" ></t:dictSelect>
	  			  费用类型：<t:dictSelect id="fylx" field="fylx"   type="select"  extendJson="{class:'form-control'}"   typeGroupCode="fylx"  defaultVal="2"></t:dictSelect>
	  			  交费方式：<t:dictSelect id="jffs" field="jffs"   type="select"   extendJson="{class:'form-control'}"     typeGroupCode="skfs"    defaultVal="0"></t:dictSelect>
	  			  开票方式：<t:dictSelect id="kpfs" field="kpfs"   type="select"  extendJson="{class:'form-control'}"   typeGroupCode="kpfs"  defaultVal="0"></t:dictSelect>
	  			 <!-- <a hidden="hidden" id="wuyequery"  href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="wuyeSfglYsfyjlListsearch();">查询</a> -->
				 <a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="searchReset('wuyeSfglYsfyjlList')">重置</a>
	  		 </div>
  	  </div>
  	</form>
  </div>
  <div  region="center"   style="padding:0px;border:0px;"  >
  <t:datagrid  name="wuyeSfglYsfyjlList"  checkbox="true" pagination="false"  fitColumns="false" title="" actionUrl="wuyeSfglFysqglController.do?datagrid&" idField="id" fit="true" queryMode="group" >
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol> 
   <t:dgCol title="业主姓名"  field="yzmc"  queryMode="single"  width="120" ></t:dgCol>
   <t:dgCol title="收费状态"  field="sfzt"  queryMode="single" dictionary="sfzt" width="120" ></t:dgCol> 
   <t:dgCol title="计费起始时间"  field="jfqssj"  queryMode="single"  width="120"  formatter="yyyy-MM-dd" ></t:dgCol>
   <t:dgCol title="计费终止时间"  field="jfjzsj"  queryMode="single"  width="120" formatter="yyyy-MM-dd" ></t:dgCol>
   <t:dgCol title="数量"  field="sl"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="价格"  field="jg"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="应收金额"  field="ysje"  queryMode="single"  width="120"  ></t:dgCol>
   <t:dgCol title="起数"  field="qss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="止数"  field="jzs"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="倍率"  field="bl"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="公摊"  field="gts"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费年度"  field="jfnd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费月份"  field="jfyf"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费起始日期"  field="sfqsrq"  queryMode="single"  width="120" formatter="yyyy-MM-dd" ></t:dgCol>
   <t:dgCol title="收费截止日期"  field="sfjzrq"  queryMode="single"  width="120"  formatter="yyyy-MM-dd" ></t:dgCol>
   <t:dgCol title="滞纳金起始日期"  field="znjqsrq"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="bz"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核状态"  field="shzt"  queryMode="single" dictionary="shzt" width="120" ></t:dgCol>
   <t:dgCol title="审核时间"  field="shsj"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核人员"  field="shry"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wuyeSfglYsfyjlController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/> 
  </t:datagrid>
    
  </div>
 </div>
 <script src = "webpage/com/jeecg/wuyesfgl/wuyeSfglFysqglList.js"></script>		
 <script type="text/javascript">
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wuyeSfglYsfyjlController.do?upload', "wuyeSfglYsfyjlList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wuyeSfglYsfyjlController.do?exportXls","wuyeSfglYsfyjlList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wuyeSfglYsfyjlController.do?exportXlsByT","wuyeSfglYsfyjlList");
}

 </script>