package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.CampDetail;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.marketing.campaign.activity.query response.
 *
 * @author auto create
 * @since 1.0, 2017-12-07 16:16:49
 */
public class KoubeiMarketingCampaignActivityQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 2578783895684333115L;

	/**
	 * 活动详情
	 */
	@ApiField("camp_detail")
	private CampDetail campDetail;

	public void setCampDetail(CampDetail campDetail) {
		this.campDetail = campDetail;
	}

	public CampDetail getCampDetail() {
		return this.campDetail;
	}

}
