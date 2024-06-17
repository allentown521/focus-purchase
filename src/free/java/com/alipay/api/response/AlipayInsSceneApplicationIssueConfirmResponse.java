package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.ins.scene.application.issue.confirm response.
 *
 * @author auto create
 * @since 1.0, 2018-04-03 11:29:12
 */
public class AlipayInsSceneApplicationIssueConfirmResponse extends AlipayResponse {

	private static final long serialVersionUID = 8427841567284698679L;

	/**
	 * 投保订单号
	 */
	@ApiField("application_no")
	private String applicationNo;

	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public String getApplicationNo() {
		return this.applicationNo;
	}

}
