package com.jeecg.wuyesfgl.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Param;

import com.jeecg.wuyesfgl.entity.WuyeSfglSfxmszPageEntity;
@MiniDao
public interface WuyeSfglSfxmszDao {

	//查询列表
	List<WuyeSfglSfxmszPageEntity> findList(@Param("sfxmsz") WuyeSfglSfxmszPageEntity sfxmsz);
	
	//查询列表数量
	int findListCount(@Param("sfxmsz") WuyeSfglSfxmszPageEntity sfxmsz);
	
	
}
