package com.jeecg.fang.service;
import com.jeecg.fang.entity.YwGuanquEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface YwGuanquServiceI extends CommonService{
	
 	public void delete(YwGuanquEntity entity) throws Exception;
 	
 	public Serializable save(YwGuanquEntity entity) throws Exception;
 	
 	public void saveOrUpdate(YwGuanquEntity entity) throws Exception;
 	
}
