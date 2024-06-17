package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.FengdieTemplateListRespModel;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.tool.fengdie.template.batchquery response.
 *
 * @author auto create
 * @since 1.0, 2018-04-26 10:14:34
 */
public class AlipayMarketingToolFengdieTemplateBatchqueryResponse extends AlipayResponse {

	private static final long serialVersionUID = 4675192866936254787L;

	/**
	 * 模板详情列表
	 */
	@ApiField("data")
	private FengdieTemplateListRespModel data;

	public void setData(FengdieTemplateListRespModel data) {
		this.data = data;
	}

	public FengdieTemplateListRespModel getData() {
		return this.data;
	}

}
