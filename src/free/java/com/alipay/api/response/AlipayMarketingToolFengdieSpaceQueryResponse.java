package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.FengdieSpaceDetailModel;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.tool.fengdie.space.query response.
 *
 * @author auto create
 * @since 1.0, 2018-04-26 10:14:41
 */
public class AlipayMarketingToolFengdieSpaceQueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 6515755618182384637L;

	/**
	 * 空间详情信息，比如空间名称、空间管理员等信息
	 */
	@ApiField("data")
	private FengdieSpaceDetailModel data;

	public void setData(FengdieSpaceDetailModel data) {
		this.data = data;
	}

	public FengdieSpaceDetailModel getData() {
		return this.data;
	}

}
