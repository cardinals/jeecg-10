package com.jeecg.wuyeglq.controller;
import com.jeecg.wuyeglq.dao.WuyeFwxxCqbgDao;
import com.jeecg.wuyeglq.entity.WuyeFwxxCqbgEntity;
import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyeglq.service.WuyeFwxxCqbgServiceI;
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
 * @Description: 房屋产权变更表
 * @author onlineGenerator
 * @date 2018-03-09 15:03:34
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wuyeFwxxCqbgController")
@Api(value="WuyeFwxxCqbg",description="房屋产权变更表",tags="wuyeFwxxCqbgController")
public class WuyeFwxxCqbgController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WuyeFwxxCqbgController.class);

	@Autowired
	private WuyeFwxxCqbgServiceI wuyeFwxxCqbgService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private WuyeFwxxCqbgDao wuyeFwxxCqbgDao;
	@Autowired
	private Validator validator;
	/**房间id*/
	private String id;
	private String parentId;

	/**
	 * 房屋基本信息列表 页面跳转(树)
	 * @author GuoPeiZhi
	 * @return
	 */
	@RequestMapping(params = "ztree")
	public ModelAndView ztree(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/wuyeglq/wuyeFwxxCqbgZtree");
	}
	
	/**
	 * 房屋基本信息列表 页面跳转
	 * @author GuoPeiZhi
	 * @return
	 */	
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		this.id = request.getParameter("id");
		this.parentId = request.getParameter("parentId");
		return new ModelAndView("com/jeecg/wuyeglq/wuyeFwxxCqbgList");
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
				StringBuffer hql = new StringBuffer(" from WuyeGlqEntity w where  w.yxbz <> 0 order by w.pxh ");			
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
					 map.put("open",false);
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
	public void datagrid(WuyeFwxxCqbgEntity wuyeFwxxCqbg,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WuyeFwxxCqbgEntity.class, dataGrid);
		//查询条件组装器
		//WuyeFwxxEntity fwxxEntity = systemService.findUniqueByProperty(WuyeFwxxEntity.class, "fjid", Long.valueOf(id));
		String fwxxid =  wuyeFwxxCqbgDao.findByObject(Long.valueOf(this.id));
		wuyeFwxxCqbg.setFwxxid(fwxxid);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeFwxxCqbg, request.getParameterMap());
		this.wuyeFwxxCqbgService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除房屋产权变更表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeFwxxCqbgEntity wuyeFwxxCqbg, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeFwxxCqbg = systemService.getEntity(WuyeFwxxCqbgEntity.class, wuyeFwxxCqbg.getId());
		message = "房屋产权变更表删除成功";
		try{
			wuyeFwxxCqbgService.delete(wuyeFwxxCqbg);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋产权变更表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除房屋产权变更表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房屋产权变更表删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeFwxxCqbgEntity wuyeFwxxCqbg = systemService.getEntity(WuyeFwxxCqbgEntity.class, 
				id
				);
				wuyeFwxxCqbgService.delete(wuyeFwxxCqbg);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋产权变更表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加房屋产权变更表
	 * @author GuoPeiZhi
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeFwxxCqbgEntity wuyeFwxxCqbg, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房屋产权变更表添加成功";
		try{		
			//添加房屋迁入管理表
			wuyeFwxxCqbgService.save(wuyeFwxxCqbg);
			//更新产权人
			systemService.updateBySqlString(
					"update  wuye_fwxx  set fwcqr='"+wuyeFwxxCqbg.getFwsyqrXz()
				 +"',zjmc='"+wuyeFwxxCqbg.getZjmcXz()
				 +"',zjhm='"+wuyeFwxxCqbg.getZjhmXz() 
				 +"' where  id='"+wuyeFwxxCqbg.getFwxxid()+"'");
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋产权变更表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新房屋产权变更表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WuyeFwxxCqbgEntity wuyeFwxxCqbg, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房屋产权变更表更新成功";
		WuyeFwxxCqbgEntity t = wuyeFwxxCqbgService.get(WuyeFwxxCqbgEntity.class, wuyeFwxxCqbg.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wuyeFwxxCqbg, t);			
			systemService.updateBySqlString(
					"update  wuye_fwxx  set fwcqr='"+t.getFwsyqrXz()
				 +"',zjmc='"+t.getZjmcXz()
				 +"',zjhm='"+t.getZjhmXz()
				 +"' where  fjid="+t.getFwxxid());
			wuyeFwxxCqbgService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "房屋产权变更表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 房屋产权变更表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WuyeFwxxCqbgEntity wuyeFwxxCqbg, HttpServletRequest req) {		
		List<WuyeFwxxEntity>wuyefwxx = systemService.findByQueryString("from WuyeFwxxEntity where yxbz='1' and  fjid="+id);		
		req.setAttribute("id", wuyefwxx.get(0).getId());
		req.setAttribute("fwsyqrYl", wuyefwxx.get(0).getFwcqr());
		req.setAttribute("zjmcYl", wuyefwxx.get(0).getZjmc());
		req.setAttribute("zjhmYl", wuyefwxx.get(0).getZjhm());
		if (StringUtil.isNotEmpty(wuyeFwxxCqbg.getId())) {
			wuyeFwxxCqbg = wuyeFwxxCqbgService.getEntity(WuyeFwxxCqbgEntity.class, wuyeFwxxCqbg.getId());
			req.setAttribute("wuyeFwxxCqbgPage", wuyeFwxxCqbg);
		}
		return new ModelAndView("com/jeecg/wuyeglq/wuyeFwxxCqbg-add");
	}
	/**
	 * 房屋产权变更表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WuyeFwxxCqbgEntity wuyeFwxxCqbg, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeFwxxCqbg.getId())) {
			wuyeFwxxCqbg = wuyeFwxxCqbgService.getEntity(WuyeFwxxCqbgEntity.class, wuyeFwxxCqbg.getId());
			req.setAttribute("wuyeFwxxCqbgPage", wuyeFwxxCqbg);
		}
		return new ModelAndView("com/jeecg/wuyeglq/wuyeFwxxCqbg-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeFwxxCqbgController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WuyeFwxxCqbgEntity wuyeFwxxCqbg,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WuyeFwxxCqbgEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeFwxxCqbg, request.getParameterMap());
		List<WuyeFwxxCqbgEntity> wuyeFwxxCqbgs = this.wuyeFwxxCqbgService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"房屋产权变更表");
		modelMap.put(NormalExcelConstants.CLASS,WuyeFwxxCqbgEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("房屋产权变更表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wuyeFwxxCqbgs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WuyeFwxxCqbgEntity wuyeFwxxCqbg,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"房屋产权变更表");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeFwxxCqbgEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("房屋产权变更表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	/**
	 * 	excel导入
	 * @author GuoPeiZhi
	 * @param request
	 * @param response
	 * @return
	 */
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
				List<WuyeFwxxCqbgEntity> listWuyeFwxxCqbgEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeFwxxCqbgEntity.class,params);
				for (WuyeFwxxCqbgEntity wuyeFwxxCqbg : listWuyeFwxxCqbgEntitys) {
					wuyeFwxxCqbgService.save(wuyeFwxxCqbg);
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
	@ApiOperation(value="房屋产权变更表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WuyeFwxxCqbgEntity>> list() {
		List<WuyeFwxxCqbgEntity> listWuyeFwxxCqbgs=wuyeFwxxCqbgService.getList(WuyeFwxxCqbgEntity.class);
		return Result.success(listWuyeFwxxCqbgs);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取房屋产权变更表信息",notes="根据ID获取房屋产权变更表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WuyeFwxxCqbgEntity task = wuyeFwxxCqbgService.get(WuyeFwxxCqbgEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取房屋产权变更表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建房屋产权变更表")
	public ResponseMessage<?> create(@ApiParam(name="房屋产权变更表对象")@RequestBody WuyeFwxxCqbgEntity wuyeFwxxCqbg, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeFwxxCqbgEntity>> failures = validator.validate(wuyeFwxxCqbg);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeFwxxCqbgService.save(wuyeFwxxCqbg);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("房屋产权变更表信息保存失败");
		}
		return Result.success(wuyeFwxxCqbg);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新房屋产权变更表",notes="更新房屋产权变更表")
	public ResponseMessage<?> update(@ApiParam(name="房屋产权变更表对象")@RequestBody WuyeFwxxCqbgEntity wuyeFwxxCqbg) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeFwxxCqbgEntity>> failures = validator.validate(wuyeFwxxCqbg);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeFwxxCqbgService.saveOrUpdate(wuyeFwxxCqbg);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新房屋产权变更表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新房屋产权变更表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除房屋产权变更表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wuyeFwxxCqbgService.deleteEntityById(WuyeFwxxCqbgEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("房屋产权变更表删除失败");
		}

		return Result.success();
	}
}
