package com.jeecg.wuyeglq.service.impl;
import com.jeecg.wuyeglq.service.WuyeFwxxServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
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

@Service("wuyeFwxxService")
@Transactional
public class WuyeFwxxServiceImpl extends CommonServiceImpl implements WuyeFwxxServiceI {

	
 	public void delete(WuyeFwxxEntity entity) throws Exception{
 		/*super.delete(entity);*/
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WuyeFwxxEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WuyeFwxxEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WuyeFwxxEntity t) throws Exception{
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
	private void doUpdateBus(WuyeFwxxEntity t) throws Exception{
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
	private void doDelBus(WuyeFwxxEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(WuyeFwxxEntity t){
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
		map.put("fjid", t.getFjid());
		map.put("glqid", t.getGlqid());
		map.put("glid", t.getLyid());
		map.put("zlcs", t.getZlcs());
		map.put("dyh", t.getDyh());
		map.put("lch", t.getLch());
		map.put("fjbh", t.getFjbh());
		map.put("loux", t.getLoux());
		map.put("jzmj", t.getJzmj());
		map.put("tnmj", t.getTnmj());
		map.put("gtmj", t.getGtmj());
		map.put("ytmj", t.getYtmj());
		map.put("fwhx", t.getFwhx());
		map.put("fwlx", t.getFwlx());
		map.put("zflb", t.getZflb());
		map.put("fwyt", t.getFwyt());
		map.put("fwcx", t.getFwcx());
		map.put("fwzt", t.getFwzt());
		map.put("jgrq", t.getJgrq());
		map.put("jfrq", t.getJfrq());
		map.put("zxrq", t.getZxrq());
		map.put("rzrq", t.getRzrq());
		map.put("fwcqr", t.getFwcqr());
		map.put("cqrzjlx", t.getCqrzjlx());
		map.put("cqrzjhm", t.getCqrzjhm());
		map.put("cfczbz", t.getCfczbz());
		map.put("sffwdx", t.getSffwdx());
		map.put("pxh", t.getPxh());
		map.put("yxbz", t.getYxbz());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WuyeFwxxEntity t){
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
 		sql  = sql.replace("#{fjid}",String.valueOf(t.getFjid()));
 		sql  = sql.replace("#{glqid}",String.valueOf(t.getGlqid()));
 		sql  = sql.replace("#{glid}",String.valueOf(t.getLyid()));
 		sql  = sql.replace("#{zlcs}",String.valueOf(t.getZlcs()));
 		sql  = sql.replace("#{dyh}",String.valueOf(t.getDyh()));
 		sql  = sql.replace("#{lch}",String.valueOf(t.getLch()));
 		sql  = sql.replace("#{fjbh}",String.valueOf(t.getFjbh()));
 		sql  = sql.replace("#{loux}",String.valueOf(t.getLoux()));
 		sql  = sql.replace("#{jzmj}",String.valueOf(t.getJzmj()));
 		sql  = sql.replace("#{tnmj}",String.valueOf(t.getTnmj()));
 		sql  = sql.replace("#{gtmj}",String.valueOf(t.getGtmj()));
 		sql  = sql.replace("#{ytmj}",String.valueOf(t.getYtmj()));
 		sql  = sql.replace("#{fwhx}",String.valueOf(t.getFwhx()));
 		sql  = sql.replace("#{fwlx}",String.valueOf(t.getFwlx()));
 		sql  = sql.replace("#{zflb}",String.valueOf(t.getZflb()));
 		sql  = sql.replace("#{fwyt}",String.valueOf(t.getFwyt()));
 		sql  = sql.replace("#{fwcx}",String.valueOf(t.getFwcx()));
 		sql  = sql.replace("#{fwzt}",String.valueOf(t.getFwzt()));
 		sql  = sql.replace("#{jgrq}",String.valueOf(t.getJgrq()));
 		sql  = sql.replace("#{jfrq}",String.valueOf(t.getJfrq()));
 		sql  = sql.replace("#{zxrq}",String.valueOf(t.getZxrq()));
 		sql  = sql.replace("#{rzrq}",String.valueOf(t.getRzrq()));
 		sql  = sql.replace("#{fwcqr}",String.valueOf(t.getFwcqr()));
 		sql  = sql.replace("#{cqrzjlx}",String.valueOf(t.getCqrzjlx()));
 		sql  = sql.replace("#{cqrzjhm}",String.valueOf(t.getCqrzjhm()));
 		sql  = sql.replace("#{cfczbz}",String.valueOf(t.getCfczbz()));
 		sql  = sql.replace("#{sffwdx}",String.valueOf(t.getSffwdx()));
 		sql  = sql.replace("#{pxh}",String.valueOf(t.getPxh()));
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
					javaInter.execute("wuye_fwxx",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}