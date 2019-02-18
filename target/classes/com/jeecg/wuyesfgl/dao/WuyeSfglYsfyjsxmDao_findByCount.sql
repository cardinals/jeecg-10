select count(*) from wuye_sfgl_ysfyjl
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
and jfnd=:jfnd
and jfyf=:jfyf
and shzt='1'