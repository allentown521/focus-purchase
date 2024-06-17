package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.trade.create response.
 *
 * @author auto create
 * @since 1.0, 2018-06-14 17:35:00
 */
public class AlipayTradeCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 6467829456464945961L;

	/**
	 * 商户订单号
	 */
	@ApiField("out_trade_no")
	private String outTradeNo;

	/**
	 * 支付宝交易号
	 */
	@ApiField("trade_no")
	private String tradeNo;

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getOutTradeNo() {
		return this.outTradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getTradeNo() {
		return this.tradeNo;
	}

}
