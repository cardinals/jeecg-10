<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.jeecgframework.core.util.SysThemesUtil,org.jeecgframework.core.enums.SysThemesEnum"%>
<%@include file="/context/mytags.jsp"%>
<%
  session.setAttribute("lang","zh-cn");
  SysThemesEnum sysTheme = SysThemesUtil.getSysTheme(request);
  String lhgdialogTheme = SysThemesUtil.getLhgdialogTheme(sysTheme);
%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta charset="utf-8" />
  <title>山铝物业管理系统</title>
   <link rel="shortcut icon" href="images/favicon.ico">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

  <link rel="stylesheet" href="plug-in/login/css/ldlogon.css" />
  <style type="text/css">
	
	#versionBar {
		background-color: #212121;
		position: fixed;
		width: 100%;
		height: 35px;
		bottom: 0;
		left: 0;
		text-align: center;
		line-height: 35px;
		z-index: 11;
		-webkit-box-shadow: black 0px 10px 10px -10px inset;
		-moz-box-shadow: black 0px 10px 10px -10px inset;
		box-shadow: black 0px 10px 10px -10px inset;
	}
	
	.copyright {
		text-align: center;
		font-size: 10px;
		color: #CCC;
	}
	
	.copyright a {
		color: #A31F1A;
		text-decoration: none
	}
	</style>
</head>
<body style="overflow:-Scroll;overflow-y:hidden">

<div id="loginbox">
<form id="loinForm" class="form-vertical" method="post" >
<input type="hidden" id="ReturnURL"  name="ReturnURL" value="${ReturnURL }"/>
    <div>
        <div class="logo-title">
            <img src="plug-in/login/img/logo.png" alt="logon" /><p><span>山铝物业管理系统</span></p>
        </div>
    </div>
    <div class="logon-box">
        <div class="logo-caption">
            <img src="plug-in/login/img/logo-caption.png" alt="logon" />
        </div>
        <div class="control-box">
            <div class="controls">
                <input type="text" iscookie="true" name="userName" id="userName" placeholder="工号" />
            </div>
            <div class="controls">
                <input type="password" name="password" id="password" placeholder="密码" />
            </div>
            <div class="actions">  
			    <label style="float:left;width:120px;padding:0px;margin-left:-10px;">
                          <input type="checkbox" id="on_off"  name="remember" value="yes" style="padding:0px;margin:0;"/>
                          <span class="lbl">记住用户名</span>
                        </label>
                <input style="float:right;" id="but_login" type="button" class="btn" value="登 录" onclick="checkUser()"/>
            </div>
            <div class="actions" style="clear:both; padding-top:10px;">
			<div class="alert alert-warning alert-dismissible" role="alert" id="errMsgContiner">
				  <div id="showErrMsg"></div>
				</div>
			  <div class="toolbar clearfix" style="display:none">
                  <div style="float: right">
                    <a href="#"  class="forgot-password-link">
                    	  语言
                      <i class="ace-icon fa fa-arrow-right"></i>
                      <t:dictSelect id="langCode" field="langCode" typeGroupCode="lang" hasLabel="false" extendJson="{style:'padding:2px; width:80px;'}" defaultVal="zh-cn"></t:dictSelect>
                    </a>
                  </div>
                </div>
            </div>
        </div>
    </div>
</form>
    </div>


<script type="text/javascript" src="plug-in/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="plug-in/jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="plug-in/mutiLang/en.js"></script>
<script type="text/javascript" src="plug-in/mutiLang/zh-cn.js"></script>
<script type="text/javascript" src="plug-in/login/js/jquery.tipsy.js"></script>
<script type="text/javascript" src="plug-in/login/js/iphone.check.js"></script>
<script type="text/javascript" src="plug-in/login/js/login.js"></script>
<script type="text/javascript">
	$(function(){
		optErrMsg();
	});
	$("#errMsgContiner").hide();
	function optErrMsg(){
		$("#showErrMsg").html('');
		$("#errMsgContiner").hide();
	}

   //输入验证码，回车登录
  $(document).keydown(function(e){
  	if(e.keyCode == 13) {

      setTimeout("$('#but_login').click()","100");

  	}
  });

  //验证用户信息
  function checkUser(){
    if(!validForm()){
      return false;
    }
    newLogin();
  }
  //表单验证
  function validForm(){
    if($.trim($("#userName").val()).length==0){
      showErrorMsg("请输入用户名");
      return false;
    }

    if($.trim($("#password").val()).length==0){
      showErrorMsg("请输入密码");
      return false;
    }

    /*if($.trim($("#randCode").val()).length==0){
      showErrorMsg("请输入验证码");
      return false;
    }*/
    return true;
  }

  //登录处理函数
  function newLogin(orgId) {
    setCookie();

    var actionurl="loginController.do?login";//提交路径
    var checkurl="loginController.do?checkuser";//验证路径

    var formData = new Object();
    var data=$(":input").each(function() {
      formData[this.name] =$("#"+this.name ).val();
    });
    formData['orgId'] = orgId ? orgId : "";
    //语言
    formData['langCode']=$("#langCode").val();
    formData['langCode'] = $("#langCode option:selected").val();
    $.ajax({
      async : false,
      cache : false,
      type : 'POST',
      url : checkurl,// 请求的action路径
      data : formData,
      error : function() {// 请求失败处理函数
      },
      success : function(data) {
        var d = $.parseJSON(data);
        if (d.success) {
          if (d.attributes.orgNum > 1) {
          	  //用户拥有多个部门，需选择部门进行登录
        	  var title, okButton;
              if($("#langCode").val() == 'en') {
                title = "Please select Org";
                okButton = "Ok";
              } else {
                title = "请选择组织机构";
                okButton = "确定";
              }
            $.dialog({
              id: 'LHG1976D',
              title: title,
              max: false,
              min: false,
              drag: false,
              resize: false,
              content: 'url:userController.do?userOrgSelect&userId=' + d.attributes.user.id,
              lock:true,
              button : [ {
                name : okButton,
                focus : true,
                callback : function() {
                  iframe = this.iframe.contentWindow;
                  var orgId = $('#orgId', iframe.document).val();

                  formData['orgId'] = orgId ? orgId : "";
                  $.ajax({
              		async : false,
              		cache : false,
              		type : 'POST',
              		url : 'loginController.do?changeDefaultOrg',// 请求的action路径
              		data : formData,
              		error : function() {// 请求失败处理函数
              		},
              		success : function(data) {
              			window.location.href = actionurl;
              		}
                  });

                  this.close();
                  return false;
                }
              }],
              close: function(){
                setTimeout("window.location.href='"+actionurl+"'", 10);
              }
            });
          } else {
            window.location.href = actionurl;
          }
       } else {
			showErrorMsg(d.msg);

		  	if(d.msg === "用户名或密码错误" || d.msg === "验证码错误")
		  		reloadRandCodeImage();

        }
      }
    });
  }
  //登录提示消息显示
  function showErrorMsg(msg){	
    $("#errMsgContiner").show();
    $("#showErrMsg").html(msg);    
    window.setTimeout(optErrMsg,3000); 
  }
  /**
   * 刷新验证码
   */
$('#randCodeImage').click(function(){
    reloadRandCodeImage();
});
function reloadRandCodeImage() {
    var date = new Date();
    var img = document.getElementById("randCodeImage");
    img.src='randCodeImage?a=' + date.getTime();
}

  function darkStyle(){
    $('body').attr('class', 'login-layout');
    $('#id-text2').attr('class', 'red');
    $('#id-company-text').attr('class', 'blue');
    e.preventDefault();
  }
  function lightStyle(){
    $('body').attr('class', 'login-layout light-login');
    $('#id-text2').attr('class', 'grey');
    $('#id-company-text').attr('class', 'blue');

    e.preventDefault();
  }
  function blurStyle(){
    $('body').attr('class', 'login-layout blur-login');
    $('#id-text2').attr('class', 'white');
    $('#id-company-text').attr('class', 'light-blue');

    e.preventDefault();
  }
//设置cookie
  function setCookie()
  {

  	if ($('#on_off').attr("checked")) {

  		$("input[iscookie='true']").each(function() {
  			$.cookie(this.name, $("#"+this.name).val(), "/",24);
  			$.cookie("COOKIE_NAME","true", "/",24);
  		});
  	} else {
  		$("input[iscookie='true']").each(function() {
  			$.cookie(this.name,null);
  			$.cookie("COOKIE_NAME",null);
  		});
  	}
  }
  //读取cookie
  function getCookie()
  {
  	var COOKIE_NAME=$.cookie("COOKIE_NAME");
  	if (COOKIE_NAME !=null) {
  		$("input[iscookie='true']").each(function() {
  			$($("#"+this.name).val( $.cookie(this.name)));
              if("admin" == $.cookie(this.name)) {
                  $("#randCode").focus();
              } else {
                  $("#password").val("");
                  $("#password").focus();
              }
          });
  		$("#on_off").attr("checked", true);
  		$("#on_off").val("1");
  	} 
  	else
  	{
  		$("#on_off").attr("checked", false);
  		$("#on_off").val("0");
        $("#randCode").focus();
  	}
  }
</script>
<%=lhgdialogTheme %>
<div class="clear"></div>
    <div id="versionBar">
        <div class="copyright">&copy; 山铝物业 版权所有  <t:mutiLang langKey="common.browser.recommend"/>技术部</div>
    </div>
</body>
</html>