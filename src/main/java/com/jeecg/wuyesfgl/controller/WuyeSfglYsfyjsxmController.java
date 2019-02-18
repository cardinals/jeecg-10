package com.jeecg.wuyesfgl.controller;
import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyesfgl.dao.WuyeSfglYsfyjsxmDao;
import com.jeecg.wuyesfgl.entity.WuyeSfglFjsfxmszEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglSfxmszEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjlEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjsxmEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjszbEntity;
import com.jeecg.wuyesfgl.service.WuyeSfglYsfyjlServiceI;
import com.jeecg.wuyesfgl.service.WuyeSfglYsfyjsxmServiceI;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwyzxxEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.PropertiesUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.core.util.ResourceUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.Properties;

import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: 应收费用计算项目表
 * @author onlineGenerator
 * @date 2018-03-21 17:55:32
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wuyeSfglYsfyjsxmController")
@Api(value="WuyeSfglYsfyjsxm",description="应收费用计算项目表",tags="wuyeSfglYsfyjsxmController")
public class WuyeSfglYsfyjsxmController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WuyeSfglYsfyjsxmController.class);

	@Autowired
	private WuyeSfglYsfyjsxmServiceI wuyeSfglYsfyjsxmService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private WuyeSfglYsfyjsxmDao wuyeSfglYsfyjsxmDao;
	@Autowired
	private WuyeSfglYsfyjlServiceI wuyeSfglYsfyjlService;
	/** 收费主表id */
	private String id;
	/**
	 * 应收费用计算项目表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		this.id = request.getParameter("id");
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglYsfyjsxmList");
	}
	
	@RequestMapping(params = "listLoading")
	public ModelAndView listLoading(HttpServletRequest request) {
		this.id = request.getParameter("id");
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglSfjs");
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
	public void datagrid(WuyeSfglYsfyjsxmEntity wuyeSfglYsfyjsxm,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WuyeSfglYsfyjsxmEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeSfglYsfyjsxm, request.getParameterMap());
		try{
		//自定义追加查询条件
		List<WuyeSfglYsfyjszbEntity> ysfyjszbList = systemService.findByQueryString("from WuyeSfglYsfyjszbEntity where id='"+this.id+"'");		
		wuyeSfglYsfyjsxm.setGlqid(ysfyjszbList.get(0).getGlqid());
		wuyeSfglYsfyjsxm.setZbid(ysfyjszbList.get(0).getId());
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		//查询条件组装器
	    org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeSfglYsfyjsxm, request.getParameterMap());
		this.wuyeSfglYsfyjsxmService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	
	/**
	 * 删除应收费用计算项目表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeSfglYsfyjsxmEntity wuyeSfglYsfyjsxm, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeSfglYsfyjsxm = systemService.getEntity(WuyeSfglYsfyjsxmEntity.class, wuyeSfglYsfyjsxm.getId());
		message = "应收费用计算项目表删除成功";
		try{
			wuyeSfglYsfyjsxmService.delete(wuyeSfglYsfyjsxm);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "应收费用计算项目表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除应收费用计算项目表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "应收费用计算项目表删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeSfglYsfyjsxmEntity wuyeSfglYsfyjsxm = systemService.getEntity(WuyeSfglYsfyjsxmEntity.class, 
				id
				);
				wuyeSfglYsfyjsxmService.delete(wuyeSfglYsfyjsxm);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "应收费用计算项目表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加应收费用计算项目表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeSfglYsfyjsxmEntity wuyeSfglYsfyjsxm, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "应收费用计算项目表添加成功";
		try{
			wuyeSfglYsfyjsxmService.save(wuyeSfglYsfyjsxm);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "应收费用计算项目表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新应收费用计算项目表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WuyeSfglYsfyjsxmEntity wuyeSfglYsfyjsxm, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "应收费用计算项目表更新成功";
		WuyeSfglYsfyjsxmEntity t = wuyeSfglYsfyjsxmService.get(WuyeSfglYsfyjsxmEntity.class, wuyeSfglYsfyjsxm.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wuyeSfglYsfyjsxm, t);
			wuyeSfglYsfyjsxmService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "应收费用计算项目表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 应收费用计算项目表新增页面跳转
	 * @author GuoPeiZhi
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WuyeSfglYsfyjsxmEntity wuyeSfglYsfyjsxm, HttpServletRequest req) throws UnsupportedEncodingException {		
		 //判断属于哪个管区
		StringBuffer hql = new StringBuffer(" from WuyeSfglSfxmszEntity w where glqid=(SELECT glqid FROM WuyeSfglYsfyjszbEntity WHERE id='"+id+"')");	
		List<WuyeSfglSfxmszEntity> departList = this.systemService.findHql(hql.toString());
		if(departList.size()>0)
		req.setAttribute("zbid",this.id);
		req.setAttribute("glqid",departList.get(0).getGlqid());		
		//设置时间
		WuyeSfglYsfyjszbEntity jszb = systemService.findUniqueByProperty(WuyeSfglYsfyjszbEntity.class, "id", this.id);
		String firstTime =  jszb.getJfnd()+"-0"+ jszb.getJfyf()+"-0"+1;
		try {
			Calendar calendar = DateUtils.parseCalendar(firstTime, "yyyy-MM-dd");
			String lastTime = jszb.getJfnd()+"-0"+ jszb.getJfyf()+"-"+calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			req.setAttribute("jfqssj", firstTime);
			req.setAttribute("jfjzsj", lastTime);
		} catch (ParseException e) {		
			e.printStackTrace();
		}				
		if (StringUtil.isNotEmpty(wuyeSfglYsfyjsxm.getId())) {
			wuyeSfglYsfyjsxm = wuyeSfglYsfyjsxmService.getEntity(WuyeSfglYsfyjsxmEntity.class, wuyeSfglYsfyjsxm.getId());
			req.setAttribute("wuyeSfglYsfyjsxmPage", wuyeSfglYsfyjsxm);
		}
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglYsfyjsxm-add");
	}
	/**
	 * 异步参数
	 * @author GuoPeiZhi
	 * @param req
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(params = "goAdd2")
	@ResponseBody()
	public WuyeSfglSfxmszEntity goAdd2( HttpServletRequest req) throws UnsupportedEncodingException {		
		//判断属于哪个管区
		StringBuffer hql = new StringBuffer(" from WuyeSfglSfxmszEntity w where glqid=(SELECT glqid FROM WuyeSfglYsfyjszbEntity WHERE id='"+id+"')");			
		List<WuyeSfglSfxmszEntity> departList = this.systemService.findHql(hql.toString());
		if(departList.size()>0)
		req.setAttribute("glqid", departList.get(0).getGlqid());
		//通过id获取entity		
		String name =req.getParameter("name");
		if(name!=null){
			name =new String(name.getBytes("iso-8859-1"), "utf-8");
			List<WuyeSfglSfxmszEntity> fxmszList = systemService.findByQueryString("from WuyeSfglSfxmszEntity where xmmc='"+name+"' and glqid='"+departList.get(0).getGlqid()+"'");		
			if(fxmszList.size()>0){
				return fxmszList.get(0);
			}
		}
		return new WuyeSfglSfxmszEntity();
	}
	
	
	
	
	
	/**
	 * 应收费用计算项目表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WuyeSfglYsfyjsxmEntity wuyeSfglYsfyjsxm, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeSfglYsfyjsxm.getId())) {
			wuyeSfglYsfyjsxm = wuyeSfglYsfyjsxmService.getEntity(WuyeSfglYsfyjsxmEntity.class, wuyeSfglYsfyjsxm.getId());
			req.setAttribute("wuyeSfglYsfyjsxmPage", wuyeSfglYsfyjsxm);
		}
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglYsfyjsxm-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeSfglYsfyjsxmController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WuyeSfglYsfyjsxmEntity wuyeSfglYsfyjsxm,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WuyeSfglYsfyjsxmEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeSfglYsfyjsxm, request.getParameterMap());
		List<WuyeSfglYsfyjsxmEntity> wuyeSfglYsfyjsxms = this.wuyeSfglYsfyjsxmService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"应收费用计算项目表");
		modelMap.put(NormalExcelConstants.CLASS,WuyeSfglYsfyjsxmEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("应收费用计算项目表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wuyeSfglYsfyjsxms);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WuyeSfglYsfyjsxmEntity wuyeSfglYsfyjsxm,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"应收费用计算项目表");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeSfglYsfyjsxmEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("应收费用计算项目表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<WuyeSfglYsfyjsxmEntity> listWuyeSfglYsfyjsxmEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeSfglYsfyjsxmEntity.class,params);
				for (WuyeSfglYsfyjsxmEntity wuyeSfglYsfyjsxm : listWuyeSfglYsfyjsxmEntitys) {
					wuyeSfglYsfyjsxmService.save(wuyeSfglYsfyjsxm);
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
	@ApiOperation(value="应收费用计算项目表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WuyeSfglYsfyjsxmEntity>> list() {
		List<WuyeSfglYsfyjsxmEntity> listWuyeSfglYsfyjsxms=wuyeSfglYsfyjsxmService.getList(WuyeSfglYsfyjsxmEntity.class);
		return Result.success(listWuyeSfglYsfyjsxms);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取应收费用计算项目表信息",notes="根据ID获取应收费用计算项目表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WuyeSfglYsfyjsxmEntity task = wuyeSfglYsfyjsxmService.get(WuyeSfglYsfyjsxmEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取应收费用计算项目表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建应收费用计算项目表")
	public ResponseMessage<?> create(@ApiParam(name="应收费用计算项目表对象")@RequestBody WuyeSfglYsfyjsxmEntity wuyeSfglYsfyjsxm, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeSfglYsfyjsxmEntity>> failures = validator.validate(wuyeSfglYsfyjsxm);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeSfglYsfyjsxmService.save(wuyeSfglYsfyjsxm);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("应收费用计算项目表信息保存失败");
		}
		return Result.success(wuyeSfglYsfyjsxm);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新应收费用计算项目表",notes="更新应收费用计算项目表")
	public ResponseMessage<?> update(@ApiParam(name="应收费用计算项目表对象")@RequestBody WuyeSfglYsfyjsxmEntity wuyeSfglYsfyjsxm) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeSfglYsfyjsxmEntity>> failures = validator.validate(wuyeSfglYsfyjsxm);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeSfglYsfyjsxmService.saveOrUpdate(wuyeSfglYsfyjsxm);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新应收费用计算项目表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新应收费用计算项目表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除应收费用计算项目表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wuyeSfglYsfyjsxmService.deleteEntityById(WuyeSfglYsfyjsxmEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("应收费用计算项目表删除失败");
		}

		return Result.success();
	}
	
	/**计算费用
	 * @throws ScriptException */
	@RequestMapping(params = "countCost")
	@ResponseBody
	public AjaxJson countCost(HttpServletRequest request) throws ScriptException{
		AjaxJson j = new AjaxJson();
		String id = request.getParameter("id");
		//获取算费范围
		WuyeSfglYsfyjszbEntity jszb = systemService.findUniqueByProperty(WuyeSfglYsfyjszbEntity.class, "id", id);		
		WuyeGlqEntity glqEntity = wuyeSfglYsfyjsxmDao.findByObject(jszb.getSffw());		
		String lx="";
		//获取算费范围所有房间
		if("4".equals(glqEntity.getGlqlx()))lx="4";
		if("3".equals(glqEntity.getGlqlx()))lx="3";
		if("2".equals(glqEntity.getGlqlx()))lx="2";
		List<WuyeFwxxEntity> fwxxList =  wuyeSfglYsfyjsxmDao.findByList(lx,jszb.getSffw());
		//判断是否计算
		Integer  count = wuyeSfglYsfyjsxmDao.findByCount(jszb.getJfnd(),jszb.getJfyf(),lx,jszb.getSffw());
		if(count>0){
			j.setMsg("费用已审核,不能重复计算");
			return j;
		}
		//删除未审核记录重新计算
		wuyeSfglYsfyjsxmDao.findByDelete(jszb.getJfnd(),jszb.getJfyf(),lx,jszb.getSffw());			
		//获取计算收费项目管理表
		List<WuyeSfglYsfyjsxmEntity> sfxmEntityList = wuyeSfglYsfyjsxmDao.findByJsxmList(jszb.getId());		
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");		
		//遍历房间
		for(WuyeFwxxEntity fwxxEntity:fwxxList){
			//获取房间项目收费表
			List<WuyeSfglFjsfxmszEntity> fjsfEntityList = wuyeSfglYsfyjsxmDao.findByfjsfxmList(fwxxEntity.getId());
			//自住
			if("0".equals(fwxxEntity.getZflb())){				
				//遍历收费项目管理表
				for(WuyeSfglYsfyjsxmEntity sfxmEntity : sfxmEntityList){
					//遍历房间项目收费表		
					for(WuyeSfglFjsfxmszEntity fjsfEntity : fjsfEntityList ){
						if(fjsfEntity.getSfxmid().equals(sfxmEntity.getSfxmid())){							
							Bindings bindings = engine.createBindings();							
							//折扣系数
							Double zkxh =1.0;
							if(fjsfEntity.getYhbl()!=null)zkxh=fjsfEntity.getYhbl();
							String str ="function repalceContent(a,b,c,d,e,f,g){ return ("+replaceProperties(sfxmEntity.getJsgs())+")*"+zkxh+"*"+sfxmEntity.getJfzq()+"; } repalceContent(a,b,c,d,e,f,g)";
							CompiledScript js = ((Compilable) engine).compile(str);		
							bindings.put("a", fwxxEntity.getJzmj());//建筑面积
							bindings.put("b", sfxmEntity.getJfdj());//单价
							bindings.put("c", fwxxEntity.getTnmj());//套内面积
							bindings.put("d", 0);//实际用量
							bindings.put("e", 0);//租赁费
							bindings.put("f",  0);
							bindings.put("g", 0);
							WuyeSfglYsfyjlEntity ysfyjlEntity = new WuyeSfglYsfyjlEntity();							
							List<Map<String, Object>>  list =new  ArrayList<>();
							ysfyjlEntity.setSl(1d);							
							if("3".equals(sfxmEntity.getJffs())){
								Double sum = wuyeSfglYsfyjsxmDao.findBysbSum(sfxmEntity.getSfxmdm(),fwxxEntity.getId(),sfxmEntity.getJfqssj(),sfxmEntity.getJfjzsj());
								//获取起止数								
							    list= systemService.findForJdbc("SELECT l.syzs,l.byzs,l.bl,l.gtl FROM wuye_cbgl_sbcbjl l WHERE l.ybid =(select id from wuye_cbgl_fjb  w where  w.sfxmdm ="+sfxmEntity.getSfxmdm()+" AND w.fwxxid='"+fwxxEntity.getId()+"'  AND w.yxbz='1') AND '"+ sfxmEntity.getJfqssj()+"'<=jfqsrq AND  '"+sfxmEntity.getJfjzsj()+"'>=jfjsrq");																		
							    //获取数量
								ysfyjlEntity.setSl(sum);
							    bindings.put("d", sum);							
							}
							if("4".equals(sfxmEntity.getJffs())){
								Double sum = wuyeSfglYsfyjsxmDao.findBydbSum(sfxmEntity.getSfxmdm(),fwxxEntity.getId(),sfxmEntity.getJfqssj(),sfxmEntity.getJfjzsj());
								//获取起止数
								list = systemService.findForJdbc("SELECT l.syzs,l.byzs,l.bl,l.gtl FROM wuye_cbgl_dbcbjl l WHERE l.ybid =(select id from wuye_cbgl_fjb  w where  w.sfxmdm ="+sfxmEntity.getSfxmdm()+" AND w.fwxxid='"+fwxxEntity.getId()+"'  AND w.yxbz='1') AND '"+ sfxmEntity.getJfqssj()+"'<=jfqsrq AND  '"+sfxmEntity.getJfjzsj()+"'>=jfjsrq");													
								ysfyjlEntity.setSl(sum);
								bindings.put("d", sum);
							}
							if("5".equals(sfxmEntity.getJffs())){
								Double sum = wuyeSfglYsfyjsxmDao.findByqbSum(sfxmEntity.getSfxmdm(),fwxxEntity.getId(),sfxmEntity.getJfqssj(),sfxmEntity.getJfjzsj());
								//获取起止数
								list = systemService.findForJdbc("SELECT l.syzs,l.byzs,l.bl,l.gtl FROM wuye_cbgl_qbcbjl l WHERE l.ybid =(select id from wuye_cbgl_fjb  w where  w.sfxmdm ="+sfxmEntity.getSfxmdm()+" AND w.fwxxid='"+fwxxEntity.getId()+"'  AND w.yxbz='1') AND '"+ sfxmEntity.getJfqssj()+"'<=jfqsrq AND  '"+sfxmEntity.getJfjzsj()+"'>=jfjsrq");																					
								ysfyjlEntity.setSl(sum);
								bindings.put("d", sum);
							}
						   Double d = (Double)js.eval(bindings);
						   bindings.clear();
						   //插入						   
						   if(1==list.size()){
								ysfyjlEntity.setQss(Double.valueOf(list.get(0).get("syzs").toString()));
								ysfyjlEntity.setJzs(Double.valueOf(list.get(0).get("byzs").toString()));
								ysfyjlEntity.setBl(Double.valueOf(list.get(0).get("bl").toString()));
								ysfyjlEntity.setGts(Double.valueOf(list.get(0).get("gtl").toString()));						
							}
						   //数量设置
						   if("0".equals(sfxmEntity.getJffs()))ysfyjlEntity.setSl(fwxxEntity.getJzmj());//建筑面积
						   if("1".equals(sfxmEntity.getJffs()))ysfyjlEntity.setSl(fwxxEntity.getTnmj());//套内面积					  
						   ysfyjlEntity.setGlqid(fwxxEntity.getGlqid());
						   ysfyjlEntity.setLyid(fwxxEntity.getLyid());
						   ysfyjlEntity.setFjid(fwxxEntity.getFjid());
						   ysfyjlEntity.setFwxxid(fwxxEntity.getId());
						   List<WuyeYzglFwyzxxEntity>  fwyzxxList = systemService.findByQueryString("from WuyeYzglFwyzxxEntity where  fwxxid='"+fwxxEntity.getId()+"' and yxbz='1' ");
						  if(fwyzxxList.size()!=0){
							   ysfyjlEntity.setFwyzxxid(fwyzxxList.get(0).getId());
							   ysfyjlEntity.setYzmc(fwyzxxList.get(0).getYzMc());
						  }						
						   ysfyjlEntity.setSfzt("0");
						   ysfyjlEntity.setShzt("0");
						   ysfyjlEntity.setSfxmdm(sfxmEntity.getSfxmdm());
						   ysfyjlEntity.setSfxmmc(sfxmEntity.getSfxmmc());
						   ysfyjlEntity.setJfqssj(sfxmEntity.getJfqssj());
						   ysfyjlEntity.setJfjzsj(sfxmEntity.getJfjzsj());
						   ysfyjlEntity.setJg(sfxmEntity.getJfdj());
						   ysfyjlEntity.setYsje(d);
						   ysfyjlEntity.setJfnd(jszb.getJfnd());
						   ysfyjlEntity.setJfyf(jszb.getJfyf());
						   try {
							wuyeSfglYsfyjlService.save(ysfyjlEntity);
						} catch (Exception e) {							
							e.printStackTrace();
							throw new BusinessException("应收费用计算异常！");
						}
						}
					}
				}
			}else{//出租			
				//遍历收费项目管理表表
				for(WuyeSfglYsfyjsxmEntity sfxmEntity : sfxmEntityList){
					//遍历房间项目收费表		
					for(WuyeSfglFjsfxmszEntity fjsfEntity : fjsfEntityList ){						
						if(fjsfEntity.getSfxmid().equals(sfxmEntity.getSfxmid())){
							//房间所租人数
							List<WuyeYzglFwyzxxEntity> fwyzxxList = systemService.findByQueryString("from WuyeYzglFwyzxxEntity where fwxxid='"+fwxxEntity.getId()+"' and yxbz='1'  and yzSx='zh' ");
							for(int i=0;i<fwyzxxList.size();i++){
								Bindings bindings = engine.createBindings();
								//折扣系数
								Double zkxh =1.0;
								Integer zhrs =fwyzxxList.size();
								if(fjsfEntity.getYhbl()!=null)zkxh=fjsfEntity.getYhbl();
								bindings.put("e",0);//租赁费
								if(!StringUtils.isEmpty(fwyzxxList.get(i).getZlf())){
									bindings.put("e", Integer.valueOf(fwyzxxList.get(i).getZlf()));//租赁费
									zhrs=1;
								}
								bindings.put("a", fwxxEntity.getJzmj());//建筑面积
								bindings.put("b", sfxmEntity.getJfdj());//单价
								bindings.put("c", fwxxEntity.getTnmj());//套内面积
								bindings.put("d",0);//实际用量
								bindings.put("f",  0);
								bindings.put("g", 0);
								String str ="function repalceContent(a,b,c,d,e,f,g){ return ("+replaceProperties(sfxmEntity.getJsgs())+")*"+zkxh+"*"+sfxmEntity.getJfzq()+"/"+zhrs+"; } repalceContent(a,b,c,d,e,f,g)";
								CompiledScript js = ((Compilable) engine).compile(str);						
								//声明
								WuyeSfglYsfyjlEntity ysfyjlEntity = new WuyeSfglYsfyjlEntity();
								List<Map<String, Object>>  list = new ArrayList<>();
								ysfyjlEntity.setSl(1d);
								if("3".equals(sfxmEntity.getJffs())){
									Double sum = wuyeSfglYsfyjsxmDao.findBysbSum(sfxmEntity.getSfxmdm(),fwxxEntity.getId(),sfxmEntity.getJfqssj(),sfxmEntity.getJfjzsj());
									//获取起止数
									list = systemService.findForJdbc("SELECT l.syzs,l.byzs,l.bl,l.gtl FROM wuye_cbgl_sbcbjl l WHERE l.ybid =(select id from wuye_cbgl_fjb  w where  w.sfxmdm ="+sfxmEntity.getSfxmdm()+" AND w.fwxxid='"+fwxxEntity.getId()+"'  AND w.yxbz='1') AND '"+ sfxmEntity.getJfqssj()+"'<=jfqsrq AND  '"+sfxmEntity.getJfjzsj()+"'>=jfjsrq");																													
									//获取数量
									ysfyjlEntity.setSl(sum/fwyzxxList.size());							
									bindings.put("d", sum);							
								}								
								if("4".equals(sfxmEntity.getJffs())){
									Double sum = wuyeSfglYsfyjsxmDao.findBydbSum(sfxmEntity.getSfxmdm(),fwxxEntity.getId(),sfxmEntity.getJfqssj(),sfxmEntity.getJfjzsj());
									//获取起止数
									list = systemService.findForJdbc("SELECT l.syzs,l.byzs,l.bl,l.gtl FROM wuye_cbgl_dbcbjl l WHERE l.ybid =(select id from wuye_cbgl_fjb  w where  w.sfxmdm ="+sfxmEntity.getSfxmdm()+" AND w.fwxxid='"+fwxxEntity.getId()+"'  AND w.yxbz='1') AND '"+ sfxmEntity.getJfqssj()+"'<=jfqsrq AND  '"+sfxmEntity.getJfjzsj()+"'>=jfjsrq");															
									ysfyjlEntity.setSl(sum/fwyzxxList.size());
									bindings.put("d", sum);
								}
								if("5".equals(sfxmEntity.getJffs())){
									Double sum = wuyeSfglYsfyjsxmDao.findByqbSum(sfxmEntity.getSfxmdm(),fwxxEntity.getId(),sfxmEntity.getJfqssj(),sfxmEntity.getJfjzsj());
									//获取起止数
									list = systemService.findForJdbc("SELECT l.syzs,l.byzs,l.bl,l.gtl FROM wuye_cbgl_qbcbjl l WHERE l.ybid =(select id from wuye_cbgl_fjb  w where  w.sfxmdm ="+sfxmEntity.getSfxmdm()+" AND w.fwxxid='"+fwxxEntity.getId()+"'  AND w.yxbz='1') AND '"+ sfxmEntity.getJfqssj()+"'<=jfqsrq AND  '"+sfxmEntity.getJfjzsj()+"'>=jfjsrq");													
									ysfyjlEntity.setSl(sum/fwyzxxList.size());
									bindings.put("d", sum);
								}
							   Double d = (Double)js.eval(bindings);
							   bindings.clear();
							   //插入
							   if(1==list.size()){
									ysfyjlEntity.setQss(Double.valueOf(list.get(0).get("syzs").toString()));
									ysfyjlEntity.setJzs(Double.valueOf(list.get(0).get("byzs").toString()));
									ysfyjlEntity.setBl(Double.valueOf(list.get(0).get("bl").toString()));
									ysfyjlEntity.setGts(Double.valueOf(list.get(0).get("gtl").toString()));						
								}
							   if("0".equals(sfxmEntity.getJffs()))ysfyjlEntity.setSl(fwxxEntity.getJzmj());//建筑面积
							   if("1".equals(sfxmEntity.getJffs()))ysfyjlEntity.setSl(fwxxEntity.getTnmj());//套内面积
							   ysfyjlEntity.setGlqid(fwxxEntity.getGlqid());
							   ysfyjlEntity.setLyid(fwxxEntity.getLyid());
							   ysfyjlEntity.setFjid(fwxxEntity.getFjid());
							   ysfyjlEntity.setFwxxid(fwxxEntity.getId());							   
							   ysfyjlEntity.setFwyzxxid(fwyzxxList.get(i).getId());
							   ysfyjlEntity.setYzmc(fwyzxxList.get(i).getYzMc());
							   ysfyjlEntity.setSfzt("0");
							   ysfyjlEntity.setShzt("0");
							   ysfyjlEntity.setSfxmdm(sfxmEntity.getSfxmdm());
							   ysfyjlEntity.setSfxmmc(sfxmEntity.getSfxmmc());
							   ysfyjlEntity.setJfqssj(sfxmEntity.getJfqssj());
							   ysfyjlEntity.setJfjzsj(sfxmEntity.getJfjzsj());
							   ysfyjlEntity.setJg(sfxmEntity.getJfdj());
							   ysfyjlEntity.setYsje(d);
							   ysfyjlEntity.setJfnd(jszb.getJfnd());
							   ysfyjlEntity.setJfyf(jszb.getJfyf());
							   try {
								wuyeSfglYsfyjlService.save(ysfyjlEntity);
							} catch (Exception e) {							
								e.printStackTrace();
								throw new BusinessException("应收费用计算异常！");
							}
							}														
						}
					}
				}
			}			
		}
		j.setMsg("计算成功,请到应收费用审核查看！");
		return j;
	}
	/**公式替换*/
	private String replaceProperties(String str){
		PropertiesUtil p = new PropertiesUtil("wuye.properties");		
		Properties pps = p.getProperties();
		Enumeration<?> en = pps.propertyNames(); // 得到配置文件的名字
		while (en.hasMoreElements()) {
			String strKey = (String) en.nextElement();
			String strValue = pps.getProperty(strKey);
			str = str.replaceAll(strKey, strValue);			
		}
		return str;
	}
}
