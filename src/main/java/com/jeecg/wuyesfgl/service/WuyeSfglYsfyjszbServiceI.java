package com.jeecg.wuyesfgl.service;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjszbEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeSfglYsfyjszbServiceI extends CommonService{
	
 	public void delete(WuyeSfglYsfyjszbEntity entity) throws Exception;
 	
 	public Serializable save(WuyeSfglYsfyjszbEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeSfglYsfyjszbEntity entity) throws Exception;
 	
}
