package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.cdp.advertise.create response.
 *
 * @author auto create
 * @since 1.0, 2017-12-29 12:01:26
 */
public class AlipayMarketingCdpAdvertiseCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 2386789554785171326L;

	/**
	 * 创建广告唯一标识
	 */
	@ApiField("ad_id")
	private String adId;

	public void setAdId(String adId) {
		this.adId = adId;
	}

	public String getAdId() {
		return this.adId;
	}

}
