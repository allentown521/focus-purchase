package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.exchangevoucher.use response.
 *
 * @author auto create
 * @since 1.0, 2018-01-30 22:44:13
 */
public class AlipayMarketingExchangevoucherUseResponse extends AlipayResponse {

	private static final long serialVersionUID = 5635738254568195758L;

	/**
	 * 被核销的券ID
	 */
	@ApiField("voucher_id")
	private String voucherId;

	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}

	public String getVoucherId() {
		return this.voucherId;
	}

}
