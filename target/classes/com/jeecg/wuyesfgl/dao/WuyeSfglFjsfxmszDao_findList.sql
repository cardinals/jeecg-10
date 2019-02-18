select f.id,(select g.glqmc from wuye_glq g where g.id = f.glqid) glqmc,f.glqid,
	f.lyid,f.fjid,
	f.fwxxid,f.sfxmid,f.yhlx,f.yhbl,f.bz,s.xmdm,s.xmmc,s.sffs,s.jfdj,s.sfbz,s.jfzq,s.jfzqdw
 from wuye_sfgl_sfxmsz s 
	join wuye_sfgl_fjsfxmsz f on s.id = f.sfxmid where f.fjid = :fjid
