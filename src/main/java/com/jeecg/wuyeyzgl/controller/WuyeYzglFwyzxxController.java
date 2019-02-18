package com.jeecg.wuyeyzgl.controller;
import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyeglq.service.WuyeFwxxServiceI;
import com.jeecg.wuyeglq.service.WuyeGlqServiceI;
import com.jeecg.wuyesfgl.entity.WuyeSfglSfxmszEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjlPageEntity;
import com.jeecg.wuyeyzgl.Dao.WuyeYzglFwyzxxDao;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwyzxxEntity;
import com.jeecg.wuyeyzgl.service.WuyeYzglFwyzxxServiceI;
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
import org.hibernate.criterion.Criterion;
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
 * @Description: 房屋业主信息
 * @author onlineGenerator
 * @date 2018-03-12 16:02:58
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wuyeYzglFwyzxxController")
@Api(value="WuyeYzglFwyzxx",description="房屋业主信息",tags="wuyeYzglFwyzxxController")
public class WuyeYzglFwyzxxController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WuyeYzglFwyzxxController.class);

	@Autowired
	private WuyeYzglFwyzxxServiceI wuyeYzglFwyzxxService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private WuyeFwxxServiceI wuyeFwxxService;
	@Autowired
	private WuyeGlqServiceI wuyeGlqService;
	@Autowired
	private WuyeYzglFwyzxxDao wuyeYzglFwyzxxDao;

	/**
	 * 房屋业主信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		
		return new ModelAndView("com/jeecg/wuyeyzgl/wuyeYzglFwyzxxList");
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
	public void datagrid(WuyeYzglFwyzxxEntity wuyeYzglFwyzxx,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {		
		//查询数据
		List<WuyeYzglFwyzxxEntity> fwyzxx = wuyeYzglFwyzxxDao.findList(wuyeYzglFwyzxx); 
		
		//查询数据数量
		int count = wuyeYzglFwyzxxDao.findListCount(wuyeYzglFwyzxx); 
		
		dataGrid.setTotal(count);
		dataGrid.setResults(fwyzxx);
		TagUtil.datagrid(response, dataGrid);
	}
	
	
	
	
	/**
	 * 删除房屋业主信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeYzglFwyzxxEntity wuyeYzglFwyzxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeYzglFwyzxx = systemService.getEntity(WuyeYzglFwyzxxEntity.class, wuyeYzglFwyzxx.getId());
		wuyeYzglFwyzxx.setYxbz("0");//修改状态
		message = "房屋业主信息删除成功";
		WuyeYzglFwyzxxEntity t = wuyeYzglFwyzxxService.get(WuyeYzglFwyzxxEntity.class, wuyeYzglFwyzxx.getId());
		try{
			/*wuyeYzglFwyzxxService.delete(wuyeYzglFwyzxx);//自带的删除方法*/	
			//更改状态的删除方法
			MyBeanUtils.copyBeanNotNull2Bean(wuyeYzglFwyzxx, t);
			wuyeYzglFwyzxxService.saveOrUpdate(t);
			
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋业主信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除房屋业主信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房屋业主信息删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeYzglFwyzxxEntity wuyeYzglFwyzxx = systemService.getEntity(WuyeYzglFwyzxxEntity.class,id);
				wuyeYzglFwyzxx.setYxbz("0");//修改状态
				/*wuyeYzglFwyzxxService.delete(wuyeYzglFwyzxx);//自带的删除方法*/
				
				//执行修改状态删除
				wuyeYzglFwyzxxService.saveOrUpdate(wuyeYzglFwyzxx);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋业主信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加房屋业主信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeYzglFwyzxxEntity wuyeYzglFwyzxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房屋业主信息添加成功";
		try{
			wuyeYzglFwyzxx.setYxbz("1");//设置状态标志
			wuyeYzglFwyzxxService.save(wuyeYzglFwyzxx);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋业主信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新房屋业主信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WuyeYzglFwyzxxEntity wuyeYzglFwyzxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		
		message = "房屋业主信息更新成功";
		WuyeYzglFwyzxxEntity t = wuyeYzglFwyzxxService.get(WuyeYzglFwyzxxEntity.class, wuyeYzglFwyzxx.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wuyeYzglFwyzxx, t);
			wuyeYzglFwyzxxService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "房屋业主信息更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 房屋业主信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WuyeYzglFwyzxxEntity wuyeYzglFwyzxx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeYzglFwyzxx.getId())) {
			wuyeYzglFwyzxx = wuyeYzglFwyzxxService.getEntity(WuyeYzglFwyzxxEntity.class, wuyeYzglFwyzxx.getId());
			req.setAttribute("wuyeYzglFwyzxxPage", wuyeYzglFwyzxx);
		}
		return new ModelAndView("com/jeecg/wuyeyzgl/wuyeYzglFwyzxx-add");
	}
	/**
	 * 房屋业主信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WuyeYzglFwyzxxEntity wuyeYzglFwyzxx, HttpServletRequest req) {
		
		if (StringUtil.isNotEmpty(wuyeYzglFwyzxx.getId())) {
			wuyeYzglFwyzxx = wuyeYzglFwyzxxService.getEntity(WuyeYzglFwyzxxEntity.class, wuyeYzglFwyzxx.getId());
			
			//当存在房屋主键时候
			if(!wuyeYzglFwyzxx.getFwxxid().equals("")){
				//查询房屋编号
				WuyeFwxxEntity fwxx = wuyeFwxxService.getEntity(WuyeFwxxEntity.class, wuyeYzglFwyzxx.getFwxxid());
				req.setAttribute("fjbh", fwxx.getFjbh());
				//查询楼宇号
				WuyeGlqEntity glq = wuyeGlqService.get(WuyeGlqEntity.class, fwxx.getLyid());
				req.setAttribute("louyu", glq.getGlqmc());
			}
			
			req.setAttribute("wuyeYzglFwyzxxPage", wuyeYzglFwyzxx);
		}
		return new ModelAndView("com/jeecg/wuyeyzgl/wuyeYzglFwyzxx-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeYzglFwyzxxController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WuyeYzglFwyzxxEntity wuyeYzglFwyzxx,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WuyeYzglFwyzxxEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeYzglFwyzxx, request.getParameterMap());
		List<WuyeYzglFwyzxxEntity> wuyeYzglFwyzxxs = this.wuyeYzglFwyzxxService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"房屋业主信息");
		modelMap.put(NormalExcelConstants.CLASS,WuyeYzglFwyzxxEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("房屋业主信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wuyeYzglFwyzxxs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WuyeYzglFwyzxxEntity wuyeYzglFwyzxx,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"房屋业主信息");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeYzglFwyzxxEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("房屋业主信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<WuyeYzglFwyzxxEntity> listWuyeYzglFwyzxxEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeYzglFwyzxxEntity.class,params);
				for (WuyeYzglFwyzxxEntity wuyeYzglFwyzxx : listWuyeYzglFwyzxxEntitys) {
					//当房屋主键不存在时候
					if(wuyeYzglFwyzxx.getFwxxid().equals("") || wuyeYzglFwyzxx.getFwxxid() == null){
						//根据房间id查询房屋主键
						if(wuyeYzglFwyzxx.getFjid() != null || wuyeYzglFwyzxx.getFjid().equals("")){
							List<WuyeFwxxEntity> wuyefwxxList = systemService.findByQueryString("from WuyeFwxxEntity w where w.fjid ="+wuyeYzglFwyzxx.getFjid());
							System.out.println(wuyefwxxList.get(0).getId());
							wuyeYzglFwyzxx.setFwxxid(wuyefwxxList.get(0).getId());
						}
					}
					wuyeYzglFwyzxxService.save(wuyeYzglFwyzxx);
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
	@ApiOperation(value="房屋业主信息列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WuyeYzglFwyzxxEntity>> list() {
		List<WuyeYzglFwyzxxEntity> listWuyeYzglFwyzxxs=wuyeYzglFwyzxxService.getList(WuyeYzglFwyzxxEntity.class);
		return Result.success(listWuyeYzglFwyzxxs);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取房屋业主信息信息",notes="根据ID获取房屋业主信息信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WuyeYzglFwyzxxEntity task = wuyeYzglFwyzxxService.get(WuyeYzglFwyzxxEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取房屋业主信息信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建房屋业主信息")
	public ResponseMessage<?> create(@ApiParam(name="房屋业主信息对象")@RequestBody WuyeYzglFwyzxxEntity wuyeYzglFwyzxx, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeYzglFwyzxxEntity>> failures = validator.validate(wuyeYzglFwyzxx);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeYzglFwyzxxService.save(wuyeYzglFwyzxx);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("房屋业主信息信息保存失败");
		}
		return Result.success(wuyeYzglFwyzxx);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新房屋业主信息",notes="更新房屋业主信息")
	public ResponseMessage<?> update(@ApiParam(name="房屋业主信息对象")@RequestBody WuyeYzglFwyzxxEntity wuyeYzglFwyzxx) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeYzglFwyzxxEntity>> failures = validator.validate(wuyeYzglFwyzxx);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeYzglFwyzxxService.saveOrUpdate(wuyeYzglFwyzxx);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新房屋业主信息信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新房屋业主信息信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除房屋业主信息")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wuyeYzglFwyzxxService.deleteEntityById(WuyeYzglFwyzxxEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("房屋业主信息删除失败");
		}

		return Result.success();
	}
	/**
	 * 验证输入的银行账号是否存在
	 * */
	@ResponseBody
	@RequestMapping(params = "existence")
	public String existence(String fwyzid,String yhzh, HttpServletRequest req) {
		String str1 = "'";
		String str2 = "'";
		String str = "from WuyeYzglFwyzxxEntity where dkrDkyhzh = "+str1+yhzh+str2+"and id <> "+str1+fwyzid+str2;
		//先查询房屋信息
		List<WuyeYzglFwyzxxEntity> fwyzxx = systemService.findByQueryString(str);
		//当查不到时候
		if(fwyzxx.isEmpty()){
			return "success";
		}else{
			return "err";
		}
		
	}
	
}
