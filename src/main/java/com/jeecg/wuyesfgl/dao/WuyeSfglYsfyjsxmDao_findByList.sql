select * from wuye_fwxx
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
and fwzt='rz' 
and yxbz='1'