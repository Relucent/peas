/**
 * 版权所有 @Lijq / ly_0199@163.com
 */
package com.peas.framework.core.web.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author Lijq 2016年1月18日上午11:09:55
 * @since version 1.0
 */
public class BaseController {

	/**
	 * 获取 request
	 * 
	 * @return request
	 */
	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 获取 response
	 * 
	 * @return response
	 */
	public HttpServletResponse getResponse() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	}

}
