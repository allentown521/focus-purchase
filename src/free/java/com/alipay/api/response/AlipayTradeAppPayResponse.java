package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.trade.app.pay response.
 *
 * @author auto create
 * @since 1.0, 2018-03-23 19:15:47
 */
public class AlipayTradeAppPayResponse extends AlipayResponse {

	private static final long serialVersionUID = 8387918272899676157L;

	/**
	 * 商户网站唯一订单号
	 */
	@ApiField("out_trade_no")
	private String outTradeNo;

	/**
	 * 收款支付宝账号对应的支付宝唯一用户号。
	 * 以2088开头的纯16位数字
	 */
	@ApiField("seller_id")
	private String sellerId;

	/**
	 * 该笔订单的资金总额，单位为RMB-Yuan。取值范围为[0.01，100000000.00]，精确到小数点后两位。
	 */
	@ApiField("total_amount")
	private String totalAmount;

	/**
	 * 该交易在支付宝系统中的交易流水号。
	 */
	@ApiField("trade_no")
	private String tradeNo;

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getOutTradeNo() {
		return this.outTradeNo;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerId() {
		return this.sellerId;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTotalAmount() {
		return this.totalAmount;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

}
