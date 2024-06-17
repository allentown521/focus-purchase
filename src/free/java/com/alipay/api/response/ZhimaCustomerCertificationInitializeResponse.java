package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: zhima.customer.certification.initialize response.
 *
 * @author auto create
 * @since 1.0, 2017-12-19 19:11:31
 */
public class ZhimaCustomerCertificationInitializeResponse extends AlipayResponse {

	private static final long serialVersionUID = 8156722385333165554L;

	/**
	 * 本次认证的唯一标识，商户需要记录，后续的操作都需要用到
	 */
	@ApiField("biz_no")
	private String bizNo;

	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}

	public String getBizNo() {
		return this.bizNo;
	}

}
