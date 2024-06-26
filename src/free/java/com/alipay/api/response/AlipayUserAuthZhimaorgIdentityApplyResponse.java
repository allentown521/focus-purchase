package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.user.auth.zhimaorg.identity.apply response.
 *
 * @author auto create
 * @since 1.0, 2017-12-06 15:17:02
 */
public class AlipayUserAuthZhimaorgIdentityApplyResponse extends AlipayResponse {

	private static final long serialVersionUID = 2288177591559476872L;

	/**
	 * 访问令牌。通过该令牌调用需要授权类接口
	 */
	@ApiField("access_token")
	private String accessToken;

	/**
	 * 令牌类型，permanent表示返回的access_token和refresh_token永久有效，不受expires_in和re_expires_in限制，默认是空，即受expires_in和re_expires_in限制的时效性令牌
	 */
	@ApiField("auth_token_type")
	private String authTokenType;

	/**
	 * 刷新令牌。通过该令牌可以刷新access_token
	 */
	@ApiField("refresh_token")
	private String refreshToken;

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return this.accessToken;
	}

	public void setAuthTokenType(String authTokenType) {
		this.authTokenType = authTokenType;
	}

	public String getAuthTokenType() {
		return this.authTokenType;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getRefreshToken() {
		return this.refreshToken;
	}

}
