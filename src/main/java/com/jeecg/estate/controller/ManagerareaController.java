package com.jeecg.estate.controller;
import com.jeecg.estate.entity.CompanyEntity;
import com.jeecg.estate.entity.ManagerareaEntity;
import com.jeecg.estate.service.ManagerareaServiceI;

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
 * @Description: 管区表
 * @author onlineGenerator
 * @date 2019-01-21 14:59:04
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/managerareaController")
public class ManagerareaController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(ManagerareaController.class);

	@Autowired
	private ManagerareaServiceI managerareaService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 管区表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request,String fatherId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("com/jeecg/estate/managerareaList");
		mav.addObject("fatherId", fatherId);
		return mav;
		//return new ModelAndView("com/jeecg/estate/managerareaList");
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
	public void datagrid(ManagerareaEntity managerarea,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid, String fatherId) {
		CriteriaQuery cq = new CriteriaQuery(ManagerareaEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, managerarea, request.getParameterMap());
		try{
		//自定义追加查询条件
			//System.out.println("我得到了fatherId:"+fatherId);
			cq.eq("fatherId", fatherId);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.managerareaService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除管区表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ManagerareaEntity managerarea, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		managerarea = systemService.getEntity(ManagerareaEntity.class, managerarea.getId());
		message = "管区表删除成功";
		try{
			managerareaService.delete(managerarea);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "管区表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除管区表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "管区表删除成功";
		try{
			for(String id:ids.split(",")){
				ManagerareaEntity managerarea = systemService.getEntity(ManagerareaEntity.class, 
				id
				);
				managerareaService.delete(managerarea);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "管区表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加管区表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ManagerareaEntity managerarea, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "管区表添加成功";
		try{
			managerareaService.save(managerarea);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "管区表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新管区表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ManagerareaEntity managerarea, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "管区表更新成功";
		ManagerareaEntity t = managerareaService.get(ManagerareaEntity.class, managerarea.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(managerarea, t);
			managerareaService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "管区表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 管区表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ManagerareaEntity managerarea, HttpServletRequest req, String fatherId) {
		if (StringUtil.isNotEmpty(managerarea.getId())) {
			managerarea = managerareaService.getEntity(ManagerareaEntity.class, managerarea.getId());
			req.setAttribute("managerarea", managerarea);
		}
		CompanyEntity company = systemService.get(CompanyEntity.class, fatherId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("com/jeecg/estate/managerarea-add");
		mav.addObject("fatherId", fatherId);
		mav.addObject("fatherName", company.getComName());
		return mav;
	}
	/**
	 * 管区表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ManagerareaEntity managerarea, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(managerarea.getId())) {
			managerarea = managerareaService.getEntity(ManagerareaEntity.class, managerarea.getId());
			req.setAttribute("managerarea", managerarea);
		}
		return new ModelAndView("com/jeecg/estate/managerarea-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","managerareaController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(ManagerareaEntity managerarea,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(ManagerareaEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, managerarea, request.getParameterMap());
		List<ManagerareaEntity> managerareas = this.managerareaService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"管区表");
		modelMap.put(NormalExcelConstants.CLASS,ManagerareaEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("管区表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,managerareas);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ManagerareaEntity managerarea,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"管区表");
    	modelMap.put(NormalExcelConstants.CLASS,ManagerareaEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("管区表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<ManagerareaEntity> listManagerareaEntitys = ExcelImportUtil.importExcel(file.getInputStream(),ManagerareaEntity.class,params);
				for (ManagerareaEntity managerarea : listManagerareaEntitys) {
					managerareaService.save(managerarea);
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
