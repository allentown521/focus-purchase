package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.trust.user.auth.send response.
 *
 * @author auto create
 * @since 1.0, 2015-05-15 09:36:22
 */
public class AlipayTrustUserAuthSendResponse extends AlipayResponse {

	private static final long serialVersionUID = 8791451845791291527L;

	/**
	 * 当授权通知发送成功时，为T；否则用业务错误码表示
	 */
	@ApiField("result")
	private String result;

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return this.result;
	}

}
