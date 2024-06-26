package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.mobile.public.message.total.send response.
 *
 * @author auto create
 * @since 1.0, 2016-01-19 16:43:05
 */
public class AlipayMobilePublicMessageTotalSendResponse extends AlipayResponse {

	private static final long serialVersionUID = 1743292732651119658L;

	/**
	 * 结果码
	 */
	@ApiField("code")
	private String code;

	/**
	 * 消息ID
	 */
	@ApiField("data")
	private String data;

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

	public void setData(String data) {
		this.data = data;
	}

	public String getData() {
		return this.data;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}

}
