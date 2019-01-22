package com.jeecg.estatemore.service;
import com.jeecg.estatemore.entity.PropertyRightinfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface PropertyRightinfoServiceI extends CommonService{
	
 	public void delete(PropertyRightinfoEntity entity) throws Exception;
 	
 	public Serializable save(PropertyRightinfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(PropertyRightinfoEntity entity) throws Exception;
 	
}
