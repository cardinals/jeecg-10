package com.jeecg.wuyeyzgl.service.impl;
import com.jeecg.wuyeyzgl.service.WuyeYzglFwqcglServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwqcglEntity;
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

@Service("wuyeYzglFwqcglService")
@Transactional
public class WuyeYzglFwqcglServiceImpl extends CommonServiceImpl implements WuyeYzglFwqcglServiceI {

	
 	public void delete(WuyeYzglFwqcglEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WuyeYzglFwqcglEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WuyeYzglFwqcglEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WuyeYzglFwqcglEntity t) throws Exception{
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
	private void doUpdateBus(WuyeYzglFwqcglEntity t) throws Exception{
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
	private void doDelBus(WuyeYzglFwqcglEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(WuyeYzglFwqcglEntity t){
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
		map.put("fjbh", t.getFjbh());
		map.put("rzrq", t.getRzrq());
		map.put("sffwdx", t.getSffwdx());
		map.put("khid", t.getKhid());
		map.put("khxm", t.getKhxm());
		map.put("lxdh", t.getLxdh());
		map.put("qrhfjzt", t.getQrhfjzt());
		map.put("sfksrq", t.getSfksrq());
		map.put("sfjsrq", t.getSfjsrq());
		map.put("bz", t.getBz());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WuyeYzglFwqcglEntity t){
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
 		sql  = sql.replace("#{fjbh}",String.valueOf(t.getFjbh()));
 		sql  = sql.replace("#{rzrq}",String.valueOf(t.getRzrq()));
 		sql  = sql.replace("#{sffwdx}",String.valueOf(t.getSffwdx()));
 		sql  = sql.replace("#{khid}",String.valueOf(t.getKhid()));
 		sql  = sql.replace("#{khxm}",String.valueOf(t.getKhxm()));
 		sql  = sql.replace("#{lxdh}",String.valueOf(t.getLxdh()));
 		sql  = sql.replace("#{qrhfjzt}",String.valueOf(t.getQrhfjzt()));
 		sql  = sql.replace("#{sfksrq}",String.valueOf(t.getSfksrq()));
 		sql  = sql.replace("#{sfjsrq}",String.valueOf(t.getSfjsrq()));
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
					javaInter.execute("wuye_yzgl_fwqcgl",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}