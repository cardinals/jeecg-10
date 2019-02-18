package com.jeecg.wuyeglq.controller;
import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyeglq.service.WuyeFwxxServiceI;
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
 * @Description: 房屋基本信息
 * @author onlineGenerator
 * @date 2018-03-08 15:34:27
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wuyeFwxxController")
@Api(value="WuyeFwxx",description="房屋基本信息",tags="wuyeFwxxController")
public class WuyeFwxxController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WuyeFwxxController.class);

	@Autowired
	private WuyeFwxxServiceI wuyeFwxxService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	private String id;
	private String parentId;
	private String pxh;

	/**
	 * 房屋基本信息列表 页面跳转(树)
	 * @author GuoPeiZhi
	 * @return
	 */
	@RequestMapping(params = "ztree")
	public ModelAndView ztree(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/wuyeglq/wuyeFwxxZtree");
	}
	
	@RequestMapping(params = "ztree2")
	public ModelAndView ztree2(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/wuyeglq/wuyefwztZtree");
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
		this.pxh = request.getParameter("pxh");
		return new ModelAndView("com/jeecg/wuyeglq/wuyeFwxxList");
	}
	/**
	 * 我的机构管理zTree
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

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(WuyeFwxxEntity wuyeFwxx,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WuyeFwxxEntity.class, dataGrid);
		//查询条件组装器				
		try{
			if(id!=null||"".equals(id)){
				wuyeFwxx.setLyid(this.id);
			}
			wuyeFwxx.setYxbz("1");

		//自定义追加查询条件
		String query_fjbh_begin = request.getParameter("fjbh_begin");
		String query_fjbh_end = request.getParameter("fjbh_end");
		if(StringUtil.isNotEmpty(query_fjbh_begin)){
			cq.ge("fjbh", Integer.parseInt(query_fjbh_begin));
		}
		if(StringUtil.isNotEmpty(query_fjbh_end)){
			cq.le("fjbh", Integer.parseInt(query_fjbh_end));
		}
		String query_jzmj_begin = request.getParameter("jzmj_begin");
		String query_jzmj_end = request.getParameter("jzmj_end");
		if(StringUtil.isNotEmpty(query_jzmj_begin)){
			cq.ge("jzmj", Integer.parseInt(query_jzmj_begin));
		}
		if(StringUtil.isNotEmpty(query_jzmj_end)){
			cq.le("jzmj", Integer.parseInt(query_jzmj_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeFwxx, request.getParameterMap());
		this.wuyeFwxxService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除房屋基本信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeFwxxEntity wuyeFwxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeFwxx = systemService.getEntity(WuyeFwxxEntity.class, wuyeFwxx.getId());
		message = "房屋基本信息删除成功";
		try{
			wuyeFwxxService.delete(wuyeFwxx);
			wuyeFwxx.setYxbz("0");
			doUpdate(wuyeFwxx,request);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋基本信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除房屋基本信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房屋基本信息删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeFwxxEntity wuyeFwxx = systemService.getEntity(WuyeFwxxEntity.class, 
				id
				);
				wuyeFwxx.setYxbz("0");
				doUpdate(wuyeFwxx,request);
				wuyeFwxxService.delete(wuyeFwxx);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋基本信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加房屋基本信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeFwxxEntity wuyeFwxx, HttpServletRequest request) {
		String message = null;
		System.out.println(wuyeFwxx.getCfczbz());
		AjaxJson j = new AjaxJson();
		message = "房屋基本信息添加成功";
		try{
			Long fjid= systemService.getCountForJdbc("select ifnull(max(fjid),0) from wuye_fwxx");
			if(fjid==0){
				fjid=100000000000l;
				wuyeFwxx.setFjid(fjid);
			}else{
				wuyeFwxx.setFjid(fjid+1);
			}
			//设置有效标志
			wuyeFwxx.setYxbz("1");
			wuyeFwxxService.save(wuyeFwxx);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋基本信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新房屋基本信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WuyeFwxxEntity wuyeFwxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房屋基本信息更新成功";
		WuyeFwxxEntity t = wuyeFwxxService.get(WuyeFwxxEntity.class, wuyeFwxx.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wuyeFwxx, t);
			wuyeFwxxService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "房屋基本信息更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 房屋基本信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WuyeFwxxEntity wuyeFwxx, HttpServletRequest req) {
		req.setAttribute("lyid", id);
		List<WuyeGlqEntity> wuyeGlqEntityList = systemService.findByQueryString("from WuyeGlqEntity  where id= '"+parentId+"'");
		req.setAttribute("glqid", wuyeGlqEntityList.get(0).getFid());
		req.setAttribute("yxbz","1");
		req.setAttribute("pxh", pxh);
		if (StringUtil.isNotEmpty(wuyeFwxx.getId())) {
			wuyeFwxx = wuyeFwxxService.getEntity(WuyeFwxxEntity.class, wuyeFwxx.getId());
			req.setAttribute("wuyeFwxxPage", wuyeFwxx);
		}
		return new ModelAndView("com/jeecg/wuyeglq/wuyeFwxx-add");
	}
	/**
	 * 房屋基本信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WuyeFwxxEntity wuyeFwxx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeFwxx.getId())) {
			wuyeFwxx = wuyeFwxxService.getEntity(WuyeFwxxEntity.class, wuyeFwxx.getId());
			req.setAttribute("wuyeFwxxPage", wuyeFwxx);
		}
		return new ModelAndView("com/jeecg/wuyeglq/wuyeFwxx-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeFwxxController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WuyeFwxxEntity wuyeFwxx,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WuyeFwxxEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeFwxx, request.getParameterMap());
		List<WuyeFwxxEntity> wuyeFwxxs = this.wuyeFwxxService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"房屋基本信息");
		modelMap.put(NormalExcelConstants.CLASS,WuyeFwxxEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("房屋基本信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wuyeFwxxs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WuyeFwxxEntity wuyeFwxx,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"房屋基本信息");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeFwxxEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("房屋基本信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * excel导入
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
				List<WuyeFwxxEntity> listWuyeFwxxEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeFwxxEntity.class,params);
				for (WuyeFwxxEntity wuyeFwxx : listWuyeFwxxEntitys) {
					//添加管理区信息
					List<WuyeGlqEntity>  glqList = systemService.findByQueryString("from WuyeGlqEntity  where  id = (select fid from WuyeGlqEntity  where id='"+parentId+"')");
					 wuyeFwxx.setGlqid(glqList.get(0).getId());
					 wuyeFwxx.setLyid(id);					 
					 wuyeFwxx.setYxbz("1");
					 if(wuyeFwxx.getFjid()==null||"".equals(wuyeFwxx.getFjid())){
						 j.setMsg("文件导入失败！");
						 return j;
					}
					 //房间加单元号
					if(wuyeFwxx.getFjbh().indexOf("-")==-1)
					wuyeFwxx.setFjbh(wuyeFwxx.getDyh()+"-"+wuyeFwxx.getFjbh());				
					wuyeFwxxService.save(wuyeFwxx);
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
	@ApiOperation(value="房屋基本信息列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WuyeFwxxEntity>> list() {
		List<WuyeFwxxEntity> listWuyeFwxxs=wuyeFwxxService.getList(WuyeFwxxEntity.class);
		return Result.success(listWuyeFwxxs);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取房屋基本信息信息",notes="根据ID获取房屋基本信息信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WuyeFwxxEntity task = wuyeFwxxService.get(WuyeFwxxEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取房屋基本信息信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建房屋基本信息")
	public ResponseMessage<?> create(@ApiParam(name="房屋基本信息对象")@RequestBody WuyeFwxxEntity wuyeFwxx, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeFwxxEntity>> failures = validator.validate(wuyeFwxx);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeFwxxService.save(wuyeFwxx);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("房屋基本信息信息保存失败");
		}
		return Result.success(wuyeFwxx);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新房屋基本信息",notes="更新房屋基本信息")
	public ResponseMessage<?> update(@ApiParam(name="房屋基本信息对象")@RequestBody WuyeFwxxEntity wuyeFwxx) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeFwxxEntity>> failures = validator.validate(wuyeFwxx);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeFwxxService.saveOrUpdate(wuyeFwxx);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新房屋基本信息信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新房屋基本信息信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除房屋基本信息")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wuyeFwxxService.deleteEntityById(WuyeFwxxEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("房屋基本信息删除失败");
		}
		return Result.success();
	}
	
	@RequestMapping( params = "getDyzt",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getFwzt(String lyid){
		AjaxJson j = new AjaxJson();
		List<WuyeFwxxEntity> fwxx = systemService.findHql("from WuyeFwxxEntity where lyid = '"+lyid+"'");
		int fjs = 0;
		int fjs_rz = 0;
		int fjs_kz = 0;
		double jzmj = 0.0;
		int dy = 0;
		Map<String,Object> map = null;
		for (WuyeFwxxEntity wuyeFwxxEntity : fwxx) {			
			fjs++;
			if("fx".equals(wuyeFwxxEntity.getFwzt())){
				fjs_rz++;
			}
			if("xz".equals(wuyeFwxxEntity.getFwzt())){
				fjs_kz++;
			}
			if(wuyeFwxxEntity.getJzmj()==null){
				wuyeFwxxEntity.setJzmj(0.0);
			}
			jzmj += wuyeFwxxEntity.getJzmj();
			if(wuyeFwxxEntity.getDyh()==null || wuyeFwxxEntity.getDyh().equals("")){
				wuyeFwxxEntity.setDyh("0");
			}
			if(Integer.parseInt(wuyeFwxxEntity.getDyh())>dy){
				dy = Integer.parseInt(wuyeFwxxEntity.getDyh());
			}			
		}
		map = new HashMap<String,Object>();
		map.put("fjs", fjs);
		map.put("fjs_rz", fjs_rz);
		map.put("fjs_kz", fjs_kz);
		map.put("jzmj", jzmj);
		map.put("dy", dy);
		j.setAttributes(map);
		return j;
	}
	
	@RequestMapping( params = "getFwzt",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getFwxx_Fw(String lyid,String dy,String lc){
		List<WuyeFwxxEntity> fwxx = systemService.findHql("from WuyeFwxxEntity where lyid = '"+lyid+"' and dyh ='"+dy+"'");//' and lch = '"+lc+"
		Map<String,Object> map = null;
		int zlcs = 0;
		for (WuyeFwxxEntity wuyeFwxxEntity : fwxx) {
			if(wuyeFwxxEntity.getZlcs()>=zlcs){
				zlcs = wuyeFwxxEntity.getZlcs();
			}
		}
		map = new HashMap<String,Object>();
		map.put("zlcs", zlcs);
		AjaxJson j = new AjaxJson();
		j.setObj(fwxx);
		j.setAttributes(map);
		return j;
	}
	
}
