package com.jeecg.wuyesfgl.controller;
import com.jeecg.wuyesfgl.dao.WuyeSfglDwdkxxDao;
import com.jeecg.wuyesfgl.dao.WuyeSfglYhdkxxDao;
import com.jeecg.wuyesfgl.dao.WuyeSfglYsfyjlDao;
import com.jeecg.wuyesfgl.entity.WuyeSfglDkxxzbEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglDwdkxxEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglDwdkxxPageEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglDwdkxxzbEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYhdkxxEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYhdkxxPageEntity;
import com.jeecg.wuyesfgl.service.WuyeSfglDwdkxxServiceI;
import com.jeecg.wuyesfgl.service.WuyeSfglDwdkxxzbServiceI;
import com.jeecg.wuyesfgl.service.WuyeSfglYhdkxxServiceI;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwyzxxEntity;

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
 * @Description: 单位代扣信息主表
 * @author onlineGenerator
 * @date 2018-04-19 09:43:23
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wuyeSfglDwdkxxzbController")
@Api(value="WuyeSfglDwdkxxzb",description="单位代扣信息主表",tags="wuyeSfglDwdkxxzbController")
public class WuyeSfglDwdkxxzbController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WuyeSfglDwdkxxzbController.class);

	@Autowired
	private WuyeSfglDwdkxxzbServiceI wuyeSfglDwdkxxzbService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private WuyeSfglYsfyjlDao wuyeSfglYsfyjlDao; 
	@Autowired
	private WuyeSfglDwdkxxServiceI wuyeSfglDwdkxxService;
	@Autowired
	private WuyeSfglDwdkxxDao wuyeSfglDwdkxxjlDao; 


	/**
	 * 单位代扣信息主表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglDwdkxxzbList");
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
	public void datagrid(WuyeSfglDwdkxxzbEntity wuyeSfglDwdkxxzb,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WuyeSfglDwdkxxzbEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeSfglDwdkxxzb, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wuyeSfglDwdkxxzbService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**生成扣款信息
	 * @throws Exception */
	@ResponseBody
	@RequestMapping(params = "insertDaikou")
	public String insertDaikou(String dkid) throws Exception {
		String str = "'";
		String message = "生成扣款失败";
		
		/**通过主表主键，查询出单位代扣主表信息*/
		WuyeSfglDwdkxxzbEntity dwdkxxzb = systemService.getEntity(WuyeSfglDwdkxxzbEntity.class,dkid);
		/**通过应收费用审核表和业主信息表查询数据*/
		List<WuyeSfglDwdkxxPageEntity> dkxxPage = wuyeSfglYsfyjlDao.findListByDwDkxxzb(dwdkxxzb); 
		/**如果已经时导入的数据，那么不予生成*/
		if("1".equals(dwdkxxzb.getSfyjdr())){
			message = dwdkxxzb.getYear()+"年"+dwdkxxzb.getMonth()+"月单位代扣信息更新完成，无需再次生成";
		}else{   /**添加*/
			//先删除
			int s = wuyeSfglDwdkxxjlDao.deleteByYearAndMonthAndDkdw(dwdkxxzb);
			
			//再增加，实现一个随时更新功能
			if(!dkxxPage.isEmpty()){
				for(WuyeSfglDwdkxxPageEntity d : dkxxPage){
					//执行添加操作
					WuyeSfglDwdkxxEntity dwdkxx = new WuyeSfglDwdkxxEntity();
					dwdkxx.setZhxm(d.getYzmc());
					dwdkxx.setSsje(d.getSsje()); 
					dwdkxx.setDkdwgh(d.getDkdwgh());
					dwdkxx.setYear(dwdkxxzb.getYear());
					dwdkxx.setMonth(dwdkxxzb.getMonth());
					dwdkxx.setDkdw(dwdkxxzb.getDkdw());
					//执行保存操作
					wuyeSfglDwdkxxService.save(dwdkxx);
					
					/**该添加的也添加进去了，是时候更新应收费用记录表外键了*/
					//根据单位工号，查询业主主键
					List<WuyeYzglFwyzxxEntity> fwyzxx = systemService.findByQueryString("from WuyeYzglFwyzxxEntity where dkr_dkdwgh ="+str+dwdkxx.getDkdwgh()+str);
					String fwyzxxid = fwyzxx.get(0).getId();
					String sfzt = "0";
					//执行更新操作
					int i = wuyeSfglYsfyjlDao.updateDkxxzj(dwdkxx.getId(),dwdkxxzb.getYear(),dwdkxxzb.getMonth(),fwyzxxid,sfzt);
				}
			}
			message = dwdkxxzb.getYear()+"年"+dwdkxxzb.getMonth()+"月扣款生成成功";
		}
		
		
		return message;
	}
	
	
	/**
	 * 删除单位代扣信息主表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeSfglDwdkxxzbEntity wuyeSfglDwdkxxzb, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeSfglDwdkxxzb = systemService.getEntity(WuyeSfglDwdkxxzbEntity.class, wuyeSfglDwdkxxzb.getId());
		message = "单位代扣信息主表删除成功";
		try{
			wuyeSfglDwdkxxzbService.delete(wuyeSfglDwdkxxzb);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "单位代扣信息主表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除单位代扣信息主表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "单位代扣信息主表删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeSfglDwdkxxzbEntity wuyeSfglDwdkxxzb = systemService.getEntity(WuyeSfglDwdkxxzbEntity.class, 
				id
				);
				wuyeSfglDwdkxxzbService.delete(wuyeSfglDwdkxxzb);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "单位代扣信息主表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加单位代扣信息主表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeSfglDwdkxxzbEntity wuyeSfglDwdkxxzb, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "单位代扣信息主表添加成功";
		try{
			wuyeSfglDwdkxxzbService.save(wuyeSfglDwdkxxzb);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "单位代扣信息主表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新单位代扣信息主表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WuyeSfglDwdkxxzbEntity wuyeSfglDwdkxxzb, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "单位代扣信息主表更新成功";
		WuyeSfglDwdkxxzbEntity t = wuyeSfglDwdkxxzbService.get(WuyeSfglDwdkxxzbEntity.class, wuyeSfglDwdkxxzb.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wuyeSfglDwdkxxzb, t);
			wuyeSfglDwdkxxzbService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "单位代扣信息主表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 单位代扣信息主表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WuyeSfglDwdkxxzbEntity wuyeSfglDwdkxxzb, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeSfglDwdkxxzb.getId())) {
			wuyeSfglDwdkxxzb = wuyeSfglDwdkxxzbService.getEntity(WuyeSfglDwdkxxzbEntity.class, wuyeSfglDwdkxxzb.getId());
			req.setAttribute("wuyeSfglDwdkxxzbPage", wuyeSfglDwdkxxzb);
		}
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglDwdkxxzb-add");
	}
	/**
	 * 单位代扣信息主表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WuyeSfglDwdkxxzbEntity wuyeSfglDwdkxxzb, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeSfglDwdkxxzb.getId())) {
			wuyeSfglDwdkxxzb = wuyeSfglDwdkxxzbService.getEntity(WuyeSfglDwdkxxzbEntity.class, wuyeSfglDwdkxxzb.getId());
			req.setAttribute("wuyeSfglDwdkxxzbPage", wuyeSfglDwdkxxzb);
		}
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglDwdkxxzb-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeSfglDwdkxxzbController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WuyeSfglDwdkxxzbEntity wuyeSfglDwdkxxzb,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WuyeSfglDwdkxxzbEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeSfglDwdkxxzb, request.getParameterMap());
		List<WuyeSfglDwdkxxzbEntity> wuyeSfglDwdkxxzbs = this.wuyeSfglDwdkxxzbService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"单位代扣信息主表");
		modelMap.put(NormalExcelConstants.CLASS,WuyeSfglDwdkxxzbEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("单位代扣信息主表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wuyeSfglDwdkxxzbs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WuyeSfglDwdkxxzbEntity wuyeSfglDwdkxxzb,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"单位代扣信息主表");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeSfglDwdkxxzbEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("单位代扣信息主表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<WuyeSfglDwdkxxzbEntity> listWuyeSfglDwdkxxzbEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeSfglDwdkxxzbEntity.class,params);
				for (WuyeSfglDwdkxxzbEntity wuyeSfglDwdkxxzb : listWuyeSfglDwdkxxzbEntitys) {
					wuyeSfglDwdkxxzbService.save(wuyeSfglDwdkxxzb);
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
	@ApiOperation(value="单位代扣信息主表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WuyeSfglDwdkxxzbEntity>> list() {
		List<WuyeSfglDwdkxxzbEntity> listWuyeSfglDwdkxxzbs=wuyeSfglDwdkxxzbService.getList(WuyeSfglDwdkxxzbEntity.class);
		return Result.success(listWuyeSfglDwdkxxzbs);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取单位代扣信息主表信息",notes="根据ID获取单位代扣信息主表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WuyeSfglDwdkxxzbEntity task = wuyeSfglDwdkxxzbService.get(WuyeSfglDwdkxxzbEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取单位代扣信息主表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建单位代扣信息主表")
	public ResponseMessage<?> create(@ApiParam(name="单位代扣信息主表对象")@RequestBody WuyeSfglDwdkxxzbEntity wuyeSfglDwdkxxzb, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeSfglDwdkxxzbEntity>> failures = validator.validate(wuyeSfglDwdkxxzb);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeSfglDwdkxxzbService.save(wuyeSfglDwdkxxzb);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("单位代扣信息主表信息保存失败");
		}
		return Result.success(wuyeSfglDwdkxxzb);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新单位代扣信息主表",notes="更新单位代扣信息主表")
	public ResponseMessage<?> update(@ApiParam(name="单位代扣信息主表对象")@RequestBody WuyeSfglDwdkxxzbEntity wuyeSfglDwdkxxzb) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeSfglDwdkxxzbEntity>> failures = validator.validate(wuyeSfglDwdkxxzb);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeSfglDwdkxxzbService.saveOrUpdate(wuyeSfglDwdkxxzb);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新单位代扣信息主表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新单位代扣信息主表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除单位代扣信息主表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wuyeSfglDwdkxxzbService.deleteEntityById(WuyeSfglDwdkxxzbEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("单位代扣信息主表删除失败");
		}

		return Result.success();
	}
}
