package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.mobile.shake.user.query response.
 *
 * @author auto create
 * @since 1.0, 2018-01-03 16:35:37
 */
public class AlipayMobileShakeUserQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 1358184763683278138L;

	/**
	 * 对应的业务信息
	 */
	@ApiField("bizdata")
	private String bizdata;

	/**
	 * 支付宝用户登录账户，可能是email或者手机号码
	 */
	@ApiField("logon_id")
	private String logonId;

	/**
	 * 对应的核销数据
	 */
	@ApiField("pass_id")
	private String passId;

	/**
	 * 支付宝用户ID
	 */
	@ApiField("user_id")
	private String userId;

	public void setBizdata(String bizdata) {
		this.bizdata = bizdata;
	}

	public String getBizdata() {
		return this.bizdata;
	}

	public void setLogonId(String logonId) {
		this.logonId = logonId;
	}

	public String getLogonId() {
		return this.logonId;
	}

	public void setPassId(String passId) {
		this.passId = passId;
	}

	public String getPassId() {
		return this.passId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

}
