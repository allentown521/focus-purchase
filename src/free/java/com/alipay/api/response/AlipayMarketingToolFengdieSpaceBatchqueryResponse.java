package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.FengdieSpaceListRespModel;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.tool.fengdie.space.batchquery response.
 *
 * @author auto create
 * @since 1.0, 2018-04-26 10:14:27
 */
public class AlipayMarketingToolFengdieSpaceBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 2483144353986987861L;

	/**
	 * 云凤蝶空间列表查询接口返回值，包含分页信息，空间信息的列表。
	 */
	@ApiField("data")
	private FengdieSpaceListRespModel data;

	public void setData(FengdieSpaceListRespModel data) {
		this.data = data;
	}

	public FengdieSpaceListRespModel getData() {
		return this.data;
	}

}
