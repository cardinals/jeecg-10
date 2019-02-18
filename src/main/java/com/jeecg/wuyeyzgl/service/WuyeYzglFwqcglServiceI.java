package com.jeecg.wuyeyzgl.service;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwqcglEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeYzglFwqcglServiceI extends CommonService{
	
 	public void delete(WuyeYzglFwqcglEntity entity) throws Exception;
 	
 	public Serializable save(WuyeYzglFwqcglEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeYzglFwqcglEntity entity) throws Exception;
 	
}
