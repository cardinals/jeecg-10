package com.jeecg.wuyesfgl.service;
import com.jeecg.wuyesfgl.entity.WuyeSfglFysqzbEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeSfglFysqzbServiceI extends CommonService{
	
 	public void delete(WuyeSfglFysqzbEntity entity) throws Exception;
 	
 	public Serializable save(WuyeSfglFysqzbEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeSfglFysqzbEntity entity) throws Exception;
 	
}
