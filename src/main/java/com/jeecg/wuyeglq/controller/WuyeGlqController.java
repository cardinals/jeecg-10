package com.jeecg.wuyeglq.controller;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyeglq.service.WuyeGlqServiceI;
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
import org.jeecgframework.web.system.util.OrgConstants;
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
 * @Description: 物业_管理区表
 * @author onlineGenerator
 * @date 2018-03-07 15:58:29
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wuyeGlqController")
@Api(value="WuyeGlq",description="物业_管理区表",tags="wuyeGlqController")
public class WuyeGlqController extends BaseController {
	/**
	 * Logger for this class
	 */
	
	private static final Logger logger = Logger.getLogger(WuyeGlqController.class);

	@Autowired
	private WuyeGlqServiceI wuyeGlqService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 物业_管理区表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/wuyeglq/wuyeGlqList");
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
	public void datagrid(WuyeGlqEntity wuyeGlq,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WuyeGlqEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeGlq, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.wuyeGlqService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除物业_管理区表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeGlqEntity wuyeGlq, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeGlq = systemService.getEntity(WuyeGlqEntity.class, wuyeGlq.getId());
		message = "物业_管理区表删除成功";
		try{
			wuyeGlqService.delete(wuyeGlq);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "物业_管理区表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除物业_管理区表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "物业_管理区表删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeGlqEntity wuyeGlq = systemService.getEntity(WuyeGlqEntity.class, 
				id
				);
				wuyeGlqService.delete(wuyeGlq);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "物业_管理区表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加物业_管理区表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeGlqEntity wuyeGlq, HttpServletRequest request) {
		wuyeGlq.setYxbz("1");
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "物业_管理区表添加成功";
		try{
			wuyeGlqService.save(wuyeGlq);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "物业_管理区表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新物业_管理区表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WuyeGlqEntity wuyeGlq, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "物业_管理区表更新成功";
		WuyeGlqEntity t = wuyeGlqService.get(WuyeGlqEntity.class, wuyeGlq.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wuyeGlq, t);
			wuyeGlqService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "物业_管理区表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新物业_管理区表(删除)
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doDelYxbz")
	@ResponseBody
	public AjaxJson doDelYxbz(WuyeGlqEntity wuyeGlq, HttpServletRequest request) {
		String message = null;
		wuyeGlq.setYxbz("0");
		AjaxJson j = new AjaxJson();
		
		message = "删除成功";
		WuyeGlqEntity t = wuyeGlqService.get(WuyeGlqEntity.class, wuyeGlq.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wuyeGlq, t);
			wuyeGlqService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 物业_管理区表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WuyeGlqEntity wuyeGlq, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeGlq.getId())) {
			wuyeGlq = wuyeGlqService.getEntity(WuyeGlqEntity.class, wuyeGlq.getId());
			req.setAttribute("wuyeGlqPage", wuyeGlq);
		}
		return new ModelAndView("com/jeecg/wuyeglq/wuyeGlq-add");
	}
	/**
	 * 物业_管理区表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WuyeGlqEntity wuyeGlq, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeGlq.getId())) {
			wuyeGlq = wuyeGlqService.getEntity(WuyeGlqEntity.class, wuyeGlq.getId());
			req.setAttribute("wuyeGlqPage", wuyeGlq);
		}
		return new ModelAndView("com/jeecg/wuyeglq/wuyeGlq-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeGlqController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WuyeGlqEntity wuyeGlq,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WuyeGlqEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeGlq, request.getParameterMap());
		List<WuyeGlqEntity> wuyeGlqs = this.wuyeGlqService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"物业_管理区表");
		modelMap.put(NormalExcelConstants.CLASS,WuyeGlqEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("物业_管理区表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wuyeGlqs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WuyeGlqEntity wuyeGlq,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"物业_管理区表");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeGlqEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("物业_管理区表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<WuyeGlqEntity> listWuyeGlqEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeGlqEntity.class,params);
				for (WuyeGlqEntity wuyeGlq : listWuyeGlqEntitys) {
					wuyeGlqService.save(wuyeGlq);
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
	@ApiOperation(value="物业_管理区表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WuyeGlqEntity>> list() {
		List<WuyeGlqEntity> listWuyeGlqs=wuyeGlqService.getList(WuyeGlqEntity.class);
		return Result.success(listWuyeGlqs);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取物业_管理区表信息",notes="根据ID获取物业_管理区表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WuyeGlqEntity task = wuyeGlqService.get(WuyeGlqEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取物业_管理区表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建物业_管理区表")
	public ResponseMessage<?> create(@ApiParam(name="物业_管理区表对象")@RequestBody WuyeGlqEntity wuyeGlq, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeGlqEntity>> failures = validator.validate(wuyeGlq);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeGlqService.save(wuyeGlq);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("物业_管理区表信息保存失败");
		}
		return Result.success(wuyeGlq);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新物业_管理区表",notes="更新物业_管理区表")
	public ResponseMessage<?> update(@ApiParam(name="物业_管理区表对象")@RequestBody WuyeGlqEntity wuyeGlq) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeGlqEntity>> failures = validator.validate(wuyeGlq);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeGlqService.saveOrUpdate(wuyeGlq);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新物业_管理区表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新物业_管理区表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除物业_管理区表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wuyeGlqService.deleteEntityById(WuyeGlqEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("物业_管理区表删除失败");
		}

		return Result.success();
	}
	
/////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 *展示管理区域树
	 * 
	 * @return
	 */
	@RequestMapping(params = "wuyeTree")
	public ModelAndView myDepart() {
		return new ModelAndView("com/jeecg/wuyeglq/wuyetree");
	}
	
	
	/**
	 * 我的机构管理zTree
	 * @param functionGroup
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(params="getMyTreeData",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<Map<String,Object>> getMyTreeData(HttpServletResponse response,HttpServletRequest request ){
		List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
		try{
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String level = request.getParameter("level");
		    //如果id不为空，则查询当前节点子节点
			if(StringUtils.isNotEmpty(id)){
				String hql = "from WuyeGlqEntity w where w.fid = ? and w.yxbz <> 0 order by w.pxh";
				List<WuyeGlqEntity> wuyeglq = this.systemService.findHql(hql,id);
				populateTree(wuyeglq,dataList);
			}else{

				String userName = ResourceUtil.getSessionUser().getUserName();
				StringBuffer hql = new StringBuffer(" from WuyeGlqEntity w where w.yxbz <> 0 order by w.pxh");
			
				List<WuyeGlqEntity> departList = this.systemService.findHql(hql.toString());

				populateTree(departList,dataList);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		//System.err.println(dataList);
		return dataList;
	}
	
	private void populateTree(List<WuyeGlqEntity> wuyeglq,List<Map<String,Object>> dataList){
		Map<String,Object> map = null;
		if(wuyeglq!=null&&wuyeglq.size()>0){
			for(WuyeGlqEntity w :wuyeglq){
				map = new HashMap<String,Object>();
//				map.put("chkDisabled",false);
//				map.put("click", true);
				map.put("open", true);
				map.put("id", w.getId());
				map.put("name",w.getGlqmc());
				map.put("fid",w.getFid());
				map.put("glqlx", w.getGlqlx());
				
				//判断是否有子节点
				String hql = "select count(*) from WuyeGlqEntity t where t.fid = '"+w.getId()+"' ";
				 Long count = (Long)this.systemService.singleResult(hql);
				 if(count>0){
					 map.put("isParent", true);
				 }else{
					 map.put("isParent", false);
				 }
				 if("1".equals(w.getGlqlx())){
					 map.put("icon","plug-in/ztree/css/img/diy/wuyegongsi.png");
				 }else if("2".equals(w.getGlqlx())){
					 map.put("icon","plug-in/ztree/css/img/diy/guanqu.png");
				 }else if("3".equals(w.getGlqlx())){
					 map.put("icon","plug-in/ztree/css/img/diy/xiaoqu.png");
				 }else if("4".equals(w.getGlqlx())){
					 map.put("icon","plug-in/ztree/css/img/diy/louyu.png");
				 }

				dataList.add(map);
			}
		}
	}
	
	/**
	 * 查看详细信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "comDetail")
	public ModelAndView comDetail(WuyeGlqEntity wuyeglq, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String viewName = "";
		if (StringUtil.isNotEmpty(wuyeglq.getId())) {
			wuyeglq = systemService.getEntity(WuyeGlqEntity.class, wuyeglq.getId());
			req.setAttribute("wuyeglq", wuyeglq);
			
			viewName = "com/jeecg/wuyeglq/wuyetree-detail";
		}
		mv.setViewName(viewName);
		return mv;
	}

	/**
	 * 添加下级部门
	 * 
	 * @return
	 */
	
	@RequestMapping(params = "toAddSubOrg")
	public ModelAndView toAddSubOrg(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String pid = request.getParameter("pid");
		//System.out.println("......."+pid);
		String viewName = "";
		//查询设置需返回的参数
		if (StringUtil.isNotEmpty(pid)) {
			WuyeGlqEntity wuyeglq = wuyeGlqService.get(WuyeGlqEntity.class, pid);
			String wuyeglqlx = "";
			if(wuyeglq.getGlqlx().equals("1")){
				wuyeglqlx = "2";
			}else if(wuyeglq.getGlqlx().equals("2")){
				wuyeglqlx = "3";
			}else if(wuyeglq.getGlqlx().equals("3")){
				wuyeglqlx = "4";
			}
			request.setAttribute("wuyeAdd", wuyeglq);
			request.setAttribute("wuyeglqlx", wuyeglqlx);
			
			//System.err.println("1..."+wuyeglq);
			viewName = "com/jeecg/wuyeglq/wuyetree-add";
		}
		
		mv.setViewName(viewName);
		return mv;
	}
	
	/**
	 * 组织机构编辑
	 * 
	 * @return
	 */
	@RequestMapping(params = "comUpdate")
	public ModelAndView comUpdate(WuyeGlqEntity wuyeglq, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String viewName = "";
		if (StringUtil.isNotEmpty(wuyeglq.getId())) {
			wuyeglq = systemService.getEntity(WuyeGlqEntity.class, wuyeglq.getId());
			req.setAttribute("wuyeglq", wuyeglq);
			
			viewName = "com/jeecg/wuyeglq/wuyetree-edit";
			
		}
		
		mv.setViewName(viewName);
		return mv;
	}
	/**
	 * 删除部门：
	 * <ul>
     *     组织机构下存在子机构时
     *     <li>不允许删除 组织机构</li>
	 * </ul>
	 * <ul>
     *     组织机构下存在用户时
     *     <li>不允许删除 组织机构</li>
	 * </ul>
	 * <ul>
     *     组织机构下 不存在子机构 且 不存在用户时
     *     <li>删除 组织机构-角色 信息</li>
     *     <li>删除 组织机构 信息</li>
	 * </ul>
	 * @return 删除的结果信息
	 *//*
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TSDepart depart, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		depart = systemService.getEntity(TSDepart.class, depart.getId());
        message = MutiLangUtil.paramDelSuccess("common.department");
        if (depart.getTSDeparts().size() == 0) {
            Long userCount = systemService.getCountForJdbc("select count(1) from t_s_user_org where org_id='" + depart.getId() + "'");
            if(userCount == 0) { // 组织机构下没有用户时，该组织机构才允许删除。
                systemService.executeSql("delete from t_s_role_org where org_id=?", depart.getId());
                systemService.delete(depart);
                systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
            }else{

            	message = MutiLangUtil.getMutiLangInstance().getLang("common.department.hasuser");

            }
        } else {
            message = MutiLangUtil.paramDelFail("common.department");
        }

        j.setMsg(message);
		return j;
	}*/
	
}
