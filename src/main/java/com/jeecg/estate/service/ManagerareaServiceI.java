package com.jeecg.estate.service;
import com.jeecg.estate.entity.ManagerareaEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ManagerareaServiceI extends CommonService{
	
 	public void delete(ManagerareaEntity entity) throws Exception;
 	
 	public Serializable save(ManagerareaEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ManagerareaEntity entity) throws Exception;
 	
}
