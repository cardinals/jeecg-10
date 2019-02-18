package com.jeecg.wuyeyzgl.controller;
import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyeglq.service.WuyeFwxxServiceI;
import com.jeecg.wuyeyzgl.Dao.WuyeYzglFwqrglDao;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwqrglEntity;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwyzxxEntity;
import com.jeecg.wuyeyzgl.service.WuyeYzglFwqrglServiceI;
import com.jeecg.wuyeyzgl.service.WuyeYzglFwyzxxServiceI;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
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
import org.jeecgframework.core.util.DateUtils;
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
 * @Description: 房屋迁入管理
 * @author onlineGenerator
 * @date 2018-03-13 09:55:15
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wuyeYzglFwqrglController")
@Api(value="WuyeYzglFwqrgl",description="房屋迁入管理",tags="wuyeYzglFwqrglController")
public class WuyeYzglFwqrglController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WuyeYzglFwqrglController.class);

	@Autowired
	private WuyeYzglFwqrglServiceI wuyeYzglFwqrglService;
	@Autowired
	private WuyeFwxxServiceI wuyeFwxxService;
	@Autowired
	private WuyeYzglFwyzxxServiceI wuyeYzglFwyzxxService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private WuyeYzglFwqrglDao wuyeYzglFwqrglDao;
	@Autowired
	private Validator validator;
	private String id;
	
	/**
	 * 房屋迁入管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "ztree")
	public ModelAndView ztree(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/wuyeyzgl/wuyeYzglFwqrglZtree");
	}
	
	/**
	 * 房屋迁入管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		this.id = request.getParameter("id");
		return new ModelAndView("com/jeecg/wuyeyzgl/wuyeYzglFwqrglList");
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
				StringBuffer hql = new StringBuffer(" from WuyeGlqEntity w where  w.yxbz <> 0  order by w.pxh ");			
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
				 }else if("4".equals(wuyeGlqEntity.getGlqlx())){
					 map.put("icon","plug-in/ztree/css/img/diy/louyu.png");
				 }
				dataList.add(map);
			}
		}
	}
	
	/**
	 * easyui AJAX请求数据
	 * @author GuoPeiZhi
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "datagrid")
	public void minidaoDatagrid(WuyeFwxxEntity entity,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {		
		if(id!=null||"".equals(id)){
			List<WuyeGlqEntity>  wuyeGlqEntityList = systemService.findByQueryString(" FROM WuyeGlqEntity WHERE id='"+id+"'");		
			String lx="";
			if("4".equals(wuyeGlqEntityList.get(0).getGlqlx()))lx="4";								
			if("3".equals(wuyeGlqEntityList.get(0).getGlqlx()))lx="3";
			if("2".equals(wuyeGlqEntityList.get(0).getGlqlx()))lx="2";
			List<WuyeFwxxEntity> wuye = wuyeYzglFwqrglDao.findByIdList(id,lx,entity);
			Integer count =wuyeYzglFwqrglDao.getCount(id,lx,entity);				
			dataGrid.setTotal(count);
			dataGrid.setResults(wuye);			
		}				
		TagUtil.datagrid(response, dataGrid);
	}
	
	
	
	
	
	
	
	
	/**
	 * 删除房屋迁入管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeYzglFwqrglEntity wuyeYzglFwqrgl, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeYzglFwqrgl = systemService.getEntity(WuyeYzglFwqrglEntity.class, wuyeYzglFwqrgl.getId());
		message = "房屋迁入管理删除成功";
		try{
			wuyeYzglFwqrglService.delete(wuyeYzglFwqrgl);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋迁入管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除房屋迁入管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房屋迁入管理删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeYzglFwqrglEntity wuyeYzglFwqrgl = systemService.getEntity(WuyeYzglFwqrglEntity.class, 
				id
				);
				wuyeYzglFwqrglService.delete(wuyeYzglFwqrgl);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋迁入管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加房屋迁入管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeYzglFwqrglEntity wuyeYzglFwqrgl, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房屋迁入管理添加成功";
		//获取数据
		String glqid = request.getParameter("glqid");
		String lyid = request.getParameter("lyid");
		String fwxxid = request.getParameter("fwxxid");
		String fjid = request.getParameter("fjid");
		String fjbh = request.getParameter("fjbh");
		String rzrq = request.getParameter("rzrq");
		String sffwdx = request.getParameter("sffwdx");
		String khid = request.getParameter("khid");
		String khxm = request.getParameter("khxm");
		if(khxm.length()<=0){
		message="客户姓名不能为空";
		j.setMsg(message);
		return j;}
		String lxdh = request.getParameter("lxdh");
		String qrhfjzt = request.getParameter("qrhfjzt");
		String sfksrq = request.getParameter("sfksrq");
		String sfjsrq = request.getParameter("sfjsrq");
		String bz = request.getParameter("bz");		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
		try{
			wuyeYzglFwqrgl.setKhid(khid);
			wuyeYzglFwqrgl.setGlqid(glqid);
			wuyeYzglFwqrgl.setLyid(lyid);
			wuyeYzglFwqrgl.setFwxxid(fwxxid);
			wuyeYzglFwqrgl.setFjid(Integer.valueOf(fjid));
			wuyeYzglFwqrgl.setFjbh(fjbh);
			if(StringUtil.isNotEmpty(rzrq))
			wuyeYzglFwqrgl.setRzrq(sdf.parse(rzrq));			
			wuyeYzglFwqrgl.setSffwdx(sffwdx);
			wuyeYzglFwqrgl.setKhid(khid);
			wuyeYzglFwqrgl.setKhxm(khxm);
			wuyeYzglFwqrgl.setLxdh(lxdh);
			wuyeYzglFwqrgl.setQrhfjzt(qrhfjzt);
			if(StringUtil.isNotEmpty(sfksrq))
			wuyeYzglFwqrgl.setSfksrq(sdf.parse(sfksrq));
			if(StringUtil.isNotEmpty(sfjsrq))			
			wuyeYzglFwqrgl.setSfjsrq(sdf.parse(sfjsrq));
			wuyeYzglFwqrgl.setBz(bz);
			
			//重新生成业主编码
			String yzbm ="";
			Map<String,Object> fwxxMap = systemService.findOneForJdbc("SELECT f.fjbh from wuye_fwxx f where f.id = '"+fwxxid+"'");
			String fwxxfjbh =null;
			Long i =1L;
			if(fwxxMap!=null&&fwxxMap.size()>0){
				 fwxxfjbh =fwxxMap.get("fjbh").toString();
				 Long l = systemService.getCountForJdbc("select count(*) from wuye_yzgl_fwyzxx where yz_bm like '"+fwxxfjbh+"%'");
				 i=l+1;
				 yzbm=fwxxfjbh+"-"+i.toString();				
			}
			//判断是否新增客户		
			if(khid==null||"".equals(khid)){
				//新增业主信息
				WuyeYzglFwyzxxEntity wuyeYzglFwyzxx = new WuyeYzglFwyzxxEntity() ;
				wuyeYzglFwyzxx.setGlqid(glqid);
				wuyeYzglFwyzxx.setFwxxid(fwxxid);
				wuyeYzglFwyzxx.setFjid(Integer.valueOf(fjid));
				wuyeYzglFwyzxx.setYzMc(khxm);
				wuyeYzglFwyzxx.setYzShouj(lxdh);
				wuyeYzglFwyzxx.setYzSx("yz");
				wuyeYzglFwyzxx.setYxbz("1");
				wuyeYzglFwyzxx.setYzBm(yzbm);				
				wuyeYzglFwyzxxService.save(wuyeYzglFwyzxx);	
				wuyeYzglFwqrgl.setKhid(wuyeYzglFwyzxx.getId());
			}else{
				//更新业主信息
			    systemService.executeSql("UPDATE wuye_yzgl_fwyzxx SET yz_bm='"+yzbm+"',fwxxid='"+fwxxid+"',glqid='"+glqid+"',fjid='"+fjid+"',yz_mc='"+khxm+"',yz_shouj='"+lxdh+"',yxbz='1'   WHERE id='"+khid+"'");
			}
			//更新房屋状态
			systemService.executeSql("UPDATE wuye_fwxx SET sffwdx='"+sffwdx+"' WHERE id='"+fwxxid+"'");
			
			wuyeYzglFwqrglService.save(wuyeYzglFwqrgl);			
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋迁入管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新房屋迁入管理
	 * 
	 * @param ids
	 * @return
	 * 
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WuyeYzglFwqrglEntity wuyeYzglFwqrgl,HttpServletRequest request) {	  			
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房屋迁入管理更新成功";
		WuyeYzglFwqrglEntity t = wuyeYzglFwqrglService.get(WuyeYzglFwqrglEntity.class, wuyeYzglFwqrgl.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(wuyeYzglFwqrgl, t);
			wuyeYzglFwqrglService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "房屋迁入管理更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 房屋迁入管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WuyeYzglFwqrglEntity wuyeYzglFwqrgl, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(wuyeYzglFwqrgl.getId())) {
			wuyeYzglFwqrgl = wuyeYzglFwqrglService.getEntity(WuyeYzglFwqrglEntity.class, wuyeYzglFwqrgl.getId());
			req.setAttribute("wuyeYzglFwqrglPage", wuyeYzglFwqrgl);
		}
		return new ModelAndView("com/jeecg/wuyeyzgl/wuyeYzglFwqrgl-add");
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
			wuyeFwxx.setFwzt("rz");
			req.setAttribute("wuyeFwxxPage", wuyeFwxx);
			req.setAttribute("rzrq",new DateUtils().getDate("yyyy-MM-dd"));
		}
		return new ModelAndView("com/jeecg/wuyeyzgl/wuyeYzglFwqrgl-update");
	}
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","wuyeYzglFwqrglController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WuyeYzglFwqrglEntity wuyeYzglFwqrgl,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WuyeYzglFwqrglEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeYzglFwqrgl, request.getParameterMap());
		List<WuyeYzglFwqrglEntity> wuyeYzglFwqrgls = this.wuyeYzglFwqrglService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"房屋迁入管理");
		modelMap.put(NormalExcelConstants.CLASS,WuyeYzglFwqrglEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("房屋迁入管理列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,wuyeYzglFwqrgls);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WuyeYzglFwqrglEntity wuyeYzglFwqrgl,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"房屋迁入管理");
    	modelMap.put(NormalExcelConstants.CLASS,WuyeYzglFwqrglEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("房屋迁入管理列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<WuyeYzglFwqrglEntity> listWuyeYzglFwqrglEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WuyeYzglFwqrglEntity.class,params);
				for (WuyeYzglFwqrglEntity wuyeYzglFwqrgl : listWuyeYzglFwqrglEntitys) {
					wuyeYzglFwqrglService.save(wuyeYzglFwqrgl);
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
	@ApiOperation(value="房屋迁入管理列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<WuyeYzglFwqrglEntity>> list() {
		List<WuyeYzglFwqrglEntity> listWuyeYzglFwqrgls=wuyeYzglFwqrglService.getList(WuyeYzglFwqrglEntity.class);
		return Result.success(listWuyeYzglFwqrgls);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取房屋迁入管理信息",notes="根据ID获取房屋迁入管理信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		WuyeYzglFwqrglEntity task = wuyeYzglFwqrglService.get(WuyeYzglFwqrglEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取房屋迁入管理信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建房屋迁入管理")
	public ResponseMessage<?> create(@ApiParam(name="房屋迁入管理对象")@RequestBody WuyeYzglFwqrglEntity wuyeYzglFwqrgl, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeYzglFwqrglEntity>> failures = validator.validate(wuyeYzglFwqrgl);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeYzglFwqrglService.save(wuyeYzglFwqrgl);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("房屋迁入管理信息保存失败");
		}
		return Result.success(wuyeYzglFwqrgl);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新房屋迁入管理",notes="更新房屋迁入管理")
	public ResponseMessage<?> update(@ApiParam(name="房屋迁入管理对象")@RequestBody WuyeYzglFwqrglEntity wuyeYzglFwqrgl) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WuyeYzglFwqrglEntity>> failures = validator.validate(wuyeYzglFwqrgl);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			wuyeYzglFwqrglService.saveOrUpdate(wuyeYzglFwqrgl);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新房屋迁入管理信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新房屋迁入管理信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除房屋迁入管理")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			wuyeYzglFwqrglService.deleteEntityById(WuyeYzglFwqrglEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("房屋迁入管理删除失败");
		}

		return Result.success();
	}
}
