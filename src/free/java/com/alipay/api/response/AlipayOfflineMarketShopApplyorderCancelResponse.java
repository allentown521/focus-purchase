package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.offline.market.shop.applyorder.cancel response.
 *
 * @author auto create
 * @since 1.0, 2018-03-27 17:07:06
 */
public class AlipayOfflineMarketShopApplyorderCancelResponse extends AlipayResponse {

	private static final long serialVersionUID = 5859667875879591245L;

	/**
	 * 申请撤销成功接口同步返回的支付宝申请流水号。
	 */
	@ApiField("apply_id")
	private String applyId;

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getApplyId() {
		return this.applyId;
	}

}
