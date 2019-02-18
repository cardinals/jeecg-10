package com.jeecg.wuyeyzgl.service;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwqrglEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeYzglFwqrglServiceI extends CommonService{
	
 	public void delete(WuyeYzglFwqrglEntity entity) throws Exception;
 	
 	public Serializable save(WuyeYzglFwqrglEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeYzglFwqrglEntity entity) throws Exception;
 	
}
