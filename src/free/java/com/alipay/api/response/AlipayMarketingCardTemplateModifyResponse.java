package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.marketing.card.template.modify response.
 *
 * @author auto create
 * @since 1.0, 2018-06-14 10:55:00
 */
public class AlipayMarketingCardTemplateModifyResponse extends AlipayResponse {

	private static final long serialVersionUID = 7384533923464153521L;

	/**
	 * 模板ID
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
