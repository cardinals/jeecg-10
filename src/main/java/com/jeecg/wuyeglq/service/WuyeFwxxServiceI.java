package com.jeecg.wuyeglq.service;
import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeFwxxServiceI extends CommonService{
	
 	public void delete(WuyeFwxxEntity entity) throws Exception;
 	
 	public Serializable save(WuyeFwxxEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeFwxxEntity entity) throws Exception;
 	
}
