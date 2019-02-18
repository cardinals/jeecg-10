package com.jeecg.wuyesfgl.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.MoneyUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeecg.wuyesfgl.dao.WuyeSfglFysqglDao;
import com.jeecg.wuyesfgl.entity.WuyeSfglFysqmxEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglFysqzbEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjlEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjlPageEntity;
import com.jeecg.wuyesfgl.service.WuyeSfglFysqglServicel;
/**
 * 物业费用收取主表
 * @author GuoPeiZhi
 */
@Controller
@RequestMapping("/wuyeSfglFysqglController")
public class WuyeSfglFysqglController  extends BaseController {	
	/**房间id*/
	private Long fjid;
	/**收费主表id*/
	private String zbid;
	@Autowired
	private SystemService systemSerive;
	@Autowired
	private WuyeSfglFysqglServicel wuyeSfglFysqglServicel;
	@Autowired
	private WuyeSfglFysqglDao wuyeSfglFysqglDao;


	/**
	 * 物业费用收取列表下拉树 页面跳转
	 * @author GuoPeiZhi
	 * @return
	 */
	@RequestMapping( params="ztree")
	public ModelAndView  ztree(){
		return new ModelAndView ("com/jeecg/wuyesfgl/wuyeSfglFysqglZtree");
	}
	
	/**
	 * 物业费用打印 页面跳转
	 * @author GuoPeiZhi
	 * @return
	 */
	@RequestMapping( params="lodop")
	public ModelAndView  lodop(String id,HttpServletRequest req){
		this.zbid=id;
		WuyeSfglFysqzbEntity entity = systemSerive.get(WuyeSfglFysqzbEntity.class, id);
		String address = wuyeSfglFysqglDao.findByFjb(entity.getFwwxxid());
		req.setAttribute("jyh", entity.getJyh());//交易号
		req.setAttribute("sjh", entity.getSjh());//收据号
		req.setAttribute("date", DateUtils.getDate("yyyy  MM  dd"));		
		req.setAttribute("address",address );//地址
		req.setAttribute("name",address+"("+entity.getYzmc()+")");
		req.setAttribute("money", entity.getSsje());//金额
		req.setAttribute("capitalMoney",MoneyUtil.amountToChinese(entity.getSsje()));//大写金额
		req.setAttribute("chargePeople", entity.getSfry());//收费人员
		TSUser user = ResourceUtil.getSessionUser();
		req.setAttribute("operator",user.getUserName());//操作人员
		req.setAttribute("DateTwo", DateUtils.getDate("yyyy-MM-dd"));
		req.setAttribute("jfny",entity.getJfnd()+"年"+entity.getJfyf()+"月");
		return new ModelAndView ("com/jeecg/wuyesfgl/lodop");
	}
		
	/**
	 * 物业费用收取列表 页面跳转
	 * @author GuoPeiZhi
	 * @return
	 */
	@RequestMapping( params="list")
	public ModelAndView  list(String id,HttpServletRequest request){
		//this.fjid = Long.valueOf(id);
		request.setAttribute("fjid", id);
		
		return new ModelAndView ("com/jeecg/wuyesfgl/wuyeSfglFysqglList");
	}	
	
	/**
	 * AJAX返回查询数据
	 * @author GuoPeiZhi
	 * @param sfdx
	 * @param jfny
	 * @param wuyeSfglYsfyjl
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping( params="datagrid")
	@ResponseBody
	public void datagrid(String sfdx,String jfny,WuyeSfglYsfyjlPageEntity wuyeSfglYsfyjl,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid){
		//判读是否查询
		String jfnd= null, jfyf = null;
		if(!"--请选择--".equals(jfny)&&null!=jfny){
			String[ ]  j = jfny.split("-");
			 jfnd = j[0];
			 jfyf = j[1];
		}	
		//查询数据
		List<WuyeSfglYsfyjlEntity> ysfyjlList =wuyeSfglFysqglDao.findByList(sfdx, jfnd, jfyf, this.fjid);			
		//查询个数
		Integer count =  wuyeSfglFysqglDao.findByCount(sfdx, jfnd, jfyf, this.fjid);
		dataGrid.setTotal(count);
		dataGrid.setResults(ysfyjlList);
	    TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * AJAX返回未收费年月
	 * @author GuoPeiZhi
	 * @param request
	 * @return
	 */
	@RequestMapping(params= "yearMonth")
	@ResponseBody
	public List<String> yearMonth(HttpServletRequest request){
		List<String> list = new ArrayList<>();
		List<WuyeSfglYsfyjlEntity>  ysfyjlEntityList= systemSerive.findByQueryString(" from  WuyeSfglYsfyjlEntity  where shzt='1' AND sfzt='0' AND fwxxid=(SELECT id FROM WuyeFwxxEntity WHERE fjid="+this.fjid+" AND yxbz='1') group by jfyf ");
		for(WuyeSfglYsfyjlEntity ysfyjlEntity : ysfyjlEntityList){
			list.add( ysfyjlEntity.getJfnd()+"-"+ysfyjlEntity.getJfyf());		
		}		 
		return list;
	}
	/**
	 * AJAX返回信息
	 * @return
	 */
	@RequestMapping(params="loadNorth")
	@ResponseBody
	public Map<String,Object> loadNorth(){
		Map<String,Object>  map = new HashMap<>();		
	    map =  systemSerive.findOneForJdbc("SELECT w.yz_mc yzmc,w.yz_shouj yzsj,x.jzmj,x.fjbh FROM wuye_yzgl_fwyzxx w JOIN wuye_fwxx x ON w.fwxxid =x.id  WHERE x.fjid='"+this.fjid+"' AND x.yxbz='1' AND w.yxbz='1' AND w.yz_sx='yz' ");
		if(map!=null&&map.size()>0){
			map.put("jfrq", DateUtils.formatDate());
		}
		return  map;
	}
	
	
	@RequestMapping(params="charge")
	@ResponseBody
	public AjaxJson charge(HttpServletRequest request){		
		AjaxJson j= wuyeSfglFysqglServicel.saveCharge(request,this.fjid);		  
		return j;
	}
	
	/**
	 * 异步输出打印数据
	 * @author GuoPeiZhi
	 * @param entity
	 * @return
	 */
	@RequestMapping(params="sftable")
	@ResponseBody
	public List<WuyeSfglFysqmxEntity> sftable(){
		List<WuyeSfglFysqmxEntity>  fysqmxEntity = systemSerive.findByQueryString("from WuyeSfglFysqmxEntity where sfzbid='"+this.zbid+"' ");
		return fysqmxEntity;
	}
}
