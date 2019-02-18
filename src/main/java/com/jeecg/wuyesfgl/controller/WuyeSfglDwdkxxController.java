package com.jeecg.wuyesfgl.controller;
import com.jeecg.wuyesfgl.dao.WuyeSfglDwdkxxDao;
import com.jeecg.wuyesfgl.dao.WuyeSfglYhdkxxDao;
import com.jeecg.wuyesfgl.dao.WuyeSfglYsfyjlDao;
import com.jeecg.wuyesfgl.entity.WuyeSfglDkxxzbEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglDwdkxxEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglDwdkxxzbEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYhdkxxEntity;
import com.jeecg.wuyesfgl.service.WuyeSfglDwdkxxServiceI;
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
 * @Description: 单位代扣信息
 * @author onlineGenerator
 * @date 2018-04-19 09:43:04
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wuyeSfglDwdkxxController")
@Api(value="WuyeSfglDwdkxx",description="单位代扣信息",tags="wuyeSfglDwdkxxController")
public class WuyeSfglDwdkxxController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WuyeSfglDwdkxxController.class);

	@Autowired
	private WuyeSfglDwdkxxServiceI wuyeSfglDwdkxxService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private WuyeSfglYsfyjlDao wuyeSfglYsfyjlDao; 
	@Autowired
	private WuyeSfglDwdkxxDao wuyeSfglDwdkxxjlDao; 
	
	//银行代扣主表id
	private String zbid;

	String str = "'";

	/**
	 * 单位代扣信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(String zbid,HttpServletRequest request) {
		this.zbid = zbid;
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglDwdkxxList");
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
	public void datagrid(WuyeSfglDwdkxxEntity wuyeSfglDwdkxx,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		/**通过主表主键，查询出代扣主表信息*/
		WuyeSfglDwdkxxzbEntity dwdkxxzb = systemService.getEntity(WuyeSfglDwdkxxzbEntity.class,this.zbid);
		//查询数据
		List<WuyeSfglDwdkxxEntity> dwdkxx = wuyeSfglDwdkxxjlDao.findListByYearAndMonthAndDkdw(dwdkxxzb); 
		
		//查询个数
		int count = wuyeSfglDwdkxxjlDao.findcountByYearAndMonthAndDkdw(dwdkxxzb);
		dataGrid.setTotal(count);
		dataGrid.setResults(dwdkxx);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除单位代扣信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeSfglDwdkxxEntity wuyeSfglDwdkxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeSfglDwdkxx = systemService.getEntity(WuyeSfglDwdkxxEntity.class, wuyeSfglDwdkxx.getId());
		message = "单位代扣信息删除成功";
		try{
			wuyeSfglDwdkxxService.delete(wuyeSfglDwdkxx);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "单位代扣信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除单位代扣信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "单位代扣信息删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeSfglDwdkxxEntity wuyeSfglDwdkxx = systemService.getEntity(WuyeSfglDwdkxxEntity.class, 
				id
				);
				wuyeSfglDwdkxxService.delete(wuyeSfglDwdkxx);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "单位代扣信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加单位代扣信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeSfglDwdkxxEntity wuyeSfglDwdkxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "单位代扣信息添加成功";
		try{
			wuyeSfglDwdkxxService.save(wuyeSfglDwdkxx);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "单位代扣信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新单位代扣信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WuyeSfglDwdkxxEntity wuyeSfglDwdkxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "单位代扣信息更新成功";
		WuyeSfglDwdkxxEntity t = wuyeSfglDwdkxxService.get(WuyeSfglDwdkxxEntity.class, wuyeSfglDwdkxx.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wuyeSfglDwdkxx, t);
			wuyeSfglDwdkxxService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "单位代扣信息更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 单位代扣信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WuyeSfglDwdkxxEntity wuyeSfglDwdkxx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeSfglDwdkxx.getId())) {
			wuyeSfglDwdkxx = wuyeSfglDwdkxxService.getEntity(WuyeSfglDwdkxxEntity.class, wuyeSfglDwdkxx.getId());
			req.setAttribute("wuyeSfglDwdkxxPage", wuyeSfglDwdkxx);
		}
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglDwdkxx-add");
	}
	/**
	 * 单位代扣信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WuyeSfglDwdkxxEntity wuyeSfglDwdkxx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeSfglDwdkxx.getId())) {
			wuyeSfglDwdkxx = wuyeSfglDwdkxxService.getEntity(WuyeSfglDwdkxxEntity.class, wuyeSfglDwdkxx.getId());
			req.setAttribute("wuyeSfglDwdkxxPage", wuyeSfglDwdkxx);
		}
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglDwdkxx-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeSfglDwdkxxController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WuyeSfglDwdkxxEntity wuyeSfglDwdkxx,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		/**通过主表主键，查询出代扣主表信息*/
		WuyeSfglDwdkxxzbEntity dwdkxxzb = systemService.getEntity(WuyeSfglDwdkxxzbEntity.class,this.zbid);
		String year = dwdkxxzb.getYear();
		String month = dwdkxxzb.getMonth();
		String dkdw = dwdkxxzb.getDkdw();
		
		List<WuyeSfglDwdkxxEntity> wuyeSfglDwdkxxs = wuyeSfglDwdkxxjlDao.findByYearAndMonth(dwdkxxzb);
			
		//导出文件名称
		String fileName = year+"年"+month+"月"+dkdw+"单位缴费明细";
		modelMap.put(NormalExcelConstants.FILE_NAME,fileName);
		modelMap.put(NormalExcelConstants.CLASS,WuyeSfglDwdkxxEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams(fileName, "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wuyeSfglDwdkxxs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WuyeSfglDwdkxxEntity wuyeSfglDwdkxx,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"单位代扣信息");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeSfglDwdkxxEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("单位代扣信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		/**通过主表主键，查询出代扣主表信息*/
		WuyeSfglDwdkxxzbEntity dwdkxxzb = systemService.getEntity(WuyeSfglDwdkxxzbEntity.class,this.zbid);
		
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
				List<WuyeSfglDwdkxxEntity> listWuyeSfglDwdkxxEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeSfglDwdkxxEntity.class,params);
				
				
				//先删除这年这月的信息
				int s = wuyeSfglDwdkxxjlDao.deleteByYearAndMonthAndDkdw(dwdkxxzb);
				//System.out.println(s);
				String sfzt = "0";
				for (WuyeSfglDwdkxxEntity dwdkxx : listWuyeSfglDwdkxxEntitys) {
					//再增加
					wuyeSfglDwdkxxService.save(dwdkxx);
					//扣费成功了，就把收费状态改成银行代扣
					if("成功".equals(dwdkxx.getZt())){
						sfzt = "2";
					}
					//根据代扣单位工号，查询业主主键
					List<WuyeYzglFwyzxxEntity> fwyzxx = systemService.findByQueryString("from WuyeYzglFwyzxxEntity where dkr_dkdwgh ="+str+dwdkxx.getDkdwgh()+str);
					String fwyzxxid = fwyzxx.get(0).getId();
					//执行更新操作
					int i = wuyeSfglYsfyjlDao.updateDkxxzj(dwdkxx.getId(),dwdkxxzb.getYear(),dwdkxxzb.getMonth(),fwyzxxid,sfzt);
					
					
				}
				/**导入成功后，更新代扣主表信息*/
				dwdkxxzb.setSfyjdr("1");
				systemService.saveOrUpdate(dwdkxxzb);
				
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
	@ApiOperation(value="单位代扣信息列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WuyeSfglDwdkxxEntity>> list() {
		List<WuyeSfglDwdkxxEntity> listWuyeSfglDwdkxxs=wuyeSfglDwdkxxService.getList(WuyeSfglDwdkxxEntity.class);
		return Result.success(listWuyeSfglDwdkxxs);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取单位代扣信息信息",notes="根据ID获取单位代扣信息信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WuyeSfglDwdkxxEntity task = wuyeSfglDwdkxxService.get(WuyeSfglDwdkxxEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取单位代扣信息信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建单位代扣信息")
	public ResponseMessage<?> create(@ApiParam(name="单位代扣信息对象")@RequestBody WuyeSfglDwdkxxEntity wuyeSfglDwdkxx, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeSfglDwdkxxEntity>> failures = validator.validate(wuyeSfglDwdkxx);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeSfglDwdkxxService.save(wuyeSfglDwdkxx);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("单位代扣信息信息保存失败");
		}
		return Result.success(wuyeSfglDwdkxx);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新单位代扣信息",notes="更新单位代扣信息")
	public ResponseMessage<?> update(@ApiParam(name="单位代扣信息对象")@RequestBody WuyeSfglDwdkxxEntity wuyeSfglDwdkxx) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeSfglDwdkxxEntity>> failures = validator.validate(wuyeSfglDwdkxx);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeSfglDwdkxxService.saveOrUpdate(wuyeSfglDwdkxx);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新单位代扣信息信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新单位代扣信息信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除单位代扣信息")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wuyeSfglDwdkxxService.deleteEntityById(WuyeSfglDwdkxxEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("单位代扣信息删除失败");
		}

		return Result.success();
	}
}
