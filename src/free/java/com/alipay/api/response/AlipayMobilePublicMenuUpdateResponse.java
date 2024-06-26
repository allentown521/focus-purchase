package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.mobile.public.menu.update response.
 *
 * @author auto create
 * @since 1.0, 2018-01-31 17:39:27
 */
public class AlipayMobilePublicMenuUpdateResponse extends AlipayResponse {

	private static final long serialVersionUID = 5212611655298676897L;

	/**
	 * 结果码
	 */
	@ApiField("code")
	private String code;

	/**
	 * 成功
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
