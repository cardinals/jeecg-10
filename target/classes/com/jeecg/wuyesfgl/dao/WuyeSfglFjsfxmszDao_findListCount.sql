select count(*)
 from wuye_sfgl_sfxmsz s 
	join wuye_sfgl_fjsfxmsz f on s.id = f.sfxmid where f.fjid = :fjid
