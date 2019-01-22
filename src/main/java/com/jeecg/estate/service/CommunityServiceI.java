package com.jeecg.estate.service;
import com.jeecg.estate.entity.CommunityEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface CommunityServiceI extends CommonService{
	
 	public void delete(CommunityEntity entity) throws Exception;
 	
 	public Serializable save(CommunityEntity entity) throws Exception;
 	
 	public void saveOrUpdate(CommunityEntity entity) throws Exception;
 	
}
