package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.FengdieSuccessRespModel;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.tool.fengdie.template.send response.
 *
 * @author auto create
 * @since 1.0, 2018-04-26 10:13:13
 */
public class AlipayMarketingToolFengdieTemplateSendResponse extends AlipayResponse {

	private static final long serialVersionUID = 2728694475423174157L;

	/**
	 * 分配模板的操作是否成功
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
