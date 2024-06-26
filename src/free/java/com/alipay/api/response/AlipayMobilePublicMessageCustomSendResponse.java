package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.mobile.public.message.custom.send response.
 *
 * @author auto create
 * @since 1.0, 2018-06-01 10:40:00
 */
public class AlipayMobilePublicMessageCustomSendResponse extends AlipayResponse {

	private static final long serialVersionUID = 3113176949483354811L;

	/**
	 * 结果码
	 */
	@ApiField("code")
	private String code;

	/**
	 * 结果描述
	 */
	@ApiField("msg")
	private String msg;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}

}
