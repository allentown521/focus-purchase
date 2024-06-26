package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.trade.itemorder.refund response.
 *
 * @author auto create
 * @since 1.0, 2018-02-08 13:54:45
 */
public class KoubeiTradeItemorderRefundResponse extends AlipayResponse {

	private static final long serialVersionUID = 5795329623495178621L;

	/**
	 * 口碑订单号
	 */
	@ApiField("order_no")
	private String orderNo;

	/**
	 * 退款唯一请求号
	 */
	@ApiField("out_request_no")
	private String outRequestNo;

	/**
	 * 实际退的资金。
	 */
	@ApiField("real_refund_amount")
	private String realRefundAmount;

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOutRequestNo(String outRequestNo) {
		this.outRequestNo = outRequestNo;
	}

	public String getOutRequestNo() {
		return this.outRequestNo;
	}

	public void setRealRefundAmount(String realRefundAmount) {
		this.realRefundAmount = realRefundAmount;
	}

	public String getRealRefundAmount() {
		return this.realRefundAmount;
	}

}
