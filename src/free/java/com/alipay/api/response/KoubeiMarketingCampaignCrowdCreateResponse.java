package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.marketing.campaign.crowd.create response.
 *
 * @author auto create
 * @since 1.0, 2018-04-25 17:16:38
 */
public class KoubeiMarketingCampaignCrowdCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 8691155843315498239L;

	/**
	 * 返回的人群组的唯一标识
	 */
	@ApiField("crowd_group_id")
	private String crowdGroupId;

	public void setCrowdGroupId(String crowdGroupId) {
		this.crowdGroupId = crowdGroupId;
	}

	public String getCrowdGroupId() {
		return this.crowdGroupId;
	}

}
