/**
 * 版权所有 @lijinquan / ly_0199@163.com
 */
package com.peas.apps.web.upload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lijinquan 2016年1月11日上午10:41:40
 * @since version 1.0
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadController {

	@RequestMapping(value = "/index")
	public String index(ModelMap model) {
		return "upload/index";
	}

	@RequestMapping(value = "/upload")
	public String upload(ModelMap model, @RequestParam(value = "file", required = false) MultipartFile file) {

		System.out.println("---");

		return "";
	}

	public static void main(String[] args) {

		String str = "96f06aec039a44b9b053079476554fd6954ecd5a126692463cc3dab112b172199a3ea8a32ab998156ec47157b1bb595d3aa88277a89cb2a78302668d8560d50e";
		System.out.println(str.length());

	}

}
