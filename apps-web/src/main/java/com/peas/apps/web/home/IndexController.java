/**
 * 版权所有 @lijinquan / ly_0199@163.com
 */
package com.peas.apps.web.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lijinquan 2016年1月7日下午2:33:34
 * @since version 1.0
 */
@Controller
public class IndexController {

	@RequestMapping(value = { "/", "/index" })
	public String index(ModelMap model) {

		return "index";
	}

}
