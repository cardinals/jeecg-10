package com.jeecg.estate.controller;
import com.jeecg.estate.entity.BuildingEntity;
import com.jeecg.estate.entity.CommunityEntity;
import com.jeecg.estate.entity.ManagerareaEntity;
import com.jeecg.estate.service.BuildingServiceI;

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
 * @Description: 楼宇表
 * @author onlineGenerator
 * @date 2019-01-18 15:27:16
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/buildingController")
public class BuildingController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(BuildingController.class);

	@Autowired
	private BuildingServiceI buildingService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 楼宇表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request, String commId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("com/jeecg/estate/buildingList");
		mav.addObject("commId", commId);
		CommunityEntity comm = systemService.get(CommunityEntity.class, commId);
		String managerId = comm.getFatherId();
		ManagerareaEntity mana = systemService.get(ManagerareaEntity.class, managerId);
		String companyId = mana.getFatherId();
		mav.addObject("managerId", managerId);
		mav.addObject("companyId", companyId);
		return mav;
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
	public void datagrid(BuildingEntity building,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid, String commId) {
		CriteriaQuery cq = new CriteriaQuery(BuildingEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, building, request.getParameterMap());
		try{
		//自定义追加查询条件
			cq.eq("commId", commId);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.buildingService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除楼宇表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(BuildingEntity building, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		building = systemService.getEntity(BuildingEntity.class, building.getId());
		message = "楼宇表删除成功";
		try{
			buildingService.delete(building);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "楼宇表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除楼宇表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "楼宇表删除成功";
		try{
			for(String id:ids.split(",")){
				BuildingEntity building = systemService.getEntity(BuildingEntity.class, 
				id
				);
				buildingService.delete(building);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "楼宇表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加楼宇表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(BuildingEntity building, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "楼宇表添加成功";
		try{
			buildingService.save(building);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "楼宇表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新楼宇表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(BuildingEntity building, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "楼宇表更新成功";
		BuildingEntity t = buildingService.get(BuildingEntity.class, building.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(building, t);
			buildingService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "楼宇表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 楼宇表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(BuildingEntity building, HttpServletRequest req, String commId,String managerId,String companyId) {
		if (StringUtil.isNotEmpty(building.getId())) {
			building = buildingService.getEntity(BuildingEntity.class, building.getId());
			req.setAttribute("building", building);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("com/jeecg/estate/building-add");
		Map<String,String> m = new HashMap<String,String>();
		m.put("commId", commId);
		m.put("managerId", managerId);
		m.put("companyId", companyId);
		mav.addObject("idMap", m);
		return mav;
	}
	/**
	 * 返回上一层
	 */
	@RequestMapping(params="goLastOne")
	public ModelAndView goLastOne(HttpServletRequest request,HttpServletResponse response,String commId) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("com/jeecg/estate/communityList");
		List<CommunityEntity> comm = systemService.findByPropertyisOrder(CommunityEntity.class, "id", commId, true);
		String fatherId = comm.get(0).getFatherId();
		mav.addObject("fatherId", fatherId);
		return mav;
	}
	/**
	 * 楼宇表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(BuildingEntity building, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(building.getId())) {
			building = buildingService.getEntity(BuildingEntity.class, building.getId());
			req.setAttribute("building", building);
		}
		return new ModelAndView("com/jeecg/estate/building-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","buildingController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(BuildingEntity building,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(BuildingEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, building, request.getParameterMap());
		List<BuildingEntity> buildings = this.buildingService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"楼宇表");
		modelMap.put(NormalExcelConstants.CLASS,BuildingEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("楼宇表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,buildings);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(BuildingEntity building,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"楼宇表");
    	modelMap.put(NormalExcelConstants.CLASS,BuildingEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("楼宇表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<BuildingEntity> listBuildingEntitys = ExcelImportUtil.importExcel(file.getInputStream(),BuildingEntity.class,params);
				for (BuildingEntity building : listBuildingEntitys) {
					buildingService.save(building);
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
