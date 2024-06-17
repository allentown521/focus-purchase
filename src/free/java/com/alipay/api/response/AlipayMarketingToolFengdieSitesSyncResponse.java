package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.FengdieSuccessRespModel;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.tool.fengdie.sites.sync response.
 *
 * @author auto create
 * @since 1.0, 2018-04-26 10:14:05
 */
public class AlipayMarketingToolFengdieSitesSyncResponse extends AlipayResponse {

	private static final long serialVersionUID = 5347755121347965521L;

	/**
	 * 返回站点升级是否成功
	 */
	@ApiField("data")
	private FengdieSuccessRespModel data;

	public void setData(FengdieSuccessRespModel data) {
		this.data = data;
	}

	public FengdieSuccessRespModel getData() {
		return this.data;
	}

}
