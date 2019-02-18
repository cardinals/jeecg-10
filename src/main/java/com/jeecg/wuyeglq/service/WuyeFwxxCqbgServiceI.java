package com.jeecg.wuyeglq.service;
import com.jeecg.wuyeglq.entity.WuyeFwxxCqbgEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeFwxxCqbgServiceI extends CommonService{
	
 	public void delete(WuyeFwxxCqbgEntity entity) throws Exception;
 	
 	public Serializable save(WuyeFwxxCqbgEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeFwxxCqbgEntity entity) throws Exception;
 	
}
