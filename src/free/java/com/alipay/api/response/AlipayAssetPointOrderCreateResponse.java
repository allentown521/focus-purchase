package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.asset.point.order.create response.
 *
 * @author auto create
 * @since 1.0, 2017-04-14 18:53:05
 */
public class AlipayAssetPointOrderCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 4116167197974996336L;

	/**
	 * 支付宝集分宝发放流水号
	 */
	@ApiField("alipay_order_no")
	private String alipayOrderNo;

	public void setAlipayOrderNo(String alipayOrderNo) {
		this.alipayOrderNo = alipayOrderNo;
	}

	public String getAlipayOrderNo() {
		return this.alipayOrderNo;
	}

}
