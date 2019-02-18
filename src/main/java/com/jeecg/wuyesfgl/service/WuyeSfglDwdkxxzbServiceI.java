package com.jeecg.wuyesfgl.service;
import com.jeecg.wuyesfgl.entity.WuyeSfglDwdkxxzbEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeSfglDwdkxxzbServiceI extends CommonService{
	
 	public void delete(WuyeSfglDwdkxxzbEntity entity) throws Exception;
 	
 	public Serializable save(WuyeSfglDwdkxxzbEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeSfglDwdkxxzbEntity entity) throws Exception;
 	
}
