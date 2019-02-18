package com.jeecg.wuyesfgl.controller;
import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyesfgl.dao.WuyeSfglFjsfxmszDao;
import com.jeecg.wuyesfgl.entity.WuyeSfFjsfxmszPageEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglFjsfxmszEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglSfxmszEntity;
import com.jeecg.wuyesfgl.service.WuyeSfglFjsfxmszServiceI;
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
import org.apache.ibatis.annotations.Param;
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
 * @Description: 房间收费项目设置
 * @author onlineGenerator
 * @date 2018-03-17 10:09:06
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wuyeSfglFjsfxmszController")
@Api(value="WuyeSfglFjsfxmsz",description="房间收费项目设置",tags="wuyeSfglFjsfxmszController")
public class WuyeSfglFjsfxmszController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WuyeSfglFjsfxmszController.class);

	@Autowired
	private WuyeSfglFjsfxmszServiceI wuyeSfglFjsfxmszService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private WuyeSfglFjsfxmszDao wuyeSfglFjsfxmszDao;


	/**
	 * 房间收费项目设置列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/wuyesfgl/wuyesfgltree");
	}
	
	
	/**
	 * 房间收费项目设置列表 页面跳转(二级页面)
	 * 
	 * @return
	 */
	@RequestMapping(params = "list2")
	public ModelAndView list2(HttpServletRequest request , String id) {
		request.setAttribute("fjid", id);
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglFjsfxmszList");
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
	
	public void datagrid(int fjid,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//System.out.println(fjid);
		//查询数据
		List<WuyeSfFjsfxmszPageEntity> fjsfxmsz = wuyeSfglFjsfxmszDao.findList(fjid); 
		//System.out.println("................"+fjsfxmsz);
		//查询数量
		int count = wuyeSfglFjsfxmszDao.findListCount(fjid);
		
		dataGrid.setTotal(count);
		dataGrid.setResults(fjsfxmsz);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除房间收费项目设置
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeSfglFjsfxmszEntity wuyeSfglFjsfxmsz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeSfglFjsfxmsz = systemService.getEntity(WuyeSfglFjsfxmszEntity.class, wuyeSfglFjsfxmsz.getId());
		message = "房间收费项目设置删除成功";
		try{
			wuyeSfglFjsfxmszService.delete(wuyeSfglFjsfxmsz);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房间收费项目设置删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除房间收费项目设置
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房间收费项目设置删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeSfglFjsfxmszEntity wuyeSfglFjsfxmsz = systemService.getEntity(WuyeSfglFjsfxmszEntity.class, 
				id
				);
				wuyeSfglFjsfxmszService.delete(wuyeSfglFjsfxmsz);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "房间收费项目设置删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加房间收费项目设置
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeSfglFjsfxmszEntity wuyeSfglFjsfxmsz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房间收费项目设置添加成功";
		try{
			//先查询待添加的房间是否存在此收费项目，避免重复添加
			List<WuyeSfglFjsfxmszEntity> fj = wuyeSfglFjsfxmszDao.findsfxmszListIs(wuyeSfglFjsfxmsz);
			if(fj.isEmpty()){
				wuyeSfglFjsfxmszService.save(wuyeSfglFjsfxmsz);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				message = "收费项目设置添加成功";
			}else{
				//System.err.println("此房间已经存在该收费项目，请不要重复添加");
				message = "此房间已经存在该收费项目，请不要重复添加！";
			}
			//wuyeSfglFjsfxmszService.save(wuyeSfglFjsfxmsz);
			//systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房间收费项目设置添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新房间收费项目设置
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WuyeSfglFjsfxmszEntity wuyeSfglFjsfxmsz, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房间收费项目设置更新成功";
		WuyeSfglFjsfxmszEntity t = wuyeSfglFjsfxmszService.get(WuyeSfglFjsfxmszEntity.class, wuyeSfglFjsfxmsz.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wuyeSfglFjsfxmsz, t);
			wuyeSfglFjsfxmszService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "房间收费项目设置更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 房间收费项目设置新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WuyeSfglFjsfxmszEntity wuyeSfglFjsfxmsz, HttpServletRequest req,int fjid) {
		//先查询房屋信息
		List<WuyeFwxxEntity> wuyefwxx = systemService.findByQueryString("from WuyeFwxxEntity w where w.fjid = "+ fjid+"and yxbz='1' ");
		//System.out.println(wuyefwxx.get(0));
		req.setAttribute("wuyefwxx", wuyefwxx.get(0));
		//查询收费类型
		List<WuyeSfglSfxmszEntity> sfxmszList = systemService.findByQueryString("from WuyeSfglSfxmszEntity"); 
		//System.out.println(sfxmszList);
		req.setAttribute("sfxmszList", sfxmszList);
		if (StringUtil.isNotEmpty(wuyeSfglFjsfxmsz.getId())) {
			wuyeSfglFjsfxmsz = wuyeSfglFjsfxmszService.getEntity(WuyeSfglFjsfxmszEntity.class, wuyeSfglFjsfxmsz.getId());
			req.setAttribute("wuyeSfglFjsfxmszPage", wuyeSfglFjsfxmsz);
		}
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglFjsfxmsz-add");
	}
	/**
	 * 房间收费项目设置编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WuyeSfglFjsfxmszEntity wuyeSfglFjsfxmsz, HttpServletRequest req,int fjid) {
		//先查询房屋信息
		List<WuyeFwxxEntity> wuyefwxx = systemService.findByQueryString("from WuyeFwxxEntity w where w.fjid = "+ fjid);
		req.setAttribute("wuyefwxx", wuyefwxx.get(0));
		//查询收费类型
		List<WuyeSfglSfxmszEntity> sfxmszList = systemService.findByQueryString("from WuyeSfglSfxmszEntity"); 
		req.setAttribute("sfxmszList", sfxmszList);
		if (StringUtil.isNotEmpty(wuyeSfglFjsfxmsz.getId())) {
			wuyeSfglFjsfxmsz = wuyeSfglFjsfxmszService.getEntity(WuyeSfglFjsfxmszEntity.class, wuyeSfglFjsfxmsz.getId());
			req.setAttribute("wuyeSfglFjsfxmszPage", wuyeSfglFjsfxmsz);
		}
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglFjsfxmsz-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeSfglFjsfxmszController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WuyeSfglFjsfxmszEntity wuyeSfglFjsfxmsz,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WuyeSfglFjsfxmszEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeSfglFjsfxmsz, request.getParameterMap());
		List<WuyeSfglFjsfxmszEntity> wuyeSfglFjsfxmszs = this.wuyeSfglFjsfxmszService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"房间收费项目设置");
		modelMap.put(NormalExcelConstants.CLASS,WuyeSfglFjsfxmszEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("房间收费项目设置列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wuyeSfglFjsfxmszs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WuyeSfglFjsfxmszEntity wuyeSfglFjsfxmsz,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"房间收费项目设置");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeSfglFjsfxmszEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("房间收费项目设置列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<WuyeSfglFjsfxmszEntity> listWuyeSfglFjsfxmszEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeSfglFjsfxmszEntity.class,params);
				for (WuyeSfglFjsfxmszEntity wuyeSfglFjsfxmsz : listWuyeSfglFjsfxmszEntitys) {
					wuyeSfglFjsfxmszService.save(wuyeSfglFjsfxmsz);
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
	@ApiOperation(value="房间收费项目设置列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WuyeSfglFjsfxmszEntity>> list() {
		List<WuyeSfglFjsfxmszEntity> listWuyeSfglFjsfxmszs=wuyeSfglFjsfxmszService.getList(WuyeSfglFjsfxmszEntity.class);
		return Result.success(listWuyeSfglFjsfxmszs);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取房间收费项目设置信息",notes="根据ID获取房间收费项目设置信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WuyeSfglFjsfxmszEntity task = wuyeSfglFjsfxmszService.get(WuyeSfglFjsfxmszEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取房间收费项目设置信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建房间收费项目设置")
	public ResponseMessage<?> create(@ApiParam(name="房间收费项目设置对象")@RequestBody WuyeSfglFjsfxmszEntity wuyeSfglFjsfxmsz, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeSfglFjsfxmszEntity>> failures = validator.validate(wuyeSfglFjsfxmsz);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeSfglFjsfxmszService.save(wuyeSfglFjsfxmsz);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("房间收费项目设置信息保存失败");
		}
		return Result.success(wuyeSfglFjsfxmsz);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新房间收费项目设置",notes="更新房间收费项目设置")
	public ResponseMessage<?> update(@ApiParam(name="房间收费项目设置对象")@RequestBody WuyeSfglFjsfxmszEntity wuyeSfglFjsfxmsz) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeSfglFjsfxmszEntity>> failures = validator.validate(wuyeSfglFjsfxmsz);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeSfglFjsfxmszService.saveOrUpdate(wuyeSfglFjsfxmsz);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新房间收费项目设置信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新房间收费项目设置信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除房间收费项目设置")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wuyeSfglFjsfxmszService.deleteEntityById(WuyeSfglFjsfxmszEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("房间收费项目设置删除失败");
		}

		return Result.success();
	}
}
