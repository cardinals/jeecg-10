package com.jeecg.wuyeyzgl.controller;
import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyeglq.service.WuyeFwxxServiceI;
import com.jeecg.wuyeyzgl.Dao.WuyeYzglFwqcglDao;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwqcglEntity;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwyzxxEntity;
import com.jeecg.wuyeyzgl.service.WuyeYzglFwqcglServiceI;
import com.jeecg.wuyeyzgl.service.WuyeYzglFwyzxxServiceI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;

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
 * @Description: 房屋迁出管理
 * @author onlineGenerator
 * @date 2018-03-16 14:19:29
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wuyeYzglFwqcglController")
@Api(value="WuyeYzglFwqcgl",description="房屋迁出管理",tags="wuyeYzglFwqcglController")
public class WuyeYzglFwqcglController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WuyeYzglFwqcglController.class);

	@Autowired
	private WuyeYzglFwqcglServiceI wuyeYzglFwqcglService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private WuyeFwxxServiceI wuyeFwxxService;
	@Autowired
	private WuyeYzglFwqcglDao wuyeYzglFwqcglDao;
	@Autowired
	private Validator validator;
	private String id;

	/**
	 * 房屋迁入管理列表 页面跳转
	 * @author GuoPeiZhi
	 * @return
	 */
	@RequestMapping(params = "ztree")
	public ModelAndView ztree(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/wuyeyzgl/wuyeYzglFwqcglZtree");
	}
	/**
	 * 房屋迁出管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		id = request.getParameter("id");
		return new ModelAndView("com/jeecg/wuyeyzgl/wuyeYzglFwqcglList");
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
	public void minidaoDatagrid(WuyeFwxxEntity entity,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid){
		if(id!=null||"".equals(id)){
			List<WuyeGlqEntity>  wuyeGlqEntityList = systemService.findByQueryString(" FROM WuyeGlqEntity WHERE id='"+id+"'");		
			String lx="";
			if("4".equals(wuyeGlqEntityList.get(0).getGlqlx()))lx="4";								
			if("3".equals(wuyeGlqEntityList.get(0).getGlqlx()))lx="3";
			if("2".equals(wuyeGlqEntityList.get(0).getGlqlx()))lx="2";
			List<WuyeFwxxEntity> wuye = wuyeYzglFwqcglDao.findByIdList(id,lx,entity);
			Integer count =wuyeYzglFwqcglDao.getCount(id,lx,entity);				
			dataGrid.setTotal(count);
			dataGrid.setResults(wuye);			
		}				
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除房屋迁出管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeYzglFwqcglEntity wuyeYzglFwqcgl, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeYzglFwqcgl = systemService.getEntity(WuyeYzglFwqcglEntity.class, wuyeYzglFwqcgl.getId());
		message = "房屋迁出管理删除成功";
		try{
			wuyeYzglFwqcglService.delete(wuyeYzglFwqcgl);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋迁出管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除房屋迁出管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房屋迁出管理删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeYzglFwqcglEntity wuyeYzglFwqcgl = systemService.getEntity(WuyeYzglFwqcglEntity.class, 
				id
				);
				wuyeYzglFwqcglService.delete(wuyeYzglFwqcgl);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋迁出管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加房屋迁出管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeYzglFwqcglEntity wuyeYzglFwqcgl, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房屋迁出管理添加成功";		
		try{	
			//更新房屋管理表
			systemService.updateBySqlString("update wuye_fwxx set fwzt='"+wuyeYzglFwqcgl.getQrhfjzt()+"' where id='"+wuyeYzglFwqcgl.getFwxxid()+"'");
			//更新业主表业
			systemService.updateBySqlString("update wuye_yzgl_fwyzxx  set glqid=NULL,fwxxid=NULL,fjid=NULL,yz_bm=NULL where id='"+wuyeYzglFwqcgl.getKhid()+"'");
			wuyeYzglFwqcglService.save(wuyeYzglFwqcgl);		
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋迁出管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	
	/**
	 * 房屋迁出管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WuyeFwxxEntity wuyeFwxx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeFwxx.getId())) {
			wuyeFwxx = wuyeFwxxService.getEntity(WuyeFwxxEntity.class, wuyeFwxx.getId());					
			List<WuyeYzglFwyzxxEntity> yzglFwyzxxList =  systemService.findByQueryString("from WuyeYzglFwyzxxEntity where fwxxid='"+wuyeFwxx.getId()+"'");
			if(yzglFwyzxxList.size()>0){
				req.setAttribute("yzglFwyzxxPage", yzglFwyzxxList.get(0));				
			}
			wuyeFwxx.setFwzt("xz");	
			req.setAttribute("wuyeFwxxPage", wuyeFwxx);
			req.setAttribute("qcrq",new DateUtils().getDate("yyyy-MM-dd"));
		}
		return new ModelAndView("com/jeecg/wuyeyzgl/wuyeYzglFwqcgl-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeYzglFwqcglController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WuyeYzglFwqcglEntity wuyeYzglFwqcgl,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WuyeYzglFwqcglEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeYzglFwqcgl, request.getParameterMap());
		List<WuyeYzglFwqcglEntity> wuyeYzglFwqcgls = this.wuyeYzglFwqcglService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"房屋迁出管理");
		modelMap.put(NormalExcelConstants.CLASS,WuyeYzglFwqcglEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("房屋迁出管理列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wuyeYzglFwqcgls);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WuyeYzglFwqcglEntity wuyeYzglFwqcgl,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"房屋迁出管理");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeYzglFwqcglEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("房屋迁出管理列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<WuyeYzglFwqcglEntity> listWuyeYzglFwqcglEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeYzglFwqcglEntity.class,params);
				for (WuyeYzglFwqcglEntity wuyeYzglFwqcgl : listWuyeYzglFwqcglEntitys) {
					wuyeYzglFwqcglService.save(wuyeYzglFwqcgl);
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
	@ApiOperation(value="房屋迁出管理列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WuyeYzglFwqcglEntity>> list() {
		List<WuyeYzglFwqcglEntity> listWuyeYzglFwqcgls=wuyeYzglFwqcglService.getList(WuyeYzglFwqcglEntity.class);
		return Result.success(listWuyeYzglFwqcgls);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取房屋迁出管理信息",notes="根据ID获取房屋迁出管理信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WuyeYzglFwqcglEntity task = wuyeYzglFwqcglService.get(WuyeYzglFwqcglEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取房屋迁出管理信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建房屋迁出管理")
	public ResponseMessage<?> create(@ApiParam(name="房屋迁出管理对象")@RequestBody WuyeYzglFwqcglEntity wuyeYzglFwqcgl, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeYzglFwqcglEntity>> failures = validator.validate(wuyeYzglFwqcgl);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeYzglFwqcglService.save(wuyeYzglFwqcgl);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("房屋迁出管理信息保存失败");
		}
		return Result.success(wuyeYzglFwqcgl);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新房屋迁出管理",notes="更新房屋迁出管理")
	public ResponseMessage<?> update(@ApiParam(name="房屋迁出管理对象")@RequestBody WuyeYzglFwqcglEntity wuyeYzglFwqcgl) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeYzglFwqcglEntity>> failures = validator.validate(wuyeYzglFwqcgl);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeYzglFwqcglService.saveOrUpdate(wuyeYzglFwqcgl);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新房屋迁出管理信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新房屋迁出管理信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除房屋迁出管理")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wuyeYzglFwqcglService.deleteEntityById(WuyeYzglFwqcglEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("房屋迁出管理删除失败");
		}

		return Result.success();
	}
}
