package com.jeecg.wuyesfgl.service;
import com.jeecg.wuyesfgl.entity.WuyeSfglFjsfxmszEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeSfglFjsfxmszServiceI extends CommonService{
	
 	public void delete(WuyeSfglFjsfxmszEntity entity) throws Exception;
 	
 	public Serializable save(WuyeSfglFjsfxmszEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeSfglFjsfxmszEntity entity) throws Exception;
 	
}
