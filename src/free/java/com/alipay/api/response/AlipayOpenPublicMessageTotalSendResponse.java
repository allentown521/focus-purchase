package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.open.public.message.total.send response.
 *
 * @author auto create
 * @since 1.0, 2018-01-22 10:33:37
 */
public class AlipayOpenPublicMessageTotalSendResponse extends AlipayResponse {

	private static final long serialVersionUID = 4575572993671936755L;

	/**
	 * 消息ID
	 */
	@ApiField("message_id")
	private String messageId;

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMessageId() {
		return this.messageId;
	}

}
