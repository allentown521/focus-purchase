package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: koubei.marketing.campaign.asset.detail.query response.
 *
 * @author auto create
 * @since 1.0, 2018-01-10 14:14:43
 */
public class KoubeiMarketingCampaignAssetDetailQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 6284977797392583638L;

	/**
	 * 适用门店:门店与门店之间用“,”隔开，适用门店的意思：就是该资产只能在返回的门店中核销该资产。
	 */
	@ApiField("limit_shops")
	private String limitShops;

	public void setLimitShops(String limitShops) {
		this.limitShops = limitShops;
	}

	public String getLimitShops() {
		return this.limitShops;
	}

}
