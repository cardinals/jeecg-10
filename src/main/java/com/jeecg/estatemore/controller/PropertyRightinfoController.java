package com.jeecg.estatemore.controller;
import com.jeecg.estatemore.entity.PropertyRightinfoEntity;
import com.jeecg.estatemore.service.PropertyRightinfoServiceI;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * @Title: Controller  
 * @Description: 房间产权信息表
 * @author onlineGenerator
 * @date 2019-01-18 15:28:50
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/propertyRightinfoController")
public class PropertyRightinfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(PropertyRightinfoController.class);

	@Autowired
	private PropertyRightinfoServiceI propertyRightinfoService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 房间产权信息表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/estatemore/propertyRightinfoList");
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
	public void datagrid(PropertyRightinfoEntity propertyRightinfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PropertyRightinfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, propertyRightinfo, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.propertyRightinfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除房间产权信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(PropertyRightinfoEntity propertyRightinfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		propertyRightinfo = systemService.getEntity(PropertyRightinfoEntity.class, propertyRightinfo.getId());
		message = "房间产权信息表删除成功";
		try{
			propertyRightinfoService.delete(propertyRightinfo);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房间产权信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除房间产权信息表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房间产权信息表删除成功";
		try{
			for(String id:ids.split(",")){
				PropertyRightinfoEntity propertyRightinfo = systemService.getEntity(PropertyRightinfoEntity.class, 
				id
				);
				propertyRightinfoService.delete(propertyRightinfo);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "房间产权信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加房间产权信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(PropertyRightinfoEntity propertyRightinfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房间产权信息表添加成功";
		try{
			propertyRightinfoService.save(propertyRightinfo);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房间产权信息表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新房间产权信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(PropertyRightinfoEntity propertyRightinfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房间产权信息表更新成功";
		PropertyRightinfoEntity t = propertyRightinfoService.get(PropertyRightinfoEntity.class, propertyRightinfo.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(propertyRightinfo, t);
			propertyRightinfoService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "房间产权信息表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 房间产权信息表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(PropertyRightinfoEntity propertyRightinfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(propertyRightinfo.getId())) {
			propertyRightinfo = propertyRightinfoService.getEntity(PropertyRightinfoEntity.class, propertyRightinfo.getId());
			req.setAttribute("propertyRightinfo", propertyRightinfo);
		}
		return new ModelAndView("com/jeecg/estatemore/propertyRightinfo-add");
	}
	/**
	 * 房间产权信息表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(PropertyRightinfoEntity propertyRightinfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(propertyRightinfo.getId())) {
			propertyRightinfo = propertyRightinfoService.getEntity(PropertyRightinfoEntity.class, propertyRightinfo.getId());
			req.setAttribute("propertyRightinfo", propertyRightinfo);
		}
		return new ModelAndView("com/jeecg/estatemore/propertyRightinfo-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","propertyRightinfoController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(PropertyRightinfoEntity propertyRightinfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(PropertyRightinfoEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, propertyRightinfo, request.getParameterMap());
		List<PropertyRightinfoEntity> propertyRightinfos = this.propertyRightinfoService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"房间产权信息表");
		modelMap.put(NormalExcelConstants.CLASS,PropertyRightinfoEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("房间产权信息表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,propertyRightinfos);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(PropertyRightinfoEntity propertyRightinfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"房间产权信息表");
    	modelMap.put(NormalExcelConstants.CLASS,PropertyRightinfoEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("房间产权信息表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<PropertyRightinfoEntity> listPropertyRightinfoEntitys = ExcelImportUtil.importExcel(file.getInputStream(),PropertyRightinfoEntity.class,params);
				for (PropertyRightinfoEntity propertyRightinfo : listPropertyRightinfoEntitys) {
					propertyRightinfoService.save(propertyRightinfo);
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
	
	
}
