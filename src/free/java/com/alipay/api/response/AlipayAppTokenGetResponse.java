package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.app.token.get response.
 *
 * @author auto create
 * @since 1.0, 2017-04-13 19:13:06
 */
public class AlipayAppTokenGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 4817663818618358649L;

	/**
	 * 应用访问令牌
	 */
	@ApiField("app_access_token")
	private String appAccessToken;

	/**
	 * 应用访问凭证有效时间，单位：秒
	 */
	@ApiField("expires_in")
	private Long expiresIn;

	public void setAppAccessToken(String appAccessToken) {
		this.appAccessToken = appAccessToken;
	}

	public String getAppAccessToken() {
		return this.appAccessToken;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public Long getExpiresIn() {
		return this.expiresIn;
	}

}
