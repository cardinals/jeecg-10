package com.jeecg.wuyesfgl.service;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjlEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeSfglYsfyjlServiceI extends CommonService{
	
 	public void delete(WuyeSfglYsfyjlEntity entity) throws Exception;
 	
 	public Serializable save(WuyeSfglYsfyjlEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeSfglYsfyjlEntity entity) throws Exception;
 	
}
