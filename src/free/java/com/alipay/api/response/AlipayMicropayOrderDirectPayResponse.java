package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.SinglePayDetail;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.micropay.order.direct.pay response.
 *
 * @author auto create
 * @since 1.0, 2018-02-06 10:34:09
 */
public class AlipayMicropayOrderDirectPayResponse extends AlipayResponse {

	private static final long serialVersionUID = 2843139718533672722L;

	/**
	 * 单笔直接支付返回结果
	 */
	@ApiField("single_pay_detail")
	private SinglePayDetail singlePayDetail;

	public void setSinglePayDetail(SinglePayDetail singlePayDetail) {
		this.singlePayDetail = singlePayDetail;
	}

	public SinglePayDetail getSinglePayDetail() {
		return this.singlePayDetail;
	}

}
