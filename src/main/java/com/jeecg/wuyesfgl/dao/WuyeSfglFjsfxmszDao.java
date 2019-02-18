package com.jeecg.wuyesfgl.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.Sql;

import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfFjsfxmszPageEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglFjsfxmszEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglSfxmszEntity;

@MiniDao
public interface WuyeSfglFjsfxmszDao {
	/**房间收费项目设置*/
	public List<WuyeSfFjsfxmszPageEntity> findList(@Param("fjid") int fjid);
	/**房间收费项目设置查询数量*/
	int findListCount(@Param("fjid") int fjid);
	
	//查询管理区表
	@Sql("select * from wuye_glq w where w.glqlx = '2' and w.yxbz = '1'")
	public List<WuyeGlqEntity> findGlqList();
	
	//查询房屋信息表
	@Sql("select * from wuye_fwxx w where w.lyid = :lyid")
	public List<WuyeFwxxEntity> findFwxxListByLyid(@Param("lyid") String lyid);
	
	//批量修改房间收费设置
	@Sql("update wuye_sfgl_fjsfxmsz w set w.yhlx = :fjsfxm.yhlx,w.yhbl = :fjsfxm.yhbl,bz = :fjsfxm.bz where w.fwxxid = :fjsfxm.fwxxid and w.sfxmid = :fjsfxm.sfxmid")
	public void updateByLyidPiliang(@Param("fjsfxm") WuyeSfglFjsfxmszEntity fjsfxm);
	
	//查询在批量添加收费项目时，此房间是否存在此项目
	@Sql("SELECT * from wuye_sfgl_fjsfxmsz w where w.fjid = :wuyeSfglFjsfxmsz.fjid and w.sfxmid = :wuyeSfglFjsfxmsz.sfxmid")
	public List<WuyeSfglFjsfxmszEntity> findsfxmszListIs(@Param("wuyeSfglFjsfxmsz") WuyeSfglFjsfxmszEntity wuyeSfglFjsfxmsz);
}
