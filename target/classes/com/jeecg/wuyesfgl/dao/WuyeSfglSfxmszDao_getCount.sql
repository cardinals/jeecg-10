select count(*) from wuye_sfgl_sfxmsz w
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