package com.jeecg.wuyeglq.controller;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.web.system.service.MutiLangServiceI;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglFysqzbEntity;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwyzxxEntity;
import com.jeecg.wuyeyzgl.entity.WuyeYzglYzjtcyEntity;

import io.swagger.annotations.Api;

/**   
 * @Title: Controller  
 * @Description: 房屋基本信息
 * @author onlineGenerator
 * @date 2018-03-08 15:34:27
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/wuyeFwyzgkController")
@Api(value="WuyeFwyzgk",description="房屋状态图示",tags="wuyeFwyzgkController")
public class WuyeFwyzgkController extends BaseController {
	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params = "ztree")
	public ModelAndView ztree2(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/wuyeglq/wuyeFwyzgkZtree");
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
/*
 * 房屋信息
 */
	@RequestMapping( params = "getFwxx",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getFwxx(String fjid) throws Exception{
		AjaxJson j = new AjaxJson();
		Map<String,Object> map = new HashMap<String,Object>();
		List<WuyeFwxxEntity> WuyeFwxxEntity = this.systemService.findHql("from WuyeFwxxEntity where fjid = '"+fjid+"' and yxbz = '1'");
		List<WuyeGlqEntity> WuyeGlqEntity = this.systemService.findHql("from WuyeGlqEntity where id = '"+WuyeFwxxEntity.get(0).getLyid()+"' and yxbz = '1'");
		
		List<WuyeSfglFysqzbEntity> WuyeSfglFysqzbEntity = this.systemService.findHql("from WuyeSfglFysqzbEntity where fjid = '"+fjid+"'");
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		Date date=format.parse("0000-00-00");
		double jfje = 0.0;
		double jfhj = 0.0;
		if(WuyeSfglFysqzbEntity.size() != 0){
			for (WuyeSfglFysqzbEntity wuyeSfglFysqzbEntity2 : WuyeSfglFysqzbEntity) {
				jfhj += wuyeSfglFysqzbEntity2.getYsje();
				if(wuyeSfglFysqzbEntity2.getSfsj().after(date)){
					date = wuyeSfglFysqzbEntity2.getSfsj();
					jfje = wuyeSfglFysqzbEntity2.getYsje();
				}
			}
			DecimalFormat df = new DecimalFormat("######0.00"); 
			map.put("jqjfrq", date);
			map.put("jqjfje", df.format(jfje));
			map.put("ljjfhj", df.format(jfhj));
		}else{
			map.put("jqjfrq", "无");
			map.put("jqjfje", "无");
			map.put("ljjfhj", "无");
		}

		
		map.put("fwxx", WuyeFwxxEntity.get(0));
		map.put("fwlx", getSelectType("fwlx",WuyeFwxxEntity.get(0).getFwlx()));
		map.put("fwhx", getSelectType("fwhx",WuyeFwxxEntity.get(0).getFwhx()));
		map.put("fwzt", getSelectType("fwzt",WuyeFwxxEntity.get(0).getFwzt()));
		map.put("lym", WuyeGlqEntity.get(0).getGlqmc());
		
		List<WuyeYzglFwyzxxEntity> WuyeYzglFwyzxxEntity = this.systemService.findHql("from WuyeYzglFwyzxxEntity where fjid = '"+fjid+"' and yxbz = '1'");
		List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();	
		for (WuyeYzglFwyzxxEntity wuyeYzglFwyzxxEntity2 : WuyeYzglFwyzxxEntity) {
			Map<String, Object> mutiMap = new HashMap<String, Object>();
			mutiMap.put("id", wuyeYzglFwyzxxEntity2.getId());
			mutiMap.put("xm", wuyeYzglFwyzxxEntity2.getYzMc());
			mutiMap.put("yzsx", getSelectType("yzSx",wuyeYzglFwyzxxEntity2.getYzSx()));
			mutiMap.put("yzxz", getSelectType("yzXz",wuyeYzglFwyzxxEntity2.getYzXz()));
			listMap.add(mutiMap);
		}
		map.put("yzxx", listMap);
		
		j.setAttributes(map);
		
		return j;
	}
	
	/*
	 * 业主家庭关系
	 */
	@RequestMapping( params = "getYzjtgx",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getYzjtgx(String yzid,String zb){
		AjaxJson j = new AjaxJson();
		List<WuyeYzglYzjtcyEntity> WuyeYzglYzjtcyEntity = this.systemService.findHql("from WuyeYzglYzjtcyEntity where fwyzxxid = '"+yzid+"'");
		List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();		
		for (WuyeYzglYzjtcyEntity wuyeYzglYzjtcyEntity2 : WuyeYzglYzjtcyEntity) {
			Map<String, Object> mutiMap = new HashMap<String, Object>();
			mutiMap.put("id", wuyeYzglYzjtcyEntity2.getId());
			mutiMap.put("xm", wuyeYzglYzjtcyEntity2.getJtcyxm());
			mutiMap.put("xb", getSelectType("sex", wuyeYzglYzjtcyEntity2.getXb()));
			mutiMap.put("hzgx", getSelectType("hzgx", wuyeYzglYzjtcyEntity2.getHzgx()));
			mutiMap.put("yzxz", getSelectType("yzXz", wuyeYzglYzjtcyEntity2.getGzxz()));
			listMap.add(mutiMap);
		}
		j.setObj(listMap);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("zb", zb);
		j.setAttributes(map);
		return j;
	}
	/*
	 * 查询字典
	 */
	public String getSelectType(String typegroup,String code) {
		String name = "";
		try {
			String sql = "select t.typename from t_s_type t where typegroupid = (select tg.id from t_s_typegroup tg where tg.typegroupcode=?) and typecode = '"+code+"'";
			List<Map<String, Object>> selectType = systemService.findForJdbc(sql,typegroup);
			//step.2 根据查询的结果判断是否是国际化语言，是的话转换
			List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
			MutiLangServiceI mutiLangService = ApplicationContextUtil.getContext().getBean(MutiLangServiceI.class);	
			if(selectType.size()>0) {
				for (Map<String, Object> map : selectType) {
					Map<String, Object> mutiMap = new HashMap<String, Object>();
					mutiMap.put("typename", mutiLangService.getLang(map.get("typename").toString()));
					listMap.add(mutiMap);
				}
			}
			if(listMap.size() != 0){
				name = listMap.get(0).get("typename").toString();
			}else{
				name = "无";
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	
	/*
	 * 查询历史业主信息
	 */
	
	@RequestMapping( params = "getlsyz",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getLsyzxx(String fjid){
		AjaxJson j = new AjaxJson();
		
		String sql = "select c.rzrq as rzrq ,r.rzrq as qcrq ,y.yz_mc as yzmc,y.yz_xb as yzxb from wuye_yzgl_fwqcgl c JOIN wuye_yzgl_fwqrgl r ON c.fjid = r.fjid JOIN wuye_yzgl_fwyzxx y ON y.id = c.khid JOIN wuye_yzgl_fwyzxx z ON z.id = r.khid where c.sffwdx = 'yz' and c.fjid = ?";
		List<Map<String, Object>> select = systemService.findForJdbc(sql,fjid);
		List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
		if(select.size()>0) {
			for (Map<String, Object> map : select) {
				Map<String, Object> mutiMap = new HashMap<String, Object>();
				if(map.get("yzmc") == null || map.get("yzmc").toString() == ""){
					mutiMap.put("yzmc", "无");
				}else{
					mutiMap.put("yzmc", map.get("yzmc").toString());
				}
				if(map.get("yzxb") == null || map.get("yzxb").toString() == ""){
					mutiMap.put("yzxb", "无");
				}else{
					mutiMap.put("yzxb", getSelectType("sex", map.get("yzxb").toString()));
				}
				mutiMap.put("rzrq", StringUtils.substringBeforeLast(map.get("rzrq").toString(), " "));
				mutiMap.put("qcrq", StringUtils.substringBeforeLast(map.get("qcrq").toString(), " "));
			
				listMap.add(mutiMap);
			}
		}
		j.setObj(listMap);
		return j;
	}
	
	@RequestMapping( params = "getlszh",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getLszhxx(String fjid){
		AjaxJson j = new AjaxJson();
		
		String sql = "select c.rzrq as rzrq ,r.rzrq as qcrq ,y.yz_mc as yzmc,y.yz_xb as yzxb from wuye_yzgl_fwqcgl c JOIN wuye_yzgl_fwqrgl r ON c.fjid = r.fjid JOIN wuye_yzgl_fwyzxx y ON y.id = c.khid JOIN wuye_yzgl_fwyzxx z ON z.id = r.khid where c.sffwdx = 'zh' and c.fjid = ?";
		List<Map<String, Object>> select = systemService.findForJdbc(sql,fjid);
		List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();
		if(select.size()>0) {
			for (Map<String, Object> map : select) {
				Map<String, Object> mutiMap = new HashMap<String, Object>();
				if(map.get("yzmc") == null || map.get("yzmc").toString() == ""){
					mutiMap.put("yzmc", "无");
				}else{
					mutiMap.put("yzmc", map.get("yzmc").toString());
				}
				if(map.get("yzxb") == null || map.get("yzxb").toString() == ""){
					mutiMap.put("yzxb", "无");
				}else{
					mutiMap.put("yzxb", getSelectType("sex", map.get("yzxb").toString()));
				}
				mutiMap.put("rzrq", StringUtils.substringBeforeLast(map.get("rzrq").toString(), " "));
				mutiMap.put("qcrq", StringUtils.substringBeforeLast(map.get("qcrq").toString(), " "));
			
				listMap.add(mutiMap);
			}
		}
		j.setObj(listMap);
		return j;
	}
	
}
