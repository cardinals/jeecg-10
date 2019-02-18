select count(*) from  wuye_sfgl_ysfyjl 
where 1=1
<#if yzmc ?exists && yzmc ?length gt 0>
AND yzmc = :yzmc
</#if>
<#if jfnd ?exists && jfnd ?length gt 0>
AND jfnd = :jfnd
</#if>
<#if jfyf ?exists && jfyf ?length gt 0>
AND jfyf = :jfyf
</#if>
AND shzt='1' 
AND sfzt='0' 
AND fwxxid=(SELECT id FROM wuye_fwxx WHERE fjid=:fjid AND yxbz='1')