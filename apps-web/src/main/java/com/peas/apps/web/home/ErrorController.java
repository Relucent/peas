/**
 * 版权所有 @Lijq / ly_0199@163.com
 */
package com.peas.apps.web.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 错误信息处理类，类似于404,500等错误
 * 
 * @author Lijq 2016年1月25日下午1:36:44
 * @since version 1.0
 */
@Controller
@RequestMapping(value = "/error")
public class ErrorController {

	private final String PAGE_403 = "error/403";
	
	private final String PAGE_404 = "error/404";

	private final String PAGE_500 = "error/500";
	
	
	/**
	 * 403页面处理
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/403")
	public String error403(ModelMap model) {
		return PAGE_403;
	}

	/**
	 * 404页面处理
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/404")
	public String error404(ModelMap model) {
		return PAGE_404;
	}
	
	/**
	 * 500页面处理
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/500")
	public String error500(ModelMap model) {
		return PAGE_500;
	}

}
