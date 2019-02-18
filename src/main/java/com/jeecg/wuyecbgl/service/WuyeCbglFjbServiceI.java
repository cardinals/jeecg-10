package com.jeecg.wuyecbgl.service;
import com.jeecg.wuyecbgl.entity.WuyeCbglFjbEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeCbglFjbServiceI extends CommonService{
	
 	public void delete(WuyeCbglFjbEntity entity) throws Exception;
 	
 	public Serializable save(WuyeCbglFjbEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeCbglFjbEntity entity) throws Exception;
 	
}
