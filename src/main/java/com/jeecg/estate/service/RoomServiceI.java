package com.jeecg.estate.service;
import com.jeecg.estate.entity.RoomEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface RoomServiceI extends CommonService{
	
 	public void delete(RoomEntity entity) throws Exception;
 	
 	public Serializable save(RoomEntity entity) throws Exception;
 	
 	public void saveOrUpdate(RoomEntity entity) throws Exception;
 	
}
