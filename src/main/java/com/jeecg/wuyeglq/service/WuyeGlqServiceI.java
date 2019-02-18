package com.jeecg.wuyeglq.service;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeGlqServiceI extends CommonService{
	
 	public void delete(WuyeGlqEntity entity) throws Exception;
 	
 	public Serializable save(WuyeGlqEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeGlqEntity entity) throws Exception;
 	
}
