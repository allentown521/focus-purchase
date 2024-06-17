package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.security.prod.fingerprint.riskcontrol.query response.
 *
 * @author auto create
 * @since 1.0, 2017-11-28 17:49:30
 */
public class AlipaySecurityProdFingerprintRiskcontrolQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 7581665243251169447L;

	/**
	 * IFAA服务端查询结果，true为支持指纹功能，false为不支持
	 */
	@ApiField("check_result")
	private Boolean checkResult;

	public void setCheckResult(Boolean checkResult) {
		this.checkResult = checkResult;
	}

	public Boolean getCheckResult() {
		return this.checkResult;
	}

}
