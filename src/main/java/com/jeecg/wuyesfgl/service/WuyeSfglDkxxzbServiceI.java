package com.jeecg.wuyesfgl.service;
import com.jeecg.wuyesfgl.entity.WuyeSfglDkxxzbEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeSfglDkxxzbServiceI extends CommonService{
	
 	public void delete(WuyeSfglDkxxzbEntity entity) throws Exception;
 	
 	public Serializable save(WuyeSfglDkxxzbEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeSfglDkxxzbEntity entity) throws Exception;
 	
}
