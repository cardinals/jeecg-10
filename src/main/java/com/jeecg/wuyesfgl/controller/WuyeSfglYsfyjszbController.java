package com.jeecg.wuyesfgl.controller;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyesfgl.entity.WuyeGlqTreeEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjszbEntity;
import com.jeecg.wuyesfgl.service.WuyeSfglYsfyjszbServiceI;
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
import org.jeecgframework.core.common.model.json.ComboTree;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.jeecgframework.tag.vo.easyui.ComboTreeModel;
import org.jeecgframework.web.system.pojo.base.TSCategoryEntity;
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
import org.jeecgframework.core.util.MutiLangUtil;
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
 * @Description: 应收费用计算表
 * @author onlineGenerator
 * @date 2018-03-20 09:18:01
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wuyeSfglYsfyjszbController")
@Api(value="WuyeSfglYsfyjszb",description="应收费用计算表",tags="wuyeSfglYsfyjszbController")
public class WuyeSfglYsfyjszbController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WuyeSfglYsfyjszbController.class);

	@Autowired
	private WuyeSfglYsfyjszbServiceI wuyeSfglYsfyjszbService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 应收费用计算表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglYsfyjszbList");
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
	public void datagrid(WuyeSfglYsfyjszbEntity wuyeSfglYsfyjszb,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WuyeSfglYsfyjszbEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeSfglYsfyjszb, request.getParameterMap());
		try{
		//自定义追加查询条件		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wuyeSfglYsfyjszbService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 下拉树
	 * @author GuoPeiZhi
	 * @param selfCode
	 * @param comboTree
	 * @return
	 */
	@RequestMapping(params = "combotree")
	@ResponseBody
	public List<ComboTree> combotree(String selfCode, ComboTree comboTree) {
		CriteriaQuery cq = new CriteriaQuery(WuyeGlqTreeEntity.class);
		if (StringUtils.isNotEmpty(comboTree.getId())) {			
			cq.createAlias("fid", "fid");
			cq.eq("fid.id", comboTree.getId());
		} else if (StringUtils.isNotEmpty(selfCode)) {
			cq.eq("id", selfCode);
		} else {
			cq.isNull("fid");
		}
		cq.eq("yxbz", "1");
		cq.add();
		List<WuyeGlqTreeEntity> wuyeGlqEntityList = systemService.getListByCriteriaQuery(cq, false);
		List<ComboTree> comboTrees = new ArrayList<ComboTree>();
		ComboTreeModel comboTreeModel = new ComboTreeModel("id", "glqmc", "list");
		comboTrees = systemService.ComboTree(wuyeGlqEntityList, comboTreeModel,null, false);				
		MutiLangUtil.setMutiTree(comboTrees);
		return comboTrees;
	}

	
	/**
	 * 删除应收费用计算表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeSfglYsfyjszbEntity wuyeSfglYsfyjszb, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeSfglYsfyjszb = systemService.getEntity(WuyeSfglYsfyjszbEntity.class, wuyeSfglYsfyjszb.getId());
		message = "应收费用计算表删除成功";
		try{
			wuyeSfglYsfyjszbService.delete(wuyeSfglYsfyjszb);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "应收费用计算表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除应收费用计算表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "应收费用计算表删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeSfglYsfyjszbEntity wuyeSfglYsfyjszb = systemService.getEntity(WuyeSfglYsfyjszbEntity.class, 
				id
				);
				wuyeSfglYsfyjszbService.delete(wuyeSfglYsfyjszb);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "应收费用计算表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加应收费用计算表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeSfglYsfyjszbEntity wuyeSfglYsfyjszb, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "应收费用计算表添加成功";
		try{
			//添加范围			
			String sffw = request.getParameter("fid");			
			WuyeGlqEntity glq = systemService.findUniqueByProperty(WuyeGlqEntity.class, "id", sffw);			
			wuyeSfglYsfyjszb.setSffw(glq.getId());
			//添加管理区id
			if("1".equals(glq.getGlqlx())){
				message="此层级无法选择";
				j.setMsg(message);
				return j;
			}			
			if("2".equals(glq.getGlqlx()))	{
				wuyeSfglYsfyjszb.setSffwmc(glq.getGlqmc());
				wuyeSfglYsfyjszb.setGlqid(sffw);
			}			
			if("3".equals(glq.getGlqlx())){
				wuyeSfglYsfyjszb.setSffwmc(glq.getGlqmc());
				wuyeSfglYsfyjszb.setGlqid(glq.getFid());	
			}			
			if("4".equals(glq.getGlqlx())){
				List<WuyeGlqEntity> glqlyList =systemService.findByQueryString(" FROM WuyeGlqEntity w WHERE w.id = (SELECT fid FROM WuyeGlqEntity WHERE id='"+sffw+"')");
				wuyeSfglYsfyjszb.setSffwmc(glqlyList.get(0).getGlqmc()+glq.getGlqmc());
				wuyeSfglYsfyjszb.setGlqid(glqlyList.get(0).getFid());
			}
			wuyeSfglYsfyjszbService.save(wuyeSfglYsfyjszb);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "应收费用计算表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新应收费用计算表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WuyeSfglYsfyjszbEntity wuyeSfglYsfyjszb, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "应收费用计算表更新成功";
		WuyeSfglYsfyjszbEntity t = wuyeSfglYsfyjszbService.get(WuyeSfglYsfyjszbEntity.class, wuyeSfglYsfyjszb.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wuyeSfglYsfyjszb, t);
			wuyeSfglYsfyjszbService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "应收费用计算表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 应收费用计算表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WuyeSfglYsfyjszbEntity wuyeSfglYsfyjszb, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeSfglYsfyjszb.getId())) {
			wuyeSfglYsfyjszb = wuyeSfglYsfyjszbService.getEntity(WuyeSfglYsfyjszbEntity.class, wuyeSfglYsfyjszb.getId());
			req.setAttribute("wuyeSfglYsfyjszbPage", wuyeSfglYsfyjszb);
		}
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglYsfyjszb-add");
	}
	/**
	 * 应收费用计算表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WuyeSfglYsfyjszbEntity wuyeSfglYsfyjszb, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeSfglYsfyjszb.getId())) {
			wuyeSfglYsfyjszb = wuyeSfglYsfyjszbService.getEntity(WuyeSfglYsfyjszbEntity.class, wuyeSfglYsfyjszb.getId());
			req.setAttribute("wuyeSfglYsfyjszbPage", wuyeSfglYsfyjszb);
		}
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglYsfyjszb-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeSfglYsfyjszbController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WuyeSfglYsfyjszbEntity wuyeSfglYsfyjszb,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WuyeSfglYsfyjszbEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeSfglYsfyjszb, request.getParameterMap());
		List<WuyeSfglYsfyjszbEntity> wuyeSfglYsfyjszbs = this.wuyeSfglYsfyjszbService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"应收费用计算表");
		modelMap.put(NormalExcelConstants.CLASS,WuyeSfglYsfyjszbEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("应收费用计算表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wuyeSfglYsfyjszbs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WuyeSfglYsfyjszbEntity wuyeSfglYsfyjszb,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"应收费用计算表");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeSfglYsfyjszbEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("应收费用计算表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<WuyeSfglYsfyjszbEntity> listWuyeSfglYsfyjszbEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeSfglYsfyjszbEntity.class,params);
				for (WuyeSfglYsfyjszbEntity wuyeSfglYsfyjszb : listWuyeSfglYsfyjszbEntitys) {
					wuyeSfglYsfyjszbService.save(wuyeSfglYsfyjszb);
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
	@ApiOperation(value="应收费用计算表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WuyeSfglYsfyjszbEntity>> list() {
		List<WuyeSfglYsfyjszbEntity> listWuyeSfglYsfyjszbs=wuyeSfglYsfyjszbService.getList(WuyeSfglYsfyjszbEntity.class);
		return Result.success(listWuyeSfglYsfyjszbs);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取应收费用计算表信息",notes="根据ID获取应收费用计算表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WuyeSfglYsfyjszbEntity task = wuyeSfglYsfyjszbService.get(WuyeSfglYsfyjszbEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取应收费用计算表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建应收费用计算表")
	public ResponseMessage<?> create(@ApiParam(name="应收费用计算表对象")@RequestBody WuyeSfglYsfyjszbEntity wuyeSfglYsfyjszb, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeSfglYsfyjszbEntity>> failures = validator.validate(wuyeSfglYsfyjszb);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeSfglYsfyjszbService.save(wuyeSfglYsfyjszb);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("应收费用计算表信息保存失败");
		}
		return Result.success(wuyeSfglYsfyjszb);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新应收费用计算表",notes="更新应收费用计算表")
	public ResponseMessage<?> update(@ApiParam(name="应收费用计算表对象")@RequestBody WuyeSfglYsfyjszbEntity wuyeSfglYsfyjszb) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeSfglYsfyjszbEntity>> failures = validator.validate(wuyeSfglYsfyjszb);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeSfglYsfyjszbService.saveOrUpdate(wuyeSfglYsfyjszb);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新应收费用计算表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新应收费用计算表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除应收费用计算表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wuyeSfglYsfyjszbService.deleteEntityById(WuyeSfglYsfyjszbEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("应收费用计算表删除失败");
		}

		return Result.success();
	}
}
