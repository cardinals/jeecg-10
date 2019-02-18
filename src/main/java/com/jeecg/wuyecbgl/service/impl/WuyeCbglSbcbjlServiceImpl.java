package com.jeecg.wuyecbgl.service.impl;
import com.jeecg.wuyecbgl.service.WuyeCbglSbcbjlServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.wuyecbgl.entity.WuyeCbglSbcbjlEntity;
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

@Service("wuyeCbglSbcbjlService")
@Transactional
public class WuyeCbglSbcbjlServiceImpl extends CommonServiceImpl implements WuyeCbglSbcbjlServiceI {

	
 	public void delete(WuyeCbglSbcbjlEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WuyeCbglSbcbjlEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WuyeCbglSbcbjlEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WuyeCbglSbcbjlEntity t) throws Exception{
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
	private void doUpdateBus(WuyeCbglSbcbjlEntity t) throws Exception{
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
	private void doDelBus(WuyeCbglSbcbjlEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(WuyeCbglSbcbjlEntity t){
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
		map.put("fjdz", t.getFjdz());
		map.put("xm", t.getXm());
		map.put("ybsx", t.getYbsx());
		map.put("ybid", t.getYbid());
		map.put("ybbh", t.getYbbh());
		map.put("syzs", t.getSyzs());
		map.put("byzs", t.getByzs());
		map.put("bl", t.getBl());
		map.put("byyl", t.getByyl());
		map.put("hbyl", t.getHbyl());
		map.put("gtl", t.getGtl());
		map.put("sjyl", t.getSjyl());
		map.put("cbr", t.getCbr());
		map.put("cbsj", t.getCbsj());
		map.put("bz", t.getBz());
		map.put("jfqsrq", t.getJfqsrq());
		map.put("jfjsrq", t.getJfjsrq());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WuyeCbglSbcbjlEntity t){
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
 		sql  = sql.replace("#{fjdz}",String.valueOf(t.getFjdz()));
 		sql  = sql.replace("#{xm}",String.valueOf(t.getXm()));
 		sql  = sql.replace("#{ybsx}",String.valueOf(t.getYbsx()));
 		sql  = sql.replace("#{ybid}",String.valueOf(t.getYbid()));
 		sql  = sql.replace("#{ybbh}",String.valueOf(t.getYbbh()));
 		sql  = sql.replace("#{syzs}",String.valueOf(t.getSyzs()));
 		sql  = sql.replace("#{byzs}",String.valueOf(t.getByzs()));
 		sql  = sql.replace("#{bl}",String.valueOf(t.getBl()));
 		sql  = sql.replace("#{byyl}",String.valueOf(t.getByyl()));
 		sql  = sql.replace("#{hbyl}",String.valueOf(t.getHbyl()));
 		sql  = sql.replace("#{gtl}",String.valueOf(t.getGtl()));
 		sql  = sql.replace("#{sjyl}",String.valueOf(t.getSjyl()));
 		sql  = sql.replace("#{cbr}",String.valueOf(t.getCbr()));
 		sql  = sql.replace("#{cbsj}",String.valueOf(t.getCbsj()));
 		sql  = sql.replace("#{bz}",String.valueOf(t.getBz()));
 		sql  = sql.replace("#{jfqsrq}",String.valueOf(t.getJfqsrq()));
 		sql  = sql.replace("#{jfjsrq}",String.valueOf(t.getJfjsrq()));
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
					javaInter.execute("wuye_cbgl_sbcbjl",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}