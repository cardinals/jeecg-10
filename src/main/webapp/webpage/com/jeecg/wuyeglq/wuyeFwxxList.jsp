<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="wuyeFwxxList" checkbox="true" pagination="true" fitColumns="false" title="房屋基本信息" actionUrl="wuyeFwxxController.do?datagrid" idField="id" fit="true" queryMode="group"  sortName="fjbh">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="房间序号"  field="fjid"  queryMode="single"  width="120"  ></t:dgCol>
   <t:dgCol title="管理区id"  field="glqid"  queryMode="group"  width="120"  hidden="true" ></t:dgCol>
   <t:dgCol title="楼宇id"  field="glid"  queryMode="group"  width="120"  hidden="true" ></t:dgCol>
   <t:dgCol title="总楼层数"  field="zlcs"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="单元号"  field="dyh"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所在楼层"  field="lch"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="房间编号"  field="fjbh"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="楼型"  field="loux"  queryMode="group"  dictionary="lx"  width="120"></t:dgCol>
   <t:dgCol title="建筑面积"  field="jzmj"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="套内面积"  field="tnmj"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公摊面积"  field="gtmj"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="阳台面积"  field="ytmj"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="房屋户型"  field="fwhx"  query="true"  queryMode="single"  dictionary="fwhx"  width="120"></t:dgCol>
   <t:dgCol title="房屋类型"  field="fwlx"  queryMode="group"  dictionary="fwlx"  width="120"></t:dgCol>
   <t:dgCol title="住房类别"  field="zflb"  query="true"  queryMode="single"  dictionary="zflb"  width="120"></t:dgCol>
   <t:dgCol title="房屋用途"  field="fwyt"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="房屋朝向"  field="fwcx"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="房屋状态"  field="fwzt"  query="true"  queryMode="single"  dictionary="fwzt"  width="120"></t:dgCol>
   <t:dgCol title="竣工日期"  field="jgrq"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="交房日期"  field="jfrq"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="装修日期"  field="zxrq"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入住日期"  field="rzrq"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="产权人"  field="fwcqr"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="产权人类型"  field="cqrzjlx"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="产权人号码"  field="cqrzjhm"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否拆分出租"  field="cfczbz"  queryMode="group"  width="120"   dictionary="cfcz" ></t:dgCol>
   <t:dgCol title="收费服务对象"  field="sffwdx"  queryMode="group"  width="120"  dictionary="sfdx" ></t:dgCol>
   <t:dgCol title="排序号"  field="pxh"  queryMode="group"  width="120" hidden="true" ></t:dgCol>
   <t:dgCol title="有效标志"  field="yxbz"  queryMode="group"  width="120" hidden="true" ></t:dgCol>
   <t:dgCol title="证件类型"  field="zjmc"  queryMode="single"  dictionary="zjlx"  width="120"></t:dgCol>
   <t:dgCol title="证件号码"  field="zjhm"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="wuyeFwxxController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="wuyeFwxxController.do?goAdd" funname="add"  width="780"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="wuyeFwxxController.do?goUpdate" funname="update" width="780"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="wuyeFwxxController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="wuyeFwxxController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/wuyeglq/wuyeFwxxList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'wuyeFwxxController.do?upload', "wuyeFwxxList");
}

//导出
function ExportXls() {
	JeecgExcelExport("wuyeFwxxController.do?exportXls","wuyeFwxxList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("wuyeFwxxController.do?exportXlsByT","wuyeFwxxList");
}

 </script>