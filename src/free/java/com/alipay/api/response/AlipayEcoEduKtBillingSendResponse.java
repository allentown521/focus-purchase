package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.eco.edu.kt.billing.send response.
 *
 * @author auto create
 * @since 1.0, 2018-03-29 15:20:23
 */
public class AlipayEcoEduKtBillingSendResponse extends AlipayResponse {

	private static final long serialVersionUID = 3525185436366138784L;

	/**
	 * 支付宝－中小学－教育缴费的账单号
	 */
	@ApiField("order_no")
	private String orderNo;

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

}
