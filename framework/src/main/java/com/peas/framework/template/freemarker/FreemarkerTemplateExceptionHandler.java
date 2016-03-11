/**
 * 版权所有 @Lijq / ly_0199@163.com
 */
package com.peas.framework.template.freemarker;

import java.io.IOException;
import java.io.Writer;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * @author Lijq 2016年1月26日下午2:41:02
 * @since version 1.0
 */
public class FreemarkerTemplateExceptionHandler implements TemplateExceptionHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * freemarker.template.TemplateExceptionHandler#handleTemplateException(
	 * freemarker.template.TemplateException, freemarker.core.Environment,
	 * java.io.Writer)
	 */
	@Override
	public void handleTemplateException(TemplateException te, Environment env, Writer out) throws TemplateException {

		try {
			out.write("[Error:" + te.getMessage() + "]");
		} catch (IOException ex) {
			throw new TemplateException("Failed to print error messafe. Cause" + ex, env);
		}

	}

}
