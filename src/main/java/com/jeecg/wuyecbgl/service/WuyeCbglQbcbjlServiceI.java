package com.jeecg.wuyecbgl.service;
import com.jeecg.wuyecbgl.entity.WuyeCbglQbcbjlEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeCbglQbcbjlServiceI extends CommonService{
	
 	public void delete(WuyeCbglQbcbjlEntity entity) throws Exception;
 	
 	public Serializable save(WuyeCbglQbcbjlEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeCbglQbcbjlEntity entity) throws Exception;
 	
}
