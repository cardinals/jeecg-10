package com.jeecg.wuyesfgl.service;
import com.jeecg.wuyesfgl.entity.WuyeSfglFysqmxEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeSfglFysqmxServiceI extends CommonService{
	
 	public void delete(WuyeSfglFysqmxEntity entity) throws Exception;
 	
 	public Serializable save(WuyeSfglFysqmxEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeSfglFysqmxEntity entity) throws Exception;
 	
}
