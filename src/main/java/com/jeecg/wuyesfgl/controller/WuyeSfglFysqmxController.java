package com.jeecg.wuyesfgl.controller;
import com.jeecg.wuyesfgl.entity.WuyeSfglFysqmxEntity;
import com.jeecg.wuyesfgl.service.WuyeSfglFysqmxServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
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
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
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
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: 费用收取明细
 * @author onlineGenerator
 * @date 2018-04-10 16:52:44
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wuyeSfglFysqmxController")
@Api(value="WuyeSfglFysqmx",description="费用收取明细",tags="wuyeSfglFysqmxController")
public class WuyeSfglFysqmxController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WuyeSfglFysqmxController.class);

	@Autowired
	private WuyeSfglFysqmxServiceI wuyeSfglFysqmxService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	/**主表id*/
	String id;


	/**
	 * 费用收取明细列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(String id, HttpServletRequest request) {
		this.id = id;
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglFysqmxList");
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
	public void datagrid(WuyeSfglFysqmxEntity wuyeSfglFysqmx,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WuyeSfglFysqmxEntity.class, dataGrid);	
		try{
			//自定义追加查询条件
			wuyeSfglFysqmx.setSfzbid(this.id);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		//查询条件组装器		
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeSfglFysqmx, request.getParameterMap());
		this.wuyeSfglFysqmxService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除费用收取明细
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeSfglFysqmxEntity wuyeSfglFysqmx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeSfglFysqmx = systemService.getEntity(WuyeSfglFysqmxEntity.class, wuyeSfglFysqmx.getId());
		message = "费用收取明细删除成功";
		try{
			wuyeSfglFysqmxService.delete(wuyeSfglFysqmx);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "费用收取明细删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除费用收取明细
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "费用收取明细删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeSfglFysqmxEntity wuyeSfglFysqmx = systemService.getEntity(WuyeSfglFysqmxEntity.class, 
				id
				);
				wuyeSfglFysqmxService.delete(wuyeSfglFysqmx);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "费用收取明细删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加费用收取明细
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeSfglFysqmxEntity wuyeSfglFysqmx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "费用收取明细添加成功";
		try{
			wuyeSfglFysqmxService.save(wuyeSfglFysqmx);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "费用收取明细添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新费用收取明细
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WuyeSfglFysqmxEntity wuyeSfglFysqmx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "费用收取明细更新成功";
		WuyeSfglFysqmxEntity t = wuyeSfglFysqmxService.get(WuyeSfglFysqmxEntity.class, wuyeSfglFysqmx.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wuyeSfglFysqmx, t);
			wuyeSfglFysqmxService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "费用收取明细更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 费用收取明细新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WuyeSfglFysqmxEntity wuyeSfglFysqmx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeSfglFysqmx.getId())) {
			wuyeSfglFysqmx = wuyeSfglFysqmxService.getEntity(WuyeSfglFysqmxEntity.class, wuyeSfglFysqmx.getId());
			req.setAttribute("wuyeSfglFysqmxPage", wuyeSfglFysqmx);
		}
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglFysqmx-add");
	}
	/**
	 * 费用收取明细编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WuyeSfglFysqmxEntity wuyeSfglFysqmx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeSfglFysqmx.getId())) {
			wuyeSfglFysqmx = wuyeSfglFysqmxService.getEntity(WuyeSfglFysqmxEntity.class, wuyeSfglFysqmx.getId());
			req.setAttribute("wuyeSfglFysqmxPage", wuyeSfglFysqmx);
		}
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglFysqmx-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeSfglFysqmxController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WuyeSfglFysqmxEntity wuyeSfglFysqmx,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WuyeSfglFysqmxEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeSfglFysqmx, request.getParameterMap());
		List<WuyeSfglFysqmxEntity> wuyeSfglFysqmxs = this.wuyeSfglFysqmxService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"费用收取明细");
		modelMap.put(NormalExcelConstants.CLASS,WuyeSfglFysqmxEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("费用收取明细列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wuyeSfglFysqmxs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WuyeSfglFysqmxEntity wuyeSfglFysqmx,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"费用收取明细");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeSfglFysqmxEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("费用收取明细列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<WuyeSfglFysqmxEntity> listWuyeSfglFysqmxEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeSfglFysqmxEntity.class,params);
				for (WuyeSfglFysqmxEntity wuyeSfglFysqmx : listWuyeSfglFysqmxEntitys) {
					wuyeSfglFysqmxService.save(wuyeSfglFysqmx);
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
	@ApiOperation(value="费用收取明细列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WuyeSfglFysqmxEntity>> list() {
		List<WuyeSfglFysqmxEntity> listWuyeSfglFysqmxs=wuyeSfglFysqmxService.getList(WuyeSfglFysqmxEntity.class);
		return Result.success(listWuyeSfglFysqmxs);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取费用收取明细信息",notes="根据ID获取费用收取明细信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WuyeSfglFysqmxEntity task = wuyeSfglFysqmxService.get(WuyeSfglFysqmxEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取费用收取明细信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建费用收取明细")
	public ResponseMessage<?> create(@ApiParam(name="费用收取明细对象")@RequestBody WuyeSfglFysqmxEntity wuyeSfglFysqmx, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeSfglFysqmxEntity>> failures = validator.validate(wuyeSfglFysqmx);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeSfglFysqmxService.save(wuyeSfglFysqmx);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("费用收取明细信息保存失败");
		}
		return Result.success(wuyeSfglFysqmx);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新费用收取明细",notes="更新费用收取明细")
	public ResponseMessage<?> update(@ApiParam(name="费用收取明细对象")@RequestBody WuyeSfglFysqmxEntity wuyeSfglFysqmx) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeSfglFysqmxEntity>> failures = validator.validate(wuyeSfglFysqmx);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeSfglFysqmxService.saveOrUpdate(wuyeSfglFysqmx);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新费用收取明细信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新费用收取明细信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除费用收取明细")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wuyeSfglFysqmxService.deleteEntityById(WuyeSfglFysqmxEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("费用收取明细删除失败");
		}

		return Result.success();
	}
}
