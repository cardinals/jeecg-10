package com.jeecg.wuyesfgl.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import com.jeecg.wuyecbgl.entity.WuyeCbglFjbEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglFysqmxEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglFysqzbEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjlEntity;
/**
 * 收费主表Dao层
 * @author GuoPeiZhi
 *
 */
/*@MiniDao*/
@Repository
public interface WuyeSfglFysqglDao {
	
	
	/**返回费用审核记录集合*/
	public List<WuyeSfglYsfyjlEntity> findByList(
			@Param("yzmc") String yzmc,@Param("jfnd")String jfnd,
			@Param("jfyf")String jfyf,@Param("fjid")Long fjid);
	
	/**返回费用审计纪律总数*/
	public Integer findByCount(
			@Param("yzmc") String yzmc,@Param("jfnd")String jfnd,
			@Param("jfyf")String jfyf,@Param("fjid")Long fjid);
	
	/**设置收费主表信息*/
	@Sql("SELECT x.glqid,x.lyid,x.id fwwxxid,x.fjid,w.id fwyzxxid FROM wuye_fwxx x JOIN wuye_yzgl_fwyzxx w ON w.fwxxid=x.id WHERE x.fjid=:fjid AND x.yxbz='1' AND w.yxbz='1' AND yz_mc=:yzmc ")
	public WuyeSfglFysqzbEntity findByObject(@Param("fjid")Long fjid,@Param("yzmc") String yzmc);
	
	/**通过id修改收费记录收费状态*/
	@Sql("UPDATE wuye_sfgl_ysfyjl SET sfzt='1' WHERE id=:jlid")
	public void updateByObject(@Param("jlid")String jlid);
	
	/**查询收费记录明细*/
	@Sql("SELECT w.glqid,w.id ysfyjlid,w.sfzt,w.sfxmdm,w.sfxmmc,w.jfqssj,w.jfjzsj,w.sl,w.jg,w.ysje,w.ysje ssje  FROM wuye_sfgl_ysfyjl w  WHERE  w.id= :jlid")
	public WuyeSfglFysqmxEntity saveFysqmx(@Param("jlid")String jlid);
	
	/**查询收据号是否重复*/
	@Sql("SELECT count(*) FROM wuye_sfgl_fysqzb WHERE sjh=:sjh ")
	public Integer findBySjh(@Param("sjh")String sjh);
	
	/**获取房间地址*/
	@Sql("SELECT CONCAT((select q.glqmc from wuye_glq q where q.id = g.fid),g.glqmc,w.dyh,'单元',w.fjbh,'号')dz FROM wuye_fwxx w JOIN wuye_glq g ON  g.id=w.lyid WHERE w.id=: fwxxid ")
	public String findByFjb(@Param("fwxxid")String fwxxid);
}
