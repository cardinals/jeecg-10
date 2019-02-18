package com.jeecg.wuyesfgl.service;
import com.jeecg.wuyesfgl.entity.WuyeSfglYhdkxxEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeSfglYhdkxxServiceI extends CommonService{
	
 	public void delete(WuyeSfglYhdkxxEntity entity) throws Exception;
 	
 	public Serializable save(WuyeSfglYhdkxxEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeSfglYhdkxxEntity entity) throws Exception;
 	
}
