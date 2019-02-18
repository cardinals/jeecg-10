package com.jeecg.wuyeglq.dao;

import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.Sql;

import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
/***
 * 房屋产权变更Dao层
 * @author GuoPeiZhi
 *
 */
@MiniDao
public interface WuyeFwxxCqbgDao {
	
	/***通过房间id查找房屋唯一记录*/
	@Sql("SELECT id FROM wuye_fwxx WHERE fjid=:fjid AND yxbz='1'")
	public String findByObject(@Param("fjid") Long fjid);
}
