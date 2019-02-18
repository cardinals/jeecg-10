package com.jeecg.wuyezhgl.Controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyeglq.service.WuyeFwxxServiceI;
import com.jeecg.wuyeglq.service.WuyeGlqServiceI;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwyzxxEntity;
import com.jeecg.wuyeyzgl.service.WuyeYzglFwyzxxServiceI;
import com.jeecg.wuyezhgl.Dao.WuyeZhglZhcxDao;

import io.swagger.annotations.Api;

/**   
 * @Title: Controller  
 * @Description: 房屋状态图示
 * @author onlineGenerator
 * @date 2018-03-08 15:34:27
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wuyeZhglFwztController")
@Api(value="WuyeFwzt",description="房屋状态图示",tags="wuyeFwztController")
public class WuyeZhglFwztController extends BaseController {
	@Autowired
	private SystemService systemService;
	@Autowired
	private WuyeYzglFwyzxxServiceI wuyeYzglFwyzxxService;
	@Autowired
	private WuyeGlqServiceI wuyeGlqService;
	@Autowired
	private WuyeFwxxServiceI wuyeFwxxService;
	@Autowired
	private WuyeZhglZhcxDao wuyeZhglZhcxDao;
	/**房间Id*/
	private String fjid;
	
	@RequestMapping(params = "ztree")
	public ModelAndView ztree2(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/wuyezhgl/wuyeZhglfwztZtree");
	}
	
	/**
	 * 租赁
	 * @author GuoPeiZhi
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		this.fjid = request.getParameter("id");
		return new ModelAndView("com/jeecg/wuyezhgl/wuyeZhglFwyzxxList");
	}
	@RequestMapping(params = "listTwo")
	public ModelAndView listTwo(HttpServletRequest request) {
		this.fjid = request.getParameter("id");
		return new ModelAndView("com/jeecg/wuyezhgl/wuyeZhglFwyzxxListTwo");
	}
	/**
	 * 添加房屋业主信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WuyeYzglFwyzxxEntity wuyeYzglFwyzxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房屋业主信息添加成功";
		try{
			int  e = systemService.executeSql("update wuye_fwxx set fwzt='rz' where fjid="+fjid);
			if(e<=0){
				message = "房屋业主信息添加失败";
				j.setMsg(message);
				return j;
			}
			wuyeYzglFwyzxx.setYxbz("1");//设置状态标志
			wuyeYzglFwyzxxService.save(wuyeYzglFwyzxx);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋业主信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 房屋业主信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WuyeYzglFwyzxxEntity wuyeYzglFwyzxx, HttpServletRequest req) {
		List<WuyeFwxxEntity> fwxxList = systemService.findByQueryString("from WuyeFwxxEntity where fjid="+this.fjid);
		if(fwxxList.size()>0){
			req.setAttribute("glqid", fwxxList.get(0).getGlqid());
			req.setAttribute("fwxxid", fwxxList.get(0).getId());
			req.setAttribute("fjid",Integer.valueOf(fjid));
			req.setAttribute("yzsx", "zh");	
			//重新生成业主编码
			String yzbm ="";		
			Long i =1L;		
			Long l = systemService.getCountForJdbc("select count(*) from wuye_yzgl_fwyzxx where yz_bm like '"+fwxxList.get(0).getFjbh()+"%'");
			i=l+1L;
			yzbm=fwxxList.get(0).getFjbh()+"-"+i.toString();
			req.setAttribute("yzbm", yzbm);			
			}		
		if (StringUtil.isNotEmpty(wuyeYzglFwyzxx.getId())) {
			wuyeYzglFwyzxx = wuyeYzglFwyzxxService.getEntity(WuyeYzglFwyzxxEntity.class, wuyeYzglFwyzxx.getId());
			req.setAttribute("wuyeYzglFwyzxxPage", wuyeYzglFwyzxx);
		}
		
		return new ModelAndView("com/jeecg/wuyezhgl/wuyeYzglFwyzxx-add");
	}
	
	/**
	 * 房屋业主信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WuyeYzglFwyzxxEntity wuyeYzglFwyzxx, HttpServletRequest req) {
		
		if (StringUtil.isNotEmpty(wuyeYzglFwyzxx.getId())) {
			wuyeYzglFwyzxx = wuyeYzglFwyzxxService.getEntity(WuyeYzglFwyzxxEntity.class, wuyeYzglFwyzxx.getId());
			
			//当存在房屋主键时候
			if(!wuyeYzglFwyzxx.getFwxxid().equals("")){
				//查询房屋编号
				WuyeFwxxEntity fwxx = wuyeFwxxService.getEntity(WuyeFwxxEntity.class, wuyeYzglFwyzxx.getFwxxid());
				req.setAttribute("fjbh", fwxx.getFjbh());
				//查询楼宇号
				WuyeGlqEntity glq = wuyeGlqService.get(WuyeGlqEntity.class, fwxx.getLyid());
				req.setAttribute("louyu", glq.getGlqmc());
			}
			
			req.setAttribute("wuyeYzglFwyzxxPage", wuyeYzglFwyzxx);
		}
		return new ModelAndView("com/jeecg/wuyezhgl/wuyeYzglFwyzxx-update");
	}
	
	
	
	
	/**
	 * easyui AJAX请求数据
	 * @author GuoPeiZhi
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */
	
	@RequestMapping(params = "datagrid")
	public void datagrid(WuyeYzglFwyzxxEntity wuyeYzglFwyzxx,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WuyeYzglFwyzxxEntity.class, dataGrid);
		try{
			//自定义追加查询条件
			cq.notEq("yxbz", "0");
		 	cq.eq("fjid",Integer.valueOf(this.fjid));
			wuyeYzglFwyzxx.setYzSx("zh");
			cq.add();
			//查询条件组装器
			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeYzglFwyzxx, request.getParameterMap());
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		this.wuyeYzglFwyzxxService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}	
	
	@RequestMapping(params = "datagridTwo")
	public void datagridTwo(WuyeYzglFwyzxxEntity wuyeYzglFwyzxx,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WuyeYzglFwyzxxEntity.class, dataGrid);
		try{
			//自定义追加查询条件
			cq.notEq("yxbz", "0");
			wuyeYzglFwyzxx.setYzSx("zh");
			cq.add();
			//查询条件组装器
			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, wuyeYzglFwyzxx, request.getParameterMap());
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		this.wuyeYzglFwyzxxService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}	
	/**
	 * zTree树
	 * @author GuoPeiZhi
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
				StringBuffer hql = new StringBuffer(" from WuyeGlqEntity w where  w.yxbz <> 0");			
				List<WuyeGlqEntity> departList = this.systemService.findHql(hql.toString());
				populateTree(departList,dataList);		
		}catch(Exception e){
			e.printStackTrace();
		}
		j.setObj(dataList);
		return j;
	}
	/**
	 * 树
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
					 map.put("icon","plug-in/ztree/css/img/diy/company.png");
				 }else if("2".equals(wuyeGlqEntity.getGlqlx())){
					 map.put("icon","plug-in/ztree/css/img/diy/gysroot.png");
				 }else if("3".equals(wuyeGlqEntity.getGlqlx())){
					 map.put("icon","plug-in/ztree/css/img/diy/xiaoqu.png");
				 }else if("4".equals(wuyeGlqEntity.getGlqlx())){
					 map.put("icon","plug-in/ztree/css/img/diy/1_open.png");
				 }

				dataList.add(map);
			}
		}
	}

	/**
	 * 删除房屋业主信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WuyeYzglFwyzxxEntity wuyeYzglFwyzxx, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		wuyeYzglFwyzxx = systemService.getEntity(WuyeYzglFwyzxxEntity.class, wuyeYzglFwyzxx.getId());
		wuyeYzglFwyzxx.setYxbz("0");//修改状态
		message = "房屋业主信息删除成功";
		WuyeYzglFwyzxxEntity t = wuyeYzglFwyzxxService.get(WuyeYzglFwyzxxEntity.class, wuyeYzglFwyzxx.getId());
		try{
			/*wuyeYzglFwyzxxService.delete(wuyeYzglFwyzxx);//自带的删除方法*/	
			//更改状态的删除方法
			MyBeanUtils.copyBeanNotNull2Bean(wuyeYzglFwyzxx, t);
			wuyeYzglFwyzxxService.saveOrUpdate(t);
			//如果租户为空则改为闲置
			Integer it = wuyeZhglZhcxDao.findByCount(Long.valueOf(wuyeYzglFwyzxx.getFjid()));		
			if(it<=0){
				systemService.updateBySqlString("update wuye_fwxx set fwzt='xz' where fjid="+wuyeYzglFwyzxx.getFjid()+" and yxbz='1' ");
			}			
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋业主信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除房屋业主信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "房屋业主信息删除成功";
		try{
			for(String id:ids.split(",")){
				WuyeYzglFwyzxxEntity wuyeYzglFwyzxx = systemService.getEntity(WuyeYzglFwyzxxEntity.class,id);
				wuyeYzglFwyzxx.setYxbz("0");//修改状态
				/*wuyeYzglFwyzxxService.delete(wuyeYzglFwyzxx);//自带的删除方法*/				
				//执行修改状态删除
				wuyeYzglFwyzxxService.saveOrUpdate(wuyeYzglFwyzxx);				
				//如果租户为空则改为闲置
				Integer it= wuyeZhglZhcxDao.findByCount(Long.valueOf(wuyeYzglFwyzxx.getFjid()));
				if(it<=0){
					systemService.updateBySqlString("update wuye_fwxx set fwzt='xz' where fjid="+wuyeYzglFwyzxx.getFjid()+" and yxbz='1' ");
				}	
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋业主信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	
	
	/*
	 * 单元信息
	 */
	@RequestMapping( params = "getDyzt",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getFwzt(String lyid){
		AjaxJson j = new AjaxJson();
		List<WuyeFwxxEntity> fwxx = systemService.findHql("from WuyeFwxxEntity where lyid = '"+lyid+"' and yxbz = '1'");
		int fjs = 0;
		int fjs_rz = 0;
		int fjs_kz = 0;
		double jzmj = 0.0;
		Map<String,Object> map = null;
		List<String> dyh = new ArrayList<String>();		
		for (WuyeFwxxEntity wuyeFwxxEntity : fwxx) {			
			fjs++;
			if("rz".equals(wuyeFwxxEntity.getFwzt())){
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
			dyh.add(wuyeFwxxEntity.getDyh());
		}
		for (int i = 0; i < dyh.size(); i++) {
			for (int k = dyh.size() - 1 ; k > i; k--) {
				if(dyh.get(i).equals(dyh.get(k))){
					dyh.remove(k);
				}
			}
		}
		map = new HashMap<String,Object>();
		map.put("fjs", fjs);
		map.put("fjs_rz", fjs_rz);
		map.put("fjs_kz", fjs_kz);
		map.put("jzmj", jzmj);
		j.setAttributes(map);
		j.setObj(dyh);
		return j;
	}

	/*
	 * 楼宇信息
	 */
	@RequestMapping( params = "getFwzt",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getFwxx_Fw(String lyid,String dy,String lc){
		List<WuyeFwxxEntity> fwxx = systemService.findHql("from WuyeFwxxEntity where lyid = '"+lyid+"' and dyh ='"+dy+"' and yxbz = '1'");//' and lch = '"+lc+"
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

	/*
	 * 业主姓名
	 */
	@RequestMapping( params = "getYzxm",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getYzxm(String fjid){
		List<WuyeYzglFwyzxxEntity> fwxx = wuyeZhglZhcxDao.findByObjects(Long.valueOf(fjid));
		AjaxJson j = new AjaxJson();
		 StringBuffer result = new StringBuffer();
		if(fwxx.size() != 0){
			for (WuyeYzglFwyzxxEntity wuyeYzglFwyzxxEntity : fwxx) {
				result.append(wuyeYzglFwyzxxEntity.getYzMc()+",");		
			}
			result=result.delete(result.length()-1,result.length());
			j.setObj(result.toString());
		}else{
			j.setObj("");
		} 
		return j;
	}

}
