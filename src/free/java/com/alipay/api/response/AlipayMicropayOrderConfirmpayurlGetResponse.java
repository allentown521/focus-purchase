package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.SinglePayDetail;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.micropay.order.confirmpayurl.get response.
 *
 * @author auto create
 * @since 1.0, 2016-06-06 17:53:18
 */
public class AlipayMicropayOrderConfirmpayurlGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 2697787313988541578L;

	/**
	 * SinglePayDetail信息
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
