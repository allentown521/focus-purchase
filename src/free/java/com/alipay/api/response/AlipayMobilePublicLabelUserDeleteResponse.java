package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.mobile.public.label.user.delete response.
 *
 * @author auto create
 * @since 1.0, 2016-07-29 19:58:34
 */
public class AlipayMobilePublicLabelUserDeleteResponse extends AlipayResponse {

	private static final long serialVersionUID = 4447512169741285181L;

	/**
	 * 结果码
	 */
	@ApiField("code")
	private String code;

	/**
	 * 结果信息
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
