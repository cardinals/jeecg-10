package com.jeecg.wuyecbgl.service;
import com.jeecg.wuyecbgl.entity.WuyeCbglGtbEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeCbglGtbServiceI extends CommonService{
	
 	public void delete(WuyeCbglGtbEntity entity) throws Exception;
 	
 	public Serializable save(WuyeCbglGtbEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeCbglGtbEntity entity) throws Exception;
 	
}
