package com.jeecg.wuyesfgl.service.impl;
import com.jeecg.wuyesfgl.service.WuyeSfglFysqzbServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.wuyesfgl.entity.WuyeSfglFysqzbEntity;
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

@Service("wuyeSfglFysqzbService")
@Transactional
public class WuyeSfglFysqzbServiceImpl extends CommonServiceImpl implements WuyeSfglFysqzbServiceI {

	
 	public void delete(WuyeSfglFysqzbEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WuyeSfglFysqzbEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WuyeSfglFysqzbEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WuyeSfglFysqzbEntity t) throws Exception{
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
	private void doUpdateBus(WuyeSfglFysqzbEntity t) throws Exception{
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
	private void doDelBus(WuyeSfglFysqzbEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(WuyeSfglFysqzbEntity t){
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
		map.put("lyid", t.getLyid());
		map.put("fwwxxid", t.getFwwxxid());
		map.put("fjid", t.getFjid());
		map.put("fwyzxxid", t.getFwyzxxid());
		map.put("yzmc", t.getYzmc());
		map.put("jfnd", t.getJfnd());
		map.put("jfyf", t.getJfyf());
		map.put("sjh", t.getSjh());
		map.put("fylx", t.getFylx());
		map.put("jffs", t.getJffs());
		map.put("ysje", t.getYsje());
		map.put("mlje", t.getMlje());
		map.put("znj", t.getZnj());
		map.put("ssje", t.getSsje());
		map.put("skje", t.getSkje());
		map.put("zlje", t.getZlje());
		map.put("sfry", t.getSfry());
		map.put("sfsj", t.getSfsj());
		map.put("kpfs", t.getKpfs());
		map.put("bz", t.getBz());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WuyeSfglFysqzbEntity t){
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
 		sql  = sql.replace("#{lyid}",String.valueOf(t.getLyid()));
 		sql  = sql.replace("#{fwwxxid}",String.valueOf(t.getFwwxxid()));
 		sql  = sql.replace("#{fjid}",String.valueOf(t.getFjid()));
 		sql  = sql.replace("#{fwyzxxid}",String.valueOf(t.getFwyzxxid()));
 		sql  = sql.replace("#{yzmc}",String.valueOf(t.getYzmc()));
 		sql  = sql.replace("#{jfnd}",String.valueOf(t.getJfnd()));
 		sql  = sql.replace("#{jfyf}",String.valueOf(t.getJfyf()));
 		sql  = sql.replace("#{sjh}",String.valueOf(t.getSjh()));
 		sql  = sql.replace("#{fylx}",String.valueOf(t.getFylx()));
 		sql  = sql.replace("#{jffs}",String.valueOf(t.getJffs()));
 		sql  = sql.replace("#{ysje}",String.valueOf(t.getYsje()));
 		sql  = sql.replace("#{mlje}",String.valueOf(t.getMlje()));
 		sql  = sql.replace("#{znj}",String.valueOf(t.getZnj()));
 		sql  = sql.replace("#{ssje}",String.valueOf(t.getSsje()));
 		sql  = sql.replace("#{skje}",String.valueOf(t.getSkje()));
 		sql  = sql.replace("#{zlje}",String.valueOf(t.getZlje()));
 		sql  = sql.replace("#{sfry}",String.valueOf(t.getSfry()));
 		sql  = sql.replace("#{sfsj}",String.valueOf(t.getSfsj()));
 		sql  = sql.replace("#{kpfs}",String.valueOf(t.getKpfs()));
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
					javaInter.execute("wuye_sfgl_fysqzb",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}