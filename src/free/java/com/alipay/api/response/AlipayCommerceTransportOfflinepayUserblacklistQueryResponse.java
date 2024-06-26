package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import java.util.List;

/**
 * ALIPAY API: alipay.commerce.transport.offlinepay.userblacklist.query response.
 *
 * @author auto create
 * @since 1.0, 2017-09-04 17:13:07
 */
public class AlipayCommerceTransportOfflinepayUserblacklistQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 3126988213767279259L;

	/**
	 * 黑名单用户ID
	 */
	@ApiListField("black_list")
	@ApiField("string")
	private List<String> blackList;

	public void setBlackList(List<String> blackList) {
		this.blackList = blackList;
	}

	public List<String> getBlackList() {
		return this.blackList;
	}

}
