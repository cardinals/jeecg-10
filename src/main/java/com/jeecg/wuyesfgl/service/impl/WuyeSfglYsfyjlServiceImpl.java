package com.jeecg.wuyesfgl.service.impl;
import com.jeecg.wuyesfgl.service.WuyeSfglYsfyjlServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjlEntity;
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

@Service("wuyeSfglYsfyjlService")
@Transactional
public class WuyeSfglYsfyjlServiceImpl extends CommonServiceImpl implements WuyeSfglYsfyjlServiceI {

	
 	public void delete(WuyeSfglYsfyjlEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WuyeSfglYsfyjlEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WuyeSfglYsfyjlEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WuyeSfglYsfyjlEntity t) throws Exception{
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
	private void doUpdateBus(WuyeSfglYsfyjlEntity t) throws Exception{
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
	private void doDelBus(WuyeSfglYsfyjlEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(WuyeSfglYsfyjlEntity t){
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
		map.put("xqid", t.getXqid());
		map.put("lyid", t.getLyid());
		map.put("fwxxid", t.getFwxxid());
		map.put("fjid", t.getFjid());
		map.put("fwyzxxid", t.getFwyzxxid());
		map.put("yzmc", t.getYzmc());
		map.put("sfzt", t.getSfzt());
		map.put("sfxmdm", t.getSfxmdm());
		map.put("sfxmmc", t.getSfxmmc());
		map.put("jfqssj", t.getJfqssj());
		map.put("jfjzsj", t.getJfjzsj());
		map.put("sl", t.getSl());
		map.put("jg", t.getJg());
		map.put("ysje", t.getYsje());
		map.put("qss", t.getQss());
		map.put("jzs", t.getJzs());
		map.put("bl", t.getBl());
		map.put("gts", t.getGts());
		map.put("jfnd", t.getJfnd());
		map.put("jfyf", t.getJfyf());
		map.put("sfqsrq", t.getSfqsrq());
		map.put("sfjzrq", t.getSfjzrq());
		map.put("znjqsrq", t.getZnjqsrq());
		map.put("bz", t.getBz());
		map.put("shzt", t.getShzt());
		map.put("shsj", t.getShsj());
		map.put("shry", t.getShry());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WuyeSfglYsfyjlEntity t){
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
 		sql  = sql.replace("#{xqid}",String.valueOf(t.getXqid()));
 		sql  = sql.replace("#{lyid}",String.valueOf(t.getLyid()));
 		sql  = sql.replace("#{fwxxid}",String.valueOf(t.getFwxxid()));
 		sql  = sql.replace("#{fjid}",String.valueOf(t.getFjid()));
 		sql  = sql.replace("#{fwyzxxid}",String.valueOf(t.getFwyzxxid()));
 		sql  = sql.replace("#{yzmc}",String.valueOf(t.getYzmc()));
 		sql  = sql.replace("#{sfzt}",String.valueOf(t.getSfzt()));
 		sql  = sql.replace("#{sfxmdm}",String.valueOf(t.getSfxmdm()));
 		sql  = sql.replace("#{sfxmmc}",String.valueOf(t.getSfxmmc()));
 		sql  = sql.replace("#{jfqssj}",String.valueOf(t.getJfqssj()));
 		sql  = sql.replace("#{jfjzsj}",String.valueOf(t.getJfjzsj()));
 		sql  = sql.replace("#{sl}",String.valueOf(t.getSl()));
 		sql  = sql.replace("#{jg}",String.valueOf(t.getJg()));
 		sql  = sql.replace("#{ysje}",String.valueOf(t.getYsje()));
 		sql  = sql.replace("#{qss}",String.valueOf(t.getQss()));
 		sql  = sql.replace("#{jzs}",String.valueOf(t.getJzs()));
 		sql  = sql.replace("#{bl}",String.valueOf(t.getBl()));
 		sql  = sql.replace("#{gts}",String.valueOf(t.getGts()));
 		sql  = sql.replace("#{jfnd}",String.valueOf(t.getJfnd()));
 		sql  = sql.replace("#{jfyf}",String.valueOf(t.getJfyf()));
 		sql  = sql.replace("#{sfqsrq}",String.valueOf(t.getSfqsrq()));
 		sql  = sql.replace("#{sfjzrq}",String.valueOf(t.getSfjzrq()));
 		sql  = sql.replace("#{znjqsrq}",String.valueOf(t.getZnjqsrq()));
 		sql  = sql.replace("#{bz}",String.valueOf(t.getBz()));
 		sql  = sql.replace("#{shzt}",String.valueOf(t.getShzt()));
 		sql  = sql.replace("#{shsj}",String.valueOf(t.getShsj()));
 		sql  = sql.replace("#{shry}",String.valueOf(t.getShry()));
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
					javaInter.execute("wuye_sfgl_ysfyjl",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}