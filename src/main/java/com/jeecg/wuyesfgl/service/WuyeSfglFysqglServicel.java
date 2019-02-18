package com.jeecg.wuyesfgl.service;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.model.json.AjaxJson;

public interface WuyeSfglFysqglServicel  {
	
	public AjaxJson saveCharge(HttpServletRequest request,Long fjid);
}
