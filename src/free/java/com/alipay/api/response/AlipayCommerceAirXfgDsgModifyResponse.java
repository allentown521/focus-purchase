package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.commerce.air.xfg.dsg.modify response.
 *
 * @author auto create
 * @since 1.0, 2018-01-18 15:28:48
 */
public class AlipayCommerceAirXfgDsgModifyResponse extends AlipayResponse {

	private static final long serialVersionUID = 8118199253534359367L;

	/**
	 * 用户级别
	 */
	@ApiField("level")
	private String level;

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLevel() {
		return this.level;
	}

}
