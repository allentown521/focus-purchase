package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.voucher.auth.send response.
 *
 * @author auto create
 * @since 1.0, 2017-06-19 11:27:25
 */
public class AlipayMarketingVoucherAuthSendResponse extends AlipayResponse {

	private static final long serialVersionUID = 7158445473756238875L;

	/**
	 * 券ID
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
