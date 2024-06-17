package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.FengdieSuccessRespModel;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.tool.fengdie.sites.delete response.
 *
 * @author auto create
 * @since 1.0, 2018-04-26 10:13:20
 */
public class AlipayMarketingToolFengdieSitesDeleteResponse extends AlipayResponse {

	private static final long serialVersionUID = 7734117946739943772L;

	/**
	 * 返回删除云凤蝶站点成功与失败的结果
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
