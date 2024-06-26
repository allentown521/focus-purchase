package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.IntelligentPromo;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.marketing.campaign.intelligent.promo.query response.
 *
 * @author auto create
 * @since 1.0, 2017-12-20 18:18:43
 */
public class KoubeiMarketingCampaignIntelligentPromoQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 5321647733929526341L;

	/**
	 * 查询返回的营销活动模型
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
