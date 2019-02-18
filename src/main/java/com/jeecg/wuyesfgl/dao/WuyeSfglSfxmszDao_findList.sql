select (select g.glqmc from wuye_glq g where g.id = w.glqid)glqmc,w.id,w.glqid,w.xmdm,w.xmmc,w.sffs,w.jffs,w.jfzq,w.jfzqdw,
				w.jfdj,w.sfbz,w.jfjd,w.znjl,w.znjksts,w.jsgs,w.dycx
	from wuye_sfgl_sfxmsz w
	where 
	<#if sfxmsz.glqid ?exists && sfxmsz.glqid ?length gt 0>
		 w.glqid = :sfxmsz.glqid
	</#if>
	<#if sfxmsz.xmdm ?exists && sfxmsz.xmdm ?length gt 0>
		and w.xmdm = :sfxmsz.xmdm
	</#if>
	<#if sfxmsz.xmmc ?exists && sfxmsz.xmmc ?length gt 0>
		and w.xmmc = :sfxmsz.xmmc
	</#if>