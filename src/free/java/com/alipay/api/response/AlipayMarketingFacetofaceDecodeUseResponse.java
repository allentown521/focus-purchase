package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.facetoface.decode.use response.
 *
 * @author auto create
 * @since 1.0, 2018-06-14 11:33:58
 */
public class AlipayMarketingFacetofaceDecodeUseResponse extends AlipayResponse {

	private static final long serialVersionUID = 6698461412734437129L;

	/**
	 * 用户userId
	 */
	@ApiField("user_id")
	private String userId;

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

}
