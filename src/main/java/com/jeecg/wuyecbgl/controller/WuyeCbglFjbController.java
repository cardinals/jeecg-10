package com.jeecg.wuyecbgl.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.alibaba.fastjson.JSONArray;
import com.jeecg.wuyecbgl.entity.WuyeCbglFjbEntity;
import com.jeecg.wuyecbgl.entity.WuyeCbglGtbEntity;
import com.jeecg.wuyecbgl.entity.WuyeCbglSbcbjlEntity;
import com.jeecg.wuyecbgl.service.WuyeCbglFjbServiceI;
import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglSfxmszEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: 房间表管理
 * @author onlineGenerator
 * @date 2018-03-22 10:37:58
 * @version V1.0   
 *
 */
@Api(value="WuyeCbglFjb",description="房间表管理",tags="wuyeCbglFjbController")
@Controller
@RequestMapping("/wuyeCbglFjbController")
public class WuyeCbglFjbController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WuyeCbglFjbController.class);

	@Autowired
	private WuyeCbglFjbServiceI wuyeCbglFjbService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	private Long ybbh;
	private String lyid = "";
	private String fjid = "";

	/**
	 * 房间表管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list_ly")
	public ModelAndView list_ly(HttpServletRequest request) {
		this.lyid = request.getParameter("id");
		return new ModelAndView("com/jeecg/wuyecbgl/wuyeCbglFjbList_ly");
	}

	@RequestMapping(params = "list_fj")
	public ModelAndView list_fj(HttpServletRequest request) {
		this.fjid = request.getParameter("id");
		return new ModelAndView("com/jeecg/wuyecbgl/wuyeCbglFjbList_fj");
	}
	
	@RequestMapping(params = "ztree")
	public ModelAndView ztree(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/wuyecbgl/wuyeCbglFjbZtree");
	}
	
	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

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
		List<WuyeCbglFjbEntity> WuyeCbglFjbEntity = this.systemService.findHql("from WuyeCbglFjbEntity where yxbz = '1'");
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
	
	@RequestMapping(params = "datagrid_fj")
	public void datagrid_fj(WuyeCbglFjbEntity wuyeCbglFjb,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
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
		List<WuyeCbglFjbEntity> WuyeCbglFjbEntity = this.systemService.findHql("from WuyeCbglFjbEntity where yxbz = '1' and fjid = '"+fjid+"'");
		dataGrid.setTotal(WuyeCbglFjbEntity.size());
		dataGrid.setResults(WuyeCbglFjbEntity);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除房间表管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeCbglFjbEntity wuyeCbglFjb, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeCbglFjb = systemService.getEntity(WuyeCbglFjbEntity.class, wuyeCbglFjb.getId());
		wuyeCbglFjb.setYxbz("0");
		message = "房间表管理删除成功";
		try{
			/*wuyeCbglFjbService.delete(wuyeCbglFjb);*/
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房间表管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除房间表管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房间表管理删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeCbglFjbEntity wuyeCbglFjb = systemService.getEntity(WuyeCbglFjbEntity.class, id);
				wuyeCbglFjb.setYxbz("0");
				/*wuyeCbglFjbService.delete(wuyeCbglFjb);*/
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "房间表管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加房间表管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeCbglFjbEntity wuyeCbglFjb, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房间表管理添加成功";
		try{
			wuyeCbglFjb.setYxbz("1");
			if(wuyeCbglFjb.getGtbid().equals("")){
				wuyeCbglFjb.setGtbid("");
			}else{
				List<WuyeCbglGtbEntity> WuyeCbglGtbEntity = this.systemService.findHql("from WuyeCbglGtbEntity where ybbh = '"+wuyeCbglFjb.getGtbid()+"' and yxbz = '1'");
				wuyeCbglFjb.setGtbid(WuyeCbglGtbEntity.get(0).getId());
			}
			List<WuyeSfglSfxmszEntity> WuyeSfglSfxmszEntity = this.systemService.findHql("from WuyeSfglSfxmszEntity where xmmc = '"+wuyeCbglFjb.getSfxmdm()+"'");
			wuyeCbglFjb.setSfxmdm(WuyeSfglSfxmszEntity.get(0).getXmdm());
			wuyeCbglFjbService.save(wuyeCbglFjb);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房间表管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新房间表管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WuyeCbglFjbEntity wuyeCbglFjb, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房间表管理更新成功";
		WuyeCbglFjbEntity t = wuyeCbglFjbService.get(WuyeCbglFjbEntity.class, wuyeCbglFjb.getId());
		try {
			
			List<WuyeCbglGtbEntity> WuyeCbglGtbEntity = this.systemService.findHql("from WuyeCbglGtbEntity where ybbh = '"+wuyeCbglFjb.getGtbid()+"' and yxbz = '1'");
			wuyeCbglFjb.setGtbid(WuyeCbglGtbEntity.get(0).getId());
			List<WuyeSfglSfxmszEntity> WuyeSfglSfxmszEntity = this.systemService.findHql("from WuyeSfglSfxmszEntity where xmmc = '"+wuyeCbglFjb.getSfxmdm()+"'");
			wuyeCbglFjb.setSfxmdm(WuyeSfglSfxmszEntity.get(0).getXmdm());
			if(wuyeCbglFjb.getYblx().equals("水表")){
				wuyeCbglFjb.setYblx("sb");
			}else if(wuyeCbglFjb.getYblx().equals("气表")){
				wuyeCbglFjb.setYblx("qb");
			}else if(wuyeCbglFjb.getYblx().equals("电表")){
				wuyeCbglFjb.setYblx("db");
			}
			MyBeanUtils.copyBeanNotNull2Bean(wuyeCbglFjb, t);
			wuyeCbglFjbService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "房间表管理更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 房间表管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WuyeCbglFjbEntity wuyeCbglFjb, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeCbglFjb.getId())) {
			wuyeCbglFjb = wuyeCbglFjbService.getEntity(WuyeCbglFjbEntity.class, wuyeCbglFjb.getId());
			req.setAttribute("wuyeCbglFjbPage", wuyeCbglFjb);
		}
		 if(wuyeCbglFjb.getYbbh()==null){
			 ybbh= systemService.getCountForJdbc("select ifnull(max(ybbh),0) from wuye_cbgl_fjb");
				if(ybbh==0){
					ybbh=(long) 10001;
					//wuyeCbglFjb.setFjid(ybbh.intValue());
				}else{
					ybbh += 1; 
					//wuyeCbglFjb.setFjid(ybbh.intValue()+1);
				}												
		}
		 wuyeCbglFjb.setYbbh(ybbh.intValue());
		 req.setAttribute("wuyeCbglFjbPage", wuyeCbglFjb);
		return new ModelAndView("com/jeecg/wuyecbgl/wuyeCbglFjb-add");
	}
	/**
	 * 房间表管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WuyeCbglFjbEntity wuyeCbglFjb, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeCbglFjb.getId())) {
			wuyeCbglFjb = wuyeCbglFjbService.getEntity(WuyeCbglFjbEntity.class, wuyeCbglFjb.getId());
			req.setAttribute("wuyeCbglFjbPage", wuyeCbglFjb);
		}
		return new ModelAndView("com/jeecg/wuyecbgl/wuyeCbglFjb-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeCbglFjbController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WuyeCbglFjbEntity wuyeCbglFjb,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WuyeCbglFjbEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeCbglFjb, request.getParameterMap());
		List<WuyeCbglFjbEntity> wuyeCbglFjbs = this.wuyeCbglFjbService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"房间表管理");
		modelMap.put(NormalExcelConstants.CLASS,WuyeCbglFjbEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("房间表管理列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wuyeCbglFjbs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WuyeCbglFjbEntity wuyeCbglFjb,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"房间表管理");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeCbglFjbEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("房间表管理列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<WuyeCbglFjbEntity> listWuyeCbglFjbEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeCbglFjbEntity.class,params);
				for (WuyeCbglFjbEntity wuyeCbglFjb : listWuyeCbglFjbEntitys) {
					List<WuyeFwxxEntity> WuyeFwxxEntity = systemService.findHql("from WuyeFwxxEntity where yxbz = '1' and fjid = '"+wuyeCbglFjb.getFjid()+"'");
					if(WuyeFwxxEntity.size() != 0){
						wuyeCbglFjb.setGlqid(WuyeFwxxEntity.get(0).getGlqid());
						wuyeCbglFjb.setFwxxid(WuyeFwxxEntity.get(0).getId());
					}
					List<WuyeCbglGtbEntity> WuyeCbglGtbEntity = systemService.findHql("from WuyeCbglGtbEntity where yxbz = '1' and ybbh = '"+wuyeCbglFjb.getGtbid()+"'");
					if(WuyeCbglGtbEntity.size() != 0){
						wuyeCbglFjb.setGtbid(WuyeCbglGtbEntity.get(0).getId());
					}
					wuyeCbglFjb.setYxbz("1");
					wuyeCbglFjbService.save(wuyeCbglFjb);
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
	@ApiOperation(value="房间表管理列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WuyeCbglFjbEntity>> list() {
		List<WuyeCbglFjbEntity> listWuyeCbglFjbs=wuyeCbglFjbService.getList(WuyeCbglFjbEntity.class);
		return Result.success(listWuyeCbglFjbs);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取房间表管理信息",notes="根据ID获取房间表管理信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WuyeCbglFjbEntity task = wuyeCbglFjbService.get(WuyeCbglFjbEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取房间表管理信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建房间表管理")
	public ResponseMessage<?> create(@ApiParam(name="房间表管理对象")@RequestBody WuyeCbglFjbEntity wuyeCbglFjb, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeCbglFjbEntity>> failures = validator.validate(wuyeCbglFjb);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeCbglFjbService.save(wuyeCbglFjb);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("房间表管理信息保存失败");
		}
		return Result.success(wuyeCbglFjb);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新房间表管理",notes="更新房间表管理")
	public ResponseMessage<?> update(@ApiParam(name="房间表管理对象")@RequestBody WuyeCbglFjbEntity wuyeCbglFjb) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeCbglFjbEntity>> failures = validator.validate(wuyeCbglFjb);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeCbglFjbService.saveOrUpdate(wuyeCbglFjb);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新房间表管理信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新房间表管理信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除房间表管理")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wuyeCbglFjbService.deleteEntityById(WuyeCbglFjbEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("房间表管理删除失败");
		}

		return Result.success();
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
	
	/*
	 * 房屋信息
	 */
	@RequestMapping( params = "getFwxx",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getFwxx(String fjid){
		
		AjaxJson j = new AjaxJson();
		
		List<WuyeFwxxEntity> WuyeFwxxEntity = this.systemService.findHql("from WuyeFwxxEntity where fjid = '"+fjid+"' and yxbz = '1'");
		j.setObj(WuyeFwxxEntity);
		
		List<WuyeGlqEntity> WuyeGlqEntity = this.systemService.findHql("from WuyeGlqEntity where id = '"+WuyeFwxxEntity.get(0).getLyid()+"' and yxbz = '1'");
		List<WuyeCbglGtbEntity> WuyeCbglGtbEntity = this.systemService.findHql("from WuyeCbglGtbEntity where glqid = '"+WuyeFwxxEntity.get(0).getGlqid()+"' and yxbz = '1'");
		Map<String,Object> map = null;
		map = new HashMap<String,Object>();	
		map.put("lym", WuyeGlqEntity.get(0).getGlqmc());
		map.put("gtb", WuyeCbglGtbEntity);
		j.setAttributes(map);
		
		return j;
	}
	
	/*
	 * 录入房间表信息
	 */
	@RequestMapping( params = "getXmxx",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getXmxx(String yblx){
		
		AjaxJson j = new AjaxJson();
		int jffs = 0;
		if(yblx.equals("水表 ")){
			jffs = 3;
		}else if(yblx.equals("电表 ")){
			jffs = 4;
		}else if(yblx.equals("气表 ")){
			jffs = 5;
		}
		
		if(jffs != 0){
			List<WuyeSfglSfxmszEntity> WuyeSfglSfxmszEntity = this.systemService.findHql("from WuyeSfglSfxmszEntity where jffs = '"+jffs+"'");
			j.setObj(WuyeSfglSfxmszEntity);
		}
		return j;
	}
	
	/*
	 * 编辑房间表信息
	 */
	@RequestMapping( params = "getFjxx",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getFjxx(String gtbid, String yblx, String sfxmdm){
		AjaxJson j = new AjaxJson();
		
		List<WuyeCbglGtbEntity> WuyeCbglGtbEntity = this.systemService.findHql("from WuyeCbglGtbEntity where id = '"+gtbid+"' and yxbz = '1'");
		List<WuyeSfglSfxmszEntity> WuyeSfglSfxmszEntity = this.systemService.findHql("from WuyeSfglSfxmszEntity where xmdm = '"+sfxmdm+"'");
		Map<String,Object> map = null;
		map = new HashMap<String,Object>();	
		map.put("ybbh", WuyeCbglGtbEntity.get(0).getYbbh());
		map.put("xmmc", WuyeSfglSfxmszEntity.get(0).getXmmc());
		if(yblx.equals("sb")){
			map.put("yblx", "水表");
		}else if(yblx.equals("qb")){
			map.put("yblx", "气表");
		}else if(yblx.equals("db")){
			map.put("yblx", "电表");
		}
		j.setAttributes(map);
		
		return j;
	}
}
