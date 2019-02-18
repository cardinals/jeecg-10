select  count(*) from  wuye_fwxx  
where 1=1
<#if lx == '4'>
	and lyid =:id
</#if>
<#if lx == '3'>
	and lyid in (select id from wuye_glq WHERE fid = :id)
</#if>
<#if lx == '2'>
	and glqid =:id
</#if>
<#if entity.fjbh ?exists && entity.fjbh ?length gt 0>
	and fjbh =:entity.fjbh
</#if>
<#if entity.fwhx ?exists && entity.fwhx ?length gt 0>
	and fwhx =:entity.fwhx
</#if>
<#if entity.zflb ?exists && entity.zflb ?length gt 0>
	and zflb =:entity.zflb
</#if>
and fjid not in(select fjid from wuye_yzgl_fwyzxx WHERE yz_sx='yz' and fjid is not NULL)
and yxbz='1'