package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.ins.auto.autoinsprod.policy.cancel response.
 *
 * @author auto create
 * @since 1.0, 2017-12-13 11:31:43
 */
public class AlipayInsAutoAutoinsprodPolicyCancelResponse extends AlipayResponse {

	private static final long serialVersionUID = 7328292986531724284L;

	/**
	 * 操作结果 true/false
	 */
	@ApiField("cancel_result")
	private String cancelResult;

	public void setCancelResult(String cancelResult) {
		this.cancelResult = cancelResult;
	}

	public String getCancelResult() {
		return this.cancelResult;
	}

}
