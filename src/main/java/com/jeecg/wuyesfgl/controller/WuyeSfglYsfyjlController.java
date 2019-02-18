package com.jeecg.wuyesfgl.controller;
import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyesfgl.dao.WuyeSfglSfxmszDao;
import com.jeecg.wuyesfgl.dao.WuyeSfglYsfyjlDao;
import com.jeecg.wuyesfgl.entity.WuyeSfglDkxxzbEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglSfxmszPageEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjlEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjlPageEntity;
import com.jeecg.wuyesfgl.service.WuyeSfglYsfyjlServiceI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.GsonUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import org.jeecgframework.minidao.annotation.Param;

import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: 应收费用记录
 * @author onlineGenerator
 * @date 2018-03-28 09:34:49
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wuyeSfglYsfyjlController")
@Api(value="WuyeSfglYsfyjl",description="应收费用记录",tags="wuyeSfglYsfyjlController")
public class WuyeSfglYsfyjlController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WuyeSfglYsfyjlController.class);

	@Autowired
	private WuyeSfglYsfyjlServiceI wuyeSfglYsfyjlService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private WuyeSfglYsfyjlDao wuyeSfglYsfyjlDao; 
	//成员变量
	private String p_lyid;
	/**
	 * 应收费用记录列表 页面跳转-tree
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		//return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglYsfyjlList");
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglYsfyjlTree");
	}
	/**
	 * 接受发送过来的字符串post
	 * */
	@ResponseBody
	@RequestMapping(params = "dataOfPost")
	public String dataOfPost(String lyid, HttpServletRequest req) {
		//System.out.println(nodeId);
		this.p_lyid = lyid;
		return "success";
	}
	/**
	 * 应收费用记录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list_child")
	public ModelAndView list_child(HttpServletRequest request) {
		//System.out.println("楼宇id"+this.p_lyid);
		request.setAttribute("lyid",this.p_lyid);
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglYsfyjlList");
	}
	

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(String lyid,WuyeSfglYsfyjlPageEntity wuyeSfglYsfyjl,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		wuyeSfglYsfyjl.setLyid(lyid);
		HttpSession session = request.getSession();
		String dkxxzj = (String) session.getAttribute("dkxxid");
		wuyeSfglYsfyjl.setDkxxzj(dkxxzj);
		if("".equals(wuyeSfglYsfyjl.getShzt())){
			wuyeSfglYsfyjl.setShzt("0");
		}
		//查询数据
		List<WuyeSfglYsfyjlPageEntity> ysfyjl = wuyeSfglYsfyjlDao.findList(wuyeSfglYsfyjl); 
		//查询数量
		int count = wuyeSfglYsfyjlDao.findListCount(wuyeSfglYsfyjl); 

		dataGrid.setTotal(count);
		dataGrid.setResults(ysfyjl);
		TagUtil.datagrid(response, dataGrid);
	}

	
	/**
	 * 删除应收费用记录
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeSfglYsfyjlEntity wuyeSfglYsfyjl, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeSfglYsfyjl = systemService.getEntity(WuyeSfglYsfyjlEntity.class, wuyeSfglYsfyjl.getId());
		message = "应收费用记录删除成功";
		try{
			wuyeSfglYsfyjlService.delete(wuyeSfglYsfyjl);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "应收费用记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除应收费用记录
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "应收费用记录删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeSfglYsfyjlEntity wuyeSfglYsfyjl = systemService.getEntity(WuyeSfglYsfyjlEntity.class,id);
				wuyeSfglYsfyjlService.delete(wuyeSfglYsfyjl);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "应收费用记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	 /**
	  * 审核
	  * 
	  * @return
	 * @throws ParseException 
	  */
	 @RequestMapping(params = "doShenhe")
	 @ResponseBody
	 public AjaxJson doShenhe(String ids,HttpServletRequest request) throws ParseException{
		// System.out.println("审核id："+ ids);
		 String message = null;
		 //查找登陆用户
		 TSUser user = (TSUser)ResourceUtil.getSessionUser();
		 String shry = user.getUserName();
		 //获取当前时间
		 Date day=new Date();    
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		 Date shsj = sdf.parse(sdf.format(day));
		 AjaxJson j = new AjaxJson();
		 message = "审核完成";
		 try{
			 for(String id:ids.split(",")){
				 WuyeSfglYsfyjlEntity wuyeSfglYsfyjl = systemService.getEntity(WuyeSfglYsfyjlEntity.class,id);
				 if("1".equals(wuyeSfglYsfyjl.getShzt())){
					 break;
				 }
				 wuyeSfglYsfyjl.setShzt("1");
				 wuyeSfglYsfyjl.setShry(shry);
				 wuyeSfglYsfyjl.setShsj(shsj);
				 wuyeSfglYsfyjlService.saveOrUpdate(wuyeSfglYsfyjl);		
				 systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			 }
		 }catch(Exception e){
			 e.printStackTrace();
			 message = "审核失败";
			 throw new BusinessException(e.getMessage());
		 }
		 j.setMsg(message);
		 return j;
	 }


	/**
	 * 添加应收费用记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeSfglYsfyjlEntity wuyeSfglYsfyjl, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "应收费用记录添加成功";
		try{
			wuyeSfglYsfyjlService.save(wuyeSfglYsfyjl);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "应收费用记录添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新应收费用记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WuyeSfglYsfyjlEntity wuyeSfglYsfyjl, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "应收费用记录更新成功";
		WuyeSfglYsfyjlEntity t = wuyeSfglYsfyjlService.get(WuyeSfglYsfyjlEntity.class, wuyeSfglYsfyjl.getId());
		if(t.getShzt().equals("1")){
			message = "该项目已经审批过，不能再次修改！";
		}else{
			try {
				MyBeanUtils.copyBeanNotNull2Bean(wuyeSfglYsfyjl, t);
				wuyeSfglYsfyjlService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "应收费用记录更新失败";
				throw new BusinessException(e.getMessage());
			}
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 应收费用记录新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WuyeSfglYsfyjlEntity wuyeSfglYsfyjl, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeSfglYsfyjl.getId())) {
			wuyeSfglYsfyjl = wuyeSfglYsfyjlService.getEntity(WuyeSfglYsfyjlEntity.class, wuyeSfglYsfyjl.getId());
			req.setAttribute("wuyeSfglYsfyjlPage", wuyeSfglYsfyjl);
		}
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglYsfyjl-add");
	}
	/**
	 * 应收费用记录编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WuyeSfglYsfyjlEntity wuyeSfglYsfyjl, HttpServletRequest req) {
		String str = "'";
		if (StringUtil.isNotEmpty(wuyeSfglYsfyjl.getId())) {
			wuyeSfglYsfyjl = wuyeSfglYsfyjlService.getEntity(WuyeSfglYsfyjlEntity.class, wuyeSfglYsfyjl.getId());
			//通过房间id查询房间编号
			List<WuyeFwxxEntity> fwxx = systemService.findByQueryString("from WuyeFwxxEntity w where w.fjid = "+ wuyeSfglYsfyjl.getFjid());
			String fjbh = fwxx.get(0).getFjbh();
			//通过管理区id查询管理区名称
			List<WuyeGlqEntity> glq = systemService.findByQueryString("from WuyeGlqEntity w where w.id = "+ str + wuyeSfglYsfyjl.getGlqid() + str);
			String glqmc = glq.get(0).getGlqmc();
			
			req.setAttribute("fjbh", fjbh);
			req.setAttribute("glqmc", glqmc);
			req.setAttribute("wuyeSfglYsfyjlPage", wuyeSfglYsfyjl);
		}
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglYsfyjl-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeSfglYsfyjlController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WuyeSfglYsfyjlEntity wuyeSfglYsfyjl,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WuyeSfglYsfyjlEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeSfglYsfyjl, request.getParameterMap());
		List<WuyeSfglYsfyjlEntity> wuyeSfglYsfyjls = this.wuyeSfglYsfyjlService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"应收费用记录");
		modelMap.put(NormalExcelConstants.CLASS,WuyeSfglYsfyjlEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("应收费用记录列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wuyeSfglYsfyjls);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WuyeSfglYsfyjlEntity wuyeSfglYsfyjl,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"应收费用记录");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeSfglYsfyjlEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("应收费用记录列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<WuyeSfglYsfyjlEntity> listWuyeSfglYsfyjlEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeSfglYsfyjlEntity.class,params);
				for (WuyeSfglYsfyjlEntity wuyeSfglYsfyjl : listWuyeSfglYsfyjlEntitys) {
					wuyeSfglYsfyjlService.save(wuyeSfglYsfyjl);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="应收费用记录列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WuyeSfglYsfyjlEntity>> list() {
		List<WuyeSfglYsfyjlEntity> listWuyeSfglYsfyjls=wuyeSfglYsfyjlService.getList(WuyeSfglYsfyjlEntity.class);
		return Result.success(listWuyeSfglYsfyjls);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取应收费用记录信息",notes="根据ID获取应收费用记录信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WuyeSfglYsfyjlEntity task = wuyeSfglYsfyjlService.get(WuyeSfglYsfyjlEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取应收费用记录信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建应收费用记录")
	public ResponseMessage<?> create(@ApiParam(name="应收费用记录对象")@RequestBody WuyeSfglYsfyjlEntity wuyeSfglYsfyjl, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeSfglYsfyjlEntity>> failures = validator.validate(wuyeSfglYsfyjl);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeSfglYsfyjlService.save(wuyeSfglYsfyjl);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("应收费用记录信息保存失败");
		}
		return Result.success(wuyeSfglYsfyjl);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新应收费用记录",notes="更新应收费用记录")
	public ResponseMessage<?> update(@ApiParam(name="应收费用记录对象")@RequestBody WuyeSfglYsfyjlEntity wuyeSfglYsfyjl) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeSfglYsfyjlEntity>> failures = validator.validate(wuyeSfglYsfyjl);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeSfglYsfyjlService.saveOrUpdate(wuyeSfglYsfyjl);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新应收费用记录信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新应收费用记录信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除应收费用记录")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wuyeSfglYsfyjlService.deleteEntityById(WuyeSfglYsfyjlEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("应收费用记录删除失败");
		}

		return Result.success();
	}
}
