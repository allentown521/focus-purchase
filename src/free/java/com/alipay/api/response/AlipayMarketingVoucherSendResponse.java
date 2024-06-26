package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.voucher.send response.
 *
 * @author auto create
 * @since 1.0, 2018-06-20 18:11:01
 */
public class AlipayMarketingVoucherSendResponse extends AlipayResponse {

	private static final long serialVersionUID = 8873324845419151858L;

	/**
	 * 支付宝用户ID
	 */
	@ApiField("user_id")
	private String userId;

	/**
	 * 券ID
	 */
	@ApiField("voucher_id")
	private String voucherId;

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}

	public String getVoucherId() {
		return this.voucherId;
	}

}
