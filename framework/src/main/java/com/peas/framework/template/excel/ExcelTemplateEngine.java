/**
 * 版权所有 @Lijq / ly_0199@163.com
 */
package com.peas.framework.template.excel;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.peas.framework.template.TemplateEngineException;

import net.sf.jxls.transformer.XLSTransformer;

/**
 * Excel 模板引擎
 * 
 * @author Lijq 2016年1月26日下午1:32:30
 * @since version 1.0
 */
public class ExcelTemplateEngine implements InitializingBean, ResourceLoaderAware {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private String templateLoaderPath;
	private File rootPath;
	private ResourceLoader resourceLoader = new DefaultResourceLoader();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.ResourceLoaderAware#setResourceLoader(org.
	 * springframework.core.io.ResourceLoader)
	 */
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public void setTemplateLoaderPath(String templateLoaderPath) {
		this.templateLoaderPath = templateLoaderPath;
	}

	public void process(String tplName, Map<String, Object> data, OutputStream os) throws TemplateEngineException {
		if (StringUtils.isBlank(tplName)) {
			throw new TemplateEngineException("模板名称不能为空。");
		}

		tplName = tplName.trim();

		Long startTime = System.currentTimeMillis();

		InputStream is;

		try {
			File templateFile = getTemplateFile(tplName);
			is = new BufferedInputStream(new FileInputStream(templateFile));
		} catch (FileNotFoundException e) {
			throw new TemplateEngineException(tplName + "文件不存在。", e);
		}

		XLSTransformer transformer = new XLSTransformer();

		try {
			Workbook workbook;
			workbook = transformer.transformXLS(is, data);
			workbook.write(os);
		} catch (Throwable ex) {
			throw new TemplateEngineException("执行模板[" + tplName + "]时出错。" + ex.getMessage(), ex);
		} finally {
			try {
				is.close();
			} catch (Exception e) {
				throw new TemplateEngineException(e.getMessage());
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("模板[" + tplName + "]执行时间:" + (System.currentTimeMillis() - startTime));
		}

	}

	public File getTemplateFile(String tplName) throws FileNotFoundException {
		File file = FileUtils.getFile(rootPath, tplName);
		if (file.exists() && file.isFile()) {
			return file;
		} else {
			throw new FileNotFoundException(tplName + "文件不存在");
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
		if (StringUtils.isBlank(templateLoaderPath)) {
			throw new IllegalArgumentException("必须指定templateLoaderPath（模板存放路径）");
		}

		Resource path = resourceLoader.getResource(templateLoaderPath);
		rootPath = path.getFile();
	}

}
