package com.jeecg.wuyesfgl.service;
import com.jeecg.wuyesfgl.entity.WuyeSfglDwdkxxEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeSfglDwdkxxServiceI extends CommonService{
	
 	public void delete(WuyeSfglDwdkxxEntity entity) throws Exception;
 	
 	public Serializable save(WuyeSfglDwdkxxEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeSfglDwdkxxEntity entity) throws Exception;
 	
}
