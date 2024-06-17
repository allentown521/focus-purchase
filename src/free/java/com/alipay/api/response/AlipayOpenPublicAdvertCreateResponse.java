package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.open.public.advert.create response.
 *
 * @author auto create
 * @since 1.0, 2018-04-09 11:00:00
 */
public class AlipayOpenPublicAdvertCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 1814482434151692931L;

	/**
	 * 广告位id
	 */
	@ApiField("advert_id")
	private String advertId;

	public void setAdvertId(String advertId) {
		this.advertId = advertId;
	}

	public String getAdvertId() {
		return this.advertId;
	}

}
