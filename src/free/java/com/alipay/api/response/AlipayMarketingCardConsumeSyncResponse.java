package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.card.consume.sync response.
 *
 * @author auto create
 * @since 1.0, 2017-06-23 14:51:37
 */
public class AlipayMarketingCardConsumeSyncResponse extends AlipayResponse {

	private static final long serialVersionUID = 5222157924747976566L;

	/**
	 * 外部卡号
	 */
	@ApiField("external_card_no")
	private String externalCardNo;

	public void setExternalCardNo(String externalCardNo) {
		this.externalCardNo = externalCardNo;
	}

	public String getExternalCardNo() {
		return this.externalCardNo;
	}

}
