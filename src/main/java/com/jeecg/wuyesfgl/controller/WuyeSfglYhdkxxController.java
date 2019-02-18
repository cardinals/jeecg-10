package com.jeecg.wuyesfgl.controller;
import com.jeecg.wuyesfgl.dao.WuyeSfglYhdkxxDao;
import com.jeecg.wuyesfgl.dao.WuyeSfglYsfyjlDao;
import com.jeecg.wuyesfgl.entity.WuyeSfglDkxxzbEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYhdkxxEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYhdkxxPageEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjlEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjlPageEntity;
import com.jeecg.wuyesfgl.service.WuyeSfglYhdkxxServiceI;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwyzxxEntity;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
 * @Description: 银行代扣信息表
 * @author onlineGenerator
 * @date 2018-03-30 15:20:16
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wuyeSfglYhdkxxController")
@Api(value="WuyeSfglYhdkxx",description="银行代扣信息表",tags="wuyeSfglYhdkxxController")
public class WuyeSfglYhdkxxController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WuyeSfglYhdkxxController.class);

	@Autowired
	private WuyeSfglYhdkxxServiceI wuyeSfglYhdkxxService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private WuyeSfglYsfyjlDao wuyeSfglYsfyjlDao; 
	@Autowired
	private WuyeSfglYhdkxxDao wuyeSfglYhdkxxjlDao; 
	
	//银行代扣主表id
	private String zbid;

	String str = "'";
	/**
	 * 银行代扣信息表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(String zbid,HttpServletRequest request) {
		this.zbid = zbid;
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglYhdkxxList");
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
	public void datagrid(WuyeSfglYhdkxxEntity wuyeSfglYhdkxx,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		/**通过主表主键，查询出代扣主表信息*/
		WuyeSfglDkxxzbEntity dkxxzb = systemService.getEntity(WuyeSfglDkxxzbEntity.class,this.zbid);
		//查询数据
		List<WuyeSfglYhdkxxEntity> yhdkxx = wuyeSfglYhdkxxjlDao.findListByYearAndMonthAndYhbm(dkxxzb); 
		
		//查询数目
		int count = wuyeSfglYhdkxxjlDao.findListByYearAndMonthAndYhbmCount(dkxxzb); 
		
		//查询个数
		
		dataGrid.setTotal(count);
		dataGrid.setResults(yhdkxx);
		TagUtil.datagrid(response, dataGrid);
	}
	
	
	/**
	 * 删除银行代扣信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeSfglYhdkxxEntity wuyeSfglYhdkxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeSfglYhdkxx = systemService.getEntity(WuyeSfglYhdkxxEntity.class, wuyeSfglYhdkxx.getId());
		message = "银行代扣信息表删除成功";
		try{
			wuyeSfglYhdkxxService.delete(wuyeSfglYhdkxx);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "银行代扣信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 查看扣费明细
	 * 
	 * @return
	 */
	@RequestMapping(params = "goDetails")
	@ResponseBody
	public ModelAndView goDetails(WuyeSfglYhdkxxEntity wuyeSfglYhdkxx, HttpServletRequest request) {
		//System.out.println("..."+wuyeSfglYhdkxx.getId());
		HttpSession session = request.getSession();
		session.setAttribute("dkxxid", wuyeSfglYhdkxx.getId());
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglDkxxDetailList");
	}
	
	/**
	 * 批量删除银行代扣信息表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "银行代扣信息表删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeSfglYhdkxxEntity wuyeSfglYhdkxx = systemService.getEntity(WuyeSfglYhdkxxEntity.class, 
				id
				);
				wuyeSfglYhdkxxService.delete(wuyeSfglYhdkxx);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "银行代扣信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加银行代扣信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeSfglYhdkxxEntity wuyeSfglYhdkxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "银行代扣信息表添加成功";
		try{
			wuyeSfglYhdkxxService.save(wuyeSfglYhdkxx);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "银行代扣信息表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新银行代扣信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WuyeSfglYhdkxxEntity wuyeSfglYhdkxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "银行代扣信息表更新成功";
		WuyeSfglYhdkxxEntity t = wuyeSfglYhdkxxService.get(WuyeSfglYhdkxxEntity.class, wuyeSfglYhdkxx.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wuyeSfglYhdkxx, t);
			wuyeSfglYhdkxxService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "银行代扣信息表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 银行代扣信息表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WuyeSfglYhdkxxEntity wuyeSfglYhdkxx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeSfglYhdkxx.getId())) {
			wuyeSfglYhdkxx = wuyeSfglYhdkxxService.getEntity(WuyeSfglYhdkxxEntity.class, wuyeSfglYhdkxx.getId());
			req.setAttribute("wuyeSfglYhdkxxPage", wuyeSfglYhdkxx);
		}
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglYhdkxx-add");
	}
	/**
	 * 银行代扣信息表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WuyeSfglYhdkxxEntity wuyeSfglYhdkxx, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeSfglYhdkxx.getId())) {
			wuyeSfglYhdkxx = wuyeSfglYhdkxxService.getEntity(WuyeSfglYhdkxxEntity.class, wuyeSfglYhdkxx.getId());
			req.setAttribute("wuyeSfglYhdkxxPage", wuyeSfglYhdkxx);
		}
		return new ModelAndView("com/jeecg/wuyesfgl/wuyeSfglYhdkxx-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeSfglYhdkxxController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WuyeSfglYhdkxxEntity wuyeSfglYhdkxx,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		
		/**通过主表主键，查询出代扣主表信息*/
		WuyeSfglDkxxzbEntity dkxxzb = systemService.getEntity(WuyeSfglDkxxzbEntity.class,this.zbid);
		String year = dkxxzb.getYear();
		String month = dkxxzb.getMonth();
		String yhbm = dkxxzb.getYhbm();
		String yhmc = "";
		switch (yhbm) {
		case "95588":
			yhmc = "工商银行";
			break;
		case "95533":
			yhmc = "建设银行";
			break;
		case "95566":
			yhmc = "中国银行";
			break;
		case "95599":
			yhmc = "农业银行";
			break;
		case "96588":
			yhmc = "齐商银行";
			break;
		}
		
		List<WuyeSfglYhdkxxEntity> wuyeSfglYhdkxxs = wuyeSfglYhdkxxjlDao.findByYearAndMonth(dkxxzb);
			
		//导出文件名称
		String fileName = year+"年"+month+"月"+yhmc+"缴费明细";
		modelMap.put(NormalExcelConstants.FILE_NAME,fileName);
		modelMap.put(NormalExcelConstants.CLASS,WuyeSfglYhdkxxEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams(fileName, "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wuyeSfglYhdkxxs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WuyeSfglYhdkxxEntity wuyeSfglYhdkxx,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"银行代扣信息表");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeSfglYhdkxxEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("银行代扣信息表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	
	/**导入*/
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		
		/**通过主表主键，查询出代扣主表信息*/
		WuyeSfglDkxxzbEntity dkxxzb = systemService.getEntity(WuyeSfglDkxxzbEntity.class,this.zbid);
		
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
				List<WuyeSfglYhdkxxEntity> listWuyeSfglYhdkxxEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeSfglYhdkxxEntity.class,params);
				
				
				//先删除这年这月的信息
				int s = wuyeSfglYhdkxxjlDao.deleteByYearAndMonthAndYhbm(dkxxzb);
				//System.out.println(s);
				String sfzt = "0";
				for (WuyeSfglYhdkxxEntity yhdkxx : listWuyeSfglYhdkxxEntitys) {
					//再增加
					wuyeSfglYhdkxxService.save(yhdkxx);
					//扣费成功了，就把收费状态改成银行代扣
					if("成功".equals(yhdkxx.getZt())){
						sfzt = "3";
					}
					//根据银行账户，查询业主主键
					List<WuyeYzglFwyzxxEntity> fwyzxx = systemService.findByQueryString("from WuyeYzglFwyzxxEntity where dkr_dkyhzh ="+str+yhdkxx.getZh()+str);
					String fwyzxxid = fwyzxx.get(0).getId();
					//执行更新操作
					int i = wuyeSfglYsfyjlDao.updateDkxxzj(yhdkxx.getId(),dkxxzb.getYear(),dkxxzb.getMonth(),fwyzxxid,sfzt);
					
					
				}
				/**导入成功后，更新代扣主表信息*/
				dkxxzb.setSfyjdr("1");
				systemService.saveOrUpdate(dkxxzb);
				
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
	@ApiOperation(value="银行代扣信息表列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WuyeSfglYhdkxxEntity>> list() {
		List<WuyeSfglYhdkxxEntity> listWuyeSfglYhdkxxs=wuyeSfglYhdkxxService.getList(WuyeSfglYhdkxxEntity.class);
		return Result.success(listWuyeSfglYhdkxxs);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取银行代扣信息表信息",notes="根据ID获取银行代扣信息表信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WuyeSfglYhdkxxEntity task = wuyeSfglYhdkxxService.get(WuyeSfglYhdkxxEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取银行代扣信息表信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建银行代扣信息表")
	public ResponseMessage<?> create(@ApiParam(name="银行代扣信息表对象")@RequestBody WuyeSfglYhdkxxEntity wuyeSfglYhdkxx, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeSfglYhdkxxEntity>> failures = validator.validate(wuyeSfglYhdkxx);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeSfglYhdkxxService.save(wuyeSfglYhdkxx);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("银行代扣信息表信息保存失败");
		}
		return Result.success(wuyeSfglYhdkxx);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新银行代扣信息表",notes="更新银行代扣信息表")
	public ResponseMessage<?> update(@ApiParam(name="银行代扣信息表对象")@RequestBody WuyeSfglYhdkxxEntity wuyeSfglYhdkxx) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeSfglYhdkxxEntity>> failures = validator.validate(wuyeSfglYhdkxx);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeSfglYhdkxxService.saveOrUpdate(wuyeSfglYhdkxx);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新银行代扣信息表信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新银行代扣信息表信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除银行代扣信息表")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wuyeSfglYhdkxxService.deleteEntityById(WuyeSfglYhdkxxEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("银行代扣信息表删除失败");
		}

		return Result.success();
	}
}
