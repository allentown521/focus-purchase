package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.pass.tpl.add response.
 *
 * @author auto create
 * @since 1.0, 2016-07-01 15:35:14
 */
public class AlipayPassTplAddResponse extends AlipayResponse {

	private static final long serialVersionUID = 4379571898377526675L;

	/**
	 * 接口返回业务错误码
	 */
	@ApiField("error_code")
	private String errorCode;

	/**
	 * 接口调用返回结果信息
	 */
	@ApiField("result")
	private String result;

	/**
	 * 操作成功标识【T：成功；F：失败】
	 */
	@ApiField("success")
	private String success;

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return this.result;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getSuccess() {
		return this.success;
	}

}
