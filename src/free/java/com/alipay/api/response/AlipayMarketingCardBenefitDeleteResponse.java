package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.card.benefit.delete response.
 *
 * @author auto create
 * @since 1.0, 2017-06-23 09:40:27
 */
public class AlipayMarketingCardBenefitDeleteResponse extends AlipayResponse {

	private static final long serialVersionUID = 6243632986558769581L;

	/**
	 * 权益删除结果；true成功，false失败
	 */
	@ApiField("result")
	private Boolean result;

	public void setResult(Boolean result) {
		this.result = result;
	}

	public Boolean getResult() {
		return this.result;
	}

}
