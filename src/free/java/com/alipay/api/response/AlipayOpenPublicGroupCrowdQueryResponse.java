package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.open.public.group.crowd.query response.
 *
 * @author auto create
 * @since 1.0, 2018-05-11 19:06:43
 */
public class AlipayOpenPublicGroupCrowdQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 2465483269138926419L;

	/**
	 * 分组圈出的人群数量
	 */
	@ApiField("count")
	private String count;

	public void setCount(String count) {
		this.count = count;
	}

	public String getCount() {
		return this.count;
	}

}
