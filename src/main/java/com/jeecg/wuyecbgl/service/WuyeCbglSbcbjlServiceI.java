package com.jeecg.wuyecbgl.service;
import com.jeecg.wuyecbgl.entity.WuyeCbglSbcbjlEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeCbglSbcbjlServiceI extends CommonService{
	
 	public void delete(WuyeCbglSbcbjlEntity entity) throws Exception;
 	
 	public Serializable save(WuyeCbglSbcbjlEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeCbglSbcbjlEntity entity) throws Exception;
 	
}
