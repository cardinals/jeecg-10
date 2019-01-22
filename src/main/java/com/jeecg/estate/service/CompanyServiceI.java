package com.jeecg.estate.service;
import com.jeecg.estate.entity.CompanyEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface CompanyServiceI extends CommonService{
	
 	public void delete(CompanyEntity entity) throws Exception;
 	
 	public Serializable save(CompanyEntity entity) throws Exception;
 	
 	public void saveOrUpdate(CompanyEntity entity) throws Exception;
 	
}
