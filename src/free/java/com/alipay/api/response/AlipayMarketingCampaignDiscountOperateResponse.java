package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.campaign.discount.operate response.
 *
 * @author auto create
 * @since 1.0, 2017-03-03 16:48:01
 */
public class AlipayMarketingCampaignDiscountOperateResponse extends AlipayResponse {

	private static final long serialVersionUID = 3383496133728187342L;

	/**
	 * 123
	 */
	@ApiField("camp_id")
	private String campId;

	public void setCampId(String campId) {
		this.campId = campId;
	}

	public String getCampId() {
		return this.campId;
	}

}
