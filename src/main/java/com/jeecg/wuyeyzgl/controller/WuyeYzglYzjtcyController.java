package com.jeecg.wuyeyzgl.controller;
import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwyzxxEntity;
import com.jeecg.wuyeyzgl.entity.WuyeYzglYzjtcyEntity;
import com.jeecg.wuyeyzgl.service.WuyeYzglFwyzxxServiceI;
import com.jeecg.wuyeyzgl.service.WuyeYzglYzjtcyServiceI;
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
 * @Description: 业主家庭成员管理
 * @author onlineGenerator
 * @date 2018-03-15 10:27:38
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wuyeYzglYzjtcyController")
@Api(value="WuyeYzglYzjtcy",description="业主家庭成员管理",tags="wuyeYzglYzjtcyController")
public class WuyeYzglYzjtcyController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WuyeYzglYzjtcyController.class);

	@Autowired
	private WuyeYzglYzjtcyServiceI wuyeYzglYzjtcyService;
	@Autowired
	private WuyeYzglFwyzxxServiceI wuyeYzglFwyzxxService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	private String id;
	private String glqid;
	private String fwxxid;
	private String fwyzxxid;
	
	/**
	 * 业主家庭成员管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		this.id = request.getParameter("id");
		this.glqid = request.getParameter("glqid");
		this.fwxxid = request.getParameter("fwxxid");
		this.fwyzxxid = request.getParameter("fwyzxxid");
		return new ModelAndView("com/jeecg/wuyeyzgl/wuyeYzglYzjtcyList");
	}
	
	@RequestMapping(params = "list1")
	public ModelAndView list1(HttpServletRequest request) {
		this.id = request.getParameter("id");
		return new ModelAndView("com/jeecg/wuyeyzgl/wuyeYzglYzjtcyList1");
	}
	
	@RequestMapping(params = "ztree")
	public ModelAndView ztree(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/wuyeyzgl/wuyeYzglYzjtcyZtree");
	}
	
	/**
	 * 机构管理zTree
	 * @author GuoPeiZhi
	 * @param functionGroup
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(params="getTreeData",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getMyTreeData(HttpServletResponse response,HttpServletRequest request ){
		AjaxJson j = new AjaxJson();
		List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
		try{
				StringBuffer hql = new StringBuffer(" from WuyeGlqEntity w where  w.yxbz <> 0 order by w.pxh");			
				List<WuyeGlqEntity> departList = this.systemService.findHql(hql.toString());				
				populateTree(departList,dataList);						
		}catch(Exception e){
			e.printStackTrace();
		}
		j.setObj(dataList);
		return j;
	}
	/**zTree
	 * @author GuoPeiZhi
	 * @param wuyeglq
	 * @param dataList
	 */
	private void populateTree(List<WuyeGlqEntity> wuyeglq, List<Map<String,Object>> dataList){		
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
				map.put("pxh", wuyeGlqEntity.getPxh());
				map.put("glqlx", wuyeGlqEntity.getGlqlx());
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
				List<WuyeFwxxEntity> wuyeFwxxList = this.systemService.findHql("from WuyeFwxxEntity w where w.yxbz = '1' order by w.fjbh ");
				if(wuyeFwxxList!=null&&wuyeFwxxList.size()>0){
						for(WuyeFwxxEntity wuyeFwxxEntity:wuyeFwxxList){
							if(wuyeGlqEntity.getId().equals(wuyeFwxxEntity.getLyid())){
								map = new HashMap<String,Object>();
								map.put("chkDisabled",false);
								map.put("click", true);
								map.put("id", wuyeFwxxEntity.getFjid());
								map.put("name", wuyeFwxxEntity.getFjbh());
								map.put("nocheck", false);
								map.put("struct","TREE");
								map.put("title",wuyeFwxxEntity.getFjbh());
								map.put("pxh", wuyeFwxxEntity.getPxh());
								map.put("icon","");
								if (wuyeFwxxEntity.getLyid() != null) {
									map.put("parentId",wuyeFwxxEntity.getLyid());
								}else {
									map.put("parentId","0");
								}
								dataList.add(map);
							}
						}
					}
			}
		}
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
	public void datagrid(WuyeYzglYzjtcyEntity wuyeYzglYzjtcy,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WuyeYzglYzjtcyEntity.class, dataGrid);
		//查询条件组装器
		
		try{
		//自定义追加查询条件
			wuyeYzglYzjtcy.setFjid(Integer.parseInt(id));//匹配房间
			wuyeYzglYzjtcy.setFwyzxxid(fwyzxxid);//匹配业主
			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeYzglYzjtcy, request.getParameterMap());
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wuyeYzglYzjtcyService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除业主家庭成员管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeYzglYzjtcyEntity wuyeYzglYzjtcy, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeYzglYzjtcy = systemService.getEntity(WuyeYzglYzjtcyEntity.class, wuyeYzglYzjtcy.getId());
		message = "业主家庭成员管理删除成功";
		try{
			wuyeYzglYzjtcyService.delete(wuyeYzglYzjtcy);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "业主家庭成员管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除业主家庭成员管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "业主家庭成员管理删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeYzglYzjtcyEntity wuyeYzglYzjtcy = systemService.getEntity(WuyeYzglYzjtcyEntity.class, 
				id
				);
				wuyeYzglYzjtcyService.delete(wuyeYzglYzjtcy);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "业主家庭成员管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加业主家庭成员管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeYzglYzjtcyEntity wuyeYzglYzjtcy, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "业主家庭成员管理添加成功";
		try{		
			wuyeYzglYzjtcy.setGlqid(glqid);
			wuyeYzglYzjtcy.setFjid(Integer.parseInt(id));
			wuyeYzglYzjtcy.setFwxxid(fwxxid);
			wuyeYzglYzjtcy.setFwyzxxid(fwyzxxid);
			wuyeYzglYzjtcyService.save(wuyeYzglYzjtcy);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "业主家庭成员管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新业主家庭成员管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WuyeYzglYzjtcyEntity wuyeYzglYzjtcy, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "业主家庭成员管理更新成功";
		WuyeYzglYzjtcyEntity t = wuyeYzglYzjtcyService.get(WuyeYzglYzjtcyEntity.class, wuyeYzglYzjtcy.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wuyeYzglYzjtcy, t);
			wuyeYzglYzjtcyService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "业主家庭成员管理更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 业主家庭成员管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WuyeYzglYzjtcyEntity wuyeYzglYzjtcy, HttpServletRequest req) {
		wuyeYzglYzjtcy.setGlqid(glqid);
		wuyeYzglYzjtcy.setFjid(Integer.parseInt(id));
		wuyeYzglYzjtcy.setFwxxid(fwxxid);
		wuyeYzglYzjtcy.setFwyzxxid(req.getParameter("fwyzxxid"));
		if (StringUtil.isNotEmpty(wuyeYzglYzjtcy.getId())) {
			wuyeYzglYzjtcy = wuyeYzglYzjtcyService.getEntity(WuyeYzglYzjtcyEntity.class, wuyeYzglYzjtcy.getId());
		}
		req.setAttribute("wuyeYzglYzjtcyPage", wuyeYzglYzjtcy);
		return new ModelAndView("com/jeecg/wuyeyzgl/wuyeYzglYzjtcy-add");
	}
	/**
	 * 业主家庭成员管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WuyeYzglYzjtcyEntity wuyeYzglYzjtcy, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeYzglYzjtcy.getId())) {
			wuyeYzglYzjtcy = wuyeYzglYzjtcyService.getEntity(WuyeYzglYzjtcyEntity.class, wuyeYzglYzjtcy.getId());
			req.setAttribute("wuyeYzglYzjtcyPage", wuyeYzglYzjtcy);
		}
		return new ModelAndView("com/jeecg/wuyeyzgl/wuyeYzglYzjtcy-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeYzglYzjtcyController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WuyeYzglYzjtcyEntity wuyeYzglYzjtcy,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WuyeYzglYzjtcyEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeYzglYzjtcy, request.getParameterMap());
		List<WuyeYzglYzjtcyEntity> wuyeYzglYzjtcys = this.wuyeYzglYzjtcyService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"业主家庭成员管理");
		modelMap.put(NormalExcelConstants.CLASS,WuyeYzglYzjtcyEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("业主家庭成员管理列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wuyeYzglYzjtcys);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WuyeYzglYzjtcyEntity wuyeYzglYzjtcy,HttpServletRequest request,HttpServletResponse response, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"业主家庭成员管理");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeYzglYzjtcyEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("业主家庭成员管理列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),"导出信息"));
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
				List<WuyeYzglYzjtcyEntity> listWuyeYzglYzjtcyEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeYzglYzjtcyEntity.class,params);
				for (WuyeYzglYzjtcyEntity wuyeYzglYzjtcy : listWuyeYzglYzjtcyEntitys) {
					List<WuyeYzglFwyzxxEntity> fwxx = systemService.findHql("from WuyeYzglFwyzxxEntity where fjid = '"+wuyeYzglYzjtcy.getFjid()+"' and yxbz = '1'");
					wuyeYzglYzjtcy.setGlqid(fwxx.get(0).getGlqid());
					wuyeYzglYzjtcy.setFwxxid(fwxx.get(0).getFwxxid());
					wuyeYzglYzjtcyService.save(wuyeYzglYzjtcy);
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
	@ApiOperation(value="业主家庭成员管理列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WuyeYzglYzjtcyEntity>> list() {
		List<WuyeYzglYzjtcyEntity> listWuyeYzglYzjtcys=wuyeYzglYzjtcyService.getList(WuyeYzglYzjtcyEntity.class);
		return Result.success(listWuyeYzglYzjtcys);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取业主家庭成员管理信息",notes="根据ID获取业主家庭成员管理信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WuyeYzglYzjtcyEntity task = wuyeYzglYzjtcyService.get(WuyeYzglYzjtcyEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取业主家庭成员管理信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建业主家庭成员管理")
	public ResponseMessage<?> create(@ApiParam(name="业主家庭成员管理对象")@RequestBody WuyeYzglYzjtcyEntity wuyeYzglYzjtcy, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeYzglYzjtcyEntity>> failures = validator.validate(wuyeYzglYzjtcy);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeYzglYzjtcyService.save(wuyeYzglYzjtcy);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("业主家庭成员管理信息保存失败");
		}
		return Result.success(wuyeYzglYzjtcy);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新业主家庭成员管理",notes="更新业主家庭成员管理")
	public ResponseMessage<?> update(@ApiParam(name="业主家庭成员管理对象")@RequestBody WuyeYzglYzjtcyEntity wuyeYzglYzjtcy) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeYzglYzjtcyEntity>> failures = validator.validate(wuyeYzglYzjtcy);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeYzglYzjtcyService.saveOrUpdate(wuyeYzglYzjtcy);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新业主家庭成员管理信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新业主家庭成员管理信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除业主家庭成员管理")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wuyeYzglYzjtcyService.deleteEntityById(WuyeYzglYzjtcyEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("业主家庭成员管理删除失败");
		}

		return Result.success();
	}
	
	/*
	 * 房间业主信息
	 */
	@RequestMapping( params = "getYzxm",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getYzxm(String fjid){
		List<WuyeYzglFwyzxxEntity> fwxx = systemService.findHql("from WuyeYzglFwyzxxEntity where fjid = '"+fjid+"' and yxbz = '1'");		
		AjaxJson j = new AjaxJson();
		if(fwxx.size() != 0){
			j.setObj(fwxx);
		}else{
			j.setObj("");
		}
		return j;
	}
	
	@RequestMapping(params = "dataid")
	public void dataid(WuyeYzglFwyzxxEntity wuyeYzglFwyzxx,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WuyeYzglFwyzxxEntity.class, dataGrid);
		
		try{
			//自定义追加查询条件
			cq.notEq("yxbz", "0");//状态不为0
			wuyeYzglFwyzxx.setFjid(Integer.parseInt(id));//匹配房间
			cq.add();
			//查询条件组装器
			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeYzglFwyzxx, request.getParameterMap());
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		this.wuyeYzglFwyzxxService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	@RequestMapping( params = "getyz",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getYz(String fjid){
		List<WuyeYzglFwyzxxEntity> fwxx = systemService.findHql("from WuyeYzglFwyzxxEntity where fjid = '"+fjid+"' and yxbz = '0'");		
		AjaxJson j = new AjaxJson();
		if(fwxx.size() != 0){
			j.setObj(fwxx);
		}else{
			j.setObj("");
		}
		return j;
	}
	
}
