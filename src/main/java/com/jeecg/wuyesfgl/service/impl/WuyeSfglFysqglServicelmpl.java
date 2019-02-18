package com.jeecg.wuyesfgl.service.impl;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.wuyesfgl.dao.WuyeSfglFysqglDao;
import com.jeecg.wuyesfgl.entity.WuyeSfglFysqmxEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglFysqzbEntity;
import com.jeecg.wuyesfgl.service.WuyeSfglFysqglServicel;
import com.jeecg.wuyesfgl.service.WuyeSfglFysqmxServiceI;
import com.jeecg.wuyesfgl.service.WuyeSfglFysqzbServiceI;


/**
 * 收费主表service
 * @author GuoPeiZhi
 *
 */
@Service("wuyeSfglFysqglService")
@Transactional
public class WuyeSfglFysqglServicelmpl  implements WuyeSfglFysqglServicel {
	@Autowired
	private WuyeSfglFysqzbServiceI wuyeSfglFysqzbService;
	@Autowired
	private WuyeSfglFysqmxServiceI wuyeSfglFysqmxService;
	@Autowired
	private WuyeSfglFysqglDao wuyeSfglFysqglDao;
	
	/**
	 * 费用收取主表插入数据
	 */
	@Override
	public AjaxJson saveCharge(HttpServletRequest request,Long fjid) {
		AjaxJson j =new AjaxJson();				
		String ysfy =request.getParameter("ysfy");//应收费用
		String jfny =request.getParameter("jfny");//交费年月
		String sfdx =request.getParameter("sfdx");//收费对象
		String jffs =request.getParameter("jffs");//交费方式
		String kpfs =request.getParameter("kpfs");//开票方式
		String jfrq =request.getParameter("jfrq");//交费日期
		String zl =request.getParameter("zl");//找零
		String sffy =request.getParameter("sffy");//实收费用
		String sjh =request.getParameter("sjh");//收据号
		String fylx =request.getParameter("fylx");//费用类型
		String id =request.getParameter("ids");//收费id组	
		String msg="收费成功！";	
		//插入数据
		try {
			WuyeSfglFysqzbEntity fysqzbEntity  = wuyeSfglFysqglDao.findByObject(fjid,null);
			fysqzbEntity.setYsje(Double.valueOf(ysfy));
			fysqzbEntity.setYzmc(sfdx);
			fysqzbEntity.setJffs(jffs);
			fysqzbEntity.setFylx(fylx);
			fysqzbEntity.setKpfs(kpfs);
			fysqzbEntity.setSfsj(DateUtils.parseDate(jfrq,"yyyy-MM-dd"));
			fysqzbEntity.setZlje(Double.valueOf(zl));
			fysqzbEntity.setSsje(Double.valueOf(ysfy));	
			fysqzbEntity.setSkje(Double.valueOf(sffy));//客付金额
			TSUser user = ResourceUtil.getSessionUser();			
			fysqzbEntity.setSfry(user.getUserName());//收费人员
			Integer c = wuyeSfglFysqglDao.findBySjh(sjh);
			String str= DateUtils.date2Str(new SimpleDateFormat("yyyyMMddhhmmss"));
			fysqzbEntity.setJyh(str+(int)(Math.random()*100));//交易号
			if(c>0){
				msg="收据号重复！";
				j.setMsg(msg);
				j.setSuccess(false);
				return  j;
			}
			fysqzbEntity.setSjh(sjh);
			if(jfny!=null&&!jfny.equals("")){
				String[] strs = jfny.split("-");
				fysqzbEntity.setJfnd(strs[0]);
				fysqzbEntity.setJfyf(strs[1]);
			}		
			//插入数据
			wuyeSfglFysqzbService.save(fysqzbEntity);
			//更改收费状态
			String[] ids = id.split(",");
			for(int i=0;i<ids.length;i++){
				String jlid=ids[i];
				wuyeSfglFysqglDao.updateByObject(jlid);
				WuyeSfglFysqmxEntity entity = wuyeSfglFysqglDao.saveFysqmx(jlid);
				entity.setSfzbid(fysqzbEntity.getId());//主表id
				entity.setSflx("1");//应收类型
				wuyeSfglFysqmxService.save(entity);
				j.setObj(fysqzbEntity.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "费用收取失败！";
			j.setSuccess(false);
			//throw new BusinessException(e.getMessage());			
		}
		j.setMsg(msg);
		return j;
	}
	
}
