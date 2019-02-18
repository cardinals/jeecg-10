package com.jeecg.wuyesfgl.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.Sql;

import com.jeecg.wuyesfgl.entity.WuyeSfglDkxxzbEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglDwdkxxPageEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglDwdkxxzbEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYhdkxxEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYhdkxxPageEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjlEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjlPageEntity;
@MiniDao
public interface WuyeSfglYsfyjlDao {
	/**查询所有信息*/
	List<WuyeSfglYsfyjlPageEntity> findList(@Param("ysfyjl") WuyeSfglYsfyjlPageEntity ysfyjl);
	//查询数量
	int findListCount(@Param("ysfyjl") WuyeSfglYsfyjlPageEntity ysfyjl);
	
	/**通过银行代扣信息主表查询银行代扣数据*/
	List<WuyeSfglYhdkxxPageEntity> findListByYhDkxxzb(@Param("yh") WuyeSfglDkxxzbEntity yh);
	
	/**更新应收费用记录表
	 * @param sfzt */
	@Sql("update wuye_sfgl_ysfyjl w set w.dkxxzj  = :id,w.sfzt = :sfzt	where  w.jfnd = :year and w.jfyf = :month and w.fwyzxxid = :fwyzxxid")
	int updateDkxxzj(@Param("id") String id,@Param("year") String year,@Param("month") String month,@Param("fwyzxxid") String fwyzxxid,@Param("sfzt") String sfzt);
	/**通过单位代扣信息主表查询单位代扣数据*/
	List<WuyeSfglDwdkxxPageEntity> findListByDwDkxxzb(@Param("dw") WuyeSfglDwdkxxzbEntity dw);
	
	

}
