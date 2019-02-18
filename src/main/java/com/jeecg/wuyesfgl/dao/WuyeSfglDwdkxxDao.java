package com.jeecg.wuyesfgl.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.Sql;

import com.jeecg.wuyesfgl.entity.WuyeSfglDkxxzbEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglDwdkxxEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglDwdkxxzbEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYhdkxxEntity;

@MiniDao
public interface WuyeSfglDwdkxxDao {
	
	//先删除当月的数据，然后插入，都到更新的效果
	@Sql("delete from wuye_sfgl_dwdkxx where year = :zb.year and month = :zb.month and dkdw = :zb.dkdw")
	int deleteByYearAndMonthAndDkdw(@Param("zb") WuyeSfglDwdkxxzbEntity zb);
	
	//通过年和月确定需要导出的账户
	@Sql("select dw.* from wuye_sfgl_dwdkxx dw , wuye_sfgl_ysfyjl ys , wuye_yzgl_fwyzxx yz	where ys.jfnd = :d.year and ys.jfyf = :d.month and ys.fwyzxxid = yz.id and dw.dkdwgh = yz.dkr_dkdwgh GROUP BY  dw.dkdwgh")
	List<WuyeSfglDwdkxxEntity> findByYearAndMonth(@Param("d") WuyeSfglDwdkxxzbEntity d);
	
	//通过年份和月份和银行编码查
	@Sql("select * from wuye_sfgl_dwdkxx where year = :dkxxzb.year and month = :dkxxzb.month and dkdw = :dkxxzb.dkdw")
	List<WuyeSfglDwdkxxEntity> findListByYearAndMonthAndDkdw(@Param("dkxxzb") WuyeSfglDwdkxxzbEntity dkxxzb);
	//查询数量
	@Sql("select count(*) from wuye_sfgl_dwdkxx where year = :dkxxzb.year and month = :dkxxzb.month and dkdw = :dkxxzb.dkdw")
	int findcountByYearAndMonthAndDkdw(@Param("dkxxzb") WuyeSfglDwdkxxzbEntity dkxxzb);

	
}
