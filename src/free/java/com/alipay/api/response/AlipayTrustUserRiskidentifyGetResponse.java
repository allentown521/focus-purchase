package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AliTrustRiskIdentify;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.trust.user.riskidentify.get response.
 *
 * @author auto create
 * @since 1.0, 2016-01-04 10:16:04
 */
public class AlipayTrustUserRiskidentifyGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 4157227123546696296L;

	/**
	 * 行业关注名单识别结果
	 */
	@ApiField("ali_trust_risk_identify")
	private AliTrustRiskIdentify aliTrustRiskIdentify;

	public void setAliTrustRiskIdentify(AliTrustRiskIdentify aliTrustRiskIdentify) {
		this.aliTrustRiskIdentify = aliTrustRiskIdentify;
	}

	public AliTrustRiskIdentify getAliTrustRiskIdentify() {
		return this.aliTrustRiskIdentify;
	}

}
