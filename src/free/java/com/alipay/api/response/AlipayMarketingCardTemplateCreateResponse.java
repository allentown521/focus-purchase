package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.card.template.create response.
 *
 * @author auto create
 * @since 1.0, 2018-06-14 10:45:00
 */
public class AlipayMarketingCardTemplateCreateResponse extends AlipayResponse {

	private static final long serialVersionUID = 2678324273346224415L;

	/**
	 * 支付宝卡模板ID
	 */
	@ApiField("template_id")
	private String templateId;

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateId() {
		return this.templateId;
	}

}
