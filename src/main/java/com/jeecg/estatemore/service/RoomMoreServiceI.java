package com.jeecg.estatemore.service;
import com.jeecg.estatemore.entity.RoomMoreEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface RoomMoreServiceI extends CommonService{
	
 	public void delete(RoomMoreEntity entity) throws Exception;
 	
 	public Serializable save(RoomMoreEntity entity) throws Exception;
 	
 	public void saveOrUpdate(RoomMoreEntity entity) throws Exception;
 	
}
