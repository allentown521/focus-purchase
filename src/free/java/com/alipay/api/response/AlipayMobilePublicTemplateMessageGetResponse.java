package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.mobile.public.template.message.get response.
 *
 * @author auto create
 * @since 1.0, 2017-08-02 17:37:08
 */
public class AlipayMobilePublicTemplateMessageGetResponse extends AlipayResponse {

	private static final long serialVersionUID = 7513461697873284569L;

	/**
	 * 消息模板id--商户领取母版后生成的唯一模板id
	 */
	@ApiField("msg_template_id")
	private String msgTemplateId;

	/**
	 * 模板内容
	 */
	@ApiField("template")
	private String template;

	public void setMsgTemplateId(String msgTemplateId) {
		this.msgTemplateId = msgTemplateId;
	}

	public String getMsgTemplateId() {
		return this.msgTemplateId;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getTemplate() {
		return this.template;
	}

}
