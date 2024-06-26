package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.fund.trans.toaccount.transfer response.
 *
 * @author auto create
 * @since 1.0, 2018-07-03 21:37:30
 */
public class AlipayFundTransToaccountTransferResponse extends AlipayResponse {

	private static final long serialVersionUID = 2515352369492864182L;

	/**
	 * 支付宝转账单据号，成功一定返回，失败可能不返回也可能返回。
	 */
	@ApiField("order_id")
	private String orderId;

	/**
	 * 商户转账唯一订单号：发起转账来源方定义的转账单据号。请求时对应的参数，原样返回。
	 */
	@ApiField("out_biz_no")
	private String outBizNo;

	/**
	 * 支付时间：格式为yyyy-MM-dd HH:mm:ss，仅转账成功返回。
	 */
	@ApiField("pay_date")
	private String payDate;

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}

	public String getOutBizNo() {
		return this.outBizNo;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public String getPayDate() {
		return this.payDate;
	}

}
