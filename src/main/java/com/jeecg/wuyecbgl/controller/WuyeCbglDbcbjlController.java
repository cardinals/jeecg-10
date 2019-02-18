package com.jeecg.wuyecbgl.controller;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.jeecgframework.web.system.pojo.base.TSUser;
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
import com.jeecg.wuyecbgl.entity.WuyeCbglDbcbjlEntity;
import com.jeecg.wuyecbgl.entity.WuyeCbglFjbEntity;
import com.jeecg.wuyecbgl.entity.WuyeCbglSbcbjlEntity;
import com.jeecg.wuyecbgl.service.WuyeCbglDbcbjlServiceI;
import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwyzxxEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: 电表抄表记录
 * @author onlineGenerator
 * @date 2018-03-20 14:11:38
 * @version V1.0   
 *
 */
@Api(value="WuyeCbglDbcbjl",description="电表抄表记录",tags="wuyeCbglDbcbjlController")
@Controller
@RequestMapping("/wuyeCbglDbcbjlController")
public class WuyeCbglDbcbjlController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WuyeCbglDbcbjlController.class);

	@Autowired
	private WuyeCbglDbcbjlServiceI wuyeCbglDbcbjlService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	private String id = "";


	/**
	 * 电表抄表记录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		this.id = request.getParameter("id");
		return new ModelAndView("com/jeecg/wuyecbgl/wuyeCbglDbcbjlList");
	}

	@RequestMapping(params = "ztree")
	public ModelAndView ztree(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/wuyecbgl/wuyeCbglDbcbjlZtree");
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
	public void datagrid(WuyeCbglDbcbjlEntity wuyeCbglDbcbjl,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		List<WuyeFwxxEntity> wuyeFwxxList = this.systemService.findHql("from WuyeFwxxEntity where yxbz = '1' and lyid = '"+id+"'");
		List<WuyeCbglDbcbjlEntity> WuyeCbglDbcbjlEntity = this.systemService.findHql("from WuyeCbglDbcbjlEntity ");
		List<WuyeCbglDbcbjlEntity> wuyeCbglDbcbjl1 = new ArrayList<WuyeCbglDbcbjlEntity>();
		for (WuyeFwxxEntity wuyeFwxxEntity : wuyeFwxxList) {
			for (WuyeCbglDbcbjlEntity wuyeCbglDbcbjlEntity : WuyeCbglDbcbjlEntity) {
				if(wuyeCbglDbcbjlEntity.getFjid() == wuyeFwxxEntity.getFjid().intValue()){
					wuyeCbglDbcbjl1.add(wuyeCbglDbcbjlEntity);
				}
			}
		}
		dataGrid.setTotal(wuyeCbglDbcbjl1.size());
		dataGrid.setResults(wuyeCbglDbcbjl1);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除电表抄表记录
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeCbglDbcbjlEntity wuyeCbglDbcbjl, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeCbglDbcbjl = systemService.getEntity(WuyeCbglDbcbjlEntity.class, wuyeCbglDbcbjl.getId());
		message = "电表抄表记录删除成功";
		try{
			wuyeCbglDbcbjlService.delete(wuyeCbglDbcbjl);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "电表抄表记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除电表抄表记录
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "电表抄表记录删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeCbglDbcbjlEntity wuyeCbglDbcbjl = systemService.getEntity(WuyeCbglDbcbjlEntity.class, 
				id
				);
				wuyeCbglDbcbjlService.delete(wuyeCbglDbcbjl);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "电表抄表记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加电表抄表记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeCbglDbcbjlEntity wuyeCbglDbcbjl, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "电表抄表记录添加成功";
		try{
			wuyeCbglDbcbjlService.save(wuyeCbglDbcbjl);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "电表抄表记录添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新电表抄表记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WuyeCbglDbcbjlEntity wuyeCbglDbcbjl, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "电表抄表记录更新成功";
		WuyeCbglDbcbjlEntity t = wuyeCbglDbcbjlService.get(WuyeCbglDbcbjlEntity.class, wuyeCbglDbcbjl.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wuyeCbglDbcbjl, t);
			wuyeCbglDbcbjlService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "电表抄表记录更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 电表抄表记录新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WuyeCbglDbcbjlEntity wuyeCbglDbcbjl, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeCbglDbcbjl.getId())) {
			wuyeCbglDbcbjl = wuyeCbglDbcbjlService.getEntity(WuyeCbglDbcbjlEntity.class, wuyeCbglDbcbjl.getId());
			req.setAttribute("wuyeCbglDbcbjlPage", wuyeCbglDbcbjl);
		}
		return new ModelAndView("com/jeecg/wuyecbgl/wuyeCbglDbcbjl-add");
	}
	/**
	 * 电表抄表记录编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WuyeCbglDbcbjlEntity wuyeCbglDbcbjl, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeCbglDbcbjl.getId())) {
			wuyeCbglDbcbjl = wuyeCbglDbcbjlService.getEntity(WuyeCbglDbcbjlEntity.class, wuyeCbglDbcbjl.getId());
			req.setAttribute("wuyeCbglDbcbjlPage", wuyeCbglDbcbjl);
		}
		return new ModelAndView("com/jeecg/wuyecbgl/wuyeCbglDbcbjl-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeCbglDbcbjlController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WuyeCbglDbcbjlEntity wuyeCbglDbcbjl,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WuyeCbglDbcbjlEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeCbglDbcbjl, request.getParameterMap());
		List<WuyeCbglDbcbjlEntity> wuyeCbglDbcbjls = this.wuyeCbglDbcbjlService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"电表抄表记录");
		modelMap.put(NormalExcelConstants.CLASS,WuyeCbglDbcbjlEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("电表抄表记录列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wuyeCbglDbcbjls);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WuyeCbglDbcbjlEntity wuyeCbglDbcbjl,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"电表抄表记录");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeCbglDbcbjlEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("电表抄表记录列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	/*
	 * 导出生成模板
	 */
	
	@RequestMapping(params = "dcscmb")
	public String dcScmb(WuyeCbglSbcbjlEntity wuyeCbglSbcbjl,HttpServletRequest request,HttpServletResponse response, DataGrid dataGrid,ModelMap modelMap) throws Exception {
		List<WuyeCbglDbcbjlEntity> wuyeCbglDbcbjl1 = new ArrayList<WuyeCbglDbcbjlEntity>();
		List<WuyeFwxxEntity> WuyeFwxxEntity = this.systemService.findHql("from WuyeFwxxEntity where yxbz = '1' and lyid = '"+id+"'");		
		for (WuyeFwxxEntity wuyeFwxxEntity2 : WuyeFwxxEntity) {	
			List<WuyeCbglFjbEntity> WuyeCbglFjbEntity = this.systemService.findHql("from WuyeCbglFjbEntity where fjid = '"+wuyeFwxxEntity2.getFjid()+"' and yblx = 'sb' and yxbz = '1' order by ybbh");
			for (WuyeCbglFjbEntity wuyeCbglFjbEntity2 : WuyeCbglFjbEntity) {
				WuyeCbglDbcbjlEntity WuyeCbglDbcbjlEntity = new WuyeCbglDbcbjlEntity();
				WuyeCbglDbcbjlEntity.setFjid(wuyeFwxxEntity2.getFjid().intValue());
				WuyeCbglDbcbjlEntity.setGlqid(wuyeFwxxEntity2.getGlqid());
				WuyeCbglDbcbjlEntity.setFwxxid(wuyeFwxxEntity2.getId());
				List<WuyeYzglFwyzxxEntity> fwxx = systemService.findHql("from WuyeYzglFwyzxxEntity where fjid = '"+wuyeFwxxEntity2.getFjid()+"' and yxbz = '1'");
				 StringBuffer result = new StringBuffer();
					if(fwxx.size() != 0){
						if(fwxx.size() == 1){
							WuyeCbglDbcbjlEntity.setXm(fwxx.get(0).getYzMc());
						}else{
							for (WuyeYzglFwyzxxEntity wuyeYzglFwyzxxEntity : fwxx) {
								result.append(wuyeYzglFwyzxxEntity.getYzMc()+",");		
							}
							WuyeCbglDbcbjlEntity.setXm(result.toString());
						}
					}				
					WuyeCbglDbcbjlEntity.setYbid(wuyeCbglFjbEntity2.getId());
					WuyeCbglDbcbjlEntity.setYbbh(wuyeCbglFjbEntity2.getYbbh());
					WuyeCbglDbcbjlEntity.setYbsx("房间表");
					WuyeCbglDbcbjlEntity.setBl(wuyeCbglFjbEntity2.getBl());
					WuyeCbglDbcbjlEntity.setCbr(ResourceUtil.getSessionUser().getUserName());
					WuyeCbglDbcbjlEntity.setFjdz(wuyeCbglFjbEntity2.getFjdz());
				List<WuyeCbglSbcbjlEntity> WuyeCbglSbcbjlEntity2 = this.systemService.findHql("from WuyeCbglSbcbjlEntity where fjid = '"+wuyeFwxxEntity2.getFjid()+"' and ybbh = '"+wuyeCbglFjbEntity2.getYbbh()+"'");
				SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
				Date date=format.parse("0000-00-00");
				double syzs = 0.0;
				for (WuyeCbglSbcbjlEntity wuyeCbglSbcbjlEntity2 : WuyeCbglSbcbjlEntity2) {
					if(wuyeCbglSbcbjlEntity2.getCbsj() != null){
						if(date.after(wuyeCbglSbcbjlEntity2.getCbsj())){
							date = wuyeCbglSbcbjlEntity2.getCbsj();
							syzs = wuyeCbglSbcbjlEntity2.getByzs();
						}
					}
				}
		        if(syzs != 0.0){
		        	WuyeCbglDbcbjlEntity.setSyzs(syzs);
		        }else{
		        	WuyeCbglDbcbjlEntity.setSyzs(wuyeCbglFjbEntity2.getCsds());
		        }
		        WuyeCbglDbcbjlEntity.setByzs(0.0);
		        WuyeCbglDbcbjlEntity.setByyl(0.0);
		        WuyeCbglDbcbjlEntity.setHbyl(0.0);
		        WuyeCbglDbcbjlEntity.setGtl(0.0);
		        WuyeCbglDbcbjlEntity.setSjyl(0.0);
				wuyeCbglDbcbjl1.add(WuyeCbglDbcbjlEntity);
			}
		}
		List<WuyeGlqEntity> WuyeGlqEntity = this.systemService.findHql("from WuyeGlqEntity where yxbz = '1' and id = '"+id+"'");
		List<WuyeGlqEntity> WuyeGlqEntity1 = this.systemService.findHql("from WuyeGlqEntity where yxbz = '1' and id = '"+WuyeFwxxEntity.get(0).getGlqid()+"'");
    	modelMap.put(NormalExcelConstants.FILE_NAME,WuyeGlqEntity1.get(0).getGlqmc()+WuyeGlqEntity.get(0).getGlqmc()+"水表抄表模板");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeCbglDbcbjlEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams(WuyeGlqEntity1.get(0).getGlqmc()+WuyeGlqEntity.get(0).getGlqmc()+"水表抄表记录模板列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,wuyeCbglDbcbjl1);
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload1")
	public ModelAndView upload1(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeCbglSbcbjlController");
		return new ModelAndView("common/upload/pub_excel_upload2");
	}
	
	
	/*
	 * 导入生成模板
	 */
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "drscmb", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson drScmb(HttpServletRequest request, HttpServletResponse response) {
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
				List<WuyeCbglDbcbjlEntity> listWuyeCbglDbcbjlEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeCbglDbcbjlEntity.class,params);
				for (WuyeCbglDbcbjlEntity wuyeCbglDbcbjl : listWuyeCbglDbcbjlEntitys) {
					List<WuyeFwxxEntity> wuyeFwxxEntity =  wuyeCbglDbcbjlService.findByQueryString("from WuyeFwxxEntity where fjid ='"+wuyeCbglDbcbjl.getFjid()+"' and yxbz = '1'");
					wuyeCbglDbcbjl.setGlqid(wuyeFwxxEntity.get(0).getGlqid());
					wuyeCbglDbcbjl.setFwxxid(wuyeFwxxEntity.get(0).getId());
					BigDecimal b = new BigDecimal((wuyeCbglDbcbjl.getByzs()-wuyeCbglDbcbjl.getSyzs())*wuyeCbglDbcbjl.getBl());  
					wuyeCbglDbcbjl.setByyl(b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
					wuyeCbglDbcbjl.setSjyl(wuyeCbglDbcbjl.getByyl()+wuyeCbglDbcbjl.getGtl()+wuyeCbglDbcbjl.getHbyl());
					wuyeCbglDbcbjl.setCbsj(new Date());
					wuyeCbglDbcbjl.setJfqsrq(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("jfqsrq")));
					wuyeCbglDbcbjl.setJfjsrq(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("jfjsrq")));
					wuyeCbglDbcbjlService.save(wuyeCbglDbcbjl);
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
				List<WuyeCbglDbcbjlEntity> listWuyeCbglDbcbjlEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeCbglDbcbjlEntity.class,params);
				for (WuyeCbglDbcbjlEntity wuyeCbglDbcbjl : listWuyeCbglDbcbjlEntitys) {
					List<WuyeYzglFwyzxxEntity> WuyeYzglFwyzxxEntity =  wuyeCbglDbcbjlService.findByQueryString("from WuyeYzglFwyzxxEntity where fjid ='"+wuyeCbglDbcbjl.getFjid()+"' and yzMc = '"+wuyeCbglDbcbjl.getXm()+"' and yxbz = '1'");
					wuyeCbglDbcbjl.setGlqid(WuyeYzglFwyzxxEntity.get(0).getGlqid());
					wuyeCbglDbcbjl.setFwxxid(WuyeYzglFwyzxxEntity.get(0).getFwxxid());
					wuyeCbglDbcbjlService.save(wuyeCbglDbcbjl);
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
	@ApiOperation(value="电表抄表记录列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WuyeCbglDbcbjlEntity>> list() {
		List<WuyeCbglDbcbjlEntity> listWuyeCbglDbcbjls=wuyeCbglDbcbjlService.getList(WuyeCbglDbcbjlEntity.class);
		return Result.success(listWuyeCbglDbcbjls);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取电表抄表记录信息",notes="根据ID获取电表抄表记录信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WuyeCbglDbcbjlEntity task = wuyeCbglDbcbjlService.get(WuyeCbglDbcbjlEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取电表抄表记录信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建电表抄表记录")
	public ResponseMessage<?> create(@ApiParam(name="电表抄表记录对象")@RequestBody WuyeCbglDbcbjlEntity wuyeCbglDbcbjl, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeCbglDbcbjlEntity>> failures = validator.validate(wuyeCbglDbcbjl);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeCbglDbcbjlService.save(wuyeCbglDbcbjl);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("电表抄表记录信息保存失败");
		}
		return Result.success(wuyeCbglDbcbjl);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新电表抄表记录",notes="更新电表抄表记录")
	public ResponseMessage<?> update(@ApiParam(name="电表抄表记录对象")@RequestBody WuyeCbglDbcbjlEntity wuyeCbglDbcbjl) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeCbglDbcbjlEntity>> failures = validator.validate(wuyeCbglDbcbjl);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeCbglDbcbjlService.saveOrUpdate(wuyeCbglDbcbjl);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新电表抄表记录信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新电表抄表记录信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除电表抄表记录")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wuyeCbglDbcbjlService.deleteEntityById(WuyeCbglDbcbjlEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("电表抄表记录删除失败");
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
	
	@RequestMapping( params = "getYbbh",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getYbbh(String fjid){
		AjaxJson j = new AjaxJson();
		
		List<WuyeCbglFjbEntity> WuyeCbglFjbEntity = this.systemService.findHql("from WuyeCbglFjbEntity where fjid = '"+fjid+"' and yblx = 'db' and yxbz = '1' order by ybbh ");
		j.setObj(WuyeCbglFjbEntity);
		
		List<WuyeFwxxEntity> WuyeFwxxEntity = this.systemService.findHql("from WuyeFwxxEntity where fjid = '"+fjid+"' and yxbz = '1'");
		List<WuyeGlqEntity> WuyeGlqEntity = this.systemService.findHql("from WuyeGlqEntity where id = '"+WuyeFwxxEntity.get(0).getLyid()+"' and yxbz = '1'");
		List<WuyeYzglFwyzxxEntity> WuyeYzglFwyzxxEntity = this.systemService.findHql("from WuyeYzglFwyzxxEntity where fjid = '"+fjid+"' and yxbz = '1'");
		
		Map<String,Object> map = null;
		map = new HashMap<String,Object>();		
		map.put("lym", WuyeGlqEntity.get(0).getGlqmc());
		 StringBuffer result = new StringBuffer();
			if(WuyeYzglFwyzxxEntity.size() != 0){
				if(WuyeYzglFwyzxxEntity.size() == 1){
					map.put("yzmc", WuyeYzglFwyzxxEntity.get(0).getYzMc());
				}else{
					for (WuyeYzglFwyzxxEntity wuyeYzglFwyzxxEntity : WuyeYzglFwyzxxEntity) {
						result.append(wuyeYzglFwyzxxEntity.getYzMc()+",");		
					}
					map.put("yzmc", result.toString());
				}
			}		
		map.put("dyh",WuyeFwxxEntity.get(0).getDyh());
		map.put("fjbh",WuyeFwxxEntity.get(0).getFjbh());
		
		//获取登陆用户
		TSUser user = ResourceUtil.getSessionUser();
		map.put("user",user.getUserName());
		
		j.setAttributes(map);
		
		return j;
	}
	
	@RequestMapping( params = "getYbxx",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getYbxx(String ybbh,String fjid) throws Exception{
		
		AjaxJson j = new AjaxJson();
		List<WuyeCbglFjbEntity> WuyeCbglFjbEntity = this.systemService.findHql("from WuyeCbglFjbEntity where fjid = '"+fjid+"' and yblx = 'db' and ybbh = '"+ybbh+"' and yxbz = '1' order by ybbh ");
		j.setObj(WuyeCbglFjbEntity);
		
		
		List<WuyeCbglSbcbjlEntity> WuyeCbglSbcbjlEntity = this.systemService.findHql("from WuyeCbglSbcbjlEntity where fjid = '"+fjid+"' and ybbh = '"+ybbh+"'");
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		Date date=format.parse("0000-00-00");
		double syzs = 0.0;
		for (WuyeCbglSbcbjlEntity wuyeCbglSbcbjlEntity2 : WuyeCbglSbcbjlEntity) {
			if((wuyeCbglSbcbjlEntity2.getCbsj()).after(date)){
				date = wuyeCbglSbcbjlEntity2.getCbsj();
				syzs = wuyeCbglSbcbjlEntity2.getByzs();
			}
		}
		Map<String,Object> map = null;
		map = new HashMap<String,Object>();
		map.put("sj", date);
		map.put("syzs", syzs);
		j.setAttributes(map);
		return j;
	}
	
	@RequestMapping(params="getTreeData1",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getMyTreeData1(HttpServletResponse response,HttpServletRequest request ){
		AjaxJson j = new AjaxJson();
		List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
		try{
				StringBuffer hql = new StringBuffer(" from WuyeGlqEntity w where  w.yxbz <> 0 order by w.pxh");			
				List<WuyeGlqEntity> departList = this.systemService.findHql(hql.toString());
				populateTree1(departList,dataList);		
		}catch(Exception e){
			e.printStackTrace();
		}
		j.setObj(dataList);
		return j;
	}

	private void populateTree1(List<WuyeGlqEntity> wuyeglq,List<Map<String,Object>> dataList){
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
