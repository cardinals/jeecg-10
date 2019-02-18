package com.jeecg.wuyesfgl.service.impl;
import com.jeecg.wuyesfgl.service.WuyeSfglFysqmxServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.wuyesfgl.entity.WuyeSfglFysqmxEntity;
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

@Service("wuyeSfglFysqmxService")
@Transactional
public class WuyeSfglFysqmxServiceImpl extends CommonServiceImpl implements WuyeSfglFysqmxServiceI {

	
 	public void delete(WuyeSfglFysqmxEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WuyeSfglFysqmxEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WuyeSfglFysqmxEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WuyeSfglFysqmxEntity t) throws Exception{
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
	private void doUpdateBus(WuyeSfglFysqmxEntity t) throws Exception{
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
	private void doDelBus(WuyeSfglFysqmxEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(WuyeSfglFysqmxEntity t){
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
		map.put("sfzbid", t.getSfzbid());
		map.put("ysfyjlid", t.getYsfyjlid());
		map.put("sflx", t.getSflx());
		map.put("sfzt", t.getSfzt());
		map.put("sfxmdm", t.getSfxmdm());
		map.put("sfxmmc", t.getSfxmmc());
		map.put("jfqssj", t.getJfqssj());
		map.put("jfjzsj", t.getJfjzsj());
		map.put("sl", t.getSl());
		map.put("jg", t.getJg());
		map.put("ysje", t.getYsje());
		map.put("ssje", t.getSsje());
		map.put("znj", t.getZnj());
		map.put("bz", t.getBz());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WuyeSfglFysqmxEntity t){
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
 		sql  = sql.replace("#{sfzbid}",String.valueOf(t.getSfzbid()));
 		sql  = sql.replace("#{ysfyjlid}",String.valueOf(t.getYsfyjlid()));
 		sql  = sql.replace("#{sflx}",String.valueOf(t.getSflx()));
 		sql  = sql.replace("#{sfzt}",String.valueOf(t.getSfzt()));
 		sql  = sql.replace("#{sfxmdm}",String.valueOf(t.getSfxmdm()));
 		sql  = sql.replace("#{sfxmmc}",String.valueOf(t.getSfxmmc()));
 		sql  = sql.replace("#{jfqssj}",String.valueOf(t.getJfqssj()));
 		sql  = sql.replace("#{jfjzsj}",String.valueOf(t.getJfjzsj()));
 		sql  = sql.replace("#{sl}",String.valueOf(t.getSl()));
 		sql  = sql.replace("#{jg}",String.valueOf(t.getJg()));
 		sql  = sql.replace("#{ysje}",String.valueOf(t.getYsje()));
 		sql  = sql.replace("#{ssje}",String.valueOf(t.getSsje()));
 		sql  = sql.replace("#{znj}",String.valueOf(t.getZnj()));
 		sql  = sql.replace("#{bz}",String.valueOf(t.getBz()));
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
					javaInter.execute("wuye_sfgl_fysqmx",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}