package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.card.delete response.
 *
 * @author auto create
 * @since 1.0, 2018-01-16 19:51:58
 */
public class AlipayMarketingCardDeleteResponse extends AlipayResponse {

	private static final long serialVersionUID = 4326461199451131912L;

	/**
	 * 支付宝端删卡业务流水号
	 */
	@ApiField("biz_serial_no")
	private String bizSerialNo;

	public void setBizSerialNo(String bizSerialNo) {
		this.bizSerialNo = bizSerialNo;
	}

	public String getBizSerialNo() {
		return this.bizSerialNo;
	}

}
