package com.jeecg.estatemore.service;
import com.jeecg.estatemore.entity.OwninfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface OwninfoServiceI extends CommonService{
	
 	public void delete(OwninfoEntity entity) throws Exception;
 	
 	public Serializable save(OwninfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(OwninfoEntity entity) throws Exception;
 	
}
