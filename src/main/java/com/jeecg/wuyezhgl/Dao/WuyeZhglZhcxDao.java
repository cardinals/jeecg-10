package com.jeecg.wuyezhgl.Dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.Sql;

import com.jeecg.wuyeyzgl.entity.WuyeYzglFwyzxxEntity;

@MiniDao
public interface WuyeZhglZhcxDao {
	
	@Sql("SELECT ifnull(count(*),0) FROM wuye_yzgl_fwyzxx  WHERE fwxxid =(SELECT w.id FROM wuye_fwxx  w WHERE w.fjid=:fjid AND w.yxbz='1') and yxbz='1'")
	public Integer findByCount(@Param("fjid") Long fjid);
	
	@Sql("SELECT * FROM wuye_yzgl_fwyzxx WHERE fjid=:fjid AND yxbz='1' AND yz_sx = (SELECT CASE WHEN zflb='1' THEN REPLACE(zflb,'1','zh') ELSE REPLACE(zflb,'0','yz') END AS z FROM wuye_fwxx WHERE fjid=:fjid and yxbz='1')")
	public List<WuyeYzglFwyzxxEntity> findByObjects(@Param("fjid") Long fjid);

}
