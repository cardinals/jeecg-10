select ys.yzmc yzmc,sum(ys.ysje) ssje,(select x.dkr_dkdwgh from wuye_yzgl_fwyzxx x where x.id = ys.fwyzxxid ) dkdwgh
	
	from wuye_sfgl_ysfyjl ys join wuye_yzgl_fwyzxx yz on ys.fwyzxxid = yz.id
	where ys.sfzt = '0'
	<#if dw.year ?exists && dw.year ?length gt 0>
		and ys.jfnd = :dw.year
	</#if>
	<#if dw.month ?exists && dw.month ?length gt 0>
		and ys.jfyf = :dw.month
	</#if>
	<#if dw.dkdw ?exists && dw.dkdw ?length gt 0>
		and yz.dkr_dkdw = :dw.dkdw
	</#if>
	group by ys.yzmc