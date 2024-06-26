package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.boss.prod.arrangement.offline.query response.
 *
 * @author auto create
 * @since 1.0, 2017-04-14 21:06:47
 */
public class AlipayBossProdArrangementOfflineQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 8715159411125569392L;

	/**
	 * 商户的签约状态
	 */
	@ApiField("sign_status")
	private String signStatus;

	public void setSignStatus(String signStatus) {
		this.signStatus = signStatus;
	}

	public String getSignStatus() {
		return this.signStatus;
	}

}
