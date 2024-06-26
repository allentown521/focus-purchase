package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.open.public.account.reset response.
 *
 * @author auto create
 * @since 1.0, 2016-12-08 12:01:32
 */
public class AlipayOpenPublicAccountResetResponse extends AlipayResponse {

	private static final long serialVersionUID = 5526711191346224347L;

	/**
	 * 重置后的协议号，商户会员在支付宝服务窗账号中的唯一标识
	 */
	@ApiField("agreement_id")
	private String agreementId;

	public void setAgreementId(String agreementId) {
		this.agreementId = agreementId;
	}

	public String getAgreementId() {
		return this.agreementId;
	}

}
