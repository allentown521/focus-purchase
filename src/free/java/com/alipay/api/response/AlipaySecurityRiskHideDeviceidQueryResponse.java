package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.security.risk.hide.deviceid.query response.
 *
 * @author auto create
 * @since 1.0, 2016-06-17 15:05:08
 */
public class AlipaySecurityRiskHideDeviceidQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 3125251447686698539L;

	/**
	 * 设备指纹的apdid
	 */
	@ApiField("deviceid")
	private String deviceid;

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getDeviceid() {
		return this.deviceid;
	}

}
