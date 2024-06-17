package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.IntelligentPromo;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.marketing.campaign.intelligent.promo.create response.
 *
 * @author auto create
 * @since 1.0, 2018-04-18 11:42:29
 */
public class KoubeiMarketingCampaignIntelligentPromoCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 5349531775452717744L;

	/**
	 * 智能营销活动信息
	 */
	@ApiField("promo")
	private IntelligentPromo promo;

	public void setPromo(IntelligentPromo promo) {
		this.promo = promo;
	}

	public IntelligentPromo getPromo() {
		return this.promo;
	}

}
