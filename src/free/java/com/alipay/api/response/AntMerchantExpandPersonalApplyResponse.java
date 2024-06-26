package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: ant.merchant.expand.personal.apply response.
 *
 * @author auto create
 * @since 1.0, 2016-09-26 13:19:43
 */
public class AntMerchantExpandPersonalApplyResponse extends AlipayResponse {

	private static final long serialVersionUID = 5239997542781114724L;

	/**
	 * 支付宝端商户入驻申请单据号
	 */
	@ApiField("order_no")
	private String orderNo;

	/**
	 * 外部入驻申请单据号
	 */
	@ApiField("out_biz_no")
	private String outBizNo;

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOutBizNo(String outBizNo) {
		this.outBizNo = outBizNo;
	}

	public String getOutBizNo() {
		return this.outBizNo;
	}

}
