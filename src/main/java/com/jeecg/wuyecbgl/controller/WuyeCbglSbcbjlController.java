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
import com.jeecg.wuyecbgl.entity.WuyeCbglFjbEntity;
import com.jeecg.wuyecbgl.entity.WuyeCbglSbcbjlEntity;
import com.jeecg.wuyecbgl.service.WuyeCbglSbcbjlServiceI;
import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwyzxxEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: 水表抄表记录
 * @author onlineGenerator
 * @date 2018-03-20 14:11:26
 * @version V1.0   
 *
 */
@Api(value="WuyeCbglSbcbjl",description="水表抄表记录",tags="wuyeCbglSbcbjlController")
@Controller
@RequestMapping("/wuyeCbglSbcbjlController")
public class WuyeCbglSbcbjlController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WuyeCbglSbcbjlController.class);

	@Autowired
	private WuyeCbglSbcbjlServiceI wuyeCbglSbcbjlService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	private String id = "";

	/**
	 * 水表抄表记录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		this.id = request.getParameter("id");
		return new ModelAndView("com/jeecg/wuyecbgl/wuyeCbglSbcbjlList");
	}
	
	@RequestMapping(params = "ztree")
	public ModelAndView ztree(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/wuyecbgl/wuyeCbglSbcbjlZtree");
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
	public void datagrid(WuyeCbglSbcbjlEntity wuyeCbglSbcbjl,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		List<WuyeFwxxEntity> wuyeFwxxList = this.systemService.findHql("from WuyeFwxxEntity where yxbz = '1' and lyid = '"+id+"'");
		List<WuyeCbglSbcbjlEntity> WuyeCbglSbcbjlEntity = this.systemService.findHql("from WuyeCbglSbcbjlEntity ");
		List<WuyeCbglSbcbjlEntity> wuyeCbglSbcbjl1 = new ArrayList<WuyeCbglSbcbjlEntity>();
		for (WuyeFwxxEntity wuyeFwxxEntity : wuyeFwxxList) {
			for (WuyeCbglSbcbjlEntity wuyeCbglSbcbjlEntity : WuyeCbglSbcbjlEntity) {
				if(wuyeCbglSbcbjlEntity.getFjid() == wuyeFwxxEntity.getFjid().intValue()){
					wuyeCbglSbcbjl1.add(wuyeCbglSbcbjlEntity);
				}
			}
		}
		dataGrid.setTotal(wuyeCbglSbcbjl1.size());
		dataGrid.setResults(wuyeCbglSbcbjl1);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除水表抄表记录
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeCbglSbcbjlEntity wuyeCbglSbcbjl, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeCbglSbcbjl = systemService.getEntity(WuyeCbglSbcbjlEntity.class, wuyeCbglSbcbjl.getId());
		message = "水表抄表记录删除成功";
		try{
			wuyeCbglSbcbjlService.delete(wuyeCbglSbcbjl);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "水表抄表记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除水表抄表记录
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "水表抄表记录删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeCbglSbcbjlEntity wuyeCbglSbcbjl = systemService.getEntity(WuyeCbglSbcbjlEntity.class, 
				id
				);
				wuyeCbglSbcbjlService.delete(wuyeCbglSbcbjl);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "水表抄表记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加水表抄表记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeCbglSbcbjlEntity wuyeCbglSbcbjl, HttpServletRequest request) {
		
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "水表抄表记录添加成功";
		try{
			wuyeCbglSbcbjlService.save(wuyeCbglSbcbjl);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "水表抄表记录添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新水表抄表记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WuyeCbglSbcbjlEntity wuyeCbglSbcbjl, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "水表抄表记录更新成功";
		WuyeCbglSbcbjlEntity t = wuyeCbglSbcbjlService.get(WuyeCbglSbcbjlEntity.class, wuyeCbglSbcbjl.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wuyeCbglSbcbjl, t);
			wuyeCbglSbcbjlService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "水表抄表记录更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 水表抄表记录新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WuyeCbglSbcbjlEntity wuyeCbglSbcbjl, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeCbglSbcbjl.getId())) {
			wuyeCbglSbcbjl = wuyeCbglSbcbjlService.getEntity(WuyeCbglSbcbjlEntity.class, wuyeCbglSbcbjl.getId());			
			req.setAttribute("wuyeCbglSbcbjlPage", wuyeCbglSbcbjl);
		}
		return new ModelAndView("com/jeecg/wuyecbgl/wuyeCbglSbcbjl-add");
	}
	/**
	 * 水表抄表记录编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WuyeCbglSbcbjlEntity wuyeCbglSbcbjl, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeCbglSbcbjl.getId())) {
			wuyeCbglSbcbjl = wuyeCbglSbcbjlService.getEntity(WuyeCbglSbcbjlEntity.class, wuyeCbglSbcbjl.getId());
			req.setAttribute("wuyeCbglSbcbjlPage", wuyeCbglSbcbjl);
		}
		return new ModelAndView("com/jeecg/wuyecbgl/wuyeCbglSbcbjl-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeCbglSbcbjlController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WuyeCbglSbcbjlEntity wuyeCbglSbcbjl,HttpServletRequest request,HttpServletResponse response, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WuyeCbglSbcbjlEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeCbglSbcbjl, request.getParameterMap());
		List<WuyeCbglSbcbjlEntity> wuyeCbglSbcbjls = this.wuyeCbglSbcbjlService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"水表抄表记录");
		modelMap.put(NormalExcelConstants.CLASS,WuyeCbglSbcbjlEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("水表抄表记录列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wuyeCbglSbcbjls);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WuyeCbglSbcbjlEntity wuyeCbglSbcbjl,HttpServletRequest request,HttpServletResponse response, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"水表抄表记录");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeCbglSbcbjlEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("水表抄表记录列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	/*
	 * 导出生成模板
	 */
	
	@RequestMapping(params = "dcscmb")
	public String dcScmb(WuyeCbglSbcbjlEntity wuyeCbglSbcbjl,HttpServletRequest request,HttpServletResponse response, DataGrid dataGrid,ModelMap modelMap) throws Exception {
		List<WuyeCbglSbcbjlEntity> wuyeCbglSbcbjl1 = new ArrayList<WuyeCbglSbcbjlEntity>();
		List<WuyeFwxxEntity> WuyeFwxxEntity = this.systemService.findHql("from WuyeFwxxEntity where yxbz = '1' and lyid = '"+id+"'");		
		for (WuyeFwxxEntity wuyeFwxxEntity2 : WuyeFwxxEntity) {	
			List<WuyeCbglFjbEntity> WuyeCbglFjbEntity = this.systemService.findHql("from WuyeCbglFjbEntity where fjid = '"+wuyeFwxxEntity2.getFjid()+"' and yblx = 'sb' and yxbz = '1' order by ybbh");
			for (WuyeCbglFjbEntity wuyeCbglFjbEntity2 : WuyeCbglFjbEntity) {
				WuyeCbglSbcbjlEntity WuyeCbglSbcbjlEntity = new WuyeCbglSbcbjlEntity();
				WuyeCbglSbcbjlEntity.setFjid(wuyeFwxxEntity2.getFjid().intValue());
				WuyeCbglSbcbjlEntity.setGlqid(wuyeFwxxEntity2.getGlqid());
				WuyeCbglSbcbjlEntity.setFwxxid(wuyeFwxxEntity2.getId());
				List<WuyeYzglFwyzxxEntity> fwxx = systemService.findHql("from WuyeYzglFwyzxxEntity where fjid = '"+wuyeFwxxEntity2.getFjid()+"' and yxbz = '1'");
				 StringBuffer result = new StringBuffer();
					if(fwxx.size() != 0){
						if(fwxx.size() == 1){
							WuyeCbglSbcbjlEntity.setXm(fwxx.get(0).getYzMc());
						}else{
							for (WuyeYzglFwyzxxEntity wuyeYzglFwyzxxEntity : fwxx) {
								result.append(wuyeYzglFwyzxxEntity.getYzMc()+",");		
							}
							WuyeCbglSbcbjlEntity.setXm(result.toString());
						}
					}				
				WuyeCbglSbcbjlEntity.setYbid(wuyeCbglFjbEntity2.getId());
				WuyeCbglSbcbjlEntity.setYbbh(wuyeCbglFjbEntity2.getYbbh());
				WuyeCbglSbcbjlEntity.setYbsx("房间表");
				WuyeCbglSbcbjlEntity.setBl(wuyeCbglFjbEntity2.getBl());
				WuyeCbglSbcbjlEntity.setCbr(ResourceUtil.getSessionUser().getUserName());
				WuyeCbglSbcbjlEntity.setFjdz(wuyeCbglFjbEntity2.getFjdz());
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
		        	WuyeCbglSbcbjlEntity.setSyzs(syzs);
		        }else{
		        	WuyeCbglSbcbjlEntity.setSyzs(wuyeCbglFjbEntity2.getCsds());
		        }
		        WuyeCbglSbcbjlEntity.setByzs(0.0);
		        WuyeCbglSbcbjlEntity.setByyl(0.0);
		        WuyeCbglSbcbjlEntity.setHbyl(0.0);
		        WuyeCbglSbcbjlEntity.setGtl(0.0);
		        WuyeCbglSbcbjlEntity.setSjyl(0.0);
				wuyeCbglSbcbjl1.add(WuyeCbglSbcbjlEntity);
			}
		}
		List<WuyeGlqEntity> WuyeGlqEntity = this.systemService.findHql("from WuyeGlqEntity where yxbz = '1' and id = '"+id+"'");
		List<WuyeGlqEntity> WuyeGlqEntity1 = this.systemService.findHql("from WuyeGlqEntity where yxbz = '1' and id = '"+WuyeFwxxEntity.get(0).getGlqid()+"'");
    	modelMap.put(NormalExcelConstants.FILE_NAME,WuyeGlqEntity1.get(0).getGlqmc()+WuyeGlqEntity.get(0).getGlqmc()+"水表抄表模板");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeCbglSbcbjlEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams(WuyeGlqEntity1.get(0).getGlqmc()+WuyeGlqEntity.get(0).getGlqmc()+"水表抄表记录模板列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,wuyeCbglSbcbjl1);
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
				List<WuyeCbglSbcbjlEntity> listWuyeCbglSbcbjlEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeCbglSbcbjlEntity.class,params);
				for (WuyeCbglSbcbjlEntity wuyeCbglSbcbjl : listWuyeCbglSbcbjlEntitys) {
					List<WuyeFwxxEntity> wuyeFwxxEntity =  wuyeCbglSbcbjlService.findByQueryString("from WuyeFwxxEntity where fjid ='"+wuyeCbglSbcbjl.getFjid()+"' and yxbz = '1'");
					wuyeCbglSbcbjl.setGlqid(wuyeFwxxEntity.get(0).getGlqid());
					wuyeCbglSbcbjl.setFwxxid(wuyeFwxxEntity.get(0).getId());					
					if(wuyeCbglSbcbjl.getByzs()-wuyeCbglSbcbjl.getSyzs()>=0.0){
						BigDecimal b = new BigDecimal((wuyeCbglSbcbjl.getByzs()-wuyeCbglSbcbjl.getSyzs())*wuyeCbglSbcbjl.getBl());  
						wuyeCbglSbcbjl.setByyl(b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
						wuyeCbglSbcbjl.setSjyl(wuyeCbglSbcbjl.getByyl()+wuyeCbglSbcbjl.getGtl()+wuyeCbglSbcbjl.getHbyl());
					}else{
						wuyeCbglSbcbjl.setByyl(0.0);
						wuyeCbglSbcbjl.setSjyl(0.0);
					}										
					wuyeCbglSbcbjl.setCbsj(new Date());
					wuyeCbglSbcbjl.setJfqsrq(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("jfqsrq")));
					wuyeCbglSbcbjl.setJfjsrq(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("jfjsrq")));
					wuyeCbglSbcbjlService.save(wuyeCbglSbcbjl);
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
				List<WuyeCbglSbcbjlEntity> listWuyeCbglSbcbjlEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeCbglSbcbjlEntity.class,params);
				for (WuyeCbglSbcbjlEntity wuyeCbglSbcbjl : listWuyeCbglSbcbjlEntitys) {
					List<WuyeYzglFwyzxxEntity> WuyeYzglFwyzxxEntity =  wuyeCbglSbcbjlService.findByQueryString("from WuyeYzglFwyzxxEntity where fjid ='"+wuyeCbglSbcbjl.getFjid()+"' and yzMc = '"+wuyeCbglSbcbjl.getXm()+"' and yxbz = '1'");
					wuyeCbglSbcbjl.setGlqid(WuyeYzglFwyzxxEntity.get(0).getGlqid());
					wuyeCbglSbcbjl.setFwxxid(WuyeYzglFwyzxxEntity.get(0).getFwxxid());
					wuyeCbglSbcbjlService.save(wuyeCbglSbcbjl);
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
	@ApiOperation(value="水表抄表记录列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WuyeCbglSbcbjlEntity>> list() {
		List<WuyeCbglSbcbjlEntity> listWuyeCbglSbcbjls=wuyeCbglSbcbjlService.getList(WuyeCbglSbcbjlEntity.class);
		return Result.success(listWuyeCbglSbcbjls);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取水表抄表记录信息",notes="根据ID获取水表抄表记录信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WuyeCbglSbcbjlEntity task = wuyeCbglSbcbjlService.get(WuyeCbglSbcbjlEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取水表抄表记录信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建水表抄表记录")
	public ResponseMessage<?> create(@ApiParam(name="水表抄表记录对象")@RequestBody WuyeCbglSbcbjlEntity wuyeCbglSbcbjl, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeCbglSbcbjlEntity>> failures = validator.validate(wuyeCbglSbcbjl);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeCbglSbcbjlService.save(wuyeCbglSbcbjl);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("水表抄表记录信息保存失败");
		}
		return Result.success(wuyeCbglSbcbjl);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新水表抄表记录",notes="更新水表抄表记录")
	public ResponseMessage<?> update(@ApiParam(name="水表抄表记录对象")@RequestBody WuyeCbglSbcbjlEntity wuyeCbglSbcbjl) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeCbglSbcbjlEntity>> failures = validator.validate(wuyeCbglSbcbjl);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeCbglSbcbjlService.saveOrUpdate(wuyeCbglSbcbjl);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新水表抄表记录信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新水表抄表记录信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除水表抄表记录")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wuyeCbglSbcbjlService.deleteEntityById(WuyeCbglSbcbjlEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("水表抄表记录删除失败");
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
		
		List<WuyeCbglFjbEntity> WuyeCbglFjbEntity = this.systemService.findHql("from WuyeCbglFjbEntity where fjid = '"+fjid+"' and yblx = 'sb' and yxbz = '1' order by ybbh ");
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
		List<WuyeCbglFjbEntity> WuyeCbglFjbEntity = this.systemService.findHql("from WuyeCbglFjbEntity where fjid = '"+fjid+"' and yblx = 'sb' and ybbh = '"+ybbh+"' and yxbz = '1' order by ybbh ");
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
