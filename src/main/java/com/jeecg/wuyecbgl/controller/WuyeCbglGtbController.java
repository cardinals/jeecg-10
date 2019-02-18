package com.jeecg.wuyecbgl.controller;
import com.jeecg.wuyecbgl.entity.WuyeCbglFjbEntity;
import com.jeecg.wuyecbgl.entity.WuyeCbglGtbEntity;
import com.jeecg.wuyecbgl.service.WuyeCbglGtbServiceI;
import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyesfgl.dao.WuyeSfglFjsfxmszDao;

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
 * @Description: 公摊表管理
 * @author onlineGenerator
 * @date 2018-03-22 15:02:57
 * @version V1.0   
 *
 */
@Api(value="WuyeCbglGtb",description="公摊表管理",tags="wuyeCbglGtbController")
@Controller
@RequestMapping("/wuyeCbglGtbController")
public class WuyeCbglGtbController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WuyeCbglGtbController.class);

	@Autowired
	private WuyeCbglGtbServiceI wuyeCbglGtbService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private WuyeSfglFjsfxmszDao wuyeSfglFjsfxmszDao;	
	private String lyid;
	private String yblx;
	private String gtbid;
	
	/**
	 * 公摊表管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/wuyecbgl/wuyeCbglGtbList");
	}
	
	@RequestMapping(params = "list_ly")
	public ModelAndView list_ly(HttpServletRequest request) {
		this.lyid = request.getParameter("id");
		return new ModelAndView("com/jeecg/wuyecbgl/wuyeCbglGtbList_fjb_ly");
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
	public void datagrid(WuyeCbglGtbEntity wuyeCbglGtb,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WuyeCbglGtbEntity.class, dataGrid);
		//查询条件组装器		
		try{
		//自定义追加查询条件
			cq.notEq("yxbz", "0");
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeCbglGtb, request.getParameterMap());
		this.wuyeCbglGtbService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	@RequestMapping(params = "datagrid_ly")
	public void datagrid_ly(WuyeCbglFjbEntity wuyeCbglFjb,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
/*		CriteriaQuery cq = new CriteriaQuery(WuyeCbglFjbEntity.class, dataGrid);
		//查询条件组装器		
		try{
		//自定义追加查询条件
			cq.notEq("yxbz", "0");
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeCbglFjb, request.getParameterMap());
		this.wuyeCbglFjbService.getDataGridReturn(cq, true);*/
		List<WuyeFwxxEntity> wuyeFwxxList = this.systemService.findHql("from WuyeFwxxEntity where yxbz = '1' and lyid = '"+lyid+"'");
		List<WuyeCbglFjbEntity> WuyeCbglFjbEntity = this.systemService.findHql("from WuyeCbglFjbEntity where yxbz = '1' and yblx = '"+yblx+"'");
		List<WuyeCbglFjbEntity> wuyeCbglFjbEntity1 = new ArrayList<WuyeCbglFjbEntity>();
		for (WuyeFwxxEntity wuyeFwxxEntity : wuyeFwxxList) {
			for (WuyeCbglFjbEntity wuyeCbglFjbEntity : WuyeCbglFjbEntity) {
				if(wuyeCbglFjbEntity.getFjid() == wuyeFwxxEntity.getFjid().intValue()){
					wuyeCbglFjbEntity1.add(wuyeCbglFjbEntity);
				}
			}
		}
		dataGrid.setTotal(wuyeCbglFjbEntity1.size());
		dataGrid.setResults(wuyeCbglFjbEntity1);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除公摊表管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeCbglGtbEntity wuyeCbglGtb, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeCbglGtb = systemService.getEntity(WuyeCbglGtbEntity.class, wuyeCbglGtb.getId());
		wuyeCbglGtb.setYxbz("0");
		message = "公摊表管理删除成功";
		try{
			/*wuyeCbglGtbService.delete(wuyeCbglGtb);*/
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "公摊表管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除公摊表管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "公摊表管理删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeCbglGtbEntity wuyeCbglGtb = systemService.getEntity(WuyeCbglGtbEntity.class, id);
				wuyeCbglGtb.setYxbz("0");
				/*wuyeCbglGtbService.delete(wuyeCbglGtb);*/
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "公摊表管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	 
		/**
		 * 批量再房间表添加公摊ID管理
		 * 
		 * @return
		 */
		 @RequestMapping(params = "doPl")
		@ResponseBody
		public AjaxJson doPl(String ids,HttpServletRequest request){
			String message = null;
			AjaxJson j = new AjaxJson();
			message = "修改成功";
			try{
				for(String id:ids.split(",")){
					WuyeCbglFjbEntity WuyeCbglFjb = systemService.getEntity(WuyeCbglFjbEntity.class, id);
					WuyeCbglFjb.setGtbid(gtbid);
					systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
				}
			}catch(Exception e){
				e.printStackTrace();
				message = "修改失败";
				throw new BusinessException(e.getMessage());
			}
			j.setMsg(message);
			return j;
		}
	 

	/**
	 * 添加公摊表管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeCbglGtbEntity wuyeCbglGtb, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "公摊表管理添加成功";
		try{
			wuyeCbglGtb.setYxbz("1");
			wuyeCbglGtbService.save(wuyeCbglGtb);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "公摊表管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新公摊表管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WuyeCbglGtbEntity wuyeCbglGtb, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "公摊表管理更新成功";
		WuyeCbglGtbEntity t = wuyeCbglGtbService.get(WuyeCbglGtbEntity.class, wuyeCbglGtb.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wuyeCbglGtb, t);
			wuyeCbglGtbService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "公摊表管理更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 公摊表管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WuyeCbglGtbEntity wuyeCbglGtb, HttpServletRequest req) {
		//查询管理区表
		List<WuyeGlqEntity> glqList = wuyeSfglFjsfxmszDao.findGlqList(); 
		req.setAttribute("glqList", glqList);		
		if (StringUtil.isNotEmpty(wuyeCbglGtb.getId())) {
			wuyeCbglGtb = wuyeCbglGtbService.getEntity(WuyeCbglGtbEntity.class, wuyeCbglGtb.getId());
			req.setAttribute("wuyeCbglGtbPage", wuyeCbglGtb);
		}
		return new ModelAndView("com/jeecg/wuyecbgl/wuyeCbglGtb-add");
	}
	/**
	 * 公摊表管理批量页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goPl")
	public ModelAndView goPl(HttpServletRequest request) {
		this.yblx = request.getParameter("yblx");
		this.gtbid = request.getParameter("gtbid");
		return new ModelAndView("com/jeecg/wuyecbgl/wuyeCbglGtb-pl");
	}
	/**
	 * 公摊表管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WuyeCbglGtbEntity wuyeCbglGtb, HttpServletRequest req) {
		//查询管理区表
		List<WuyeGlqEntity> glqList = wuyeSfglFjsfxmszDao.findGlqList(); 
		req.setAttribute("glqList", glqList);		
		if (StringUtil.isNotEmpty(wuyeCbglGtb.getId())) {
			wuyeCbglGtb = wuyeCbglGtbService.getEntity(WuyeCbglGtbEntity.class, wuyeCbglGtb.getId());
			req.setAttribute("wuyeCbglGtbPage", wuyeCbglGtb);
		}
		return new ModelAndView("com/jeecg/wuyecbgl/wuyeCbglGtb-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeCbglGtbController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WuyeCbglGtbEntity wuyeCbglGtb,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WuyeCbglGtbEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeCbglGtb, request.getParameterMap());
		List<WuyeCbglGtbEntity> wuyeCbglGtbs = this.wuyeCbglGtbService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"公摊表管理");
		modelMap.put(NormalExcelConstants.CLASS,WuyeCbglGtbEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("公摊表管理列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wuyeCbglGtbs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WuyeCbglGtbEntity wuyeCbglGtb,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"公摊表管理");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeCbglGtbEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("公摊表管理列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<WuyeCbglGtbEntity> listWuyeCbglGtbEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeCbglGtbEntity.class,params);
				for (WuyeCbglGtbEntity wuyeCbglGtb : listWuyeCbglGtbEntitys) {
					wuyeCbglGtbService.save(wuyeCbglGtb);
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
	@ApiOperation(value="公摊表管理列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WuyeCbglGtbEntity>> list() {
		List<WuyeCbglGtbEntity> listWuyeCbglGtbs=wuyeCbglGtbService.getList(WuyeCbglGtbEntity.class);
		return Result.success(listWuyeCbglGtbs);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取公摊表管理信息",notes="根据ID获取公摊表管理信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WuyeCbglGtbEntity task = wuyeCbglGtbService.get(WuyeCbglGtbEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取公摊表管理信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建公摊表管理")
	public ResponseMessage<?> create(@ApiParam(name="公摊表管理对象")@RequestBody WuyeCbglGtbEntity wuyeCbglGtb, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeCbglGtbEntity>> failures = validator.validate(wuyeCbglGtb);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeCbglGtbService.save(wuyeCbglGtb);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("公摊表管理信息保存失败");
		}
		return Result.success(wuyeCbglGtb);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新公摊表管理",notes="更新公摊表管理")
	public ResponseMessage<?> update(@ApiParam(name="公摊表管理对象")@RequestBody WuyeCbglGtbEntity wuyeCbglGtb) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeCbglGtbEntity>> failures = validator.validate(wuyeCbglGtb);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeCbglGtbService.saveOrUpdate(wuyeCbglGtb);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新公摊表管理信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新公摊表管理信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除公摊表管理")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wuyeCbglGtbService.deleteEntityById(WuyeCbglGtbEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("公摊表管理删除失败");
		}

		return Result.success();
	}
	
	@RequestMapping(params="getTreeData",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getMyTreeData(HttpServletResponse response,HttpServletRequest request ){
		AjaxJson j = new AjaxJson();
		List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
		try{
				StringBuffer hql = new StringBuffer(" from WuyeGlqEntity w where  w.yxbz <> 0");			
				List<WuyeGlqEntity> departList = this.systemService.findHql(hql.toString());
				populateTree(departList,dataList);		
		}catch(Exception e){
			e.printStackTrace();
		}
		j.setObj(dataList);
		return j;
	}

	private void populateTree(List<WuyeGlqEntity> wuyeglq,List<Map<String,Object>> dataList){
		Map<String,Object> map = null;
		if(wuyeglq!=null&&wuyeglq.size()>0){
			for(WuyeGlqEntity wuyeGlqEntity :wuyeglq){
				map = new HashMap<String,Object>();
				map.put("chkDisabled",false);
				map.put("click", true);
				map.put("id", wuyeGlqEntity.getId());
				map.put("name", wuyeGlqEntity.getGlqmc());
				map.put("nocheck", false);
				map.put("struct","TREE");
				map.put("title",wuyeGlqEntity.getGlqmc());
				map.put("glqlx", wuyeGlqEntity.getGlqlx());
				map.put("pxh", wuyeGlqEntity.getPxh());
				
				//判断是否有子节点
				if (wuyeGlqEntity.getFid() != null) {
					map.put("parentId",wuyeGlqEntity.getFid());
				}else {
					map.put("parentId","0");
				}
				 if("1".equals(wuyeGlqEntity.getGlqlx())){
					 map.put("icon","plug-in/ztree/css/img/diy/wuyegongsi.png");
				 }else if("2".equals(wuyeGlqEntity.getGlqlx())){
					 map.put("icon","plug-in/ztree/css/img/diy/guanqu.png");
				 }else if("3".equals(wuyeGlqEntity.getGlqlx())){
					 map.put("icon","plug-in/ztree/css/img/diy/xiaoqu.png");
				 }else if("4".equals(wuyeGlqEntity.getGlqlx())){
					 map.put("icon","plug-in/ztree/css/img/diy/louyu.png");
				 }
				dataList.add(map);
			}
		}
	}
	
}



