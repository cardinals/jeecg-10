package com.jeecg.wuyeyzgl.service;
import com.jeecg.wuyeyzgl.entity.WuyeYzglYzjtcyEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeYzglYzjtcyServiceI extends CommonService{
	
 	public void delete(WuyeYzglYzjtcyEntity entity) throws Exception;
 	
 	public Serializable save(WuyeYzglYzjtcyEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeYzglYzjtcyEntity entity) throws Exception;
 	
}
