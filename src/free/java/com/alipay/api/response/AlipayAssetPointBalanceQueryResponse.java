package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.asset.point.balance.query response.
 *
 * @author auto create
 * @since 1.0, 2017-04-14 19:00:47
 */
public class AlipayAssetPointBalanceQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 4411953983641648847L;

	/**
	 * 用户的集分宝余额
	 */
	@ApiField("point_amount")
	private Long pointAmount;

	public void setPointAmount(Long pointAmount) {
		this.pointAmount = pointAmount;
	}

	public Long getPointAmount() {
		return this.pointAmount;
	}

}
