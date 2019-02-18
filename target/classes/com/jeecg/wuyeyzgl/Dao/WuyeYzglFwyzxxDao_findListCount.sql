select count(*) from wuye_yzgl_fwyzxx w where w.yxbz = '1' and w.yz_sx = 'yz' and w.fjid <> ''

	<#if yz.glqid ?exists && yz.glqid ?length gt 0>
		and w.glqid = :yz.glqid
	</#if>
	<#if yz.yzBm ?exists && yz.yzBm ?length gt 0>
		and w.yz_bm = :yz.yzBm
	</#if>
	<#if yz.yzMc ?exists && yz.yzMc ?length gt 0>
		and w.yz_mc = :yz.yzMc
	</#if>
	<#if yz.yzSfzh ?exists && yz.yzSfzh ?length gt 0>
		and w.yz_sfzh = :yz.yzSfzh
	</#if>
	<#if yz.sfjm ?exists && yz.sfjm ?length gt 0>
		and w.sfjm = :yz.sfjm
	</#if>
	
