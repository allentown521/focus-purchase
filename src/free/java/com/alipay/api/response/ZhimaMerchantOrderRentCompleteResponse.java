package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.merchant.order.rent.complete response.
 *
 * @author auto create
 * @since 1.0, 2018-07-02 11:47:22
 */
public class ZhimaMerchantOrderRentCompleteResponse extends AlipayResponse {

	private static final long serialVersionUID = 6673915272785287172L;

	/**
	 * 资金流水号，用于商户与支付宝进行对账
	 */
	@ApiField("alipay_fund_order_no")
	private String alipayFundOrderNo;

	/**
	 * 信用借还的订单号
	 */
	@ApiField("order_no")
	private String orderNo;

	/**
	 * 借用人支付宝userId.
	 */
	@ApiField("user_id")
	private String userId;

	public void setAlipayFundOrderNo(String alipayFundOrderNo) {
		this.alipayFundOrderNo = alipayFundOrderNo;
	}

	public String getAlipayFundOrderNo() {
		return this.alipayFundOrderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

}
