/**
 * 版权所有 @lijinquan / ly_0199@163.com
 */
package com.peas.apps.web.ucenter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lijinquan 2016年1月8日上午10:43:03
 * @since version 1.0
 */
@Controller
@RequestMapping(value = "/ucenter")
public class UCenterController {

	@RequestMapping(value = { "/{uid}" })
	public String index(ModelMap model, @PathVariable(value = "uid") String uid) {

		System.out.println("uid : " + uid);
		
		model.put("uid", uid);

		return "ucenter/index";
	}

}
