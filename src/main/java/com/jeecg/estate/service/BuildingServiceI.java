package com.jeecg.estate.service;
import com.jeecg.estate.entity.BuildingEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface BuildingServiceI extends CommonService{
	
 	public void delete(BuildingEntity entity) throws Exception;
 	
 	public Serializable save(BuildingEntity entity) throws Exception;
 	
 	public void saveOrUpdate(BuildingEntity entity) throws Exception;
 	
}
