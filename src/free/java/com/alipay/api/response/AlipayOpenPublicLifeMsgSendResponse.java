package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.open.public.life.msg.send response.
 *
 * @author auto create
 * @since 1.0, 2018-04-17 14:24:09
 */
public class AlipayOpenPublicLifeMsgSendResponse extends AlipayResponse {

	private static final long serialVersionUID = 6255441636725125181L;

	/**
	 * 生活号消息唯一标识
	 */
	@ApiField("alipay_msg_id")
	private String alipayMsgId;

	public void setAlipayMsgId(String alipayMsgId) {
		this.alipayMsgId = alipayMsgId;
	}

	public String getAlipayMsgId() {
		return this.alipayMsgId;
	}

}
