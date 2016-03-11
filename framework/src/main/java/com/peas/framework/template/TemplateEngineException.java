/**
 * 版权所有 @Lijq / ly_0199@163.com
 */
package com.peas.framework.template;

/**
 * 模板异常类
 * 
 * @author Lijq 2016年1月26日下午1:39:59
 * @since version 1.0
 */
@SuppressWarnings("serial")
public class TemplateEngineException extends Exception {

	public TemplateEngineException(String message) {
		super(message);
	}

	public TemplateEngineException(String message, Throwable cause) {
		super(message, cause);
	}
}
