package com.jeecg.wuyeglq.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwyzxxEntity;

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
@RequestMapping("/wuyeFwztController")
@Api(value="WuyeFwzt",description="房屋状态图示",tags="wuyeFwztController")
public class WuyeFwztController extends BaseController {
	@Autowired
	private SystemService systemService;
	
	@RequestMapping(params = "ztree2")
	public ModelAndView ztree2(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/wuyeglq/wuyefwztZtree");
	}
	

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
	 * 楼层信息
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
	@RequestMapping( params = "getYzxm_yz",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getYzxm_yz(String fjid){
		List<WuyeYzglFwyzxxEntity> fwxx = systemService.findHql("from WuyeYzglFwyzxxEntity where fjid = '"+fjid+"' and yxbz = '1' and yz_sx = 'yz'");		
		AjaxJson j = new AjaxJson();
		 StringBuffer result = new StringBuffer();
		if(fwxx.size() != 0){
			if(fwxx.size() == 1){
				j.setObj(fwxx.get(0).getYzMc());;
			}else{
				for (WuyeYzglFwyzxxEntity wuyeYzglFwyzxxEntity : fwxx) {
					result.append(wuyeYzglFwyzxxEntity.getYzMc()+",");		
				}
				j.setObj(result.toString());
			}
		}else{
			j.setObj("");
		} 
		return j;
	}
	
	@RequestMapping( params = "getYzxm_zh",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getYzxm_zh(String fjid){
		List<WuyeYzglFwyzxxEntity> fwxx = systemService.findHql("from WuyeYzglFwyzxxEntity where fjid = '"+fjid+"' and yxbz = '1' and yz_sx = 'zh'");		
		AjaxJson j = new AjaxJson();
		 StringBuffer result = new StringBuffer();
		if(fwxx.size() != 0){
			if(fwxx.size() == 1){
				j.setObj(fwxx.get(0).getYzMc());;
			}else{
				for (WuyeYzglFwyzxxEntity wuyeYzglFwyzxxEntity : fwxx) {
					result.append(wuyeYzglFwyzxxEntity.getYzMc()+",");		
				}
				j.setObj(result.toString());
			}
		}else{
			j.setObj("");
		} 
		return j;
	}
	
}
