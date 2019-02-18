package com.jeecg.wuyeyzgl.Dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.ResultType;
import org.jeecgframework.minidao.annotation.Sql;

import com.jeecg.demo.entity.JeecgDemoEntity;
import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;

@MiniDao
public interface WuyeYzglFwqrglDao {
		 
	/**
	 * 楼宇查询
	 * @param id
	 * @return
	 */
	@ResultType(WuyeFwxxEntity.class)
	public List<WuyeFwxxEntity> findByIdList(
			@Param("id") String id,
			@Param("lx") String lx,
			@Param("entity") WuyeFwxxEntity entity);
	@ResultType(WuyeFwxxEntity.class)
	public Integer getCount(
			@Param("id") String id,
			@Param("lx") String lx,
			@Param("entity") WuyeFwxxEntity entity);		
	
}
