package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.card.benefit.modify response.
 *
 * @author auto create
 * @since 1.0, 2018-03-13 20:26:40
 */
public class AlipayMarketingCardBenefitModifyResponse extends AlipayResponse {

	private static final long serialVersionUID = 8671672913913154293L;

	/**
	 * 权益修改结果；true成功：false失败
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
