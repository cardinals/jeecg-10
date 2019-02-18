package com.jeecg.wuyesfgl.dao;

import java.util.Date;
import java.util.List;

import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.Sql;

import com.jeecg.wuyeglq.entity.WuyeFwxxEntity;
import com.jeecg.wuyeglq.entity.WuyeGlqEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglFjsfxmszEntity;
import com.jeecg.wuyesfgl.entity.WuyeSfglYsfyjsxmEntity;

@MiniDao
public interface WuyeSfglYsfyjsxmDao {
	
	@Sql("select * from wuye_glq where  id = :sffw and yxbz='1' ")
	public WuyeGlqEntity findByObject(@Param("sffw")String sffw);
	
	/**获取入住所有房间*/
	public List<WuyeFwxxEntity> findByList(@Param("lx")String lx,@Param("id")String id);
	
	/**获取收费项目管理表*/
	@Sql("select * from wuye_sfgl_ysfyjsxm m where sfxmdm in (select xmdm from wuye_sfgl_sfxmsz where sfbz='1' ) and zbid=:zbid ")
	//@Sql("select * from wuye_sfgl_sfxmsz where xmdm in(select sfxmdm from wuye_sfgl_ysfyjsxm where zbid=:zbid) and sfbz='1' ")
	public List<WuyeSfglYsfyjsxmEntity> findByJsxmList(@Param("zbid")String zbid);
	
	/**获取房间收费项目表*/
	@Sql("select * from wuye_sfgl_fjsfxmsz  where  fwxxid=:fwxxid")
	public List<WuyeSfglFjsfxmszEntity> findByfjsfxmList(@Param("fwxxid")String fwxxid);
	
	/**获取水表实际用量*/
	@Sql("SELECT  ifnull(sum(sjyl),0) FROM wuye_cbgl_sbcbjl WHERE ybid =(select id from wuye_cbgl_fjb where  sfxmdm =:sfxmdm AND fwxxid=:fwxxid AND yxbz='1') AND :jfqsrq<=jfqsrq AND :jfjsrq>=jfjsrq")
	public Double findBysbSum(
			@Param("sfxmdm")String sfxmdm,@Param("fwxxid")String fwxxid,
			@Param("jfqsrq")Date jfqsrq,@Param("jfjsrq")Date jfjsrq);
	
	/**获取电表实际用量*/
	@Sql("SELECT  ifnull(sum(sjyl),0) FROM wuye_cbgl_dbcbjl WHERE ybid =(select id from wuye_cbgl_fjb where  sfxmdm =:sfxmdm AND fwxxid=:fwxxid AND yxbz='1') AND :jfqsrq<=jfqsrq AND :jfjsrq>=jfjsrq")
	public Double findBydbSum(
			@Param("sfxmdm")String sfxmdm,@Param("fwxxid")String fwxxid,
			@Param("jfqsrq")Date jfqsrq,@Param("jfjsrq")Date jfjsrq);
	
	/**获取气表实际用量*/
	@Sql("SELECT  ifnull(sum(sjyl),0) FROM wuye_cbgl_qbcbjl WHERE ybid =(select id from wuye_cbgl_fjb where  sfxmdm =:sfxmdm AND fwxxid=:fwxxid AND yxbz='1') AND :jfqsrq<=jfqsrq AND :jfjsrq>=jfjsrq")
	public Double findByqbSum(
			@Param("sfxmdm")String sfxmdm,@Param("fwxxid")String fwxxid,
			@Param("jfqsrq")Date jfqsrq,@Param("jfjsrq")Date jfjsrq);
	
	/**判断是否计算*/
	
	public Integer findByCount(
			@Param("jfnd")String jfnd,@Param("jfyf")String jfyf
			,@Param("lx")String lx,@Param("id")String id);
	
	public void findByDelete(
			@Param("jfnd")String jfnd,@Param("jfyf")String jfyf
			,@Param("lx")String lx,@Param("id")String id);
}
