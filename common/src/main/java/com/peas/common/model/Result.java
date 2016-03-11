/**
 * 版权所有 @lijinquan / ly_0199@163.com
 */
package com.peas.common.model;

import java.io.Serializable;

/**
 * 调用结果类。该类可以在很多场景用到，一个类调用另一个类时可以用Result来传递调用结果
 * 
 * 默认下 successed 为 true;
 * 
 * @author lijinquan 2015年12月25日上午10:37:32
 * @since version 1.0
 */
@SuppressWarnings("serial")
public class Result implements Serializable {

	/**
	 * 是否成功，默认执行成功(必填)
	 */
	private boolean successed = true;

	/**
	 * 消息，不论是否成功都可以写入消息(选填）
	 */
	private String message = "";

	/**
	 * 返回数据 用于可扩展的返回信息(选填)
	 */
	private Object result = null;

	/**
	 * 创建成功结果
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public static Result createSuccessResult() {
		Result result = new Result();
		result.setSuccessed(true);
		return result;
	}

	/**
	 * 创建成功结果
	 *
	 * @param dataMap
	 *            返回数据map
	 * @return
	 */
	public static Result createSuccessResult(Object object) {
		Result result = new Result();
		result.setSuccessed(true);
		result.setResult(object);
		return result;
	}

	/**
	 * 创建失败结果
	 *
	 * @param errorMessage
	 *            错误消息
	 * @return
	 */
	public static Result createErrorResult(String message) {
		Result result = new Result();
		result.setSuccessed(false);
		result.setMessage(message);
		return result;
	}

	public boolean isSuccessed() {
		return successed;
	}

	public void setSuccessed(boolean successed) {
		this.successed = successed;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String permissionIds) {
		this.message = permissionIds;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object object) {
		result = object;
	}

}
