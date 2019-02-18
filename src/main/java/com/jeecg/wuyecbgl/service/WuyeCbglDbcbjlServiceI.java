package com.jeecg.wuyecbgl.service;
import com.jeecg.wuyecbgl.entity.WuyeCbglDbcbjlEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeCbglDbcbjlServiceI extends CommonService{
	
 	public void delete(WuyeCbglDbcbjlEntity entity) throws Exception;
 	
 	public Serializable save(WuyeCbglDbcbjlEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeCbglDbcbjlEntity entity) throws Exception;
 	
}
