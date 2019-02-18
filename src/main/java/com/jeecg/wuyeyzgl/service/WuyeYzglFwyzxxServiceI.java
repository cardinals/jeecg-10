package com.jeecg.wuyeyzgl.service;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwyzxxEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeYzglFwyzxxServiceI extends CommonService{
	
 	public void delete(WuyeYzglFwyzxxEntity entity) throws Exception;
 	
 	public Serializable save(WuyeYzglFwyzxxEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeYzglFwyzxxEntity entity) throws Exception;
 	
}
