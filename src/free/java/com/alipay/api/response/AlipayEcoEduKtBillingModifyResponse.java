package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.eco.edu.kt.billing.modify response.
 *
 * @author auto create
 * @since 1.0, 2017-11-06 11:48:51
 */
public class AlipayEcoEduKtBillingModifyResponse extends AlipayResponse {

	private static final long serialVersionUID = 1436378355358928773L;

	/**
	 * 如果成功，返回Y
	 */
	@ApiField("status")
	private String status;

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

}
