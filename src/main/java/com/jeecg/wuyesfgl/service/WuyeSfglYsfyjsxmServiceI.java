package com.jeecg.wuyesfgl.service;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjsxmEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeSfglYsfyjsxmServiceI extends CommonService{
	
 	public void delete(WuyeSfglYsfyjsxmEntity entity) throws Exception;
 	
 	public Serializable save(WuyeSfglYsfyjsxmEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeSfglYsfyjsxmEntity entity) throws Exception;
 	
}
