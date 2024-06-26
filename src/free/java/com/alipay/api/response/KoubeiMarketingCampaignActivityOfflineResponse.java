package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.marketing.campaign.activity.offline response.
 *
 * @author auto create
 * @since 1.0, 2017-12-07 20:12:57
 */
public class KoubeiMarketingCampaignActivityOfflineResponse extends AlipayResponse {

	private static final long serialVersionUID = 4162681517561827367L;

	/**
	 * 活动子状态，如审核中
	 */
	@ApiField("audit_status")
	private String auditStatus;

	/**
	 * 活动状态
	 */
	@ApiField("camp_status")
	private String campStatus;

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getAuditStatus() {
		return this.auditStatus;
	}

	public void setCampStatus(String campStatus) {
		this.campStatus = campStatus;
	}

	public String getCampStatus() {
		return this.campStatus;
	}

}
