/**
 * 版权所有 @Lijq / ly_0199@163.com
 */
package com.peas.framework.template.freemarker;

import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;

import com.peas.framework.template.TemplateEngine;
import com.peas.framework.template.TemplateEngineException;

import freemarker.template.Configuration;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

/**
 * @author Lijq 2016年1月26日下午2:28:25
 * @since version 1.0
 */
public class FreeMarkerTemplateEngine extends FreeMarkerConfigurationFactory
		implements TemplateEngine, InitializingBean {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private Configuration configuration;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ly0199.plat.common.template.TemplateEngine#process(java.lang.String,
	 * java.util.Map, java.io.Writer)
	 */
	@Override
	public void process(String tplName, Map<String, Object> data, Writer out) throws TemplateEngineException {
		if (StringUtils.isBlank(tplName)) {
			throw new TemplateEngineException("模板名称不能为空。");
		}

		tplName = tplName.trim();

		Long startTime = System.currentTimeMillis();

		Template tpl;

		try {
			tpl = configuration.getTemplate(tplName);
		} catch (Throwable ex) {
			throw new TemplateEngineException("读取模板[" + tplName + "]时出错。" + ex.getMessage(), ex);
		}

		try {
			tpl.process(data, out);
		} catch (Throwable ex) {
			throw new TemplateEngineException("执行模板[" + tplName + "]时出错。", ex);
		}

		if (logger.isInfoEnabled()) {
			long executionTime = System.currentTimeMillis() - startTime;
			if (executionTime > 2000)
				logger.info("模板[" + tplName + "]执行时间大于2000:" + executionTime);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		this.configuration = createConfiguration();
		this.configuration.setTemplateExceptionHandler(getTemplateExceptionHandler());
		this.configuration.setDefaultEncoding("UTF-8");
		Map<String, Object> sharedVariable = new HashMap<String, Object>();
		doInit(sharedVariable);
		this.configuration.setSharedVariable("esn", new SimpleHash(sharedVariable, configuration.getObjectWrapper()));
	}

	protected void doInit(Map<String, Object> sharedVariable) {
		// TODO do nothing
	}

	protected TemplateExceptionHandler getTemplateExceptionHandler() {
		return new FreemarkerTemplateExceptionHandler();
	}

}
