package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.IntelligentPromo;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.marketing.campaign.intelligent.promo.modify response.
 *
 * @author auto create
 * @since 1.0, 2017-11-22 18:57:28
 */
public class KoubeiMarketingCampaignIntelligentPromoModifyResponse extends AlipayResponse {

	private static final long serialVersionUID = 4549688311948482893L;

	/**
	 * 修改后返回的智能活动模型
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
