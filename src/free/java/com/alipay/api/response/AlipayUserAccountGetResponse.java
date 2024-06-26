package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlipayAccount;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.user.account.get response.
 *
 * @author auto create
 * @since 1.0, 2018-03-07 09:25:46
 */
public class AlipayUserAccountGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 1129945873731333795L;

	/**
	 * 支付宝用户账户信息
	 */
	@ApiField("alipay_account")
	private AlipayAccount alipayAccount;

	public void setAlipayAccount(AlipayAccount alipayAccount) {
		this.alipayAccount = alipayAccount;
	}

	public AlipayAccount getAlipayAccount() {
		return this.alipayAccount;
	}

}
