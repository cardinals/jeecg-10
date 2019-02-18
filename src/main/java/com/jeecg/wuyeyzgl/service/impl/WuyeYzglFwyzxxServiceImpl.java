package com.jeecg.wuyeyzgl.service.impl;
import com.jeecg.wuyeyzgl.service.WuyeYzglFwyzxxServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwyzxxEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("wuyeYzglFwyzxxService")
@Transactional
public class WuyeYzglFwyzxxServiceImpl extends CommonServiceImpl implements WuyeYzglFwyzxxServiceI {

	
 	public void delete(WuyeYzglFwyzxxEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WuyeYzglFwyzxxEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WuyeYzglFwyzxxEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WuyeYzglFwyzxxEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(WuyeYzglFwyzxxEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(WuyeYzglFwyzxxEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(WuyeYzglFwyzxxEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("create_name", t.getCreateName());
		map.put("create_by", t.getCreateBy());
		map.put("create_date", t.getCreateDate());
		map.put("update_name", t.getUpdateName());
		map.put("update_by", t.getUpdateBy());
		map.put("update_date", t.getUpdateDate());
		map.put("sys_org_code", t.getSysOrgCode());
		map.put("sys_company_code", t.getSysCompanyCode());
		map.put("bpm_status", t.getBpmStatus());
		map.put("glqid", t.getGlqid());
		map.put("fwxxid", t.getFwxxid());
		map.put("fjid", t.getFjid());
		map.put("yz_bm", t.getYzBm());
		map.put("yz_sx", t.getYzSx());
		map.put("yz_lx", t.getYzLx());
		map.put("yz_mc", t.getYzMc());
		map.put("yz_lxr", t.getYzLxr());
		map.put("yz_xb", t.getYzXb());
		map.put("yz_csrq", t.getYzCsrq());
		map.put("yz_sfzh", t.getYzSfzh());
		map.put("yz_gzdw", t.getYzGzdw());
		map.put("yz_zuoj", t.getYzZuoj());
		map.put("yz_shouj", t.getYzShouj());
		map.put("yz_chuanz", t.getYzChuanz());
		map.put("yz_xz", t.getYzXz());
		map.put("dkr_xm", t.getDkrXm());
		map.put("dkr_gzdw", t.getDkrGzdw());
		map.put("dkr_dkfs", t.getDkrDkfs());
		map.put("dkr_dkyh", t.getDkrDkyh());
		map.put("dkr_dkyhzh", t.getDkrDkyhzh());
		map.put("dkr_dkdw", t.getDkrDkdw());
		map.put("dkr_dkdwgh", t.getDkrDkdwgh());
		map.put("dkr_lxdh", t.getDkrLxdh());
		map.put("dkr_xz", t.getDkrXz());
		map.put("dbr_xm", t.getDbrXm());
		map.put("dbr_dw", t.getDbrDw());
		map.put("dbr_gh", t.getDbrGh());
		map.put("dbr_lxdh", t.getDbrLxdh());
		map.put("sfjm", t.getSfjm());
		map.put("jmyy", t.getJmyy());
		map.put("sfksrq", t.getSfksrq());
		map.put("sfjzrq", t.getSfjzrq());
		map.put("bz", t.getBz());
		map.put("yxbz", t.getYxbz());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WuyeYzglFwyzxxEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_by}",String.valueOf(t.getCreateBy()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_by}",String.valueOf(t.getUpdateBy()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{sys_org_code}",String.valueOf(t.getSysOrgCode()));
 		sql  = sql.replace("#{sys_company_code}",String.valueOf(t.getSysCompanyCode()));
 		sql  = sql.replace("#{bpm_status}",String.valueOf(t.getBpmStatus()));
 		sql  = sql.replace("#{glqid}",String.valueOf(t.getGlqid()));
 		sql  = sql.replace("#{fwxxid}",String.valueOf(t.getFwxxid()));
 		sql  = sql.replace("#{fjid}",String.valueOf(t.getFjid()));
 		sql  = sql.replace("#{yz_bm}",String.valueOf(t.getYzBm()));
 		sql  = sql.replace("#{yz_sx}",String.valueOf(t.getYzSx()));
 		sql  = sql.replace("#{yz_lx}",String.valueOf(t.getYzLx()));
 		sql  = sql.replace("#{yz_mc}",String.valueOf(t.getYzMc()));
 		sql  = sql.replace("#{yz_lxr}",String.valueOf(t.getYzLxr()));
 		sql  = sql.replace("#{yz_xb}",String.valueOf(t.getYzXb()));
 		sql  = sql.replace("#{yz_csrq}",String.valueOf(t.getYzCsrq()));
 		sql  = sql.replace("#{yz_sfzh}",String.valueOf(t.getYzSfzh()));
 		sql  = sql.replace("#{yz_gzdw}",String.valueOf(t.getYzGzdw()));
 		sql  = sql.replace("#{yz_zuoj}",String.valueOf(t.getYzZuoj()));
 		sql  = sql.replace("#{yz_shouj}",String.valueOf(t.getYzShouj()));
 		sql  = sql.replace("#{yz_chuanz}",String.valueOf(t.getYzChuanz()));
 		sql  = sql.replace("#{yz_xz}",String.valueOf(t.getYzXz()));
 		sql  = sql.replace("#{dkr_xm}",String.valueOf(t.getDkrXm()));
 		sql  = sql.replace("#{dkr_gzdw}",String.valueOf(t.getDkrGzdw()));
 		sql  = sql.replace("#{dkr_dkfs}",String.valueOf(t.getDkrDkfs()));
 		sql  = sql.replace("#{dkr_dkyh}",String.valueOf(t.getDkrDkyh()));
 		sql  = sql.replace("#{dkr_dkyhzh}",String.valueOf(t.getDkrDkyhzh()));
 		sql  = sql.replace("#{dkr_dkdw}",String.valueOf(t.getDkrDkdw()));
 		sql  = sql.replace("#{dkr_dkdwgh}",String.valueOf(t.getDkrDkdwgh()));
 		sql  = sql.replace("#{dkr_lxdh}",String.valueOf(t.getDkrLxdh()));
 		sql  = sql.replace("#{dkr_xz}",String.valueOf(t.getDkrXz()));
 		sql  = sql.replace("#{dbr_xm}",String.valueOf(t.getDbrXm()));
 		sql  = sql.replace("#{dbr_dw}",String.valueOf(t.getDbrDw()));
 		sql  = sql.replace("#{dbr_gh}",String.valueOf(t.getDbrGh()));
 		sql  = sql.replace("#{dbr_lxdh}",String.valueOf(t.getDbrLxdh()));
 		sql  = sql.replace("#{sfjm}",String.valueOf(t.getSfjm()));
 		sql  = sql.replace("#{jmyy}",String.valueOf(t.getJmyy()));
 		sql  = sql.replace("#{sfksrq}",String.valueOf(t.getSfksrq()));
 		sql  = sql.replace("#{sfjzrq}",String.valueOf(t.getSfjzrq()));
 		sql  = sql.replace("#{bz}",String.valueOf(t.getBz()));
 		sql  = sql.replace("#{yxbz}",String.valueOf(t.getYxbz()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute("wuye_yzgl_fwyzxx",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}