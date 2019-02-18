package com.jeecg.wuyeyzgl.Dao;

import java.util.Date;
import java.util.List;

import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.Sql;

import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglFjsfxmszEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjsxmEntity;
import com.jeecg.wuyeyzgl.entity.WuyeYzglFwyzxxEntity;

@MiniDao
public interface WuyeYzglFwyzxxDao {

	
	/**查询列表*/
	List<WuyeYzglFwyzxxEntity> findList(@Param("yz") WuyeYzglFwyzxxEntity yz);
	//查询数量
	int findListCount(@Param("yz") WuyeYzglFwyzxxEntity yz);
	
	
}
