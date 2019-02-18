package com.jeecg.wuyesfgl.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.Sql;

import com.jeecg.wuyesfgl.entity.WuyeSfglDkxxzbEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglDwdkxxzbEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYhdkxxEntity;

@MiniDao
public interface WuyeSfglYhdkxxDao {
	
	//先删除当月的数据，然后插入，都到更新的效果
	@Sql("delete from wuye_sfgl_yhdkxx where year = :zb.year and month = :zb.month and yhbm = :zb.yhbm")
	int deleteByYearAndMonthAndYhbm(@Param("zb") WuyeSfglDkxxzbEntity zb);
	
	//通过年和月确定需要导出的账户
	@Sql("select yh.* from wuye_sfgl_yhdkxx yh , wuye_sfgl_ysfyjl ys , wuye_yzgl_fwyzxx yz	where ys.jfnd = :d.year and ys.jfyf = :d.month and ys.fwyzxxid = yz.id and yh.zh = yz.dkr_dkyhzh GROUP BY  yh.zh")
	List<WuyeSfglYhdkxxEntity> findByYearAndMonth(@Param("d") WuyeSfglDkxxzbEntity d);
	
	//通过年份和月份和银行编码查
	@Sql("select * from wuye_sfgl_yhdkxx where year = :dkxxzb.year and month = :dkxxzb.month and yhbm = :dkxxzb.yhbm")
	List<WuyeSfglYhdkxxEntity> findListByYearAndMonthAndYhbm(@Param("dkxxzb") WuyeSfglDkxxzbEntity dkxxzb);
	
	//查询数量
	@Sql("select count(*) from wuye_sfgl_yhdkxx where year = :dkxxzb.year and month = :dkxxzb.month and yhbm = :dkxxzb.yhbm")
	int findListByYearAndMonthAndYhbmCount(@Param("dkxxzb") WuyeSfglDkxxzbEntity dkxxzb);

	
}
