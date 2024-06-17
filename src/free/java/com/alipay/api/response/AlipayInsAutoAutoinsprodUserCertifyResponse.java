package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.ins.auto.autoinsprod.user.certify response.
 *
 * @author auto create
 * @since 1.0, 2017-12-13 11:31:13
 */
public class AlipayInsAutoAutoinsprodUserCertifyResponse extends AlipayResponse {

	private static final long serialVersionUID = 7872293854117317261L;

	/**
	 * 验证结果
	 */
	@ApiField("agent_cert_result")
	private String agentCertResult;

	public void setAgentCertResult(String agentCertResult) {
		this.agentCertResult = agentCertResult;
	}

	public String getAgentCertResult() {
		return this.agentCertResult;
	}

}
