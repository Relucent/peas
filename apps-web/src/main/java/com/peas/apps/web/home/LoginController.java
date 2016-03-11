/**
 * 版权所有 @Lijq / ly_0199@163.com
 */
package com.peas.apps.web.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Lijq 2016年1月25日下午2:58:35
 * @since version 1.0
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

	private final String LOGIN_PAGE = "login";

	/**
	 * 登录页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "/", "", "/index", "", "/login" })
	public String index(ModelMap model) {
		return LOGIN_PAGE;
	}

}
