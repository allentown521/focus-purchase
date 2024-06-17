package com.alipay.api.response;

import com.alipay.api.AlipayResponse;
import com.alipay.api.internal.mapping.ApiField;

/**
 * ALIPAY API: alipay.commerce.lottery.present.send response.
 *
 * @author auto create
 * @since 1.0, 2018-03-30 14:30:00
 */
public class AlipayCommerceLotteryPresentSendResponse extends AlipayResponse {

	private static final long serialVersionUID = 1564724141631922539L;

	/**
	 * 是否赠送成功
	 */
	@ApiField("send_result")
	private Boolean sendResult;

	public void setSendResult(Boolean sendResult) {
		this.sendResult = sendResult;
	}

	public Boolean getSendResult() {
		return this.sendResult;
	}

}
