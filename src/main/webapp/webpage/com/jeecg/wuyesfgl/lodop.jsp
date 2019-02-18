<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<html>
<head>
<style>
 /* body,table,table tr th, table tr td { border:1px solid #0094ff; } */
.btn{   
	cursor:pointer;
	border: 1px solid #999;
    border-radius: 3px;
    color: #333;
    cursor: pointer;
    display: inline-block;
    height: 30px;
    letter-spacing: 3px;
    margin-left: 6px;
    overflow: visible;
    padding: 3px 10px 3px 12px;
    text-align: center;
    transition: box-shadow 0.2s linear 0s;
}
</style>
</head>
<body  style="width:225mm;height: 130mm;margin: 0px;padding: 0px;">
<script type="text/javascript"  src="webpage/com/jeecg/wuyesfgl/LodopFuncs.js"></script>
<object  id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
       <embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
</object>
<script  type="text/javascript">
  var LODOP;
  function CreatePrintPage() {
     LODOP=getLodop();  
	 LODOP.PRINT_INIT();
	 LODOP.ADD_PRINT_HTM(0,0,1200,600,document.getElementById("dyform").innerHTML);
  };  
  url="wuyeSfglFysqglController.do?sftable";
  $.post(url,function(result){
	  if(result.length>0){
		  for(var i in result){
			  $("#sftable").append('<tr valign="top" style="height: 25px"><td>'+result[i].sfxmmc+'</td><td>'+result[i].jg+'</td><td>'+result[i].sl+'</td><td>'+result[i].ssje+'</td></tr>');
			  $("#sfxmtable").append('<tr valign="top"  style="height: 25px"><td>'+result[i].sfxmmc+'</td><td>'+result[i].jg+'</td><td>'+result[i].sl+'</td><td>'+result[i].ssje+'</td></tr>');
		  }	 
	  }
     },"json");
</script> 

<div  style="width:225mm;height: 140mm;margin: 0px;padding: 0px;">
<form id="dyform"  style="margin: 0px;padding: 0px;">
	<table id="dytable"  style="width:225mm;height: 120mm;margin: 0px;padding: 0px;">
			<tr style="height:30px;text-align: center"valign="top">
				<td  colspan="2"  style="width: 75mm;">${jyh}</td>
				<td  colspan="3"  style="width: 150mm;"></td>
			</tr>
		<tr style="height:25px;">
				<td ><pre>${date}</pre></td>
				<td >${sjh}</td>
				<td  colspan="2"><pre>[${jyh}]&nbsp;&nbsp;${date}</pre></td>
				<td >${sjh}</td>
			</tr>
			<tr style="height:25px">
				<td style="padding-left: 40px;"  colspan="2" >${address}</td>
				<td style="padding-left: 65px;"  colspan="3">${name}</td>
			</tr>
			<tr style="height:25px">
				<td  style="padding-left: 40px"  colspan="2">${money}</td>
				<td  style="padding-left: 90px"  colspan="2">${capitalMoney}</td>
			    <td  style="padding-left: 150px">${money}</td>
			</tr>
			<tr style="height:238px" valign="top">
				<td class="td1"  colspan="2"  valign="top">
					<table id="sftable" style="width:70mm;">
						<tr style="height: 20px">
							<td colspan="4">您${jfny}的费用明细为:</td>
						</tr>
						<tr style="height: 20px">
							<td>项目</td>
							<td>单价</td>
							<td>用量</td>
							<td>金额</td>
						</tr>
					</table>
				</td>
				<td class="td2"  colspan="3" style="padding-left:10px;width: 445px;">
					<table id="sfxmtable" style="width:140mm;">
						<tr style="height: 20px">
							<td colspan="4">您${jfny}的费用明细为:</td>
						</tr>
						<tr style="height: 20px">
							<td>项目</td>
							<td>单价</td>
							<td>用量</td>
							<td>金额</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr style="height: 25px">
				<td class="td3" style="padding-left: 55px;">${operator}</td>
				<td class="td3" style="padding-left: 50px;">${chargePeople}</td>
				<td class="td4" style="padding-left: 55px;width: 45mm;">${operator}</td>
				<td class="td4" >${chargePeople}</td>
				<td class="td4"  style="padding-left: 110px;">${DateTwo}</td>
			</tr>
			<tr style="height: 20px"valign="top">
				<td class="td1" style="padding-left: 70px"  colspan="2">${DateTwo}</td>
			</tr>
			<tr>
				<td colspan="5"></td>
			</tr>
	</table>
	</form>	
<div>
	<input  class="btn"   type="button"   style="float: right;"  value="打印"   onclick="CreatePrintPage();LODOP.PRINT();"/>&nbsp;&nbsp;
	<input  class="btn"  type="button"   style="float: right;" value="打印预览"  onclick="CreatePrintPage();LODOP.PREVIEW();"/>
</div>
</div>
</body>
</html>