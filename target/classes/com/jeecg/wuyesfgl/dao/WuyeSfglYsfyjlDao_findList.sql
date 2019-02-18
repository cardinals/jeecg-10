select ys.*,(select g.glqmc from wuye_glq g where g.id = ys.glqid) glqmc,fw.fjbh 
	from wuye_sfgl_ysfyjl ys join wuye_fwxx fw on ys.fjid = fw.fjid
	where fw.yxbz = '1'
	<#if ysfyjl.lyid ?exists && ysfyjl.lyid ?length gt 0>
		and ys.lyid = :ysfyjl.lyid
	</#if>
	<#if ysfyjl.fjbh ?exists && ysfyjl.fjbh ?length gt 0>
		and fw.fjbh = :ysfyjl.fjbh
	</#if>
	<#if ysfyjl.sfzt ?exists && ysfyjl.sfzt ?length gt 0>
		and ys.sfzt = :ysfyjl.sfzt
	</#if>
	<#if ysfyjl.sfxmdm ?exists && ysfyjl.sfxmdm ?length gt 0>
		and ys.sfxmdm = :ysfyjl.sfxmdm
	</#if>
	<#if ysfyjl.sfxmmc ?exists && ysfyjl.sfxmmc ?length gt 0>
		and ys.sfxmmc = :ysfyjl.sfxmmc
	</#if>
	<#if ysfyjl.shzt ?exists && ysfyjl.shzt ?length gt 0>
		and ys.shzt = :ysfyjl.shzt
	</#if>
	<#if ysfyjl.dkxxzj ?exists && ysfyjl.dkxxzj ?length gt 0>
		and ys.dkxxzj = :ysfyjl.dkxxzj
	</#if>
