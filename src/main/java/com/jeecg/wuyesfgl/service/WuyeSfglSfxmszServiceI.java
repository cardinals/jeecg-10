package com.jeecg.wuyesfgl.service;
import com.jeecg.wuyesfgl.entity.WuyeSfglSfxmszEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WuyeSfglSfxmszServiceI extends CommonService{
	
 	public void delete(WuyeSfglSfxmszEntity entity) throws Exception;
 	
 	public Serializable save(WuyeSfglSfxmszEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WuyeSfglSfxmszEntity entity) throws Exception;
 	
}
