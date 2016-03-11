/**
 * 版权所有 @Lijq / ly_0199@163.com
 */
package com.peas.framework.template;

import java.io.Writer;
import java.util.Map;

/**
 * 模板引擎接口
 * 
 * @author Lijq 2016年1月26日下午2:25:37
 * @since version 1.0
 */
public interface TemplateEngine {

	public void process(String tplName, Map<String, Object> data, Writer out) throws TemplateEngineException;

}
