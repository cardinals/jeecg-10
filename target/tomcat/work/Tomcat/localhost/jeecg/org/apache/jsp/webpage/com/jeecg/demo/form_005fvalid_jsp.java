/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-03-30 02:36:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.webpage.com.jeecg.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class form_005fvalid_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/tld/easyui.tld", Long.valueOf(1521446129221L));
    _jspx_dependants.put("/context/mytags.jsp", Long.valueOf(1521446129245L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ft_005fformvalid_0026_005flayout_005fformid_005fdialog_005fcallback_005fbeforeSubmit_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ft_005fhasPermission_0026_005fcode;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ft_005fauthFilter_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ft_005fformvalid_0026_005flayout_005fformid_005fdialog_005fcallback_005fbeforeSubmit_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ft_005fhasPermission_0026_005fcode = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ft_005fauthFilter_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody.release();
    _005fjspx_005ftagPool_005ft_005fformvalid_0026_005flayout_005fformid_005fdialog_005fcallback_005fbeforeSubmit_005faction.release();
    _005fjspx_005ftagPool_005ft_005fhasPermission_0026_005fcode.release();
    _005fjspx_005ftagPool_005ft_005fauthFilter_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

      out.write('\n');
      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /context/mytags.jsp(9,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("webRoot");
      // /context/mytags.jsp(9,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(basePath);
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>uitags</title>\n");
      if (_jspx_meth_t_005fbase_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("<SCRIPT type=\"text/javascript\">\n");
      out.write("        function parse(data){\n");
      out.write("            \tvar parsed = [];\n");
      out.write("\t\t        \t$.each(data.rows,function(index,row){\n");
      out.write("\t\t        \t\tparsed.push({data:row,result:row,value:row.id});\n");
      out.write("\t\t        \t});\n");
      out.write("        \t\t\t\treturn parsed;\n");
      out.write("        }\n");
      out.write("        /**\n");
      out.write("         * 选择后回调 \n");
      out.write("         * \n");
      out.write("         * @param {Object} data\n");
      out.write("         */\n");
      out.write("        function callBack(data) {\n");
      out.write("        \t$(\"#user\").val(data.userName);\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("         /**\n");
      out.write("          * 每一个选择项显示的信息\n");
      out.write("          * \n");
      out.write("          * @param {Object} data\n");
      out.write("          */\n");
      out.write("        function formatItem(data) {\n");
      out.write("        \treturn data.userName + \"-->\" + \" \" + data.realName;\n");
      out.write("        }\n");
      out.write("          \n");
      out.write("          function setContentc(){\n");
      out.write("        \t alert(\"表单提交前想干点啥呢\");\n");
      out.write("          }\n");
      out.write("          function test(){\n");
      out.write("        \t  alert(\"表单提交后要干点啥呢\");\n");
      out.write("          }\n");
      out.write("\n");
      out.write("  </SCRIPT>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      if (_jspx_meth_t_005fformvalid_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      if (_jspx_meth_t_005fauthFilter_005f0(_jspx_page_context))
        return;
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_t_005fbase_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  t:base
    org.jeecgframework.tag.core.easyui.BaseTag _jspx_th_t_005fbase_005f0 = (org.jeecgframework.tag.core.easyui.BaseTag) _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody.get(org.jeecgframework.tag.core.easyui.BaseTag.class);
    _jspx_th_t_005fbase_005f0.setPageContext(_jspx_page_context);
    _jspx_th_t_005fbase_005f0.setParent(null);
    // /webpage/com/jeecg/demo/form_valid.jsp(7,0) name = type type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fbase_005f0.setType("jquery,easyui,tools,autocomplete");
    int _jspx_eval_t_005fbase_005f0 = _jspx_th_t_005fbase_005f0.doStartTag();
    if (_jspx_th_t_005fbase_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody.reuse(_jspx_th_t_005fbase_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody.reuse(_jspx_th_t_005fbase_005f0);
    return false;
  }

  private boolean _jspx_meth_t_005fformvalid_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  t:formvalid
    org.jeecgframework.tag.core.easyui.FormValidationTag _jspx_th_t_005fformvalid_005f0 = (org.jeecgframework.tag.core.easyui.FormValidationTag) _005fjspx_005ftagPool_005ft_005fformvalid_0026_005flayout_005fformid_005fdialog_005fcallback_005fbeforeSubmit_005faction.get(org.jeecgframework.tag.core.easyui.FormValidationTag.class);
    _jspx_th_t_005fformvalid_005f0.setPageContext(_jspx_page_context);
    _jspx_th_t_005fformvalid_005f0.setParent(null);
    // /webpage/com/jeecg/demo/form_valid.jsp(44,0) name = formid type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fformvalid_005f0.setFormid("formobj");
    // /webpage/com/jeecg/demo/form_valid.jsp(44,0) name = dialog type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fformvalid_005f0.setDialog(false);
    // /webpage/com/jeecg/demo/form_valid.jsp(44,0) name = layout type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fformvalid_005f0.setLayout("div");
    // /webpage/com/jeecg/demo/form_valid.jsp(44,0) name = callback type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fformvalid_005f0.setCallback("test");
    // /webpage/com/jeecg/demo/form_valid.jsp(44,0) name = action type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fformvalid_005f0.setAction("jeecgFormvalidController.do?testsubmit=2");
    // /webpage/com/jeecg/demo/form_valid.jsp(44,0) name = beforeSubmit type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fformvalid_005f0.setBeforeSubmit("setContentc");
    int _jspx_eval_t_005fformvalid_005f0 = _jspx_th_t_005fformvalid_005f0.doStartTag();
    if (_jspx_eval_t_005fformvalid_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t <fieldset class=\"step\">\n");
        out.write("\t\t<div class=\"form\">\n");
        out.write("\t\t\t<label class=\"Validform_label\"> 非空验证： </label> \n");
        out.write("\t\t\t<input type=\"text\" name=\"demotitle\" id=\"demotitle\" datatype=\"*\" errormsg=\"该字段不为空\"> \n");
        out.write("\t\t\t<span class=\"Validform_checktip\"></span>\n");
        out.write("\t\t</div>\n");
        out.write("\t\t\n");
        out.write("\t\t<div class=\"form\">\n");
        out.write("\t\t\t<label class=\"Validform_label\"> URL验证： </label> \n");
        out.write("\t\t\t<input type=\"text\" name=\"demourl\" id=\"demourl\" datatype=\"url\" errormsg=\"必须是URL\"> \n");
        out.write("\t\t\t<span class=\"Validform_checktip\"></span>\n");
        out.write("\t\t</div>\n");
        out.write("\t\t\n");
        out.write("\t\t<div class=\"form\">\n");
        out.write("\t\t\t<label class=\"Validform_label\"> 至少选择2项： </label> \n");
        out.write("\t\t\t<input name=\"shoppingsite1\" class=\"rt2\" id=\"shoppingsite21\" type=\"checkbox\" value=\"1\" datatype=\"need2\" nullmsg=\"请选择您的爱好！\" />阅读 \n");
        out.write("\t\t\t<input name=\"shoppingsite1\" class=\"rt2\" id=\"shoppingsite22\" type=\"checkbox\" value=\"2\" /> 音乐\n");
        out.write("\t\t    <input name=\"shoppingsite1\" class=\"rt2\" id=\"shoppingsite23\" type=\"checkbox\" value=\"3\" /> 运动 \n");
        out.write("\t\t    <span class=\"Validform_checktip\"></span>\n");
        out.write("\t\t</div>\n");
        out.write("\t\t  \n");
        out.write("\t\t\n");
        out.write("\t\t<div class=\"form\" id=\"mail_id\">\n");
        out.write("\t\t\t<label class=\"Validform_label\"> 邮箱： </label> \n");
        out.write("\t\t\t<input type=\"text\" name=\"demoorder\" id=\"demoorder\" datatype=\"e\" errormsg=\"邮箱非法\">\n");
        out.write("\t\t    <span class=\"Validform_checktip\"></span>\n");
        out.write("\t    </div>\n");
        out.write("\t    \n");
        out.write("\t ");
        if (_jspx_meth_t_005fhasPermission_005f0(_jspx_th_t_005fformvalid_005f0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\t\t<div class=\"form\" id=\"money_id\">\n");
        out.write("\t\t\t<label class=\"Validform_label\"> 金额： </label> \n");
        out.write("\t\t\t<input type=\"text\" name=\"money\" id=\"money\" datatype=\"d\" errormsg=\"金额非法\"> \n");
        out.write("\t\t\t<span class=\"Validform_checktip\"></span>\n");
        out.write("\t\t</div>\n");
        out.write("\t\t\n");
        out.write("\t\t<div class=\"form\">\n");
        out.write("\t\t\t<label class=\"Validform_label\"> 日期： </label> \n");
        out.write("\t\t\t<input type=\"text\" name=\"date\" id=\"date\" class=\"easyui-datebox\"> \n");
        out.write("\t\t\t<span class=\"Validform_checktip\"></span>\n");
        out.write("\t\t</div>\n");
        out.write("\t\t\n");
        out.write("\t\t<div class=\"form\">\n");
        out.write("\t\t\t<label class=\"Validform_label\"> 时间： </label> \n");
        out.write("\t\t\t<input type=\"text\" name=\"time\" id=\"time\" class=\"easyui-datetimebox\"> \n");
        out.write("\t\t\t<span class=\"Validform_checktip\"></span>\n");
        out.write("\t\t</div> \n");
        out.write("\t\t<div style=\"text-align:center\"><input class=\"btn\" type=\"submit\" value=\"提交\" style=\"height:30px;width:100px !important;border-radius:5px\"></div>\n");
        out.write("\t\t\n");
        out.write("\t</fieldset>\n");
        int evalDoAfterBody = _jspx_th_t_005fformvalid_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_t_005fformvalid_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ft_005fformvalid_0026_005flayout_005fformid_005fdialog_005fcallback_005fbeforeSubmit_005faction.reuse(_jspx_th_t_005fformvalid_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ft_005fformvalid_0026_005flayout_005fformid_005fdialog_005fcallback_005fbeforeSubmit_005faction.reuse(_jspx_th_t_005fformvalid_005f0);
    return false;
  }

  private boolean _jspx_meth_t_005fhasPermission_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_t_005fformvalid_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  t:hasPermission
    org.jeecgframework.tag.core.easyui.HasPermissionTag _jspx_th_t_005fhasPermission_005f0 = (org.jeecgframework.tag.core.easyui.HasPermissionTag) _005fjspx_005ftagPool_005ft_005fhasPermission_0026_005fcode.get(org.jeecgframework.tag.core.easyui.HasPermissionTag.class);
    _jspx_th_t_005fhasPermission_005f0.setPageContext(_jspx_page_context);
    _jspx_th_t_005fhasPermission_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_t_005fformvalid_005f0);
    // /webpage/com/jeecg/demo/form_valid.jsp(73,2) name = code type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fhasPermission_005f0.setCode("phone_code");
    int _jspx_eval_t_005fhasPermission_005f0 = _jspx_th_t_005fhasPermission_005f0.doStartTag();
    if (_jspx_eval_t_005fhasPermission_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t<div class=\"form\">\n");
        out.write("\t\t\t<label class=\"Validform_label\"> 手机号： </label>\n");
        out.write("\t   \t\t<input type=\"text\" name=\"phone\" id=\"phone\" datatype=\"m\" errormsg=\"手机号非法\"> \n");
        out.write("\t   \t\t<span class=\"Validform_checktip\"></span>\n");
        out.write("\t   \t</div>\n");
        out.write("\t ");
        int evalDoAfterBody = _jspx_th_t_005fhasPermission_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_t_005fhasPermission_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ft_005fhasPermission_0026_005fcode.reuse(_jspx_th_t_005fhasPermission_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ft_005fhasPermission_0026_005fcode.reuse(_jspx_th_t_005fhasPermission_005f0);
    return false;
  }

  private boolean _jspx_meth_t_005fauthFilter_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  t:authFilter
    org.jeecgframework.tag.core.easyui.AuthFilterTag _jspx_th_t_005fauthFilter_005f0 = (org.jeecgframework.tag.core.easyui.AuthFilterTag) _005fjspx_005ftagPool_005ft_005fauthFilter_005fnobody.get(org.jeecgframework.tag.core.easyui.AuthFilterTag.class);
    _jspx_th_t_005fauthFilter_005f0.setPageContext(_jspx_page_context);
    _jspx_th_t_005fauthFilter_005f0.setParent(null);
    int _jspx_eval_t_005fauthFilter_005f0 = _jspx_th_t_005fauthFilter_005f0.doStartTag();
    if (_jspx_th_t_005fauthFilter_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ft_005fauthFilter_005fnobody.reuse(_jspx_th_t_005fauthFilter_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ft_005fauthFilter_005fnobody.reuse(_jspx_th_t_005fauthFilter_005f0);
    return false;
  }
}