select ys.yzmc yzmc,sum(ys.ysje) ssje,(select x.dkr_dkyhzh from wuye_yzgl_fwyzxx x where x.id = ys.fwyzxxid ) zh
	
	from wuye_sfgl_ysfyjl ys join wuye_yzgl_fwyzxx yz on ys.fwyzxxid = yz.id
	where ys.sfzt = '0'
	<#if yh.year ?exists && yh.year ?length gt 0>
		and ys.jfnd = :yh.year
	</#if>
	<#if yh.month ?exists && yh.month ?length gt 0>
		and ys.jfyf = :yh.month
	</#if>
	<#if yh.yhbm ?exists && yh.yhbm ?length gt 0>
		and yz.dkr_dkyh = :yh.yhbm
	</#if>
	group by ys.yzmc